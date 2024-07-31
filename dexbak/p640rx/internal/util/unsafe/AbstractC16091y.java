package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16091y<E> extends AbstractC16089w<E> {

    /* renamed from: Q0 */
    private volatile long f46814Q0;

    public AbstractC16091y(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public final long m751o() {
        return this.f46814Q0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final void m750p(long j) {
        this.f46814Q0 = j;
    }
}
