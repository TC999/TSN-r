package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorBufferWithTime.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r1<T> implements e.b<List<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f63198a;

    /* renamed from: b  reason: collision with root package name */
    final long f63199b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f63200c;

    /* renamed from: d  reason: collision with root package name */
    final int f63201d;

    /* renamed from: e  reason: collision with root package name */
    final rx.h f63202e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63203a;

        /* renamed from: b  reason: collision with root package name */
        final h.a f63204b;

        /* renamed from: c  reason: collision with root package name */
        List<T> f63205c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        boolean f63206d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithTime.java */
        /* renamed from: rx.internal.operators.r1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1293a implements rx.functions.a {
            C1293a() {
            }

            @Override // rx.functions.a
            public void call() {
                a.this.g();
            }
        }

        public a(rx.l<? super List<T>> lVar, h.a aVar) {
            this.f63203a = lVar;
            this.f63204b = aVar;
        }

        void g() {
            synchronized (this) {
                if (this.f63206d) {
                    return;
                }
                List<T> list = this.f63205c;
                this.f63205c = new ArrayList();
                try {
                    this.f63203a.onNext(list);
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f63204b.unsubscribe();
                synchronized (this) {
                    if (this.f63206d) {
                        return;
                    }
                    this.f63206d = true;
                    List<T> list = this.f63205c;
                    this.f63205c = null;
                    this.f63203a.onNext(list);
                    this.f63203a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f63203a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f63206d) {
                    return;
                }
                this.f63206d = true;
                this.f63205c = null;
                this.f63203a.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            List<T> list;
            synchronized (this) {
                if (this.f63206d) {
                    return;
                }
                this.f63205c.add(t3);
                if (this.f63205c.size() == r1.this.f63201d) {
                    list = this.f63205c;
                    this.f63205c = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.f63203a.onNext(list);
                }
            }
        }

        void v() {
            h.a aVar = this.f63204b;
            C1293a c1293a = new C1293a();
            r1 r1Var = r1.this;
            long j4 = r1Var.f63198a;
            aVar.g(c1293a, j4, j4, r1Var.f63200c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63209a;

        /* renamed from: b  reason: collision with root package name */
        final h.a f63210b;

        /* renamed from: c  reason: collision with root package name */
        final List<List<T>> f63211c = new LinkedList();

        /* renamed from: d  reason: collision with root package name */
        boolean f63212d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithTime.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithTime.java */
        /* renamed from: rx.internal.operators.r1$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1294b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List f63215a;

            C1294b(List list) {
                this.f63215a = list;
            }

            @Override // rx.functions.a
            public void call() {
                b.this.g(this.f63215a);
            }
        }

        public b(rx.l<? super List<T>> lVar, h.a aVar) {
            this.f63209a = lVar;
            this.f63210b = aVar;
        }

        void g(List<T> list) {
            boolean z3;
            synchronized (this) {
                if (this.f63212d) {
                    return;
                }
                Iterator<List<T>> it = this.f63211c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (it.next() == list) {
                        it.remove();
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    try {
                        this.f63209a.onNext(list);
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, this);
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f63212d) {
                        return;
                    }
                    this.f63212d = true;
                    LinkedList<List> linkedList = new LinkedList(this.f63211c);
                    this.f63211c.clear();
                    for (List list : linkedList) {
                        this.f63209a.onNext(list);
                    }
                    this.f63209a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f63209a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f63212d) {
                    return;
                }
                this.f63212d = true;
                this.f63211c.clear();
                this.f63209a.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this) {
                if (this.f63212d) {
                    return;
                }
                Iterator<List<T>> it = this.f63211c.iterator();
                LinkedList<List> linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t3);
                    if (next.size() == r1.this.f63201d) {
                        it.remove();
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(next);
                    }
                }
                if (linkedList != null) {
                    for (List list : linkedList) {
                        this.f63209a.onNext(list);
                    }
                }
            }
        }

        void v() {
            h.a aVar = this.f63210b;
            a aVar2 = new a();
            r1 r1Var = r1.this;
            long j4 = r1Var.f63199b;
            aVar.g(aVar2, j4, j4, r1Var.f63200c);
        }

        void x() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f63212d) {
                    return;
                }
                this.f63211c.add(arrayList);
                h.a aVar = this.f63210b;
                C1294b c1294b = new C1294b(arrayList);
                r1 r1Var = r1.this;
                aVar.e(c1294b, r1Var.f63198a, r1Var.f63200c);
            }
        }
    }

    public r1(long j4, long j5, TimeUnit timeUnit, int i4, rx.h hVar) {
        this.f63198a = j4;
        this.f63199b = j5;
        this.f63200c = timeUnit;
        this.f63201d = i4;
        this.f63202e = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        h.a a4 = this.f63202e.a();
        rx.observers.g gVar = new rx.observers.g(lVar);
        if (this.f63198a == this.f63199b) {
            a aVar = new a(gVar, a4);
            aVar.add(a4);
            lVar.add(aVar);
            aVar.v();
            return aVar;
        }
        b bVar = new b(gVar, a4);
        bVar.add(a4);
        lVar.add(bVar);
        bVar.x();
        bVar.v();
        return bVar;
    }
}
