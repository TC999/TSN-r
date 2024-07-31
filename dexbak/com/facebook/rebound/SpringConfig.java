package com.facebook.rebound;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SpringConfig {

    /* renamed from: c */
    public static SpringConfig f23480c = m35562b(40.0d, 7.0d);

    /* renamed from: a */
    public double f23481a;

    /* renamed from: b */
    public double f23482b;

    public SpringConfig(double d, double d2) {
        this.f23482b = d;
        this.f23481a = d2;
    }

    /* renamed from: a */
    public static SpringConfig m35563a(double d, double d2) {
        BouncyConversion bouncyConversion = new BouncyConversion(d2, d);
        return m35562b(bouncyConversion.m35623g(), bouncyConversion.m35624f());
    }

    /* renamed from: b */
    public static SpringConfig m35562b(double d, double d2) {
        return new SpringConfig(OrigamiValueConverter.m35603d(d), OrigamiValueConverter.m35606a(d2));
    }
}
