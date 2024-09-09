package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
            float f4 = fArr2[1] + fArr2[7];
            this.mPath.rewind();
            float f5 = measuredWidth;
            if (f5 >= fArr2[0] + fArr2[3]) {
                float f6 = measuredHeight;
                if (f6 > f4) {
                    this.mRectF.set(0.0f, 0.0f, f5, f6);
                    this.mPath.addRoundRect(this.mRectF, this.axk, Path.Direction.CW);
                    canvas.clipPath(this.mPath);
                }
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f4) {
        this.axk = new float[8];
        int i4 = 0;
        while (true) {
            float[] fArr = this.axk;
            if (i4 >= fArr.length) {
                return;
            }
            fArr[i4] = f4;
            i4++;
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float[] fArr) {
        this.axk = new float[8];
        int i4 = 0;
        while (true) {
            float[] fArr2 = this.axk;
            if (i4 >= fArr2.length) {
                return;
            }
            fArr2[i4] = fArr[i4];
            i4++;
        }
    }
}
