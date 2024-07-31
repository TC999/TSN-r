package p640rx.android;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Subscription;
import p640rx.android.schedulers.AndroidSchedulers;
import p640rx.functions.Action0;

/* renamed from: rx.android.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MainThreadSubscription implements Subscription {

    /* renamed from: a */
    private final AtomicBoolean f44636a = new AtomicBoolean();

    /* compiled from: MainThreadSubscription.java */
    /* renamed from: rx.android.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15503a implements Action0 {
        C15503a() {
        }

        @Override // p640rx.functions.Action0
        public void call() {
            MainThreadSubscription.this.m1992a();
        }
    }

    /* renamed from: b */
    public static void m1991b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    /* renamed from: a */
    protected abstract void m1992a();

    @Override // p640rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f44636a.get();
    }

    @Override // p640rx.Subscription
    public final void unsubscribe() {
        if (this.f44636a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m1992a();
            } else {
                AndroidSchedulers.m1982b().mo450a().mo456d(new C15503a());
            }
        }
    }
}
