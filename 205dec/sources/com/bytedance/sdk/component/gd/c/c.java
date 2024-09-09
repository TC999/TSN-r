package com.bytedance.sdk.component.gd.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c<T> implements BlockingQueue<T> {

    /* renamed from: c  reason: collision with root package name */
    private final BlockingQueue<T> f29823c;

    public c(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.f29823c = new SynchronousQueue();
        } else {
            this.f29823c = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t3) {
        return this.f29823c.add(t3);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f29823c.addAll(collection);
    }

    public final String c() {
        return this.f29823c.getClass().getName();
    }

    @Override // java.util.Collection
    public void clear() {
        this.f29823c.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.f29823c.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f29823c.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.f29823c.drainTo(collection);
    }

    @Override // java.util.Queue
    public T element() {
        return this.f29823c.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f29823c.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f29823c.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t3) {
        return this.f29823c.offer(t3);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.f29823c.peek();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j4, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.f29823c.poll(j4, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t3) throws InterruptedException {
        this.f29823c.put(t3);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.f29823c.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.f29823c.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f29823c.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f29823c.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return xv();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.f29823c.take();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public final BlockingQueue w() {
        return this.f29823c;
    }

    public int xv() {
        return this.f29823c.size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i4) {
        return this.f29823c.drainTo(collection, i4);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t3, long j4, TimeUnit timeUnit) throws InterruptedException {
        return this.f29823c.offer(t3, j4, timeUnit);
    }

    @Override // java.util.Queue
    public T poll() {
        return this.f29823c.poll();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.f29823c.remove(obj);
    }
}
