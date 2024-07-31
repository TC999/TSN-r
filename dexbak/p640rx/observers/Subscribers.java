package p640rx.observers;

import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;

/* renamed from: rx.observers.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Subscribers {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Subscribers.java */
    /* renamed from: rx.observers.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16130a<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Observer f46914a;

        C16130a(Observer observer) {
            this.f46914a = observer;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46914a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46914a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46914a.onNext(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Subscribers.java */
    /* renamed from: rx.observers.h$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16131b<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46915a;

        C16131b(Action1 action1) {
            this.f46915a = action1;
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // p640rx.Observer
        public final void onNext(T t) {
            this.f46915a.call(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Subscribers.java */
    /* renamed from: rx.observers.h$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16132c<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46916a;

        /* renamed from: b */
        final /* synthetic */ Action1 f46917b;

        C16132c(Action1 action1, Action1 action12) {
            this.f46916a = action1;
            this.f46917b = action12;
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            this.f46916a.call(th);
        }

        @Override // p640rx.Observer
        public final void onNext(T t) {
            this.f46917b.call(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Subscribers.java */
    /* renamed from: rx.observers.h$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16133d<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Action0 f46918a;

        /* renamed from: b */
        final /* synthetic */ Action1 f46919b;

        /* renamed from: c */
        final /* synthetic */ Action1 f46920c;

        C16133d(Action0 action0, Action1 action1, Action1 action12) {
            this.f46918a = action0;
            this.f46919b = action1;
            this.f46920c = action12;
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
            this.f46918a.call();
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            this.f46919b.call(th);
        }

        @Override // p640rx.Observer
        public final void onNext(T t) {
            this.f46920c.call(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Subscribers.java */
    /* renamed from: rx.observers.h$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16134e<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f46921a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16134e(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f46921a = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46921a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46921a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f46921a.onNext(t);
        }
    }

    private Subscribers() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Subscriber<T> m636a(Action1<? super T> action1) {
        if (action1 != null) {
            return new C16131b(action1);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: b */
    public static <T> Subscriber<T> m635b(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 != null) {
            if (action12 != null) {
                return new C16132c(action12, action1);
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: c */
    public static <T> Subscriber<T> m634c(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        if (action1 != null) {
            if (action12 != null) {
                if (action0 != null) {
                    return new C16133d(action0, action12, action1);
                }
                throw new IllegalArgumentException("onComplete can not be null");
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: d */
    public static <T> Subscriber<T> m633d() {
        return m632e(Observers.m641d());
    }

    /* renamed from: e */
    public static <T> Subscriber<T> m632e(Observer<? super T> observer) {
        return new C16130a(observer);
    }

    /* renamed from: f */
    public static <T> Subscriber<T> m631f(Subscriber<? super T> subscriber) {
        return new C16134e(subscriber, subscriber);
    }
}
