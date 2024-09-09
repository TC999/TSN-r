package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class r<E> extends v<E> {
    public r(int i4) {
        super(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        return n() == k();
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e4) {
        if (e4 != null) {
            E[] eArr = this.f64022r;
            long j4 = this.f64021q;
            long k4 = k();
            long a4 = a(k4);
            if (f(eArr, a4) != null) {
                if (k4 - n() > j4) {
                    return false;
                }
                do {
                } while (f(eArr, a4) != null);
                j(eArr, a4, e4);
                l(k4 + 1);
                return true;
            }
            j(eArr, a4, e4);
            l(k4 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        E e4;
        long o4 = o();
        do {
            long n4 = n();
            if (n4 >= o4) {
                long k4 = k();
                if (n4 >= k4) {
                    return null;
                }
                p(k4);
            }
            e4 = e(a(n4));
        } while (e4 == null);
        return e4;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        long n4;
        long o4 = o();
        do {
            n4 = n();
            if (n4 >= o4) {
                long k4 = k();
                if (n4 >= k4) {
                    return null;
                }
                p(k4);
            }
        } while (!m(n4, 1 + n4));
        long a4 = a(n4);
        E[] eArr = this.f64022r;
        E d4 = d(eArr, a4);
        h(eArr, a4, null);
        return d4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long n4 = n();
        while (true) {
            long k4 = k();
            long n5 = n();
            if (n4 == n5) {
                return (int) (k4 - n5);
            }
            n4 = n5;
        }
    }
}
