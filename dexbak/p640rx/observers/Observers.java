package p640rx.observers;

import p640rx.Observer;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;

/* renamed from: rx.observers.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Observers {

    /* renamed from: a */
    private static final Observer<Object> f46895a = new C16125a();

    /* compiled from: Observers.java */
    /* renamed from: rx.observers.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16125a implements Observer<Object> {
        C16125a() {
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // p640rx.Observer
        public final void onNext(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Observers.java */
    /* renamed from: rx.observers.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16126b<T> implements Observer<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46896a;

        C16126b(Action1 action1) {
            this.f46896a = action1;
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
            this.f46896a.call(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Observers.java */
    /* renamed from: rx.observers.c$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16127c<T> implements Observer<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46897a;

        /* renamed from: b */
        final /* synthetic */ Action1 f46898b;

        C16127c(Action1 action1, Action1 action12) {
            this.f46897a = action1;
            this.f46898b = action12;
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            this.f46897a.call(th);
        }

        @Override // p640rx.Observer
        public final void onNext(T t) {
            this.f46898b.call(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Observers.java */
    /* renamed from: rx.observers.c$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16128d<T> implements Observer<T> {

        /* renamed from: a */
        final /* synthetic */ Action0 f46899a;

        /* renamed from: b */
        final /* synthetic */ Action1 f46900b;

        /* renamed from: c */
        final /* synthetic */ Action1 f46901c;

        C16128d(Action0 action0, Action1 action1, Action1 action12) {
            this.f46899a = action0;
            this.f46900b = action1;
            this.f46901c = action12;
        }

        @Override // p640rx.Observer
        public final void onCompleted() {
            this.f46899a.call();
        }

        @Override // p640rx.Observer
        public final void onError(Throwable th) {
            this.f46900b.call(th);
        }

        @Override // p640rx.Observer
        public final void onNext(T t) {
            this.f46901c.call(t);
        }
    }

    private Observers() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Observer<T> m644a(Action1<? super T> action1) {
        if (action1 != null) {
            return new C16126b(action1);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: b */
    public static <T> Observer<T> m643b(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 != null) {
            if (action12 != null) {
                return new C16127c(action12, action1);
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: c */
    public static <T> Observer<T> m642c(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        if (action1 != null) {
            if (action12 != null) {
                if (action0 != null) {
                    return new C16128d(action0, action12, action1);
                }
                throw new IllegalArgumentException("onComplete can not be null");
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: d */
    public static <T> Observer<T> m641d() {
        return (Observer<T>) f46895a;
    }
}
