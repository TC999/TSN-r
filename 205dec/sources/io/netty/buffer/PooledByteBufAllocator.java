package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_TINY_CACHE_SIZE;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final int tinyCacheSize;

    /* renamed from: io.netty.buffer.PooledByteBufAllocator$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PooledByteBufAllocator.this.trimCurrentThreadCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        PoolThreadLocalCache() {
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            for (int i4 = 1; i4 < poolArenaArr.length; i4++) {
                PoolArena<T> poolArena2 = poolArenaArr[i4];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            return new PoolThreadCache(leastUsedArena(PooledByteBufAllocator.this.heapArenas), leastUsedArena(PooledByteBufAllocator.this.directArenas), PooledByteBufAllocator.this.tinyCacheSize, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free();
        }
    }

    static {
        Object obj;
        int i4 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i4);
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i4 = 8192;
        }
        DEFAULT_PAGE_SIZE = i4;
        int i5 = 11;
        int i6 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 11);
        try {
            validateAndCalculateChunkSize(i4, i6);
            i5 = i6;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i5;
        Runtime runtime = Runtime.getRuntime();
        int i7 = DEFAULT_PAGE_SIZE;
        long availableProcessors = runtime.availableProcessors() * 2;
        long j4 = i7 << i5;
        int max = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(availableProcessors, ((runtime.maxMemory() / j4) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = max;
        int max2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(availableProcessors, ((PlatformDependent.maxDirectMemory() / j4) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = max2;
        int i8 = SystemPropertyUtil.getInt("io.netty.allocator.tinyCacheSize", 512);
        DEFAULT_TINY_CACHE_SIZE = i8;
        int i9 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i9;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i10;
        int i11 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i11;
        int i12 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i12;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(max));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(max2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i7));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i7), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i5));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i5), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i7 << i5));
            internalLogger.debug("-Dio.netty.allocator.tinyCacheSize: {}", Integer.valueOf(i8));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i9));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i10));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i11));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i12));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultTinyCacheSize() {
        return DEFAULT_TINY_CACHE_SIZE;
    }

    private static <T> PoolArena<T>[] newArenaArray(int i4) {
        return new PoolArena[i4];
    }

    private static int validateAndCalculateChunkSize(int i4, int i5) {
        if (i5 > 14) {
            throw new IllegalArgumentException("maxOrder: " + i5 + " (expected: 0-14)");
        }
        int i6 = i4;
        for (int i7 = i5; i7 > 0; i7--) {
            if (i6 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i4), Integer.valueOf(i5), 1073741824));
            }
            i6 <<= 1;
        }
        return i6;
    }

    private static int validateAndCalculatePageShifts(int i4) {
        if (i4 >= 4096) {
            if (((i4 - 1) & i4) == 0) {
                return 31 - Integer.numberOfLeadingZeros(i4);
            }
            throw new IllegalArgumentException("pageSize: " + i4 + " (expected: power of 2)");
        }
        throw new IllegalArgumentException("pageSize: " + i4 + " (expected: 4096)");
    }

    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] poolArenaArr = this.heapArenas;
        int length = poolArenaArr == null ? 0 : poolArenaArr.length;
        StringBuilder sb = new StringBuilder(512);
        sb.append(length);
        sb.append(" heap arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length > 0) {
            for (PoolArena<byte[]> poolArena : this.heapArenas) {
                sb.append(poolArena);
            }
        }
        PoolArena<ByteBuffer>[] poolArenaArr2 = this.directArenas;
        int length2 = poolArenaArr2 == null ? 0 : poolArenaArr2.length;
        sb.append(length2);
        sb.append(" direct arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length2 > 0) {
            for (PoolArena<ByteBuffer> poolArena2 : this.directArenas) {
                sb.append(poolArena2);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i4, int i5) {
        ByteBuf unpooledDirectByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        if (poolArena != null) {
            unpooledDirectByteBuf = poolArena.allocate(poolThreadCache, i4, i5);
        } else if (PlatformDependent.hasUnsafe()) {
            unpooledDirectByteBuf = UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i4, i5);
        } else {
            unpooledDirectByteBuf = new UnpooledDirectByteBuf(this, i4, i5);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i4, int i5) {
        AbstractByteBuf unpooledHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledHeapByteBuf = poolArena.allocate(poolThreadCache, i4, i5);
        } else {
            unpooledHeapByteBuf = new UnpooledHeapByteBuf(this, i4, i5);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledHeapByteBuf);
    }

    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i4 = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i4 += poolArena.numThreadCaches.get();
        }
        return i4;
    }

    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    public int tinyCacheSize() {
        return this.tinyCacheSize;
    }

    public PooledByteBufAllocator(boolean z3) {
        this(z3, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public PooledByteBufAllocator(int i4, int i5, int i6, int i7) {
        this(false, i4, i5, i6, i7);
    }

    public PooledByteBufAllocator(boolean z3, int i4, int i5, int i6, int i7) {
        this(z3, i4, i5, i6, i7, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    public PooledByteBufAllocator(boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(z3);
        this.threadCache = new PoolThreadLocalCache();
        this.tinyCacheSize = i8;
        this.smallCacheSize = i9;
        this.normalCacheSize = i10;
        int validateAndCalculateChunkSize = validateAndCalculateChunkSize(i6, i7);
        if (i4 < 0) {
            throw new IllegalArgumentException("nHeapArena: " + i4 + " (expected: >= 0)");
        } else if (i5 >= 0) {
            int validateAndCalculatePageShifts = validateAndCalculatePageShifts(i6);
            if (i4 > 0) {
                PoolArena<byte[]>[] newArenaArray = newArenaArray(i4);
                this.heapArenas = newArenaArray;
                ArrayList arrayList = new ArrayList(newArenaArray.length);
                for (int i11 = 0; i11 < this.heapArenas.length; i11++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i6, i7, validateAndCalculatePageShifts, validateAndCalculateChunkSize);
                    this.heapArenas[i11] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.emptyList();
            }
            if (i5 > 0) {
                PoolArena<ByteBuffer>[] newArenaArray2 = newArenaArray(i5);
                this.directArenas = newArenaArray2;
                ArrayList arrayList2 = new ArrayList(newArenaArray2.length);
                for (int i12 = 0; i12 < this.directArenas.length; i12++) {
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i6, i7, validateAndCalculatePageShifts, validateAndCalculateChunkSize);
                    this.directArenas[i12] = directArena;
                    arrayList2.add(directArena);
                }
                this.directArenaMetrics = Collections.unmodifiableList(arrayList2);
                return;
            }
            this.directArenas = null;
            this.directArenaMetrics = Collections.emptyList();
        } else {
            throw new IllegalArgumentException("nDirectArea: " + i5 + " (expected: >= 0)");
        }
    }
}
