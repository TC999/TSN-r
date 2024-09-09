package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Experimental;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RxAndroidPlugins.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f62069b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b> f62070a = new AtomicReference<>();

    a() {
    }

    public static a a() {
        return f62069b;
    }

    public b b() {
        if (this.f62070a.get() == null) {
            this.f62070a.compareAndSet(null, b.a());
        }
        return this.f62070a.get();
    }

    public void c(b bVar) {
        if (this.f62070a.compareAndSet(null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f62070a.get());
    }

    @Experimental
    public void d() {
        this.f62070a.set(null);
    }
}
