package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrigamiValueConverter {
    /* renamed from: a */
    public static double m35606a(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 25.0d + ((d - 8.0d) * 3.0d);
    }

    /* renamed from: b */
    public static double m35605b(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 8.0d + ((d - 25.0d) / 3.0d);
    }

    /* renamed from: c */
    public static double m35604c(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 30.0d + ((d - 194.0d) / 3.62d);
    }

    /* renamed from: d */
    public static double m35603d(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 194.0d + ((d - 30.0d) * 3.62d);
    }
}
