package p640rx.internal.operators;

import java.util.NoSuchElementException;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.internal.producers.SingleProducer;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.a3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorSingle<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    private final boolean f44899a;

    /* renamed from: b */
    private final T f44900b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSingle.java */
    /* renamed from: rx.internal.operators.a3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15647a {

        /* renamed from: a */
        static final OperatorSingle<?> f44901a = new OperatorSingle<>();

        C15647a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSingle.java */
    /* renamed from: rx.internal.operators.a3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15648b<T> extends Subscriber<T> {

        /* renamed from: a */
        private final Subscriber<? super T> f44902a;

        /* renamed from: b */
        private final boolean f44903b;

        /* renamed from: c */
        private final T f44904c;

        /* renamed from: d */
        private T f44905d;

        /* renamed from: e */
        private boolean f44906e;

        /* renamed from: f */
        private boolean f44907f;

        C15648b(Subscriber<? super T> subscriber, boolean z, T t) {
            this.f44902a = subscriber;
            this.f44903b = z;
            this.f44904c = t;
            request(2L);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f44907f) {
                return;
            }
            if (this.f44906e) {
                this.f44902a.setProducer(new SingleProducer(this.f44902a, this.f44905d));
            } else if (this.f44903b) {
                this.f44902a.setProducer(new SingleProducer(this.f44902a, this.f44904c));
            } else {
                this.f44902a.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f44907f) {
                RxJavaHooks.m576I(th);
            } else {
                this.f44902a.onError(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f44907f) {
                return;
            }
            if (this.f44906e) {
                this.f44907f = true;
                this.f44902a.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
                return;
            }
            this.f44905d = t;
            this.f44906e = true;
        }
    }

    OperatorSingle() {
        this(false, null);
    }

    /* renamed from: a */
    public static <T> OperatorSingle<T> m1317a() {
        return (OperatorSingle<T>) C15647a.f44901a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorSingle(T t) {
        this(true, t);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15648b c15648b = new C15648b(subscriber, this.f44899a, this.f44900b);
        subscriber.add(c15648b);
        return c15648b;
    }

    private OperatorSingle(boolean z, T t) {
        this.f44899a = z;
        this.f44900b = t;
    }
}
