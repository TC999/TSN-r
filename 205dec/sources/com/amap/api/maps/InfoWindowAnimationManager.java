package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class InfoWindowAnimationManager {

    /* renamed from: a  reason: collision with root package name */
    IInfoWindowManager f10719a;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f10719a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f10719a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f10719a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i4) {
        this.f10719a.setInfoWindowBackColor(i4);
    }

    public void setInfoWindowBackEnable(boolean z3) {
        this.f10719a.setInfoWindowBackEnable(z3);
    }

    public void setInfoWindowBackScale(float f4, float f5) {
        this.f10719a.setInfoWindowBackScale(f4, f5);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f10719a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f10719a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f10719a.startAnimation();
    }
}
