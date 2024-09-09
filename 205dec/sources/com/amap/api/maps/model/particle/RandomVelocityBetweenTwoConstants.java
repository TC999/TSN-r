package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    @JBindingExclude
    private Random random = new Random();

    /* renamed from: x1  reason: collision with root package name */
    private float f10780x1;

    /* renamed from: x2  reason: collision with root package name */
    private float f10781x2;

    /* renamed from: y1  reason: collision with root package name */
    private float f10782y1;

    /* renamed from: y2  reason: collision with root package name */
    private float f10783y2;

    /* renamed from: z1  reason: collision with root package name */
    private float f10784z1;

    /* renamed from: z2  reason: collision with root package name */
    private float f10785z2;

    public RandomVelocityBetweenTwoConstants(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f10780x1 = f4;
        this.f10782y1 = f5;
        this.f10784z1 = f6;
        this.f10781x2 = f7;
        this.f10783y2 = f8;
        this.f10785z2 = f9;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f4 = this.f10781x2;
        float f5 = this.f10780x1;
        return (nextFloat * (f4 - f5)) + f5;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f4 = this.f10783y2;
        float f5 = this.f10782y1;
        return (nextFloat * (f4 - f5)) + f5;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f4 = this.f10785z2;
        float f5 = this.f10784z1;
        return (nextFloat * (f4 - f5)) + f5;
    }
}
