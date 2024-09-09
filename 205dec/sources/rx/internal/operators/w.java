package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeAmb.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends rx.e<? extends T>> f63483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeAmb.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63484a;

        a(d dVar) {
            this.f63484a = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            c<T> cVar = this.f63484a.get();
            if (cVar != null) {
                cVar.unsubscribe();
            }
            w.j(this.f63484a.f63491a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeAmb.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63486a;

        b(d dVar) {
            this.f63486a = dVar;
        }

        @Override // rx.g
        public void request(long j4) {
            c<T> cVar = this.f63486a.get();
            if (cVar != null) {
                cVar.x(j4);
                return;
            }
            for (c<T> cVar2 : this.f63486a.f63491a) {
                if (!cVar2.isUnsubscribed()) {
                    if (this.f63486a.get() == cVar2) {
                        cVar2.x(j4);
                        return;
                    }
                    cVar2.x(j4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeAmb.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f63488a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f63489b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f63490c;

        c(long j4, rx.l<? super T> lVar, d<T> dVar) {
            this.f63488a = lVar;
            this.f63489b = dVar;
            request(j4);
        }

        private boolean v() {
            if (this.f63490c) {
                return true;
            }
            if (this.f63489b.get() == this) {
                this.f63490c = true;
                return true;
            } else if (this.f63489b.compareAndSet(null, this)) {
                this.f63489b.b(this);
                this.f63490c = true;
                return true;
            } else {
                this.f63489b.a();
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            if (v()) {
                this.f63488a.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (v()) {
                this.f63488a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (v()) {
                this.f63488a.onNext(t3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeAmb.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends AtomicReference<c<T>> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<c<T>> f63491a = new ConcurrentLinkedQueue();

        d() {
        }

        public void a() {
            c<T> cVar = get();
            if (cVar != null) {
                b(cVar);
            }
        }

        public void b(c<T> cVar) {
            for (c<T> cVar2 : this.f63491a) {
                if (cVar2 != cVar) {
                    cVar2.unsubscribe();
                }
            }
            this.f63491a.clear();
        }
    }

    private w(Iterable<? extends rx.e<? extends T>> iterable) {
        this.f63483a = iterable;
    }

    public static <T> e.a<T> a(Iterable<? extends rx.e<? extends T>> iterable) {
        return new w(iterable);
    }

    public static <T> e.a<T> b(rx.e<? extends T> eVar, rx.e<? extends T> eVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        return a(arrayList);
    }

    public static <T> e.a<T> c(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        return a(arrayList);
    }

    public static <T> e.a<T> d(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        return a(arrayList);
    }

    public static <T> e.a<T> e(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        return a(arrayList);
    }

    public static <T> e.a<T> f(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        return a(arrayList);
    }

    public static <T> e.a<T> g(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        return a(arrayList);
    }

    public static <T> e.a<T> h(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7, rx.e<? extends T> eVar8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        return a(arrayList);
    }

    public static <T> e.a<T> i(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.e<? extends T> eVar3, rx.e<? extends T> eVar4, rx.e<? extends T> eVar5, rx.e<? extends T> eVar6, rx.e<? extends T> eVar7, rx.e<? extends T> eVar8, rx.e<? extends T> eVar9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        arrayList.add(eVar9);
        return a(arrayList);
    }

    static <T> void j(Collection<c<T>> collection) {
        if (collection.isEmpty()) {
            return;
        }
        for (c<T> cVar : collection) {
            cVar.unsubscribe();
        }
        collection.clear();
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        d dVar = new d();
        lVar.add(rx.subscriptions.f.a(new a(dVar)));
        for (rx.e<? extends T> eVar : this.f63483a) {
            if (lVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar = new c<>(0L, lVar, dVar);
            dVar.f63491a.add(cVar);
            c<T> cVar2 = dVar.get();
            if (cVar2 != null) {
                dVar.b(cVar2);
                return;
            }
            eVar.I6(cVar);
        }
        if (lVar.isUnsubscribed()) {
            j(dVar.f63491a);
        }
        lVar.setProducer(new b(dVar));
    }
}
