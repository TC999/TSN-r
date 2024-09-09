package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLMapState implements IGLMapState {
    private int engineID;
    private boolean isNewInstance;
    private long nativeEngineInstance;
    private long nativeStateInstance;

    public GLMapState(int i4, long j4) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j4 != 0) {
            this.engineID = i4;
            this.nativeEngineInstance = j4;
            this.nativeStateInstance = nativeNewInstance(i4, j4);
            this.isNewInstance = true;
        }
    }

    public static void geo2LonLat(long j4, long j5, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(j4, j5, 20);
        dPoint.f11671x = pixelsToLatLong.f11671x;
        dPoint.f11672y = pixelsToLatLong.f11672y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d4, double d5, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d5, d4, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    public static native float nativeCalMapZoomScalefactor(long j4, int i4, int i5, float f4);

    public static native float nativeCalculateMapZoomer(long j4, int i4, int i5, int i6, int i7, int i8);

    public static native float nativeGetCameraDegree(long j4);

    public static native float nativeGetGLUnitWithWin(long j4, int i4);

    public static native float nativeGetMapAngle(long j4);

    public static native void nativeGetMapCenter(long j4, Point point);

    public static native double nativeGetMapCenterXDouble(long j4);

    public static native double nativeGetMapCenterYDouble(long j4);

    public static native float nativeGetMapZoomer(long j4);

    public static native void nativeGetPixel20Bound(long j4, Rect rect, int i4, int i5);

    public static native void nativeGetProjectionMatrix(long j4, float[] fArr);

    public static native float nativeGetSkyHeight(long j4);

    public static native void nativeGetViewMatrix(long j4, float[] fArr);

    public static native long nativeNewInstance(int i4, long j4);

    public static native void nativeP20ToScreenPoint(long j4, int i4, int i5, int i6, PointF pointF);

    public static native void nativeRecalculate(long j4);

    public static native void nativeScreenToP20Point(long j4, float f4, float f5, Point point);

    public static native void nativeSetCameraDegree(long j4, float f4);

    public static native void nativeSetMapAngle(long j4, float f4);

    public static native void nativeSetMapCenter(long j4, double d4, double d5);

    private static native void nativeSetMapState(int i4, long j4, long j5);

    public static native void nativeSetMapZoomer(long j4, float f4);

    public static native void nativeStateDestroy(long j4, long j5);

    public float calMapZoomScalefactor(int i4, int i5, int i6) {
        return nativeCalMapZoomScalefactor(this.nativeStateInstance, i4, i5, i6);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float calculateMapZoomer(int i4, int i5, int i6, int i7, int i8) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeCalculateMapZoomer(j4, i4, i5, i6, i7, i8);
        }
        return 3.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getCameraDegree() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeGetCameraDegree(j4);
        }
        return 0.0f;
    }

    public float getGLUnitWithWin(int i4) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeGetGLUnitWithWin(j4, i4);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapAngle() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeGetMapAngle(j4);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void getMapGeoCenter(IPoint iPoint) {
        nativeGetMapCenter(this.nativeStateInstance, iPoint);
    }

    public double getMapGeoCenterX() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public double getMapGeoCenterY() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public float getMapLenWithWin(int i4) {
        return getGLUnitWithWin(i4);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapZoomer() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeGetMapZoomer(j4);
        }
        return 0.0f;
    }

    public long getNativeInstance() {
        return this.nativeStateInstance;
    }

    public void getPixel20Bound(Rect rect, int i4, int i5) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeGetPixel20Bound(j4, rect, i4, i5);
        }
    }

    public void getProjectionMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetProjectionMatrix(this.nativeStateInstance, fArr);
    }

    public float getSkyHeight() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            return nativeGetSkyHeight(j4);
        }
        return 0.0f;
    }

    public void getViewMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetViewMatrix(this.nativeStateInstance, fArr);
    }

    public void p20ToScreenPoint(int i4, int i5, FPoint fPoint) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeP20ToScreenPoint(j4, i4, i5, 0, fPoint);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recalculate() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeRecalculate(j4);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recycle() {
        long j4 = this.nativeStateInstance;
        if (j4 != 0 && this.isNewInstance) {
            nativeStateDestroy(j4, this.nativeEngineInstance);
        }
        this.nativeStateInstance = 0L;
    }

    public void reset() {
        if (this.nativeStateInstance != 0) {
            recycle();
        }
        long j4 = this.nativeEngineInstance;
        if (j4 != 0) {
            this.nativeStateInstance = nativeNewInstance(this.engineID, j4);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void screenToP20Point(int i4, int i5, Point point) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeScreenToP20Point(j4, i4, i5, point);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setCameraDegree(float f4) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeSetCameraDegree(j4, f4);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapAngle(float f4) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeSetMapAngle(j4, f4);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapGeoCenter(double d4, double d5) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeSetMapCenter(j4, d4, d5);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapZoomer(float f4) {
        long j4 = this.nativeStateInstance;
        if (j4 != 0) {
            nativeSetMapZoomer(j4, f4);
        }
    }

    public void setNativeMapengineState(int i4, long j4) {
        if (j4 != 0) {
            long j5 = this.nativeStateInstance;
            if (j5 == 0) {
                return;
            }
            this.nativeEngineInstance = j4;
            nativeSetMapState(i4, j4, j5);
        }
    }

    public String toString() {
        return "instance: " + this.nativeStateInstance + " center: " + getMapGeoCenter().f11671x + " , " + getMapGeoCenter().f11672y + " bearing:" + getCameraDegree() + "  tilt:" + getMapAngle() + "  zoom:" + getMapZoomer() + "  ";
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public DPoint getMapGeoCenter() {
        DPoint dPoint = new DPoint();
        dPoint.f11671x = nativeGetMapCenterXDouble(this.nativeStateInstance);
        dPoint.f11672y = nativeGetMapCenterYDouble(this.nativeStateInstance);
        return dPoint;
    }

    public GLMapState(int i4, long j4, long j5) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j4 != 0) {
            this.engineID = i4;
            this.nativeEngineInstance = j4;
            this.nativeStateInstance = j5;
            this.isNewInstance = true;
        }
    }
}
