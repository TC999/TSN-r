package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.k3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeLastTimed<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f45453a;

    /* renamed from: b */
    final Scheduler f45454b;

    /* renamed from: c */
    final int f45455c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeLastTimed.java */
    /* renamed from: rx.internal.operators.k3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15778a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15779b f45456a;

        C15778a(C15779b c15779b) {
            this.f45456a = c15779b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45456a.m1182G(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeLastTimed.java */
    /* renamed from: rx.internal.operators.k3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15779b<T> extends Subscriber<T> implements Func1<Object, T> {

        /* renamed from: a */
        final Subscriber<? super T> f45458a;

        /* renamed from: b */
        final long f45459b;

        /* renamed from: c */
        final Scheduler f45460c;

        /* renamed from: d */
        final int f45461d;

        /* renamed from: e */
        final AtomicLong f45462e = new AtomicLong();

        /* renamed from: f */
        final ArrayDeque<Object> f45463f = new ArrayDeque<>();

        /* renamed from: g */
        final ArrayDeque<Long> f45464g = new ArrayDeque<>();

        public C15779b(Subscriber<? super T> subscriber, int i, long j, Scheduler scheduler) {
            this.f45458a = subscriber;
            this.f45461d = i;
            this.f45459b = j;
            this.f45460c = scheduler;
        }

        /* renamed from: F */
        protected void m1183F(long j) {
            long j2 = j - this.f45459b;
            while (true) {
                Long peek = this.f45464g.peek();
                if (peek == null || peek.longValue() >= j2) {
                    return;
                }
                this.f45463f.poll();
                this.f45464g.poll();
            }
        }

        /* renamed from: G */
        void m1182G(long j) {
            BackpressureUtils.m1329h(this.f45462e, j, this.f45463f, this.f45458a, this);
        }

        @Override // p640rx.functions.Func1
        public T call(Object obj) {
            return (T) NotificationLite.m1048e(obj);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            m1183F(this.f45460c.mo462b());
            this.f45464g.clear();
            BackpressureUtils.m1332e(this.f45462e, this.f45463f, this.f45458a, this);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45463f.clear();
            this.f45464g.clear();
            this.f45458a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45461d != 0) {
                long mo462b = this.f45460c.mo462b();
                if (this.f45463f.size() == this.f45461d) {
                    this.f45463f.poll();
                    this.f45464g.poll();
                }
                m1183F(mo462b);
                this.f45463f.offer(NotificationLite.m1043j(t));
                this.f45464g.offer(Long.valueOf(mo462b));
            }
        }
    }

    public OperatorTakeLastTimed(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45453a = timeUnit.toMillis(j);
        this.f45454b = scheduler;
        this.f45455c = -1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15779b c15779b = new C15779b(subscriber, this.f45455c, this.f45453a, this.f45454b);
        subscriber.add(c15779b);
        subscriber.setProducer(new C15778a(c15779b));
        return c15779b;
    }

    public OperatorTakeLastTimed(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            this.f45453a = timeUnit.toMillis(j);
            this.f45454b = scheduler;
            this.f45455c = i;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
