package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.interfaces.IProjection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Projection {
    private final IProjection projectionDelegate;

    public Projection(IProjection iProjection) {
        this.projectionDelegate = iProjection;
    }

    public float calZoomByTargetPos(LatLng latLng, int i4) {
        try {
            return this.projectionDelegate.calculateMapZoomer(latLng, i4);
        } catch (Throwable th) {
            th.printStackTrace();
            return 3.0f;
        }
    }

    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i4, int i5) {
        try {
            return this.projectionDelegate.fromBoundsToTile(latLngBounds, i4, i5);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.projectionDelegate.fromScreenLocation(point);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public AMapCameraInfo getCameraInfo() {
        try {
            return this.projectionDelegate.getCameraInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLngBounds getMapBounds(LatLng latLng, float f4) {
        try {
            return this.projectionDelegate.getMapBounds(latLng, f4);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.projectionDelegate.getVisibleRegion();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public PointF toOpenGLLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float toOpenGLWidth(int i4) {
        try {
            return this.projectionDelegate.toMapLenWithWin(i4);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toScreenLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
