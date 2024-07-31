package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AnimationSet extends Animation {
    @JBindingInclude
    private List<Animation> mAnimations = new ArrayList();
    @JBindingInclude
    private boolean shareInterpolator;

    public AnimationSet(boolean z) {
        this.shareInterpolator = false;
        this.glAnimation = new GLAnimationSet(z);
        this.shareInterpolator = z;
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
