package p640rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.annotations.Experimental;

/* renamed from: rx.android.plugins.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RxAndroidPlugins {

    /* renamed from: b */
    private static final RxAndroidPlugins f44638b = new RxAndroidPlugins();

    /* renamed from: a */
    private final AtomicReference<RxAndroidSchedulersHook> f44639a = new AtomicReference<>();

    RxAndroidPlugins() {
    }

    /* renamed from: a */
    public static RxAndroidPlugins m1990a() {
        return f44638b;
    }

    /* renamed from: b */
    public RxAndroidSchedulersHook m1989b() {
        if (this.f44639a.get() == null) {
            this.f44639a.compareAndSet(null, RxAndroidSchedulersHook.m1986a());
        }
        return this.f44639a.get();
    }

    /* renamed from: c */
    public void m1988c(RxAndroidSchedulersHook rxAndroidSchedulersHook) {
        if (this.f44639a.compareAndSet(null, rxAndroidSchedulersHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f44639a.get());
    }

    @Experimental
    /* renamed from: d */
    public void m1987d() {
        this.f44639a.set(null);
    }
}
