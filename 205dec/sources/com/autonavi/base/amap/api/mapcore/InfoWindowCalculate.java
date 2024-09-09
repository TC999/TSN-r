package com.autonavi.base.amap.api.mapcore;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.FPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface InfoWindowCalculate {
    boolean checkInBounds();

    IPoint getAnchor();

    BitmapDescriptor getBitmapDescriptor();

    FPoint getGeoPosition();

    int getHeight();

    int getInfoWindowOffsetX();

    int getInfoWindowOffsetY();

    int getRealInfoWindowOffsetX();

    int getRealInfoWindowOffsetY();

    LatLng getRealPosition();

    Rect getRect();

    IPoint getScreenPosition();

    int getWidth();

    boolean isContains();

    boolean isDestory();

    boolean isInfoWindowEnable();

    boolean isViewMode();

    void setInfoWindowOffset(int i4, int i5) throws RemoteException;

    void setInfoWindowShown(boolean z3);
}
