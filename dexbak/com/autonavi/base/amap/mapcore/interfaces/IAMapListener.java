package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.p048ae.gmap.GLMapState;
import com.autonavi.base.p048ae.gmap.MapPoi;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i, GLMapState gLMapState);

    void afterDrawLabel(int i, GLMapState gLMapState);

    void afterRendererOver(int i, GLMapState gLMapState);

    void beforeDrawLabel(int i, GLMapState gLMapState);

    void onMapBlankClick(double d, double d2);

    void onMapPOIClick(MapPoi mapPoi);
}
