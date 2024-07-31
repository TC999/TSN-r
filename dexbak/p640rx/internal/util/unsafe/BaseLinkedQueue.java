package p640rx.internal.util.unsafe;

import java.util.Iterator;
import p640rx.internal.util.SuppressAnimalSniffer;
import p640rx.internal.util.atomic.LinkedQueueNode;

@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class BaseLinkedQueue<E> extends AbstractC16066b<E> {

    /* renamed from: I */
    long f46553I;

    /* renamed from: J */
    long f46554J;

    /* renamed from: K */
    long f46555K;

    /* renamed from: L */
    long f46556L;

    /* renamed from: M */
    long f46557M;

    /* renamed from: N */
    long f46558N;

    /* renamed from: O */
    long f46559O;

    /* renamed from: P */
    long f46560P;

    /* renamed from: Q */
    long f46561Q;

    /* renamed from: R */
    long f46562R;

    /* renamed from: S */
    long f46563S;

    /* renamed from: T */
    long f46564T;

    /* renamed from: U */
    long f46565U;

    /* renamed from: V */
    long f46566V;

    /* renamed from: W */
    long f46567W;

    /* renamed from: X */
    long f46568X;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return m801e() == m798b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> m801e = m801e();
        LinkedQueueNode<E> m798b = m798b();
        int i = 0;
        while (m801e != m798b && i < Integer.MAX_VALUE) {
            do {
                lvNext = m801e.lvNext();
            } while (lvNext == null);
            i++;
            m801e = lvNext;
        }
        return i;
    }
}
