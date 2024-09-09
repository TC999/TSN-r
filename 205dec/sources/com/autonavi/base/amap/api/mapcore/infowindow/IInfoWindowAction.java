package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.col.p0003l.z;
import com.amap.api.maps.model.BasePointOverlay;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IInfoWindowAction {
    void hideInfoWindow();

    boolean isInfoWindowShown();

    boolean onInfoWindowTap(MotionEvent motionEvent);

    void redrawInfoWindow();

    void setInfoWindowAdapterManager(z zVar);

    void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;
}
