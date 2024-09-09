package com.autonavi.amap.mapcore.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IMapFragmentDelegate {
    IAMap getMap() throws RemoteException;

    boolean isReady() throws RemoteException;

    void loadWorldVectorMap(boolean z3);

    void onCreate(Bundle bundle) throws RemoteException;

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void setContext(Context context);

    void setOptions(AMapOptions aMapOptions);

    void setVisibility(int i4);
}