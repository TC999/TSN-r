package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.col.p0463l.InfoWindowDelegate;
import com.amap.api.maps.model.BasePointOverlay;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IInfoWindowAction {
    void hideInfoWindow();

    boolean isInfoWindowShown();

    boolean onInfoWindowTap(MotionEvent motionEvent);

    void redrawInfoWindow();

    void setInfoWindowAdapterManager(InfoWindowDelegate infoWindowDelegate);

    void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;
}
