package p640rx.internal.operators;

import java.util.NoSuchElementException;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func2;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.x0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeReduce<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Observable<T> f46130a;

    /* renamed from: b */
    final Func2<T, T, T> f46131b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeReduce.java */
    /* renamed from: rx.internal.operators.x0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15956a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15957b f46132a;

        C15956a(C15957b c15957b) {
            this.f46132a = c15957b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f46132a.m1007F(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeReduce.java */
    /* renamed from: rx.internal.operators.x0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15957b<T> extends Subscriber<T> {

        /* renamed from: e */
        static final Object f46134e = new Object();

        /* renamed from: a */
        final Subscriber<? super T> f46135a;

        /* renamed from: b */
        final Func2<T, T, T> f46136b;

        /* renamed from: c */
        T f46137c = (T) f46134e;

        /* renamed from: d */
        boolean f46138d;

        public C15957b(Subscriber<? super T> subscriber, Func2<T, T, T> func2) {
            this.f46135a = subscriber;
            this.f46136b = func2;
            request(0L);
        }

        /* renamed from: F */
        void m1007F(long j) {
            if (j >= 0) {
                if (j != 0) {
                    request(Long.MAX_VALUE);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46138d) {
                return;
            }
            this.f46138d = true;
            T t = this.f46137c;
            if (t != f46134e) {
                this.f46135a.onNext(t);
                this.f46135a.onCompleted();
                return;
            }
            this.f46135a.onError(new NoSuchElementException());
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f46138d) {
                this.f46138d = true;
                this.f46135a.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f46138d) {
                return;
            }
            T t2 = this.f46137c;
            if (t2 == f46134e) {
                this.f46137c = t;
                return;
            }
            try {
                this.f46137c = this.f46136b.call(t2, t);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeReduce(Observable<T> observable, Func2<T, T, T> func2) {
        this.f46130a = observable;
        this.f46131b = func2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        C15957b c15957b = new C15957b(subscriber, this.f46131b);
        subscriber.add(c15957b);
        subscriber.setProducer(new C15956a(c15957b));
        this.f46130a.m1822I6(c15957b);
    }
}
