package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private Paint f36367c;

    /* renamed from: w  reason: collision with root package name */
    private RectF f36368w;

    public ShadowImageView(Context context) {
        super(context);
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.f36367c = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f36367c.setColor(Color.parseColor("#99333333"));
        this.f36367c.setAntiAlias(true);
        this.f36367c.setStrokeWidth(0.0f);
        this.f36368w = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f36368w;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f36367c);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f36368w.right == getMeasuredWidth() && this.f36368w.bottom == getMeasuredHeight()) {
            return;
        }
        this.f36368w.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
