package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ConcurrentCircularArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: s  reason: collision with root package name */
    protected static final int f64017s;

    /* renamed from: t  reason: collision with root package name */
    protected static final int f64018t = 32;

    /* renamed from: u  reason: collision with root package name */
    private static final long f64019u;

    /* renamed from: v  reason: collision with root package name */
    private static final int f64020v;

    /* renamed from: q  reason: collision with root package name */
    protected final long f64021q;

    /* renamed from: r  reason: collision with root package name */
    protected final E[] f64022r;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f64017s = intValue;
        Unsafe unsafe = n0.f64070a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f64020v = intValue + 2;
        } else if (8 == arrayIndexScale) {
            f64020v = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f64019u = unsafe.arrayBaseOffset(Object[].class) + (32 << (f64020v - intValue));
    }

    public f(int i4) {
        int b4 = p.b(i4);
        this.f64021q = b4 - 1;
        this.f64022r = (E[]) new Object[(b4 << f64017s) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long a(long j4) {
        return b(j4, this.f64021q);
    }

    protected final long b(long j4, long j5) {
        return f64019u + ((j4 & j5) << f64020v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E c(long j4) {
        return d(this.f64022r, j4);
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
    public final E d(E[] eArr, long j4) {
        return (E) n0.f64070a.getObject(eArr, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E e(long j4) {
        return f(this.f64022r, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E f(E[] eArr, long j4) {
        return (E) n0.f64070a.getObjectVolatile(eArr, j4);
    }

    protected final void g(long j4, E e4) {
        h(this.f64022r, j4, e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(E[] eArr, long j4, E e4) {
        n0.f64070a.putOrderedObject(eArr, j4, e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(long j4, E e4) {
        j(this.f64022r, j4, e4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(E[] eArr, long j4, E e4) {
        n0.f64070a.putObject(eArr, j4, e4);
    }
}
