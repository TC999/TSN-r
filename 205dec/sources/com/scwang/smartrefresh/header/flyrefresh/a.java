package com.scwang.smartrefresh.header.flyrefresh;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathInterpolatorCompat.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {
    private a() {
    }

    public static Interpolator a(float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a(f4, f5);
        }
        return c.a(f4, f5);
    }

    public static Interpolator b(float f4, float f5, float f6, float f7) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.b(f4, f5, f6, f7);
        }
        return c.b(f4, f5, f6, f7);
    }

    public static Interpolator c(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.c(path);
        }
        return c.c(path);
    }
}
