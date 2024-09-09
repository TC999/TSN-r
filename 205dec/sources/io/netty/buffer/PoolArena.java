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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.buffer.PoolArena$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class DirectArena extends PoolArena<ByteBuffer> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i4, int i5, int i6, int i7) {
            super(pooledByteBufAllocator, i4, i5, i6, i7);
        }

        private static ByteBuffer allocateDirect(int i4) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(i4) : ByteBuffer.allocateDirect(i4);
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
        protected PooledByteBuf<ByteBuffer> newByteBuf(int i4) {
            if (PoolArena.HAS_UNSAFE) {
                return PooledUnsafeDirectByteBuf.newInstance(i4);
            }
            return PooledDirectByteBuf.newInstance(i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int i4, int i5, int i6, int i7) {
            return new PoolChunk<>(this, allocateDirect(i7), i4, i5, i6, i7);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int i4) {
            return new PoolChunk<>(this, allocateDirect(i4), i4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, int i6) {
            if (i6 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + i4, PlatformDependent.directBufferAddress(byteBuffer2) + i5, i6);
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            duplicate.position(i4).limit(i4 + i6);
            duplicate2.position(i5);
            duplicate2.put(duplicate);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class HeapArena extends PoolArena<byte[]> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i4, int i5, int i6, int i7) {
            super(pooledByteBufAllocator, i4, i5, i6, i7);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int i4) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i4) : PooledHeapByteBuf.newInstance(i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int i4, int i5, int i6, int i7) {
            return new PoolChunk<>(this, new byte[i7], i4, i5, i6, i7);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int i4) {
            return new PoolChunk<>(this, new byte[i4], i4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
            if (i6 == 0) {
                return;
            }
            System.arraycopy(bArr, i4, bArr2, i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum SizeClass {
        Tiny,
        Small,
        Normal
    }

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i4, int i5, int i6, int i7) {
        this.parent = pooledByteBufAllocator;
        this.pageSize = i4;
        this.maxOrder = i5;
        this.pageShifts = i6;
        this.chunkSize = i7;
        this.subpageOverflowMask = (i4 - 1) ^ (-1);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.tinySubpagePools;
            if (i9 >= poolSubpageArr.length) {
                break;
            }
            poolSubpageArr[i9] = newSubpagePoolHead(i4);
            i9++;
        }
        int i10 = i6 - 9;
        this.numSmallSubpagePools = i10;
        this.smallSubpagePools = newSubpagePoolArray(i10);
        while (true) {
            PoolSubpage<T>[] poolSubpageArr2 = this.smallSubpagePools;
            if (i8 < poolSubpageArr2.length) {
                poolSubpageArr2[i8] = newSubpagePoolHead(i4);
                i8++;
            } else {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(null, 100, Integer.MAX_VALUE, i7);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(poolChunkList, 75, 100, i7);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(poolChunkList2, 50, 100, i7);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(poolChunkList3, 25, 75, i7);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(poolChunkList4, 1, 50, i7);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(poolChunkList5, Integer.MIN_VALUE, 25, i7);
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

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i4) {
        PoolChunk<T> newUnpooledChunk = newUnpooledChunk(i4);
        this.activeBytesHuge.add(newUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(newUnpooledChunk, i4);
        this.allocationsHuge.increment();
    }

    private synchronized void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i4, int i5) {
        if (!this.q050.allocate(pooledByteBuf, i4, i5) && !this.q025.allocate(pooledByteBuf, i4, i5) && !this.q000.allocate(pooledByteBuf, i4, i5) && !this.qInit.allocate(pooledByteBuf, i4, i5) && !this.q075.allocate(pooledByteBuf, i4, i5)) {
            PoolChunk<T> newChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
            long allocate = newChunk.allocate(i5);
            this.allocationsNormal++;
            newChunk.initBuf(pooledByteBuf, allocate, i4);
            this.qInit.add(newChunk);
            return;
        }
        this.allocationsNormal++;
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i4 = 0; i4 < poolSubpageArr.length; i4++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i4];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i4);
                sb.append(": ");
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    static boolean isTiny(int i4) {
        return (i4 & (-512)) == 0;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i4) {
        return new PoolSubpage[i4];
    }

    private PoolSubpage<T> newSubpagePoolHead(int i4) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i4);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private SizeClass sizeClass(int i4) {
        if (isTinyOrSmall(i4)) {
            return isTiny(i4) ? SizeClass.Tiny : SizeClass.Small;
        }
        return SizeClass.Normal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int smallIdx(int i4) {
        int i5 = i4 >>> 10;
        int i6 = 0;
        while (i5 != 0) {
            i5 >>>= 1;
            i6++;
        }
        return i6;
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
    public static int tinyIdx(int i4) {
        return i4 >>> 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i4, int i5) {
        PooledByteBuf<T> newByteBuf = newByteBuf(i5);
        allocate(poolThreadCache, newByteBuf, i4);
        return newByteBuf;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    protected abstract void destroyChunk(PoolChunk<T> poolChunk);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage<T> findSubpagePoolHead(int i4) {
        PoolSubpage<T>[] poolSubpageArr;
        int i5;
        if (isTiny(i4)) {
            i5 = i4 >>> 4;
            poolSubpageArr = this.tinySubpagePools;
        } else {
            int i6 = 0;
            int i7 = i4 >>> 10;
            while (i7 != 0) {
                i7 >>>= 1;
                i6++;
            }
            int i8 = i6;
            poolSubpageArr = this.smallSubpagePools;
            i5 = i8;
        }
        return poolSubpageArr[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(PoolChunk<T> poolChunk, long j4, int i4, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            int chunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-chunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(i4);
        if (poolThreadCache == null || !poolThreadCache.add(this, poolChunk, j4, i4, sizeClass)) {
            freeChunk(poolChunk, j4, sizeClass);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void freeChunk(PoolChunk<T> poolChunk, long j4, SizeClass sizeClass) {
        boolean z3;
        synchronized (this) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
            z3 = true;
            if (i4 == 1) {
                this.deallocationsNormal++;
            } else if (i4 == 2) {
                this.deallocationsSmall++;
            } else if (i4 == 3) {
                this.deallocationsTiny++;
            } else {
                throw new Error();
            }
            if (poolChunk.parent.free(poolChunk, j4)) {
                z3 = false;
            }
        }
        if (z3) {
            destroyChunk(poolChunk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isDirect();

    boolean isTinyOrSmall(int i4) {
        return (i4 & this.subpageOverflowMask) == 0;
    }

    protected abstract void memoryCopy(T t3, int i4, T t4, int i5, int i6);

    protected abstract PooledByteBuf<T> newByteBuf(int i4);

    protected abstract PoolChunk<T> newChunk(int i4, int i5, int i6, int i7);

    protected abstract PoolChunk<T> newUnpooledChunk(int i4);

    int normalizeCapacity(int i4) {
        if (i4 >= 0) {
            if (i4 >= this.chunkSize) {
                return i4;
            }
            if (isTiny(i4)) {
                return (i4 & 15) == 0 ? i4 : (i4 & (-16)) + 16;
            }
            int i5 = i4 - 1;
            int i6 = i5 | (i5 >>> 1);
            int i7 = i6 | (i6 >>> 2);
            int i8 = i7 | (i7 >>> 4);
            int i9 = i8 | (i8 >>> 8);
            int i10 = (i9 | (i9 >>> 16)) + 1;
            return i10 < 0 ? i10 >>> 1 : i10;
        }
        throw new IllegalArgumentException("capacity: " + i4 + " (expected: 0+)");
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long j4;
        long value = ((this.allocationsTiny.value() + this.allocationsSmall.value()) + this.allocationsHuge.value()) - this.deallocationsHuge.value();
        synchronized (this) {
            j4 = value + (this.allocationsNormal - ((this.deallocationsTiny + this.deallocationsSmall) + this.deallocationsNormal));
        }
        return Math.max(j4, 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long value = this.activeBytesHuge.value();
        synchronized (this) {
            for (int i4 = 0; i4 < this.chunkListMetrics.size(); i4++) {
                for (PoolChunkMetric poolChunkMetric : this.chunkListMetrics.get(i4)) {
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
        long j4;
        synchronized (this) {
            j4 = this.allocationsNormal - this.deallocationsNormal;
        }
        return Math.max(j4, 0L);
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
        long j4;
        synchronized (this) {
            j4 = this.allocationsNormal;
        }
        return this.allocationsTiny.value() + this.allocationsSmall.value() + j4 + this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        long j4;
        synchronized (this) {
            j4 = this.deallocationsTiny + this.deallocationsSmall + this.deallocationsNormal;
        }
        return j4 + this.deallocationsHuge.value();
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

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i4) {
        int smallIdx;
        PoolSubpage<T>[] poolSubpageArr;
        int normalizeCapacity = normalizeCapacity(i4);
        if (isTinyOrSmall(normalizeCapacity)) {
            boolean isTiny = isTiny(normalizeCapacity);
            if (isTiny) {
                if (poolThreadCache.allocateTiny(this, pooledByteBuf, i4, normalizeCapacity)) {
                    return;
                }
                smallIdx = tinyIdx(normalizeCapacity);
                poolSubpageArr = this.tinySubpagePools;
            } else if (poolThreadCache.allocateSmall(this, pooledByteBuf, i4, normalizeCapacity)) {
                return;
            } else {
                smallIdx = smallIdx(normalizeCapacity);
                poolSubpageArr = this.smallSubpagePools;
            }
            PoolSubpage<T> poolSubpage = poolSubpageArr[smallIdx];
            synchronized (poolSubpage) {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                if (poolSubpage2 != poolSubpage) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, poolSubpage2.allocate(), i4);
                    if (isTiny) {
                        this.allocationsTiny.increment();
                    } else {
                        this.allocationsSmall.increment();
                    }
                    return;
                }
                allocateNormal(pooledByteBuf, i4, normalizeCapacity);
            }
        } else if (normalizeCapacity <= this.chunkSize) {
            if (poolThreadCache.allocateNormal(this, pooledByteBuf, i4, normalizeCapacity)) {
                return;
            }
            allocateNormal(pooledByteBuf, i4, normalizeCapacity);
        } else {
            allocateHuge(pooledByteBuf, i4);
        }
    }
}
