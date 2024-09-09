package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f4, float f5, float f6, boolean z3) {
        this.point_3 = r0;
        float[] fArr = {f4, f5, f6};
        this.isUseRatio = z3;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float f4, float f5, float f6) {
        this(f4, f5, f6, false);
    }
}
