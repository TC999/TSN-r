package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x */
    private float f7072x;

    /* renamed from: y */
    private float f7073y;

    /* renamed from: z */
    private float f7074z;

    public CurveSizeOverLife(float f, float f2, float f3) {
        this.f7072x = f;
        this.f7073y = f2;
        this.f7074z = f3;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f) {
        return 0.0f;
    }
}
