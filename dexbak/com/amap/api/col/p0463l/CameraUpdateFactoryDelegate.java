package com.amap.api.col.p0463l;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* renamed from: com.amap.api.col.3l.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CameraUpdateFactoryDelegate {
    /* renamed from: a */
    public static AbstractCameraUpdateMessage m54554a() {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = 1.0f;
        return abstractCameraZoomMessage;
    }

    /* renamed from: b */
    public static AbstractCameraUpdateMessage m54553b(float f) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.zoom = f;
        return abstractCameraPositionMessage;
    }

    /* renamed from: c */
    public static AbstractCameraUpdateMessage m54552c(float f, float f2) {
        AbstractCameraScrollMessage abstractCameraScrollMessage = new AbstractCameraScrollMessage();
        abstractCameraScrollMessage.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        abstractCameraScrollMessage.xPixel = f;
        abstractCameraScrollMessage.yPixel = f2;
        return abstractCameraScrollMessage;
    }

    /* renamed from: d */
    public static AbstractCameraUpdateMessage m54551d(float f, Point point) {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = f;
        abstractCameraZoomMessage.focus = point;
        return abstractCameraZoomMessage;
    }

    /* renamed from: e */
    public static AbstractCameraUpdateMessage m54550e(Point point) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(point.x, point.y);
        return abstractCameraPositionMessage;
    }

    /* renamed from: f */
    public static AbstractCameraUpdateMessage m54549f(CameraPosition cameraPosition) {
        LatLng latLng;
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            abstractCameraPositionMessage.geoPoint = new DPoint(latLongToPixelsDouble.f7977x, latLongToPixelsDouble.f7978y);
            abstractCameraPositionMessage.zoom = cameraPosition.zoom;
            abstractCameraPositionMessage.bearing = cameraPosition.bearing;
            abstractCameraPositionMessage.tilt = cameraPosition.tilt;
            abstractCameraPositionMessage.cameraPosition = cameraPosition;
        }
        return abstractCameraPositionMessage;
    }

    /* renamed from: g */
    public static AbstractCameraUpdateMessage m54548g(LatLng latLng) {
        return m54549f(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    /* renamed from: h */
    public static AbstractCameraUpdateMessage m54547h(LatLng latLng, float f) {
        return m54549f(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    /* renamed from: i */
    public static AbstractCameraUpdateMessage m54546i(LatLngBounds latLngBounds, int i) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i;
        abstractCameraBoundsMessage.paddingRight = i;
        abstractCameraBoundsMessage.paddingTop = i;
        abstractCameraBoundsMessage.paddingBottom = i;
        return abstractCameraBoundsMessage;
    }

    /* renamed from: j */
    public static AbstractCameraUpdateMessage m54545j(LatLngBounds latLngBounds, int i, int i2, int i3) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i3;
        abstractCameraBoundsMessage.paddingRight = i3;
        abstractCameraBoundsMessage.paddingTop = i3;
        abstractCameraBoundsMessage.paddingBottom = i3;
        abstractCameraBoundsMessage.width = i;
        abstractCameraBoundsMessage.height = i2;
        return abstractCameraBoundsMessage;
    }

    /* renamed from: k */
    public static AbstractCameraUpdateMessage m54544k(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i;
        abstractCameraBoundsMessage.paddingRight = i2;
        abstractCameraBoundsMessage.paddingTop = i3;
        abstractCameraBoundsMessage.paddingBottom = i4;
        return abstractCameraBoundsMessage;
    }

    /* renamed from: l */
    public static AbstractCameraUpdateMessage m54543l() {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = -1.0f;
        return abstractCameraZoomMessage;
    }

    /* renamed from: m */
    public static AbstractCameraUpdateMessage m54542m(float f) {
        return m54551d(f, null);
    }

    /* renamed from: n */
    public static AbstractCameraUpdateMessage m54541n(float f, Point point) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(point.x, point.y);
        abstractCameraPositionMessage.bearing = f;
        return abstractCameraPositionMessage;
    }

    /* renamed from: o */
    public static AbstractCameraUpdateMessage m54540o() {
        return new AbstractCameraPositionMessage();
    }

    /* renamed from: p */
    public static AbstractCameraUpdateMessage m54539p(float f) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.tilt = f;
        return abstractCameraPositionMessage;
    }

    /* renamed from: q */
    public static AbstractCameraUpdateMessage m54538q(float f) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.bearing = f;
        return abstractCameraPositionMessage;
    }
}
