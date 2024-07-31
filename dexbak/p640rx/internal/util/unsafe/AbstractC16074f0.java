package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16074f0<E> extends AbstractC16069c0<E> {

    /* renamed from: O */
    protected static final long f46657O = UnsafeAccess.m764a(AbstractC16074f0.class, "producerIndex");

    /* renamed from: N */
    protected long f46658N;
    protected long producerIndex;

    public AbstractC16074f0(int i) {
        super(i);
    }
}
