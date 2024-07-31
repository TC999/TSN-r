package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.p048ae.gmap.GLMapEngine;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        iGLMapEngine.addGroupAnimation(engineIDWithType, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.f7977x, (int) mapGeoCenter.f7978y, this.mCallback);
        newMapState.recycle();
    }

    protected Point getAnchorGeoPoint(IGLMapState iGLMapState, int i, int i2) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i, i2, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    public void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float m55704h = C1732a3.m55704h(this.mapConfig, this.zoom);
        this.zoom = m55704h;
        this.tilt = C1732a3.m55702i(this.mapConfig, this.tilt, m55704h);
        double d = this.bearing;
        Double.isNaN(d);
        this.bearing = (float) (((d % 360.0d) + 360.0d) % 360.0d);
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
        if ((dPoint == null || (dPoint.f7977x == Utils.DOUBLE_EPSILON && dPoint.f7978y == Utils.DOUBLE_EPSILON)) ? false : true) {
            iGLMapState.setMapGeoCenter(dPoint.f7977x, dPoint.f7978y);
        }
    }

    public abstract void runCameraUpdate(IGLMapState iGLMapState);

    protected void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i, int i2) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i, i2);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        double d = mapGeoCenter.f7977x + dPoint.f7977x;
        double d2 = anchorGeoPoint.x;
        Double.isNaN(d2);
        double d3 = anchorGeoPoint.y;
        Double.isNaN(d3);
        iGLMapState.setMapGeoCenter(d - d2, (mapGeoCenter.f7978y + dPoint.f7978y) - d3);
    }
}
