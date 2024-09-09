package cn.jiguang.al;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import cn.jiguang.ao.d;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: t  reason: collision with root package name */
    private static volatile a f2279t;

    /* renamed from: u  reason: collision with root package name */
    private static final Object f2280u = new Object();

    /* renamed from: v  reason: collision with root package name */
    private static String f2281v;

    /* renamed from: a  reason: collision with root package name */
    public String f2282a;

    /* renamed from: b  reason: collision with root package name */
    public String f2283b;

    /* renamed from: c  reason: collision with root package name */
    public String f2284c;

    /* renamed from: d  reason: collision with root package name */
    public String f2285d;

    /* renamed from: e  reason: collision with root package name */
    public String f2286e;

    /* renamed from: f  reason: collision with root package name */
    public String f2287f;

    /* renamed from: g  reason: collision with root package name */
    public int f2288g;

    /* renamed from: h  reason: collision with root package name */
    public String f2289h;

    /* renamed from: i  reason: collision with root package name */
    public String f2290i;

    /* renamed from: j  reason: collision with root package name */
    public String f2291j;

    /* renamed from: k  reason: collision with root package name */
    public String f2292k;

    /* renamed from: l  reason: collision with root package name */
    public String f2293l;

    /* renamed from: m  reason: collision with root package name */
    public String f2294m;

    /* renamed from: n  reason: collision with root package name */
    public String f2295n;

    /* renamed from: o  reason: collision with root package name */
    public String f2296o;

    /* renamed from: p  reason: collision with root package name */
    public String f2297p;

    /* renamed from: q  reason: collision with root package name */
    public String f2298q;

    /* renamed from: r  reason: collision with root package name */
    public String f2299r;

    /* renamed from: s  reason: collision with root package name */
    private transient AtomicBoolean f2300s = new AtomicBoolean(false);

    private a(Context context) {
        b(context);
    }

    public static a a(Context context) {
        if (f2279t == null) {
            synchronized (f2280u) {
                if (f2279t == null) {
                    f2279t = new a(context);
                }
            }
        }
        return f2279t;
    }

    private String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private void b(Context context) {
        if (this.f2300s.get() || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a(cn.jiguang.ag.a.v(context)));
        sb.append(",");
        int i4 = Build.VERSION.SDK_INT;
        sb.append(i4);
        this.f2283b = sb.toString();
        if (cn.jiguang.ar.a.a().e(2009)) {
            this.f2284c = cn.jiguang.ag.a.p(context);
        }
        if (cn.jiguang.ar.a.a().e(2001)) {
            this.f2285d = cn.jiguang.ag.a.a(context, "gsm.version.baseband", "baseband");
        }
        if (cn.jiguang.ar.a.a().e(2008)) {
            this.f2293l = cn.jiguang.ag.a.t(context);
        }
        if (cn.jiguang.ar.a.a().e(2002)) {
            this.f2295n = cn.jiguang.ag.a.r(context);
        }
        if (cn.jiguang.ar.a.a().e(2012)) {
            this.f2289h = cn.jiguang.ag.a.c(context);
        }
        if (cn.jiguang.ar.a.a().e(2000)) {
            this.f2290i = cn.jiguang.ag.a.g(context);
        }
        this.f2291j = " ";
        this.f2286e = a(Build.DEVICE);
        this.f2292k = a(cn.jiguang.ag.a.n(context));
        this.f2294m = a(cn.jiguang.ag.a.o(context));
        this.f2282a = c(context);
        this.f2287f = cn.jiguang.h.a.e(context);
        this.f2288g = cn.jiguang.ag.a.b(context) ? 1 : 0;
        this.f2296o = cn.jiguang.ag.a.d(context, "");
        Object a4 = d.a(context, "get_imei", null);
        if (a4 instanceof String) {
            this.f2297p = (String) a4;
        }
        this.f2298q = i4 + "";
        this.f2299r = context.getApplicationInfo().targetSdkVersion + "";
        this.f2300s.set(true);
    }

    private static String c(Context context) {
        if (f2281v == null) {
            try {
                PackageInfo a4 = cn.jiguang.ag.a.a(context, 0);
                if (a4 != null) {
                    String str = a4.versionName;
                    byte[] bytes = str.getBytes("UTF-8");
                    if (bytes.length > 30) {
                        str = new String(bytes, 0, 30);
                    }
                    f2281v = str;
                } else {
                    cn.jiguang.w.a.c("DeviceInfo", "NO versionName defined in manifest.");
                }
            } catch (Throwable unused) {
                cn.jiguang.w.a.c("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str2 = f2281v;
        return str2 == null ? "" : str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("androidApiVer", this.f2283b);
            jSONObject.put("modelNum", this.f2284c);
            jSONObject.put("baseBandVer", this.f2285d);
            jSONObject.put("manufacturer", this.f2293l);
            jSONObject.put("brand", this.f2295n);
            jSONObject.put("resolution", this.f2289h);
            jSONObject.put("androidId", this.f2290i);
            jSONObject.put("device", this.f2286e);
            jSONObject.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, this.f2292k);
            jSONObject.put("fingerprint", this.f2294m);
            jSONObject.put("aVersion", this.f2282a);
            jSONObject.put("channel", this.f2287f);
            jSONObject.put("installation", this.f2288g);
            jSONObject.put("imsi", this.f2296o);
            jSONObject.put("imei", this.f2297p);
            jSONObject.put("androidVer", this.f2298q);
            jSONObject.put("androidTargetVer", this.f2299r);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
