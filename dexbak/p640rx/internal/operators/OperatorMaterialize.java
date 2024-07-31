package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.k2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorMaterialize<T> implements Observable.InterfaceC15568b<Notification<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMaterialize.java */
    /* renamed from: rx.internal.operators.k2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15775a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15777c f45445a;

        C15775a(C15777c c15777c) {
            this.f45445a = c15777c;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j > 0) {
                this.f45445a.m1184H(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMaterialize.java */
    /* renamed from: rx.internal.operators.k2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15776b {

        /* renamed from: a */
        static final OperatorMaterialize<Object> f45447a = new OperatorMaterialize<>();

        C15776b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMaterialize.java */
    /* renamed from: rx.internal.operators.k2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15777c<T> extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super Notification<T>> f45448a;

        /* renamed from: b */
        private volatile Notification<T> f45449b;

        /* renamed from: c */
        private boolean f45450c;

        /* renamed from: d */
        private boolean f45451d;

        /* renamed from: e */
        private final AtomicLong f45452e = new AtomicLong();

        C15777c(Subscriber<? super Notification<T>> subscriber) {
            this.f45448a = subscriber;
        }

        /* renamed from: F */
        private void m1186F() {
            long j;
            AtomicLong atomicLong = this.f45452e;
            do {
                j = atomicLong.get();
                if (j == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        /* renamed from: G */
        private void m1185G() {
            synchronized (this) {
                if (this.f45450c) {
                    this.f45451d = true;
                    return;
                }
                AtomicLong atomicLong = this.f45452e;
                while (!this.f45448a.isUnsubscribed()) {
                    Notification<T> notification = this.f45449b;
                    if (notification != null && atomicLong.get() > 0) {
                        this.f45449b = null;
                        this.f45448a.onNext(notification);
                        if (this.f45448a.isUnsubscribed()) {
                            return;
                        }
                        this.f45448a.onCompleted();
                        return;
                    }
                    synchronized (this) {
                        if (!this.f45451d) {
                            this.f45450c = false;
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: H */
        void m1184H(long j) {
            BackpressureUtils.m1335b(this.f45452e, j);
            request(j);
            m1185G();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45449b = Notification.m2005b();
            m1185G();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45449b = Notification.m2003d(th);
            RxJavaHooks.m576I(th);
            m1185G();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45448a.onNext(Notification.m2002e(t));
            m1186F();
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(0L);
        }
    }

    OperatorMaterialize() {
    }

    /* renamed from: a */
    public static <T> OperatorMaterialize<T> m1187a() {
        return (OperatorMaterialize<T>) C15776b.f45447a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        C15777c c15777c = new C15777c(subscriber);
        subscriber.add(c15777c);
        subscriber.setProducer(new C15775a(c15777c));
        return c15777c;
    }
}
