package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(path);
        }
        return new PathInterpolatorApi14(path);
    }

    public static Interpolator create(float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f4, f5);
        }
        return new PathInterpolatorApi14(f4, f5);
    }

    public static Interpolator create(float f4, float f5, float f6, float f7) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f4, f5, f6, f7);
        }
        return new PathInterpolatorApi14(f4, f5, f6, f7);
    }
}
