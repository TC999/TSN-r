package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {

    /* renamed from: x */
    private static final long f46675x;

    /* renamed from: y */
    private static final int f46676y;

    /* renamed from: w */
    protected final long[] f46677w;

    static {
        Unsafe unsafe = UnsafeAccess.f46750a;
        if (8 == unsafe.arrayIndexScale(long[].class)) {
            int i = ConcurrentCircularArrayQueue.f46651s;
            int i2 = i + 3;
            f46676y = i2;
            f46675x = unsafe.arrayBaseOffset(long[].class) + (32 << (i2 - i));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        int i2 = (int) (this.f46655q + 1);
        this.f46677w = new long[(i2 << ConcurrentCircularArrayQueue.f46651s) + 64];
        for (long j = 0; j < i2; j++) {
            m784m(this.f46677w, m786k(j), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public final long m786k(long j) {
        return f46675x + ((j & this.f46655q) << f46676y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final long m785l(long[] jArr, long j) {
        return UnsafeAccess.f46750a.getLongVolatile(jArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public final void m784m(long[] jArr, long j, long j2) {
        UnsafeAccess.f46750a.putOrderedLong(jArr, j, j2);
    }
}
