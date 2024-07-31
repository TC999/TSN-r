package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.col.p0463l.CameraUpdateFactoryDelegate;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54538q(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint == null) {
            Log.w(CLASSNAME, "geoPoint is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54541n(f % 360.0f, new Point(((Point) iPoint).x, ((Point) iPoint).y)));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w(CLASSNAME, "target is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54550e(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54539p(f));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            Log.w(CLASSNAME, "cameraPosition is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54549f(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w(CLASSNAME, "latLng is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54548g(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54546i(latLngBounds, i));
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54544k(latLngBounds, i, i2, i3, i4));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng == null) {
            Log.w(CLASSNAME, "target is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54547h(latLng, f));
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54552c(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54542m(f));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54554a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54543l());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54553b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54551d(f, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.m54540o());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.m54545j(latLngBounds, i, i2, i3));
    }
}
