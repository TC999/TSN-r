package com.amap.api.col.p0463l;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* renamed from: com.amap.api.col.3l.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AbstractCameraScrollMessage extends AbstractCameraUpdateMessage {
    /* renamed from: a */
    private static void m54644a(IGLMapState iGLMapState, int i, int i2, Point point) {
        iGLMapState.screenToP20Point(i, i2, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = (this.width / 2.0f) + f;
        float f4 = (this.height / 2.0f) + f2;
        Point point = new Point();
        m54644a(iGLMapState, (int) f3, (int) f4, point);
        iGLMapState.setMapGeoCenter(point.x, point.y);
    }
}
