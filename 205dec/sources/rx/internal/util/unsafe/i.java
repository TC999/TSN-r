package rx.internal.util.unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MessagePassingQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public interface i<M> {
    boolean isEmpty();

    boolean offer(M m4);

    M peek();

    M poll();

    int size();
}
