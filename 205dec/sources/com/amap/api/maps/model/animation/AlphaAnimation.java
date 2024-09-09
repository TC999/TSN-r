package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AlphaAnimation extends Animation {
    @JBindingInclude
    private float mFromAlpha;
    @JBindingInclude
    private float mToAlpha;

    public AlphaAnimation(float f4, float f5) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f4, f5);
        this.mFromAlpha = f4;
        this.mToAlpha = f5;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AlphaAnimation";
    }
}
