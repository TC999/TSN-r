package io.netty.buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    int elemSize;
    private int maxNumElems;
    private final int memoryMapIdx;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageSize;
    PoolSubpage<T> prev;
    private final int runOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage(int i4) {
        this.chunk = null;
        this.memoryMapIdx = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.pageSize = i4;
        this.bitmap = null;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i4 = this.bitmapLength;
        for (int i5 = 0; i5 < i4; i5++) {
            long j4 = jArr[i5];
            if (((-1) ^ j4) != 0) {
                return findNextAvail0(i5, j4);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i4, long j4) {
        int i5 = this.maxNumElems;
        int i6 = i4 << 6;
        for (int i7 = 0; i7 < 64; i7++) {
            if ((1 & j4) == 0) {
                int i8 = i6 | i7;
                if (i8 < i5) {
                    return i8;
                }
                return -1;
            }
            j4 >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i4 = this.nextAvail;
        if (i4 >= 0) {
            this.nextAvail = -1;
            return i4;
        }
        return findNextAvail();
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i4) {
        this.nextAvail = i4;
    }

    private long toHandle(int i4) {
        return (i4 << 32) | 4611686018427387904L | this.memoryMapIdx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long allocate() {
        if (this.elemSize == 0) {
            return toHandle(0);
        }
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        int i4 = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i4] = jArr[i4] | (1 << (nextAvail & 63));
        int i5 = this.numAvail - 1;
        this.numAvail = i5;
        if (i5 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        return this.elemSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean free(PoolSubpage<T> poolSubpage, int i4) {
        if (this.elemSize == 0) {
            return true;
        }
        int i5 = i4 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i5] = jArr[i5] ^ (1 << (i4 & 63));
        setNextAvail(i4);
        int i6 = this.numAvail;
        int i7 = i6 + 1;
        this.numAvail = i7;
        if (i6 == 0) {
            addToPool(poolSubpage);
            return true;
        } else if (i7 == this.maxNumElems && this.prev != this.next) {
            this.doNotDestroy = false;
            removeFromPool();
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolSubpage<T> poolSubpage, int i4) {
        this.doNotDestroy = true;
        this.elemSize = i4;
        if (i4 != 0) {
            int i5 = this.pageSize / i4;
            this.numAvail = i5;
            this.maxNumElems = i5;
            this.nextAvail = 0;
            int i6 = i5 >>> 6;
            this.bitmapLength = i6;
            if ((i5 & 63) != 0) {
                this.bitmapLength = i6 + 1;
            }
            for (int i7 = 0; i7 < this.bitmapLength; i7++) {
                this.bitmap[i7] = 0;
            }
        }
        addToPool(poolSubpage);
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        return this.maxNumElems;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        return this.numAvail;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return this.pageSize;
    }

    public String toString() {
        if (!this.doNotDestroy) {
            return "(" + this.memoryMapIdx + ": not in use)";
        }
        return String.valueOf('(') + this.memoryMapIdx + ": " + (this.maxNumElems - this.numAvail) + '/' + this.maxNumElems + ", offset: " + this.runOffset + ", length: " + this.pageSize + ", elemSize: " + this.elemSize + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i4, int i5, int i6, int i7) {
        this.chunk = poolChunk;
        this.memoryMapIdx = i4;
        this.runOffset = i5;
        this.pageSize = i6;
        this.bitmap = new long[i6 >>> 10];
        init(poolSubpage, i7);
    }
}
