package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC16085s<E> extends AbstractC16087u<E> {

    /* renamed from: A0 */
    protected static final long f46752A0 = UnsafeAccess.m764a(AbstractC16085s.class, "consumerIndex");
    private volatile long consumerIndex;

    public AbstractC16085s(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public final boolean m755m(long j, long j2) {
        return UnsafeAccess.f46750a.compareAndSwapLong(this, f46752A0, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final long m754n() {
        return this.consumerIndex;
    }
}
