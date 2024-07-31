package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.amap.api.maps.model.WeightedLatLng;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RelativeCornerSize implements CornerSize {
    private final float percent;

    public RelativeCornerSize(@FloatRange(from = 0.0d, m60036to = 1.0d) float f) {
        this.percent = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RelativeCornerSize) && this.percent == ((RelativeCornerSize) obj).percent;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return this.percent * rectF.height();
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON, m60036to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getRelativePercent() {
        return this.percent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.percent)});
    }
}
