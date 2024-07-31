package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;

/* compiled from: SpscArrayQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C16092z<E> extends AbstractC16073e0<E> {
    public C16092z(int i) {
        super(i);
    }

    /* renamed from: k */
    private long m749k() {
        return UnsafeAccess.f46750a.getLongVolatile(this, AbstractC16067b0.f46572D0);
    }

    /* renamed from: l */
    private long m748l() {
        return UnsafeAccess.f46750a.getLongVolatile(this, AbstractC16074f0.f46657O);
    }

    /* renamed from: m */
    private void m747m(long j) {
        UnsafeAccess.f46750a.putOrderedLong(this, AbstractC16067b0.f46572D0, j);
    }

    /* renamed from: n */
    private void m746n(long j) {
        UnsafeAccess.f46750a.putOrderedLong(this, AbstractC16074f0.f46657O, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return m748l() == m749k();
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f46656r;
            long j = this.producerIndex;
            long m796a = m796a(j);
            if (m791f(eArr, m796a) != null) {
                return false;
            }
            m789h(eArr, m796a, e);
            m746n(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        return m792e(m796a(this.consumerIndex));
    }

    @Override // java.util.Queue, p640rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long j = this.consumerIndex;
        long m796a = m796a(j);
        E[] eArr = this.f46656r;
        E m791f = m791f(eArr, m796a);
        if (m791f == null) {
            return null;
        }
        m789h(eArr, m796a, null);
        m747m(j + 1);
        return m791f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p640rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long m749k = m749k();
        while (true) {
            long m748l = m748l();
            long m749k2 = m749k();
            if (m749k == m749k2) {
                return (int) (m748l - m749k2);
            }
            m749k = m749k2;
        }
    }
}
