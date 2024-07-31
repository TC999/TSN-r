package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(9)
@TargetApi(9)
/* renamed from: com.scwang.smartrefresh.header.flyrefresh.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class PathInterpolatorCompatBase {
    private PathInterpolatorCompatBase() {
    }

    /* renamed from: a */
    public static Interpolator m20115a(float f, float f2) {
        return new PathInterpolatorGingerbread(f, f2);
    }

    /* renamed from: b */
    public static Interpolator m20114b(float f, float f2, float f3, float f4) {
        return new PathInterpolatorGingerbread(f, f2, f3, f4);
    }

    /* renamed from: c */
    public static Interpolator m20113c(Path path) {
        return new PathInterpolatorGingerbread(path);
    }
}
