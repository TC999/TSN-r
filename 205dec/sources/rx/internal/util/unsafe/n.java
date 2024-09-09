package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class n<E> extends l<E> {
    private static final long O = n0.a(n.class, "producerIndex");
    private volatile long producerIndex;

    public n(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n(long j4, long j5) {
        return n0.f64070a.compareAndSwapLong(this, O, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long o() {
        return this.producerIndex;
    }
}
