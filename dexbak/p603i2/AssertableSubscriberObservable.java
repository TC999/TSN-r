package p603i2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.observers.AssertableSubscriber;
import p640rx.observers.TestSubscriber;

/* renamed from: i2.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class AssertableSubscriberObservable<T> extends Subscriber<T> implements AssertableSubscriber<T> {

    /* renamed from: a */
    private final TestSubscriber<T> f40177a;

    public AssertableSubscriberObservable(TestSubscriber<T> testSubscriber) {
        this.f40177a = testSubscriber;
    }

    /* renamed from: F */
    public static <T> AssertableSubscriberObservable<T> m12694F(long j) {
        TestSubscriber testSubscriber = new TestSubscriber(j);
        AssertableSubscriberObservable<T> assertableSubscriberObservable = new AssertableSubscriberObservable<>(testSubscriber);
        assertableSubscriberObservable.add(testSubscriber);
        return assertableSubscriberObservable;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: A */
    public final AssertableSubscriber<T> mo673A(Class<? extends Throwable> cls, T... tArr) {
        this.f40177a.m609S(tArr);
        this.f40177a.m621G(cls);
        this.f40177a.m615M();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: B */
    public final int mo672B() {
        return this.f40177a.m623B();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: C */
    public final AssertableSubscriber<T> mo671C(Action0 action0) {
        action0.call();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: D */
    public AssertableSubscriber<T> mo670D(long j) {
        this.f40177a.m595f0(j);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: E */
    public final AssertableSubscriber<T> mo669E(Class<? extends Throwable> cls, String str, T... tArr) {
        this.f40177a.m609S(tArr);
        this.f40177a.m621G(cls);
        this.f40177a.m615M();
        String message = this.f40177a.m594k().get(0).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: c */
    public AssertableSubscriber<T> mo668c() {
        this.f40177a.m606V();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: e */
    public Thread mo667e() {
        return this.f40177a.m597e();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: f */
    public final AssertableSubscriber<T> mo666f(T t, T... tArr) {
        this.f40177a.m608T(t, tArr);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: g */
    public AssertableSubscriber<T> mo665g(Class<? extends Throwable> cls) {
        this.f40177a.m621G(cls);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: h */
    public final AssertableSubscriber<T> mo664h(T... tArr) {
        this.f40177a.m609S(tArr);
        this.f40177a.m618J();
        this.f40177a.m622F();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: i */
    public AssertableSubscriber<T> mo663i() {
        this.f40177a.m613O();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: j */
    public AssertableSubscriber<T> mo662j() {
        this.f40177a.m618J();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: k */
    public List<Throwable> mo661k() {
        return this.f40177a.m594k();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: l */
    public AssertableSubscriber<T> mo660l() {
        this.f40177a.m616L();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: m */
    public final int mo659m() {
        return this.f40177a.m593m();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: n */
    public AssertableSubscriber<T> mo658n() {
        this.f40177a.m622F();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: o */
    public AssertableSubscriber<T> mo657o(long j, TimeUnit timeUnit) {
        this.f40177a.m604X(j, timeUnit);
        return this;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f40177a.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f40177a.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f40177a.onNext(t);
    }

    @Override // p640rx.Subscriber
    public void onStart() {
        this.f40177a.onStart();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: p */
    public final AssertableSubscriber<T> mo656p(int i, long j, TimeUnit timeUnit) {
        if (this.f40177a.m603Y(i, j, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i + ", Actual: " + this.f40177a.m593m());
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: q */
    public AssertableSubscriber<T> mo655q() {
        this.f40177a.m615M();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: r */
    public AssertableSubscriber<T> mo654r(List<T> list) {
        this.f40177a.m614N(list);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: s */
    public AssertableSubscriber<T> mo653s() {
        this.f40177a.m617K();
        return this;
    }

    @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
    public void setProducer(Producer producer) {
        this.f40177a.setProducer(producer);
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: t */
    public AssertableSubscriber<T> mo652t(Throwable th) {
        this.f40177a.m620H(th);
        return this;
    }

    public String toString() {
        return this.f40177a.toString();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: u */
    public AssertableSubscriber<T> mo651u(T t) {
        this.f40177a.m611Q(t);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: v */
    public List<T> mo650v() {
        return this.f40177a.m592v();
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: w */
    public AssertableSubscriber<T> mo649w(int i) {
        this.f40177a.m610R(i);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: x */
    public AssertableSubscriber<T> mo648x() {
        this.f40177a.m612P();
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: y */
    public AssertableSubscriber<T> mo647y(long j, TimeUnit timeUnit) {
        this.f40177a.m605W(j, timeUnit);
        return this;
    }

    @Override // p640rx.observers.AssertableSubscriber
    /* renamed from: z */
    public AssertableSubscriber<T> mo646z(T... tArr) {
        this.f40177a.m609S(tArr);
        return this;
    }
}
