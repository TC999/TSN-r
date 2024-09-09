package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeTimerPeriodically.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g1 implements e.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f62620a;

    /* renamed from: b  reason: collision with root package name */
    final long f62621b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f62622c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f62623d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeTimerPeriodically.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        long f62624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h.a f62626c;

        a(rx.l lVar, h.a aVar) {
            this.f62625b = lVar;
            this.f62626c = aVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                rx.l lVar = this.f62625b;
                long j4 = this.f62624a;
                this.f62624a = 1 + j4;
                lVar.onNext(Long.valueOf(j4));
            } catch (Throwable th) {
                try {
                    this.f62626c.unsubscribe();
                } finally {
                    rx.exceptions.a.f(th, this.f62625b);
                }
            }
        }
    }

    public g1(long j4, long j5, TimeUnit timeUnit, rx.h hVar) {
        this.f62620a = j4;
        this.f62621b = j5;
        this.f62622c = timeUnit;
        this.f62623d = hVar;
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Long> lVar) {
        h.a a4 = this.f62623d.a();
        lVar.add(a4);
        a4.g(new a(lVar, a4), this.f62620a, this.f62621b, this.f62622c);
    }
}
