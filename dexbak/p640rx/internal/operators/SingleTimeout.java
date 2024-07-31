package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Scheduler;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.b5 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleTimeout<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f44979a;

    /* renamed from: b */
    final long f44980b;

    /* renamed from: c */
    final TimeUnit f44981c;

    /* renamed from: d */
    final Scheduler f44982d;

    /* renamed from: e */
    final Single.InterfaceC15633t<? extends T> f44983e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleTimeout.java */
    /* renamed from: rx.internal.operators.b5$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15667a<T> extends SingleSubscriber<T> implements Action0 {

        /* renamed from: b */
        final SingleSubscriber<? super T> f44984b;

        /* renamed from: c */
        final AtomicBoolean f44985c = new AtomicBoolean();

        /* renamed from: d */
        final Single.InterfaceC15633t<? extends T> f44986d;

        /* compiled from: SingleTimeout.java */
        /* renamed from: rx.internal.operators.b5$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C15668a<T> extends SingleSubscriber<T> {

            /* renamed from: b */
            final SingleSubscriber<? super T> f44987b;

            C15668a(SingleSubscriber<? super T> singleSubscriber) {
                this.f44987b = singleSubscriber;
            }

            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(T t) {
                this.f44987b.mo446d(t);
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                this.f44987b.onError(th);
            }
        }

        C15667a(SingleSubscriber<? super T> singleSubscriber, Single.InterfaceC15633t<? extends T> interfaceC15633t) {
            this.f44984b = singleSubscriber;
            this.f44986d = interfaceC15633t;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f44985c.compareAndSet(false, true)) {
                try {
                    Single.InterfaceC15633t<? extends T> interfaceC15633t = this.f44986d;
                    if (interfaceC15633t == null) {
                        this.f44984b.onError(new TimeoutException());
                    } else {
                        C15668a c15668a = new C15668a(this.f44984b);
                        this.f44984b.m743b(c15668a);
                        interfaceC15633t.call(c15668a);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            if (this.f44985c.compareAndSet(false, true)) {
                try {
                    this.f44984b.mo446d(t);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.f44985c.compareAndSet(false, true)) {
                try {
                    this.f44984b.onError(th);
                    return;
                } finally {
                    unsubscribe();
                }
            }
            RxJavaHooks.m576I(th);
        }
    }

    public SingleTimeout(Single.InterfaceC15633t<T> interfaceC15633t, long j, TimeUnit timeUnit, Scheduler scheduler, Single.InterfaceC15633t<? extends T> interfaceC15633t2) {
        this.f44979a = interfaceC15633t;
        this.f44980b = j;
        this.f44981c = timeUnit;
        this.f44982d = scheduler;
        this.f44983e = interfaceC15633t2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15667a c15667a = new C15667a(singleSubscriber, this.f44983e);
        Scheduler.AbstractC15607a mo450a = this.f44982d.mo450a();
        c15667a.m743b(mo450a);
        singleSubscriber.m743b(c15667a);
        mo450a.mo460F(c15667a, this.f44980b, this.f44981c);
        this.f44979a.call(c15667a);
    }
}
