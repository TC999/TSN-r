package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;
import p640rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16066b<E> extends AbstractC16070d<E> {

    /* renamed from: H */
    protected static final long f46571H = UnsafeAccess.m764a(AbstractC16066b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final LinkedQueueNode<E> m802d() {
        return this.consumerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final LinkedQueueNode<E> m801e() {
        return (LinkedQueueNode) UnsafeAccess.f46750a.getObjectVolatile(this, f46571H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final void m800f(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
