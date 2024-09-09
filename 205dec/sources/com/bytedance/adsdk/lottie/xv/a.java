package com.bytedance.adsdk.lottie.xv;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f25751a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f25752b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f25753c;

    public a() {
        this.f25751a = new PointF();
        this.f25752b = new PointF();
        this.f25753c = new PointF();
    }

    public PointF a() {
        return this.f25751a;
    }

    public void b(float f4, float f5) {
        this.f25751a.set(f4, f5);
    }

    public PointF c() {
        return this.f25752b;
    }

    public void d(float f4, float f5) {
        this.f25752b.set(f4, f5);
    }

    public PointF e() {
        return this.f25753c;
    }

    public void f(float f4, float f5) {
        this.f25753c.set(f4, f5);
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f25753c.x), Float.valueOf(this.f25753c.y), Float.valueOf(this.f25751a.x), Float.valueOf(this.f25751a.y), Float.valueOf(this.f25752b.x), Float.valueOf(this.f25752b.y));
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f25751a = pointF;
        this.f25752b = pointF2;
        this.f25753c = pointF3;
    }
}
