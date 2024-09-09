package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeJoin.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p0<TLeft, TRight, TLeftDuration, TRightDuration, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<TLeft> f63089a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<TRight> f63090b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.p<TLeft, rx.e<TLeftDuration>> f63091c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.p<TRight, rx.e<TRightDuration>> f63092d;

    /* renamed from: e  reason: collision with root package name */
    final rx.functions.q<TLeft, TRight, R> f63093e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeJoin.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<? super R> f63095b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63096c;

        /* renamed from: d  reason: collision with root package name */
        int f63097d;

        /* renamed from: e  reason: collision with root package name */
        boolean f63098e;

        /* renamed from: f  reason: collision with root package name */
        int f63099f;

        /* renamed from: a  reason: collision with root package name */
        final rx.subscriptions.b f63094a = new rx.subscriptions.b();

        /* renamed from: g  reason: collision with root package name */
        final Map<Integer, TRight> f63100g = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeJoin.java */
        /* renamed from: rx.internal.operators.p0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1289a extends rx.l<TLeft> {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: OnSubscribeJoin.java */
            /* renamed from: rx.internal.operators.p0$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            final class C1290a extends rx.l<TLeftDuration> {

                /* renamed from: a  reason: collision with root package name */
                final int f63103a;

                /* renamed from: b  reason: collision with root package name */
                boolean f63104b = true;

                public C1290a(int i4) {
                    this.f63103a = i4;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f63104b) {
                        this.f63104b = false;
                        C1289a.this.g(this.f63103a, this);
                    }
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    C1289a.this.onError(th);
                }

                @Override // rx.f
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            C1289a() {
            }

            protected void g(int i4, rx.m mVar) {
                boolean z3;
                synchronized (a.this) {
                    z3 = a.this.a().remove(Integer.valueOf(i4)) != null && a.this.a().isEmpty() && a.this.f63096c;
                }
                if (z3) {
                    a.this.f63095b.onCompleted();
                    a.this.f63095b.unsubscribe();
                    return;
                }
                a.this.f63094a.g(mVar);
            }

            @Override // rx.f
            public void onCompleted() {
                boolean z3;
                synchronized (a.this) {
                    a aVar = a.this;
                    z3 = true;
                    aVar.f63096c = true;
                    if (!aVar.f63098e && !aVar.a().isEmpty()) {
                        z3 = false;
                    }
                }
                if (z3) {
                    a.this.f63095b.onCompleted();
                    a.this.f63095b.unsubscribe();
                    return;
                }
                a.this.f63094a.g(this);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f63095b.onError(th);
                a.this.f63095b.unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.f
            public void onNext(TLeft tleft) {
                int i4;
                a aVar;
                int i5;
                synchronized (a.this) {
                    a aVar2 = a.this;
                    i4 = aVar2.f63097d;
                    aVar2.f63097d = i4 + 1;
                    aVar2.a().put(Integer.valueOf(i4), tleft);
                    aVar = a.this;
                    i5 = aVar.f63099f;
                }
                try {
                    C1290a c1290a = new C1290a(i4);
                    a.this.f63094a.a(c1290a);
                    p0.this.f63091c.call(tleft).I6(c1290a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (a.this) {
                        for (Map.Entry<Integer, TRight> entry : a.this.f63100g.entrySet()) {
                            if (entry.getKey().intValue() < i5) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        a.this.f63095b.onNext(p0.this.f63093e.call(tleft, obj));
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeJoin.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class b extends rx.l<TRight> {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: OnSubscribeJoin.java */
            /* renamed from: rx.internal.operators.p0$a$b$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            final class C1291a extends rx.l<TRightDuration> {

                /* renamed from: a  reason: collision with root package name */
                final int f63107a;

                /* renamed from: b  reason: collision with root package name */
                boolean f63108b = true;

                public C1291a(int i4) {
                    this.f63107a = i4;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f63108b) {
                        this.f63108b = false;
                        b.this.g(this.f63107a, this);
                    }
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // rx.f
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            b() {
            }

            void g(int i4, rx.m mVar) {
                boolean z3;
                synchronized (a.this) {
                    z3 = a.this.f63100g.remove(Integer.valueOf(i4)) != null && a.this.f63100g.isEmpty() && a.this.f63098e;
                }
                if (z3) {
                    a.this.f63095b.onCompleted();
                    a.this.f63095b.unsubscribe();
                    return;
                }
                a.this.f63094a.g(mVar);
            }

            @Override // rx.f
            public void onCompleted() {
                boolean z3;
                synchronized (a.this) {
                    a aVar = a.this;
                    z3 = true;
                    aVar.f63098e = true;
                    if (!aVar.f63096c && !aVar.f63100g.isEmpty()) {
                        z3 = false;
                    }
                }
                if (z3) {
                    a.this.f63095b.onCompleted();
                    a.this.f63095b.unsubscribe();
                    return;
                }
                a.this.f63094a.g(this);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f63095b.onError(th);
                a.this.f63095b.unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.f
            public void onNext(TRight tright) {
                int i4;
                int i5;
                synchronized (a.this) {
                    a aVar = a.this;
                    i4 = aVar.f63099f;
                    aVar.f63099f = i4 + 1;
                    aVar.f63100g.put(Integer.valueOf(i4), tright);
                    i5 = a.this.f63097d;
                }
                a.this.f63094a.a(new rx.subscriptions.e());
                try {
                    C1291a c1291a = new C1291a(i4);
                    a.this.f63094a.a(c1291a);
                    p0.this.f63092d.call(tright).I6(c1291a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (a.this) {
                        for (Map.Entry<Integer, TLeft> entry : a.this.a().entrySet()) {
                            if (entry.getKey().intValue() < i5) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        a.this.f63095b.onNext(p0.this.f63093e.call(obj, tright));
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        public a(rx.l<? super R> lVar) {
            this.f63095b = lVar;
        }

        HashMap<Integer, TLeft> a() {
            return this;
        }

        public void b() {
            this.f63095b.add(this.f63094a);
            C1289a c1289a = new C1289a();
            b bVar = new b();
            this.f63094a.a(c1289a);
            this.f63094a.a(bVar);
            p0.this.f63089a.I6(c1289a);
            p0.this.f63090b.I6(bVar);
        }
    }

    public p0(rx.e<TLeft> eVar, rx.e<TRight> eVar2, rx.functions.p<TLeft, rx.e<TLeftDuration>> pVar, rx.functions.p<TRight, rx.e<TRightDuration>> pVar2, rx.functions.q<TLeft, TRight, R> qVar) {
        this.f63089a = eVar;
        this.f63090b = eVar2;
        this.f63091c = pVar;
        this.f63092d = pVar2;
        this.f63093e = qVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        new a(new rx.observers.g(lVar)).b();
    }
}
