package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET;
    private static final InternalLogger logger;
    private BitSet cleanerFlags;
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    public long rp9;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(InternalThreadLocalMap.class);
        logger = internalLoggerFactory;
        UNSET = new Object();
        int i4 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
        STRING_BUILDER_INITIAL_SIZE = i4;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(i4));
        int i5 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
        STRING_BUILDER_MAX_SIZE = i5;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(i5));
    }

    private InternalThreadLocalMap() {
        super(newIndexedVariableTable());
    }

    public static void destroy() {
        UnpaddedInternalThreadLocalMap.slowThreadLocalMap.remove();
    }

    private void expandIndexedVariableTableAndSet(int i4, Object obj) {
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        int i5 = (i4 >>> 1) | i4;
        int i6 = i5 | (i5 >>> 2);
        int i7 = i6 | (i6 >>> 4);
        int i8 = i7 | (i7 >>> 8);
        Object[] copyOf = Arrays.copyOf(objArr, (i8 | (i8 >>> 16)) + 1);
        Arrays.fill(copyOf, length, copyOf.length, UNSET);
        copyOf[i4] = obj;
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

    @Deprecated
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

    public Object indexedVariable(int i4) {
        Object[] objArr = this.indexedVariables;
        return i4 < objArr.length ? objArr[i4] : UNSET;
    }

    public boolean isCleanerFlagSet(int i4) {
        BitSet bitSet = this.cleanerFlags;
        return bitSet != null && bitSet.get(i4);
    }

    public boolean isIndexedVariableSet(int i4) {
        Object[] objArr = this.indexedVariables;
        return i4 < objArr.length && objArr[i4] != UNSET;
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

    public Object removeIndexedVariable(int i4) {
        Object[] objArr = this.indexedVariables;
        if (i4 < objArr.length) {
            Object obj = objArr[i4];
            objArr[i4] = UNSET;
            return obj;
        }
        return UNSET;
    }

    public void setCleanerFlag(int i4) {
        if (this.cleanerFlags == null) {
            this.cleanerFlags = new BitSet();
        }
        this.cleanerFlags.set(i4);
    }

    @Deprecated
    public void setCounterHashCode(IntegerHolder integerHolder) {
        this.counterHashCode = integerHolder;
    }

    public void setFutureListenerStackDepth(int i4) {
        this.futureListenerStackDepth = i4;
    }

    public boolean setIndexedVariable(int i4, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i4 < objArr.length) {
            Object obj2 = objArr[i4];
            objArr[i4] = obj;
            return obj2 == UNSET;
        }
        expandIndexedVariableTableAndSet(i4, obj);
        return true;
    }

    public void setLocalChannelReaderStackDepth(int i4) {
        this.localChannelReaderStackDepth = i4;
    }

    public int size() {
        int i4 = this.futureListenerStackDepth != 0 ? 1 : 0;
        if (this.localChannelReaderStackDepth != 0) {
            i4++;
        }
        if (this.handlerSharableCache != null) {
            i4++;
        }
        if (this.counterHashCode != null) {
            i4++;
        }
        if (this.random != null) {
            i4++;
        }
        if (this.typeParameterMatcherGetCache != null) {
            i4++;
        }
        if (this.typeParameterMatcherFindCache != null) {
            i4++;
        }
        if (this.stringBuilder != null) {
            i4++;
        }
        if (this.charsetEncoderCache != null) {
            i4++;
        }
        if (this.charsetDecoderCache != null) {
            i4++;
        }
        if (this.arrayList != null) {
            i4++;
        }
        for (Object obj : this.indexedVariables) {
            if (obj != UNSET) {
                i4++;
            }
        }
        return i4 - 1;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb2;
            return sb2;
        }
        if (sb.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb.trimToSize();
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

    public <E> ArrayList<E> arrayList(int i4) {
        ArrayList<E> arrayList = (ArrayList<E>) this.arrayList;
        if (arrayList == null) {
            ArrayList<E> arrayList2 = new ArrayList<>(i4);
            this.arrayList = arrayList2;
            return arrayList2;
        }
        arrayList.clear();
        arrayList.ensureCapacity(i4);
        return arrayList;
    }
}
