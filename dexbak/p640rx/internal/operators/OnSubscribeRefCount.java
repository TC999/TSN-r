package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.observables.ConnectableObservable;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.z0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeRefCount<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    private final ConnectableObservable<? extends T> f46250a;

    /* renamed from: b */
    volatile CompositeSubscription f46251b = new CompositeSubscription();

    /* renamed from: c */
    final AtomicInteger f46252c = new AtomicInteger(0);

    /* renamed from: d */
    final ReentrantLock f46253d = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRefCount.java */
    /* renamed from: rx.internal.operators.z0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15983a implements Action1<Subscription> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46254a;

        /* renamed from: b */
        final /* synthetic */ AtomicBoolean f46255b;

        C15983a(Subscriber subscriber, AtomicBoolean atomicBoolean) {
            this.f46254a = subscriber;
            this.f46255b = atomicBoolean;
        }

        @Override // p640rx.functions.Action1
        public void call(Subscription subscription) {
            try {
                OnSubscribeRefCount.this.f46251b.m359a(subscription);
                OnSubscribeRefCount onSubscribeRefCount = OnSubscribeRefCount.this;
                onSubscribeRefCount.m974c(this.f46254a, onSubscribeRefCount.f46251b);
            } finally {
                OnSubscribeRefCount.this.f46253d.unlock();
                this.f46255b.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRefCount.java */
    /* renamed from: rx.internal.operators.z0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15984b extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46257a;

        /* renamed from: b */
        final /* synthetic */ CompositeSubscription f46258b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15984b(Subscriber subscriber, Subscriber subscriber2, CompositeSubscription compositeSubscription) {
            super(subscriber);
            this.f46257a = subscriber2;
            this.f46258b = compositeSubscription;
        }

        /* renamed from: F */
        void m972F() {
            OnSubscribeRefCount.this.f46253d.lock();
            try {
                if (OnSubscribeRefCount.this.f46251b == this.f46258b) {
                    if (OnSubscribeRefCount.this.f46250a instanceof Subscription) {
                        ((Subscription) OnSubscribeRefCount.this.f46250a).unsubscribe();
                    }
                    OnSubscribeRefCount.this.f46251b.unsubscribe();
                    OnSubscribeRefCount.this.f46251b = new CompositeSubscription();
                    OnSubscribeRefCount.this.f46252c.set(0);
                }
            } finally {
                OnSubscribeRefCount.this.f46253d.unlock();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m972F();
            this.f46257a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            m972F();
            this.f46257a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46257a.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRefCount.java */
    /* renamed from: rx.internal.operators.z0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15985c implements Action0 {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f46260a;

        C15985c(CompositeSubscription compositeSubscription) {
            this.f46260a = compositeSubscription;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            OnSubscribeRefCount.this.f46253d.lock();
            try {
                if (OnSubscribeRefCount.this.f46251b == this.f46260a && OnSubscribeRefCount.this.f46252c.decrementAndGet() == 0) {
                    if (OnSubscribeRefCount.this.f46250a instanceof Subscription) {
                        ((Subscription) OnSubscribeRefCount.this.f46250a).unsubscribe();
                    }
                    OnSubscribeRefCount.this.f46251b.unsubscribe();
                    OnSubscribeRefCount.this.f46251b = new CompositeSubscription();
                }
            } finally {
                OnSubscribeRefCount.this.f46253d.unlock();
            }
        }
    }

    public OnSubscribeRefCount(ConnectableObservable<? extends T> connectableObservable) {
        this.f46250a = connectableObservable;
    }

    /* renamed from: b */
    private Subscription m975b(CompositeSubscription compositeSubscription) {
        return Subscriptions.m346a(new C15985c(compositeSubscription));
    }

    /* renamed from: d */
    private Action1<Subscription> m973d(Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
        return new C15983a(subscriber, atomicBoolean);
    }

    /* renamed from: c */
    void m974c(Subscriber<? super T> subscriber, CompositeSubscription compositeSubscription) {
        subscriber.add(m975b(compositeSubscription));
        this.f46250a.m1822I6(new C15984b(subscriber, subscriber, compositeSubscription));
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        boolean z;
        this.f46253d.lock();
        if (this.f46252c.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f46250a.mo692z7(m973d(subscriber, atomicBoolean));
                if (z) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            m974c(subscriber, this.f46251b);
        } finally {
            this.f46253d.unlock();
        }
    }
}
