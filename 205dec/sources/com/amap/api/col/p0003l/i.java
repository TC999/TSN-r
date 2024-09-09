package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractCameraBoundsMessage.java */
/* renamed from: com.amap.api.col.3l.i  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> q3 = a3.q(this, this.mapConfig);
        if (q3 == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) q3.first).floatValue());
        Object obj = q3.second;
        iGLMapState.setMapGeoCenter(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
