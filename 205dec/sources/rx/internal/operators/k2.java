package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorMaterialize.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k2<T> implements e.b<Notification<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMaterialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62876a;

        a(c cVar) {
            this.f62876a = cVar;
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 > 0) {
                this.f62876a.x(j4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMaterialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final k2<Object> f62878a = new k2<>();

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMaterialize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super Notification<T>> f62879a;

        /* renamed from: b  reason: collision with root package name */
        private volatile Notification<T> f62880b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62881c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f62882d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicLong f62883e = new AtomicLong();

        c(rx.l<? super Notification<T>> lVar) {
            this.f62879a = lVar;
        }

        private void g() {
            long j4;
            AtomicLong atomicLong = this.f62883e;
            do {
                j4 = atomicLong.get();
                if (j4 == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j4, j4 - 1));
        }

        private void v() {
            synchronized (this) {
                if (this.f62881c) {
                    this.f62882d = true;
                    return;
                }
                AtomicLong atomicLong = this.f62883e;
                while (!this.f62879a.isUnsubscribed()) {
                    Notification<T> notification = this.f62880b;
                    if (notification != null && atomicLong.get() > 0) {
                        this.f62880b = null;
                        this.f62879a.onNext(notification);
                        if (this.f62879a.isUnsubscribed()) {
                            return;
                        }
                        this.f62879a.onCompleted();
                        return;
                    }
                    synchronized (this) {
                        if (!this.f62882d) {
                            this.f62881c = false;
                            return;
                        }
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62880b = Notification.b();
            v();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62880b = Notification.d(th);
            rx.plugins.c.I(th);
            v();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62879a.onNext(Notification.e(t3));
            g();
        }

        @Override // rx.l
        public void onStart() {
            request(0L);
        }

        void x(long j4) {
            rx.internal.operators.a.b(this.f62883e, j4);
            request(j4);
            v();
        }
    }

    k2() {
    }

    public static <T> k2<T> a() {
        return (k2<T>) b.f62878a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super Notification<T>> lVar) {
        c cVar = new c(lVar);
        lVar.add(cVar);
        lVar.setProducer(new a(cVar));
        return cVar;
    }
}
