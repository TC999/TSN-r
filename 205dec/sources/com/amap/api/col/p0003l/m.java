package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CameraUpdateFactoryDelegate.java */
/* renamed from: com.amap.api.col.3l.m  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m {
    public static AbstractCameraUpdateMessage a() {
        l lVar = new l();
        lVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        lVar.amount = 1.0f;
        return lVar;
    }

    public static AbstractCameraUpdateMessage b(float f4) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        jVar.zoom = f4;
        return jVar;
    }

    public static AbstractCameraUpdateMessage c(float f4, float f5) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        kVar.xPixel = f4;
        kVar.yPixel = f5;
        return kVar;
    }

    public static AbstractCameraUpdateMessage d(float f4, Point point) {
        l lVar = new l();
        lVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        lVar.amount = f4;
        lVar.focus = point;
        return lVar;
    }

    public static AbstractCameraUpdateMessage e(Point point) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        jVar.geoPoint = new DPoint(point.x, point.y);
        return jVar;
    }

    public static AbstractCameraUpdateMessage f(CameraPosition cameraPosition) {
        LatLng latLng;
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            jVar.geoPoint = new DPoint(latLongToPixelsDouble.f11671x, latLongToPixelsDouble.f11672y);
            jVar.zoom = cameraPosition.zoom;
            jVar.bearing = cameraPosition.bearing;
            jVar.tilt = cameraPosition.tilt;
            jVar.cameraPosition = cameraPosition;
        }
        return jVar;
    }

    public static AbstractCameraUpdateMessage g(LatLng latLng) {
        return f(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage h(LatLng latLng, float f4) {
        return f(CameraPosition.builder().target(latLng).zoom(f4).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage i(LatLngBounds latLngBounds, int i4) {
        i iVar = new i();
        iVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        iVar.bounds = latLngBounds;
        iVar.paddingLeft = i4;
        iVar.paddingRight = i4;
        iVar.paddingTop = i4;
        iVar.paddingBottom = i4;
        return iVar;
    }

    public static AbstractCameraUpdateMessage j(LatLngBounds latLngBounds, int i4, int i5, int i6) {
        i iVar = new i();
        iVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        iVar.bounds = latLngBounds;
        iVar.paddingLeft = i6;
        iVar.paddingRight = i6;
        iVar.paddingTop = i6;
        iVar.paddingBottom = i6;
        iVar.width = i4;
        iVar.height = i5;
        return iVar;
    }

    public static AbstractCameraUpdateMessage k(LatLngBounds latLngBounds, int i4, int i5, int i6, int i7) {
        i iVar = new i();
        iVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        iVar.bounds = latLngBounds;
        iVar.paddingLeft = i4;
        iVar.paddingRight = i5;
        iVar.paddingTop = i6;
        iVar.paddingBottom = i7;
        return iVar;
    }

    public static AbstractCameraUpdateMessage l() {
        l lVar = new l();
        lVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        lVar.amount = -1.0f;
        return lVar;
    }

    public static AbstractCameraUpdateMessage m(float f4) {
        return d(f4, null);
    }

    public static AbstractCameraUpdateMessage n(float f4, Point point) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        jVar.geoPoint = new DPoint(point.x, point.y);
        jVar.bearing = f4;
        return jVar;
    }

    public static AbstractCameraUpdateMessage o() {
        return new j();
    }

    public static AbstractCameraUpdateMessage p(float f4) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        jVar.tilt = f4;
        return jVar;
    }

    public static AbstractCameraUpdateMessage q(float f4) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        jVar.bearing = f4;
        return jVar;
    }
}
