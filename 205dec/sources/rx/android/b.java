package rx.android;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MainThreadSubscription.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f62067a = new AtomicBoolean();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: MainThreadSubscription.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements rx.functions.a {
        a() {
        }

        @Override // rx.functions.a
        public void call() {
            b.this.a();
        }
    }

    public static void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    protected abstract void a();

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f62067a.get();
    }

    @Override // rx.m
    public final void unsubscribe() {
        if (this.f62067a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                rx.android.schedulers.a.b().a().c(new a());
            }
        }
    }
}
