package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IGLMapState {
    float calculateMapZoomer(int i4, int i5, int i6, int i7, int i8);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i4, int i5, Point point);

    void setCameraDegree(float f4);

    void setMapAngle(float f4);

    void setMapGeoCenter(double d4, double d5);

    void setMapZoomer(float f4);
}
