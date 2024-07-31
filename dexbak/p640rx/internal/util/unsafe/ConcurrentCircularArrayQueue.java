package p640rx.internal.util.unsafe;

import java.util.Iterator;
import p640rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends AbstractC16075g<E> {

    /* renamed from: s */
    protected static final int f46651s;

    /* renamed from: t */
    protected static final int f46652t = 32;

    /* renamed from: u */
    private static final long f46653u;

    /* renamed from: v */
    private static final int f46654v;

    /* renamed from: q */
    protected final long f46655q;

    /* renamed from: r */
    protected final E[] f46656r;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f46651s = intValue;
        Unsafe unsafe = UnsafeAccess.f46750a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f46654v = intValue + 2;
        } else if (8 == arrayIndexScale) {
            f46654v = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f46653u = unsafe.arrayBaseOffset(Object[].class) + (32 << (f46654v - intValue));
    }

    public ConcurrentCircularArrayQueue(int i) {
        int m756b = Pow2.m756b(i);
        this.f46655q = m756b - 1;
        this.f46656r = (E[]) new Object[(m756b << f46651s) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final long m796a(long j) {
        return m795b(j, this.f46655q);
    }

    /* renamed from: b */
    protected final long m795b(long j, long j2) {
        return f46653u + ((j & j2) << f46654v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final E m794c(long j) {
        return m793d(this.f46656r, j);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final E m793d(E[] eArr, long j) {
        return (E) UnsafeAccess.f46750a.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final E m792e(long j) {
        return m791f(this.f46656r, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final E m791f(E[] eArr, long j) {
        return (E) UnsafeAccess.f46750a.getObjectVolatile(eArr, j);
    }

    /* renamed from: g */
    protected final void m790g(long j, E e) {
        m789h(this.f46656r, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final void m789h(E[] eArr, long j, E e) {
        UnsafeAccess.f46750a.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public final void m788i(long j, E e) {
        m787j(this.f46656r, j, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final void m787j(E[] eArr, long j, E e) {
        UnsafeAccess.f46750a.putObject(eArr, j, e);
    }
}
