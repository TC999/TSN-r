package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscUnboundedArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class h0<E> extends j0<E> implements q {

    /* renamed from: u  reason: collision with root package name */
    private static final long f64043u;

    /* renamed from: v  reason: collision with root package name */
    private static final long f64044v;

    /* renamed from: w  reason: collision with root package name */
    private static final long f64045w;

    /* renamed from: x  reason: collision with root package name */
    private static final int f64046x;

    /* renamed from: t  reason: collision with root package name */
    static final int f64042t = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: y  reason: collision with root package name */
    private static final Object f64047y = new Object();

    static {
        Unsafe unsafe = n0.f64070a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f64046x = 2;
        } else if (8 == arrayIndexScale) {
            f64046x = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f64045w = unsafe.arrayBaseOffset(Object[].class);
        try {
            f64043u = unsafe.objectFieldOffset(m0.class.getDeclaredField("producerIndex"));
            try {
                f64044v = unsafe.objectFieldOffset(j0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e4) {
                InternalError internalError = new InternalError();
                internalError.initCause(e4);
                throw internalError;
            }
        } catch (NoSuchFieldException e5) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e5);
            throw internalError2;
        }
    }

    public h0(int i4) {
        int b4 = p.b(i4);
        long j4 = b4 - 1;
        E[] eArr = (E[]) new Object[b4 + 1];
        this.f64068d = eArr;
        this.f64067c = j4;
        a(b4);
        this.f64049s = eArr;
        this.f64048r = j4;
        this.f64066b = j4 - 1;
        n(0L);
    }

    private void a(int i4) {
        this.f64065a = Math.min(i4 / 4, f64042t);
    }

    private static long b(long j4) {
        return f64045w + (j4 << f64046x);
    }

    private static long c(long j4, long j5) {
        return b(j4 & j5);
    }

    private long d() {
        return n0.f64070a.getLongVolatile(this, f64044v);
    }

    private static <E> Object e(E[] eArr, long j4) {
        return n0.f64070a.getObjectVolatile(eArr, j4);
    }

    private E[] f(E[] eArr) {
        return (E[]) ((Object[]) e(eArr, b(eArr.length - 1)));
    }

    private long g() {
        return n0.f64070a.getLongVolatile(this, f64043u);
    }

    private E h(E[] eArr, long j4, long j5) {
        this.f64049s = eArr;
        return (E) e(eArr, c(j4, j5));
    }

    private E i(E[] eArr, long j4, long j5) {
        this.f64049s = eArr;
        long c4 = c(j4, j5);
        E e4 = (E) e(eArr, c4);
        if (e4 == null) {
            return null;
        }
        l(eArr, c4, null);
        k(j4 + 1);
        return e4;
    }

    private void j(E[] eArr, long j4, long j5, E e4, long j6) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f64068d = eArr2;
        this.f64066b = (j6 + j4) - 1;
        l(eArr2, j5, e4);
        m(eArr, eArr2);
        l(eArr, j5, f64047y);
        n(j4 + 1);
    }

    private void k(long j4) {
        n0.f64070a.putOrderedLong(this, f64044v, j4);
    }

    private static void l(Object[] objArr, long j4, Object obj) {
        n0.f64070a.putOrderedObject(objArr, j4, obj);
    }

    private void m(E[] eArr, E[] eArr2) {
        l(eArr, b(eArr.length - 1), eArr2);
    }

    private void n(long j4) {
        n0.f64070a.putOrderedLong(this, f64043u, j4);
    }

    private boolean o(E[] eArr, E e4, long j4, long j5) {
        l(eArr, j5, e4);
        n(j4 + 1);
        return true;
    }

    @Override // rx.internal.util.unsafe.q
    public long currentConsumerIndex() {
        return d();
    }

    @Override // rx.internal.util.unsafe.q
    public long currentProducerIndex() {
        return g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e4) {
        if (e4 != null) {
            E[] eArr = this.f64068d;
            long j4 = this.producerIndex;
            long j5 = this.f64067c;
            long c4 = c(j4, j5);
            if (j4 < this.f64066b) {
                return o(eArr, e4, j4, c4);
            }
            long j6 = this.f64065a + j4;
            if (e(eArr, c(j6, j5)) == null) {
                this.f64066b = j6 - 1;
                return o(eArr, e4, j4, c4);
            } else if (e(eArr, c(1 + j4, j5)) != null) {
                return o(eArr, e4, j4, c4);
            } else {
                j(eArr, j4, c4, e4, j5);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.f64049s;
        long j4 = this.consumerIndex;
        long j5 = this.f64048r;
        E e4 = (E) e(eArr, c(j4, j5));
        return e4 == f64047y ? h(f(eArr), j4, j5) : e4;
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.f64049s;
        long j4 = this.consumerIndex;
        long j5 = this.f64048r;
        long c4 = c(j4, j5);
        E e4 = (E) e(eArr, c4);
        boolean z3 = e4 == f64047y;
        if (e4 == null || z3) {
            if (z3) {
                return i(f(eArr), j4, j5);
            }
            return null;
        }
        l(eArr, c4, null);
        k(j4 + 1);
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long d4 = d();
        while (true) {
            long g4 = g();
            long d5 = d();
            if (d4 == d5) {
                return (int) (g4 - d5);
            }
            d4 = d5;
        }
    }
}
