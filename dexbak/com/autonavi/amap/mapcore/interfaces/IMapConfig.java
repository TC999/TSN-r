package com.autonavi.amap.mapcore.interfaces;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z);

    void setAbroadState(int i);

    void setTerrainEnable(boolean z);
}
