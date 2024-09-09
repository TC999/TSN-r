package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeToMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h1<T, K, V> implements e.a<Map<K, V>>, rx.functions.o<Map<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62704a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends K> f62705b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends V> f62706c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.o<? extends Map<K, V>> f62707d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeToMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, K, V> extends u<T, Map<K, V>> {

        /* renamed from: j  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends K> f62708j;

        /* renamed from: k  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends V> f62709k;

        /* JADX WARN: Multi-variable type inference failed */
        a(rx.l<? super Map<K, V>> lVar, Map<K, V> map, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
            super(lVar);
            this.f63313c = map;
            this.f63312b = true;
            this.f62708j = pVar;
            this.f62709k = pVar2;
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63398i) {
                return;
            }
            try {
                ((Map) this.f63313c).put(this.f62708j.call(t3), this.f62709k.call(t3));
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

    public h1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(eVar, pVar, pVar2, null);
    }

    public h1(rx.e<T> eVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.o<? extends Map<K, V>> oVar) {
        this.f62704a = eVar;
        this.f62705b = pVar;
        this.f62706c = pVar2;
        if (oVar == null) {
            this.f62707d = this;
        } else {
            this.f62707d = oVar;
        }
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    @Override // rx.functions.o, java.util.concurrent.Callable
    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(rx.l<? super Map<K, V>> lVar) {
        try {
            new a(lVar, this.f62707d.call(), this.f62705b, this.f62706c).J(this.f62704a);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
