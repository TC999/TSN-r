package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* renamed from: com.scwang.smartrefresh.header.waveswipe.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DropBounceInterpolator implements Interpolator {
    public DropBounceInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f < 0.25f) {
            double d = f;
            Double.isNaN(d);
            return (((float) Math.pow(d - 0.125d, 2.0d)) * (-38.4f)) + 0.6f;
        }
        double d2 = f;
        if (d2 < 0.5d || d2 >= 0.75d) {
            return 0.0f;
        }
        Double.isNaN(d2);
        return (((float) Math.pow(d2 - 0.625d, 2.0d)) * (-19.2f)) + 0.3f;
    }

    public DropBounceInterpolator(Context context, AttributeSet attributeSet) {
    }
}
