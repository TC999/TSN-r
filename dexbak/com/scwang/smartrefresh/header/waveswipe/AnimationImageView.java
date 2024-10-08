package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AnimationImageView extends ImageView {

    /* renamed from: a */
    private Animation.AnimationListener f33433a;

    public AnimationImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f33433a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f33433a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f33433a = animationListener;
    }
}
