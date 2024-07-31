package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.k1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeUsing<T, Resource> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    private final Func0<Resource> f45439a;

    /* renamed from: b */
    private final Func1<? super Resource, ? extends Observable<? extends T>> f45440b;

    /* renamed from: c */
    private final Action1<? super Resource> f45441c;

    /* renamed from: d */
    private final boolean f45442d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeUsing.java */
    /* renamed from: rx.internal.operators.k1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15774a<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;

        /* renamed from: a */
        private Action1<? super Resource> f45443a;

        /* renamed from: b */
        private Resource f45444b;

        C15774a(Action1<? super Resource> action1, Resource resource) {
            this.f45443a = action1;
            this.f45444b = resource;
            lazySet(false);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.b<? super Resource>] */
        @Override // p640rx.functions.Action0
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r0 = (Resource) false;
                try {
                    this.f45443a.call((Resource) this.f45444b);
                } finally {
                    this.f45444b = null;
                    this.f45443a = null;
                }
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            call();
        }
    }

    public OnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        this.f45439a = func0;
        this.f45440b = func1;
        this.f45441c = action1;
        this.f45442d = z;
    }

    /* renamed from: a */
    private Throwable m1188a(Action0 action0) {
        try {
            action0.call();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        Observable<? extends T> m1843G1;
        try {
            Resource call = this.f45439a.call();
            C15774a c15774a = new C15774a(this.f45441c, call);
            subscriber.add(c15774a);
            Observable<? extends T> call2 = this.f45440b.call(call);
            if (this.f45442d) {
                m1843G1 = call2.m1779O1(c15774a);
            } else {
                m1843G1 = call2.m1843G1(c15774a);
            }
            m1843G1.m1822I6(Subscribers.m631f(subscriber));
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
