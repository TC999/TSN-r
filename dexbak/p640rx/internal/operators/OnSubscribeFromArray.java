package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFromArray<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final T[] f45472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFromArray.java */
    /* renamed from: rx.internal.operators.l0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15781a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;

        /* renamed from: a */
        final Subscriber<? super T> f45473a;

        /* renamed from: b */
        final T[] f45474b;

        /* renamed from: c */
        int f45475c;

        public C15781a(Subscriber<? super T> subscriber, T[] tArr) {
            this.f45473a = subscriber;
            this.f45474b = tArr;
        }

        /* renamed from: a */
        void m1180a() {
            Subscriber<? super T> subscriber = this.f45473a;
            for (T t : this.f45474b) {
                Object obj = (Object) t;
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(obj);
            }
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        }

        /* renamed from: b */
        void m1179b(long j) {
            Subscriber<? super T> subscriber = this.f45473a;
            T[] tArr = this.f45474b;
            int length = tArr.length;
            int i = this.f45475c;
            do {
                long j2 = 0;
                while (true) {
                    if (j != 0 && i != length) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext((Object) tArr[i]);
                        i++;
                        if (i == length) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                        j--;
                        j2--;
                    } else {
                        j = get() + j2;
                        if (j == 0) {
                            this.f45475c = i;
                            j = addAndGet(j2);
                        }
                    }
                }
            } while (j != 0);
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (j == Long.MAX_VALUE) {
                if (BackpressureUtils.m1335b(this, j) == 0) {
                    m1180a();
                }
            } else if (j == 0 || BackpressureUtils.m1335b(this, j) != 0) {
            } else {
                m1179b(j);
            }
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.f45472a = tArr;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.setProducer(new C15781a(subscriber, this.f45472a));
    }
}
