package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set newSetFromMap;
        int i4 = variablesToRemoveIndex;
        Object indexedVariable = internalThreadLocalMap.indexedVariable(i4);
        if (indexedVariable != InternalThreadLocalMap.UNSET && indexedVariable != null) {
            newSetFromMap = (Set) indexedVariable;
        } else {
            newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i4, newSetFromMap);
        }
        newSetFromMap.add(fastThreadLocal);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V v3;
        try {
            v3 = initialValue();
        } catch (Exception e4) {
            PlatformDependent.throwException(e4);
            v3 = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, v3);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return v3;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object indexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
            if (indexedVariable != null && indexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) indexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object indexedVariable = internalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (indexedVariable == InternalThreadLocalMap.UNSET || indexedVariable == null) {
            return;
        }
        ((Set) indexedVariable).remove(fastThreadLocal);
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v3) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v3)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v3 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v3 != InternalThreadLocalMap.UNSET ? v3 : initialize(internalThreadLocalMap);
    }

    public final V getIfExists() {
        V v3;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null || (v3 = (V) ifSet.indexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return null;
        }
        return v3;
    }

    protected V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    protected void onRemoval(V v3) throws Exception {
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v3) {
        if (v3 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v3);
        } else {
            remove();
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) {
        if (internalThreadLocalMap == null) {
            return;
        }
        Object removeIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index);
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        if (removeIndexedVariable != InternalThreadLocalMap.UNSET) {
            try {
                onRemoval(removeIndexedVariable);
            } catch (Exception e4) {
                PlatformDependent.throwException(e4);
            }
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v3 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v3 != InternalThreadLocalMap.UNSET ? v3 : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v3) {
        if (v3 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v3);
        } else {
            remove(internalThreadLocalMap);
        }
    }
}
