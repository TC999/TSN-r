package rx.internal.util.unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscArrayQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class a0<E> extends f<E> {

    /* renamed from: x  reason: collision with root package name */
    private static final Integer f63985x = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: w  reason: collision with root package name */
    protected final int f63986w;

    public a0(int i4) {
        super(i4);
        this.f63986w = Math.min(i4 / 4, f63985x.intValue());
    }
}
