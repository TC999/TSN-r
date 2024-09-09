package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aor;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public double getRatio() {
        return this.aor;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.aor != 0.0d) {
            int size = View.MeasureSpec.getSize(i4);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            double d4 = (double) size;
            double d5 = this.aor;
            Double.isNaN(d4);
            i5 = View.MeasureSpec.makeMeasureSpec((int) (d4 * d5), 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    public void setRatio(double d4) {
        this.aor = d4;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.aor = 0.0d;
    }
}
