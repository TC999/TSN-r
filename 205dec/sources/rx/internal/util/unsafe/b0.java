package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class b0<E> extends d0<E> {
    protected static final long D0 = n0.a(b0.class, "consumerIndex");
    protected long consumerIndex;

    public b0(int i4) {
        super(i4);
    }
}
