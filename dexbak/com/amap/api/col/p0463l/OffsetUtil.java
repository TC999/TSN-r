package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.C2477a;
import com.github.mikephil.charting.utils.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.amap.api.col.3l.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OffsetUtil {

    /* renamed from: a */
    private static boolean f5020a = false;

    /* renamed from: b */
    static double f5021b = 3.141592653589793d;

    /* renamed from: c */
    private static final double[] f5022c = {25.575374d, 120.391111d};

    /* renamed from: d */
    private static final double[] f5023d = {21.405235d, 121.649046d};

    /* renamed from: e */
    private static final List<LatLng> f5024e = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: f */
    public static double f5025f = 6378245.0d;

    /* renamed from: g */
    public static double f5026g = 0.006693421622965943d;

    /* renamed from: a */
    private static double m54274a(double d) {
        return Math.sin(d * 3000.0d * (f5021b / 180.0d)) * 2.0E-5d;
    }

    /* renamed from: b */
    private static double m54273b(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: c */
    public static LatLng m54272c(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (RegionUtil.m53892a(latLng.latitude, latLng.longitude)) {
            DPoint m54269f = m54269f(DPoint.obtain(latLng.longitude, latLng.latitude), f5020a);
            LatLng latLng2 = new LatLng(m54269f.f7978y, m54269f.f7977x, false);
            m54269f.recycle();
            return latLng2;
        }
        return latLng;
    }

    /* renamed from: d */
    public static LatLng m54271d(LatLng latLng) {
        if (latLng != null) {
            try {
                if (RegionUtil.m53892a(latLng.latitude, latLng.longitude)) {
                    DPoint m54262m = m54262m(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(m54262m.f7978y, m54262m.f7977x, false);
                    m54262m.recycle();
                    return latLng2;
                } else if (m54261n(latLng.latitude, latLng.longitude)) {
                    DPoint m54262m2 = m54262m(latLng.longitude, latLng.latitude);
                    return m54260o(m54262m2.f7978y, m54262m2.f7977x);
                } else {
                    return latLng;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    /* renamed from: e */
    private static DPoint m54270e(double d, double d2, double d3, double d4) {
        DPoint obtain = DPoint.obtain();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint m54263l = m54263l(d5, d6);
        obtain.f7977x = m54265j((d + d5) - m54263l.f7977x);
        obtain.f7978y = m54265j((d2 + d6) - m54263l.f7978y);
        return obtain;
    }

    /* renamed from: f */
    private static DPoint m54269f(DPoint dPoint, boolean z) {
        try {
            if (RegionUtil.m53892a(dPoint.f7978y, dPoint.f7977x)) {
                double[] dArr = new double[2];
                if (!z) {
                    dArr = C2477a.m51135a(dPoint.f7977x, dPoint.f7978y);
                }
                dPoint.recycle();
                return DPoint.obtain(dArr[0], dArr[1]);
            }
            return dPoint;
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    /* renamed from: g */
    private static double m54268g(double d) {
        return Math.cos(d * 3000.0d * (f5021b / 180.0d)) * 3.0E-6d;
    }

    /* renamed from: h */
    private static double m54267h(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: i */
    public static LatLng m54266i(Context context, LatLng latLng) {
        try {
            if (RegionUtil.m53892a(latLng.latitude, latLng.longitude)) {
                DPoint m54264k = m54264k(latLng.longitude, latLng.latitude);
                LatLng m54272c = m54272c(context, new LatLng(m54264k.f7978y, m54264k.f7977x, false));
                m54264k.recycle();
                return m54272c;
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    /* renamed from: j */
    private static double m54265j(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    /* renamed from: k */
    private static DPoint m54264k(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d5 = (int) ((-m54273b(d3, d4)) + d3);
        double d6 = (int) ((-m54267h(d3, d4)) + d4);
        Double.isNaN(d3);
        double d7 = (-m54273b(d5, d6)) + d3;
        double d8 = d3 > Utils.DOUBLE_EPSILON ? 1 : -1;
        Double.isNaN(d8);
        double d9 = (int) (d7 + d8);
        Double.isNaN(d4);
        double d10 = (-m54267h(d9, d6)) + d4;
        double d11 = d4 <= Utils.DOUBLE_EPSILON ? -1 : 1;
        Double.isNaN(d11);
        Double.isNaN(d9);
        double d12 = (int) (d10 + d11);
        Double.isNaN(d12);
        return DPoint.obtain(d9 / 100000.0d, d12 / 100000.0d);
    }

    /* renamed from: l */
    private static DPoint m54263l(double d, double d2) {
        DPoint obtain = DPoint.obtain();
        double d3 = (d * d) + (d2 * d2);
        obtain.f7977x = m54265j((Math.cos(m54268g(d) + Math.atan2(d2, d)) * (m54274a(d2) + Math.sqrt(d3))) + 0.0065d);
        obtain.f7978y = m54265j((Math.sin(m54268g(d) + Math.atan2(d2, d)) * (m54274a(d2) + Math.sqrt(d3))) + 0.006d);
        return obtain;
    }

    /* renamed from: m */
    private static DPoint m54262m(double d, double d2) {
        DPoint dPoint = null;
        double d3 = 0.006401062d;
        double d4 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint = m54270e(d, d2, d3, d4);
            d3 = d - dPoint.f7977x;
            d4 = d2 - dPoint.f7978y;
        }
        return dPoint;
    }

    /* renamed from: n */
    private static boolean m54261n(double d, double d2) {
        return C1732a3.m55732M(new LatLng(d, d2), f5024e);
    }

    /* renamed from: o */
    private static LatLng m54260o(double d, double d2) {
        LatLng m54259p = m54259p(d, d2);
        return new LatLng((d * 2.0d) - m54259p.latitude, (d2 * 2.0d) - m54259p.longitude);
    }

    /* renamed from: p */
    private static LatLng m54259p(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double m54258q = m54258q(d3, d4);
        double m54257r = m54257r(d3, d4);
        double d5 = (d / 180.0d) * f5021b;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((f5026g * sin) * sin);
        double sqrt = Math.sqrt(d6);
        double d7 = f5025f;
        return new LatLng(d + ((m54258q * 180.0d) / ((((1.0d - f5026g) * d7) / (d6 * sqrt)) * f5021b)), d2 + ((m54257r * 180.0d) / (((d7 / sqrt) * Math.cos(d5)) * f5021b)));
    }

    /* renamed from: q */
    private static double m54258q(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f5021b) * 20.0d) + (Math.sin(d3 * f5021b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f5021b * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f5021b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f5021b) * 160.0d) + (Math.sin((d2 * f5021b) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: r */
    private static double m54257r(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f5021b) * 20.0d) + (Math.sin((d * 2.0d) * f5021b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f5021b * d) * 20.0d) + (Math.sin((d / 3.0d) * f5021b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f5021b) * 150.0d) + (Math.sin((d / 30.0d) * f5021b) * 300.0d)) * 2.0d) / 3.0d);
    }
}
