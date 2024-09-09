package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MultiCallback.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class o implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f61879a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f61880b;

    /* compiled from: MultiCallback.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends WeakReference<Drawable.Callback> {
        a(Drawable.Callback callback) {
            super(callback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && get() == ((a) obj).get();
        }

        public int hashCode() {
            Drawable.Callback callback = get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public o() {
        this(false);
    }

    public void a(Drawable.Callback callback) {
        for (int i4 = 0; i4 < this.f61879a.size(); i4++) {
            a aVar = this.f61879a.get(i4);
            if (aVar.get() == null) {
                this.f61879a.remove(aVar);
            }
        }
        this.f61879a.addIfAbsent(new a(callback));
    }

    public void b(Drawable.Callback callback) {
        for (int i4 = 0; i4 < this.f61879a.size(); i4++) {
            a aVar = this.f61879a.get(i4);
            Drawable.Callback callback2 = aVar.get();
            if (callback2 == null || callback2 == callback) {
                this.f61879a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        for (int i4 = 0; i4 < this.f61879a.size(); i4++) {
            a aVar = this.f61879a.get(i4);
            Drawable.Callback callback = aVar.get();
            if (callback != null) {
                if (this.f61880b && (callback instanceof View)) {
                    ((View) callback).invalidate();
                } else {
                    callback.invalidateDrawable(drawable);
                }
            } else {
                this.f61879a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
        for (int i4 = 0; i4 < this.f61879a.size(); i4++) {
            a aVar = this.f61879a.get(i4);
            Drawable.Callback callback = aVar.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j4);
            } else {
                this.f61879a.remove(aVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        for (int i4 = 0; i4 < this.f61879a.size(); i4++) {
            a aVar = this.f61879a.get(i4);
            Drawable.Callback callback = aVar.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.f61879a.remove(aVar);
            }
        }
    }

    public o(boolean z3) {
        this.f61879a = new CopyOnWriteArrayList<>();
        this.f61880b = z3;
    }
}
