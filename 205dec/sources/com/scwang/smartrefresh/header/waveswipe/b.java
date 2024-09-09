package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DropBounceInterpolator.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements Interpolator {
    public b() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 < 0.25f) {
            double d4 = f4;
            Double.isNaN(d4);
            return (((float) Math.pow(d4 - 0.125d, 2.0d)) * (-38.4f)) + 0.6f;
        }
        double d5 = f4;
        if (d5 < 0.5d || d5 >= 0.75d) {
            return 0.0f;
        }
        Double.isNaN(d5);
        return (((float) Math.pow(d5 - 0.625d, 2.0d)) * (-19.2f)) + 0.3f;
    }

    public b(Context context, AttributeSet attributeSet) {
    }
}
