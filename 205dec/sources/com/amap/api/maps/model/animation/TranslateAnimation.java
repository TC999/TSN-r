package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TranslateAnimation extends Animation {
    @JBindingInclude

    /* renamed from: x  reason: collision with root package name */
    private double f10767x;
    @JBindingInclude

    /* renamed from: y  reason: collision with root package name */
    private double f10768y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f10767x = latLng.latitude;
        this.f10768y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "TranslateAnimation";
    }
}
