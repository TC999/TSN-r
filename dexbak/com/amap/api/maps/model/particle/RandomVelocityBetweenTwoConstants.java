package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    @JBindingExclude
    private Random random = new Random();

    /* renamed from: x1 */
    private float f7083x1;

    /* renamed from: x2 */
    private float f7084x2;

    /* renamed from: y1 */
    private float f7085y1;

    /* renamed from: y2 */
    private float f7086y2;

    /* renamed from: z1 */
    private float f7087z1;

    /* renamed from: z2 */
    private float f7088z2;

    public RandomVelocityBetweenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f7083x1 = f;
        this.f7085y1 = f2;
        this.f7087z1 = f3;
        this.f7084x2 = f4;
        this.f7086y2 = f5;
        this.f7088z2 = f6;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f = this.f7084x2;
        float f2 = this.f7083x1;
        return (nextFloat * (f - f2)) + f2;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f = this.f7086y2;
        float f2 = this.f7085y1;
        return (nextFloat * (f - f2)) + f2;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f = this.f7088z2;
        float f2 = this.f7087z1;
        return (nextFloat * (f - f2)) + f2;
    }
}
