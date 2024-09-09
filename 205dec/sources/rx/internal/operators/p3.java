package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorThrottleFirst.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f63138a;

    /* renamed from: b  reason: collision with root package name */
    final rx.h f63139b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorThrottleFirst.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f63140a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63141b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63141b = lVar2;
            this.f63140a = -1L;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63141b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63141b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long b4 = p3.this.f63139b.b();
            long j4 = this.f63140a;
            if (j4 == -1 || b4 < j4 || b4 - j4 >= p3.this.f63138a) {
                this.f63140a = b4;
                this.f63141b.onNext(t3);
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public p3(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f63138a = timeUnit.toMillis(j4);
        this.f63139b = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
