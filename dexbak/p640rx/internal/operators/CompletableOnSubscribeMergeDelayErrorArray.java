package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Completable[] f45652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeMergeDelayErrorArray.java */
    /* renamed from: rx.internal.operators.p$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15821a implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f45653a;

        /* renamed from: b */
        final /* synthetic */ Queue f45654b;

        /* renamed from: c */
        final /* synthetic */ AtomicInteger f45655c;

        /* renamed from: d */
        final /* synthetic */ CompletableSubscriber f45656d;

        C15821a(CompositeSubscription compositeSubscription, Queue queue, AtomicInteger atomicInteger, CompletableSubscriber completableSubscriber) {
            this.f45653a = compositeSubscription;
            this.f45654b = queue;
            this.f45655c = atomicInteger;
            this.f45656d = completableSubscriber;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45653a.m359a(subscription);
        }

        /* renamed from: b */
        void m1133b() {
            if (this.f45655c.decrementAndGet() == 0) {
                if (this.f45654b.isEmpty()) {
                    this.f45656d.onCompleted();
                } else {
                    this.f45656d.onError(CompletableOnSubscribeMerge.m1156a(this.f45654b));
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            m1133b();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45654b.offer(th);
            m1133b();
        }
    }

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] completableArr) {
        this.f45652a = completableArr;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        Completable[] completableArr;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        AtomicInteger atomicInteger = new AtomicInteger(this.f45652a.length + 1);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        completableSubscriber.mo640a(compositeSubscription);
        for (Completable completable : this.f45652a) {
            if (compositeSubscription.isUnsubscribed()) {
                return;
            }
            if (completable == null) {
                concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completable.m1967G0(new C15821a(compositeSubscription, concurrentLinkedQueue, atomicInteger, completableSubscriber));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (concurrentLinkedQueue.isEmpty()) {
                completableSubscriber.onCompleted();
            } else {
                completableSubscriber.onError(CompletableOnSubscribeMerge.m1156a(concurrentLinkedQueue));
            }
        }
    }
}
