package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ScaleAnimation extends Animation {
    @JBindingInclude
    private float mFromX;
    @JBindingInclude
    private float mFromY;
    @JBindingInclude
    private float mPivotX;
    @JBindingInclude
    private float mPivotY;
    @JBindingInclude
    private float mToX;
    @JBindingInclude
    private float mToY;

    public ScaleAnimation(float f4, float f5, float f6, float f7) {
        this.glAnimation = new GLScaleAnimation(f4, f5, f6, f7);
        this.mFromX = f4;
        this.mToX = f5;
        this.mFromY = f6;
        this.mToY = f7;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "ScaleAnimation";
    }
}
