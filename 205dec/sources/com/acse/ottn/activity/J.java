package com.acse.ottn.activity;

import android.animation.ValueAnimator;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class J implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SeedingLoadingActivity f4669a;

    J(SeedingLoadingActivity seedingLoadingActivity) {
        this.f4669a = seedingLoadingActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        SeedingLoadingActivity.e(this.f4669a).setText(SeedingLoadingActivity.c(this.f4669a)[((Integer) valueAnimator.getAnimatedValue()).intValue() % SeedingLoadingActivity.c(this.f4669a).length]);
    }
}
