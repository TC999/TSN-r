package rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: AssertableSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public interface a<T> extends rx.f<T>, m {
    a<T> A(Class<? extends Throwable> cls, T... tArr);

    int B();

    a<T> C(rx.functions.a aVar);

    a<T> D(long j4);

    a<T> E(Class<? extends Throwable> cls, String str, T... tArr);

    a<T> c();

    Thread e();

    a<T> f(T t3, T... tArr);

    a<T> g(Class<? extends Throwable> cls);

    a<T> h(T... tArr);

    a<T> i();

    @Override // rx.m
    boolean isUnsubscribed();

    a<T> j();

    List<Throwable> k();

    a<T> l();

    int m();

    a<T> n();

    a<T> o(long j4, TimeUnit timeUnit);

    void onStart();

    a<T> p(int i4, long j4, TimeUnit timeUnit);

    a<T> q();

    a<T> r(List<T> list);

    a<T> s();

    void setProducer(rx.g gVar);

    a<T> t(Throwable th);

    a<T> u(T t3);

    @Override // rx.m
    void unsubscribe();

    List<T> v();

    a<T> w(int i4);

    a<T> x();

    a<T> y(long j4, TimeUnit timeUnit);

    a<T> z(T... tArr);
}
