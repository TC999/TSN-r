package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OffsetUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static double f12025a = 3.141592653589793d;

    /* renamed from: b  reason: collision with root package name */
    private static final List<DPoint> f12026b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    private static DPoint b(DPoint dPoint) {
        try {
            if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] a4 = com.autonavi.util.a.a(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(a4[1], a4[0]);
            }
            return dPoint;
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static DPoint c(double d4, double d5) {
        double d6 = ((long) (d4 * 100000.0d)) % 36000000;
        double d7 = ((long) (d5 * 100000.0d)) % 36000000;
        Double.isNaN(d6);
        Double.isNaN(d7);
        double d8 = (int) ((-a(d6, d7)) + d6);
        double d9 = (int) ((-b(d6, d7)) + d7);
        Double.isNaN(d6);
        double d10 = (-a(d8, d9)) + d6;
        double d11 = d6 > 0.0d ? 1 : -1;
        Double.isNaN(d11);
        double d12 = (int) (d10 + d11);
        Double.isNaN(d7);
        double d13 = (-b(d12, d9)) + d7;
        double d14 = d7 <= 0.0d ? -1 : 1;
        Double.isNaN(d14);
        Double.isNaN(d12);
        double d15 = (int) (d13 + d14);
        Double.isNaN(d15);
        return new DPoint(d15 / 100000.0d, d12 / 100000.0d);
    }

    private static DPoint d(double d4, double d5) {
        DPoint dPoint = new DPoint();
        double d6 = (d4 * d4) + (d5 * d5);
        dPoint.setLongitude(c((Math.cos(b(d4) + Math.atan2(d5, d4)) * (a(d5) + Math.sqrt(d6))) + 0.0065d));
        dPoint.setLatitude(c((Math.sin(b(d4) + Math.atan2(d5, d4)) * (a(d5) + Math.sqrt(d6))) + 0.006d));
        return dPoint;
    }

    private static boolean e(double d4, double d5) {
        return b.a(new DPoint(d4, d5), f12026b);
    }

    private static DPoint f(double d4, double d5) {
        DPoint g4 = g(d4, d5);
        return new DPoint((d4 * 2.0d) - g4.getLatitude(), (d5 * 2.0d) - g4.getLongitude());
    }

    private static DPoint g(double d4, double d5) {
        double d6 = d5 - 105.0d;
        double d7 = d4 - 35.0d;
        double h4 = h(d6, d7);
        double i4 = i(d6, d7);
        double d8 = (d4 / 180.0d) * f12025a;
        double sin = Math.sin(d8);
        double d9 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d9);
        return new DPoint(d4 + ((h4 * 180.0d) / ((6335552.717000426d / (d9 * sqrt)) * f12025a)), d5 + ((i4 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d8)) * f12025a)));
    }

    private static double h(double d4, double d5) {
        double d6 = d4 * 2.0d;
        return (-100.0d) + d6 + (d5 * 3.0d) + (d5 * 0.2d * d5) + (0.1d * d4 * d5) + (Math.sqrt(Math.abs(d4)) * 0.2d) + ((((Math.sin((d4 * 6.0d) * f12025a) * 20.0d) + (Math.sin(d6 * f12025a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f12025a * d5) * 20.0d) + (Math.sin((d5 / 3.0d) * f12025a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d5 / 12.0d) * f12025a) * 160.0d) + (Math.sin((d5 * f12025a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double d4, double d5) {
        double d6 = d4 * 0.1d;
        return d4 + 300.0d + (d5 * 2.0d) + (d6 * d4) + (d6 * d5) + (Math.sqrt(Math.abs(d4)) * 0.1d) + ((((Math.sin((6.0d * d4) * f12025a) * 20.0d) + (Math.sin((d4 * 2.0d) * f12025a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f12025a * d4) * 20.0d) + (Math.sin((d4 / 3.0d) * f12025a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d4 / 12.0d) * f12025a) * 150.0d) + (Math.sin((d4 / 30.0d) * f12025a) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static double a(double d4, double d5) {
        return (Math.cos(d5 / 100000.0d) * (d4 / 18000.0d)) + (Math.sin(d4 / 100000.0d) * (d5 / 9000.0d));
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                if (e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    DPoint c4 = c(dPoint);
                    return f(c4.getLatitude(), c4.getLongitude());
                }
                return dPoint;
            } catch (Throwable th) {
                b.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            return !b.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static double a(double d4) {
        return Math.sin(d4 * 3000.0d * (f12025a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d4, double d5) {
        return (Math.sin(d5 / 100000.0d) * (d4 / 18000.0d)) + (Math.cos(d4 / 100000.0d) * (d5 / 9000.0d));
    }

    private static DPoint a(double d4, double d5, double d6, double d7) {
        DPoint dPoint = new DPoint();
        double d8 = d4 - d6;
        double d9 = d5 - d7;
        DPoint d10 = d(d8, d9);
        dPoint.setLongitude(c((d4 + d8) - d10.getLongitude()));
        dPoint.setLatitude(c((d5 + d9) - d10.getLatitude()));
        return dPoint;
    }

    private static double b(double d4) {
        return Math.cos(d4 * 3000.0d * (f12025a / 180.0d)) * 3.0E-6d;
    }

    private static double c(double d4) {
        return new BigDecimal(d4).setScale(8, 4).doubleValue();
    }

    private static DPoint c(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d4 = 0.006401062d;
        double d5 = 0.0060424805d;
        for (int i4 = 0; i4 < 2; i4++) {
            dPoint2 = a(dPoint.getLongitude(), dPoint.getLatitude(), d4, d5);
            d4 = dPoint.getLongitude() - dPoint2.getLongitude();
            d5 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}
