package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IUiSettings {
    float getLogoMarginRate(int i4) throws RemoteException;

    int getLogoPosition() throws RemoteException;

    int getZoomPosition() throws RemoteException;

    boolean isCompassEnabled() throws RemoteException;

    boolean isGestureScaleByMapCenter() throws RemoteException;

    boolean isIndoorSwitchEnabled() throws RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScaleControlsEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    boolean isZoomInByScreenCenter() throws RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean z3) throws RemoteException;

    void setCompassEnabled(boolean z3) throws RemoteException;

    void setGestureScaleByMapCenter(boolean z3) throws RemoteException;

    void setIndoorSwitchEnabled(boolean z3) throws RemoteException;

    void setLogoBottomMargin(int i4) throws RemoteException;

    void setLogoEnable(boolean z3);

    void setLogoLeftMargin(int i4) throws RemoteException;

    void setLogoMarginRate(int i4, float f4) throws RemoteException;

    void setLogoPosition(int i4) throws RemoteException;

    void setMyLocationButtonEnabled(boolean z3) throws RemoteException;

    void setRotateGesturesEnabled(boolean z3) throws RemoteException;

    void setScaleControlsEnabled(boolean z3) throws RemoteException;

    void setScrollGesturesEnabled(boolean z3) throws RemoteException;

    void setTiltGesturesEnabled(boolean z3) throws RemoteException;

    void setZoomControlsEnabled(boolean z3) throws RemoteException;

    void setZoomGesturesEnabled(boolean z3) throws RemoteException;

    void setZoomInByScreenCenter(boolean z3) throws RemoteException;

    void setZoomPosition(int i4) throws RemoteException;
}
