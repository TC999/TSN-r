package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import com.autonavi.util.C2477a;
import com.github.mikephil.charting.utils.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OffsetUtil.java */
/* renamed from: com.autonavi.aps.amapapi.utils.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2429e {

    /* renamed from: a */
    static double f8387a = 3.141592653589793d;

    /* renamed from: b */
    private static final List<DPoint> f8388b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    /* renamed from: a */
    public static DPoint m51278a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return m51273b(dPoint);
    }

    /* renamed from: b */
    private static DPoint m51273b(DPoint dPoint) {
        try {
            if (C2428b.m51309a(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] m51135a = C2477a.m51135a(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(m51135a[1], m51135a[0]);
            }
            return dPoint;
        } catch (Throwable th) {
            C2428b.m51299a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    /* renamed from: c */
    private static DPoint m51271c(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d5 = (int) ((-m51280a(d3, d4)) + d3);
        double d6 = (int) ((-m51275b(d3, d4)) + d4);
        Double.isNaN(d3);
        double d7 = (-m51280a(d5, d6)) + d3;
        double d8 = d3 > Utils.DOUBLE_EPSILON ? 1 : -1;
        Double.isNaN(d8);
        double d9 = (int) (d7 + d8);
        Double.isNaN(d4);
        double d10 = (-m51275b(d9, d6)) + d4;
        double d11 = d4 <= Utils.DOUBLE_EPSILON ? -1 : 1;
        Double.isNaN(d11);
        Double.isNaN(d9);
        double d12 = (int) (d10 + d11);
        Double.isNaN(d12);
        return new DPoint(d12 / 100000.0d, d9 / 100000.0d);
    }

    /* renamed from: d */
    private static DPoint m51269d(double d, double d2) {
        DPoint dPoint = new DPoint();
        double d3 = (d * d) + (d2 * d2);
        dPoint.setLongitude(m51272c((Math.cos(m51276b(d) + Math.atan2(d2, d)) * (m51281a(d2) + Math.sqrt(d3))) + 0.0065d));
        dPoint.setLatitude(m51272c((Math.sin(m51276b(d) + Math.atan2(d2, d)) * (m51281a(d2) + Math.sqrt(d3))) + 0.006d));
        return dPoint;
    }

    /* renamed from: e */
    private static boolean m51268e(double d, double d2) {
        return C2428b.m51301a(new DPoint(d, d2), f8388b);
    }

    /* renamed from: f */
    private static DPoint m51267f(double d, double d2) {
        DPoint m51266g = m51266g(d, d2);
        return new DPoint((d * 2.0d) - m51266g.getLatitude(), (d2 * 2.0d) - m51266g.getLongitude());
    }

    /* renamed from: g */
    private static DPoint m51266g(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double m51265h = m51265h(d3, d4);
        double m51264i = m51264i(d3, d4);
        double d5 = (d / 180.0d) * f8387a;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new DPoint(d + ((m51265h * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * f8387a)), d2 + ((m51264i * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * f8387a)));
    }

    /* renamed from: h */
    private static double m51265h(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f8387a) * 20.0d) + (Math.sin(d3 * f8387a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f8387a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f8387a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f8387a) * 160.0d) + (Math.sin((d2 * f8387a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: i */
    private static double m51264i(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f8387a) * 20.0d) + (Math.sin((d * 2.0d) * f8387a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f8387a * d) * 20.0d) + (Math.sin((d / 3.0d) * f8387a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f8387a) * 150.0d) + (Math.sin((d / 30.0d) * f8387a) * 300.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: a */
    private static double m51280a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: a */
    public static DPoint m51277a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (C2428b.m51309a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return m51270c(dPoint);
                }
                if (m51268e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    DPoint m51270c = m51270c(dPoint);
                    return m51267f(m51270c.getLatitude(), m51270c.getLongitude());
                }
                return dPoint;
            } catch (Throwable th) {
                C2428b.m51299a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    /* renamed from: b */
    public static DPoint m51274b(Context context, DPoint dPoint) {
        try {
            return !C2428b.m51309a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : m51278a(context, m51271c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            C2428b.m51299a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    /* renamed from: a */
    private static double m51281a(double d) {
        return Math.sin(d * 3000.0d * (f8387a / 180.0d)) * 2.0E-5d;
    }

    /* renamed from: b */
    private static double m51275b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: a */
    private static DPoint m51279a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint m51269d = m51269d(d5, d6);
        dPoint.setLongitude(m51272c((d + d5) - m51269d.getLongitude()));
        dPoint.setLatitude(m51272c((d2 + d6) - m51269d.getLatitude()));
        return dPoint;
    }

    /* renamed from: b */
    private static double m51276b(double d) {
        return Math.cos(d * 3000.0d * (f8387a / 180.0d)) * 3.0E-6d;
    }

    /* renamed from: c */
    private static double m51272c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    /* renamed from: c */
    private static DPoint m51270c(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint2 = m51279a(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}
