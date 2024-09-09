package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AnimationImageView extends ImageView implements w {

    /* renamed from: c  reason: collision with root package name */
    c f29081c;

    /* renamed from: f  reason: collision with root package name */
    private r f29082f;
    private float sr;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29083w;
    private float xv;

    public AnimationImageView(Context context) {
        super(context);
        this.f29081c = new c();
    }

    public r getBrickNativeValue() {
        return this.f29082f;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getMarqueeValue() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getRippleValue() {
        return this.f29083w;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.w
    public float getShineValue() {
        return this.xv;
    }

    public float getStretchValue() {
        return this.ux;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        r rVar;
        super.onDraw(canvas);
        this.f29081c.c(canvas, this, this);
        if (getRippleValue() == 0.0f || (rVar = this.f29082f) == null || rVar.w() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f29081c.c(this, i4, i5);
    }

    public void setBrickNativeValue(r rVar) {
        this.f29082f = rVar;
    }

    public void setMarqueeValue(float f4) {
        this.sr = f4;
        postInvalidate();
    }

    public void setRippleValue(float f4) {
        this.f29083w = f4;
        postInvalidate();
    }

    public void setShineValue(float f4) {
        this.xv = f4;
        postInvalidate();
    }

    public void setStretchValue(float f4) {
        this.ux = f4;
        this.f29081c.c(this, f4);
    }
}
