package com.amap.api.col.p0463l;

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
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class MapFragmentDelegateImp implements IMapFragmentDelegate {

    /* renamed from: f */
    public static volatile Context f3708f;

    /* renamed from: g */
    private static String f3709g;

    /* renamed from: a */
    private IAMap f3710a;

    /* renamed from: c */
    private int f3712c;

    /* renamed from: d */
    private AMapOptions f3713d;

    /* renamed from: b */
    public int f3711b = 0;

    /* renamed from: e */
    boolean f3714e = true;

    public MapFragmentDelegateImp(int i) {
        this.f3712c = 0;
        this.f3712c = i % 3;
        m55520d();
    }

    /* renamed from: a */
    private static void m55523a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith("TextureMapView")) {
                    z2 = true;
                }
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().endsWith(C2576c.f8506e)) {
                    z = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i].getMethodName())) {
                    z3 = true;
                }
            }
            if (z && z2 && !z3) {
                m55519e();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static void m55522b(Context context) {
        if (context != null) {
            f3708f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: c */
    private void m55521c(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f3710a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f3710a.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f3710a.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f3710a.setMapType(aMapOptions.getMapType());
        this.f3710a.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    /* renamed from: d */
    private static void m55520d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 80; i++) {
                sb.append("=");
            }
            f3709g = sb.toString();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private static void m55519e() {
        Log.i("errorLog", f3709g);
        Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
        Log.i("errorLog", f3709g);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final IAMap getMap() throws RemoteException {
        if (this.f3710a == null) {
            if (f3708f == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i = f3708f.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                ConfigableConst.f3941a = 0.5f;
            } else if (i <= 160) {
                ConfigableConst.f3941a = 0.8f;
            } else if (i <= 240) {
                ConfigableConst.f3941a = 0.87f;
            } else if (i <= 320) {
                ConfigableConst.f3941a = 1.0f;
            } else if (i <= 480) {
                ConfigableConst.f3941a = 1.5f;
            } else if (i <= 640) {
                ConfigableConst.f3941a = 1.8f;
            } else {
                ConfigableConst.f3941a = 0.9f;
            }
            int i2 = this.f3712c;
            if (i2 == 0) {
                this.f3710a = new AMapGLSurfaceView(f3708f, this.f3714e).m54453b();
            } else if (i2 == 1) {
                this.f3710a = new AMapGLTextureView(f3708f, this.f3714e).m54418r();
            } else {
                this.f3710a = new AMapGLRenderer(f3708f).m53568a();
            }
        }
        return this.f3710a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z) {
        this.f3714e = z;
        IAMap iAMap = this.f3710a;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f3708f == null && layoutInflater != null) {
            setContext(StubApp.getOrigApplicationContext(layoutInflater.getContext().getApplicationContext()));
        }
        try {
            IAMap map = getMap();
            this.f3710a = map;
            map.setVisibilityEx(this.f3711b);
            if (this.f3713d == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f3713d = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            m55521c(this.f3713d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f3710a.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws RemoteException {
        m55523a();
        IAMap iAMap = this.f3710a;
        if (iAMap != null) {
            iAMap.clear();
            this.f3710a.destroy();
            this.f3710a = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        this.f3713d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f3710a;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f3710a;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f3710a != null) {
            if (this.f3713d == null) {
                this.f3713d = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f3713d.camera(getMap().getCameraPosition());
                this.f3713d = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(Context context) {
        m55522b(context);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(AMapOptions aMapOptions) {
        this.f3713d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i) {
        this.f3711b = i;
        IAMap iAMap = this.f3710a;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i);
        }
    }
}
