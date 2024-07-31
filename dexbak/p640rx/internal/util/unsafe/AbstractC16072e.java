package p640rx.internal.util.unsafe;

import p640rx.internal.util.SuppressAnimalSniffer;
import p640rx.internal.util.atomic.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
@SuppressAnimalSniffer
/* renamed from: rx.internal.util.unsafe.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AbstractC16072e<E> extends AbstractC16068c<E> {

    /* renamed from: q */
    protected static final long f46635q = UnsafeAccess.m764a(AbstractC16072e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    /* renamed from: a */
    protected final LinkedQueueNode<E> m799a() {
        return this.producerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final LinkedQueueNode<E> m798b() {
        return (LinkedQueueNode) UnsafeAccess.f46750a.getObjectVolatile(this, f46635q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m797c(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
