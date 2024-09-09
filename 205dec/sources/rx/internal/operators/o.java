package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeMergeArray.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.b[] f63020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeMergeArray.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63021a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63022b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.d f63023c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f63024d;

        a(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar, AtomicInteger atomicInteger) {
            this.f63021a = bVar;
            this.f63022b = atomicBoolean;
            this.f63023c = dVar;
            this.f63024d = atomicInteger;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63021a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f63024d.decrementAndGet() == 0 && this.f63022b.compareAndSet(false, true)) {
                this.f63023c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f63021a.unsubscribe();
            if (this.f63022b.compareAndSet(false, true)) {
                this.f63023c.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }
    }

    public o(rx.b[] bVarArr) {
        this.f63020a = bVarArr;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        boolean z3 = true;
        AtomicInteger atomicInteger = new AtomicInteger(this.f63020a.length + 1);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        dVar.a(bVar);
        rx.b[] bVarArr = this.f63020a;
        int length = bVarArr.length;
        boolean z4 = false;
        int i4 = 0;
        while (i4 < length) {
            rx.b bVar2 = bVarArr[i4];
            if (bVar.isUnsubscribed()) {
                return;
            }
            if (bVar2 == null) {
                bVar.unsubscribe();
                Throwable nullPointerException = new NullPointerException("A completable source is null");
                if (atomicBoolean.compareAndSet(z4, z3)) {
                    dVar.onError(nullPointerException);
                    return;
                }
                rx.plugins.c.I(nullPointerException);
            }
            bVar2.G0(new a(bVar, atomicBoolean, dVar, atomicInteger));
            i4++;
            z3 = true;
            z4 = false;
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            dVar.onCompleted();
        }
    }
}
