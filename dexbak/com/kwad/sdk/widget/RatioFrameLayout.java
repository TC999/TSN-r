package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aor;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public double getRatio() {
        return this.aor;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aor != Utils.DOUBLE_EPSILON) {
            int size = View.MeasureSpec.getSize(i);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            double d = (double) size;
            double d2 = this.aor;
            Double.isNaN(d);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (d * d2), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(double d) {
        this.aor = d;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aor = Utils.DOUBLE_EPSILON;
    }
}
