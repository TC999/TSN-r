package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class x<E> extends t<E> {

    /* renamed from: L  reason: collision with root package name */
    protected static final long f64083L = n0.a(x.class, "producerIndex");
    private volatile long producerIndex;

    public x(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long k() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(long j4) {
        n0.f64070a.putOrderedLong(this, f64083L, j4);
    }
}
