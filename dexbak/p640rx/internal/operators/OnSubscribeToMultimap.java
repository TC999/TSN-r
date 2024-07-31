package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.i1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeToMultimap<T, K, V> implements Observable.InterfaceC15567a<Map<K, Collection<V>>>, Func0<Map<K, Collection<V>>> {

    /* renamed from: a */
    private final Func1<? super T, ? extends K> f45328a;

    /* renamed from: b */
    private final Func1<? super T, ? extends V> f45329b;

    /* renamed from: c */
    private final Func0<? extends Map<K, Collection<V>>> f45330c;

    /* renamed from: d */
    private final Func1<? super K, ? extends Collection<V>> f45331d;

    /* renamed from: e */
    private final Observable<T> f45332e;

    /* compiled from: OnSubscribeToMultimap.java */
    /* renamed from: rx.internal.operators.i1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C15750a<K, V> implements Func1<K, Collection<V>> {

        /* renamed from: a */
        private static final C15750a<Object, Object> f45333a = new C15750a<>();

        private C15750a() {
        }

        /* renamed from: a */
        static <K, V> C15750a<K, V> m1211a() {
            return (C15750a<K, V>) f45333a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((C15750a<K, V>) obj);
        }

        @Override // p640rx.functions.Func1
        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OnSubscribeToMultimap.java */
    /* renamed from: rx.internal.operators.i1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15751b<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, Collection<V>>> {

        /* renamed from: j */
        private final Func1<? super T, ? extends K> f45334j;

        /* renamed from: k */
        private final Func1<? super T, ? extends V> f45335k;

        /* renamed from: l */
        private final Func1<? super K, ? extends Collection<V>> f45336l;

        /* JADX WARN: Multi-variable type inference failed */
        C15751b(Subscriber<? super Map<K, Collection<V>>> subscriber, Map<K, Collection<V>> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<? super K, ? extends Collection<V>> func13) {
            super(subscriber);
            this.f45882c = map;
            this.f45881b = true;
            this.f45334j = func1;
            this.f45335k = func12;
            this.f45336l = func13;
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45967i) {
                return;
            }
            try {
                K call = this.f45334j.call(t);
                V call2 = this.f45335k.call(t);
                Collection<V> collection = (Collection) ((Map) this.f45882c).get(call);
                if (collection == null) {
                    collection = this.f45336l.call(call);
                    ((Map) this.f45882c).put(call, collection);
                }
                collection.add(call2);
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

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(observable, func1, func12, null, C15750a.m1211a());
    }

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        this(observable, func1, func12, func0, C15750a.m1211a());
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        this.f45332e = observable;
        this.f45328a = func1;
        this.f45329b = func12;
        if (func0 == null) {
            this.f45330c = this;
        } else {
            this.f45330c = func0;
        }
        this.f45331d = func13;
    }

    @Override // p640rx.functions.Func0, java.util.concurrent.Callable
    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, Collection<V>>> subscriber) {
        try {
            new C15751b(subscriber, this.f45330c.call(), this.f45328a, this.f45329b, this.f45331d).m1088J(this.f45332e);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            subscriber.onError(th);
        }
    }
}
