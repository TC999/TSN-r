package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSkipLastTimed.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f62498a;

    /* renamed from: b  reason: collision with root package name */
    final rx.h f62499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipLastTimed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private Deque<rx.schedulers.f<T>> f62500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62501b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62501b = lVar2;
            this.f62500a = new ArrayDeque();
        }

        private void g(long j4) {
            long j5 = j4 - d3.this.f62498a;
            while (!this.f62500a.isEmpty()) {
                rx.schedulers.f<T> first = this.f62500a.getFirst();
                if (first.a() >= j5) {
                    return;
                }
                this.f62500a.removeFirst();
                this.f62501b.onNext(first.b());
            }
        }

        @Override // rx.f
        public void onCompleted() {
            g(d3.this.f62499b.b());
            this.f62501b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62501b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long b4 = d3.this.f62499b.b();
            g(b4);
            this.f62500a.offerLast(new rx.schedulers.f<>(b4, t3));
        }
    }

    public d3(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62498a = timeUnit.toMillis(j4);
        this.f62499b = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
