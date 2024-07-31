package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.internal.subscriptions.SequentialSubscription;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeConcat implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Observable<Completable> f45412a;

    /* renamed from: b */
    final int f45413b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeConcat.java */
    /* renamed from: rx.internal.operators.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15769a extends Subscriber<Completable> {

        /* renamed from: a */
        final CompletableSubscriber f45414a;

        /* renamed from: b */
        final SequentialSubscription f45415b;

        /* renamed from: c */
        final C16092z<Completable> f45416c;

        /* renamed from: d */
        final C15770a f45417d;

        /* renamed from: e */
        final AtomicBoolean f45418e;

        /* renamed from: f */
        volatile boolean f45419f;

        /* renamed from: g */
        volatile boolean f45420g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CompletableOnSubscribeConcat.java */
        /* renamed from: rx.internal.operators.k$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15770a extends AtomicInteger implements CompletableSubscriber {
            private static final long serialVersionUID = 7233503139645205620L;

            C15770a() {
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                C15769a.this.f45415b.set(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                C15769a.this.m1195G();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                C15769a.this.m1194H(th);
            }
        }

        public C15769a(CompletableSubscriber completableSubscriber, int i) {
            this.f45414a = completableSubscriber;
            this.f45416c = new C16092z<>(i);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f45415b = sequentialSubscription;
            this.f45417d = new C15770a();
            this.f45418e = new AtomicBoolean();
            add(sequentialSubscription);
            request(i);
        }

        /* renamed from: F */
        void m1196F() {
            C15770a c15770a = this.f45417d;
            if (c15770a.getAndIncrement() != 0) {
                return;
            }
            while (!isUnsubscribed()) {
                if (!this.f45420g) {
                    boolean z = this.f45419f;
                    Completable poll = this.f45416c.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        this.f45414a.onCompleted();
                        return;
                    } else if (!z2) {
                        this.f45420g = true;
                        poll.m1909q0(c15770a);
                        request(1L);
                    }
                }
                if (c15770a.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* renamed from: G */
        void m1195G() {
            this.f45420g = false;
            m1196F();
        }

        /* renamed from: H */
        void m1194H(Throwable th) {
            unsubscribe();
            onError(th);
        }

        @Override // p640rx.Observer
        /* renamed from: I */
        public void onNext(Completable completable) {
            if (!this.f45416c.offer(completable)) {
                onError(new MissingBackpressureException());
            } else {
                m1196F();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45419f) {
                return;
            }
            this.f45419f = true;
            m1196F();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45418e.compareAndSet(false, true)) {
                this.f45414a.onError(th);
            } else {
                RxJavaHooks.m576I(th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeConcat(Observable<? extends Completable> observable, int i) {
        this.f45412a = observable;
        this.f45413b = i;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        C15769a c15769a = new C15769a(completableSubscriber, this.f45413b);
        completableSubscriber.mo640a(c15769a);
        this.f45412a.m1822I6(c15769a);
    }
}
