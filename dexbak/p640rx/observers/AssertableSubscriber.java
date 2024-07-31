package p640rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscription;
import p640rx.functions.Action0;

/* renamed from: rx.observers.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface AssertableSubscriber<T> extends Observer<T>, Subscription {
    /* renamed from: A */
    AssertableSubscriber<T> mo673A(Class<? extends Throwable> cls, T... tArr);

    /* renamed from: B */
    int mo672B();

    /* renamed from: C */
    AssertableSubscriber<T> mo671C(Action0 action0);

    /* renamed from: D */
    AssertableSubscriber<T> mo670D(long j);

    /* renamed from: E */
    AssertableSubscriber<T> mo669E(Class<? extends Throwable> cls, String str, T... tArr);

    /* renamed from: c */
    AssertableSubscriber<T> mo668c();

    /* renamed from: e */
    Thread mo667e();

    /* renamed from: f */
    AssertableSubscriber<T> mo666f(T t, T... tArr);

    /* renamed from: g */
    AssertableSubscriber<T> mo665g(Class<? extends Throwable> cls);

    /* renamed from: h */
    AssertableSubscriber<T> mo664h(T... tArr);

    /* renamed from: i */
    AssertableSubscriber<T> mo663i();

    @Override // p640rx.Subscription
    boolean isUnsubscribed();

    /* renamed from: j */
    AssertableSubscriber<T> mo662j();

    /* renamed from: k */
    List<Throwable> mo661k();

    /* renamed from: l */
    AssertableSubscriber<T> mo660l();

    /* renamed from: m */
    int mo659m();

    /* renamed from: n */
    AssertableSubscriber<T> mo658n();

    /* renamed from: o */
    AssertableSubscriber<T> mo657o(long j, TimeUnit timeUnit);

    void onStart();

    /* renamed from: p */
    AssertableSubscriber<T> mo656p(int i, long j, TimeUnit timeUnit);

    /* renamed from: q */
    AssertableSubscriber<T> mo655q();

    /* renamed from: r */
    AssertableSubscriber<T> mo654r(List<T> list);

    /* renamed from: s */
    AssertableSubscriber<T> mo653s();

    void setProducer(Producer producer);

    /* renamed from: t */
    AssertableSubscriber<T> mo652t(Throwable th);

    /* renamed from: u */
    AssertableSubscriber<T> mo651u(T t);

    @Override // p640rx.Subscription
    void unsubscribe();

    /* renamed from: v */
    List<T> mo650v();

    /* renamed from: w */
    AssertableSubscriber<T> mo649w(int i);

    /* renamed from: x */
    AssertableSubscriber<T> mo648x();

    /* renamed from: y */
    AssertableSubscriber<T> mo647y(long j, TimeUnit timeUnit);

    /* renamed from: z */
    AssertableSubscriber<T> mo646z(T... tArr);
}
