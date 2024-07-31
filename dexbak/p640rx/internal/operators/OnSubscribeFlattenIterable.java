package p640rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.Func1;
import p640rx.internal.operators.OnSubscribeFromIterable;
import p640rx.internal.util.ExceptionsUtils;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.ScalarSynchronousObservable;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.atomic.SpscLinkedArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.k0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeFlattenIterable<T, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<? extends T> f45422a;

    /* renamed from: b */
    final Func1<? super T, ? extends Iterable<? extends R>> f45423b;

    /* renamed from: c */
    final int f45424c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* renamed from: rx.internal.operators.k0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15771a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15772b f45425a;

        C15771a(C15772b c15772b) {
            this.f45425a = c15772b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45425a.m1189H(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* renamed from: rx.internal.operators.k0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15772b<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super R> f45427a;

        /* renamed from: b */
        final Func1<? super T, ? extends Iterable<? extends R>> f45428b;

        /* renamed from: c */
        final long f45429c;

        /* renamed from: d */
        final Queue<Object> f45430d;

        /* renamed from: h */
        volatile boolean f45434h;

        /* renamed from: i */
        long f45435i;

        /* renamed from: j */
        Iterator<? extends R> f45436j;

        /* renamed from: e */
        final AtomicReference<Throwable> f45431e = new AtomicReference<>();

        /* renamed from: g */
        final AtomicInteger f45433g = new AtomicInteger();

        /* renamed from: f */
        final AtomicLong f45432f = new AtomicLong();

        public C15772b(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.f45427a = subscriber;
            this.f45428b = func1;
            if (i == Integer.MAX_VALUE) {
                this.f45429c = Long.MAX_VALUE;
                this.f45430d = new SpscLinkedArrayQueue(RxRingBuffer.f46509d);
            } else {
                this.f45429c = i - (i >> 2);
                if (UnsafeAccess.m759f()) {
                    this.f45430d = new C16092z(i);
                } else {
                    this.f45430d = new SpscAtomicArrayQueue(i);
                }
            }
            request(i);
        }

        /* renamed from: F */
        boolean m1191F(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.f45436j = null;
                return true;
            } else if (z) {
                if (this.f45431e.get() == null) {
                    if (z2) {
                        subscriber.onCompleted();
                        return true;
                    }
                    return false;
                }
                Throwable terminate = ExceptionsUtils.terminate(this.f45431e);
                unsubscribe();
                queue.clear();
                this.f45436j = null;
                subscriber.onError(terminate);
                return true;
            } else {
                return false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0010 A[SYNTHETIC] */
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m1190G() {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OnSubscribeFlattenIterable.C15772b.m1190G():void");
        }

        /* renamed from: H */
        void m1189H(long j) {
            if (j > 0) {
                BackpressureUtils.m1335b(this.f45432f, j);
                m1190G();
            } else if (j >= 0) {
            } else {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45434h = true;
            m1190G();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.f45431e, th)) {
                this.f45434h = true;
                m1190G();
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (!this.f45430d.offer(NotificationLite.m1043j(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            m1190G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* renamed from: rx.internal.operators.k0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15773c<T, R> implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final T f45437a;

        /* renamed from: b */
        final Func1<? super T, ? extends Iterable<? extends R>> f45438b;

        public C15773c(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.f45437a = t;
            this.f45438b = func1;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator<? extends R> it = this.f45438b.call((T) this.f45437a).iterator();
                if (!it.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.C15798a(subscriber, it));
                }
            } catch (Throwable th) {
                C15575a.m1472g(th, subscriber, this.f45437a);
            }
        }
    }

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.f45422a = observable;
        this.f45423b = func1;
        this.f45424c = i;
    }

    /* renamed from: a */
    public static <T, R> Observable<R> m1192a(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.m1830H6(new C15773c(((ScalarSynchronousObservable) observable).m817x7(), func1));
        }
        return Observable.m1830H6(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        C15772b c15772b = new C15772b(subscriber, this.f45423b, this.f45424c);
        subscriber.add(c15772b);
        subscriber.setProducer(new C15771a(c15772b));
        this.f45422a.m1822I6(c15772b);
    }
}
