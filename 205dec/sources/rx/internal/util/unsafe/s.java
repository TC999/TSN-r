package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class s<E> extends u<E> {
    protected static final long A0 = n0.a(s.class, "consumerIndex");
    private volatile long consumerIndex;

    public s(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean m(long j4, long j5) {
        return n0.f64070a.compareAndSwapLong(this, A0, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long n() {
        return this.consumerIndex;
    }
}
