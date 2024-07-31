package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set newSetFromMap;
        int i = variablesToRemoveIndex;
        Object indexedVariable = internalThreadLocalMap.indexedVariable(i);
        if (indexedVariable != InternalThreadLocalMap.UNSET && indexedVariable != null) {
            newSetFromMap = (Set) indexedVariable;
        } else {
            newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i, newSetFromMap);
        }
        newSetFromMap.add(fastThreadLocal);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V v;
        try {
            v = initialValue();
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            v = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, v);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return v;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object indexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
            if (indexedVariable != null && indexedVariable != InternalThreadLocalMap.UNSET) {
                Set set = (Set) indexedVariable;
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) set.toArray(new FastThreadLocal[set.size()])) {
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

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V get() {
        return get(InternalThreadLocalMap.get());
    }

    protected V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    protected void onRemoval(V v) throws Exception {
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v) {
        if (v != InternalThreadLocalMap.UNSET) {
            set(InternalThreadLocalMap.get(), v);
        } else {
            remove();
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v != InternalThreadLocalMap.UNSET ? v : initialize(internalThreadLocalMap);
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
            } catch (Exception e) {
                PlatformDependent.throwException(e);
            }
        }
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v) {
        if (v != InternalThreadLocalMap.UNSET) {
            if (internalThreadLocalMap.setIndexedVariable(this.index, v)) {
                addToVariablesToRemove(internalThreadLocalMap, this);
                return;
            }
            return;
        }
        remove(internalThreadLocalMap);
    }
}
