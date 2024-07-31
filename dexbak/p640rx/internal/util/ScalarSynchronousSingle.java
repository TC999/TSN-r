package p640rx.internal.util;

import p640rx.Scheduler;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.internal.schedulers.EventLoopsScheduler;

/* renamed from: rx.internal.util.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ScalarSynchronousSingle<T> extends Single<T> {

    /* renamed from: b */
    final T f46533b;

    /* compiled from: ScalarSynchronousSingle.java */
    /* renamed from: rx.internal.util.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16057a implements Single.InterfaceC15633t<T> {

        /* renamed from: a */
        final /* synthetic */ Object f46534a;

        C16057a(Object obj) {
            this.f46534a = obj;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.mo446d((Object) this.f46534a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousSingle.java */
    /* renamed from: rx.internal.util.l$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16058b<R> implements Single.InterfaceC15633t<R> {

        /* renamed from: a */
        final /* synthetic */ Func1 f46535a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ScalarSynchronousSingle.java */
        /* renamed from: rx.internal.util.l$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16059a extends SingleSubscriber<R> {

            /* renamed from: b */
            final /* synthetic */ SingleSubscriber f46537b;

            C16059a(SingleSubscriber singleSubscriber) {
                this.f46537b = singleSubscriber;
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(R r) {
                this.f46537b.mo446d(r);
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                this.f46537b.onError(th);
            }
        }

        C16058b(Func1 func1) {
            this.f46535a = func1;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super R> singleSubscriber) {
            Single single = (Single) this.f46535a.call(ScalarSynchronousSingle.this.f46533b);
            if (single instanceof ScalarSynchronousSingle) {
                singleSubscriber.mo446d((T) ((ScalarSynchronousSingle) single).f46533b);
                return;
            }
            C16059a c16059a = new C16059a(singleSubscriber);
            singleSubscriber.m743b(c16059a);
            single.m1372i0(c16059a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* renamed from: rx.internal.util.l$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16060c<T> implements Single.InterfaceC15633t<T> {

        /* renamed from: a */
        private final EventLoopsScheduler f46539a;

        /* renamed from: b */
        private final T f46540b;

        C16060c(EventLoopsScheduler eventLoopsScheduler, T t) {
            this.f46539a = eventLoopsScheduler;
            this.f46540b = t;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.m743b(this.f46539a.m951F(new C16062e(singleSubscriber, this.f46540b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* renamed from: rx.internal.util.l$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16061d<T> implements Single.InterfaceC15633t<T> {

        /* renamed from: a */
        private final Scheduler f46541a;

        /* renamed from: b */
        private final T f46542b;

        C16061d(Scheduler scheduler, T t) {
            this.f46541a = scheduler;
            this.f46542b = t;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.AbstractC15607a mo450a = this.f46541a.mo450a();
            singleSubscriber.m743b(mo450a);
            mo450a.mo456d(new C16062e(singleSubscriber, this.f46542b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* renamed from: rx.internal.util.l$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16062e<T> implements Action0 {

        /* renamed from: a */
        private final SingleSubscriber<? super T> f46543a;

        /* renamed from: b */
        private final T f46544b;

        C16062e(SingleSubscriber<? super T> singleSubscriber, T t) {
            this.f46543a = singleSubscriber;
            this.f46544b = t;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                this.f46543a.mo446d((T) this.f46544b);
            } catch (Throwable th) {
                this.f46543a.onError(th);
            }
        }
    }

    protected ScalarSynchronousSingle(T t) {
        super(new C16057a(t));
        this.f46533b = t;
    }

    /* renamed from: O0 */
    public static <T> ScalarSynchronousSingle<T> m814O0(T t) {
        return new ScalarSynchronousSingle<>(t);
    }

    /* renamed from: P0 */
    public T m813P0() {
        return this.f46533b;
    }

    /* renamed from: Q0 */
    public <R> Single<R> m812Q0(Func1<? super T, ? extends Single<? extends R>> func1) {
        return Single.m1365m(new C16058b(func1));
    }

    /* renamed from: R0 */
    public Single<T> m811R0(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            return Single.m1365m(new C16060c((EventLoopsScheduler) scheduler, this.f46533b));
        }
        return Single.m1365m(new C16061d(scheduler, this.f46533b));
    }
}
