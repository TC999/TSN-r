package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e4);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addFirst(E e4);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addLast(E e4);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E element();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e4);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e4, long j4, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerFirst(E e4);

    boolean offerFirst(E e4, long j4, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerLast(E e4);

    boolean offerLast(E e4, long j4, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E peek();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j4, TimeUnit timeUnit);

    E pollFirst(long j4, TimeUnit timeUnit);

    E pollLast(long j4, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void push(E e4);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e4);

    void putFirst(E e4);

    void putLast(E e4);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E remove();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take();

    E takeFirst();

    E takeLast();
}
