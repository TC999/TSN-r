package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private Paint f29595c;

    /* renamed from: w  reason: collision with root package name */
    private RectF f29596w;

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f29596w;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f29595c);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f29596w.right == getMeasuredWidth() && this.f29596w.bottom == getMeasuredHeight()) {
            return;
        }
        this.f29596w.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
