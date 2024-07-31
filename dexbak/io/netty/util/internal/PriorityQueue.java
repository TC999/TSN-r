package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PriorityQueue<T extends PriorityQueueNode<T>> extends AbstractQueue<T> implements Queue<T> {
    private static final PriorityQueueNode[] EMPTY_QUEUE = new PriorityQueueNode[0];
    private T[] queue;
    private int size;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < PriorityQueue.this.size;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.index < PriorityQueue.this.size) {
                PriorityQueueNode[] priorityQueueNodeArr = PriorityQueue.this.queue;
                int i = this.index;
                this.index = i + 1;
                return (T) priorityQueueNodeArr[i];
            }
            throw new NoSuchElementException();
        }
    }

    public PriorityQueue() {
        this(8);
    }

    private void bubbleDown(int i, T t) {
        int i2 = this.size >>> 1;
        while (i < i2) {
            int i3 = (i << 1) + 1;
            T[] tArr = this.queue;
            T t2 = tArr[i3];
            int i4 = i3 + 1;
            if (i4 < this.size && t2.compareTo(tArr[i4]) > 0) {
                t2 = this.queue[i4];
                i3 = i4;
            }
            if (t.compareTo(t2) <= 0) {
                break;
            }
            this.queue[i] = t2;
            t2.priorityQueueIndex(i);
            i = i3;
        }
        this.queue[i] = t;
        t.priorityQueueIndex(i);
    }

    private void bubbleUp(int i, T t) {
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            T t2 = this.queue[i2];
            if (t.compareTo(t2) >= 0) {
                break;
            }
            this.queue[i] = t2;
            t2.priorityQueueIndex(i);
            i = i2;
        }
        this.queue[i] = t;
        t.priorityQueueIndex(i);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            T t = this.queue[i];
            if (t != null) {
                t.priorityQueueIndex(-1);
                this.queue[i] = null;
            }
        }
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        PriorityQueueNode priorityQueueNode;
        int priorityQueueIndex;
        return (obj instanceof PriorityQueueNode) && (priorityQueueIndex = (priorityQueueNode = (PriorityQueueNode) obj).priorityQueueIndex()) >= 0 && priorityQueueIndex < this.size && priorityQueueNode.equals(this.queue[priorityQueueIndex]);
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
        return offer((PriorityQueue<T>) ((PriorityQueueNode) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        if (contains(obj)) {
            PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
            int priorityQueueIndex = priorityQueueNode.priorityQueueIndex();
            priorityQueueNode.priorityQueueIndex(-1);
            int i = this.size - 1;
            this.size = i;
            if (i != 0 && i != priorityQueueIndex) {
                T[] tArr = this.queue;
                T t = tArr[i];
                tArr[priorityQueueIndex] = t;
                tArr[i] = null;
                if (priorityQueueNode.compareTo(t) < 0) {
                    bubbleDown(priorityQueueIndex, t);
                } else {
                    bubbleUp(priorityQueueIndex, t);
                }
                return true;
            }
            this.queue[priorityQueueIndex] = null;
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    public PriorityQueue(int i) {
        this.queue = i != 0 ? (T[]) new PriorityQueueNode[i] : (T[]) EMPTY_QUEUE;
    }

    public boolean offer(T t) {
        ObjectUtil.checkNotNull(t, "e");
        if (t.priorityQueueIndex() == -1) {
            int i = this.size;
            T[] tArr = this.queue;
            if (i >= tArr.length) {
                this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
            }
            int i2 = this.size;
            this.size = i2 + 1;
            bubbleUp(i2, t);
            return true;
        }
        throw new IllegalArgumentException("e.priorityQueueIndex(): " + t.priorityQueueIndex() + " (expected: -1)");
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
        T t = this.queue[0];
        t.priorityQueueIndex(-1);
        T[] tArr = this.queue;
        int i = this.size - 1;
        this.size = i;
        T t2 = tArr[i];
        tArr[i] = null;
        if (i != 0) {
            bubbleDown(0, t2);
        }
        return t;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i = this.size;
        if (length < i) {
            return (X[]) Arrays.copyOf(this.queue, i, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i);
        int length2 = xArr.length;
        int i2 = this.size;
        if (length2 > i2) {
            xArr[i2] = null;
        }
        return xArr;
    }
}
