package com.amap.api.col.p0463l;

import com.amap.api.maps.model.LatLng;
import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.amap.api.col.3l.v2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SegmentsIntersect {
    /* renamed from: a */
    private static double m53665a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = d - latLng3.latitude;
        double d3 = latLng.longitude;
        return ((d3 - latLng3.longitude) * (d - latLng2.latitude)) - ((d3 - latLng2.longitude) * d2);
    }

    /* renamed from: b */
    public static boolean m53664b(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double m53665a = m53665a(latLng3, latLng4, latLng);
        double m53665a2 = m53665a(latLng3, latLng4, latLng2);
        double m53665a3 = m53665a(latLng, latLng2, latLng3);
        double m53665a4 = m53665a(latLng, latLng2, latLng4);
        if (((m53665a > Utils.DOUBLE_EPSILON && m53665a2 < Utils.DOUBLE_EPSILON) || (m53665a < Utils.DOUBLE_EPSILON && m53665a2 > Utils.DOUBLE_EPSILON)) && ((m53665a3 > Utils.DOUBLE_EPSILON && m53665a4 < Utils.DOUBLE_EPSILON) || (m53665a3 < Utils.DOUBLE_EPSILON && m53665a4 > Utils.DOUBLE_EPSILON))) {
            return true;
        }
        if (m53665a == Utils.DOUBLE_EPSILON && m53663c(latLng3, latLng4, latLng)) {
            return true;
        }
        if (m53665a2 == Utils.DOUBLE_EPSILON && m53663c(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (m53665a3 == Utils.DOUBLE_EPSILON && m53663c(latLng, latLng2, latLng3)) {
            return true;
        }
        return m53665a4 == Utils.DOUBLE_EPSILON && m53663c(latLng, latLng2, latLng4);
    }

    /* renamed from: c */
    private static boolean m53663c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        double d3 = d - d2 > Utils.DOUBLE_EPSILON ? d : d2;
        if (d - d2 >= Utils.DOUBLE_EPSILON) {
            d = d2;
        }
        double d4 = latLng.latitude;
        double d5 = latLng2.latitude;
        double d6 = d4 - d5 > Utils.DOUBLE_EPSILON ? d4 : d5;
        if (d4 - d5 >= Utils.DOUBLE_EPSILON) {
            d4 = d5;
        }
        double d7 = latLng3.longitude;
        if (d > d7 || d7 > d3) {
            return false;
        }
        double d8 = latLng3.latitude;
        return d4 <= d8 && d8 <= d6;
    }
}
