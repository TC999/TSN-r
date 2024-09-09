package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class DefaultPriorityQueue<T extends PriorityQueueNode> extends AbstractQueue<T> implements PriorityQueue<T> {
    private static final PriorityQueueNode[] EMPTY_ARRAY = new PriorityQueueNode[0];
    private final Comparator<T> comparator;
    private T[] queue;
    private int size;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < DefaultPriorityQueue.this.size;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.index < DefaultPriorityQueue.this.size) {
                PriorityQueueNode[] priorityQueueNodeArr = DefaultPriorityQueue.this.queue;
                int i4 = this.index;
                this.index = i4 + 1;
                return (T) priorityQueueNodeArr[i4];
            }
            throw new NoSuchElementException();
        }
    }

    public DefaultPriorityQueue(Comparator<T> comparator, int i4) {
        this.comparator = (Comparator) ObjectUtil.checkNotNull(comparator, "comparator");
        this.queue = i4 != 0 ? (T[]) new PriorityQueueNode[i4] : (T[]) EMPTY_ARRAY;
    }

    private void bubbleDown(int i4, T t3) {
        int i5 = this.size >>> 1;
        while (i4 < i5) {
            int i6 = (i4 << 1) + 1;
            T[] tArr = this.queue;
            T t4 = tArr[i6];
            int i7 = i6 + 1;
            if (i7 < this.size && this.comparator.compare(t4, tArr[i7]) > 0) {
                t4 = this.queue[i7];
                i6 = i7;
            }
            if (this.comparator.compare(t3, t4) <= 0) {
                break;
            }
            this.queue[i4] = t4;
            t4.priorityQueueIndex(this, i4);
            i4 = i6;
        }
        this.queue[i4] = t3;
        t3.priorityQueueIndex(this, i4);
    }

    private void bubbleUp(int i4, T t3) {
        while (i4 > 0) {
            int i5 = (i4 - 1) >>> 1;
            T t4 = this.queue[i5];
            if (this.comparator.compare(t3, t4) >= 0) {
                break;
            }
            this.queue[i4] = t4;
            t4.priorityQueueIndex(this, i4);
            i4 = i5;
        }
        this.queue[i4] = t3;
        t3.priorityQueueIndex(this, i4);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i4 = 0; i4 < this.size; i4++) {
            T t3 = this.queue[i4];
            if (t3 != null) {
                t3.priorityQueueIndex(this, -1);
                this.queue[i4] = null;
            }
        }
        this.size = 0;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof PriorityQueueNode) {
            PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
            return contains(priorityQueueNode, priorityQueueNode.priorityQueueIndex(this));
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.PriorityQueue
    public /* bridge */ /* synthetic */ boolean containsTyped(Object obj) {
        return containsTyped((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.PriorityQueue
    public /* bridge */ /* synthetic */ void priorityChanged(Object obj) {
        priorityChanged((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return removeTyped((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.PriorityQueue
    public /* bridge */ /* synthetic */ boolean removeTyped(Object obj) {
        return removeTyped((DefaultPriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    public boolean containsTyped(T t3) {
        return contains(t3, t3.priorityQueueIndex(this));
    }

    public boolean offer(T t3) {
        if (t3.priorityQueueIndex(this) == -1) {
            int i4 = this.size;
            T[] tArr = this.queue;
            if (i4 >= tArr.length) {
                this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
            }
            int i5 = this.size;
            this.size = i5 + 1;
            bubbleUp(i5, t3);
            return true;
        }
        throw new IllegalArgumentException("e.priorityQueueIndex(): " + t3.priorityQueueIndex(this) + " (expected: -1) + e: " + t3);
    }

    @Override // java.util.Queue
    public T peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    @Override // java.util.Queue
    public T poll() {
        if (this.size == 0) {
            return null;
        }
        T t3 = this.queue[0];
        t3.priorityQueueIndex(this, -1);
        T[] tArr = this.queue;
        int i4 = this.size - 1;
        this.size = i4;
        T t4 = tArr[i4];
        tArr[i4] = null;
        if (i4 != 0) {
            bubbleDown(0, t4);
        }
        return t3;
    }

    public void priorityChanged(T t3) {
        int priorityQueueIndex = t3.priorityQueueIndex(this);
        if (contains(t3, priorityQueueIndex)) {
            if (priorityQueueIndex == 0) {
                bubbleDown(priorityQueueIndex, t3);
                return;
            }
            if (this.comparator.compare(t3, this.queue[(priorityQueueIndex - 1) >>> 1]) < 0) {
                bubbleUp(priorityQueueIndex, t3);
            } else {
                bubbleDown(priorityQueueIndex, t3);
            }
        }
    }

    public boolean removeTyped(T t3) {
        int priorityQueueIndex = t3.priorityQueueIndex(this);
        if (contains(t3, priorityQueueIndex)) {
            t3.priorityQueueIndex(this, -1);
            int i4 = this.size - 1;
            this.size = i4;
            if (i4 != 0 && i4 != priorityQueueIndex) {
                T[] tArr = this.queue;
                T t4 = tArr[i4];
                tArr[priorityQueueIndex] = t4;
                tArr[i4] = null;
                if (this.comparator.compare(t3, t4) < 0) {
                    bubbleDown(priorityQueueIndex, t4);
                } else {
                    bubbleUp(priorityQueueIndex, t4);
                }
                return true;
            }
            this.queue[priorityQueueIndex] = null;
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i4 = this.size;
        if (length < i4) {
            return (X[]) Arrays.copyOf(this.queue, i4, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i4);
        int length2 = xArr.length;
        int i5 = this.size;
        if (length2 > i5) {
            xArr[i5] = null;
        }
        return xArr;
    }

    private boolean contains(PriorityQueueNode priorityQueueNode, int i4) {
        return i4 >= 0 && i4 < this.size && priorityQueueNode.equals(this.queue[i4]);
    }
}
