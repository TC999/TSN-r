package io.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;

    /* renamed from: i1  reason: collision with root package name */
    private final Iterator<E> f54775i1;

    /* renamed from: i2  reason: collision with root package name */
    private final Iterator<E> f54776i2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        }
        if (it2 != null) {
            this.f54775i1 = it;
            this.f54776i2 = it2;
            this.currentIterator = it;
            return;
        }
        throw new NullPointerException("i2");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f54775i1) {
                return false;
            }
            this.currentIterator = this.f54776i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e4) {
                if (this.currentIterator != this.f54775i1) {
                    throw e4;
                }
                this.currentIterator = this.f54776i2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
