package io.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;

    /* renamed from: i1 */
    private final Iterator<E> f40184i1;

    /* renamed from: i2 */
    private final Iterator<E> f40185i2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        }
        if (it2 != null) {
            this.f40184i1 = it;
            this.f40185i2 = it2;
            this.currentIterator = it;
            return;
        }
        throw new NullPointerException("i2");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f40184i1) {
                return false;
            }
            this.currentIterator = this.f40185i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e) {
                if (this.currentIterator != this.f40184i1) {
                    throw e;
                }
                this.currentIterator = this.f40185i2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
