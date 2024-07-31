package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: pl.droidsonroids.gif.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class InvalidationHandler extends Handler {

    /* renamed from: b */
    static final int f44462b = -1;

    /* renamed from: a */
    private final WeakReference<GifDrawable> f44463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvalidationHandler(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.f44463a = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        GifDrawable gifDrawable = this.f44463a.get();
        if (gifDrawable == null) {
            return;
        }
        if (message.what == -1) {
            gifDrawable.invalidateSelf();
            return;
        }
        Iterator<AnimationListener> it = gifDrawable.f44418h.iterator();
        while (it.hasNext()) {
            it.next().m2476a(message.what);
        }
    }
}
