package cn.jiguang.cc;

import android.content.Context;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: s  reason: collision with root package name */
    private static volatile a f3237s;

    /* renamed from: t  reason: collision with root package name */
    private static final Object f3238t = new Object();

    /* renamed from: a  reason: collision with root package name */
    public String f3239a;

    /* renamed from: b  reason: collision with root package name */
    public String f3240b;

    /* renamed from: c  reason: collision with root package name */
    public String f3241c;

    /* renamed from: d  reason: collision with root package name */
    public String f3242d;

    /* renamed from: e  reason: collision with root package name */
    public String f3243e;

    /* renamed from: f  reason: collision with root package name */
    public String f3244f;

    /* renamed from: g  reason: collision with root package name */
    public int f3245g;

    /* renamed from: h  reason: collision with root package name */
    public String f3246h;

    /* renamed from: i  reason: collision with root package name */
    public String f3247i;

    /* renamed from: j  reason: collision with root package name */
    public String f3248j;

    /* renamed from: k  reason: collision with root package name */
    public String f3249k;

    /* renamed from: l  reason: collision with root package name */
    public String f3250l;

    /* renamed from: m  reason: collision with root package name */
    public String f3251m;

    /* renamed from: n  reason: collision with root package name */
    public String f3252n;

    /* renamed from: o  reason: collision with root package name */
    public String f3253o;

    /* renamed from: p  reason: collision with root package name */
    public String f3254p;

    /* renamed from: q  reason: collision with root package name */
    public String f3255q;

    /* renamed from: r  reason: collision with root package name */
    public String f3256r;

    private a(Context context) {
        b(context);
    }

    public static a a(Context context) {
        if (f3237s == null) {
            synchronized (f3238t) {
                if (f3237s == null) {
                    f3237s = new a(context);
                }
            }
        }
        return f3237s;
    }

    private void b(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "getDeviceInfo", null, null);
            if (a4 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) a4;
                this.f3240b = jSONObject.optString("androidApiVer");
                this.f3241c = jSONObject.optString("modelNum");
                this.f3242d = jSONObject.optString("baseBandVer");
                this.f3250l = jSONObject.optString("manufacturer");
                this.f3252n = jSONObject.optString("brand");
                this.f3246h = jSONObject.optString("resolution");
                this.f3247i = jSONObject.optString("androidId");
                this.f3248j = jSONObject.optString("serialNumber");
                this.f3243e = jSONObject.optString("device");
                this.f3249k = jSONObject.optString(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT);
                this.f3251m = jSONObject.optString("fingerprint");
                this.f3239a = jSONObject.optString("aVersion");
                this.f3244f = jSONObject.optString("channel");
                this.f3245g = jSONObject.optInt("installation");
                this.f3253o = jSONObject.optString("imsi");
                this.f3254p = jSONObject.optString("imei");
                this.f3255q = jSONObject.optString("androidVer");
                this.f3256r = jSONObject.optString("androidTargetVer");
            }
        } catch (Exception unused) {
        }
    }
}
