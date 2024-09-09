package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.Recycler;
import io.netty.util.ThreadDeathWatcher;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PoolThreadCache {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PoolThreadCache.class);
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final int freeSweepAllocationThreshold;
    private final Runnable freeTask;
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final int numShiftsNormalDirect;
    private final int numShiftsNormalHeap;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final Thread thread;
    private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolThreadCache$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[PoolArena.SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[PoolArena.SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class MemoryRegionCache<T> {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public Entry newObject(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1;
            final Recycler.Handle<Entry<?>> recyclerHandle;

            Entry(Recycler.Handle<Entry<?>> handle) {
                this.recyclerHandle = handle;
            }

            void recycle() {
                this.chunk = null;
                this.handle = -1L;
                this.recyclerHandle.recycle(this);
            }
        }

        MemoryRegionCache(int i4, PoolArena.SizeClass sizeClass) {
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i4);
            this.size = safeFindNextPositivePowerOfTwo;
            this.queue = PlatformDependent.newFixedMpscQueue(safeFindNextPositivePowerOfTwo);
            this.sizeClass = sizeClass;
        }

        private void freeEntry(Entry entry) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j4 = entry.handle;
            entry.recycle();
            poolChunk.arena.freeChunk(poolChunk, j4, this.sizeClass);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, long j4) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.handle = j4;
            return entry;
        }

        public final boolean add(PoolChunk<T> poolChunk, long j4) {
            Entry<T> newEntry = newEntry(poolChunk, j4);
            boolean offer = this.queue.offer(newEntry);
            if (!offer) {
                newEntry.recycle();
            }
            return offer;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i4) {
            Entry<T> poll = this.queue.poll();
            if (poll == null) {
                return false;
            }
            initBuf(poll.chunk, poll.handle, pooledByteBuf, i4);
            poll.recycle();
            this.allocations++;
            return true;
        }

        public final int free() {
            return free(Integer.MAX_VALUE);
        }

        protected abstract void initBuf(PoolChunk<T> poolChunk, long j4, PooledByteBuf<T> pooledByteBuf, int i4);

        public final void trim() {
            int i4 = this.size - this.allocations;
            this.allocations = 0;
            if (i4 > 0) {
                free(i4);
            }
        }

        private int free(int i4) {
            int i5 = 0;
            while (i5 < i4) {
                Entry<T> poll = this.queue.poll();
                if (poll == null) {
                    break;
                }
                freeEntry(poll);
                i5++;
            }
            return i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        NormalMemoryRegionCache(int i4) {
            super(i4, PoolArena.SizeClass.Normal);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, long j4, PooledByteBuf<T> pooledByteBuf, int i4) {
            poolChunk.initBuf(pooledByteBuf, j4, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        SubPageMemoryRegionCache(int i4, PoolArena.SizeClass sizeClass) {
            super(i4, sizeClass);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, long j4, PooledByteBuf<T> pooledByteBuf, int i4) {
            poolChunk.initBufWithSubpage(pooledByteBuf, j4, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i4, int i5, int i6, int i7, int i8) {
        Thread currentThread = Thread.currentThread();
        this.thread = currentThread;
        Runnable runnable = new Runnable() { // from class: io.netty.buffer.PoolThreadCache.1
            @Override // java.lang.Runnable
            public void run() {
                PoolThreadCache.this.free0();
            }
        };
        this.freeTask = runnable;
        if (i7 < 0) {
            throw new IllegalArgumentException("maxCachedBufferCapacity: " + i7 + " (expected: >= 0)");
        } else if (i8 >= 1) {
            this.freeSweepAllocationThreshold = i8;
            this.heapArena = poolArena;
            this.directArena = poolArena2;
            if (poolArena2 != null) {
                this.tinySubPageDirectCaches = createSubPageCaches(i4, 32, PoolArena.SizeClass.Tiny);
                this.smallSubPageDirectCaches = createSubPageCaches(i5, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
                this.numShiftsNormalDirect = log2(poolArena2.pageSize);
                this.normalDirectCaches = createNormalCaches(i6, i7, poolArena2);
                poolArena2.numThreadCaches.getAndIncrement();
            } else {
                this.tinySubPageDirectCaches = null;
                this.smallSubPageDirectCaches = null;
                this.normalDirectCaches = null;
                this.numShiftsNormalDirect = -1;
            }
            if (poolArena != null) {
                this.tinySubPageHeapCaches = createSubPageCaches(i4, 32, PoolArena.SizeClass.Tiny);
                this.smallSubPageHeapCaches = createSubPageCaches(i5, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
                this.numShiftsNormalHeap = log2(poolArena.pageSize);
                this.normalHeapCaches = createNormalCaches(i6, i7, poolArena);
                poolArena.numThreadCaches.getAndIncrement();
            } else {
                this.tinySubPageHeapCaches = null;
                this.smallSubPageHeapCaches = null;
                this.normalHeapCaches = null;
                this.numShiftsNormalHeap = -1;
            }
            ThreadDeathWatcher.watch(currentThread, runnable);
        } else {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i8 + " (expected: > 0)");
        }
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i4) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean allocate = memoryRegionCache.allocate(pooledByteBuf, i4);
        int i5 = this.allocations + 1;
        this.allocations = i5;
        if (i5 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return allocate;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i4, PoolArena.SizeClass sizeClass) {
        int i5 = AnonymousClass2.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return cacheForTiny(poolArena, i4);
                }
                throw new Error();
            }
            return cacheForSmall(poolArena, i4);
        }
        return cacheForNormal(poolArena, i4);
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i4) {
        if (poolArena.isDirect()) {
            return cache(this.normalDirectCaches, log2(i4 >> this.numShiftsNormalDirect));
        }
        return cache(this.normalHeapCaches, log2(i4 >> this.numShiftsNormalHeap));
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i4) {
        int smallIdx = PoolArena.smallIdx(i4);
        if (poolArena.isDirect()) {
            return cache(this.smallSubPageDirectCaches, smallIdx);
        }
        return cache(this.smallSubPageHeapCaches, smallIdx);
    }

    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int i4) {
        int tinyIdx = PoolArena.tinyIdx(i4);
        if (poolArena.isDirect()) {
            return cache(this.tinySubPageDirectCaches, tinyIdx);
        }
        return cache(this.tinySubPageHeapCaches, tinyIdx);
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i4, int i5, PoolArena<T> poolArena) {
        if (i4 > 0) {
            int max = Math.max(1, log2(Math.min(poolArena.chunkSize, i5) / poolArena.pageSize) + 1);
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[max];
            for (int i6 = 0; i6 < max; i6++) {
                memoryRegionCacheArr[i6] = new NormalMemoryRegionCache(i4);
            }
            return memoryRegionCacheArr;
        }
        return null;
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i4, int i5, PoolArena.SizeClass sizeClass) {
        if (i4 > 0) {
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                memoryRegionCacheArr[i6] = new SubPageMemoryRegionCache(i4, sizeClass);
            }
            return memoryRegionCacheArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void free0() {
        int free = free(this.tinySubPageDirectCaches) + free(this.smallSubPageDirectCaches) + free(this.normalDirectCaches) + free((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches) + free((MemoryRegionCache<?>[]) this.normalHeapCaches);
        if (free > 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(free), this.thread.getName());
            }
        }
        PoolArena<ByteBuffer> poolArena = this.directArena;
        if (poolArena != null) {
            poolArena.numThreadCaches.getAndDecrement();
        }
        PoolArena<byte[]> poolArena2 = this.heapArena;
        if (poolArena2 != null) {
            poolArena2.numThreadCaches.getAndDecrement();
        }
    }

    private static int log2(int i4) {
        int i5 = 0;
        while (i4 > 1) {
            i4 >>= 1;
            i5++;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, long j4, int i4, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> cache = cache(poolArena, i4, sizeClass);
        if (cache == null) {
            return false;
        }
        return cache.add(poolChunk, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i4, int i5) {
        return allocate(cacheForNormal(poolArena, i5), pooledByteBuf, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i4, int i5) {
        return allocate(cacheForSmall(poolArena, i5), pooledByteBuf, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i4, int i5) {
        return allocate(cacheForTiny(poolArena, i5), pooledByteBuf, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free() {
        ThreadDeathWatcher.unwatch(this.thread, this.freeTask);
        free0();
    }

    void trim() {
        trim(this.tinySubPageDirectCaches);
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    private static int free(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return 0;
        }
        int i4 = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            i4 += free(memoryRegionCache);
        }
        return i4;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free();
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i4) {
        if (memoryRegionCacheArr == null || i4 > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i4];
    }

    private static void trim(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return;
        }
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            trim(memoryRegionCache);
        }
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }
}
