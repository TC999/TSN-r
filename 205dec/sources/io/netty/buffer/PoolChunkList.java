package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PoolChunkList<T> implements PoolChunkListMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Iterator<PoolChunkMetric> EMPTY_METRICS = Collections.emptyList().iterator();
    private PoolChunk<T> head;
    private final int maxCapacity;
    private final int maxUsage;
    private final int minUsage;
    private final PoolChunkList<T> nextList;
    private PoolChunkList<T> prevList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolChunkList(PoolChunkList<T> poolChunkList, int i4, int i5, int i6) {
        this.nextList = poolChunkList;
        this.minUsage = i4;
        this.maxUsage = i5;
        this.maxCapacity = calculateMaxCapacity(i4, i6);
    }

    private static int calculateMaxCapacity(int i4, int i5) {
        int minUsage0 = minUsage0(i4);
        if (minUsage0 == 100) {
            return 0;
        }
        return (int) ((i5 * (100 - minUsage0)) / 100);
    }

    private static int minUsage0(int i4) {
        return Math.max(1, i4);
    }

    private boolean move(PoolChunk<T> poolChunk) {
        if (poolChunk.usage() < this.minUsage) {
            return move0(poolChunk);
        }
        add0(poolChunk);
        return true;
    }

    private boolean move0(PoolChunk<T> poolChunk) {
        PoolChunkList<T> poolChunkList = this.prevList;
        if (poolChunkList == null) {
            return false;
        }
        return poolChunkList.move(poolChunk);
    }

    private void remove(PoolChunk<T> poolChunk) {
        if (poolChunk == this.head) {
            PoolChunk<T> poolChunk2 = poolChunk.next;
            this.head = poolChunk2;
            if (poolChunk2 != null) {
                poolChunk2.prev = null;
                return;
            }
            return;
        }
        PoolChunk<T> poolChunk3 = poolChunk.next;
        PoolChunk<T> poolChunk4 = poolChunk.prev;
        poolChunk4.next = poolChunk3;
        if (poolChunk3 != null) {
            poolChunk3.prev = poolChunk4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(PoolChunk<T> poolChunk) {
        if (poolChunk.usage() >= this.maxUsage) {
            this.nextList.add(poolChunk);
        } else {
            add0(poolChunk);
        }
    }

    void add0(PoolChunk<T> poolChunk) {
        poolChunk.parent = this;
        PoolChunk<T> poolChunk2 = this.head;
        if (poolChunk2 == null) {
            this.head = poolChunk;
            poolChunk.prev = null;
            poolChunk.next = null;
            return;
        }
        poolChunk.prev = null;
        poolChunk.next = poolChunk2;
        poolChunk2.prev = poolChunk;
        this.head = poolChunk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allocate(PooledByteBuf<T> pooledByteBuf, int i4, int i5) {
        PoolChunk<T> poolChunk = this.head;
        if (poolChunk == null || i5 > this.maxCapacity) {
            return false;
        }
        do {
            long allocate = poolChunk.allocate(i5);
            if (allocate < 0) {
                poolChunk = poolChunk.next;
            } else {
                poolChunk.initBuf(pooledByteBuf, allocate, i4);
                if (poolChunk.usage() >= this.maxUsage) {
                    remove(poolChunk);
                    this.nextList.add(poolChunk);
                    return true;
                }
                return true;
            }
        } while (poolChunk != null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean free(PoolChunk<T> poolChunk, long j4) {
        poolChunk.free(j4);
        if (poolChunk.usage() < this.minUsage) {
            remove(poolChunk);
            return move0(poolChunk);
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<PoolChunkMetric> iterator() {
        if (this.head == null) {
            return EMPTY_METRICS;
        }
        ArrayList arrayList = new ArrayList();
        PoolChunk<T> poolChunk = this.head;
        do {
            arrayList.add(poolChunk);
            poolChunk = poolChunk.next;
        } while (poolChunk != null);
        return arrayList.iterator();
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public int maxUsage() {
        return Math.min(this.maxUsage, 100);
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public int minUsage() {
        return minUsage0(this.minUsage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prevList(PoolChunkList<T> poolChunkList) {
        this.prevList = poolChunkList;
    }

    public String toString() {
        if (this.head == null) {
            return "none";
        }
        StringBuilder sb = new StringBuilder();
        PoolChunk<T> poolChunk = this.head;
        while (true) {
            sb.append(poolChunk);
            poolChunk = poolChunk.next;
            if (poolChunk == null) {
                return sb.toString();
            }
            sb.append(StringUtil.NEWLINE);
        }
    }
}
