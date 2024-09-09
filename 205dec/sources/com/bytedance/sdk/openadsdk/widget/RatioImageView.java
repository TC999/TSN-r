package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RatioImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private float f36362c;

    public RatioImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int i6 = getLayoutParams().width;
        int i7 = getLayoutParams().height;
        float f4 = this.f36362c;
        if (f4 > 0.0f) {
            if (i6 == -2) {
                size = (int) (size2 * f4);
                mode = 1073741824;
            } else if (i7 == -2) {
                size2 = (int) (size / f4);
                mode2 = 1073741824;
            }
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setRatio(float f4) {
        this.f36362c = f4;
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
