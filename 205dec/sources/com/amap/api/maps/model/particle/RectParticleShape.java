package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;

    /* renamed from: top  reason: collision with root package name */
    private final float f10786top;

    public RectParticleShape(float f4, float f5, float f6, float f7, boolean z3) {
        this.left = f4;
        this.f10786top = f5;
        this.right = f6;
        this.bottom = f7;
        this.isUseRatio = z3;
        this.type = 1;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }
}
