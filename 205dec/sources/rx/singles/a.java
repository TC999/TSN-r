package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
import rx.internal.operators.e;
import rx.internal.util.d;
import rx.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BlockingSingle.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final i<? extends T> f64258a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BlockingSingle.java */
    /* renamed from: rx.singles.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class C1325a extends k<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f64259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f64260c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicReference f64261d;

        C1325a(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.f64259b = atomicReference;
            this.f64260c = countDownLatch;
            this.f64261d = atomicReference2;
        }

        public void d(T t3) {
            this.f64259b.set(t3);
            this.f64260c.countDown();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f64261d.set(th);
            this.f64260c.countDown();
        }
    }

    private a(i<? extends T> iVar) {
        this.f64258a = iVar;
    }

    public static <T> a<T> a(i<? extends T> iVar) {
        return new a<>(iVar);
    }

    public Future<T> b() {
        return e.a(this.f64258a.y0());
    }

    public T c() {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a(countDownLatch, this.f64258a.i0(new C1325a(atomicReference, countDownLatch, atomicReference2)));
        Throwable th = (Throwable) atomicReference2.get();
        if (th == null) {
            return (T) atomicReference.get();
        }
        throw rx.exceptions.a.c(th);
    }
}
