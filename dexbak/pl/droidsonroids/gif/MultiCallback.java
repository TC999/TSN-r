package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: pl.droidsonroids.gif.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MultiCallback implements Drawable.Callback {

    /* renamed from: a */
    private final CopyOnWriteArrayList<C15458a> f44466a;

    /* renamed from: b */
    private final boolean f44467b;

    /* compiled from: MultiCallback.java */
    /* renamed from: pl.droidsonroids.gif.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15458a extends WeakReference<Drawable.Callback> {
        C15458a(Drawable.Callback callback) {
            super(callback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && C15458a.class == obj.getClass() && get() == ((C15458a) obj).get();
        }

        public int hashCode() {
            Drawable.Callback callback = get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public MultiCallback() {
        this(false);
    }

    /* renamed from: a */
    public void m2365a(Drawable.Callback callback) {
        for (int i = 0; i < this.f44466a.size(); i++) {
            C15458a c15458a = this.f44466a.get(i);
            if (c15458a.get() == null) {
                this.f44466a.remove(c15458a);
            }
        }
        this.f44466a.addIfAbsent(new C15458a(callback));
    }

    /* renamed from: b */
    public void m2364b(Drawable.Callback callback) {
        for (int i = 0; i < this.f44466a.size(); i++) {
            C15458a c15458a = this.f44466a.get(i);
            Drawable.Callback callback2 = c15458a.get();
            if (callback2 == null || callback2 == callback) {
                this.f44466a.remove(c15458a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        for (int i = 0; i < this.f44466a.size(); i++) {
            C15458a c15458a = this.f44466a.get(i);
            Drawable.Callback callback = c15458a.get();
            if (callback != null) {
                if (this.f44467b && (callback instanceof View)) {
                    ((View) callback).invalidate();
                } else {
                    callback.invalidateDrawable(drawable);
                }
            } else {
                this.f44466a.remove(c15458a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        for (int i = 0; i < this.f44466a.size(); i++) {
            C15458a c15458a = this.f44466a.get(i);
            Drawable.Callback callback = c15458a.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            } else {
                this.f44466a.remove(c15458a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        for (int i = 0; i < this.f44466a.size(); i++) {
            C15458a c15458a = this.f44466a.get(i);
            Drawable.Callback callback = c15458a.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.f44466a.remove(c15458a);
            }
        }
    }

    public MultiCallback(boolean z) {
        this.f44466a = new CopyOnWriteArrayList<>();
        this.f44467b = z;
    }
}
