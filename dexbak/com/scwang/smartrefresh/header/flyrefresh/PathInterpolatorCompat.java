package com.scwang.smartrefresh.header.flyrefresh;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

/* renamed from: com.scwang.smartrefresh.header.flyrefresh.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    /* renamed from: a */
    public static Interpolator m20121a(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PathInterpolatorCompatApi21.m20118a(f, f2);
        }
        return PathInterpolatorCompatBase.m20115a(f, f2);
    }

    /* renamed from: b */
    public static Interpolator m20120b(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PathInterpolatorCompatApi21.m20117b(f, f2, f3, f4);
        }
        return PathInterpolatorCompatBase.m20114b(f, f2, f3, f4);
    }

    /* renamed from: c */
    public static Interpolator m20119c(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PathInterpolatorCompatApi21.m20116c(path);
        }
        return PathInterpolatorCompatBase.m20113c(path);
    }
}
