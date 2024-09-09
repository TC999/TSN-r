package com.amap.api.col.p0003l;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractCameraZoomMessage.java */
/* renamed from: com.amap.api.col.3l.l  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float mapZoomer = iGLMapState.getMapZoomer() + this.amount;
        this.zoom = mapZoomer;
        this.zoom = a3.h(this.mapConfig, mapZoomer);
        normalChange(iGLMapState);
    }
}
