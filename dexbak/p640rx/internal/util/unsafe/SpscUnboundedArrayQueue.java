package p640rx.internal.util.unsafe;

import java.util.Iterator;
import p640rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.h0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SpscUnboundedArrayQueue<E> extends AbstractC16077j0<E> implements QueueProgressIndicators {

    /* renamed from: u */
    private static final long f46679u;

    /* renamed from: v */
    private static final long f46680v;

    /* renamed from: w */
    private static final long f46681w;

    /* renamed from: x */
    private static final int f46682x;

    /* renamed from: t */
    static final int f46678t = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: y */
    private static final Object f46683y = new Object();

    static {
        Unsafe unsafe = UnsafeAccess.f46750a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f46682x = 2;
        } else if (8 == arrayIndexScale) {
            f46682x = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f46681w = unsafe.arrayBaseOffset(Object[].class);
        try {
            f46679u = unsafe.objectFieldOffset(AbstractC16083m0.class.getDeclaredField("producerIndex"));
            try {
                f46680v = unsafe.objectFieldOffset(AbstractC16077j0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public SpscUnboundedArrayQueue(int i) {
        int m756b = Pow2.m756b(i);
        long j = m756b - 1;
        E[] eArr = (E[]) new Object[m756b + 1];
        this.f46733d = eArr;
        this.f46732c = j;
        m783a(m756b);
        this.f46685s = eArr;
        this.f46684r = j;
        this.f46731b = j - 1;
        m770n(0L);
    }

    /* renamed from: a */
    private void m783a(int i) {
        this.f46730a = Math.min(i / 4, f46678t);
    }

    /* renamed from: b */
    private static long m782b(long j) {
        return f46681w + (j << f46682x);
    }

    /* renamed from: c */
    private static long m781c(long j, long j2) {
        return m782b(j & j2);
    }

    /* renamed from: d */
    private long m780d() {
        return UnsafeAccess.f46750a.getLongVolatile(this, f46680v);
    }

    /* renamed from: e */
    private static <E> Object m779e(E[] eArr, long j) {
        return UnsafeAccess.f46750a.getObjectVolatile(eArr, j);
    }

    /* renamed from: f */
    private E[] m778f(E[] eArr) {
        return (E[]) ((Object[]) m779e(eArr, m782b(eArr.length - 1)));
    }

    /* renamed from: g */
    private long m777g() {
        return UnsafeAccess.f46750a.getLongVolatile(this, f46679u);
    }

    /* renamed from: h */
    private E m776h(E[] eArr, long j, long j2) {
        this.f46685s = eArr;
        return (E) m779e(eArr, m781c(j, j2));
    }

    /* renamed from: i */
    private E m775i(E[] eArr, long j, long j2) {
        this.f46685s = eArr;
        long m781c = m781c(j, j2);
        E e = (E) m779e(eArr, m781c);
        if (e == null) {
            return null;
        }
        m772l(eArr, m781c, null);
        m773k(j + 1);
        return e;
    }

    /* renamed from: j */
    private void m774j(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f46733d = eArr2;
        this.f46731b = (j3 + j) - 1;
        m772l(eArr2, j2, e);
        m771m(eArr, eArr2);
        m772l(eArr, j2, f46683y);
        m770n(j + 1);
    }

    /* renamed from: k */
    private void m773k(long j) {
        UnsafeAccess.f46750a.putOrderedLong(this, f46680v, j);
    }

    /* renamed from: l */
    private static void m772l(Object[] objArr, long j, Object obj) {
        UnsafeAccess.f46750a.putOrderedObject(objArr, j, obj);
    }

    /* renamed from: m */
    private void m771m(E[] eArr, E[] eArr2) {
        m772l(eArr, m782b(eArr.length - 1), eArr2);
    }

    /* renamed from: n */
    private void m770n(long j) {
        UnsafeAccess.f46750a.putOrderedLong(this, f46679u, j);
    }

    /* renamed from: o */
    private boolean m769o(E[] eArr, E e, long j, long j2) {
        m772l(eArr, j2, e);
        m770n(j + 1);
        return true;
    }

    @Override // p640rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        return m780d();
    }

    @Override // p640rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        return m777g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f46733d;
            long j = this.producerIndex;
            long j2 = this.f46732c;
            long m781c = m781c(j, j2);
            if (j < this.f46731b) {
                return m769o(eArr, e, j, m781c);
            }
            long j3 = this.f46730a + j;
            if (m779e(eArr, m781c(j3, j2)) == null) {
                this.f46731b = j3 - 1;
                return m769o(eArr, e, j, m781c);
            } else if (m779e(eArr, m781c(1 + j, j2)) != null) {
                return m769o(eArr, e, j, m781c);
            } else {
                m774j(eArr, j, m781c, e, j2);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.f46685s;
        long j = this.consumerIndex;
        long j2 = this.f46684r;
        E e = (E) m779e(eArr, m781c(j, j2));
        return e == f46683y ? m776h(m778f(eArr), j, j2) : e;
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.f46685s;
        long j = this.consumerIndex;
        long j2 = this.f46684r;
        long m781c = m781c(j, j2);
        E e = (E) m779e(eArr, m781c);
        boolean z = e == f46683y;
        if (e == null || z) {
            if (z) {
                return m775i(m778f(eArr), j, j2);
            }
            return null;
        }
        m772l(eArr, m781c, null);
        m773k(j + 1);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long m780d = m780d();
        while (true) {
            long m777g = m777g();
            long m780d2 = m780d();
            if (m780d == m780d2) {
                return (int) (m777g - m780d2);
            }
            m780d = m780d2;
        }
    }
}
