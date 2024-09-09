package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorBufferWithStartEndObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q1<T, TOpening, TClosing> implements e.b<List<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends TOpening> f63158a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super TOpening, ? extends rx.e<? extends TClosing>> f63159b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithStartEndObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<TOpening> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63160a;

        a(b bVar) {
            this.f63160a = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63160a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63160a.onError(th);
        }

        @Override // rx.f
        public void onNext(TOpening topening) {
            this.f63160a.v(topening);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithStartEndObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63162a;

        /* renamed from: b  reason: collision with root package name */
        final List<List<T>> f63163b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        boolean f63164c;

        /* renamed from: d  reason: collision with root package name */
        final rx.subscriptions.b f63165d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithStartEndObservable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<TClosing> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List f63167a;

            a(List list) {
                this.f63167a = list;
            }

            @Override // rx.f
            public void onCompleted() {
                b.this.f63165d.g(this);
                b.this.g(this.f63167a);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                b.this.onError(th);
            }

            @Override // rx.f
            public void onNext(TClosing tclosing) {
                b.this.f63165d.g(this);
                b.this.g(this.f63167a);
            }
        }

        public b(rx.l<? super List<T>> lVar) {
            this.f63162a = lVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f63165d = bVar;
            add(bVar);
        }

        void g(List<T> list) {
            boolean z3;
            synchronized (this) {
                if (this.f63164c) {
                    return;
                }
                Iterator<List<T>> it = this.f63163b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (it.next() == list) {
                        z3 = true;
                        it.remove();
                        break;
                    }
                }
                if (z3) {
                    this.f63162a.onNext(list);
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f63164c) {
                        return;
                    }
                    this.f63164c = true;
                    LinkedList<List> linkedList = new LinkedList(this.f63163b);
                    this.f63163b.clear();
                    for (List list : linkedList) {
                        this.f63162a.onNext(list);
                    }
                    this.f63162a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f63162a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f63164c) {
                    return;
                }
                this.f63164c = true;
                this.f63163b.clear();
                this.f63162a.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this) {
                for (List<T> list : this.f63163b) {
                    list.add(t3);
                }
            }
        }

        void v(TOpening topening) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f63164c) {
                    return;
                }
                this.f63163b.add(arrayList);
                try {
                    rx.e<? extends TClosing> call = q1.this.f63159b.call(topening);
                    a aVar = new a(arrayList);
                    this.f63165d.a(aVar);
                    call.I6(aVar);
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }
    }

    public q1(rx.e<? extends TOpening> eVar, rx.functions.p<? super TOpening, ? extends rx.e<? extends TClosing>> pVar) {
        this.f63158a = eVar;
        this.f63159b = pVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        b bVar = new b(new rx.observers.g(lVar));
        a aVar = new a(bVar);
        lVar.add(aVar);
        lVar.add(bVar);
        this.f63158a.I6(aVar);
        return bVar;
    }
}
