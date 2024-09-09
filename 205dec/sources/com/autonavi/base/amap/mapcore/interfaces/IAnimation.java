package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAnimation {
    void setAnimation(GLAnimation gLAnimation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
