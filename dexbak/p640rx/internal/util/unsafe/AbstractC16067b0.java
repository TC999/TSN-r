package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16067b0<E> extends AbstractC16071d0<E> {

    /* renamed from: D0 */
    protected static final long f46572D0 = UnsafeAccess.m764a(AbstractC16067b0.class, "consumerIndex");
    protected long consumerIndex;

    public AbstractC16067b0(int i) {
        super(i);
    }
}
