package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MpmcArrayQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class j<E> extends k<E> {
    long E0;
    long F0;
    long G0;
    long H0;
    long I0;
    long J0;
    long K0;
    long L0;
    long M0;
    long N0;
    long O0;
    long P0;
    long Q0;
    long R0;
    long S0;

    public j(int i4) {
        super(Math.max(2, i4));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public boolean isEmpty() {
        return q() == o();
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public boolean offer(E e4) {
        if (e4 != null) {
            long j4 = this.f64021q + 1;
            long[] jArr = this.f64041w;
            long j5 = Long.MAX_VALUE;
            while (true) {
                long o4 = o();
                long k4 = k(o4);
                long l4 = l(jArr, k4) - o4;
                if (l4 == 0) {
                    long j6 = o4 + 1;
                    if (n(o4, j6)) {
                        i(a(o4), e4);
                        m(jArr, k4, j6);
                        return true;
                    }
                } else if (l4 < 0) {
                    long j7 = o4 - j4;
                    if (j7 <= j5) {
                        j5 = q();
                        if (j7 <= j5) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E peek() {
        long q3;
        E c4;
        do {
            q3 = q();
            c4 = c(a(q3));
            if (c4 != null) {
                break;
            }
        } while (q3 != o());
        return c4;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.i
    public E poll() {
        long[] jArr = this.f64041w;
        long j4 = -1;
        while (true) {
            long q3 = q();
            long k4 = k(q3);
            long j5 = q3 + 1;
            long l4 = l(jArr, k4) - j5;
            if (l4 == 0) {
                if (p(q3, j5)) {
                    long a4 = a(q3);
                    E c4 = c(a4);
                    i(a4, null);
                    m(jArr, k4, q3 + this.f64021q + 1);
                    return c4;
                }
            } else if (l4 < 0 && q3 >= j4) {
                j4 = o();
                if (q3 == j4) {
                    return null;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.i
    public int size() {
        long q3 = q();
        while (true) {
            long o4 = o();
            long q4 = q();
            if (q3 == q4) {
                return (int) (o4 - q4);
            }
            q3 = q4;
        }
    }
}
