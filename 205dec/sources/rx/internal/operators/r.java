package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeMergeIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends rx.b> f63187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeMergeIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f63188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63189b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.d f63190c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f63191d;

        a(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar, AtomicInteger atomicInteger) {
            this.f63188a = bVar;
            this.f63189b = atomicBoolean;
            this.f63190c = dVar;
            this.f63191d = atomicInteger;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f63188a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f63191d.decrementAndGet() == 0 && this.f63189b.compareAndSet(false, true)) {
                this.f63190c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f63188a.unsubscribe();
            if (this.f63189b.compareAndSet(false, true)) {
                this.f63190c.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }
    }

    public r(Iterable<? extends rx.b> iterable) {
        this.f63187a = iterable;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        try {
            Iterator<? extends rx.b> it = this.f63187a.iterator();
            if (it == null) {
                dVar.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            while (!bVar.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                            dVar.onCompleted();
                            return;
                        }
                        return;
                    } else if (bVar.isUnsubscribed()) {
                        return;
                    } else {
                        try {
                            rx.b next = it.next();
                            if (bVar.isUnsubscribed()) {
                                return;
                            }
                            if (next == null) {
                                bVar.unsubscribe();
                                Throwable nullPointerException = new NullPointerException("A completable source is null");
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    dVar.onError(nullPointerException);
                                    return;
                                } else {
                                    rx.plugins.c.I(nullPointerException);
                                    return;
                                }
                            }
                            atomicInteger.getAndIncrement();
                            next.G0(new a(bVar, atomicBoolean, dVar, atomicInteger));
                        } catch (Throwable th) {
                            bVar.unsubscribe();
                            if (atomicBoolean.compareAndSet(false, true)) {
                                dVar.onError(th);
                                return;
                            } else {
                                rx.plugins.c.I(th);
                                return;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    bVar.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
                        dVar.onError(th2);
                        return;
                    } else {
                        rx.plugins.c.I(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            dVar.onError(th3);
        }
    }
}
