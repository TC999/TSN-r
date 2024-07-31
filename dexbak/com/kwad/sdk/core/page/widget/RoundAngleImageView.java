package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RoundAngleImageView extends ImageView {
    private float[] axk;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr = this.axk;
        if (fArr != null && fArr.length == 8) {
            if (Build.VERSION.SDK_INT < 18) {
                setLayerType(1, null);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float[] fArr2 = this.axk;
            float f = fArr2[1] + fArr2[7];
            this.mPath.rewind();
            float f2 = measuredWidth;
            if (f2 >= fArr2[0] + fArr2[3]) {
                float f3 = measuredHeight;
                if (f3 > f) {
                    this.mRectF.set(0.0f, 0.0f, f2, f3);
                    this.mPath.addRoundRect(this.mRectF, this.axk, Path.Direction.CW);
                    canvas.clipPath(this.mPath);
                }
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.axk = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.axk;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f;
            i++;
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float[] fArr) {
        this.axk = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.axk;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }
}
