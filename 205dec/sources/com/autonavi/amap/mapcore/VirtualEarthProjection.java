package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d4, double d5, double d6) {
        return Math.min(Math.max(d4, d5), d6);
    }

    private static double degToRad(double d4) {
        return d4 * 0.017453292519943295d;
    }

    public static Point latLongToPixels(int i4, int i5, int i6) {
        double d4 = i5;
        Double.isNaN(d4);
        double d5 = i4;
        Double.isNaN(d5);
        return latLongToPixels(d4 / 3600000.0d, d5 / 3600000.0d, i6);
    }

    public static DPoint latLongToPixelsDouble(double d4, double d5, int i4) {
        DPoint dPoint = new DPoint();
        double sin = Math.sin(degToRad(clip(d4, -85.0511287798d, 85.0511287798d)));
        dPoint.f11671x = ((degToRad(clip(d5, -360.0d, 360.0d)) * 6378137.0d) + 2.0037508E7d) / 0.14929106831550598d;
        dPoint.f11672y = (2.0037508E7d - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d)) / 0.14929106831550598d;
        return dPoint;
    }

    public static DPoint pixelsToLatLong(long j4, long j5, int i4) {
        DPoint obtain = DPoint.obtain();
        double d4 = j4;
        Double.isNaN(d4);
        double d5 = j5;
        Double.isNaN(d5);
        obtain.f11671x = radToDeg(((d4 * 0.14929106831550598d) - 2.0037508E7d) / 6378137.0d);
        double exp = Math.exp(((2.0037508E7d - (d5 * 0.14929106831550598d)) / 6378137.0d) * 2.0d);
        obtain.f11672y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d4) {
        return d4 * 57.29577951308232d;
    }

    public static void latLongToPixels(double d4, double d5, int i4, Point point) {
        double sin = Math.sin(degToRad(clip(d4, -85.0511287798d, 85.0511287798d)));
        point.x = (int) (((degToRad(clip(d5, -360.0d, 360.0d)) * 6378137.0d) + 2.0037508E7d) / 0.14929106831550598d);
        point.y = (int) ((2.0037508E7d - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d)) / 0.14929106831550598d);
    }

    public static DPoint pixelsToLatLong(double d4, double d5, int i4) {
        DPoint obtain = DPoint.obtain();
        obtain.f11671x = radToDeg(((d4 * 0.14929106831550598d) - 2.0037508E7d) / 6378137.0d);
        double exp = Math.exp(((2.0037508E7d - (d5 * 0.14929106831550598d)) / 6378137.0d) * 2.0d);
        obtain.f11672y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static Point latLongToPixels(double d4, double d5, int i4) {
        Point point = new Point();
        latLongToPixels(d4, d5, i4, point);
        return point;
    }
}
