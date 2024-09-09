package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CameraUpdate {

    /* renamed from: a  reason: collision with root package name */
    AbstractCameraUpdateMessage f10717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.f10717a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.f10717a;
    }
}
