package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleOperatorZip.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x4 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleOperatorZip.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<R> implements i.t<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.i[] f63603a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.y f63604b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: SingleOperatorZip.java */
        /* renamed from: rx.internal.operators.x4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1305a<T> extends rx.k<T> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object[] f63605b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f63606c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AtomicInteger f63607d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ rx.k f63608e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f63609f;

            C1305a(Object[] objArr, int i4, AtomicInteger atomicInteger, rx.k kVar, AtomicBoolean atomicBoolean) {
                this.f63605b = objArr;
                this.f63606c = i4;
                this.f63607d = atomicInteger;
                this.f63608e = kVar;
                this.f63609f = atomicBoolean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.k
            public void c(T t3) {
                this.f63605b[this.f63606c] = t3;
                if (this.f63607d.decrementAndGet() == 0) {
                    try {
                        this.f63608e.c(a.this.f63604b.call(this.f63605b));
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        onError(th);
                    }
                }
            }

            @Override // rx.k
            public void onError(Throwable th) {
                if (this.f63609f.compareAndSet(false, true)) {
                    this.f63608e.onError(th);
                } else {
                    rx.plugins.c.I(th);
                }
            }
        }

        a(rx.i[] iVarArr, rx.functions.y yVar) {
            this.f63603a = iVarArr;
            this.f63604b = yVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super R> kVar) {
            if (this.f63603a.length == 0) {
                kVar.onError(new NoSuchElementException("Can't zip 0 Singles."));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(this.f63603a.length);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            Object[] objArr = new Object[this.f63603a.length];
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            kVar.b(bVar);
            for (int i4 = 0; i4 < this.f63603a.length && !bVar.isUnsubscribed() && !atomicBoolean.get(); i4++) {
                C1305a c1305a = new C1305a(objArr, i4, atomicInteger, kVar, atomicBoolean);
                bVar.a(c1305a);
                if (bVar.isUnsubscribed() || atomicBoolean.get()) {
                    return;
                }
                this.f63603a[i4].i0(c1305a);
            }
        }
    }

    private x4() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> rx.i<R> a(rx.i<? extends T>[] iVarArr, rx.functions.y<? extends R> yVar) {
        return rx.i.m(new a(iVarArr, yVar));
    }
}
