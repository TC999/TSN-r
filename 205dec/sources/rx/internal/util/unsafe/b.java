package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class b<E> extends d<E> {
    protected static final long H = n0.a(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> d() {
        return this.consumerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> e() {
        return (LinkedQueueNode) n0.f64070a.getObjectVolatile(this, H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
