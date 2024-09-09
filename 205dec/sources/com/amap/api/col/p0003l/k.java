package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractCameraScrollMessage.java */
/* renamed from: com.amap.api.col.3l.k  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k extends AbstractCameraUpdateMessage {
    private static void a(IGLMapState iGLMapState, int i4, int i5, Point point) {
        iGLMapState.screenToP20Point(i4, i5, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f4 = this.xPixel;
        float f5 = this.yPixel;
        float f6 = (this.width / 2.0f) + f4;
        float f7 = (this.height / 2.0f) + f5;
        Point point = new Point();
        a(iGLMapState, (int) f6, (int) f7, point);
        iGLMapState.setMapGeoCenter(point.x, point.y);
    }
}
