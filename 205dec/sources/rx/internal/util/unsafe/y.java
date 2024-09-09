package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class y<E> extends w<E> {
    private volatile long Q0;

    public y(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long o() {
        return this.Q0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(long j4) {
        this.Q0 = j4;
    }
}
