package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action1;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.p2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorOnBackpressureDrop<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final Action1<? super T> f45699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* renamed from: rx.internal.operators.p2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15833a implements Producer {

        /* renamed from: a */
        final /* synthetic */ AtomicLong f45700a;

        C15833a(AtomicLong atomicLong) {
            this.f45700a = atomicLong;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            BackpressureUtils.m1335b(this.f45700a, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* renamed from: rx.internal.operators.p2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15834b extends Subscriber<T> {

        /* renamed from: a */
        boolean f45702a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45703b;

        /* renamed from: c */
        final /* synthetic */ AtomicLong f45704c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15834b(Subscriber subscriber, Subscriber subscriber2, AtomicLong atomicLong) {
            super(subscriber);
            this.f45703b = subscriber2;
            this.f45704c = atomicLong;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45702a) {
                return;
            }
            this.f45702a = true;
            this.f45703b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f45702a) {
                this.f45702a = true;
                this.f45703b.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45702a) {
                return;
            }
            if (this.f45704c.get() > 0) {
                this.f45703b.onNext(t);
                this.f45704c.decrementAndGet();
                return;
            }
            Action1<? super T> action1 = OperatorOnBackpressureDrop.this.f45699a;
            if (action1 != null) {
                try {
                    action1.call(t);
                } catch (Throwable th) {
                    C15575a.m1472g(th, this, t);
                }
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* renamed from: rx.internal.operators.p2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15835c {

        /* renamed from: a */
        static final OperatorOnBackpressureDrop<Object> f45706a = new OperatorOnBackpressureDrop<>();

        C15835c() {
        }
    }

    OperatorOnBackpressureDrop() {
        this(null);
    }

    /* renamed from: a */
    public static <T> OperatorOnBackpressureDrop<T> m1120a() {
        return (OperatorOnBackpressureDrop<T>) C15835c.f45706a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.f45699a = action1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new C15833a(atomicLong));
        return new C15834b(subscriber, subscriber, atomicLong);
    }
}
