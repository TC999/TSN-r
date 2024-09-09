package rx.internal.operators;

import java.util.Iterator;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorZipIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g4<T1, T2, R> implements e.b<R, T1> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T2> f62677a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.q<? super T1, ? super T2, ? extends R> f62678b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorZipIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T1> {

        /* renamed from: a  reason: collision with root package name */
        boolean f62679a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62680b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterator f62681c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2, Iterator it) {
            super(lVar);
            this.f62680b = lVar2;
            this.f62681c = it;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62679a) {
                return;
            }
            this.f62679a = true;
            this.f62680b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62679a) {
                rx.exceptions.a.e(th);
                return;
            }
            this.f62679a = true;
            this.f62680b.onError(th);
        }

        @Override // rx.f
        public void onNext(T1 t12) {
            if (this.f62679a) {
                return;
            }
            try {
                this.f62680b.onNext(g4.this.f62678b.call(t12, (Object) this.f62681c.next()));
                if (this.f62681c.hasNext()) {
                    return;
                }
                onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }
    }

    public g4(Iterable<? extends T2> iterable, rx.functions.q<? super T1, ? super T2, ? extends R> qVar) {
        this.f62677a = iterable;
        this.f62678b = qVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T1> call(rx.l<? super R> lVar) {
        Iterator<? extends T2> it = this.f62677a.iterator();
        try {
            if (!it.hasNext()) {
                lVar.onCompleted();
                return rx.observers.h.d();
            }
            return new a(lVar, lVar, it);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
            return rx.observers.h.d();
        }
    }
}
