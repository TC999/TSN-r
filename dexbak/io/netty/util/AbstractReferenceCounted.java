package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> refCntUpdater;
    private volatile int refCnt = 1;

    static {
        AtomicIntegerFieldUpdater<AbstractReferenceCounted> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(AbstractReferenceCounted.class, "refCnt");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
        }
        refCntUpdater = newAtomicIntegerFieldUpdater;
    }

    protected abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
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

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
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

    protected final void setRefCnt(int i) {
        this.refCnt = i;
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return touch(null);
    }

    @Override // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int i) {
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
}
