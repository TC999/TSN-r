package com.bytedance.adsdk.lottie;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class g {
    public static Interpolator a(float f4, float f5, float f6, float f7) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f4, f5, f6, f7) : new o(f4, f5, f6, f7);
    }
}
