package io.netty.buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    public PoolChunk(PoolArena<T> poolArena, T t3, int i4, int i5, int i6, int i7) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t3;
        this.pageSize = i4;
        this.pageShifts = i6;
        this.maxOrder = i5;
        this.chunkSize = i7;
        this.unusable = (byte) (i5 + 1);
        this.log2ChunkSize = log2(i7);
        this.subpageOverflowMask = (i4 - 1) ^ (-1);
        this.freeBytes = i7;
        int i8 = 1 << i5;
        this.maxSubpageAllocs = i8;
        byte[] bArr = new byte[i8 << 1];
        this.memoryMap = bArr;
        this.depthMap = new byte[bArr.length];
        int i9 = 1;
        for (int i10 = 0; i10 <= i5; i10++) {
            int i11 = 1 << i10;
            for (int i12 = 0; i12 < i11; i12++) {
                byte b4 = (byte) i10;
                this.memoryMap[i9] = b4;
                this.depthMap[i9] = b4;
                i9++;
            }
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
    }

    private int allocateNode(int i4) {
        int i5 = 1;
        int i6 = -(1 << i4);
        byte value = value(1);
        if (value > i4) {
            return -1;
        }
        while (true) {
            if (value >= i4 && (i5 & i6) != 0) {
                value(i5);
                setValue(i5, this.unusable);
                updateParentsAlloc(i5);
                return i5;
            }
            i5 <<= 1;
            value = value(i5);
            if (value > i4) {
                i5 ^= 1;
                value = value(i5);
            }
        }
    }

    private long allocateRun(int i4) {
        int allocateNode = allocateNode(this.maxOrder - (log2(i4) - this.pageShifts));
        if (allocateNode < 0) {
            return allocateNode;
        }
        this.freeBytes -= runLength(allocateNode);
        return allocateNode;
    }

    private long allocateSubpage(int i4) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i4);
        synchronized (findSubpagePoolHead) {
            int allocateNode = allocateNode(this.maxOrder);
            if (allocateNode < 0) {
                return allocateNode;
            }
            PoolSubpage<T>[] poolSubpageArr = this.subpages;
            int i5 = this.pageSize;
            this.freeBytes -= i5;
            int subpageIdx = subpageIdx(allocateNode);
            PoolSubpage<T> poolSubpage = poolSubpageArr[subpageIdx];
            if (poolSubpage == null) {
                PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(findSubpagePoolHead, this, allocateNode, runOffset(allocateNode), i5, i4);
                poolSubpageArr[subpageIdx] = poolSubpage2;
                poolSubpage = poolSubpage2;
            } else {
                poolSubpage.init(findSubpagePoolHead, i4);
            }
            return poolSubpage.allocate();
        }
    }

    private static int bitmapIdx(long j4) {
        return (int) (j4 >>> 32);
    }

    private byte depth(int i4) {
        return this.depthMap[i4];
    }

    private static int log2(int i4) {
        return 31 - Integer.numberOfLeadingZeros(i4);
    }

    private static int memoryMapIdx(long j4) {
        return (int) j4;
    }

    private PoolSubpage<T>[] newSubpageArray(int i4) {
        return new PoolSubpage[i4];
    }

    private int runLength(int i4) {
        return 1 << (this.log2ChunkSize - depth(i4));
    }

    private int runOffset(int i4) {
        return ((1 << depth(i4)) ^ i4) * runLength(i4);
    }

    private void setValue(int i4, byte b4) {
        this.memoryMap[i4] = b4;
    }

    private int subpageIdx(int i4) {
        return i4 ^ this.maxSubpageAllocs;
    }

    private void updateParentsAlloc(int i4) {
        while (i4 > 1) {
            int i5 = i4 >>> 1;
            byte value = value(i4);
            byte value2 = value(i4 ^ 1);
            if (value >= value2) {
                value = value2;
            }
            setValue(i5, value);
            i4 = i5;
        }
    }

    private void updateParentsFree(int i4) {
        int depth = depth(i4) + 1;
        while (i4 > 1) {
            int i5 = i4 >>> 1;
            byte value = value(i4);
            byte value2 = value(i4 ^ 1);
            depth--;
            if (value == depth && value2 == depth) {
                setValue(i5, (byte) (depth - 1));
            } else {
                if (value >= value2) {
                    value = value2;
                }
                setValue(i5, value);
            }
            i4 = i5;
        }
    }

    private byte value(int i4) {
        return this.memoryMap[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long allocate(int i4) {
        if ((this.subpageOverflowMask & i4) != 0) {
            return allocateRun(i4);
        }
        return allocateSubpage(i4);
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free(long j4) {
        int memoryMapIdx = memoryMapIdx(j4);
        int bitmapIdx = bitmapIdx(j4);
        if (bitmapIdx != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (findSubpagePoolHead) {
                if (poolSubpage.free(findSubpagePoolHead, bitmapIdx & 1073741823)) {
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
    public void initBuf(PooledByteBuf<T> pooledByteBuf, long j4, int i4) {
        int memoryMapIdx = memoryMapIdx(j4);
        int bitmapIdx = bitmapIdx(j4);
        if (bitmapIdx == 0) {
            value(memoryMapIdx);
            pooledByteBuf.init(this, j4, runOffset(memoryMapIdx), i4, runLength(memoryMapIdx), this.arena.parent.threadCache());
            return;
        }
        initBufWithSubpage(pooledByteBuf, j4, bitmapIdx, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j4, int i4) {
        initBufWithSubpage(pooledByteBuf, j4, bitmapIdx(j4), i4);
    }

    public String toString() {
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage() + "%, " + (this.chunkSize - this.freeBytes) + '/' + this.chunkSize + ')';
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int usage() {
        int i4 = this.freeBytes;
        if (i4 == 0) {
            return 100;
        }
        int i5 = (int) ((i4 * 100) / this.chunkSize);
        if (i5 == 0) {
            return 99;
        }
        return 100 - i5;
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j4, int i4, int i5) {
        int memoryMapIdx = memoryMapIdx(j4);
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
        int runOffset = runOffset(memoryMapIdx);
        int i6 = poolSubpage.elemSize;
        pooledByteBuf.init(this, j4, runOffset + ((i4 & 1073741823) * i6), i5, i6, this.arena.parent.threadCache());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunk(PoolArena<T> poolArena, T t3, int i4) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t3;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) (1 + 0);
        this.chunkSize = i4;
        this.log2ChunkSize = log2(i4);
        this.maxSubpageAllocs = 0;
    }
}
