package p640rx;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p603i2.AssertableSubscriberObservable;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.annotations.Experimental;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Actions;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.functions.Func3;
import p640rx.functions.Func4;
import p640rx.functions.Func5;
import p640rx.functions.Func6;
import p640rx.functions.Func7;
import p640rx.functions.Func8;
import p640rx.functions.Func9;
import p640rx.functions.FuncN;
import p640rx.internal.operators.CompletableFlatMapSingleToCompletable;
import p640rx.internal.operators.SingleDelay;
import p640rx.internal.operators.SingleDoAfterTerminate;
import p640rx.internal.operators.SingleDoOnEvent;
import p640rx.internal.operators.SingleDoOnSubscribe;
import p640rx.internal.operators.SingleDoOnUnsubscribe;
import p640rx.internal.operators.SingleFromCallable;
import p640rx.internal.operators.SingleFromEmitter;
import p640rx.internal.operators.SingleFromFuture;
import p640rx.internal.operators.SingleFromObservable;
import p640rx.internal.operators.SingleLiftObservableOperator;
import p640rx.internal.operators.SingleObserveOn;
import p640rx.internal.operators.SingleOnErrorReturn;
import p640rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther;
import p640rx.internal.operators.SingleOnSubscribeMap;
import p640rx.internal.operators.SingleOnSubscribeUsing;
import p640rx.internal.operators.SingleOperatorOnErrorResumeNext;
import p640rx.internal.operators.SingleOperatorZip;
import p640rx.internal.operators.SingleTakeUntilCompletable;
import p640rx.internal.operators.SingleTakeUntilObservable;
import p640rx.internal.operators.SingleTakeUntilSingle;
import p640rx.internal.operators.SingleTimeout;
import p640rx.internal.operators.SingleToObservable;
import p640rx.internal.util.ScalarSynchronousSingle;
import p640rx.internal.util.UtilityFunctions;
import p640rx.observers.AssertableSubscriber;
import p640rx.observers.SafeSubscriber;
import p640rx.plugins.RxJavaHooks;
import p640rx.schedulers.Schedulers;
import p640rx.singles.BlockingSingle;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Single<T> {

    /* renamed from: a */
    final InterfaceC15633t<T> f44830a;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15608a<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func9 f44831a;

        C15608a(Func9 func9) {
            this.f44831a = func9;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44831a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15609b extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ Action1 f44832b;

        /* renamed from: c */
        final /* synthetic */ Action1 f44833c;

        C15609b(Action1 action1, Action1 action12) {
            this.f44832b = action1;
            this.f44833c = action12;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public final void mo446d(T t) {
            try {
                this.f44833c.call(t);
            } finally {
                unsubscribe();
            }
        }

        @Override // p640rx.SingleSubscriber
        public final void onError(Throwable th) {
            try {
                this.f44832b.call(th);
            } finally {
                unsubscribe();
            }
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15610c extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ Observer f44835b;

        C15610c(Observer observer) {
            this.f44835b = observer;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f44835b.onNext(t);
            this.f44835b.onCompleted();
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f44835b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15611d implements InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44837a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Single.java */
        /* renamed from: rx.i$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15612a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ SingleSubscriber f44839a;

            /* renamed from: b */
            final /* synthetic */ Scheduler.AbstractC15607a f44840b;

            /* compiled from: Single.java */
            /* renamed from: rx.i$d$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15613a extends SingleSubscriber<T> {
                C15613a() {
                }

                @Override // p640rx.SingleSubscriber
                /* renamed from: d */
                public void mo446d(T t) {
                    try {
                        C15612a.this.f44839a.mo446d(t);
                    } finally {
                        C15612a.this.f44840b.unsubscribe();
                    }
                }

                @Override // p640rx.SingleSubscriber
                public void onError(Throwable th) {
                    try {
                        C15612a.this.f44839a.onError(th);
                    } finally {
                        C15612a.this.f44840b.unsubscribe();
                    }
                }
            }

            C15612a(SingleSubscriber singleSubscriber, Scheduler.AbstractC15607a abstractC15607a) {
                this.f44839a = singleSubscriber;
                this.f44840b = abstractC15607a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15613a c15613a = new C15613a();
                this.f44839a.m743b(c15613a);
                Single.this.m1372i0(c15613a);
            }
        }

        C15611d(Scheduler scheduler) {
            this.f44837a = scheduler;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.AbstractC15607a mo450a = this.f44837a.mo450a();
            singleSubscriber.m743b(mo450a);
            mo450a.mo456d(new C15612a(singleSubscriber, mo450a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15614e implements Func0<Single<T>> {
        C15614e() {
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public Single<T> call() {
            return Single.m1343x(new TimeoutException());
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15615f implements Action1<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Action1 f44844a;

        C15615f(Action1 action1) {
            this.f44844a = action1;
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            this.f44844a.call(th);
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15616g implements Action1<T> {

        /* renamed from: a */
        final /* synthetic */ Action1 f44846a;

        C15616g(Action1 action1) {
            this.f44846a = action1;
        }

        @Override // p640rx.functions.Action1
        public void call(T t) {
            this.f44846a.call(Notification.m2002e(t));
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15617h implements Action1<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Action1 f44848a;

        C15617h(Action1 action1) {
            this.f44848a = action1;
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            this.f44848a.call(Notification.m2003d(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15618i implements InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Callable f44850a;

        C15618i(Callable callable) {
            this.f44850a = callable;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            try {
                ((Single) this.f44850a.call()).m1372i0(singleSubscriber);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                singleSubscriber.onError(th);
            }
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15619j implements InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44851a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Single.java */
        /* renamed from: rx.i$j$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15620a extends SingleSubscriber<T> {

            /* renamed from: b */
            final /* synthetic */ SingleSubscriber f44853b;

            C15620a(SingleSubscriber singleSubscriber) {
                this.f44853b = singleSubscriber;
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(T t) {
                this.f44853b.mo446d(t);
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                this.f44853b.onError(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Single.java */
        /* renamed from: rx.i$j$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15621b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ SingleSubscriber f44855a;

            /* compiled from: Single.java */
            /* renamed from: rx.i$j$b$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15622a implements Action0 {

                /* renamed from: a */
                final /* synthetic */ Scheduler.AbstractC15607a f44857a;

                C15622a(Scheduler.AbstractC15607a abstractC15607a) {
                    this.f44857a = abstractC15607a;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15621b.this.f44855a.unsubscribe();
                    } finally {
                        this.f44857a.unsubscribe();
                    }
                }
            }

            C15621b(SingleSubscriber singleSubscriber) {
                this.f44855a = singleSubscriber;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                Scheduler.AbstractC15607a mo450a = C15619j.this.f44851a.mo450a();
                mo450a.mo456d(new C15622a(mo450a));
            }
        }

        C15619j(Scheduler scheduler) {
            this.f44851a = scheduler;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            C15620a c15620a = new C15620a(singleSubscriber);
            singleSubscriber.m743b(Subscriptions.m346a(new C15621b(c15620a)));
            Single.this.m1372i0(c15620a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15623k implements InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Throwable f44859a;

        C15623k(Throwable th) {
            this.f44859a = th;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.onError(this.f44859a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Single.java */
    /* renamed from: rx.i$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15624l implements InterfaceC15633t<T> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Single.java */
        /* renamed from: rx.i$l$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15625a extends SingleSubscriber<Single<? extends T>> {

            /* renamed from: b */
            final /* synthetic */ SingleSubscriber f44861b;

            C15625a(SingleSubscriber singleSubscriber) {
                this.f44861b = singleSubscriber;
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: F */
            public void mo446d(Single<? extends T> single) {
                single.m1372i0(this.f44861b);
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                this.f44861b.onError(th);
            }
        }

        C15624l() {
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            C15625a c15625a = new C15625a(singleSubscriber);
            singleSubscriber.m743b(c15625a);
            Single.this.m1372i0(c15625a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15626m<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func2 f44863a;

        C15626m(Func2 func2) {
            this.f44863a = func2;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44863a.call(objArr[0], objArr[1]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15627n<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func3 f44864a;

        C15627n(Func3 func3) {
            this.f44864a = func3;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44864a.call(objArr[0], objArr[1], objArr[2]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$o */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15628o<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func4 f44865a;

        C15628o(Func4 func4) {
            this.f44865a = func4;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44865a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$p */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15629p<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func5 f44866a;

        C15629p(Func5 func5) {
            this.f44866a = func5;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44866a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$q */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15630q<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func6 f44867a;

        C15630q(Func6 func6) {
            this.f44867a = func6;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44867a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$r */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15631r<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func7 f44868a;

        C15631r(Func7 func7) {
            this.f44868a = func7;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44868a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Single.java */
    /* renamed from: rx.i$s */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15632s<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ Func8 f44869a;

        C15632s(Func8 func8) {
            this.f44869a = func8;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            return (R) this.f44869a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$t */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15633t<T> extends Action1<SingleSubscriber<? super T>> {
    }

    /* compiled from: Single.java */
    /* renamed from: rx.i$u */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15634u<T, R> extends Func1<Single<T>, Single<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Single(InterfaceC15633t<T> interfaceC15633t) {
        this.f44830a = RxJavaHooks.m577H(interfaceC15633t);
    }

    /* renamed from: A0 */
    private Subscription m1428A0(Subscriber<? super T> subscriber, boolean z) {
        if (z) {
            try {
                subscriber.onStart();
            } catch (Throwable th) {
                C15575a.m1474e(th);
                try {
                    subscriber.onError(RxJavaHooks.m568Q(th));
                    return Subscriptions.m342e();
                } catch (Throwable th2) {
                    C15575a.m1474e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    RxJavaHooks.m568Q(runtimeException);
                    throw runtimeException;
                }
            }
        }
        RxJavaHooks.m565T(this, this.f44830a).call(SingleLiftObservableOperator.m1112a(subscriber));
        return RxJavaHooks.m566S(subscriber);
    }

    /* renamed from: B */
    public static <T> Single<T> m1427B(Future<? extends T> future) {
        return m1365m(new SingleFromFuture(future, 0L, null));
    }

    /* renamed from: C */
    public static <T> Single<T> m1425C(Future<? extends T> future, long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return m1365m(new SingleFromFuture(future, j, timeUnit));
        }
        throw new NullPointerException("unit is null");
    }

    /* renamed from: C0 */
    public static <T, Resource> Single<T> m1424C0(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1) {
        return m1422D0(func0, func1, action1, false);
    }

    /* renamed from: D */
    public static <T> Single<T> m1423D(Future<? extends T> future, Scheduler scheduler) {
        return m1427B(future).m1364m0(scheduler);
    }

    /* renamed from: D0 */
    public static <T, Resource> Single<T> m1422D0(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        if (func0 != null) {
            if (func1 != null) {
                if (action1 != null) {
                    return m1365m(new SingleOnSubscribeUsing(func0, func1, action1, z));
                }
                throw new NullPointerException("disposeAction is null");
            }
            throw new NullPointerException("singleFactory is null");
        }
        throw new NullPointerException("resourceFactory is null");
    }

    /* renamed from: E */
    public static <T> Single<T> m1421E(Callable<? extends T> callable) {
        return m1365m(new SingleFromCallable(callable));
    }

    /* renamed from: E0 */
    public static <R> Single<R> m1420E0(Iterable<? extends Single<?>> iterable, FuncN<? extends R> funcN) {
        return SingleOperatorZip.m1001a(m1417G(iterable), funcN);
    }

    /* renamed from: F */
    public static <T> Single<T> m1419F(Action1<SingleEmitter<T>> action1) {
        if (action1 != null) {
            return m1365m(new SingleFromEmitter(action1));
        }
        throw new NullPointerException("producer is null");
    }

    /* renamed from: F0 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> m1418F0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Single<? extends T8> single8, Single<? extends T9> single9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4, single5, single6, single7, single8, single9}, new C15608a(func9));
    }

    /* renamed from: G */
    static <T> Single<? extends T>[] m1417G(Iterable<? extends Single<? extends T>> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return (Single[]) collection.toArray(new Single[collection.size()]);
        }
        Single<? extends T>[] singleArr = new Single[8];
        int i = 0;
        for (Single<? extends T> single : iterable) {
            if (i == singleArr.length) {
                Single<? extends T>[] singleArr2 = new Single[(i >> 2) + i];
                System.arraycopy(singleArr, 0, singleArr2, 0, i);
                singleArr = singleArr2;
            }
            singleArr[i] = single;
            i++;
        }
        if (singleArr.length == i) {
            return singleArr;
        }
        Single<? extends T>[] singleArr3 = new Single[i];
        System.arraycopy(singleArr, 0, singleArr3, 0, i);
        return singleArr3;
    }

    /* renamed from: G0 */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> m1416G0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Single<? extends T8> single8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4, single5, single6, single7, single8}, new C15632s(func8));
    }

    /* renamed from: H */
    public static <T> Single<T> m1415H(T t) {
        return ScalarSynchronousSingle.m814O0(t);
    }

    /* renamed from: H0 */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> m1414H0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Single<? extends T7> single7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4, single5, single6, single7}, new C15631r(func7));
    }

    /* renamed from: I0 */
    public static <T1, T2, T3, T4, T5, T6, R> Single<R> m1412I0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Single<? extends T6> single6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4, single5, single6}, new C15630q(func6));
    }

    /* renamed from: J0 */
    public static <T1, T2, T3, T4, T5, R> Single<R> m1410J0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Single<? extends T5> single5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4, single5}, new C15629p(func5));
    }

    /* renamed from: K */
    public static <T> Observable<T> m1409K(Observable<? extends Single<? extends T>> observable) {
        return m1407L(observable, Integer.MAX_VALUE);
    }

    /* renamed from: K0 */
    public static <T1, T2, T3, T4, R> Single<R> m1408K0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Single<? extends T4> single4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3, single4}, new C15628o(func4));
    }

    /* renamed from: L */
    public static <T> Observable<T> m1407L(Observable<? extends Single<? extends T>> observable, int i) {
        return (Observable<T>) observable.m1554q2(UtilityFunctions.m803c(), false, i);
    }

    /* renamed from: L0 */
    public static <T1, T2, T3, R> Single<R> m1406L0(Single<? extends T1> single, Single<? extends T2> single2, Single<? extends T3> single3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2, single3}, new C15627n(func3));
    }

    /* renamed from: M */
    public static <T> Observable<T> m1405M(Single<? extends T> single, Single<? extends T> single2) {
        return Observable.m1617i3(m1389a(single), m1389a(single2));
    }

    /* renamed from: M0 */
    public static <T1, T2, R> Single<R> m1404M0(Single<? extends T1> single, Single<? extends T2> single2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return SingleOperatorZip.m1001a(new Single[]{single, single2}, new C15626m(func2));
    }

    /* renamed from: N */
    public static <T> Observable<T> m1403N(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3) {
        return Observable.m1609j3(m1389a(single), m1389a(single2), m1389a(single3));
    }

    /* renamed from: O */
    public static <T> Observable<T> m1401O(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4) {
        return Observable.m1601k3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4));
    }

    /* renamed from: P */
    public static <T> Observable<T> m1400P(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5) {
        return Observable.m1593l3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5));
    }

    /* renamed from: Q */
    public static <T> Observable<T> m1399Q(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6) {
        return Observable.m1585m3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6));
    }

    /* renamed from: R */
    public static <T> Observable<T> m1398R(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7) {
        return Observable.m1577n3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7));
    }

    /* renamed from: S */
    public static <T> Observable<T> m1397S(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8) {
        return Observable.m1569o3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7), m1389a(single8));
    }

    /* renamed from: T */
    public static <T> Observable<T> m1396T(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8, Single<? extends T> single9) {
        return Observable.m1561p3(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7), m1389a(single8), m1389a(single9));
    }

    /* renamed from: U */
    public static <T> Single<T> m1395U(Single<? extends Single<? extends T>> single) {
        if (single instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) single).m812Q0(UtilityFunctions.m803c());
        }
        return m1365m(new C15624l());
    }

    /* renamed from: V */
    public static <T> Observable<T> m1394V(Observable<? extends Single<? extends T>> observable) {
        return m1407L(observable, Integer.MAX_VALUE);
    }

    /* renamed from: W */
    public static <T> Observable<T> m1393W(Observable<? extends Single<? extends T>> observable, int i) {
        return (Observable<T>) observable.m1554q2(UtilityFunctions.m803c(), true, i);
    }

    /* renamed from: a */
    private static <T> Observable<T> m1389a(Single<T> single) {
        return Observable.m1830H6(new SingleToObservable(single.f44830a));
    }

    /* renamed from: d */
    public static <T> Observable<T> m1383d(Single<? extends T> single, Single<? extends T> single2) {
        return Observable.m1516v0(m1389a(single), m1389a(single2));
    }

    /* renamed from: e */
    public static <T> Observable<T> m1381e(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3) {
        return Observable.m1509w0(m1389a(single), m1389a(single2), m1389a(single3));
    }

    /* renamed from: f */
    public static <T> Observable<T> m1379f(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4) {
        return Observable.m1502x0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4));
    }

    /* renamed from: g */
    public static <T> Observable<T> m1377g(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5) {
        return Observable.m1495y0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5));
    }

    /* renamed from: h */
    public static <T> Observable<T> m1375h(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6) {
        return Observable.m1488z0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6));
    }

    /* renamed from: i */
    public static <T> Observable<T> m1373i(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7) {
        return Observable.m1888A0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7));
    }

    /* renamed from: j */
    public static <T> Observable<T> m1371j(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8) {
        return Observable.m1881B0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7), m1389a(single8));
    }

    /* renamed from: k */
    public static <T> Observable<T> m1369k(Single<? extends T> single, Single<? extends T> single2, Single<? extends T> single3, Single<? extends T> single4, Single<? extends T> single5, Single<? extends T> single6, Single<? extends T> single7, Single<? extends T> single8, Single<? extends T> single9) {
        return Observable.m1874C0(m1389a(single), m1389a(single2), m1389a(single3), m1389a(single4), m1389a(single5), m1389a(single6), m1389a(single7), m1389a(single8), m1389a(single9));
    }

    /* renamed from: m */
    public static <T> Single<T> m1365m(InterfaceC15633t<T> interfaceC15633t) {
        return new Single<>(interfaceC15633t);
    }

    /* renamed from: n */
    public static <T> Single<T> m1363n(Callable<Single<T>> callable) {
        return m1365m(new C15618i(callable));
    }

    /* renamed from: x */
    public static <T> Single<T> m1343x(Throwable th) {
        return m1365m(new C15623k(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: A */
    public final <R> Observable<R> m1429A(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.m1633g3(m1389a(m1411J(func1)));
    }

    @Experimental
    /* renamed from: B0 */
    public final Single<T> m1426B0(Scheduler scheduler) {
        return m1365m(new C15619j(scheduler));
    }

    /* renamed from: I */
    public final <R> Single<R> m1413I(Observable.InterfaceC15568b<? extends R, ? super T> interfaceC15568b) {
        return m1365m(new SingleLiftObservableOperator(this.f44830a, interfaceC15568b));
    }

    /* renamed from: J */
    public final <R> Single<R> m1411J(Func1<? super T, ? extends R> func1) {
        return m1365m(new SingleOnSubscribeMap(this, func1));
    }

    /* renamed from: N0 */
    public final <T2, R> Single<R> m1402N0(Single<? extends T2> single, Func2<? super T, ? super T2, ? extends R> func2) {
        return m1404M0(this, single, func2);
    }

    /* renamed from: X */
    public final Observable<T> m1392X(Single<? extends T> single) {
        return m1405M(this, single);
    }

    /* renamed from: Y */
    public final Single<T> m1391Y(Scheduler scheduler) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).m811R0(scheduler);
        }
        if (scheduler != null) {
            return m1365m(new SingleObserveOn(this.f44830a, scheduler));
        }
        throw new NullPointerException("scheduler is null");
    }

    /* renamed from: Z */
    public final Single<T> m1390Z(Single<? extends T> single) {
        return new Single<>(SingleOperatorOnErrorResumeNext.m1008b(this, single));
    }

    /* renamed from: a0 */
    public final Single<T> m1388a0(Func1<Throwable, ? extends Single<? extends T>> func1) {
        return new Single<>(SingleOperatorOnErrorResumeNext.m1009a(this, func1));
    }

    /* renamed from: b */
    public final Single<T> m1387b() {
        return m1340y0().m1652e0(1).m1868C6();
    }

    /* renamed from: b0 */
    public final Single<T> m1386b0(Func1<Throwable, ? extends T> func1) {
        return m1365m(new SingleOnErrorReturn(this.f44830a, func1));
    }

    /* renamed from: c */
    public <R> Single<R> m1385c(InterfaceC15634u<? super T, ? extends R> interfaceC15634u) {
        return (Single) interfaceC15634u.call(this);
    }

    /* renamed from: c0 */
    public final Single<T> m1384c0() {
        return m1340y0().m1877B4().m1868C6();
    }

    /* renamed from: d0 */
    public final Single<T> m1382d0(long j) {
        return m1340y0().m1870C4(j).m1868C6();
    }

    /* renamed from: e0 */
    public final Single<T> m1380e0(Func2<Integer, Throwable, Boolean> func2) {
        return m1340y0().m1863D4(func2).m1868C6();
    }

    /* renamed from: f0 */
    public final Single<T> m1378f0(Func1<Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return m1340y0().m1856E4(func1).m1868C6();
    }

    /* renamed from: g0 */
    public final Subscription m1376g0() {
        return m1366l0(Actions.m1455a(), Actions.m1454b());
    }

    /* renamed from: h0 */
    public final Subscription m1374h0(Observer<? super T> observer) {
        if (observer != null) {
            return m1372i0(new C15610c(observer));
        }
        throw new NullPointerException("observer is null");
    }

    /* renamed from: i0 */
    public final Subscription m1372i0(SingleSubscriber<? super T> singleSubscriber) {
        if (singleSubscriber != null) {
            try {
                RxJavaHooks.m565T(this, this.f44830a).call(singleSubscriber);
                return RxJavaHooks.m566S(singleSubscriber);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                try {
                    singleSubscriber.onError(RxJavaHooks.m568Q(th));
                    return Subscriptions.m345b();
                } catch (Throwable th2) {
                    C15575a.m1474e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    RxJavaHooks.m568Q(runtimeException);
                    throw runtimeException;
                }
            }
        }
        throw new IllegalArgumentException("te is null");
    }

    /* renamed from: j0 */
    public final Subscription m1370j0(Subscriber<? super T> subscriber) {
        if (subscriber != null) {
            subscriber.onStart();
            if (!(subscriber instanceof SafeSubscriber)) {
                return m1428A0(new SafeSubscriber(subscriber), false);
            }
            return m1428A0(subscriber, true);
        }
        throw new IllegalArgumentException("observer can not be null");
    }

    /* renamed from: k0 */
    public final Subscription m1368k0(Action1<? super T> action1) {
        return m1366l0(action1, Actions.m1454b());
    }

    /* renamed from: l */
    public final Observable<T> m1367l(Single<? extends T> single) {
        return m1383d(this, single);
    }

    /* renamed from: l0 */
    public final Subscription m1366l0(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 != null) {
            if (action12 != null) {
                return m1372i0(new C15609b(action12, action1));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    /* renamed from: m0 */
    public final Single<T> m1364m0(Scheduler scheduler) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).m811R0(scheduler);
        }
        return m1365m(new C15611d(scheduler));
    }

    /* renamed from: n0 */
    public final Single<T> m1362n0(Completable completable) {
        return m1365m(new SingleTakeUntilCompletable(this.f44830a, completable));
    }

    /* renamed from: o */
    public final Single<T> m1361o(long j, TimeUnit timeUnit) {
        return m1359p(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: o0 */
    public final <E> Single<T> m1360o0(Observable<? extends E> observable) {
        return m1365m(new SingleTakeUntilObservable(this.f44830a, observable));
    }

    /* renamed from: p */
    public final Single<T> m1359p(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1365m(new SingleDelay(this.f44830a, j, timeUnit, scheduler));
    }

    /* renamed from: p0 */
    public final <E> Single<T> m1358p0(Single<? extends E> single) {
        return m1365m(new SingleTakeUntilSingle(this.f44830a, single));
    }

    /* renamed from: q */
    public final Single<T> m1357q(Observable<?> observable) {
        observable.getClass();
        return m1365m(new SingleOnSubscribeDelaySubscriptionOther(this, observable));
    }

    /* renamed from: q0 */
    public final AssertableSubscriber<T> m1356q0() {
        AssertableSubscriberObservable m12694F = AssertableSubscriberObservable.m12694F(Long.MAX_VALUE);
        m1370j0(m12694F);
        return m12694F;
    }

    /* renamed from: r */
    public final Single<T> m1355r(Action0 action0) {
        return m1365m(new SingleDoAfterTerminate(this, action0));
    }

    /* renamed from: r0 */
    public final Single<T> m1354r0(long j, TimeUnit timeUnit) {
        return m1348u0(j, timeUnit, null, Schedulers.m479a());
    }

    /* renamed from: s */
    public final Single<T> m1353s(Action1<Notification<? extends T>> action1) {
        if (action1 != null) {
            return m1365m(new SingleDoOnEvent(this, new C15616g(action1), new C15617h(action1)));
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    /* renamed from: s0 */
    public final Single<T> m1352s0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1348u0(j, timeUnit, null, scheduler);
    }

    /* renamed from: t */
    public final Single<T> m1351t(Action1<Throwable> action1) {
        if (action1 != null) {
            return m1365m(new SingleDoOnEvent(this, Actions.m1455a(), new C15615f(action1)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    /* renamed from: t0 */
    public final Single<T> m1350t0(long j, TimeUnit timeUnit, Single<? extends T> single) {
        return m1348u0(j, timeUnit, single, Schedulers.m479a());
    }

    /* renamed from: u */
    public final Single<T> m1349u(Action0 action0) {
        return m1365m(new SingleDoOnSubscribe(this.f44830a, action0));
    }

    /* renamed from: u0 */
    public final Single<T> m1348u0(long j, TimeUnit timeUnit, Single<? extends T> single, Scheduler scheduler) {
        if (single == null) {
            single = m1363n(new C15614e());
        }
        return m1365m(new SingleTimeout(this.f44830a, j, timeUnit, scheduler, single.f44830a));
    }

    /* renamed from: v */
    public final Single<T> m1347v(Action1<? super T> action1) {
        if (action1 != null) {
            return m1365m(new SingleDoOnEvent(this, action1, Actions.m1455a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    /* renamed from: v0 */
    public final <R> R m1346v0(Func1<? super Single<T>, R> func1) {
        return func1.call(this);
    }

    /* renamed from: w */
    public final Single<T> m1345w(Action0 action0) {
        return m1365m(new SingleDoOnUnsubscribe(this.f44830a, action0));
    }

    /* renamed from: w0 */
    public final BlockingSingle<T> m1344w0() {
        return BlockingSingle.m449a(this);
    }

    /* renamed from: x0 */
    public final Completable m1342x0() {
        return Completable.m1960K(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: y */
    public final <R> Single<R> m1341y(Func1<? super T, ? extends Single<? extends R>> func1) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).m812Q0(func1);
        }
        return m1395U(m1411J(func1));
    }

    /* renamed from: y0 */
    public final Observable<T> m1340y0() {
        return m1389a(this);
    }

    /* renamed from: z */
    public final Completable m1339z(Func1<? super T, ? extends Completable> func1) {
        return Completable.m1912p(new CompletableFlatMapSingleToCompletable(this, func1));
    }

    /* renamed from: z0 */
    public final Subscription m1338z0(Subscriber<? super T> subscriber) {
        return m1428A0(subscriber, true);
    }

    @Deprecated
    protected Single(Observable.InterfaceC15567a<T> interfaceC15567a) {
        this.f44830a = RxJavaHooks.m577H(new SingleFromObservable(interfaceC15567a));
    }
}
