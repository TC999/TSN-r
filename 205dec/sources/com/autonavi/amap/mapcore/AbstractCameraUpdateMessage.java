package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.col.p0003l.a3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapEngine;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public AMap.CancelableCallback mCallback;
    public IMapConfig mapConfig;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public Type nowType = Type.none;
    public Point focus = null;
    public float zoom = Float.NaN;
    public float tilt = Float.NaN;
    public float bearing = Float.NaN;
    public boolean isUseAnchor = false;
    public long mDuration = 250;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public float curZoolScale = 0.0f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    protected void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    public void generateMapAnimation(IGLMapEngine iGLMapEngine) {
        int engineIDWithType = ((GLMapEngine) iGLMapEngine).getEngineIDWithType(1);
        IGLMapState newMapState = iGLMapEngine.getNewMapState(engineIDWithType);
        runCameraUpdate(newMapState);
        DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(engineIDWithType, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.f11671x, (int) mapGeoCenter.f11672y, this.mCallback);
        newMapState.recycle();
    }

    protected Point getAnchorGeoPoint(IGLMapState iGLMapState, int i4, int i5) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i4, i5, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    public void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float h4 = a3.h(this.mapConfig, this.zoom);
        this.zoom = h4;
        this.tilt = a3.i(this.mapConfig, this.tilt, h4);
        double d4 = this.bearing;
        Double.isNaN(d4);
        this.bearing = (float) (((d4 % 360.0d) + 360.0d) % 360.0d);
        Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, point.x, point.y);
            this.geoPoint = new DPoint(anchorGeoPoint.x, anchorGeoPoint.y);
        }
        if (!Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, point2.x, point2.y);
            return;
        }
        DPoint dPoint = this.geoPoint;
        if ((dPoint == null || (dPoint.f11671x == 0.0d && dPoint.f11672y == 0.0d)) ? false : true) {
            iGLMapState.setMapGeoCenter(dPoint.f11671x, dPoint.f11672y);
        }
    }

    public abstract void runCameraUpdate(IGLMapState iGLMapState);

    protected void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i4, int i5) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i4, i5);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        double d4 = mapGeoCenter.f11671x + dPoint.f11671x;
        double d5 = anchorGeoPoint.x;
        Double.isNaN(d5);
        double d6 = anchorGeoPoint.y;
        Double.isNaN(d6);
        iGLMapState.setMapGeoCenter(d4 - d5, (mapGeoCenter.f11672y + dPoint.f11672y) - d6);
    }
}
