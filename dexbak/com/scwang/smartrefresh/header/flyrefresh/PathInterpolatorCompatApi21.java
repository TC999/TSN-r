package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
@TargetApi(21)
/* renamed from: com.scwang.smartrefresh.header.flyrefresh.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class PathInterpolatorCompatApi21 {
    private PathInterpolatorCompatApi21() {
    }

    /* renamed from: a */
    public static Interpolator m20118a(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    /* renamed from: b */
    public static Interpolator m20117b(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }

    /* renamed from: c */
    public static Interpolator m20116c(Path path) {
        return new PathInterpolator(path);
    }
}
