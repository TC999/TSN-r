package p640rx.internal.util.unsafe;

/* renamed from: rx.internal.util.unsafe.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface MessagePassingQueue<M> {
    boolean isEmpty();

    boolean offer(M m);

    M peek();

    M poll();

    int size();
}
