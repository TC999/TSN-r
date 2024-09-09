package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class k<E> extends m<E> {
    private static final long D0 = n0.a(k.class, "consumerIndex");
    private volatile long consumerIndex;

    public k(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean p(long j4, long j5) {
        return n0.f64070a.compareAndSwapLong(this, D0, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long q() {
        return this.consumerIndex;
    }
}
