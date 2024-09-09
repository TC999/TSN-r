package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x  reason: collision with root package name */
    private float f10769x;

    /* renamed from: y  reason: collision with root package name */
    private float f10770y;

    /* renamed from: z  reason: collision with root package name */
    private float f10771z;

    public CurveSizeOverLife(float f4, float f5, float f6) {
        this.f10769x = f4;
        this.f10770y = f5;
        this.f10771z = f6;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f4) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f4) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f4) {
        return 0.0f;
    }
}
