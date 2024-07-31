package p640rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.h1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeToMap<T, K, V> implements Observable.InterfaceC15567a<Map<K, V>>, Func0<Map<K, V>> {

    /* renamed from: a */
    final Observable<T> f45273a;

    /* renamed from: b */
    final Func1<? super T, ? extends K> f45274b;

    /* renamed from: c */
    final Func1<? super T, ? extends V> f45275c;

    /* renamed from: d */
    final Func0<? extends Map<K, V>> f45276d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeToMap.java */
    /* renamed from: rx.internal.operators.h1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15737a<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, V>> {

        /* renamed from: j */
        final Func1<? super T, ? extends K> f45277j;

        /* renamed from: k */
        final Func1<? super T, ? extends V> f45278k;

        /* JADX WARN: Multi-variable type inference failed */
        C15737a(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
            super(subscriber);
            this.f45882c = map;
            this.f45881b = true;
            this.f45277j = func1;
            this.f45278k = func12;
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45967i) {
                return;
            }
            try {
                ((Map) this.f45882c).put(this.f45277j.call(t), this.f45278k.call(t));
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(observable, func1, func12, null);
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        this.f45273a = observable;
        this.f45274b = func1;
        this.f45275c = func12;
        if (func0 == null) {
            this.f45276d = this;
        } else {
            this.f45276d = func0;
        }
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    @Override // p640rx.functions.Func0, java.util.concurrent.Callable
    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, V>> subscriber) {
        try {
            new C15737a(subscriber, this.f45276d.call(), this.f45274b, this.f45275c).m1088J(this.f45273a);
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
        }
    }
}
