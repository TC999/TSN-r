package io.netty.buffer;

import kotlinx.coroutines.internal.C15104v;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INTEGER_SIZE_MINUS_ONE = 31;
    final PoolArena<T> arena;
    private final int chunkSize;
    private final byte[] depthMap;
    private int freeBytes;
    private final int log2ChunkSize;
    private final int maxOrder;
    private final int maxSubpageAllocs;
    final T memory;
    private final byte[] memoryMap;
    PoolChunk<T> next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    private final int subpageOverflowMask;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;
    private final byte unusable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t, int i, int i2, int i3, int i4) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t;
        this.pageSize = i;
        this.pageShifts = i3;
        this.maxOrder = i2;
        this.chunkSize = i4;
        this.unusable = (byte) (i2 + 1);
        this.log2ChunkSize = log2(i4);
        this.subpageOverflowMask = (i - 1) ^ (-1);
        this.freeBytes = i4;
        int i5 = 1 << i2;
        this.maxSubpageAllocs = i5;
        byte[] bArr = new byte[i5 << 1];
        this.memoryMap = bArr;
        this.depthMap = new byte[bArr.length];
        int i6 = 1;
        for (int i7 = 0; i7 <= i2; i7++) {
            int i8 = 1 << i7;
            for (int i9 = 0; i9 < i8; i9++) {
                byte b = (byte) i7;
                this.memoryMap[i6] = b;
                this.depthMap[i6] = b;
                i6++;
            }
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
    }

    private int allocateNode(int i) {
        int i2 = 1;
        int i3 = -(1 << i);
        byte value = value(1);
        if (value > i) {
            return -1;
        }
        while (true) {
            if (value >= i && (i2 & i3) != 0) {
                value(i2);
                setValue(i2, this.unusable);
                updateParentsAlloc(i2);
                return i2;
            }
            i2 <<= 1;
            value = value(i2);
            if (value > i) {
                i2 ^= 1;
                value = value(i2);
            }
        }
    }

    private long allocateRun(int i) {
        int allocateNode = allocateNode(this.maxOrder - (log2(i) - this.pageShifts));
        if (allocateNode < 0) {
            return allocateNode;
        }
        this.freeBytes -= runLength(allocateNode);
        return allocateNode;
    }

    private long allocateSubpage(int i) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i);
        synchronized (findSubpagePoolHead) {
            int allocateNode = allocateNode(this.maxOrder);
            if (allocateNode < 0) {
                return allocateNode;
            }
            PoolSubpage<T>[] poolSubpageArr = this.subpages;
            int i2 = this.pageSize;
            this.freeBytes -= i2;
            int subpageIdx = subpageIdx(allocateNode);
            PoolSubpage<T> poolSubpage = poolSubpageArr[subpageIdx];
            if (poolSubpage == null) {
                PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(findSubpagePoolHead, this, allocateNode, runOffset(allocateNode), i2, i);
                poolSubpageArr[subpageIdx] = poolSubpage2;
                poolSubpage = poolSubpage2;
            } else {
                poolSubpage.init(findSubpagePoolHead, i);
            }
            return poolSubpage.allocate();
        }
    }

    private static int bitmapIdx(long j) {
        return (int) (j >>> 32);
    }

    private byte depth(int i) {
        return this.depthMap[i];
    }

    private static int log2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    private static int memoryMapIdx(long j) {
        return (int) j;
    }

    private PoolSubpage<T>[] newSubpageArray(int i) {
        return new PoolSubpage[i];
    }

    private int runLength(int i) {
        return 1 << (this.log2ChunkSize - depth(i));
    }

    private int runOffset(int i) {
        return ((1 << depth(i)) ^ i) * runLength(i);
    }

    private void setValue(int i, byte b) {
        this.memoryMap[i] = b;
    }

    private int subpageIdx(int i) {
        return i ^ this.maxSubpageAllocs;
    }

    private void updateParentsAlloc(int i) {
        while (i > 1) {
            int i2 = i >>> 1;
            byte value = value(i);
            byte value2 = value(i ^ 1);
            if (value >= value2) {
                value = value2;
            }
            setValue(i2, value);
            i = i2;
        }
    }

    private void updateParentsFree(int i) {
        int depth = depth(i) + 1;
        while (i > 1) {
            int i2 = i >>> 1;
            byte value = value(i);
            byte value2 = value(i ^ 1);
            depth--;
            if (value == depth && value2 == depth) {
                setValue(i2, (byte) (depth - 1));
            } else {
                if (value >= value2) {
                    value = value2;
                }
                setValue(i2, value);
            }
            i = i2;
        }
    }

    private byte value(int i) {
        return this.memoryMap[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long allocate(int i) {
        if ((this.subpageOverflowMask & i) != 0) {
            return allocateRun(i);
        }
        return allocateSubpage(i);
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(long j) {
        int memoryMapIdx = memoryMapIdx(j);
        int bitmapIdx = bitmapIdx(j);
        if (bitmapIdx != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (findSubpagePoolHead) {
                if (poolSubpage.free(findSubpagePoolHead, bitmapIdx & C15104v.f43109i)) {
                    return;
                }
            }
        }
        this.freeBytes += runLength(memoryMapIdx);
        setValue(memoryMapIdx, depth(memoryMapIdx));
        updateParentsFree(memoryMapIdx);
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        return this.freeBytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBuf(PooledByteBuf<T> pooledByteBuf, long j, int i) {
        int memoryMapIdx = memoryMapIdx(j);
        int bitmapIdx = bitmapIdx(j);
        if (bitmapIdx == 0) {
            value(memoryMapIdx);
            pooledByteBuf.init(this, j, runOffset(memoryMapIdx), i, runLength(memoryMapIdx), this.arena.parent.threadCache());
            return;
        }
        initBufWithSubpage(pooledByteBuf, j, bitmapIdx, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j, int i) {
        initBufWithSubpage(pooledByteBuf, j, bitmapIdx(j), i);
    }

    public String toString() {
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage() + "%, " + (this.chunkSize - this.freeBytes) + '/' + this.chunkSize + ')';
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int usage() {
        int i = this.freeBytes;
        if (i == 0) {
            return 100;
        }
        int i2 = (int) ((i * 100) / this.chunkSize);
        if (i2 == 0) {
            return 99;
        }
        return 100 - i2;
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j, int i, int i2) {
        int memoryMapIdx = memoryMapIdx(j);
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
        int runOffset = runOffset(memoryMapIdx);
        int i3 = i & C15104v.f43109i;
        int i4 = poolSubpage.elemSize;
        pooledByteBuf.init(this, j, runOffset + (i3 * i4), i2, i4, this.arena.parent.threadCache());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t, int i) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) (1 + 0);
        this.chunkSize = i;
        this.log2ChunkSize = log2(i);
        this.maxSubpageAllocs = 0;
    }
}
