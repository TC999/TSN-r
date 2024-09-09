package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i4);

    void setInfoWindowBackEnable(boolean z3);

    void setInfoWindowBackScale(float f4, float f5);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
