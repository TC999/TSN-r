package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a */
    private float f7075a;

    /* renamed from: a1 */
    private float f7076a1;

    /* renamed from: b */
    private float f7077b;

    /* renamed from: b1 */
    private float f7078b1;

    /* renamed from: g */
    private float f7079g;

    /* renamed from: g1 */
    private float f7080g1;

    /* renamed from: r */
    private float f7081r;

    /* renamed from: r1 */
    private float f7082r1;
    @JBindingExclude
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};
    @JBindingExclude
    private Random random = new Random();

    @JBindingExclude
    public RandomColorBetWeenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f7081r = f / 255.0f;
        this.f7079g = f2 / 255.0f;
        this.f7077b = f3 / 255.0f;
        this.f7075a = f4 / 255.0f;
        this.f7082r1 = f5 / 255.0f;
        this.f7080g1 = f6 / 255.0f;
        this.f7078b1 = f7 / 255.0f;
        this.f7076a1 = f8 / 255.0f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f = this.f7082r1;
        float f2 = this.f7081r;
        fArr[0] = (nextFloat * (f - f2)) + f2;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f3 = this.f7080g1;
        float f4 = this.f7079g;
        fArr2[1] = (nextFloat2 * (f3 - f4)) + f4;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f5 = this.f7078b1;
        float f6 = this.f7077b;
        fArr3[2] = (nextFloat3 * (f5 - f6)) + f6;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f7 = this.f7076a1;
        float f8 = this.f7075a;
        fArr4[3] = (nextFloat4 * (f7 - f8)) + f8;
        return this.color;
    }
}
