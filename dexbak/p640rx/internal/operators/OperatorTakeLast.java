package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.j3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTakeLast<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final int f45399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeLast.java */
    /* renamed from: rx.internal.operators.j3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15766a implements Producer {

        /* renamed from: a */
        final /* synthetic */ C15767b f45400a;

        C15766a(C15767b c15767b) {
            this.f45400a = c15767b;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45400a.m1197F(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeLast.java */
    /* renamed from: rx.internal.operators.j3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15767b<T> extends Subscriber<T> implements Func1<Object, T> {

        /* renamed from: a */
        final Subscriber<? super T> f45402a;

        /* renamed from: b */
        final AtomicLong f45403b = new AtomicLong();

        /* renamed from: c */
        final ArrayDeque<Object> f45404c = new ArrayDeque<>();

        /* renamed from: d */
        final int f45405d;

        public C15767b(Subscriber<? super T> subscriber, int i) {
            this.f45402a = subscriber;
            this.f45405d = i;
        }

        /* renamed from: F */
        void m1197F(long j) {
            if (j > 0) {
                BackpressureUtils.m1329h(this.f45403b, j, this.f45404c, this.f45402a, this);
            }
        }

        @Override // p640rx.functions.Func1
        public T call(Object obj) {
            return (T) NotificationLite.m1048e(obj);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            BackpressureUtils.m1332e(this.f45403b, this.f45404c, this.f45402a, this);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45404c.clear();
            this.f45402a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45404c.size() == this.f45405d) {
                this.f45404c.poll();
            }
            this.f45404c.offer(NotificationLite.m1043j(t));
        }
    }

    public OperatorTakeLast(int i) {
        if (i >= 0) {
            this.f45399a = i;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15767b c15767b = new C15767b(subscriber, this.f45399a);
        subscriber.add(c15767b);
        subscriber.setProducer(new C15766a(c15767b));
        return c15767b;
    }
}
