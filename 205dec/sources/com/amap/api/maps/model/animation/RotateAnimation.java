package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RotateAnimation extends Animation {
    @JBindingInclude
    private float mFromDegrees;
    @JBindingInclude
    private float mToDegrees;

    public RotateAnimation(float f4, float f5, float f6, float f7, float f8) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f4, f5, f6, f7, f8);
        this.mFromDegrees = f4;
        this.mToDegrees = f5;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "RotateAnimation";
    }

    public RotateAnimation(float f4, float f5) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f4, f5, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f4;
        this.mToDegrees = f5;
    }
}
