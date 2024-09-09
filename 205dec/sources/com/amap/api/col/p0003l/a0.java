package com.amap.api.col.p0003l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ft;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.ae.gmap.glyph.ReflectUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapReflectionLocationSource.java */
/* renamed from: com.amap.api.col.3l.a0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a0 implements LocationSource {
    private Method A;
    private Method B;
    private Method C;
    private Method D;
    private Method E;
    private Method F;
    private Method G;
    private Method H;
    private Method I;
    private boolean J = false;
    private long K = 2000;

    /* renamed from: L  reason: collision with root package name */
    private InvocationHandler f7055L = new a();

    /* renamed from: a  reason: collision with root package name */
    private Context f7056a;

    /* renamed from: b  reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f7057b;

    /* renamed from: c  reason: collision with root package name */
    private Object f7058c;

    /* renamed from: d  reason: collision with root package name */
    private Object f7059d;

    /* renamed from: e  reason: collision with root package name */
    private Object f7060e;

    /* renamed from: f  reason: collision with root package name */
    private Method f7061f;

    /* renamed from: g  reason: collision with root package name */
    private Method f7062g;

    /* renamed from: h  reason: collision with root package name */
    private Method f7063h;

    /* renamed from: i  reason: collision with root package name */
    private Method f7064i;

    /* renamed from: j  reason: collision with root package name */
    private Method f7065j;

    /* renamed from: k  reason: collision with root package name */
    private Method f7066k;

    /* renamed from: l  reason: collision with root package name */
    private Method f7067l;

    /* renamed from: m  reason: collision with root package name */
    private Method f7068m;

    /* renamed from: n  reason: collision with root package name */
    private Method f7069n;

    /* renamed from: o  reason: collision with root package name */
    private Method f7070o;

    /* renamed from: p  reason: collision with root package name */
    private Method f7071p;

    /* renamed from: q  reason: collision with root package name */
    private Method f7072q;

    /* renamed from: r  reason: collision with root package name */
    private Method f7073r;

    /* renamed from: s  reason: collision with root package name */
    private Method f7074s;

    /* renamed from: t  reason: collision with root package name */
    private Method f7075t;

    /* renamed from: u  reason: collision with root package name */
    private Method f7076u;

    /* renamed from: v  reason: collision with root package name */
    private Method f7077v;

    /* renamed from: w  reason: collision with root package name */
    private Method f7078w;

    /* renamed from: x  reason: collision with root package name */
    private Method f7079x;

    /* renamed from: y  reason: collision with root package name */
    private Method f7080y;

    /* renamed from: z  reason: collision with root package name */
    private Method f7081z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AMapReflectionLocationSource.java */
    /* renamed from: com.amap.api.col.3l.a0$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!TextUtils.equals(method.getName(), "onLocationChanged") || a0.this.f7057b == null || objArr == null || objArr.length != 1) {
                return null;
            }
            Object obj2 = objArr[0];
            Location location = (Location) obj2;
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Object invokeMethod = ReflectUtil.invokeMethod(obj2, a0.this.f7071p, new Object[0]);
            if (invokeMethod instanceof Integer) {
                extras.putInt("errorCode", ((Integer) invokeMethod).intValue());
            }
            Object invokeMethod2 = ReflectUtil.invokeMethod(obj2, a0.this.f7072q, new Object[0]);
            if (invokeMethod2 instanceof String) {
                extras.putString("errorInfo", (String) invokeMethod2);
            }
            Object invokeMethod3 = ReflectUtil.invokeMethod(obj2, a0.this.f7073r, new Object[0]);
            if (invokeMethod3 instanceof Integer) {
                extras.putInt("locationType", ((Integer) invokeMethod3).intValue());
            }
            Object invokeMethod4 = ReflectUtil.invokeMethod(obj2, a0.this.f7074s, new Object[0]);
            if (invokeMethod4 instanceof Float) {
                extras.putFloat("Accuracy", ((Float) invokeMethod4).floatValue());
            }
            Object invokeMethod5 = ReflectUtil.invokeMethod(obj2, a0.this.f7075t, new Object[0]);
            if (invokeMethod5 instanceof String) {
                extras.putString("AdCode", (String) invokeMethod5);
            }
            Object invokeMethod6 = ReflectUtil.invokeMethod(obj2, a0.this.f7076u, new Object[0]);
            if (invokeMethod6 instanceof String) {
                extras.putString("Address", (String) invokeMethod6);
            }
            Object invokeMethod7 = ReflectUtil.invokeMethod(obj2, a0.this.f7077v, new Object[0]);
            if (invokeMethod7 instanceof String) {
                extras.putString("AoiName", (String) invokeMethod7);
            }
            Object invokeMethod8 = ReflectUtil.invokeMethod(obj2, a0.this.f7078w, new Object[0]);
            if (invokeMethod8 instanceof String) {
                extras.putString("City", (String) invokeMethod8);
            }
            Object invokeMethod9 = ReflectUtil.invokeMethod(obj2, a0.this.f7079x, new Object[0]);
            if (invokeMethod9 instanceof String) {
                extras.putString("CityCode", (String) invokeMethod9);
            }
            Object invokeMethod10 = ReflectUtil.invokeMethod(obj2, a0.this.f7080y, new Object[0]);
            if (invokeMethod10 instanceof String) {
                extras.putString("Country", (String) invokeMethod10);
            }
            Object invokeMethod11 = ReflectUtil.invokeMethod(obj2, a0.this.f7081z, new Object[0]);
            if (invokeMethod11 instanceof String) {
                extras.putString("District", (String) invokeMethod11);
            }
            Object invokeMethod12 = ReflectUtil.invokeMethod(obj2, a0.this.A, new Object[0]);
            if (invokeMethod12 instanceof String) {
                extras.putString("Street", (String) invokeMethod12);
            }
            Object invokeMethod13 = ReflectUtil.invokeMethod(obj2, a0.this.B, new Object[0]);
            if (invokeMethod13 instanceof String) {
                extras.putString("StreetNum", (String) invokeMethod13);
            }
            Object invokeMethod14 = ReflectUtil.invokeMethod(obj2, a0.this.C, new Object[0]);
            if (invokeMethod14 instanceof String) {
                extras.putString("PoiName", (String) invokeMethod14);
            }
            Object invokeMethod15 = ReflectUtil.invokeMethod(obj2, a0.this.D, new Object[0]);
            if (invokeMethod15 instanceof String) {
                extras.putString("Province", (String) invokeMethod15);
            }
            Object invokeMethod16 = ReflectUtil.invokeMethod(obj2, a0.this.E, new Object[0]);
            if (invokeMethod16 instanceof Float) {
                extras.putFloat("Speed", ((Float) invokeMethod16).floatValue());
            }
            Object invokeMethod17 = ReflectUtil.invokeMethod(obj2, a0.this.F, new Object[0]);
            if (invokeMethod17 instanceof String) {
                extras.putString("Floor", (String) invokeMethod17);
            }
            Object invokeMethod18 = ReflectUtil.invokeMethod(obj2, a0.this.G, new Object[0]);
            if (invokeMethod18 instanceof Float) {
                extras.putFloat("Bearing", ((Float) invokeMethod18).floatValue());
            }
            Object invokeMethod19 = ReflectUtil.invokeMethod(obj2, a0.this.H, new Object[0]);
            if (invokeMethod19 instanceof String) {
                extras.putString("BuildingId", (String) invokeMethod19);
            }
            Object invokeMethod20 = ReflectUtil.invokeMethod(obj2, a0.this.I, new Object[0]);
            if (invokeMethod20 instanceof Double) {
                extras.putDouble("Altitude", ((Double) invokeMethod20).doubleValue());
            }
            location.setExtras(extras);
            a0.this.f7057b.onLocationChanged(location);
            return null;
        }
    }

    public a0(Context context) {
        this.f7056a = context;
        b();
        g();
        i();
    }

    private void b() {
        try {
            this.f7061f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", AMapLocationListener.class);
            this.f7062g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", Class.forName("com.amap.api.location.AMapLocationClientOption"));
            this.f7063h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);
            this.f7064i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);
            this.f7065j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "onDestroy", new Class[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void e(boolean z3) {
        Object obj;
        if (this.f7059d != null && (obj = this.f7058c) != null) {
            try {
                ReflectUtil.invokeMethod(obj, this.f7065j, new Object[0]);
                this.f7058c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f7056a});
                Object newProxyInstance = Proxy.newProxyInstance(a0.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.f7055L);
                this.f7060e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f7058c, this.f7061f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f7059d, this.f7067l, Boolean.valueOf(z3));
                ReflectUtil.invokeMethod(this.f7059d, this.f7069n, Boolean.FALSE);
                if (!z3) {
                    ReflectUtil.invokeMethod(this.f7059d, this.f7066k, Long.valueOf(this.K));
                }
                ReflectUtil.invokeMethod(this.f7058c, this.f7062g, this.f7059d);
                ReflectUtil.invokeMethod(this.f7058c, this.f7063h, new Object[0]);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        this.J = z3;
    }

    private void g() {
        try {
            this.f7066k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setInterval", Long.TYPE);
            Class cls = Boolean.TYPE;
            this.f7067l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", cls);
            this.f7068m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", Class.forName("com.amap.api.location.AMapLocationClientOption$AMapLocationMode"));
            this.f7069n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", cls);
            this.f7070o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void i() {
        try {
            this.f7071p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);
            this.f7072q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);
            this.f7073r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);
            this.f7074s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);
            this.f7075t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);
            this.f7076u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);
            this.f7077v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);
            this.f7078w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);
            this.f7079x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);
            this.f7080y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);
            this.f7081z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);
            this.A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);
            this.B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);
            this.C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);
            this.D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);
            this.E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);
            this.F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);
            this.G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);
            this.H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);
            this.I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f7057b = onLocationChangedListener;
        if (ft.a(this.f7056a, a3.s()).f8385a == ft.c.SuccessCode && this.f7058c == null) {
            try {
                Object newInstance = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f7056a});
                this.f7058c = newInstance;
                if (newInstance == null) {
                    return;
                }
                this.f7059d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);
                Object newProxyInstance = Proxy.newProxyInstance(a0.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.f7055L);
                this.f7060e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f7058c, this.f7061f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f7059d, this.f7066k, Long.valueOf(this.K));
                ReflectUtil.invokeMethod(this.f7059d, this.f7067l, Boolean.valueOf(this.J));
                ReflectUtil.invokeMethod(this.f7059d, this.f7068m, ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy"));
                ReflectUtil.invokeMethod(this.f7059d, this.f7069n, Boolean.FALSE);
                ReflectUtil.invokeMethod(this.f7058c, this.f7062g, this.f7059d);
                ReflectUtil.invokeMethod(this.f7058c, this.f7063h, new Object[0]);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void c(int i4) {
        if (i4 != 1 && i4 != 0) {
            e(false);
        } else {
            e(true);
        }
    }

    public final void d(long j4) {
        Object obj = this.f7059d;
        if (obj != null && this.f7058c != null) {
            Object invokeMethod = ReflectUtil.invokeMethod(obj, this.f7070o, new Object[0]);
            if ((invokeMethod instanceof Long) && ((Long) invokeMethod).longValue() != j4) {
                ReflectUtil.invokeMethod(this.f7059d, this.f7066k, Long.valueOf(j4));
                ReflectUtil.invokeMethod(this.f7058c, this.f7062g, this.f7059d);
            }
        }
        this.K = j4;
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.f7057b = null;
        Object obj = this.f7058c;
        if (obj != null) {
            ReflectUtil.invokeMethod(obj, this.f7064i, new Object[0]);
            ReflectUtil.invokeMethod(this.f7058c, this.f7065j, new Object[0]);
        }
        this.f7058c = null;
    }
}
