package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BouncyConversion {

    /* renamed from: e */
    static final /* synthetic */ boolean f23429e = false;

    /* renamed from: a */
    private final double f23430a;

    /* renamed from: b */
    private final double f23431b;

    /* renamed from: c */
    private final double f23432c;

    /* renamed from: d */
    private final double f23433d;

    public BouncyConversion(double d, double d2) {
        this.f23432c = d;
        this.f23433d = d2;
        double m35619k = m35619k(m35620j(d2 / 1.7d, Utils.DOUBLE_EPSILON, 20.0d), Utils.DOUBLE_EPSILON, 0.8d);
        double m35619k2 = m35619k(m35620j(d / 1.7d, Utils.DOUBLE_EPSILON, 20.0d), 0.5d, 200.0d);
        this.f23430a = m35619k2;
        this.f23431b = m35618l(m35619k, m35626d(m35619k2), 0.01d);
    }

    /* renamed from: a */
    private double m35629a(double d) {
        return ((Math.pow(d, 3.0d) * 7.0E-4d) - (Math.pow(d, 2.0d) * 0.031d)) + (d * 0.64d) + 1.28d;
    }

    /* renamed from: b */
    private double m35628b(double d) {
        return ((Math.pow(d, 3.0d) * 4.4E-5d) - (Math.pow(d, 2.0d) * 0.006d)) + (d * 0.36d) + 2.0d;
    }

    /* renamed from: c */
    private double m35627c(double d) {
        return ((Math.pow(d, 3.0d) * 4.5E-7d) - (Math.pow(d, 2.0d) * 3.32E-4d)) + (d * 0.1078d) + 5.84d;
    }

    /* renamed from: d */
    private double m35626d(double d) {
        if (d <= 18.0d) {
            return m35629a(d);
        }
        if (d <= 18.0d || d > 44.0d) {
            return d > 44.0d ? m35627c(d) : Utils.DOUBLE_EPSILON;
        }
        return m35628b(d);
    }

    /* renamed from: i */
    private double m35621i(double d, double d2, double d3) {
        return (d3 * d) + ((1.0d - d) * d2);
    }

    /* renamed from: j */
    private double m35620j(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    /* renamed from: k */
    private double m35619k(double d, double d2, double d3) {
        return d2 + (d * (d3 - d2));
    }

    /* renamed from: l */
    private double m35618l(double d, double d2, double d3) {
        return m35621i((2.0d * d) - (d * d), d2, d3);
    }

    /* renamed from: e */
    public double m35625e() {
        return this.f23433d;
    }

    /* renamed from: f */
    public double m35624f() {
        return this.f23431b;
    }

    /* renamed from: g */
    public double m35623g() {
        return this.f23430a;
    }

    /* renamed from: h */
    public double m35622h() {
        return this.f23432c;
    }
}
