package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MapProjection {
    public static void geo2LonLat(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.f7977x = pixelsToLatLong.f7977x;
        dPoint.f7978y = pixelsToLatLong.f7978y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d, double d2, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }
}
