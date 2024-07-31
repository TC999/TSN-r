package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16090x<E> extends AbstractC16086t<E> {

    /* renamed from: L */
    protected static final long f46813L = UnsafeAccess.m764a(AbstractC16090x.class, "producerIndex");
    private volatile long producerIndex;

    public AbstractC16090x(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public final long m753k() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final void m752l(long j) {
        UnsafeAccess.f46750a.putOrderedLong(this, f46813L, j);
    }
}
