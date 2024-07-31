package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.f2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorElementAt<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final int f45147a;

    /* renamed from: b */
    final boolean f45148b;

    /* renamed from: c */
    final T f45149c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorElementAt.java */
    /* renamed from: rx.internal.operators.f2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15708a extends Subscriber<T> {

        /* renamed from: a */
        private int f45150a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45151b;

        C15708a(Subscriber subscriber) {
            this.f45151b = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            int i = this.f45150a;
            OperatorElementAt operatorElementAt = OperatorElementAt.this;
            if (i <= operatorElementAt.f45147a) {
                if (operatorElementAt.f45148b) {
                    this.f45151b.onNext(operatorElementAt.f45149c);
                    this.f45151b.onCompleted();
                    return;
                }
                Subscriber subscriber = this.f45151b;
                subscriber.onError(new IndexOutOfBoundsException(OperatorElementAt.this.f45147a + " is out of bounds"));
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45151b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f45150a;
            this.f45150a = i + 1;
            if (i == OperatorElementAt.this.f45147a) {
                this.f45151b.onNext(t);
                this.f45151b.onCompleted();
                unsubscribe();
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45151b.setProducer(new C15709b(producer));
        }
    }

    /* compiled from: OperatorElementAt.java */
    /* renamed from: rx.internal.operators.f2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15709b extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;

        /* renamed from: a */
        final Producer f45153a;

        public C15709b(Producer producer) {
            this.f45153a = producer;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j >= 0) {
                if (j <= 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.f45153a.request(Long.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }

    public OperatorElementAt(int i) {
        this(i, null, false);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorElementAt(int i, T t) {
        this(i, t, true);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15708a c15708a = new C15708a(subscriber);
        subscriber.add(c15708a);
        return c15708a;
    }

    private OperatorElementAt(int i, T t, boolean z) {
        if (i >= 0) {
            this.f45147a = i;
            this.f45149c = t;
            this.f45148b = z;
            return;
        }
        throw new IndexOutOfBoundsException(i + " is out of bounds");
    }
}
