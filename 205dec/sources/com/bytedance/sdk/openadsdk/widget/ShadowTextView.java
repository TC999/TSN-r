package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ShadowTextView extends TextView {

    /* renamed from: c  reason: collision with root package name */
    private Paint f36369c;

    /* renamed from: w  reason: collision with root package name */
    private RectF f36370w;
    private int xv;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void c() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.f36369c = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f36369c.setColor(Color.parseColor("#99333333"));
        this.f36369c.setAntiAlias(true);
        this.f36369c.setStrokeWidth(0.0f);
        this.f36370w = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f36370w;
        float f4 = rectF.bottom;
        canvas.drawRoundRect(rectF, f4 / 2.0f, f4 / 2.0f, this.f36369c);
        canvas.translate((this.f36370w.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.xv = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i6 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i6, measuredHeight);
            this.f36370w.set(0.0f, 0.0f, i6, measuredHeight);
            return;
        }
        this.f36370w.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.xv = 0;
        c();
    }
}
