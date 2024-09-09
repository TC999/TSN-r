package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class f0<E> extends c0<E> {
    protected static final long O = n0.a(f0.class, "producerIndex");
    protected long N;
    protected long producerIndex;

    public f0(int i4) {
        super(i4);
    }
}
