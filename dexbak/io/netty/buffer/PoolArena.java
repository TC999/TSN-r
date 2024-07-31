package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class PoolArena<T> implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    static final int numTinySubpagePools = 32;
    private long allocationsNormal;
    private final List<PoolChunkListMetric> chunkListMetrics;
    final int chunkSize;
    private long deallocationsNormal;
    private long deallocationsSmall;
    private long deallocationsTiny;
    private final int maxOrder;
    final int numSmallSubpagePools;
    final int pageShifts;
    final int pageSize;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;
    final int subpageOverflowMask;
    private final LongCounter allocationsTiny = PlatformDependent.newLongCounter();
    private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    final AtomicInteger numThreadCaches = new AtomicInteger();
    private final PoolSubpage<T>[] tinySubpagePools = newSubpagePoolArray(32);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.buffer.PoolArena$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C136101 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static final class DirectArena extends PoolArena<ByteBuffer> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
            super(pooledByteBufAllocator, i, i2, i3, i4);
        }

        private static ByteBuffer allocateDirect(int i) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(i) : ByteBuffer.allocateDirect(i);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner(poolChunk.memory);
            } else {
                PlatformDependent.freeDirectBuffer(poolChunk.memory);
            }
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return true;
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<ByteBuffer> newByteBuf(int i) {
            if (PoolArena.HAS_UNSAFE) {
                return PooledUnsafeDirectByteBuf.newInstance(i);
            }
            return PooledDirectByteBuf.newInstance(i);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int i, int i2, int i3, int i4) {
            return new PoolChunk<>(this, allocateDirect(i4), i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, allocateDirect(i), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + i, PlatformDependent.directBufferAddress(byteBuffer2) + i2, i3);
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            duplicate.position(i).limit(i + i3);
            duplicate2.position(i2);
            duplicate2.put(duplicate);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static final class HeapArena extends PoolArena<byte[]> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
            super(pooledByteBufAllocator, i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int i) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i) : PooledHeapByteBuf.newInstance(i);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int i, int i2, int i3, int i4) {
            return new PoolChunk<>(this, new byte[i4], i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, new byte[i], i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            System.arraycopy(bArr, i, bArr2, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum SizeClass {
        Tiny,
        Small,
        Normal
    }

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
        this.parent = pooledByteBufAllocator;
        this.pageSize = i;
        this.maxOrder = i2;
        this.pageShifts = i3;
        this.chunkSize = i4;
        this.subpageOverflowMask = (i - 1) ^ (-1);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.tinySubpagePools;
            if (i6 >= poolSubpageArr.length) {
                break;
            }
            poolSubpageArr[i6] = newSubpagePoolHead(i);
            i6++;
        }
        int i7 = i3 - 9;
        this.numSmallSubpagePools = i7;
        this.smallSubpagePools = newSubpagePoolArray(i7);
        while (true) {
            PoolSubpage<T>[] poolSubpageArr2 = this.smallSubpagePools;
            if (i5 < poolSubpageArr2.length) {
                poolSubpageArr2[i5] = newSubpagePoolHead(i);
                i5++;
            } else {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(null, 100, Integer.MAX_VALUE, i4);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(poolChunkList, 75, 100, i4);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(poolChunkList2, 50, 100, i4);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(poolChunkList3, 25, 75, i4);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(poolChunkList4, 1, 50, i4);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(poolChunkList5, Integer.MIN_VALUE, 25, i4);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i) {
        PoolChunk<T> newUnpooledChunk = newUnpooledChunk(i);
        this.activeBytesHuge.add(newUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(newUnpooledChunk, i);
        this.allocationsHuge.increment();
    }

    private synchronized void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        if (!this.q050.allocate(pooledByteBuf, i, i2) && !this.q025.allocate(pooledByteBuf, i, i2) && !this.q000.allocate(pooledByteBuf, i, i2) && !this.qInit.allocate(pooledByteBuf, i, i2) && !this.q075.allocate(pooledByteBuf, i, i2)) {
            PoolChunk<T> newChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
            long allocate = newChunk.allocate(i2);
            this.allocationsNormal++;
            newChunk.initBuf(pooledByteBuf, allocate, i);
            this.qInit.add(newChunk);
            return;
        }
        this.allocationsNormal++;
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i = 0; i < poolSubpageArr.length; i++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i);
                sb.append(": ");
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    static boolean isTiny(int i) {
        return (i & (-512)) == 0;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i) {
        return new PoolSubpage[i];
    }

    private PoolSubpage<T> newSubpagePoolHead(int i) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private SizeClass sizeClass(int i) {
        if (isTinyOrSmall(i)) {
            return isTiny(i) ? SizeClass.Tiny : SizeClass.Small;
        }
        return SizeClass.Normal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int smallIdx(int i) {
        int i2 = i >>> 10;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            PoolSubpage poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage) {
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tinyIdx(int i) {
        return i >>> 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i, int i2) {
        PooledByteBuf<T> newByteBuf = newByteBuf(i2);
        allocate(poolThreadCache, newByteBuf, i);
        return newByteBuf;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    protected abstract void destroyChunk(PoolChunk<T> poolChunk);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage<T> findSubpagePoolHead(int i) {
        PoolSubpage<T>[] poolSubpageArr;
        int i2;
        if (isTiny(i)) {
            i2 = i >>> 4;
            poolSubpageArr = this.tinySubpagePools;
        } else {
            int i3 = 0;
            int i4 = i >>> 10;
            while (i4 != 0) {
                i4 >>>= 1;
                i3++;
            }
            int i5 = i3;
            poolSubpageArr = this.smallSubpagePools;
            i2 = i5;
        }
        return poolSubpageArr[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(PoolChunk<T> poolChunk, long j, int i, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            int chunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-chunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(i);
        if (poolThreadCache == null || !poolThreadCache.add(this, poolChunk, j, i, sizeClass)) {
            freeChunk(poolChunk, j, sizeClass);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void freeChunk(PoolChunk<T> poolChunk, long j, SizeClass sizeClass) {
        boolean z;
        synchronized (this) {
            int i = C136101.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
            z = true;
            if (i == 1) {
                this.deallocationsNormal++;
            } else if (i == 2) {
                this.deallocationsSmall++;
            } else if (i == 3) {
                this.deallocationsTiny++;
            } else {
                throw new Error();
            }
            if (poolChunk.parent.free(poolChunk, j)) {
                z = false;
            }
        }
        if (z) {
            destroyChunk(poolChunk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isDirect();

    boolean isTinyOrSmall(int i) {
        return (i & this.subpageOverflowMask) == 0;
    }

    protected abstract void memoryCopy(T t, int i, T t2, int i2, int i3);

    protected abstract PooledByteBuf<T> newByteBuf(int i);

    protected abstract PoolChunk<T> newChunk(int i, int i2, int i3, int i4);

    protected abstract PoolChunk<T> newUnpooledChunk(int i);

    int normalizeCapacity(int i) {
        if (i >= 0) {
            if (i >= this.chunkSize) {
                return i;
            }
            if (isTiny(i)) {
                return (i & 15) == 0 ? i : (i & (-16)) + 16;
            }
            int i2 = i - 1;
            int i3 = i2 | (i2 >>> 1);
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            int i7 = (i6 | (i6 >>> 16)) + 1;
            return i7 < 0 ? i7 >>> 1 : i7;
        }
        throw new IllegalArgumentException("capacity: " + i + " (expected: 0+)");
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long j;
        long value = ((this.allocationsTiny.value() + this.allocationsSmall.value()) + this.allocationsHuge.value()) - this.deallocationsHuge.value();
        synchronized (this) {
            j = value + (this.allocationsNormal - ((this.deallocationsTiny + this.deallocationsSmall) + this.deallocationsNormal));
        }
        return Math.max(j, 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long value = this.activeBytesHuge.value();
        synchronized (this) {
            for (int i = 0; i < this.chunkListMetrics.size(); i++) {
                for (PoolChunkMetric poolChunkMetric : this.chunkListMetrics.get(i)) {
                    value += poolChunkMetric.chunkSize();
                }
            }
        }
        return Math.max(0L, value);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        long j;
        synchronized (this) {
            j = this.allocationsNormal - this.deallocationsNormal;
        }
        return Math.max(j, 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return Math.max(numTinyAllocations() - numTinyDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        long j;
        synchronized (this) {
            j = this.allocationsNormal;
        }
        return this.allocationsTiny.value() + this.allocationsSmall.value() + j + this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        long j;
        synchronized (this) {
            j = this.deallocationsTiny + this.deallocationsSmall + this.deallocationsNormal;
        }
        return j + this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalAllocations() {
        return this.allocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalDeallocations() {
        return this.deallocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numSmallDeallocations() {
        return this.deallocationsSmall;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return this.allocationsTiny.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numTinyDeallocations() {
        return this.deallocationsTiny;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return this.tinySubpagePools.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reallocate(io.netty.buffer.PooledByteBuf<T> r13, int r14, boolean r15) {
        /*
            r12 = this;
            if (r14 < 0) goto L61
            int r0 = r13.maxCapacity()
            if (r14 > r0) goto L61
            int r6 = r13.length
            if (r6 != r14) goto Ld
            return
        Ld:
            io.netty.buffer.PoolChunk<T> r7 = r13.chunk
            long r8 = r13.handle
            T r2 = r13.memory
            int r3 = r13.offset
            int r10 = r13.maxLength
            int r11 = r13.readerIndex()
            int r0 = r13.writerIndex()
            io.netty.buffer.PooledByteBufAllocator r1 = r12.parent
            io.netty.buffer.PoolThreadCache r1 = r1.threadCache()
            r12.allocate(r1, r13, r14)
            if (r14 <= r6) goto L33
            T r4 = r13.memory
            int r5 = r13.offset
            r1 = r12
            r1.memoryCopy(r2, r3, r4, r5, r6)
            goto L51
        L33:
            if (r14 >= r6) goto L51
            if (r11 >= r14) goto L4f
            if (r0 <= r14) goto L3a
            goto L3b
        L3a:
            r14 = r0
        L3b:
            int r3 = r3 + r11
            T r4 = r13.memory
            int r0 = r13.offset
            int r5 = r0 + r11
            int r6 = r14 - r11
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r0.memoryCopy(r1, r2, r3, r4, r5)
            r0 = r14
            goto L51
        L4f:
            r0 = r14
            goto L52
        L51:
            r14 = r11
        L52:
            r13.setIndex(r14, r0)
            if (r15 == 0) goto L60
            io.netty.buffer.PoolThreadCache r5 = r13.cache
            r0 = r12
            r1 = r7
            r2 = r8
            r4 = r10
            r0.free(r1, r2, r4, r5)
        L60:
            return
        L61:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "newCapacity: "
            r15.append(r0)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.PoolArena.reallocate(io.netty.buffer.PooledByteBuf, int, boolean):void");
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return subPageMetricList(this.tinySubpagePools);
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Chunk(s) at 0~25%:");
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append(this.qInit);
        sb.append(str);
        sb.append("Chunk(s) at 0~50%:");
        sb.append(str);
        sb.append(this.q000);
        sb.append(str);
        sb.append("Chunk(s) at 25~75%:");
        sb.append(str);
        sb.append(this.q025);
        sb.append(str);
        sb.append("Chunk(s) at 50~100%:");
        sb.append(str);
        sb.append(this.q050);
        sb.append(str);
        sb.append("Chunk(s) at 75~100%:");
        sb.append(str);
        sb.append(this.q075);
        sb.append(str);
        sb.append("Chunk(s) at 100%:");
        sb.append(str);
        sb.append(this.q100);
        sb.append(str);
        sb.append("tiny subpages:");
        appendPoolSubPages(sb, this.tinySubpagePools);
        sb.append(str);
        sb.append("small subpages:");
        appendPoolSubPages(sb, this.smallSubpagePools);
        sb.append(str);
        return sb.toString();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i) {
        int smallIdx;
        PoolSubpage<T>[] poolSubpageArr;
        int normalizeCapacity = normalizeCapacity(i);
        if (isTinyOrSmall(normalizeCapacity)) {
            boolean isTiny = isTiny(normalizeCapacity);
            if (isTiny) {
                if (poolThreadCache.allocateTiny(this, pooledByteBuf, i, normalizeCapacity)) {
                    return;
                }
                smallIdx = tinyIdx(normalizeCapacity);
                poolSubpageArr = this.tinySubpagePools;
            } else if (poolThreadCache.allocateSmall(this, pooledByteBuf, i, normalizeCapacity)) {
                return;
            } else {
                smallIdx = smallIdx(normalizeCapacity);
                poolSubpageArr = this.smallSubpagePools;
            }
            PoolSubpage<T> poolSubpage = poolSubpageArr[smallIdx];
            synchronized (poolSubpage) {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                if (poolSubpage2 != poolSubpage) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, poolSubpage2.allocate(), i);
                    if (isTiny) {
                        this.allocationsTiny.increment();
                    } else {
                        this.allocationsSmall.increment();
                    }
                    return;
                }
                allocateNormal(pooledByteBuf, i, normalizeCapacity);
            }
        } else if (normalizeCapacity <= this.chunkSize) {
            if (poolThreadCache.allocateNormal(this, pooledByteBuf, i, normalizeCapacity)) {
                return;
            }
            allocateNormal(pooledByteBuf, i, normalizeCapacity);
        } else {
            allocateHuge(pooledByteBuf, i);
        }
    }
}
