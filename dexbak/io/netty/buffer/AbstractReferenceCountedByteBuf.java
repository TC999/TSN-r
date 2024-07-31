package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> refCntUpdater;
    private volatile int refCnt;

    static {
        AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        }
        refCntUpdater = newAtomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractReferenceCountedByteBuf(int i) {
        super(i);
        this.refCnt = 1;
    }

    protected abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.refCnt;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        int i;
        do {
            i = this.refCnt;
            if (i == 0) {
                throw new IllegalReferenceCountException(0, -1);
            }
        } while (!refCntUpdater.compareAndSet(this, i, i - 1));
        if (i == 1) {
            deallocate();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRefCnt(int i) {
        this.refCnt = i;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        int i;
        int i2;
        do {
            i = this.refCnt;
            i2 = i + 1;
            if (i2 <= 1) {
                throw new IllegalReferenceCountException(i, 1);
            }
        } while (!refCntUpdater.compareAndSet(this, i, i2));
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        int i2;
        if (i > 0) {
            do {
                i2 = this.refCnt;
                if (i2 < i) {
                    throw new IllegalReferenceCountException(i2, -i);
                }
            } while (!refCntUpdater.compareAndSet(this, i2, i2 - i));
            if (i2 == i) {
                deallocate();
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("decrement: " + i + " (expected: > 0)");
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i) {
        int i2;
        int i3;
        if (i > 0) {
            do {
                i2 = this.refCnt;
                i3 = i2 + i;
                if (i3 <= i) {
                    throw new IllegalReferenceCountException(i2, i);
                }
            } while (!refCntUpdater.compareAndSet(this, i2, i3));
            return this;
        }
        throw new IllegalArgumentException("increment: " + i + " (expected: > 0)");
    }
}
