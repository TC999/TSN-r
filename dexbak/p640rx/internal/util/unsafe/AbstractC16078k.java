package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: MpmcArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16078k<E> extends AbstractC16082m<E> {

    /* renamed from: D0 */
    private static final long f46701D0 = UnsafeAccess.m764a(AbstractC16078k.class, "consumerIndex");
    private volatile long consumerIndex;

    public AbstractC16078k(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final boolean m768p(long j, long j2) {
        return UnsafeAccess.f46750a.compareAndSwapLong(this, f46701D0, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q */
    public final long m767q() {
        return this.consumerIndex;
    }
}
