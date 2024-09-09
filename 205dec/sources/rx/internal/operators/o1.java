package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorBufferWithSingleObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o1<T, TClosing> implements e.b<List<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends TClosing>> f63053a;

    /* renamed from: b  reason: collision with root package name */
    final int f63054b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements rx.functions.o<rx.e<? extends TClosing>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f63055a;

        a(rx.e eVar) {
            this.f63055a = eVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.e<? extends TClosing> call() {
            return this.f63055a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<TClosing> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63057a;

        b(c cVar) {
            this.f63057a = cVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63057a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63057a.onError(th);
        }

        @Override // rx.f
        public void onNext(TClosing tclosing) {
            this.f63057a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class c extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63059a;

        /* renamed from: b  reason: collision with root package name */
        List<T> f63060b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63061c;

        public c(rx.l<? super List<T>> lVar) {
            this.f63059a = lVar;
            this.f63060b = new ArrayList(o1.this.f63054b);
        }

        void g() {
            synchronized (this) {
                if (this.f63061c) {
                    return;
                }
                List<T> list = this.f63060b;
                this.f63060b = new ArrayList(o1.this.f63054b);
                try {
                    this.f63059a.onNext(list);
                } catch (Throwable th) {
                    unsubscribe();
                    synchronized (this) {
                        if (this.f63061c) {
                            return;
                        }
                        this.f63061c = true;
                        rx.exceptions.a.f(th, this.f63059a);
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f63061c) {
                        return;
                    }
                    this.f63061c = true;
                    List<T> list = this.f63060b;
                    this.f63060b = null;
                    this.f63059a.onNext(list);
                    this.f63059a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f63059a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f63061c) {
                    return;
                }
                this.f63061c = true;
                this.f63060b = null;
                this.f63059a.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this) {
                if (this.f63061c) {
                    return;
                }
                this.f63060b.add(t3);
            }
        }
    }

    public o1(rx.functions.o<? extends rx.e<? extends TClosing>> oVar, int i4) {
        this.f63053a = oVar;
        this.f63054b = i4;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        try {
            rx.e<? extends TClosing> call = this.f63053a.call();
            c cVar = new c(new rx.observers.g(lVar));
            b bVar = new b(cVar);
            lVar.add(bVar);
            lVar.add(cVar);
            call.I6(bVar);
            return cVar;
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
            return rx.observers.h.d();
        }
    }

    public o1(rx.e<? extends TClosing> eVar, int i4) {
        this.f63053a = new a(eVar);
        this.f63054b = i4;
    }
}
