package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeTimerOnce.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f1 implements e.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f62573a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f62574b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f62575c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeTimerOnce.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62576a;

        a(rx.l lVar) {
            this.f62576a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.f62576a.onNext(0L);
                this.f62576a.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f62576a);
            }
        }
    }

    public f1(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62573a = j4;
        this.f62574b = timeUnit;
        this.f62575c = hVar;
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Long> lVar) {
        h.a a4 = this.f62575c.a();
        lVar.add(a4);
        a4.e(new a(lVar), this.f62573a, this.f62574b);
    }
}
