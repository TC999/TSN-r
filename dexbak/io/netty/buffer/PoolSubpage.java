package io.netty.buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    public PoolSubpage(int i) {
        this.chunk = null;
        this.memoryMapIdx = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.pageSize = i;
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
        int i = this.bitmapLength;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if (((-1) ^ j) != 0) {
                return findNextAvail0(i2, j);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i, long j) {
        int i2 = this.maxNumElems;
        int i3 = i << 6;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((1 & j) == 0) {
                int i5 = i3 | i4;
                if (i5 < i2) {
                    return i5;
                }
                return -1;
            }
            j >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i = this.nextAvail;
        if (i >= 0) {
            this.nextAvail = -1;
            return i;
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

    private void setNextAvail(int i) {
        this.nextAvail = i;
    }

    private long toHandle(int i) {
        return (i << 32) | 4611686018427387904L | this.memoryMapIdx;
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
        int i = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i] = jArr[i] | (1 << (nextAvail & 63));
        int i2 = this.numAvail - 1;
        this.numAvail = i2;
        if (i2 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        return this.elemSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean free(PoolSubpage<T> poolSubpage, int i) {
        if (this.elemSize == 0) {
            return true;
        }
        int i2 = i >>> 6;
        long[] jArr = this.bitmap;
        jArr[i2] = jArr[i2] ^ (1 << (i & 63));
        setNextAvail(i);
        int i3 = this.numAvail;
        int i4 = i3 + 1;
        this.numAvail = i4;
        if (i3 == 0) {
            addToPool(poolSubpage);
            return true;
        } else if (i4 == this.maxNumElems && this.prev != this.next) {
            this.doNotDestroy = false;
            removeFromPool();
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolSubpage<T> poolSubpage, int i) {
        this.doNotDestroy = true;
        this.elemSize = i;
        if (i != 0) {
            int i2 = this.pageSize / i;
            this.numAvail = i2;
            this.maxNumElems = i2;
            this.nextAvail = 0;
            int i3 = i2 >>> 6;
            this.bitmapLength = i3;
            if ((i2 & 63) != 0) {
                this.bitmapLength = i3 + 1;
            }
            for (int i4 = 0; i4 < this.bitmapLength; i4++) {
                this.bitmap[i4] = 0;
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
    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i, int i2, int i3, int i4) {
        this.chunk = poolChunk;
        this.memoryMapIdx = i;
        this.runOffset = i2;
        this.pageSize = i3;
        this.bitmap = new long[i3 >>> 10];
        init(poolSubpage, i4);
    }
}
