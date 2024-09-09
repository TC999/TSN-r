package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a  reason: collision with root package name */
    private float f10772a;

    /* renamed from: a1  reason: collision with root package name */
    private float f10773a1;

    /* renamed from: b  reason: collision with root package name */
    private float f10774b;

    /* renamed from: b1  reason: collision with root package name */
    private float f10775b1;

    /* renamed from: g  reason: collision with root package name */
    private float f10776g;

    /* renamed from: g1  reason: collision with root package name */
    private float f10777g1;

    /* renamed from: r  reason: collision with root package name */
    private float f10778r;

    /* renamed from: r1  reason: collision with root package name */
    private float f10779r1;
    @JBindingExclude
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};
    @JBindingExclude
    private Random random = new Random();

    @JBindingExclude
    public RandomColorBetWeenTwoConstants(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f10778r = f4 / 255.0f;
        this.f10776g = f5 / 255.0f;
        this.f10774b = f6 / 255.0f;
        this.f10772a = f7 / 255.0f;
        this.f10779r1 = f8 / 255.0f;
        this.f10777g1 = f9 / 255.0f;
        this.f10775b1 = f10 / 255.0f;
        this.f10773a1 = f11 / 255.0f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f4 = this.f10779r1;
        float f5 = this.f10778r;
        fArr[0] = (nextFloat * (f4 - f5)) + f5;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f6 = this.f10777g1;
        float f7 = this.f10776g;
        fArr2[1] = (nextFloat2 * (f6 - f7)) + f7;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f8 = this.f10775b1;
        float f9 = this.f10774b;
        fArr3[2] = (nextFloat3 * (f8 - f9)) + f9;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f10 = this.f10773a1;
        float f11 = this.f10772a;
        fArr4[3] = (nextFloat4 * (f10 - f11)) + f11;
        return this.color;
    }
}
