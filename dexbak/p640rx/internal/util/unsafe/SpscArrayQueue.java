package p640rx.internal.util.unsafe;

/* renamed from: rx.internal.util.unsafe.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class SpscArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {

    /* renamed from: x */
    private static final Integer f46569x = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: w */
    protected final int f46570w;

    public SpscArrayQueue(int i) {
        super(i);
        this.f46570w = Math.min(i / 4, f46569x.intValue());
    }
}
