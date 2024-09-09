package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeToMultimap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i1<T, K, V> implements e.a<Map<K, Collection<V>>>, rx.functions.o<Map<K, Collection<V>>> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.functions.p<? super T, ? extends K> f62759a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.functions.p<? super T, ? extends V> f62760b;

    /* renamed from: c  reason: collision with root package name */
    private final rx.functions.o<? extends Map<K, Collection<V>>> f62761c;

    /* renamed from: d  reason: collision with root package name */
    private final rx.functions.p<? super K, ? extends Collection<V>> f62762d;

    /* renamed from: e  reason: collision with root package name */
    private final rx.e<T> f62763e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeToMultimap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a<K, V> implements rx.functions.p<K, Collection<V>> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<Object, Object> f62764a = new a<>();

        private a() {
        }

        static <K, V> a<K, V> a() {
            return (a<K, V>) f62764a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a<K, V>) obj);
        }

        @Override // rx.functions.p
        public Collection<V> call(K k4) {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeToMultimap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, K, V> extends u<T, Map<K, Collection<V>>> {

        /* renamed from: j  reason: collision with root package name */
        private final rx.functions.p<? super T, ? extends K> f62765j;

        /* renamed from: k  reason: collision with root package name */
        private final rx.functions.p<? super T, ? extends V> f62766k;

        /* renamed from: l  reason: collision with root package name */
        private final rx.functions.p<? super K, ? extends Collection<V>> f62767l;

        /* JADX WARN: Multi-variable type inference failed */
        b(rx.l<? super Map<K, Collection<V>>> lVar, Map<K, Collection<V>> map, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.p<? super K, ? extends Collection<V>> pVar3) {
            super(lVar);
            this.f63313c = map;
            this.f63312b = true;
            this.f62765j = pVar;
            this.f62766k = pVar2;
            this.f62767l = pVar3;
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63398i) {
                return;
            }
            try {
                K call = this.f62765j.call(t3);
                V call2 = this.f62766k.call(t3);
                Collection<V> collection = (Collection) ((Map) this.f63313c).get(call);
                if (collection == null) {
                    collection = this.f62767l.call(call);
                    ((Map) this.f63313c).put(call, collection);
                }
                collection.add(call2);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public i1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(eVar, pVar, pVar2, null, a.a());
    }

    public i1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, Collection<V>>> oVar) {
        this(eVar, pVar, pVar2, oVar, a.a());
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public i1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, Collection<V>>> oVar, rx.functions.p<? super K, ? extends Collection<V>> pVar3) {
        this.f62763e = eVar;
        this.f62759a = pVar;
        this.f62760b = pVar2;
        if (oVar == null) {
            this.f62761c = this;
        } else {
            this.f62761c = oVar;
        }
        this.f62762d = pVar3;
    }

    @Override // rx.functions.o, java.util.concurrent.Callable
    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    public void call(rx.l<? super Map<K, Collection<V>>> lVar) {
        try {
            new b(lVar, this.f62761c.call(), this.f62759a, this.f62760b, this.f62762d).J(this.f62763e);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }
}
