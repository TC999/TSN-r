package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathInterpolatorCompatApi21.java */
@RequiresApi(21)
@TargetApi(21)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class b {
    private b() {
    }

    public static Interpolator a(float f4, float f5) {
        return new PathInterpolator(f4, f5);
    }

    public static Interpolator b(float f4, float f5, float f6, float f7) {
        return new PathInterpolator(f4, f5, f6, f7);
    }

    public static Interpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
