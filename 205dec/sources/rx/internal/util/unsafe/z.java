package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class z<E> extends e0<E> {
    public z(int i4) {
        super(i4);
    }

    private long k() {
        return n0.f64070a.getLongVolatile(this, b0.D0);
    }

    private long l() {
        return n0.f64070a.getLongVolatile(this, f0.O);
    }

    private void m(long j4) {
        n0.f64070a.putOrderedLong(this, b0.D0, j4);
    }

    private void n(long j4) {
        n0.f64070a.putOrderedLong(this, f0.O, j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        return l() == k();
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e4) {
        if (e4 != null) {
            E[] eArr = this.f64022r;
            long j4 = this.producerIndex;
            long a4 = a(j4);
            if (f(eArr, a4) != null) {
                return false;
            }
            h(eArr, a4, e4);
            n(j4 + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        return e(a(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        long j4 = this.consumerIndex;
        long a4 = a(j4);
        E[] eArr = this.f64022r;
        E f4 = f(eArr, a4);
        if (f4 == null) {
            return null;
        }
        h(eArr, a4, null);
        m(j4 + 1);
        return f4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long k4 = k();
        while (true) {
            long l4 = l();
            long k5 = k();
            if (k4 == k5) {
                return (int) (l4 - k5);
            }
            k4 = k5;
        }
    }
}
