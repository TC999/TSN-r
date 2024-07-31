package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.CompositeException;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeMerge implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Observable<Completable> f45548a;

    /* renamed from: b */
    final int f45549b;

    /* renamed from: c */
    final boolean f45550c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeMerge.java */
    /* renamed from: rx.internal.operators.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15796a extends Subscriber<Completable> {

        /* renamed from: a */
        final CompletableSubscriber f45551a;

        /* renamed from: c */
        final boolean f45553c;

        /* renamed from: d */
        volatile boolean f45554d;

        /* renamed from: b */
        final CompositeSubscription f45552b = new CompositeSubscription();

        /* renamed from: g */
        final AtomicInteger f45557g = new AtomicInteger(1);

        /* renamed from: f */
        final AtomicBoolean f45556f = new AtomicBoolean();

        /* renamed from: e */
        final AtomicReference<Queue<Throwable>> f45555e = new AtomicReference<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CompletableOnSubscribeMerge.java */
        /* renamed from: rx.internal.operators.n$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15797a implements CompletableSubscriber {

            /* renamed from: a */
            Subscription f45558a;

            /* renamed from: b */
            boolean f45559b;

            C15797a() {
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f45558a = subscription;
                C15796a.this.f45552b.m359a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                if (this.f45559b) {
                    return;
                }
                this.f45559b = true;
                C15796a.this.f45552b.m361G(this.f45558a);
                C15796a.this.m1151J();
                if (C15796a.this.f45554d) {
                    return;
                }
                C15796a.this.request(1L);
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (this.f45559b) {
                    RxJavaHooks.m576I(th);
                    return;
                }
                this.f45559b = true;
                C15796a.this.f45552b.m361G(this.f45558a);
                C15796a.this.m1153H().offer(th);
                C15796a.this.m1151J();
                C15796a c15796a = C15796a.this;
                if (!c15796a.f45553c || c15796a.f45554d) {
                    return;
                }
                C15796a.this.request(1L);
            }
        }

        public C15796a(CompletableSubscriber completableSubscriber, int i, boolean z) {
            this.f45551a = completableSubscriber;
            this.f45553c = z;
            if (i == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request(i);
            }
        }

        /* renamed from: H */
        Queue<Throwable> m1153H() {
            Queue<Throwable> queue = this.f45555e.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            return this.f45555e.compareAndSet(null, concurrentLinkedQueue) ? concurrentLinkedQueue : this.f45555e.get();
        }

        @Override // p640rx.Observer
        /* renamed from: I */
        public void onNext(Completable completable) {
            if (this.f45554d) {
                return;
            }
            this.f45557g.getAndIncrement();
            completable.m1967G0(new C15797a());
        }

        /* renamed from: J */
        void m1151J() {
            Queue<Throwable> queue;
            if (this.f45557g.decrementAndGet() == 0) {
                Queue<Throwable> queue2 = this.f45555e.get();
                if (queue2 != null && !queue2.isEmpty()) {
                    Throwable m1156a = CompletableOnSubscribeMerge.m1156a(queue2);
                    if (this.f45556f.compareAndSet(false, true)) {
                        this.f45551a.onError(m1156a);
                        return;
                    } else {
                        RxJavaHooks.m576I(m1156a);
                        return;
                    }
                }
                this.f45551a.onCompleted();
            } else if (this.f45553c || (queue = this.f45555e.get()) == null || queue.isEmpty()) {
            } else {
                Throwable m1156a2 = CompletableOnSubscribeMerge.m1156a(queue);
                if (this.f45556f.compareAndSet(false, true)) {
                    this.f45551a.onError(m1156a2);
                } else {
                    RxJavaHooks.m576I(m1156a2);
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45554d) {
                return;
            }
            this.f45554d = true;
            m1151J();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45554d) {
                RxJavaHooks.m576I(th);
                return;
            }
            m1153H().offer(th);
            this.f45554d = true;
            m1151J();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeMerge(Observable<? extends Completable> observable, int i, boolean z) {
        this.f45548a = observable;
        this.f45549b = i;
        this.f45550c = z;
    }

    /* renamed from: a */
    public static Throwable m1156a(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException(arrayList);
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        C15796a c15796a = new C15796a(completableSubscriber, this.f45549b, this.f45550c);
        completableSubscriber.mo640a(c15796a);
        this.f45548a.m1822I6(c15796a);
    }
}
