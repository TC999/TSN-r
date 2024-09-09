package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BouncyConversion {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ boolean f37025e = false;

    /* renamed from: a  reason: collision with root package name */
    private final double f37026a;

    /* renamed from: b  reason: collision with root package name */
    private final double f37027b;

    /* renamed from: c  reason: collision with root package name */
    private final double f37028c;

    /* renamed from: d  reason: collision with root package name */
    private final double f37029d;

    public BouncyConversion(double d4, double d5) {
        this.f37028c = d4;
        this.f37029d = d5;
        double k4 = k(j(d5 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double k5 = k(j(d4 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f37026a = k5;
        this.f37027b = l(k4, d(k5), 0.01d);
    }

    private double a(double d4) {
        return ((Math.pow(d4, 3.0d) * 7.0E-4d) - (Math.pow(d4, 2.0d) * 0.031d)) + (d4 * 0.64d) + 1.28d;
    }

    private double b(double d4) {
        return ((Math.pow(d4, 3.0d) * 4.4E-5d) - (Math.pow(d4, 2.0d) * 0.006d)) + (d4 * 0.36d) + 2.0d;
    }

    private double c(double d4) {
        return ((Math.pow(d4, 3.0d) * 4.5E-7d) - (Math.pow(d4, 2.0d) * 3.32E-4d)) + (d4 * 0.1078d) + 5.84d;
    }

    private double d(double d4) {
        if (d4 <= 18.0d) {
            return a(d4);
        }
        if (d4 <= 18.0d || d4 > 44.0d) {
            if (d4 > 44.0d) {
                return c(d4);
            }
            return 0.0d;
        }
        return b(d4);
    }

    private double i(double d4, double d5, double d6) {
        return (d6 * d4) + ((1.0d - d4) * d5);
    }

    private double j(double d4, double d5, double d6) {
        return (d4 - d5) / (d6 - d5);
    }

    private double k(double d4, double d5, double d6) {
        return d5 + (d4 * (d6 - d5));
    }

    private double l(double d4, double d5, double d6) {
        return i((2.0d * d4) - (d4 * d4), d5, d6);
    }

    public double e() {
        return this.f37029d;
    }

    public double f() {
        return this.f37027b;
    }

    public double g() {
        return this.f37026a;
    }

    public double h() {
        return this.f37028c;
    }
}
