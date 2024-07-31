package com.amap.api.col.p0463l;

import android.graphics.Point;
import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* renamed from: com.amap.api.col.3l.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AbstractCameraBoundsMessage extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> m55693q = C1732a3.m55693q(this, this.mapConfig);
        if (m55693q == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) m55693q.first).floatValue());
        Object obj = m55693q.second;
        iGLMapState.setMapGeoCenter(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
