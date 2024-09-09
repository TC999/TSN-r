package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class e<E> extends c<E> {

    /* renamed from: q  reason: collision with root package name */
    protected static final long f64016q = n0.a(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    protected final LinkedQueueNode<E> a() {
        return this.producerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> b() {
        return (LinkedQueueNode) n0.f64070a.getObjectVolatile(this, f64016q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
