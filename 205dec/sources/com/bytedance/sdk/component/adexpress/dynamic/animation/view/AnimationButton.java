package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AnimationButton extends TextView implements w {

    /* renamed from: c  reason: collision with root package name */
    c f29079c;
    private float sr;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29080w;
    private float xv;

    public AnimationButton(Context context) {
        super(context);
        this.f29079c = new c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getMarqueeValue() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getRippleValue() {
        return this.f29080w;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getShineValue() {
        return this.xv;
    }

    public float getStretchValue() {
        return this.ux;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f29079c.c(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f29079c.c(this, i4, i5);
    }

    public void setMarqueeValue(float f4) {
        this.sr = f4;
        postInvalidate();
    }

    public void setRippleValue(float f4) {
        this.f29080w = f4;
        postInvalidate();
    }

    public void setShineValue(float f4) {
        this.xv = f4;
        postInvalidate();
    }

    public void setStretchValue(float f4) {
        this.ux = f4;
        this.f29079c.c(this, f4);
    }
}
