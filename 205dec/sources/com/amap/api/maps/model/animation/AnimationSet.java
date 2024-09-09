package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AnimationSet extends Animation {
    @JBindingInclude
    private List<Animation> mAnimations = new ArrayList();
    @JBindingInclude
    private boolean shareInterpolator;

    public AnimationSet(boolean z3) {
        this.shareInterpolator = false;
        this.glAnimation = new GLAnimationSet(z3);
        this.shareInterpolator = z3;
    }

    public void addAnimation(Animation animation) {
        ((GLAnimationSet) this.glAnimation).addAnimation(animation);
        this.mAnimations.add(animation);
    }

    public void cleanAnimation() {
        ((GLAnimationSet) this.glAnimation).cleanAnimation();
        this.mAnimations.clear();
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AnimationSet";
    }
}
