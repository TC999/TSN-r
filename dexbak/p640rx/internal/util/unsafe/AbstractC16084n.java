package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: MpmcArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16084n<E> extends AbstractC16080l<E> {

    /* renamed from: O */
    private static final long f46749O = UnsafeAccess.m764a(AbstractC16084n.class, "producerIndex");
    private volatile long producerIndex;

    public AbstractC16084n(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final boolean m766n(long j, long j2) {
        return UnsafeAccess.f46750a.compareAndSwapLong(this, f46749O, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public final long m765o() {
        return this.producerIndex;
    }
}
