package p640rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeMergeIterable implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Iterable<? extends Completable> f45756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeMergeIterable.java */
    /* renamed from: rx.internal.operators.r$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15847a implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f45757a;

        /* renamed from: b */
        final /* synthetic */ AtomicBoolean f45758b;

        /* renamed from: c */
        final /* synthetic */ CompletableSubscriber f45759c;

        /* renamed from: d */
        final /* synthetic */ AtomicInteger f45760d;

        C15847a(CompositeSubscription compositeSubscription, AtomicBoolean atomicBoolean, CompletableSubscriber completableSubscriber, AtomicInteger atomicInteger) {
            this.f45757a = compositeSubscription;
            this.f45758b = atomicBoolean;
            this.f45759c = completableSubscriber;
            this.f45760d = atomicInteger;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45757a.m359a(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            if (this.f45760d.decrementAndGet() == 0 && this.f45758b.compareAndSet(false, true)) {
                this.f45759c.onCompleted();
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45757a.unsubscribe();
            if (this.f45758b.compareAndSet(false, true)) {
                this.f45759c.onError(th);
            } else {
                RxJavaHooks.m576I(th);
            }
        }
    }

    public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> iterable) {
        this.f45756a = iterable;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.mo640a(compositeSubscription);
        try {
            Iterator<? extends Completable> it = this.f45756a.iterator();
            if (it == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                            completableSubscriber.onCompleted();
                            return;
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
                                compositeSubscription.unsubscribe();
                                Throwable nullPointerException = new NullPointerException("A completable source is null");
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    completableSubscriber.onError(nullPointerException);
                                    return;
                                } else {
                                    RxJavaHooks.m576I(nullPointerException);
                                    return;
                                }
                            }
                            atomicInteger.getAndIncrement();
                            next.m1967G0(new C15847a(compositeSubscription, atomicBoolean, completableSubscriber, atomicInteger));
                        } catch (Throwable th) {
                            compositeSubscription.unsubscribe();
                            if (atomicBoolean.compareAndSet(false, true)) {
                                completableSubscriber.onError(th);
                                return;
                            } else {
                                RxJavaHooks.m576I(th);
                                return;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    compositeSubscription.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
                        completableSubscriber.onError(th2);
                        return;
                    } else {
                        RxJavaHooks.m576I(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
