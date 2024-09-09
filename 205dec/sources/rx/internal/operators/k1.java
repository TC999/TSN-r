package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeUsing.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k1<T, Resource> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.functions.o<Resource> f62870a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.functions.p<? super Resource, ? extends rx.e<? extends T>> f62871b;

    /* renamed from: c  reason: collision with root package name */
    private final rx.functions.b<? super Resource> f62872c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f62873d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeUsing.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<Resource> extends AtomicBoolean implements rx.functions.a, rx.m {
        private static final long serialVersionUID = 4262875056400218316L;

        /* renamed from: a  reason: collision with root package name */
        private rx.functions.b<? super Resource> f62874a;

        /* renamed from: b  reason: collision with root package name */
        private Resource f62875b;

        a(rx.functions.b<? super Resource> bVar, Resource resource) {
            this.f62874a = bVar;
            this.f62875b = resource;
            lazySet(false);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.b<? super Resource>] */
        @Override // rx.functions.a
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r02 = (Resource) false;
                try {
                    this.f62874a.call((Resource) this.f62875b);
                } finally {
                    this.f62875b = null;
                    this.f62874a = null;
                }
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.m
        public void unsubscribe() {
            call();
        }
    }

    public k1(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends rx.e<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z3) {
        this.f62870a = oVar;
        this.f62871b = pVar;
        this.f62872c = bVar;
        this.f62873d = z3;
    }

    private Throwable a(rx.functions.a aVar) {
        try {
            aVar.call();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        rx.e<? extends T> G1;
        try {
            Resource call = this.f62870a.call();
            a aVar = new a(this.f62872c, call);
            lVar.add(aVar);
            rx.e<? extends T> call2 = this.f62871b.call(call);
            if (this.f62873d) {
                G1 = call2.O1(aVar);
            } else {
                G1 = call2.G1(aVar);
            }
            G1.I6(rx.observers.h.f(lVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
