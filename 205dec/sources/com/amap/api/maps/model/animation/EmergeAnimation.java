package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class EmergeAnimation extends Animation {
    public EmergeAnimation(LatLng latLng) {
        this.glAnimation = new GLEmergeAnimation(latLng);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "EmergeAnimation";
    }
}
