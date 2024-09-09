package com.amap.api.col.p0003l;

import com.amap.api.maps.model.LatLng;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SegmentsIntersect.java */
/* renamed from: com.amap.api.col.3l.v2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v2 {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d4 = latLng.latitude;
        double d5 = d4 - latLng3.latitude;
        double d6 = latLng.longitude;
        return ((d6 - latLng3.longitude) * (d4 - latLng2.latitude)) - ((d6 - latLng2.longitude) * d5);
    }

    public static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a4 = a(latLng3, latLng4, latLng);
        double a5 = a(latLng3, latLng4, latLng2);
        double a6 = a(latLng, latLng2, latLng3);
        double a7 = a(latLng, latLng2, latLng4);
        if (((a4 > 0.0d && a5 < 0.0d) || (a4 < 0.0d && a5 > 0.0d)) && ((a6 > 0.0d && a7 < 0.0d) || (a6 < 0.0d && a7 > 0.0d))) {
            return true;
        }
        if (a4 == 0.0d && c(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a5 == 0.0d && c(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a6 == 0.0d && c(latLng, latLng2, latLng3)) {
            return true;
        }
        return a7 == 0.0d && c(latLng, latLng2, latLng4);
    }

    private static boolean c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d4 = latLng.longitude;
        double d5 = latLng2.longitude;
        double d6 = d4 - d5 > 0.0d ? d4 : d5;
        if (d4 - d5 >= 0.0d) {
            d4 = d5;
        }
        double d7 = latLng.latitude;
        double d8 = latLng2.latitude;
        double d9 = d7 - d8 > 0.0d ? d7 : d8;
        if (d7 - d8 >= 0.0d) {
            d7 = d8;
        }
        double d10 = latLng3.longitude;
        if (d4 > d10 || d10 > d6) {
            return false;
        }
        double d11 = latLng3.latitude;
        return d7 <= d11 && d11 <= d9;
    }
}
