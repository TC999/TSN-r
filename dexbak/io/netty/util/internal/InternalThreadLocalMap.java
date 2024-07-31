package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    public static final Object UNSET = new Object();
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    public long rp9;

    private InternalThreadLocalMap() {
        super(newIndexedVariableTable());
    }

    public static void destroy() {
        UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
    }

    private void expandIndexedVariableTableAndSet(int i, Object obj) {
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        int i2 = (i >>> 1) | i;
        int i3 = i2 | (i2 >>> 2);
        int i4 = i3 | (i3 >>> 4);
        int i5 = i4 | (i4 >>> 8);
        Object[] copyOf = Arrays.copyOf(objArr, (i5 | (i5 >>> 16)) + 1);
        Arrays.fill(copyOf, length, copyOf.length, UNSET);
        copyOf[i] = obj;
        this.indexedVariables = copyOf;
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread) {
        InternalThreadLocalMap threadLocalMap = fastThreadLocalThread.threadLocalMap();
        if (threadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
            fastThreadLocalThread.setThreadLocalMap(internalThreadLocalMap);
            return internalThreadLocalMap;
        }
        return threadLocalMap;
    }

    public static InternalThreadLocalMap get() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) currentThread);
        }
        return slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            return ((FastThreadLocalThread) currentThread).threadLocalMap();
        }
        return UnpaddedInternalThreadLocalMap.slowThreadLocalMap.get();
    }

    public static int lastVariableIndex() {
        return UnpaddedInternalThreadLocalMap.nextIndex.get() - 1;
    }

    private static Object[] newIndexedVariableTable() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, UNSET);
        return objArr;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger = UnpaddedInternalThreadLocalMap.nextIndex;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement >= 0) {
            return andIncrement;
        }
        atomicInteger.decrementAndGet();
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    public static void remove() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) currentThread).setThreadLocalMap(null);
        } else {
            UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
        }
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal<InternalThreadLocalMap> threadLocal = UnpaddedInternalThreadLocalMap.slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap = threadLocal.get();
        if (internalThreadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap2 = new InternalThreadLocalMap();
            threadLocal.set(internalThreadLocalMap2);
            return internalThreadLocalMap2;
        }
        return internalThreadLocalMap;
    }

    public <E> ArrayList<E> arrayList() {
        return arrayList(8);
    }

    public Map<Charset, CharsetDecoder> charsetDecoderCache() {
        Map<Charset, CharsetDecoder> map = this.charsetDecoderCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.charsetDecoderCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> map = this.charsetEncoderCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.charsetEncoderCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public IntegerHolder counterHashCode() {
        return this.counterHashCode;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> map = this.handlerSharableCache;
        if (map == null) {
            WeakHashMap weakHashMap = new WeakHashMap(4);
            this.handlerSharableCache = weakHashMap;
            return weakHashMap;
        }
        return map;
    }

    public Object indexedVariable(int i) {
        Object[] objArr = this.indexedVariables;
        return i < objArr.length ? objArr[i] : UNSET;
    }

    public boolean isIndexedVariableSet(int i) {
        Object[] objArr = this.indexedVariables;
        return i < objArr.length && objArr[i] != UNSET;
    }

    public int localChannelReaderStackDepth() {
        return this.localChannelReaderStackDepth;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom = this.random;
        if (threadLocalRandom == null) {
            ThreadLocalRandom threadLocalRandom2 = new ThreadLocalRandom();
            this.random = threadLocalRandom2;
            return threadLocalRandom2;
        }
        return threadLocalRandom;
    }

    public Object removeIndexedVariable(int i) {
        Object[] objArr = this.indexedVariables;
        if (i < objArr.length) {
            Object obj = objArr[i];
            objArr[i] = UNSET;
            return obj;
        }
        return UNSET;
    }

    public void setCounterHashCode(IntegerHolder integerHolder) {
        this.counterHashCode = integerHolder;
    }

    public void setFutureListenerStackDepth(int i) {
        this.futureListenerStackDepth = i;
    }

    public boolean setIndexedVariable(int i, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i < objArr.length) {
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2 == UNSET;
        }
        expandIndexedVariableTableAndSet(i, obj);
        return true;
    }

    public void setLocalChannelReaderStackDepth(int i) {
        this.localChannelReaderStackDepth = i;
    }

    public int size() {
        int i = this.futureListenerStackDepth != 0 ? 1 : 0;
        if (this.localChannelReaderStackDepth != 0) {
            i++;
        }
        if (this.handlerSharableCache != null) {
            i++;
        }
        if (this.counterHashCode != null) {
            i++;
        }
        if (this.random != null) {
            i++;
        }
        if (this.typeParameterMatcherGetCache != null) {
            i++;
        }
        if (this.typeParameterMatcherFindCache != null) {
            i++;
        }
        if (this.stringBuilder != null) {
            i++;
        }
        if (this.charsetEncoderCache != null) {
            i++;
        }
        if (this.charsetDecoderCache != null) {
            i++;
        }
        if (this.arrayList != null) {
            i++;
        }
        for (Object obj : this.indexedVariables) {
            if (obj != UNSET) {
                i++;
            }
        }
        return i - 1;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(512);
            this.stringBuilder = sb2;
            return sb2;
        }
        sb.setLength(0);
        return sb;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> map = this.typeParameterMatcherFindCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.typeParameterMatcherFindCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> map = this.typeParameterMatcherGetCache;
        if (map == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            this.typeParameterMatcherGetCache = identityHashMap;
            return identityHashMap;
        }
        return map;
    }

    public <E> ArrayList<E> arrayList(int i) {
        ArrayList<E> arrayList = (ArrayList<E>) this.arrayList;
        if (arrayList == null) {
            return new ArrayList<>(i);
        }
        arrayList.clear();
        arrayList.ensureCapacity(i);
        return arrayList;
    }
}
