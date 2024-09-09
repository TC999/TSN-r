package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OffsetUtil.java */
/* renamed from: com.amap.api.col.3l.p  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8573a = false;

    /* renamed from: b  reason: collision with root package name */
    static double f8574b = 3.141592653589793d;

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f8575c = {25.575374d, 120.391111d};

    /* renamed from: d  reason: collision with root package name */
    private static final double[] f8576d = {21.405235d, 121.649046d};

    /* renamed from: e  reason: collision with root package name */
    private static final List<LatLng> f8577e = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: f  reason: collision with root package name */
    public static double f8578f = 6378245.0d;

    /* renamed from: g  reason: collision with root package name */
    public static double f8579g = 0.006693421622965943d;

    private static double a(double d4) {
        return Math.sin(d4 * 3000.0d * (f8574b / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d4, double d5) {
        return (Math.cos(d5 / 100000.0d) * (d4 / 18000.0d)) + (Math.sin(d4 / 100000.0d) * (d5 / 9000.0d));
    }

    public static LatLng c(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (t2.a(latLng.latitude, latLng.longitude)) {
            DPoint f4 = f(DPoint.obtain(latLng.longitude, latLng.latitude), f8573a);
            LatLng latLng2 = new LatLng(f4.f11672y, f4.f11671x, false);
            f4.recycle();
            return latLng2;
        }
        return latLng;
    }

    public static LatLng d(LatLng latLng) {
        if (latLng != null) {
            try {
                if (t2.a(latLng.latitude, latLng.longitude)) {
                    DPoint m4 = m(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(m4.f11672y, m4.f11671x, false);
                    m4.recycle();
                    return latLng2;
                } else if (n(latLng.latitude, latLng.longitude)) {
                    DPoint m5 = m(latLng.longitude, latLng.latitude);
                    return o(m5.f11672y, m5.f11671x);
                } else {
                    return latLng;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static DPoint e(double d4, double d5, double d6, double d7) {
        DPoint obtain = DPoint.obtain();
        double d8 = d4 - d6;
        double d9 = d5 - d7;
        DPoint l4 = l(d8, d9);
        obtain.f11671x = j((d4 + d8) - l4.f11671x);
        obtain.f11672y = j((d5 + d9) - l4.f11672y);
        return obtain;
    }

    private static DPoint f(DPoint dPoint, boolean z3) {
        try {
            if (t2.a(dPoint.f11672y, dPoint.f11671x)) {
                double[] dArr = new double[2];
                if (!z3) {
                    dArr = a.a(dPoint.f11671x, dPoint.f11672y);
                }
                dPoint.recycle();
                return DPoint.obtain(dArr[0], dArr[1]);
            }
            return dPoint;
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    private static double g(double d4) {
        return Math.cos(d4 * 3000.0d * (f8574b / 180.0d)) * 3.0E-6d;
    }

    private static double h(double d4, double d5) {
        return (Math.sin(d5 / 100000.0d) * (d4 / 18000.0d)) + (Math.cos(d4 / 100000.0d) * (d5 / 9000.0d));
    }

    public static LatLng i(Context context, LatLng latLng) {
        try {
            if (t2.a(latLng.latitude, latLng.longitude)) {
                DPoint k4 = k(latLng.longitude, latLng.latitude);
                LatLng c4 = c(context, new LatLng(k4.f11672y, k4.f11671x, false));
                k4.recycle();
                return c4;
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double j(double d4) {
        return new BigDecimal(d4).setScale(8, 4).doubleValue();
    }

    private static DPoint k(double d4, double d5) {
        double d6 = ((long) (d4 * 100000.0d)) % 36000000;
        double d7 = ((long) (d5 * 100000.0d)) % 36000000;
        Double.isNaN(d6);
        Double.isNaN(d7);
        double d8 = (int) ((-b(d6, d7)) + d6);
        double d9 = (int) ((-h(d6, d7)) + d7);
        Double.isNaN(d6);
        double d10 = (-b(d8, d9)) + d6;
        double d11 = d6 > 0.0d ? 1 : -1;
        Double.isNaN(d11);
        double d12 = (int) (d10 + d11);
        Double.isNaN(d7);
        double d13 = (-h(d12, d9)) + d7;
        double d14 = d7 <= 0.0d ? -1 : 1;
        Double.isNaN(d14);
        Double.isNaN(d12);
        double d15 = (int) (d13 + d14);
        Double.isNaN(d15);
        return DPoint.obtain(d12 / 100000.0d, d15 / 100000.0d);
    }

    private static DPoint l(double d4, double d5) {
        DPoint obtain = DPoint.obtain();
        double d6 = (d4 * d4) + (d5 * d5);
        obtain.f11671x = j((Math.cos(g(d4) + Math.atan2(d5, d4)) * (a(d5) + Math.sqrt(d6))) + 0.0065d);
        obtain.f11672y = j((Math.sin(g(d4) + Math.atan2(d5, d4)) * (a(d5) + Math.sqrt(d6))) + 0.006d);
        return obtain;
    }

    private static DPoint m(double d4, double d5) {
        DPoint dPoint = null;
        double d6 = 0.006401062d;
        double d7 = 0.0060424805d;
        for (int i4 = 0; i4 < 2; i4++) {
            dPoint = e(d4, d5, d6, d7);
            d6 = d4 - dPoint.f11671x;
            d7 = d5 - dPoint.f11672y;
        }
        return dPoint;
    }

    private static boolean n(double d4, double d5) {
        return a3.M(new LatLng(d4, d5), f8577e);
    }

    private static LatLng o(double d4, double d5) {
        LatLng p3 = p(d4, d5);
        return new LatLng((d4 * 2.0d) - p3.latitude, (d5 * 2.0d) - p3.longitude);
    }

    private static LatLng p(double d4, double d5) {
        double d6 = d5 - 105.0d;
        double d7 = d4 - 35.0d;
        double q3 = q(d6, d7);
        double r3 = r(d6, d7);
        double d8 = (d4 / 180.0d) * f8574b;
        double sin = Math.sin(d8);
        double d9 = 1.0d - ((f8579g * sin) * sin);
        double sqrt = Math.sqrt(d9);
        double d10 = f8578f;
        return new LatLng(d4 + ((q3 * 180.0d) / ((((1.0d - f8579g) * d10) / (d9 * sqrt)) * f8574b)), d5 + ((r3 * 180.0d) / (((d10 / sqrt) * Math.cos(d8)) * f8574b)));
    }

    private static double q(double d4, double d5) {
        double d6 = d4 * 2.0d;
        return (-100.0d) + d6 + (d5 * 3.0d) + (d5 * 0.2d * d5) + (0.1d * d4 * d5) + (Math.sqrt(Math.abs(d4)) * 0.2d) + ((((Math.sin((d4 * 6.0d) * f8574b) * 20.0d) + (Math.sin(d6 * f8574b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f8574b * d5) * 20.0d) + (Math.sin((d5 / 3.0d) * f8574b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d5 / 12.0d) * f8574b) * 160.0d) + (Math.sin((d5 * f8574b) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double r(double d4, double d5) {
        double d6 = d4 * 0.1d;
        return d4 + 300.0d + (d5 * 2.0d) + (d6 * d4) + (d6 * d5) + (Math.sqrt(Math.abs(d4)) * 0.1d) + ((((Math.sin((6.0d * d4) * f8574b) * 20.0d) + (Math.sin((d4 * 2.0d) * f8574b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f8574b * d4) * 20.0d) + (Math.sin((d4 / 3.0d) * f8574b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d4 / 12.0d) * f8574b) * 150.0d) + (Math.sin((d4 / 30.0d) * f8574b) * 300.0d)) * 2.0d) / 3.0d);
    }
}
