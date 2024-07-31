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
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    /* renamed from: io.netty.buffer.PoolThreadCache$2 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C136122 {
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
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
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

        MemoryRegionCache(int i, PoolArena.SizeClass sizeClass) {
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i);
            this.size = safeFindNextPositivePowerOfTwo;
            this.queue = PlatformDependent.newFixedMpscQueue(safeFindNextPositivePowerOfTwo);
            this.sizeClass = sizeClass;
        }

        private void freeEntry(Entry entry) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j = entry.handle;
            entry.recycle();
            poolChunk.arena.freeChunk(poolChunk, j, this.sizeClass);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, long j) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.handle = j;
            return entry;
        }

        public final boolean add(PoolChunk<T> poolChunk, long j) {
            Entry<T> newEntry = newEntry(poolChunk, j);
            boolean offer = this.queue.offer(newEntry);
            if (!offer) {
                newEntry.recycle();
            }
            return offer;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i) {
            Entry<T> poll = this.queue.poll();
            if (poll == null) {
                return false;
            }
            initBuf(poll.chunk, poll.handle, pooledByteBuf, i);
            poll.recycle();
            this.allocations++;
            return true;
        }

        public final int free() {
            return free(Integer.MAX_VALUE);
        }

        protected abstract void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i);

        public final void trim() {
            int i = this.size - this.allocations;
            this.allocations = 0;
            if (i > 0) {
                free(i);
            }
        }

        private int free(int i) {
            int i2 = 0;
            while (i2 < i) {
                Entry<T> poll = this.queue.poll();
                if (poll == null) {
                    break;
                }
                freeEntry(poll);
                i2++;
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        NormalMemoryRegionCache(int i) {
            super(i, PoolArena.SizeClass.Normal);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i) {
            poolChunk.initBuf(pooledByteBuf, j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        SubPageMemoryRegionCache(int i, PoolArena.SizeClass sizeClass) {
            super(i, sizeClass);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i) {
            poolChunk.initBufWithSubpage(pooledByteBuf, j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i, int i2, int i3, int i4, int i5) {
        Thread currentThread = Thread.currentThread();
        this.thread = currentThread;
        Runnable runnable = new Runnable() { // from class: io.netty.buffer.PoolThreadCache.1
            @Override // java.lang.Runnable
            public void run() {
                PoolThreadCache.this.free0();
            }
        };
        this.freeTask = runnable;
        if (i4 < 0) {
            throw new IllegalArgumentException("maxCachedBufferCapacity: " + i4 + " (expected: >= 0)");
        } else if (i5 >= 1) {
            this.freeSweepAllocationThreshold = i5;
            this.heapArena = poolArena;
            this.directArena = poolArena2;
            if (poolArena2 != null) {
                this.tinySubPageDirectCaches = createSubPageCaches(i, 32, PoolArena.SizeClass.Tiny);
                this.smallSubPageDirectCaches = createSubPageCaches(i2, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
                this.numShiftsNormalDirect = log2(poolArena2.pageSize);
                this.normalDirectCaches = createNormalCaches(i3, i4, poolArena2);
                poolArena2.numThreadCaches.getAndIncrement();
            } else {
                this.tinySubPageDirectCaches = null;
                this.smallSubPageDirectCaches = null;
                this.normalDirectCaches = null;
                this.numShiftsNormalDirect = -1;
            }
            if (poolArena != null) {
                this.tinySubPageHeapCaches = createSubPageCaches(i, 32, PoolArena.SizeClass.Tiny);
                this.smallSubPageHeapCaches = createSubPageCaches(i2, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
                this.numShiftsNormalHeap = log2(poolArena.pageSize);
                this.normalHeapCaches = createNormalCaches(i3, i4, poolArena);
                poolArena.numThreadCaches.getAndIncrement();
            } else {
                this.tinySubPageHeapCaches = null;
                this.smallSubPageHeapCaches = null;
                this.normalHeapCaches = null;
                this.numShiftsNormalHeap = -1;
            }
            ThreadDeathWatcher.watch(currentThread, runnable);
        } else {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i5 + " (expected: > 0)");
        }
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean allocate = memoryRegionCache.allocate(pooledByteBuf, i);
        int i2 = this.allocations + 1;
        this.allocations = i2;
        if (i2 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return allocate;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i, PoolArena.SizeClass sizeClass) {
        int i2 = C136122.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return cacheForTiny(poolArena, i);
                }
                throw new Error();
            }
            return cacheForSmall(poolArena, i);
        }
        return cacheForNormal(poolArena, i);
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i) {
        if (poolArena.isDirect()) {
            return cache(this.normalDirectCaches, log2(i >> this.numShiftsNormalDirect));
        }
        return cache(this.normalHeapCaches, log2(i >> this.numShiftsNormalHeap));
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i) {
        int smallIdx = PoolArena.smallIdx(i);
        if (poolArena.isDirect()) {
            return cache(this.smallSubPageDirectCaches, smallIdx);
        }
        return cache(this.smallSubPageHeapCaches, smallIdx);
    }

    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int i) {
        int tinyIdx = PoolArena.tinyIdx(i);
        if (poolArena.isDirect()) {
            return cache(this.tinySubPageDirectCaches, tinyIdx);
        }
        return cache(this.tinySubPageHeapCaches, tinyIdx);
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i, int i2, PoolArena<T> poolArena) {
        if (i > 0) {
            int max = Math.max(1, log2(Math.min(poolArena.chunkSize, i2) / poolArena.pageSize) + 1);
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[max];
            for (int i3 = 0; i3 < max; i3++) {
                memoryRegionCacheArr[i3] = new NormalMemoryRegionCache(i);
            }
            return memoryRegionCacheArr;
        }
        return null;
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i, int i2, PoolArena.SizeClass sizeClass) {
        if (i > 0) {
            MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                memoryRegionCacheArr[i3] = new SubPageMemoryRegionCache(i, sizeClass);
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

    private static int log2(int i) {
        int i2 = 0;
        while (i > 1) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, long j, int i, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> cache = cache(poolArena, i, sizeClass);
        if (cache == null) {
            return false;
        }
        return cache.add(poolChunk, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForNormal(poolArena, i2), pooledByteBuf, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForSmall(poolArena, i2), pooledByteBuf, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForTiny(poolArena, i2), pooledByteBuf, i);
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
        int i = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            i += free(memoryRegionCache);
        }
        return i;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free();
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i) {
        if (memoryRegionCacheArr == null || i > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i];
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
