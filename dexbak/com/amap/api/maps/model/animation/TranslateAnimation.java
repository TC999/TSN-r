package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TranslateAnimation extends Animation {
    @JBindingInclude

    /* renamed from: x */
    private double f7070x;
    @JBindingInclude

    /* renamed from: y */
    private double f7071y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f7070x = latLng.latitude;
        this.f7071y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "TranslateAnimation";
    }
}
