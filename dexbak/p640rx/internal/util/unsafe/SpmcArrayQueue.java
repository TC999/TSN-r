package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpmcArrayQueue<E> extends AbstractC16088v<E> {
    public SpmcArrayQueue(int i) {
        super(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return m754n() == m753k();
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f46656r;
            long j = this.f46655q;
            long m753k = m753k();
            long m796a = m796a(m753k);
            if (m791f(eArr, m796a) != null) {
                if (m753k - m754n() > j) {
                    return false;
                }
                do {
                } while (m791f(eArr, m796a) != null);
                m787j(eArr, m796a, e);
                m752l(m753k + 1);
                return true;
            }
            m787j(eArr, m796a, e);
            m752l(m753k + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        E m792e;
        long m751o = m751o();
        do {
            long m754n = m754n();
            if (m754n >= m751o) {
                long m753k = m753k();
                if (m754n >= m753k) {
                    return null;
                }
                m750p(m753k);
            }
            m792e = m792e(m796a(m754n));
        } while (m792e == null);
        return m792e;
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long m754n;
        long m751o = m751o();
        do {
            m754n = m754n();
            if (m754n >= m751o) {
                long m753k = m753k();
                if (m754n >= m753k) {
                    return null;
                }
                m750p(m753k);
            }
        } while (!m755m(m754n, 1 + m754n));
        long m796a = m796a(m754n);
        E[] eArr = this.f46656r;
        E m793d = m793d(eArr, m796a);
        m789h(eArr, m796a, null);
        return m793d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long m754n = m754n();
        while (true) {
            long m753k = m753k();
            long m754n2 = m754n();
            if (m754n == m754n2) {
                return (int) (m753k - m754n2);
            }
            m754n = m754n2;
        }
    }
}
