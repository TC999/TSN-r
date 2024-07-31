package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EmergeAnimation extends Animation {
    public EmergeAnimation(LatLng latLng) {
        this.glAnimation = new GLEmergeAnimation(latLng);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "EmergeAnimation";
    }
}
