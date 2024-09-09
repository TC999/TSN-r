package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDelaySubscription.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f62424a;

    /* renamed from: b  reason: collision with root package name */
    final long f62425b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f62426c;

    /* renamed from: d  reason: collision with root package name */
    final rx.h f62427d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDelaySubscription.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62428a;

        a(rx.l lVar) {
            this.f62428a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f62428a.isUnsubscribed()) {
                return;
            }
            c0.this.f62424a.I6(rx.observers.h.f(this.f62428a));
        }
    }

    public c0(rx.e<? extends T> eVar, long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62424a = eVar;
        this.f62425b = j4;
        this.f62426c = timeUnit;
        this.f62427d = hVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        h.a a4 = this.f62427d.a();
        lVar.add(a4);
        a4.e(new a(lVar), this.f62425b, this.f62426c);
    }
}
