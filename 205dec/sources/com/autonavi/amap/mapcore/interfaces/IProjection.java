package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IProjection {
    float calculateMapZoomer(LatLng latLng, int i4);

    TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i4, int i5) throws RemoteException;

    LatLng fromScreenLocation(Point point) throws RemoteException;

    AMapCameraInfo getCameraInfo();

    LatLngBounds getMapBounds(LatLng latLng, float f4) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    float toMapLenWithWin(int i4) throws RemoteException;

    PointF toMapLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation(LatLng latLng) throws RemoteException;
}
