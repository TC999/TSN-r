package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeConcatArray.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.b[] f62898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeConcatArray.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends AtomicInteger implements rx.d {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a  reason: collision with root package name */
        final rx.d f62899a;

        /* renamed from: b  reason: collision with root package name */
        final rx.b[] f62900b;

        /* renamed from: c  reason: collision with root package name */
        int f62901c;

        /* renamed from: d  reason: collision with root package name */
        final rx.subscriptions.e f62902d = new rx.subscriptions.e();

        public a(rx.d dVar, rx.b[] bVarArr) {
            this.f62899a = dVar;
            this.f62900b = bVarArr;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62902d.b(mVar);
        }

        void b() {
            if (!this.f62902d.isUnsubscribed() && getAndIncrement() == 0) {
                rx.b[] bVarArr = this.f62900b;
                while (!this.f62902d.isUnsubscribed()) {
                    int i4 = this.f62901c;
                    this.f62901c = i4 + 1;
                    if (i4 == bVarArr.length) {
                        this.f62899a.onCompleted();
                        return;
                    }
                    bVarArr[i4].G0(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62899a.onError(th);
        }
    }

    public l(rx.b[] bVarArr) {
        this.f62898a = bVarArr;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f62898a);
        dVar.a(aVar.f62902d);
        aVar.b();
    }
}
