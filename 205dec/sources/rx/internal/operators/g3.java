package rx.internal.operators;

import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSubscribeOn.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g3<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.h f62665a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<T> f62666b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f62667c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSubscribeOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62668a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f62669b;

        /* renamed from: c  reason: collision with root package name */
        final h.a f62670c;

        /* renamed from: d  reason: collision with root package name */
        rx.e<T> f62671d;

        /* renamed from: e  reason: collision with root package name */
        Thread f62672e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorSubscribeOn.java */
        /* renamed from: rx.internal.operators.g3$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1279a implements rx.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.g f62673a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: OperatorSubscribeOn.java */
            /* renamed from: rx.internal.operators.g3$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1280a implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ long f62675a;

                C1280a(long j4) {
                    this.f62675a = j4;
                }

                @Override // rx.functions.a
                public void call() {
                    C1279a.this.f62673a.request(this.f62675a);
                }
            }

            C1279a(rx.g gVar) {
                this.f62673a = gVar;
            }

            @Override // rx.g
            public void request(long j4) {
                if (a.this.f62672e != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.f62669b) {
                        aVar.f62670c.c(new C1280a(j4));
                        return;
                    }
                }
                this.f62673a.request(j4);
            }
        }

        a(rx.l<? super T> lVar, boolean z3, h.a aVar, rx.e<T> eVar) {
            this.f62668a = lVar;
            this.f62669b = z3;
            this.f62670c = aVar;
            this.f62671d = eVar;
        }

        @Override // rx.functions.a
        public void call() {
            rx.e<T> eVar = this.f62671d;
            this.f62671d = null;
            this.f62672e = Thread.currentThread();
            eVar.I6(this);
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f62668a.onCompleted();
            } finally {
                this.f62670c.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f62668a.onError(th);
            } finally {
                this.f62670c.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62668a.onNext(t3);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62668a.setProducer(new C1279a(gVar));
        }
    }

    public g3(rx.e<T> eVar, rx.h hVar, boolean z3) {
        this.f62665a = hVar;
        this.f62666b = eVar;
        this.f62667c = z3;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        h.a a4 = this.f62665a.a();
        a aVar = new a(lVar, this.f62667c, a4, this.f62666b);
        lVar.add(aVar);
        lVar.add(a4);
        a4.c(aVar);
    }
}
