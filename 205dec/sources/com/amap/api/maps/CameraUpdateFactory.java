package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.col.p0003l.m;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f4) {
        return new CameraUpdate(m.q(f4 % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f4, IPoint iPoint) {
        if (iPoint == null) {
            Log.w("CameraUpdateFactory", "geoPoint is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.n(f4 % 360.0f, new Point(((Point) iPoint).x, ((Point) iPoint).y)));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "target is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.e(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeTilt(float f4) {
        return new CameraUpdate(m.p(f4));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            Log.w("CameraUpdateFactory", "cameraPosition is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.f(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "latLng is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.g(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.i(latLngBounds, i4));
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i4, int i5, int i6, int i7) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.k(latLngBounds, i4, i5, i6, i7));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f4) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "target is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.h(latLng, f4));
    }

    public static CameraUpdate scrollBy(float f4, float f5) {
        return new CameraUpdate(m.c(f4, f5));
    }

    public static CameraUpdate zoomBy(float f4) {
        return new CameraUpdate(m.m(f4));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(m.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(m.l());
    }

    public static CameraUpdate zoomTo(float f4) {
        return new CameraUpdate(m.b(f4));
    }

    public static CameraUpdate zoomBy(float f4, Point point) {
        return new CameraUpdate(m.d(f4, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4, int i5, int i6) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(m.o());
        }
        return new CameraUpdate(m.j(latLngBounds, i4, i5, i6));
    }
}
