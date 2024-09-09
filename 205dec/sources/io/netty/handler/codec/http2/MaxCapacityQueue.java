package io.netty.handler.codec.http2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class MaxCapacityQueue<E> implements Queue<E> {
    private final int maxCapacity;
    private final Queue<E> queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaxCapacityQueue(Queue<E> queue, int i4) {
        this.queue = queue;
        this.maxCapacity = i4;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(E e4) {
        if (offer(e4)) {
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (this.maxCapacity >= size() + collection.size()) {
            return this.queue.addAll(collection);
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Collection
    public void clear() {
        this.queue.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.queue.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.queue.containsAll(collection);
    }

    @Override // java.util.Queue
    public E element() {
        return this.queue.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.queue.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e4) {
        if (this.maxCapacity <= this.queue.size()) {
            return false;
        }
        return this.queue.offer(e4);
    }

    @Override // java.util.Queue
    public E peek() {
        return this.queue.peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return this.queue.poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return this.queue.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.queue.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.queue.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.queue.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.queue.toArray();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.queue.remove(obj);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.queue.toArray(tArr);
    }
}
