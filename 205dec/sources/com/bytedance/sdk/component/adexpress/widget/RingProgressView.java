package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RingProgressView extends View {

    /* renamed from: c  reason: collision with root package name */
    private Context f29583c;

    /* renamed from: f  reason: collision with root package name */
    private int f29584f;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29585r;
    private float sr;
    private ValueAnimator ux;

    /* renamed from: w  reason: collision with root package name */
    private Paint f29586w;
    private RectF xv;

    public RingProgressView(Context context) {
        super(context);
        this.f29584f = 1500;
        this.f29583c = context;
        Paint paint = new Paint();
        this.f29586w = paint;
        paint.setAntiAlias(true);
        this.f29586w.setStyle(Paint.Style.STROKE);
        this.f29586w.setStrokeWidth(10.0f);
        this.f29586w.setColor(Color.parseColor("#80FFFFFF"));
        this.xv = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f29585r) {
            return;
        }
        canvas.drawArc(this.xv, 270.0f, this.sr, false, this.f29586w);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.xv.set(5.0f, 5.0f, i4 - 5, i5 - 5);
    }

    public void setDuration(int i4) {
        this.f29584f = i4;
    }

    public void w() {
        ValueAnimator valueAnimator = this.ux;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void xv() {
        this.f29585r = true;
        invalidate();
    }

    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ux = ofFloat;
        ofFloat.setDuration(this.f29584f);
        this.ux.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.sr = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.ux.start();
    }
}
