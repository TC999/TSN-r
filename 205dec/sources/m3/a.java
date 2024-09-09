package m3;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.g;
import rx.l;
import rx.observers.j;

/* compiled from: AssertableSubscriberObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a<T> extends l<T> implements rx.observers.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final j<T> f60831a;

    public a(j<T> jVar) {
        this.f60831a = jVar;
    }

    public static <T> a<T> g(long j4) {
        j jVar = new j(j4);
        a<T> aVar = new a<>(jVar);
        aVar.add(jVar);
        return aVar;
    }

    public rx.observers.a<T> A(int i4) {
        this.f60831a.S(i4);
        return this;
    }

    public rx.observers.a<T> B() {
        this.f60831a.Q();
        return this;
    }

    public rx.observers.a<T> C(long j4, TimeUnit timeUnit) {
        this.f60831a.X(j4, timeUnit);
        return this;
    }

    public rx.observers.a<T> D(T... tArr) {
        this.f60831a.T(tArr);
        return this;
    }

    public final rx.observers.a<T> E(Class<? extends Throwable> cls, T... tArr) {
        this.f60831a.T(tArr);
        this.f60831a.v(cls);
        this.f60831a.N();
        return this;
    }

    public final int F() {
        return this.f60831a.F();
    }

    public final rx.observers.a<T> G(rx.functions.a aVar) {
        aVar.call();
        return this;
    }

    public rx.observers.a<T> H(long j4) {
        this.f60831a.g0(j4);
        return this;
    }

    public final rx.observers.a<T> K(Class<? extends Throwable> cls, String str, T... tArr) {
        this.f60831a.T(tArr);
        this.f60831a.v(cls);
        this.f60831a.N();
        String message = ((Throwable) this.f60831a.m().get(0)).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }

    public rx.observers.a<T> d() {
        this.f60831a.W();
        return this;
    }

    public Thread f() {
        return this.f60831a.f();
    }

    public final rx.observers.a<T> h(T t3, T... tArr) {
        this.f60831a.U(t3, tArr);
        return this;
    }

    public rx.observers.a<T> i(Class<? extends Throwable> cls) {
        this.f60831a.v(cls);
        return this;
    }

    public final rx.observers.a<T> j(T... tArr) {
        this.f60831a.T(tArr);
        this.f60831a.J();
        this.f60831a.g();
        return this;
    }

    public rx.observers.a<T> k() {
        this.f60831a.P();
        return this;
    }

    @Override // rx.observers.a
    public rx.observers.a<T> l() {
        this.f60831a.J();
        return this;
    }

    public List<Throwable> m() {
        return this.f60831a.m();
    }

    @Override // rx.observers.a
    public rx.observers.a<T> n() {
        this.f60831a.M();
        return this;
    }

    public final int o() {
        return this.f60831a.o();
    }

    @Override // rx.f
    public void onCompleted() {
        this.f60831a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f60831a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f60831a.onNext(t3);
    }

    @Override // rx.l
    public void onStart() {
        this.f60831a.onStart();
    }

    public rx.observers.a<T> p() {
        this.f60831a.g();
        return this;
    }

    public rx.observers.a<T> q(long j4, TimeUnit timeUnit) {
        this.f60831a.Y(j4, timeUnit);
        return this;
    }

    public final rx.observers.a<T> r(int i4, long j4, TimeUnit timeUnit) {
        if (this.f60831a.Z(i4, j4, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i4 + ", Actual: " + this.f60831a.o());
    }

    @Override // rx.observers.a
    public rx.observers.a<T> s() {
        this.f60831a.N();
        return this;
    }

    @Override // rx.l, rx.observers.a
    public void setProducer(g gVar) {
        this.f60831a.setProducer(gVar);
    }

    public rx.observers.a<T> t(List<T> list) {
        this.f60831a.O(list);
        return this;
    }

    public String toString() {
        return this.f60831a.toString();
    }

    public rx.observers.a<T> u() {
        this.f60831a.L();
        return this;
    }

    public rx.observers.a<T> w(Throwable th) {
        this.f60831a.x(th);
        return this;
    }

    public rx.observers.a<T> y(T t3) {
        this.f60831a.R(t3);
        return this;
    }

    public List<T> z() {
        return this.f60831a.z();
    }
}
