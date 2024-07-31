package p640rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.internal.util.atomic.MpscLinkedAtomicQueue;
import p640rx.internal.util.unsafe.MpscLinkedQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeMergeDelayErrorIterable implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Iterable<? extends Completable> f45719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeMergeDelayErrorIterable.java */
    /* renamed from: rx.internal.operators.q$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15838a implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f45720a;

        /* renamed from: b */
        final /* synthetic */ Queue f45721b;

        /* renamed from: c */
        final /* synthetic */ AtomicInteger f45722c;

        /* renamed from: d */
        final /* synthetic */ CompletableSubscriber f45723d;

        C15838a(CompositeSubscription compositeSubscription, Queue queue, AtomicInteger atomicInteger, CompletableSubscriber completableSubscriber) {
            this.f45720a = compositeSubscription;
            this.f45721b = queue;
            this.f45722c = atomicInteger;
            this.f45723d = completableSubscriber;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45720a.m359a(subscription);
        }

        /* renamed from: b */
        void m1119b() {
            if (this.f45722c.decrementAndGet() == 0) {
                if (this.f45721b.isEmpty()) {
                    this.f45723d.onCompleted();
                } else {
                    this.f45723d.onError(CompletableOnSubscribeMerge.m1156a(this.f45721b));
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            m1119b();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45721b.offer(th);
            m1119b();
        }
    }

    public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> iterable) {
        this.f45719a = iterable;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        Queue mpscLinkedAtomicQueue;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.mo640a(compositeSubscription);
        try {
            Iterator<? extends Completable> it = this.f45719a.iterator();
            if (it == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            if (UnsafeAccess.m759f()) {
                mpscLinkedAtomicQueue = new MpscLinkedQueue();
            } else {
                mpscLinkedAtomicQueue = new MpscLinkedAtomicQueue();
            }
            Queue queue = mpscLinkedAtomicQueue;
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (queue.isEmpty()) {
                                completableSubscriber.onCompleted();
                                return;
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.m1156a(queue));
                                return;
                            }
                        }
                        return;
                    } else if (compositeSubscription.isUnsubscribed()) {
                        return;
                    } else {
                        try {
                            Completable next = it.next();
                            if (compositeSubscription.isUnsubscribed()) {
                                return;
                            }
                            if (next == null) {
                                queue.offer(new NullPointerException("A completable source is null"));
                                if (atomicInteger.decrementAndGet() == 0) {
                                    if (queue.isEmpty()) {
                                        completableSubscriber.onCompleted();
                                        return;
                                    } else {
                                        completableSubscriber.onError(CompletableOnSubscribeMerge.m1156a(queue));
                                        return;
                                    }
                                }
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            next.m1967G0(new C15838a(compositeSubscription, queue, atomicInteger, completableSubscriber));
                        } catch (Throwable th) {
                            queue.offer(th);
                            if (atomicInteger.decrementAndGet() == 0) {
                                if (queue.isEmpty()) {
                                    completableSubscriber.onCompleted();
                                    return;
                                } else {
                                    completableSubscriber.onError(CompletableOnSubscribeMerge.m1156a(queue));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    queue.offer(th2);
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (queue.isEmpty()) {
                            completableSubscriber.onCompleted();
                            return;
                        } else {
                            completableSubscriber.onError(CompletableOnSubscribeMerge.m1156a(queue));
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
