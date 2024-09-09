package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class a<E> extends b<E> {
    long I;
    long J;
    long K;

    /* renamed from: L  reason: collision with root package name */
    long f63984L;
    long M;
    long N;
    long O;
    long P;
    long Q;
    long R;
    long S;
    long T;
    long U;
    long V;
    long W;
    long X;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return e() == b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> e4 = e();
        LinkedQueueNode<E> b4 = b();
        int i4 = 0;
        while (e4 != b4 && i4 < Integer.MAX_VALUE) {
            do {
                lvNext = e4.lvNext();
            } while (lvNext == null);
            i4++;
            e4 = lvNext;
        }
        return i4;
    }
}
