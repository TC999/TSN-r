package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MpmcArrayQueue<E> extends AbstractC16078k<E> {

    /* renamed from: E0 */
    long f46686E0;

    /* renamed from: F0 */
    long f46687F0;

    /* renamed from: G0 */
    long f46688G0;

    /* renamed from: H0 */
    long f46689H0;

    /* renamed from: I0 */
    long f46690I0;

    /* renamed from: J0 */
    long f46691J0;

    /* renamed from: K0 */
    long f46692K0;

    /* renamed from: L0 */
    long f46693L0;

    /* renamed from: M0 */
    long f46694M0;

    /* renamed from: N0 */
    long f46695N0;

    /* renamed from: O0 */
    long f46696O0;

    /* renamed from: P0 */
    long f46697P0;

    /* renamed from: Q0 */
    long f46698Q0;

    /* renamed from: R0 */
    long f46699R0;

    /* renamed from: S0 */
    long f46700S0;

    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return m767q() == m765o();
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        if (e != null) {
            long j = this.f46655q + 1;
            long[] jArr = this.f46677w;
            long j2 = Long.MAX_VALUE;
            while (true) {
                long m765o = m765o();
                long m786k = m786k(m765o);
                long m785l = m785l(jArr, m786k) - m765o;
                if (m785l == 0) {
                    long j3 = m765o + 1;
                    if (m766n(m765o, j3)) {
                        m788i(m796a(m765o), e);
                        m784m(jArr, m786k, j3);
                        return true;
                    }
                } else if (m785l < 0) {
                    long j4 = m765o - j;
                    if (j4 <= j2) {
                        j2 = m767q();
                        if (j4 <= j2) {
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

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        long m767q;
        E m794c;
        do {
            m767q = m767q();
            m794c = m794c(m796a(m767q));
            if (m794c != null) {
                break;
            }
        } while (m767q != m765o());
        return m794c;
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long[] jArr = this.f46677w;
        long j = -1;
        while (true) {
            long m767q = m767q();
            long m786k = m786k(m767q);
            long j2 = m767q + 1;
            long m785l = m785l(jArr, m786k) - j2;
            if (m785l == 0) {
                if (m768p(m767q, j2)) {
                    long m796a = m796a(m767q);
                    E m794c = m794c(m796a);
                    m788i(m796a, null);
                    m784m(jArr, m786k, m767q + this.f46655q + 1);
                    return m794c;
                }
            } else if (m785l < 0 && m767q >= j) {
                j = m765o();
                if (m767q == j) {
                    return null;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long m767q = m767q();
        while (true) {
            long m765o = m765o();
            long m767q2 = m767q();
            if (m767q == m767q2) {
                return (int) (m765o - m767q2);
            }
            m767q = m767q2;
        }
    }
}
