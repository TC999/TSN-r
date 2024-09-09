package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PathInterpolatorCompatBase.java */
@RequiresApi(9)
@TargetApi(9)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c {
    private c() {
    }

    public static Interpolator a(float f4, float f5) {
        return new d(f4, f5);
    }

    public static Interpolator b(float f4, float f5, float f6, float f7) {
        return new d(f4, f5, f6, f7);
    }

    public static Interpolator c(Path path) {
        return new d(path);
    }
}
