package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MapFragmentDelegateImp.java */
/* renamed from: com.amap.api.col.3l.c  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c implements IMapFragmentDelegate {

    /* renamed from: f  reason: collision with root package name */
    public static volatile Context f7290f;

    /* renamed from: g  reason: collision with root package name */
    private static String f7291g;

    /* renamed from: a  reason: collision with root package name */
    private IAMap f7292a;

    /* renamed from: c  reason: collision with root package name */
    private int f7294c;

    /* renamed from: d  reason: collision with root package name */
    private AMapOptions f7295d;

    /* renamed from: b  reason: collision with root package name */
    public int f7293b = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f7296e = true;

    public c(int i4) {
        this.f7294c = 0;
        this.f7294c = i4 % 3;
        d();
    }

    private static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (int i4 = 0; i4 < stackTrace.length; i4++) {
                if (stackTrace[i4].getClassName() != null && stackTrace[i4].getClassName().endsWith("TextureMapView")) {
                    z4 = true;
                }
                if (stackTrace[i4].getClassName() != null && stackTrace[i4].getClassName().endsWith("Fragment")) {
                    z3 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i4].getMethodName())) {
                    z5 = true;
                }
            }
            if (z3 && z4 && !z5) {
                e();
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        if (context != null) {
            f7290f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void c(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f7292a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f7292a.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f7292a.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f7292a.setMapType(aMapOptions.getMapType());
        this.f7292a.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    private static void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < 80; i4++) {
                sb.append("=");
            }
            f7291g = sb.toString();
        } catch (Throwable unused) {
        }
    }

    private static void e() {
        Log.i("errorLog", f7291g);
        Log.i("errorLog", "OnDestroy \u65b9\u6cd5\u9700\u8981\u5728OnDestroyView\u4e2d\u8c03\u7528");
        Log.i("errorLog", f7291g);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final IAMap getMap() throws RemoteException {
        if (this.f7292a == null) {
            if (f7290f == null) {
                Log.w("MapFragmentDelegateImp", "Context \u4e3a null \u8bf7\u5728\u5730\u56fe\u8c03\u7528\u4e4b\u524d \u4f7f\u7528 MapsInitializer.initialize(Context paramContext) \u6765\u8bbe\u7f6eContext");
                return null;
            }
            int i4 = f7290f.getResources().getDisplayMetrics().densityDpi;
            if (i4 <= 120) {
                fa.f7730a = 0.5f;
            } else if (i4 <= 160) {
                fa.f7730a = 0.8f;
            } else if (i4 <= 240) {
                fa.f7730a = 0.87f;
            } else if (i4 <= 320) {
                fa.f7730a = 1.0f;
            } else if (i4 <= 480) {
                fa.f7730a = 1.5f;
            } else if (i4 <= 640) {
                fa.f7730a = 1.8f;
            } else {
                fa.f7730a = 0.9f;
            }
            int i5 = this.f7294c;
            if (i5 == 0) {
                this.f7292a = new n(f7290f, this.f7296e).b();
            } else if (i5 == 1) {
                this.f7292a = new o(f7290f, this.f7296e).r();
            } else {
                this.f7292a = new x9(f7290f).a();
            }
        }
        return this.f7292a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z3) {
        this.f7296e = z3;
        IAMap iAMap = this.f7292a;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z3);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f7290f == null && layoutInflater != null) {
            setContext(StubApp.getOrigApplicationContext(layoutInflater.getContext().getApplicationContext()));
        }
        try {
            IAMap map = getMap();
            this.f7292a = map;
            map.setVisibilityEx(this.f7293b);
            if (this.f7295d == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f7295d = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            c(this.f7295d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f7292a.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.f7292a;
        if (iAMap != null) {
            iAMap.clear();
            this.f7292a.destroy();
            this.f7292a = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        this.f7295d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f7292a;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f7292a;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f7292a != null) {
            if (this.f7295d == null) {
                this.f7295d = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f7295d.camera(getMap().getCameraPosition());
                this.f7295d = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(Context context) {
        b(context);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(AMapOptions aMapOptions) {
        this.f7295d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i4) {
        this.f7293b = i4;
        IAMap iAMap = this.f7292a;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i4);
        }
    }
}
