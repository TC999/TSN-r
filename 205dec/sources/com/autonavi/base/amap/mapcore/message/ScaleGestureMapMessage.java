package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    public ScaleGestureMapMessage(int i4, float f4, int i5, int i6) {
        super(i4);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(i4, f4, i5, i6);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i4, float f4, int i5, int i6) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i4, f4, i5, i6);
        }
        acquire.reset();
        acquire.setParams(i4, f4, i5, i6);
        return acquire;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i4, float f4, int i5, int i6) {
        setState(i4);
        this.scaleDelta = f4;
        this.pivotX = i5;
        this.pivotY = i6;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i4 = this.pivotX;
        int i5 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i4 = this.width >> 1;
            i5 = this.height >> 1;
        }
        IPoint iPoint = null;
        if (i4 > 0 || i5 > 0) {
            iPoint = IPoint.obtain();
            obtain = IPoint.obtain();
            win2geo(gLMapState, i4, i5, iPoint);
            gLMapState.setMapGeoCenter(((Point) iPoint).x, ((Point) iPoint).y);
        } else {
            obtain = null;
        }
        setMapZoomer(gLMapState);
        if (i4 > 0 || i5 > 0) {
            win2geo(gLMapState, i4, i5, obtain);
            if (iPoint != null) {
                gLMapState.setMapGeoCenter((((Point) iPoint).x * 2) - ((Point) obtain).x, (((Point) iPoint).y * 2) - ((Point) obtain).y);
            }
            gLMapState.recalculate();
        }
        if (iPoint != null) {
            iPoint.recycle();
        }
        if (obtain != null) {
            obtain.recycle();
        }
    }
}
