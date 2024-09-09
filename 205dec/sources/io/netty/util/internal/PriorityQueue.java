package io.netty.util.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface PriorityQueue<T> extends Queue<T> {

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    private final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < PriorityQueue.access$100(PriorityQueue.this);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // java.util.Iterator
        public PriorityQueueNode next() {
            if (this.index < PriorityQueue.access$100(PriorityQueue.this)) {
                PriorityQueueNode[] access$200 = PriorityQueue.access$200(PriorityQueue.this);
                int i4 = this.index;
                this.index = i4 + 1;
                return access$200[i4];
            }
            throw new NoSuchElementException();
        }
    }

    void clearIgnoringIndexes();

    boolean containsTyped(T t3);

    void priorityChanged(T t3);

    boolean removeTyped(T t3);
}
