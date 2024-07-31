package p640rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.FuncN;
import p640rx.observers.SerializedSubscriber;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.e4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWithLatestFromMany<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T> f45119a;

    /* renamed from: b */
    final Observable<?>[] f45120b;

    /* renamed from: c */
    final Iterable<Observable<?>> f45121c;

    /* renamed from: d */
    final FuncN<R> f45122d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWithLatestFromMany.java */
    /* renamed from: rx.internal.operators.e4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15701a<T, R> extends Subscriber<T> {

        /* renamed from: f */
        static final Object f45123f = new Object();

        /* renamed from: a */
        final Subscriber<? super R> f45124a;

        /* renamed from: b */
        final FuncN<R> f45125b;

        /* renamed from: c */
        final AtomicReferenceArray<Object> f45126c;

        /* renamed from: d */
        final AtomicInteger f45127d;

        /* renamed from: e */
        boolean f45128e;

        public C15701a(Subscriber<? super R> subscriber, FuncN<R> funcN, int i) {
            this.f45124a = subscriber;
            this.f45125b = funcN;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i + 1);
            for (int i2 = 0; i2 <= i; i2++) {
                atomicReferenceArray.lazySet(i2, f45123f);
            }
            this.f45126c = atomicReferenceArray;
            this.f45127d = new AtomicInteger(i);
            request(0L);
        }

        /* renamed from: F */
        void m1269F(int i) {
            if (this.f45126c.get(i) == f45123f) {
                onCompleted();
            }
        }

        /* renamed from: G */
        void m1268G(int i, Throwable th) {
            onError(th);
        }

        /* renamed from: H */
        void m1267H(int i, Object obj) {
            if (this.f45126c.getAndSet(i, obj) == f45123f) {
                this.f45127d.decrementAndGet();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45128e) {
                return;
            }
            this.f45128e = true;
            unsubscribe();
            this.f45124a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45128e) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45128e = true;
            unsubscribe();
            this.f45124a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45128e) {
                return;
            }
            if (this.f45127d.get() == 0) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f45126c;
                int length = atomicReferenceArray.length();
                atomicReferenceArray.lazySet(0, t);
                Object[] objArr = new Object[atomicReferenceArray.length()];
                for (int i = 0; i < length; i++) {
                    objArr[i] = atomicReferenceArray.get(i);
                }
                try {
                    this.f45124a.onNext(this.f45125b.call(objArr));
                    return;
                } catch (Throwable th) {
                    C15575a.m1474e(th);
                    onError(th);
                    return;
                }
            }
            request(1L);
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.f45124a.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWithLatestFromMany.java */
    /* renamed from: rx.internal.operators.e4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15702b extends Subscriber<Object> {

        /* renamed from: a */
        final C15701a<?, ?> f45129a;

        /* renamed from: b */
        final int f45130b;

        public C15702b(C15701a<?, ?> c15701a, int i) {
            this.f45129a = c15701a;
            this.f45130b = i;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45129a.m1269F(this.f45130b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45129a.m1268G(this.f45130b, th);
        }

        @Override // p640rx.Observer
        public void onNext(Object obj) {
            this.f45129a.m1267H(this.f45130b, obj);
        }
    }

    public OperatorWithLatestFromMany(Observable<T> observable, Observable<?>[] observableArr, Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        this.f45119a = observable;
        this.f45120b = observableArr;
        this.f45121c = iterable;
        this.f45122d = funcN;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        int i;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Observable<?>[] observableArr = this.f45120b;
        int i2 = 0;
        if (observableArr != null) {
            i = observableArr.length;
        } else {
            observableArr = new Observable[8];
            int i3 = 0;
            for (Observable<?> observable : this.f45121c) {
                if (i3 == observableArr.length) {
                    observableArr = (Observable[]) Arrays.copyOf(observableArr, (i3 >> 2) + i3);
                }
                observableArr[i3] = observable;
                i3++;
            }
            i = i3;
        }
        C15701a c15701a = new C15701a(subscriber, this.f45122d, i);
        serializedSubscriber.add(c15701a);
        while (i2 < i) {
            if (serializedSubscriber.isUnsubscribed()) {
                return;
            }
            int i4 = i2 + 1;
            C15702b c15702b = new C15702b(c15701a, i4);
            c15701a.add(c15702b);
            observableArr[i2].m1822I6(c15702b);
            i2 = i4;
        }
        this.f45119a.m1822I6(c15701a);
    }
}
