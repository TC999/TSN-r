package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringConfig {

    /* renamed from: c  reason: collision with root package name */
    public static SpringConfig f37076c = b(40.0d, 7.0d);

    /* renamed from: a  reason: collision with root package name */
    public double f37077a;

    /* renamed from: b  reason: collision with root package name */
    public double f37078b;

    public SpringConfig(double d4, double d5) {
        this.f37078b = d4;
        this.f37077a = d5;
    }

    public static SpringConfig a(double d4, double d5) {
        BouncyConversion bouncyConversion = new BouncyConversion(d5, d4);
        return b(bouncyConversion.g(), bouncyConversion.f());
    }

    public static SpringConfig b(double d4, double d5) {
        return new SpringConfig(OrigamiValueConverter.d(d4), OrigamiValueConverter.a(d5));
    }
}
