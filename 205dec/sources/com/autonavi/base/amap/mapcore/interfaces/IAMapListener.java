package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i4, GLMapState gLMapState);

    void afterDrawLabel(int i4, GLMapState gLMapState);

    void afterRendererOver(int i4, GLMapState gLMapState);

    void beforeDrawLabel(int i4, GLMapState gLMapState);

    void onMapBlankClick(double d4, double d5);

    void onMapPOIClick(MapPoi mapPoi);
}
