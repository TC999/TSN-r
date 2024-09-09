package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MapProjection {
    public static void geo2LonLat(int i4, int i5, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i4, i5, 20);
        dPoint.f11671x = pixelsToLatLong.f11671x;
        dPoint.f11672y = pixelsToLatLong.f11672y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d4, double d5, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d5, d4, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }
}
