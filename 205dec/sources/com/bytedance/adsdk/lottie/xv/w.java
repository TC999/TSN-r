package com.bytedance.adsdk.lottie.xv;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public String f25789a;

    /* renamed from: b  reason: collision with root package name */
    public String f25790b;

    /* renamed from: c  reason: collision with root package name */
    public float f25791c;

    /* renamed from: d  reason: collision with root package name */
    public c f25792d;

    /* renamed from: e  reason: collision with root package name */
    public int f25793e;

    /* renamed from: f  reason: collision with root package name */
    public float f25794f;

    /* renamed from: g  reason: collision with root package name */
    public float f25795g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public int f25796h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public int f25797i;

    /* renamed from: j  reason: collision with root package name */
    public float f25798j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f25799k;

    /* renamed from: l  reason: collision with root package name */
    public PointF f25800l;

    /* renamed from: m  reason: collision with root package name */
    public PointF f25801m;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public w(String str, String str2, float f4, c cVar, int i4, float f5, float f6, @ColorInt int i5, @ColorInt int i6, float f7, boolean z3, PointF pointF, PointF pointF2) {
        a(str, str2, f4, cVar, i4, f5, f6, i5, i6, f7, z3, pointF, pointF2);
    }

    public void a(String str, String str2, float f4, c cVar, int i4, float f5, float f6, @ColorInt int i5, @ColorInt int i6, float f7, boolean z3, PointF pointF, PointF pointF2) {
        this.f25789a = str;
        this.f25790b = str2;
        this.f25791c = f4;
        this.f25792d = cVar;
        this.f25793e = i4;
        this.f25794f = f5;
        this.f25795g = f6;
        this.f25796h = i5;
        this.f25797i = i6;
        this.f25798j = f7;
        this.f25799k = z3;
        this.f25800l = pointF;
        this.f25801m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f25789a.hashCode() * 31) + this.f25790b.hashCode()) * 31) + this.f25791c)) * 31) + this.f25792d.ordinal()) * 31) + this.f25793e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f25794f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f25796h;
    }

    public w() {
    }
}
