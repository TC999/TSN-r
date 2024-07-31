package p640rx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p603i2.AssertableSubscriberObservable;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Single;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Actions;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.internal.operators.CompletableFromEmitter;
import p640rx.internal.operators.CompletableOnSubscribeConcat;
import p640rx.internal.operators.CompletableOnSubscribeConcatArray;
import p640rx.internal.operators.CompletableOnSubscribeConcatIterable;
import p640rx.internal.operators.CompletableOnSubscribeMerge;
import p640rx.internal.operators.CompletableOnSubscribeMergeArray;
import p640rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray;
import p640rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable;
import p640rx.internal.operators.CompletableOnSubscribeMergeIterable;
import p640rx.internal.operators.CompletableOnSubscribeTimeout;
import p640rx.internal.util.SubscriptionList;
import p640rx.internal.util.UtilityFunctions;
import p640rx.observers.AssertableSubscriber;
import p640rx.observers.SafeCompletableSubscriber;
import p640rx.observers.SafeSubscriber;
import p640rx.plugins.RxJavaHooks;
import p640rx.schedulers.Schedulers;
import p640rx.subscriptions.BooleanSubscription;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.MultipleAssignmentSubscription;
import p640rx.subscriptions.SerialSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Completable {

    /* renamed from: b */
    static final Completable f44650b = new Completable(new C15541k(), false);

    /* renamed from: c */
    static final Completable f44651c = new Completable(new C15560v(), false);

    /* renamed from: a */
    private final InterfaceC15540j0 f44652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15506a implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Observable f44653a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15507a extends Subscriber<Object> {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44654a;

            C15507a(CompletableSubscriber completableSubscriber) {
                this.f44654a = completableSubscriber;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f44654a.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f44654a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(Object obj) {
            }
        }

        C15506a(Observable observable) {
            this.f44653a = observable;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            C15507a c15507a = new C15507a(completableSubscriber);
            completableSubscriber.mo640a(c15507a);
            this.f44653a.m1822I6(c15507a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$a0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15508a0<T> implements Single.InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Func0 f44656a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$a0$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15509a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ SingleSubscriber f44658a;

            C15509a(SingleSubscriber singleSubscriber) {
                this.f44658a = singleSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44658a.m743b(subscription);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                try {
                    Object call = C15508a0.this.f44656a.call();
                    if (call == null) {
                        this.f44658a.onError(new NullPointerException("The value supplied is null"));
                    } else {
                        this.f44658a.mo446d(call);
                    }
                } catch (Throwable th) {
                    this.f44658a.onError(th);
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                this.f44658a.onError(th);
            }
        }

        C15508a0(Func0 func0) {
            this.f44656a = func0;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Completable.this.m1967G0(new C15509a(singleSubscriber));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15510b implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Single f44660a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15511a extends SingleSubscriber<Object> {

            /* renamed from: b */
            final /* synthetic */ CompletableSubscriber f44661b;

            C15511a(CompletableSubscriber completableSubscriber) {
                this.f44661b = completableSubscriber;
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(Object obj) {
                this.f44661b.onCompleted();
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                this.f44661b.onError(th);
            }
        }

        C15510b(Single single) {
            this.f44660a = single;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            C15511a c15511a = new C15511a(completableSubscriber);
            completableSubscriber.mo640a(c15511a);
            this.f44660a.m1372i0(c15511a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$b0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15512b0<T> implements Func0<T> {

        /* renamed from: a */
        final /* synthetic */ Object f44663a;

        C15512b0(Object obj) {
            this.f44663a = obj;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public T call() {
            return (T) this.f44663a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15513c implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44665a;

        /* renamed from: b */
        final /* synthetic */ long f44666b;

        /* renamed from: c */
        final /* synthetic */ TimeUnit f44667c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15514a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44668a;

            /* renamed from: b */
            final /* synthetic */ Scheduler.AbstractC15607a f44669b;

            C15514a(CompletableSubscriber completableSubscriber, Scheduler.AbstractC15607a abstractC15607a) {
                this.f44668a = completableSubscriber;
                this.f44669b = abstractC15607a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                try {
                    this.f44668a.onCompleted();
                } finally {
                    this.f44669b.unsubscribe();
                }
            }
        }

        C15513c(Scheduler scheduler, long j, TimeUnit timeUnit) {
            this.f44665a = scheduler;
            this.f44666b = j;
            this.f44667c = timeUnit;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            completableSubscriber.mo640a(multipleAssignmentSubscription);
            if (multipleAssignmentSubscription.isUnsubscribed()) {
                return;
            }
            Scheduler.AbstractC15607a mo450a = this.f44665a.mo450a();
            multipleAssignmentSubscription.m355b(mo450a);
            mo450a.mo460F(new C15514a(completableSubscriber, mo450a), this.f44666b, this.f44667c);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$c0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15515c0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44671a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$c0$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15516a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44673a;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$c0$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15517a implements Action0 {

                /* renamed from: a */
                final /* synthetic */ Subscription f44675a;

                /* compiled from: Completable.java */
                /* renamed from: rx.b$c0$a$a$a */
                /* loaded from: E:\fuckcool\tsn\5406560.dex */
                class C15518a implements Action0 {

                    /* renamed from: a */
                    final /* synthetic */ Scheduler.AbstractC15607a f44677a;

                    C15518a(Scheduler.AbstractC15607a abstractC15607a) {
                        this.f44677a = abstractC15607a;
                    }

                    @Override // p640rx.functions.Action0
                    public void call() {
                        try {
                            C15517a.this.f44675a.unsubscribe();
                        } finally {
                            this.f44677a.unsubscribe();
                        }
                    }
                }

                C15517a(Subscription subscription) {
                    this.f44675a = subscription;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    Scheduler.AbstractC15607a mo450a = C15515c0.this.f44671a.mo450a();
                    mo450a.mo456d(new C15518a(mo450a));
                }
            }

            C15516a(CompletableSubscriber completableSubscriber) {
                this.f44673a = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44673a.mo640a(Subscriptions.m346a(new C15517a(subscription)));
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                this.f44673a.onCompleted();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                this.f44673a.onError(th);
            }
        }

        C15515c0(Scheduler scheduler) {
            this.f44671a = scheduler;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            Completable.this.m1967G0(new C15516a(completableSubscriber));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15519d implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Func0 f44679a;

        /* renamed from: b */
        final /* synthetic */ Func1 f44680b;

        /* renamed from: c */
        final /* synthetic */ Action1 f44681c;

        /* renamed from: d */
        final /* synthetic */ boolean f44682d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15520a implements CompletableSubscriber {

            /* renamed from: a */
            Subscription f44683a;

            /* renamed from: b */
            final /* synthetic */ AtomicBoolean f44684b;

            /* renamed from: c */
            final /* synthetic */ Object f44685c;

            /* renamed from: d */
            final /* synthetic */ CompletableSubscriber f44686d;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$d$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15521a implements Action0 {
                C15521a() {
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    C15520a.this.m1890b();
                }
            }

            C15520a(AtomicBoolean atomicBoolean, Object obj, CompletableSubscriber completableSubscriber) {
                this.f44684b = atomicBoolean;
                this.f44685c = obj;
                this.f44686d = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44683a = subscription;
                this.f44686d.mo640a(Subscriptions.m346a(new C15521a()));
            }

            /* renamed from: b */
            void m1890b() {
                this.f44683a.unsubscribe();
                if (this.f44684b.compareAndSet(false, true)) {
                    try {
                        C15519d.this.f44681c.call(this.f44685c);
                    } catch (Throwable th) {
                        RxJavaHooks.m576I(th);
                    }
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                if (C15519d.this.f44682d && this.f44684b.compareAndSet(false, true)) {
                    try {
                        C15519d.this.f44681c.call(this.f44685c);
                    } catch (Throwable th) {
                        this.f44686d.onError(th);
                        return;
                    }
                }
                this.f44686d.onCompleted();
                if (C15519d.this.f44682d) {
                    return;
                }
                m1890b();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (C15519d.this.f44682d && this.f44684b.compareAndSet(false, true)) {
                    try {
                        C15519d.this.f44681c.call(this.f44685c);
                    } catch (Throwable th2) {
                        th = new CompositeException(Arrays.asList(th, th2));
                    }
                }
                this.f44686d.onError(th);
                if (C15519d.this.f44682d) {
                    return;
                }
                m1890b();
            }
        }

        C15519d(Func0 func0, Func1 func1, Action1 action1, boolean z) {
            this.f44679a = func0;
            this.f44680b = func1;
            this.f44681c = action1;
            this.f44682d = z;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            try {
                Object call = this.f44679a.call();
                try {
                    Completable completable = (Completable) this.f44680b.call(call);
                    if (completable == null) {
                        try {
                            this.f44681c.call(call);
                            completableSubscriber.mo640a(Subscriptions.m342e());
                            completableSubscriber.onError(new NullPointerException("The completable supplied is null"));
                            return;
                        } catch (Throwable th) {
                            C15575a.m1474e(th);
                            completableSubscriber.mo640a(Subscriptions.m342e());
                            completableSubscriber.onError(new CompositeException(Arrays.asList(new NullPointerException("The completable supplied is null"), th)));
                            return;
                        }
                    }
                    completable.m1967G0(new C15520a(new AtomicBoolean(), call, completableSubscriber));
                } catch (Throwable th2) {
                    try {
                        this.f44681c.call(call);
                        C15575a.m1474e(th2);
                        completableSubscriber.mo640a(Subscriptions.m342e());
                        completableSubscriber.onError(th2);
                    } catch (Throwable th3) {
                        C15575a.m1474e(th2);
                        C15575a.m1474e(th3);
                        completableSubscriber.mo640a(Subscriptions.m342e());
                        completableSubscriber.onError(new CompositeException(Arrays.asList(th2, th3)));
                    }
                }
            } catch (Throwable th4) {
                completableSubscriber.mo640a(Subscriptions.m342e());
                completableSubscriber.onError(th4);
            }
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$d0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15522d0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Iterable f44689a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$d0$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15523a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ AtomicBoolean f44690a;

            /* renamed from: b */
            final /* synthetic */ CompositeSubscription f44691b;

            /* renamed from: c */
            final /* synthetic */ CompletableSubscriber f44692c;

            C15523a(AtomicBoolean atomicBoolean, CompositeSubscription compositeSubscription, CompletableSubscriber completableSubscriber) {
                this.f44690a = atomicBoolean;
                this.f44691b = compositeSubscription;
                this.f44692c = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44691b.m359a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                if (this.f44690a.compareAndSet(false, true)) {
                    this.f44691b.unsubscribe();
                    this.f44692c.onCompleted();
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (this.f44690a.compareAndSet(false, true)) {
                    this.f44691b.unsubscribe();
                    this.f44692c.onError(th);
                    return;
                }
                RxJavaHooks.m576I(th);
            }
        }

        C15522d0(Iterable iterable) {
            this.f44689a = iterable;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            completableSubscriber.mo640a(compositeSubscription);
            try {
                Iterator it = this.f44689a.iterator();
                if (it == null) {
                    completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                C15523a c15523a = new C15523a(atomicBoolean, compositeSubscription, completableSubscriber);
                boolean z = true;
                while (!atomicBoolean.get() && !compositeSubscription.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            if (z) {
                                completableSubscriber.onCompleted();
                                return;
                            }
                            return;
                        } else if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                            return;
                        } else {
                            try {
                                Completable completable = (Completable) it.next();
                                if (completable == null) {
                                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        compositeSubscription.unsubscribe();
                                        completableSubscriber.onError(nullPointerException);
                                        return;
                                    }
                                    RxJavaHooks.m576I(nullPointerException);
                                    return;
                                } else if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                                    return;
                                } else {
                                    completable.m1967G0(c15523a);
                                    z = false;
                                }
                            } catch (Throwable th) {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    compositeSubscription.unsubscribe();
                                    completableSubscriber.onError(th);
                                    return;
                                }
                                RxJavaHooks.m576I(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onError(th2);
                            return;
                        }
                        RxJavaHooks.m576I(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                completableSubscriber.onError(th3);
            }
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15524e implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f44694a;

        /* renamed from: b */
        final /* synthetic */ Throwable[] f44695b;

        C15524e(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f44694a = countDownLatch;
            this.f44695b = thArr;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44694a.countDown();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f44695b[0] = th;
            this.f44694a.countDown();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$e0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15525e0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Func0 f44697a;

        C15525e0(Func0 func0) {
            this.f44697a = func0;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            try {
                Completable completable = (Completable) this.f44697a.call();
                if (completable == null) {
                    completableSubscriber.mo640a(Subscriptions.m342e());
                    completableSubscriber.onError(new NullPointerException("The completable returned is null"));
                    return;
                }
                completable.m1967G0(completableSubscriber);
            } catch (Throwable th) {
                completableSubscriber.mo640a(Subscriptions.m342e());
                completableSubscriber.onError(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15526f implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f44698a;

        /* renamed from: b */
        final /* synthetic */ Throwable[] f44699b;

        C15526f(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f44698a = countDownLatch;
            this.f44699b = thArr;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44698a.countDown();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f44699b[0] = th;
            this.f44698a.countDown();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$f0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15527f0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Func0 f44701a;

        C15527f0(Func0 func0) {
            this.f44701a = func0;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.mo640a(Subscriptions.m342e());
            try {
                th = (Throwable) this.f44701a.call();
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                th = new NullPointerException("The error supplied is null");
            }
            completableSubscriber.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15528g implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44702a;

        /* renamed from: b */
        final /* synthetic */ long f44703b;

        /* renamed from: c */
        final /* synthetic */ TimeUnit f44704c;

        /* renamed from: d */
        final /* synthetic */ boolean f44705d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$g$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15529a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ CompositeSubscription f44707a;

            /* renamed from: b */
            final /* synthetic */ Scheduler.AbstractC15607a f44708b;

            /* renamed from: c */
            final /* synthetic */ CompletableSubscriber f44709c;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$g$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15530a implements Action0 {
                C15530a() {
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15529a.this.f44709c.onCompleted();
                    } finally {
                        C15529a.this.f44708b.unsubscribe();
                    }
                }
            }

            /* compiled from: Completable.java */
            /* renamed from: rx.b$g$a$b */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15531b implements Action0 {

                /* renamed from: a */
                final /* synthetic */ Throwable f44712a;

                C15531b(Throwable th) {
                    this.f44712a = th;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15529a.this.f44709c.onError(this.f44712a);
                    } finally {
                        C15529a.this.f44708b.unsubscribe();
                    }
                }
            }

            C15529a(CompositeSubscription compositeSubscription, Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber) {
                this.f44707a = compositeSubscription;
                this.f44708b = abstractC15607a;
                this.f44709c = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44707a.m359a(subscription);
                this.f44709c.mo640a(this.f44707a);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                CompositeSubscription compositeSubscription = this.f44707a;
                Scheduler.AbstractC15607a abstractC15607a = this.f44708b;
                C15530a c15530a = new C15530a();
                C15528g c15528g = C15528g.this;
                compositeSubscription.m359a(abstractC15607a.mo460F(c15530a, c15528g.f44703b, c15528g.f44704c));
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (C15528g.this.f44705d) {
                    CompositeSubscription compositeSubscription = this.f44707a;
                    Scheduler.AbstractC15607a abstractC15607a = this.f44708b;
                    C15531b c15531b = new C15531b(th);
                    C15528g c15528g = C15528g.this;
                    compositeSubscription.m359a(abstractC15607a.mo460F(c15531b, c15528g.f44703b, c15528g.f44704c));
                    return;
                }
                this.f44709c.onError(th);
            }
        }

        C15528g(Scheduler scheduler, long j, TimeUnit timeUnit, boolean z) {
            this.f44702a = scheduler;
            this.f44703b = j;
            this.f44704c = timeUnit;
            this.f44705d = z;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            Scheduler.AbstractC15607a mo450a = this.f44702a.mo450a();
            compositeSubscription.m359a(mo450a);
            Completable.this.m1967G0(new C15529a(compositeSubscription, mo450a, completableSubscriber));
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$g0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15532g0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Throwable f44714a;

        C15532g0(Throwable th) {
            this.f44714a = th;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.mo640a(Subscriptions.m342e());
            completableSubscriber.onError(this.f44714a);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15533h implements Action1<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Action1 f44715a;

        C15533h(Action1 action1) {
            this.f44715a = action1;
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            this.f44715a.call(Notification.m2003d(th));
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$h0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15534h0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Action0 f44717a;

        C15534h0(Action0 action0) {
            this.f44717a = action0;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            BooleanSubscription booleanSubscription = new BooleanSubscription();
            completableSubscriber.mo640a(booleanSubscription);
            try {
                this.f44717a.call();
                if (booleanSubscription.isUnsubscribed()) {
                    return;
                }
                completableSubscriber.onCompleted();
            } catch (Throwable th) {
                if (booleanSubscription.isUnsubscribed()) {
                    return;
                }
                completableSubscriber.onError(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15535i implements Action0 {

        /* renamed from: a */
        final /* synthetic */ Action1 f44718a;

        C15535i(Action1 action1) {
            this.f44718a = action1;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f44718a.call(Notification.m2005b());
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$i0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15536i0 implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Callable f44720a;

        C15536i0(Callable callable) {
            this.f44720a = callable;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            BooleanSubscription booleanSubscription = new BooleanSubscription();
            completableSubscriber.mo640a(booleanSubscription);
            try {
                this.f44720a.call();
                if (booleanSubscription.isUnsubscribed()) {
                    return;
                }
                completableSubscriber.onCompleted();
            } catch (Throwable th) {
                if (booleanSubscription.isUnsubscribed()) {
                    return;
                }
                completableSubscriber.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15537j implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Action0 f44721a;

        /* renamed from: b */
        final /* synthetic */ Action0 f44722b;

        /* renamed from: c */
        final /* synthetic */ Action1 f44723c;

        /* renamed from: d */
        final /* synthetic */ Action1 f44724d;

        /* renamed from: e */
        final /* synthetic */ Action0 f44725e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$j$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15538a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44727a;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$j$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15539a implements Action0 {

                /* renamed from: a */
                final /* synthetic */ Subscription f44729a;

                C15539a(Subscription subscription) {
                    this.f44729a = subscription;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15537j.this.f44725e.call();
                    } catch (Throwable th) {
                        RxJavaHooks.m576I(th);
                    }
                    this.f44729a.unsubscribe();
                }
            }

            C15538a(CompletableSubscriber completableSubscriber) {
                this.f44727a = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                try {
                    C15537j.this.f44724d.call(subscription);
                    this.f44727a.mo640a(Subscriptions.m346a(new C15539a(subscription)));
                } catch (Throwable th) {
                    subscription.unsubscribe();
                    this.f44727a.mo640a(Subscriptions.m342e());
                    this.f44727a.onError(th);
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                try {
                    C15537j.this.f44721a.call();
                    this.f44727a.onCompleted();
                    try {
                        C15537j.this.f44722b.call();
                    } catch (Throwable th) {
                        RxJavaHooks.m576I(th);
                    }
                } catch (Throwable th2) {
                    this.f44727a.onError(th2);
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                try {
                    C15537j.this.f44723c.call(th);
                } catch (Throwable th2) {
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                this.f44727a.onError(th);
                try {
                    C15537j.this.f44722b.call();
                } catch (Throwable th3) {
                    RxJavaHooks.m576I(th3);
                }
            }
        }

        C15537j(Action0 action0, Action0 action02, Action1 action1, Action1 action12, Action0 action03) {
            this.f44721a = action0;
            this.f44722b = action02;
            this.f44723c = action1;
            this.f44724d = action12;
            this.f44725e = action03;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            Completable.this.m1967G0(new C15538a(completableSubscriber));
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$j0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15540j0 extends Action1<CompletableSubscriber> {
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15541k implements InterfaceC15540j0 {
        C15541k() {
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.mo640a(Subscriptions.m342e());
            completableSubscriber.onCompleted();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$k0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15542k0 extends Func1<CompletableSubscriber, CompletableSubscriber> {
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15543l implements Action1<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Action0 f44731a;

        C15543l(Action0 action0) {
            this.f44731a = action0;
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            this.f44731a.call();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$l0 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15544l0 extends Func1<Completable, Completable> {
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15545m implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f44733a;

        /* renamed from: b */
        final /* synthetic */ Throwable[] f44734b;

        C15545m(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f44733a = countDownLatch;
            this.f44734b = thArr;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44733a.countDown();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f44734b[0] = th;
            this.f44733a.countDown();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15546n implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f44736a;

        /* renamed from: b */
        final /* synthetic */ Throwable[] f44737b;

        C15546n(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f44736a = countDownLatch;
            this.f44737b = thArr;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44736a.countDown();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f44737b[0] = th;
            this.f44736a.countDown();
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$o */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15547o implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15542k0 f44739a;

        C15547o(InterfaceC15542k0 interfaceC15542k0) {
            this.f44739a = interfaceC15542k0;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            try {
                Completable.this.m1967G0(RxJavaHooks.m582C(this.f44739a).call(completableSubscriber));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                throw Completable.m1975C0(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$p */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15548p implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44741a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$p$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15549a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ Scheduler.AbstractC15607a f44743a;

            /* renamed from: b */
            final /* synthetic */ CompletableSubscriber f44744b;

            /* renamed from: c */
            final /* synthetic */ SubscriptionList f44745c;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$p$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15550a implements Action0 {
                C15550a() {
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15549a.this.f44744b.onCompleted();
                    } finally {
                        C15549a.this.f44745c.unsubscribe();
                    }
                }
            }

            /* compiled from: Completable.java */
            /* renamed from: rx.b$p$a$b */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15551b implements Action0 {

                /* renamed from: a */
                final /* synthetic */ Throwable f44748a;

                C15551b(Throwable th) {
                    this.f44748a = th;
                }

                @Override // p640rx.functions.Action0
                public void call() {
                    try {
                        C15549a.this.f44744b.onError(this.f44748a);
                    } finally {
                        C15549a.this.f44745c.unsubscribe();
                    }
                }
            }

            C15549a(Scheduler.AbstractC15607a abstractC15607a, CompletableSubscriber completableSubscriber, SubscriptionList subscriptionList) {
                this.f44743a = abstractC15607a;
                this.f44744b = completableSubscriber;
                this.f44745c = subscriptionList;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44745c.m808a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                this.f44743a.mo456d(new C15550a());
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                this.f44743a.mo456d(new C15551b(th));
            }
        }

        C15548p(Scheduler scheduler) {
            this.f44741a = scheduler;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            SubscriptionList subscriptionList = new SubscriptionList();
            Scheduler.AbstractC15607a mo450a = this.f44741a.mo450a();
            subscriptionList.m808a(mo450a);
            completableSubscriber.mo640a(subscriptionList);
            Completable.this.m1967G0(new C15549a(mo450a, completableSubscriber, subscriptionList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$q */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15552q implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Func1 f44750a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$q$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15553a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44752a;

            C15553a(CompletableSubscriber completableSubscriber) {
                this.f44752a = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44752a.mo640a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                this.f44752a.onCompleted();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                boolean z = false;
                try {
                    z = ((Boolean) C15552q.this.f44750a.call(th)).booleanValue();
                } catch (Throwable th2) {
                    C15575a.m1474e(th2);
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                if (z) {
                    this.f44752a.onCompleted();
                } else {
                    this.f44752a.onError(th);
                }
            }
        }

        C15552q(Func1 func1) {
            this.f44750a = func1;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            Completable.this.m1967G0(new C15553a(completableSubscriber));
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$r */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15554r implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Func1 f44754a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$r$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15555a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44756a;

            /* renamed from: b */
            final /* synthetic */ SerialSubscription f44757b;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$r$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            class C15556a implements CompletableSubscriber {
                C15556a() {
                }

                @Override // p640rx.CompletableSubscriber
                /* renamed from: a */
                public void mo640a(Subscription subscription) {
                    C15555a.this.f44757b.m347b(subscription);
                }

                @Override // p640rx.CompletableSubscriber
                public void onCompleted() {
                    C15555a.this.f44756a.onCompleted();
                }

                @Override // p640rx.CompletableSubscriber
                public void onError(Throwable th) {
                    C15555a.this.f44756a.onError(th);
                }
            }

            C15555a(CompletableSubscriber completableSubscriber, SerialSubscription serialSubscription) {
                this.f44756a = completableSubscriber;
                this.f44757b = serialSubscription;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44757b.m347b(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                this.f44756a.onCompleted();
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                try {
                    Completable completable = (Completable) C15554r.this.f44754a.call(th);
                    if (completable == null) {
                        this.f44756a.onError(new CompositeException(Arrays.asList(th, new NullPointerException("The completable returned is null"))));
                    } else {
                        completable.m1967G0(new C15556a());
                    }
                } catch (Throwable th2) {
                    this.f44756a.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        C15554r(Func1 func1) {
            this.f44754a = func1;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            SerialSubscription serialSubscription = new SerialSubscription();
            completableSubscriber.mo640a(serialSubscription);
            Completable.this.m1967G0(new C15555a(completableSubscriber, serialSubscription));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$s */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15557s implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ MultipleAssignmentSubscription f44760a;

        C15557s(MultipleAssignmentSubscription multipleAssignmentSubscription) {
            this.f44760a = multipleAssignmentSubscription;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f44760a.m355b(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44760a.unsubscribe();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            RxJavaHooks.m576I(th);
            this.f44760a.unsubscribe();
            Completable.m1902u(th);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$t */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15558t implements CompletableSubscriber {

        /* renamed from: a */
        boolean f44762a;

        /* renamed from: b */
        final /* synthetic */ Action0 f44763b;

        /* renamed from: c */
        final /* synthetic */ MultipleAssignmentSubscription f44764c;

        C15558t(Action0 action0, MultipleAssignmentSubscription multipleAssignmentSubscription) {
            this.f44763b = action0;
            this.f44764c = multipleAssignmentSubscription;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f44764c.m355b(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            if (this.f44762a) {
                return;
            }
            this.f44762a = true;
            try {
                this.f44763b.call();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            RxJavaHooks.m576I(th);
            this.f44764c.unsubscribe();
            Completable.m1902u(th);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$u */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15559u implements CompletableSubscriber {

        /* renamed from: a */
        boolean f44766a;

        /* renamed from: b */
        final /* synthetic */ Action0 f44767b;

        /* renamed from: c */
        final /* synthetic */ MultipleAssignmentSubscription f44768c;

        /* renamed from: d */
        final /* synthetic */ Action1 f44769d;

        C15559u(Action0 action0, MultipleAssignmentSubscription multipleAssignmentSubscription, Action1 action1) {
            this.f44767b = action0;
            this.f44768c = multipleAssignmentSubscription;
            this.f44769d = action1;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f44768c.m355b(subscription);
        }

        /* renamed from: b */
        void m1889b(Throwable th) {
            try {
                this.f44769d.call(th);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            if (this.f44766a) {
                return;
            }
            this.f44766a = true;
            try {
                this.f44767b.call();
                this.f44768c.unsubscribe();
            } catch (Throwable th) {
                m1889b(th);
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            if (!this.f44766a) {
                this.f44766a = true;
                m1889b(th);
                return;
            }
            RxJavaHooks.m576I(th);
            Completable.m1902u(th);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$v */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15560v implements InterfaceC15540j0 {
        C15560v() {
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.mo640a(Subscriptions.m342e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$w */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15561w implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Completable[] f44771a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$w$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15562a implements CompletableSubscriber {

            /* renamed from: a */
            final /* synthetic */ AtomicBoolean f44772a;

            /* renamed from: b */
            final /* synthetic */ CompositeSubscription f44773b;

            /* renamed from: c */
            final /* synthetic */ CompletableSubscriber f44774c;

            C15562a(AtomicBoolean atomicBoolean, CompositeSubscription compositeSubscription, CompletableSubscriber completableSubscriber) {
                this.f44772a = atomicBoolean;
                this.f44773b = compositeSubscription;
                this.f44774c = completableSubscriber;
            }

            @Override // p640rx.CompletableSubscriber
            /* renamed from: a */
            public void mo640a(Subscription subscription) {
                this.f44773b.m359a(subscription);
            }

            @Override // p640rx.CompletableSubscriber
            public void onCompleted() {
                if (this.f44772a.compareAndSet(false, true)) {
                    this.f44773b.unsubscribe();
                    this.f44774c.onCompleted();
                }
            }

            @Override // p640rx.CompletableSubscriber
            public void onError(Throwable th) {
                if (this.f44772a.compareAndSet(false, true)) {
                    this.f44773b.unsubscribe();
                    this.f44774c.onError(th);
                    return;
                }
                RxJavaHooks.m576I(th);
            }
        }

        C15561w(Completable[] completableArr) {
            this.f44771a = completableArr;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            Completable[] completableArr;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            completableSubscriber.mo640a(compositeSubscription);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            C15562a c15562a = new C15562a(atomicBoolean, compositeSubscription, completableSubscriber);
            for (Completable completable : this.f44771a) {
                if (compositeSubscription.isUnsubscribed()) {
                    return;
                }
                if (completable == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeSubscription.unsubscribe();
                        completableSubscriber.onError(nullPointerException);
                        return;
                    }
                    RxJavaHooks.m576I(nullPointerException);
                    return;
                } else if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                    return;
                } else {
                    completable.m1967G0(c15562a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$x */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15563x implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ Subscriber f44776a;

        C15563x(Subscriber subscriber) {
            this.f44776a = subscriber;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f44776a.add(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f44776a.onCompleted();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f44776a.onError(th);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$y */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15564y implements InterfaceC15540j0 {

        /* renamed from: a */
        final /* synthetic */ Scheduler f44778a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$y$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15565a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ CompletableSubscriber f44780a;

            /* renamed from: b */
            final /* synthetic */ Scheduler.AbstractC15607a f44781b;

            C15565a(CompletableSubscriber completableSubscriber, Scheduler.AbstractC15607a abstractC15607a) {
                this.f44780a = completableSubscriber;
                this.f44781b = abstractC15607a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                try {
                    Completable.this.m1967G0(this.f44780a);
                } finally {
                    this.f44781b.unsubscribe();
                }
            }
        }

        C15564y(Scheduler scheduler) {
            this.f44778a = scheduler;
        }

        @Override // p640rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            Scheduler.AbstractC15607a mo450a = this.f44778a.mo450a();
            mo450a.mo456d(new C15565a(completableSubscriber, mo450a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$z */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15566z<T> implements Observable.InterfaceC15567a<T> {
        C15566z() {
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            Completable.this.m1965H0(subscriber);
        }
    }

    protected Completable(InterfaceC15540j0 interfaceC15540j0) {
        this.f44652a = RxJavaHooks.m579F(interfaceC15540j0);
    }

    /* renamed from: A0 */
    public static Completable m1979A0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        m1929g0(timeUnit);
        m1929g0(scheduler);
        return m1912p(new C15513c(scheduler, j, timeUnit));
    }

    /* renamed from: C0 */
    static NullPointerException m1975C0(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    /* renamed from: D */
    public static Completable m1974D(Throwable th) {
        m1929g0(th);
        return m1912p(new C15532g0(th));
    }

    /* renamed from: E */
    public static Completable m1972E(Func0<? extends Throwable> func0) {
        m1929g0(func0);
        return m1912p(new C15527f0(func0));
    }

    /* renamed from: F */
    public static Completable m1970F(Action0 action0) {
        m1929g0(action0);
        return m1912p(new C15534h0(action0));
    }

    /* renamed from: G */
    public static Completable m1968G(Callable<?> callable) {
        m1929g0(callable);
        return m1912p(new C15536i0(callable));
    }

    /* renamed from: H */
    public static Completable m1966H(Action1<CompletableEmitter> action1) {
        return m1912p(new CompletableFromEmitter(action1));
    }

    /* renamed from: I */
    public static Completable m1964I(Future<?> future) {
        m1929g0(future);
        return m1962J(Observable.m1514v2(future));
    }

    /* renamed from: I0 */
    private <T> void m1963I0(Subscriber<T> subscriber, boolean z) {
        m1929g0(subscriber);
        if (z) {
            try {
                subscriber.onStart();
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                C15575a.m1474e(th);
                Throwable m573L = RxJavaHooks.m573L(th);
                RxJavaHooks.m576I(m573L);
                throw m1975C0(m573L);
            }
        }
        m1967G0(new C15563x(subscriber));
        RxJavaHooks.m571N(subscriber);
    }

    /* renamed from: J */
    public static Completable m1962J(Observable<?> observable) {
        m1929g0(observable);
        return m1912p(new C15506a(observable));
    }

    /* renamed from: K */
    public static Completable m1960K(Single<?> single) {
        m1929g0(single);
        return m1912p(new C15510b(single));
    }

    /* renamed from: K0 */
    public static <R> Completable m1959K0(Func0<R> func0, Func1<? super R, ? extends Completable> func1, Action1<? super R> action1) {
        return m1957L0(func0, func1, action1, true);
    }

    /* renamed from: L0 */
    public static <R> Completable m1957L0(Func0<R> func0, Func1<? super R, ? extends Completable> func1, Action1<? super R> action1, boolean z) {
        m1929g0(func0);
        m1929g0(func1);
        m1929g0(action1);
        return m1912p(new C15519d(func0, func1, action1, z));
    }

    /* renamed from: O */
    public static Completable m1954O(Iterable<? extends Completable> iterable) {
        m1929g0(iterable);
        return m1912p(new CompletableOnSubscribeMergeIterable(iterable));
    }

    /* renamed from: P */
    public static Completable m1953P(Observable<? extends Completable> observable) {
        return m1950S(observable, Integer.MAX_VALUE, false);
    }

    /* renamed from: Q */
    public static Completable m1952Q(Observable<? extends Completable> observable, int i) {
        return m1950S(observable, i, false);
    }

    /* renamed from: R */
    public static Completable m1951R(Completable... completableArr) {
        m1929g0(completableArr);
        if (completableArr.length == 0) {
            return m1926i();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return m1912p(new CompletableOnSubscribeMergeArray(completableArr));
    }

    /* renamed from: S */
    protected static Completable m1950S(Observable<? extends Completable> observable, int i, boolean z) {
        m1929g0(observable);
        if (i >= 1) {
            return m1912p(new CompletableOnSubscribeMerge(observable, i, z));
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i);
    }

    /* renamed from: T */
    public static Completable m1949T(Iterable<? extends Completable> iterable) {
        m1929g0(iterable);
        return m1912p(new CompletableOnSubscribeMergeDelayErrorIterable(iterable));
    }

    /* renamed from: U */
    public static Completable m1948U(Observable<? extends Completable> observable) {
        return m1950S(observable, Integer.MAX_VALUE, true);
    }

    /* renamed from: V */
    public static Completable m1947V(Observable<? extends Completable> observable, int i) {
        return m1950S(observable, i, true);
    }

    /* renamed from: W */
    public static Completable m1946W(Completable... completableArr) {
        m1929g0(completableArr);
        return m1912p(new CompletableOnSubscribeMergeDelayErrorArray(completableArr));
    }

    /* renamed from: Y */
    public static Completable m1944Y() {
        Completable completable = f44651c;
        InterfaceC15540j0 m579F = RxJavaHooks.m579F(completable.f44652a);
        return m579F == completable.f44652a ? completable : new Completable(m579F, false);
    }

    /* renamed from: a */
    public static Completable m1942a(Iterable<? extends Completable> iterable) {
        m1929g0(iterable);
        return m1912p(new C15522d0(iterable));
    }

    /* renamed from: b */
    public static Completable m1940b(Completable... completableArr) {
        m1929g0(completableArr);
        if (completableArr.length == 0) {
            return m1926i();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return m1912p(new C15561w(completableArr));
    }

    /* renamed from: g0 */
    static <T> T m1929g0(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: i */
    public static Completable m1926i() {
        Completable completable = f44650b;
        InterfaceC15540j0 m579F = RxJavaHooks.m579F(completable.f44652a);
        return m579F == completable.f44652a ? completable : new Completable(m579F, false);
    }

    /* renamed from: k */
    public static Completable m1922k(Iterable<? extends Completable> iterable) {
        m1929g0(iterable);
        return m1912p(new CompletableOnSubscribeConcatIterable(iterable));
    }

    /* renamed from: l */
    public static Completable m1920l(Observable<? extends Completable> observable) {
        return m1918m(observable, 2);
    }

    /* renamed from: m */
    public static Completable m1918m(Observable<? extends Completable> observable, int i) {
        m1929g0(observable);
        if (i >= 1) {
            return m1912p(new CompletableOnSubscribeConcat(observable, i));
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
    }

    /* renamed from: n */
    public static Completable m1916n(Completable... completableArr) {
        m1929g0(completableArr);
        if (completableArr.length == 0) {
            return m1926i();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return m1912p(new CompletableOnSubscribeConcatArray(completableArr));
    }

    /* renamed from: p */
    public static Completable m1912p(InterfaceC15540j0 interfaceC15540j0) {
        m1929g0(interfaceC15540j0);
        try {
            return new Completable(interfaceC15540j0);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            RxJavaHooks.m576I(th);
            throw m1975C0(th);
        }
    }

    /* renamed from: q */
    public static Completable m1910q(Func0<? extends Completable> func0) {
        m1929g0(func0);
        return m1912p(new C15525e0(func0));
    }

    /* renamed from: u */
    static void m1902u(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: z0 */
    public static Completable m1891z0(long j, TimeUnit timeUnit) {
        return m1979A0(j, timeUnit, Schedulers.m479a());
    }

    /* renamed from: A */
    public final Completable m1980A(Action1<? super Subscription> action1) {
        return m1892z(action1, Actions.m1455a(), Actions.m1455a(), Actions.m1455a(), Actions.m1455a());
    }

    /* renamed from: B */
    public final Completable m1978B(Action0 action0) {
        return m1892z(Actions.m1455a(), new C15543l(action0), action0, Actions.m1455a(), Actions.m1455a());
    }

    /* renamed from: B0 */
    public final <R> R m1977B0(Func1<? super Completable, R> func1) {
        return func1.call(this);
    }

    /* renamed from: C */
    public final Completable m1976C(Action0 action0) {
        return m1892z(Actions.m1455a(), Actions.m1455a(), Actions.m1455a(), Actions.m1455a(), action0);
    }

    /* renamed from: D0 */
    public final <T> Observable<T> m1973D0() {
        return Observable.m1830H6(new C15566z());
    }

    /* renamed from: E0 */
    public final <T> Single<T> m1971E0(Func0<? extends T> func0) {
        m1929g0(func0);
        return Single.m1365m(new C15508a0(func0));
    }

    /* renamed from: F0 */
    public final <T> Single<T> m1969F0(T t) {
        m1929g0(t);
        return m1971E0(new C15512b0(t));
    }

    /* renamed from: G0 */
    public final void m1967G0(CompletableSubscriber completableSubscriber) {
        m1929g0(completableSubscriber);
        try {
            RxJavaHooks.m581D(this, this.f44652a).call(completableSubscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C15575a.m1474e(th);
            Throwable m583B = RxJavaHooks.m583B(th);
            RxJavaHooks.m576I(m583B);
            throw m1975C0(m583B);
        }
    }

    /* renamed from: H0 */
    public final <T> void m1965H0(Subscriber<T> subscriber) {
        m1963I0(subscriber, true);
    }

    /* renamed from: J0 */
    public final Completable m1961J0(Scheduler scheduler) {
        m1929g0(scheduler);
        return m1912p(new C15515c0(scheduler));
    }

    /* renamed from: L */
    public final Throwable m1958L() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        m1967G0(new C15545m(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            countDownLatch.await();
            return thArr[0];
        } catch (InterruptedException e) {
            throw C15575a.m1476c(e);
        }
    }

    /* renamed from: M */
    public final Throwable m1956M(long j, TimeUnit timeUnit) {
        m1929g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        m1967G0(new C15546n(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            if (countDownLatch.await(j, timeUnit)) {
                return thArr[0];
            }
            C15575a.m1476c(new TimeoutException());
            return null;
        } catch (InterruptedException e) {
            throw C15575a.m1476c(e);
        }
    }

    /* renamed from: N */
    public final Completable m1955N(InterfaceC15542k0 interfaceC15542k0) {
        m1929g0(interfaceC15542k0);
        return m1912p(new C15547o(interfaceC15542k0));
    }

    /* renamed from: X */
    public final Completable m1945X(Completable completable) {
        m1929g0(completable);
        return m1951R(this, completable);
    }

    /* renamed from: Z */
    public final Completable m1943Z(Scheduler scheduler) {
        m1929g0(scheduler);
        return m1912p(new C15548p(scheduler));
    }

    /* renamed from: a0 */
    public final Completable m1941a0() {
        return m1939b0(UtilityFunctions.m804b());
    }

    /* renamed from: b0 */
    public final Completable m1939b0(Func1<? super Throwable, Boolean> func1) {
        m1929g0(func1);
        return m1912p(new C15552q(func1));
    }

    /* renamed from: c */
    public final Completable m1938c(Completable completable) {
        m1929g0(completable);
        return m1940b(this, completable);
    }

    /* renamed from: c0 */
    public final Completable m1937c0(Func1<? super Throwable, ? extends Completable> func1) {
        m1929g0(func1);
        return m1912p(new C15554r(func1));
    }

    /* renamed from: d */
    public final Completable m1936d(Completable completable) {
        return m1914o(completable);
    }

    /* renamed from: d0 */
    public final Completable m1935d0() {
        return m1962J(m1973D0().m1640f4());
    }

    /* renamed from: e */
    public final <T> Observable<T> m1934e(Observable<T> observable) {
        m1929g0(observable);
        return observable.m1494y1(m1973D0());
    }

    /* renamed from: e0 */
    public final Completable m1933e0(long j) {
        return m1962J(m1973D0().m1632g4(j));
    }

    /* renamed from: f */
    public final <T> Single<T> m1932f(Single<T> single) {
        m1929g0(single);
        return single.m1357q(m1973D0());
    }

    /* renamed from: f0 */
    public final Completable m1931f0(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        m1929g0(func1);
        return m1962J(m1973D0().m1608j4(func1));
    }

    /* renamed from: g */
    public final void m1930g() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        m1967G0(new C15524e(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                C15575a.m1476c(thArr[0]);
                return;
            }
            return;
        }
        try {
            countDownLatch.await();
            if (thArr[0] != null) {
                C15575a.m1476c(thArr[0]);
            }
        } catch (InterruptedException e) {
            throw C15575a.m1476c(e);
        }
    }

    /* renamed from: h */
    public final boolean m1928h(long j, TimeUnit timeUnit) {
        m1929g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        m1967G0(new C15526f(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                C15575a.m1476c(thArr[0]);
            }
            return true;
        }
        try {
            boolean await = countDownLatch.await(j, timeUnit);
            if (await && thArr[0] != null) {
                C15575a.m1476c(thArr[0]);
            }
            return await;
        } catch (InterruptedException e) {
            throw C15575a.m1476c(e);
        }
    }

    /* renamed from: h0 */
    public final Completable m1927h0() {
        return m1962J(m1973D0().m1877B4());
    }

    /* renamed from: i0 */
    public final Completable m1925i0(long j) {
        return m1962J(m1973D0().m1870C4(j));
    }

    /* renamed from: j */
    public final Completable m1924j(InterfaceC15544l0 interfaceC15544l0) {
        return (Completable) m1977B0(interfaceC15544l0);
    }

    /* renamed from: j0 */
    public final Completable m1923j0(Func2<Integer, Throwable, Boolean> func2) {
        return m1962J(m1973D0().m1863D4(func2));
    }

    /* renamed from: k0 */
    public final Completable m1921k0(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return m1962J(m1973D0().m1856E4(func1));
    }

    /* renamed from: l0 */
    public final Completable m1919l0(Completable completable) {
        m1929g0(completable);
        return m1916n(completable, this);
    }

    /* renamed from: m0 */
    public final <T> Observable<T> m1917m0(Observable<T> observable) {
        m1929g0(observable);
        return m1973D0().m1575n5(observable);
    }

    /* renamed from: n0 */
    public final Subscription m1915n0() {
        MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        m1967G0(new C15557s(multipleAssignmentSubscription));
        return multipleAssignmentSubscription;
    }

    /* renamed from: o */
    public final Completable m1914o(Completable completable) {
        m1929g0(completable);
        return m1916n(this, completable);
    }

    /* renamed from: o0 */
    public final Subscription m1913o0(Action0 action0) {
        m1929g0(action0);
        MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        m1967G0(new C15558t(action0, multipleAssignmentSubscription));
        return multipleAssignmentSubscription;
    }

    /* renamed from: p0 */
    public final Subscription m1911p0(Action0 action0, Action1<? super Throwable> action1) {
        m1929g0(action0);
        m1929g0(action1);
        MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        m1967G0(new C15559u(action0, multipleAssignmentSubscription, action1));
        return multipleAssignmentSubscription;
    }

    /* renamed from: q0 */
    public final void m1909q0(CompletableSubscriber completableSubscriber) {
        if (!(completableSubscriber instanceof SafeCompletableSubscriber)) {
            completableSubscriber = new SafeCompletableSubscriber(completableSubscriber);
        }
        m1967G0(completableSubscriber);
    }

    /* renamed from: r */
    public final Completable m1908r(long j, TimeUnit timeUnit) {
        return m1904t(j, timeUnit, Schedulers.m479a(), false);
    }

    /* renamed from: r0 */
    public final <T> void m1907r0(Subscriber<T> subscriber) {
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber(subscriber);
        }
        m1963I0(subscriber, false);
    }

    /* renamed from: s */
    public final Completable m1906s(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1904t(j, timeUnit, scheduler, false);
    }

    /* renamed from: s0 */
    public final Completable m1905s0(Scheduler scheduler) {
        m1929g0(scheduler);
        return m1912p(new C15564y(scheduler));
    }

    /* renamed from: t */
    public final Completable m1904t(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        m1929g0(timeUnit);
        m1929g0(scheduler);
        return m1912p(new C15528g(scheduler, j, timeUnit, z));
    }

    /* renamed from: t0 */
    public final AssertableSubscriber<Void> m1903t0() {
        AssertableSubscriberObservable m12694F = AssertableSubscriberObservable.m12694F(Long.MAX_VALUE);
        m1907r0(m12694F);
        return m12694F;
    }

    /* renamed from: u0 */
    public final Completable m1901u0(long j, TimeUnit timeUnit) {
        return m1893y0(j, timeUnit, Schedulers.m479a(), null);
    }

    /* renamed from: v */
    public final Completable m1900v(Action0 action0) {
        return m1892z(Actions.m1455a(), Actions.m1455a(), Actions.m1455a(), action0, Actions.m1455a());
    }

    /* renamed from: v0 */
    public final Completable m1899v0(long j, TimeUnit timeUnit, Completable completable) {
        m1929g0(completable);
        return m1893y0(j, timeUnit, Schedulers.m479a(), completable);
    }

    /* renamed from: w */
    public final Completable m1898w(Action0 action0) {
        return m1892z(Actions.m1455a(), Actions.m1455a(), action0, Actions.m1455a(), Actions.m1455a());
    }

    /* renamed from: w0 */
    public final Completable m1897w0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m1893y0(j, timeUnit, scheduler, null);
    }

    /* renamed from: x */
    public final Completable m1896x(Action1<Notification<Object>> action1) {
        if (action1 != null) {
            return m1892z(Actions.m1455a(), new C15533h(action1), new C15535i(action1), Actions.m1455a(), Actions.m1455a());
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    /* renamed from: x0 */
    public final Completable m1895x0(long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        m1929g0(completable);
        return m1893y0(j, timeUnit, scheduler, completable);
    }

    /* renamed from: y */
    public final Completable m1894y(Action1<? super Throwable> action1) {
        return m1892z(Actions.m1455a(), action1, Actions.m1455a(), Actions.m1455a(), Actions.m1455a());
    }

    /* renamed from: y0 */
    public final Completable m1893y0(long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        m1929g0(timeUnit);
        m1929g0(scheduler);
        return m1912p(new CompletableOnSubscribeTimeout(this, j, timeUnit, scheduler, completable));
    }

    /* renamed from: z */
    protected final Completable m1892z(Action1<? super Subscription> action1, Action1<? super Throwable> action12, Action0 action0, Action0 action02, Action0 action03) {
        m1929g0(action1);
        m1929g0(action12);
        m1929g0(action0);
        m1929g0(action02);
        m1929g0(action03);
        return m1912p(new C15537j(action0, action02, action12, action1, action03));
    }

    protected Completable(InterfaceC15540j0 interfaceC15540j0, boolean z) {
        this.f44652a = z ? RxJavaHooks.m579F(interfaceC15540j0) : interfaceC15540j0;
    }
}
