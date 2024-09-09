package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> refCntUpdater;
    private volatile int refCnt;

    /* renamed from: io.netty.buffer.AbstractReferenceCountedByteBuf$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass1 extends ReferenceCountUpdater<AbstractReferenceCountedByteBuf> {
        AnonymousClass1() {
        }

        @Override // io.netty.util.internal.ReferenceCountUpdater
        protected long unsafeOffset() {
            return AbstractReferenceCountedByteBuf.access$100();
        }

        @Override // io.netty.util.internal.ReferenceCountUpdater
        protected AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> updater() {
            return AbstractReferenceCountedByteBuf.access$000();
        }
    }

    static {
        AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        }
        refCntUpdater = newAtomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractReferenceCountedByteBuf(int i4) {
        super(i4);
        this.refCnt = 1;
    }

    protected abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.refCnt;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        int i4;
        do {
            i4 = this.refCnt;
            if (i4 == 0) {
                throw new IllegalReferenceCountException(0, -1);
            }
        } while (!refCntUpdater.compareAndSet(this, i4, i4 - 1));
        if (i4 == 1) {
            deallocate();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRefCnt(int i4) {
        this.refCnt = i4;
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
        int i4;
        int i5;
        do {
            i4 = this.refCnt;
            i5 = i4 + 1;
            if (i5 <= 1) {
                throw new IllegalReferenceCountException(i4, 1);
            }
        } while (!refCntUpdater.compareAndSet(this, i4, i5));
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        int i5;
        if (i4 > 0) {
            do {
                i5 = this.refCnt;
                if (i5 < i4) {
                    throw new IllegalReferenceCountException(i5, -i4);
                }
            } while (!refCntUpdater.compareAndSet(this, i5, i5 - i4));
            if (i5 == i4) {
                deallocate();
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("decrement: " + i4 + " (expected: > 0)");
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i4) {
        int i5;
        int i6;
        if (i4 > 0) {
            do {
                i5 = this.refCnt;
                i6 = i5 + i4;
                if (i6 <= i4) {
                    throw new IllegalReferenceCountException(i5, i4);
                }
            } while (!refCntUpdater.compareAndSet(this, i5, i6));
            return this;
        }
        throw new IllegalArgumentException("increment: " + i4 + " (expected: > 0)");
    }
}
