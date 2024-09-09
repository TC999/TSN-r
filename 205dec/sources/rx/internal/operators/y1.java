package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDistinct.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y1<T, U> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends U> f63637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDistinct.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        Set<U> f63638a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63639b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63639b = lVar2;
            this.f63638a = new HashSet();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63638a = null;
            this.f63639b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63638a = null;
            this.f63639b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63638a.add(y1.this.f63637a.call(t3))) {
                this.f63639b.onNext(t3);
            } else {
                request(1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDistinct.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final y1<?, ?> f63641a = new y1<>(rx.internal.util.n.c());

        b() {
        }
    }

    public y1(rx.functions.p<? super T, ? extends U> pVar) {
        this.f63637a = pVar;
    }

    public static <T> y1<T, T> a() {
        return (y1<T, T>) b.f63641a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
