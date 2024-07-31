package com.amap.api.col.p0463l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.base.p048ae.gmap.glyph.ReflectUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.amap.api.col.3l.a0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AMapReflectionLocationSource implements LocationSource {

    /* renamed from: A */
    private Method f3478A;

    /* renamed from: B */
    private Method f3479B;

    /* renamed from: C */
    private Method f3480C;

    /* renamed from: D */
    private Method f3481D;

    /* renamed from: E */
    private Method f3482E;

    /* renamed from: F */
    private Method f3483F;

    /* renamed from: G */
    private Method f3484G;

    /* renamed from: H */
    private Method f3485H;

    /* renamed from: I */
    private Method f3486I;

    /* renamed from: J */
    private boolean f3487J = false;

    /* renamed from: K */
    private long f3488K = 2000;

    /* renamed from: L */
    private InvocationHandler f3489L = new C1731a();

    /* renamed from: a */
    private Context f3490a;

    /* renamed from: b */
    private LocationSource.OnLocationChangedListener f3491b;

    /* renamed from: c */
    private Object f3492c;

    /* renamed from: d */
    private Object f3493d;

    /* renamed from: e */
    private Object f3494e;

    /* renamed from: f */
    private Method f3495f;

    /* renamed from: g */
    private Method f3496g;

    /* renamed from: h */
    private Method f3497h;

    /* renamed from: i */
    private Method f3498i;

    /* renamed from: j */
    private Method f3499j;

    /* renamed from: k */
    private Method f3500k;

    /* renamed from: l */
    private Method f3501l;

    /* renamed from: m */
    private Method f3502m;

    /* renamed from: n */
    private Method f3503n;

    /* renamed from: o */
    private Method f3504o;

    /* renamed from: p */
    private Method f3505p;

    /* renamed from: q */
    private Method f3506q;

    /* renamed from: r */
    private Method f3507r;

    /* renamed from: s */
    private Method f3508s;

    /* renamed from: t */
    private Method f3509t;

    /* renamed from: u */
    private Method f3510u;

    /* renamed from: v */
    private Method f3511v;

    /* renamed from: w */
    private Method f3512w;

    /* renamed from: x */
    private Method f3513x;

    /* renamed from: y */
    private Method f3514y;

    /* renamed from: z */
    private Method f3515z;

    /* compiled from: AMapReflectionLocationSource.java */
    /* renamed from: com.amap.api.col.3l.a0$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1731a implements InvocationHandler {
        C1731a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!TextUtils.equals(method.getName(), "onLocationChanged") || AMapReflectionLocationSource.this.f3491b == null || objArr == null || objArr.length != 1) {
                return null;
            }
            Object obj2 = objArr[0];
            Location location = (Location) obj2;
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Object invokeMethod = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3505p, new Object[0]);
            if (invokeMethod instanceof Integer) {
                extras.putInt("errorCode", ((Integer) invokeMethod).intValue());
            }
            Object invokeMethod2 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3506q, new Object[0]);
            if (invokeMethod2 instanceof String) {
                extras.putString(MyLocationStyle.ERROR_INFO, (String) invokeMethod2);
            }
            Object invokeMethod3 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3507r, new Object[0]);
            if (invokeMethod3 instanceof Integer) {
                extras.putInt(MyLocationStyle.LOCATION_TYPE, ((Integer) invokeMethod3).intValue());
            }
            Object invokeMethod4 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3508s, new Object[0]);
            if (invokeMethod4 instanceof Float) {
                extras.putFloat("Accuracy", ((Float) invokeMethod4).floatValue());
            }
            Object invokeMethod5 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3509t, new Object[0]);
            if (invokeMethod5 instanceof String) {
                extras.putString("AdCode", (String) invokeMethod5);
            }
            Object invokeMethod6 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3510u, new Object[0]);
            if (invokeMethod6 instanceof String) {
                extras.putString("Address", (String) invokeMethod6);
            }
            Object invokeMethod7 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3511v, new Object[0]);
            if (invokeMethod7 instanceof String) {
                extras.putString("AoiName", (String) invokeMethod7);
            }
            Object invokeMethod8 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3512w, new Object[0]);
            if (invokeMethod8 instanceof String) {
                extras.putString("City", (String) invokeMethod8);
            }
            Object invokeMethod9 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3513x, new Object[0]);
            if (invokeMethod9 instanceof String) {
                extras.putString("CityCode", (String) invokeMethod9);
            }
            Object invokeMethod10 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3514y, new Object[0]);
            if (invokeMethod10 instanceof String) {
                extras.putString("Country", (String) invokeMethod10);
            }
            Object invokeMethod11 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3515z, new Object[0]);
            if (invokeMethod11 instanceof String) {
                extras.putString("District", (String) invokeMethod11);
            }
            Object invokeMethod12 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3478A, new Object[0]);
            if (invokeMethod12 instanceof String) {
                extras.putString("Street", (String) invokeMethod12);
            }
            Object invokeMethod13 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3479B, new Object[0]);
            if (invokeMethod13 instanceof String) {
                extras.putString("StreetNum", (String) invokeMethod13);
            }
            Object invokeMethod14 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3480C, new Object[0]);
            if (invokeMethod14 instanceof String) {
                extras.putString("PoiName", (String) invokeMethod14);
            }
            Object invokeMethod15 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3481D, new Object[0]);
            if (invokeMethod15 instanceof String) {
                extras.putString("Province", (String) invokeMethod15);
            }
            Object invokeMethod16 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3482E, new Object[0]);
            if (invokeMethod16 instanceof Float) {
                extras.putFloat(RtspHeaders.Names.SPEED, ((Float) invokeMethod16).floatValue());
            }
            Object invokeMethod17 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3483F, new Object[0]);
            if (invokeMethod17 instanceof String) {
                extras.putString("Floor", (String) invokeMethod17);
            }
            Object invokeMethod18 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3484G, new Object[0]);
            if (invokeMethod18 instanceof Float) {
                extras.putFloat("Bearing", ((Float) invokeMethod18).floatValue());
            }
            Object invokeMethod19 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3485H, new Object[0]);
            if (invokeMethod19 instanceof String) {
                extras.putString("BuildingId", (String) invokeMethod19);
            }
            Object invokeMethod20 = ReflectUtil.invokeMethod(obj2, AMapReflectionLocationSource.this.f3486I, new Object[0]);
            if (invokeMethod20 instanceof Double) {
                extras.putDouble("Altitude", ((Double) invokeMethod20).doubleValue());
            }
            location.setExtras(extras);
            AMapReflectionLocationSource.this.f3491b.onLocationChanged(location);
            return null;
        }
    }

    public AMapReflectionLocationSource(Context context) {
        this.f3490a = context;
        m55777b();
        m55772g();
        m55770i();
    }

    /* renamed from: b */
    private void m55777b() {
        try {
            this.f3495f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", AMapLocationListener.class);
            this.f3496g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", Class.forName("com.amap.api.location.AMapLocationClientOption"));
            this.f3497h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);
            this.f3498i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);
            this.f3499j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "onDestroy", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m55774e(boolean z) {
        Object obj;
        if (this.f3493d != null && (obj = this.f3492c) != null) {
            try {
                ReflectUtil.invokeMethod(obj, this.f3499j, new Object[0]);
                this.f3492c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f3490a});
                Object newProxyInstance = Proxy.newProxyInstance(AMapReflectionLocationSource.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.f3489L);
                this.f3494e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f3492c, this.f3495f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f3493d, this.f3501l, Boolean.valueOf(z));
                ReflectUtil.invokeMethod(this.f3493d, this.f3503n, Boolean.FALSE);
                if (!z) {
                    ReflectUtil.invokeMethod(this.f3493d, this.f3500k, Long.valueOf(this.f3488K));
                }
                ReflectUtil.invokeMethod(this.f3492c, this.f3496g, this.f3493d);
                ReflectUtil.invokeMethod(this.f3492c, this.f3497h, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f3487J = z;
    }

    /* renamed from: g */
    private void m55772g() {
        try {
            this.f3500k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setInterval", Long.TYPE);
            Class cls = Boolean.TYPE;
            this.f3501l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", cls);
            this.f3502m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", Class.forName("com.amap.api.location.AMapLocationClientOption$AMapLocationMode"));
            this.f3503n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", cls);
            this.f3504o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    private void m55770i() {
        try {
            this.f3505p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);
            this.f3506q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);
            this.f3507r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);
            this.f3508s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);
            this.f3509t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);
            this.f3510u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);
            this.f3511v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);
            this.f3512w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);
            this.f3513x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);
            this.f3514y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);
            this.f3515z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);
            this.f3478A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);
            this.f3479B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);
            this.f3480C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);
            this.f3481D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);
            this.f3482E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);
            this.f3483F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);
            this.f3484G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);
            this.f3485H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);
            this.f3486I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f3491b = onLocationChangedListener;
        if (Privacy.m54995a(this.f3490a, C1732a3.m55691s()).f4676a == Privacy.EnumC1812c.SuccessCode && this.f3492c == null) {
            try {
                Object newInstance = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f3490a});
                this.f3492c = newInstance;
                if (newInstance == null) {
                    return;
                }
                this.f3493d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);
                Object newProxyInstance = Proxy.newProxyInstance(AMapReflectionLocationSource.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.f3489L);
                this.f3494e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f3492c, this.f3495f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f3493d, this.f3500k, Long.valueOf(this.f3488K));
                ReflectUtil.invokeMethod(this.f3493d, this.f3501l, Boolean.valueOf(this.f3487J));
                ReflectUtil.invokeMethod(this.f3493d, this.f3502m, ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy"));
                ReflectUtil.invokeMethod(this.f3493d, this.f3503n, Boolean.FALSE);
                ReflectUtil.invokeMethod(this.f3492c, this.f3496g, this.f3493d);
                ReflectUtil.invokeMethod(this.f3492c, this.f3497h, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public final void m55776c(int i) {
        if (i != 1 && i != 0) {
            m55774e(false);
        } else {
            m55774e(true);
        }
    }

    /* renamed from: d */
    public final void m55775d(long j) {
        Object obj = this.f3493d;
        if (obj != null && this.f3492c != null) {
            Object invokeMethod = ReflectUtil.invokeMethod(obj, this.f3504o, new Object[0]);
            if ((invokeMethod instanceof Long) && ((Long) invokeMethod).longValue() != j) {
                ReflectUtil.invokeMethod(this.f3493d, this.f3500k, Long.valueOf(j));
                ReflectUtil.invokeMethod(this.f3492c, this.f3496g, this.f3493d);
            }
        }
        this.f3488K = j;
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.f3491b = null;
        Object obj = this.f3492c;
        if (obj != null) {
            ReflectUtil.invokeMethod(obj, this.f3498i, new Object[0]);
            ReflectUtil.invokeMethod(this.f3492c, this.f3499j, new Object[0]);
        }
        this.f3492c = null;
    }
}
