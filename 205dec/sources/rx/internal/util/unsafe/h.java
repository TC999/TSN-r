package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ConcurrentSequencedCircularArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class h<E> extends f<E> {

    /* renamed from: x  reason: collision with root package name */
    private static final long f64039x;

    /* renamed from: y  reason: collision with root package name */
    private static final int f64040y;

    /* renamed from: w  reason: collision with root package name */
    protected final long[] f64041w;

    static {
        Unsafe unsafe = n0.f64070a;
        if (8 == unsafe.arrayIndexScale(long[].class)) {
            int i4 = f.f64017s;
            int i5 = i4 + 3;
            f64040y = i5;
            f64039x = unsafe.arrayBaseOffset(long[].class) + (32 << (i5 - i4));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public h(int i4) {
        super(i4);
        int i5 = (int) (this.f64021q + 1);
        this.f64041w = new long[(i5 << f.f64017s) + 64];
        for (long j4 = 0; j4 < i5; j4++) {
            m(this.f64041w, k(j4), j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long k(long j4) {
        return f64039x + ((j4 & this.f64021q) << f64040y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long l(long[] jArr, long j4) {
        return n0.f64070a.getLongVolatile(jArr, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(long[] jArr, long j4, long j5) {
        n0.f64070a.putOrderedLong(jArr, j4, j5);
    }
}
