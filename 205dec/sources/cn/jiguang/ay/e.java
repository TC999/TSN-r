package cn.jiguang.ay;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import cn.jiguang.ao.i;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e extends cn.jiguang.ah.b {

    /* renamed from: c  reason: collision with root package name */
    private static e f2492c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2494d;

    /* renamed from: e  reason: collision with root package name */
    private String f2495e;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2491b = cn.jiguang.ao.c.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 106, 124, 119, 101, 69, 83, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 115, 112, 57, 39, 81, 69, 46, 57, 117});

    /* renamed from: a  reason: collision with root package name */
    public static String f2490a = "";

    /* renamed from: f  reason: collision with root package name */
    private static int f2493f = 0;

    public static e d() {
        if (f2492c == null) {
            synchronized (e.class) {
                f2492c = new e();
            }
        }
        return f2492c;
    }

    private cn.jiguang.ak.b g(Context context) {
        String b4;
        cn.jiguang.ak.b bVar = new cn.jiguang.ak.b();
        try {
            b4 = cn.jiguang.ah.d.b(context);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceIp", "request i config failed, " + th.getMessage());
        }
        if (TextUtils.isEmpty(b4)) {
            cn.jiguang.w.a.f("JDeviceIp", "request i config failed because can't get appKey");
            return bVar;
        }
        long c4 = cn.jiguang.ah.d.c(context);
        if (c4 == 0) {
            cn.jiguang.w.a.f("JDeviceIp", "request i config failed because can't get uid");
            return bVar;
        } else if (TextUtils.isEmpty(cn.jiguang.ah.d.g(context))) {
            cn.jiguang.w.a.f("JDeviceIp", "request i config failed because need register first");
            return bVar;
        } else {
            String m4 = cn.jiguang.ag.a.m(context);
            PackageInfo a4 = cn.jiguang.ag.a.a(context, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", b4);
            jSONObject.put("uid", c4);
            jSONObject.put("appName", m4);
            jSONObject.put("appVersion", a4 == null ? "" : a4.versionName);
            jSONObject.put("appChannel", cn.jiguang.ah.d.a(context));
            jSONObject.put("appPackage", cn.jiguang.ag.a.a(context));
            String str = f2491b;
            if (a.C0049a.f2212a && !TextUtils.isEmpty(f2490a)) {
                str = f2490a;
            }
            cn.jiguang.w.a.b("JDeviceIp", "request i config, url: " + str + ", paramJson: " + jSONObject);
            cn.jiguang.ak.a aVar = new cn.jiguang.ak.a(str);
            aVar.a("Content-Type", "text/plain");
            aVar.a("Accept", "application/json");
            aVar.a("Charset", "UTF-8");
            aVar.a(i.b(jSONObject.toString(), true));
            bVar = cn.jiguang.ak.c.b(context, aVar);
            int b5 = bVar.b();
            cn.jiguang.w.a.b("JDeviceIp", "responseCode: " + b5);
            if (200 != b5) {
                return bVar;
            }
            String a5 = bVar.a();
            cn.jiguang.w.a.b("JDeviceIp", "request i config code:" + b5);
            return !TextUtils.isEmpty(a5) ? bVar : bVar;
        }
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2494d = context;
        return "JDeviceIp";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        int i4;
        c(context);
        if (TextUtils.isEmpty(this.f2495e)) {
            i4 = f2493f + 1;
            f2493f = i4;
        } else {
            i4 = 2;
        }
        f2493f = i4;
        if (i4 >= 2) {
            super.b(context, str);
        }
    }

    public synchronized String c(Context context) {
        if (cn.jiguang.ar.a.a().e(2800)) {
            if (!TextUtils.isEmpty(this.f2495e)) {
                return this.f2495e;
            }
            cn.jiguang.ak.b g4 = g(context);
            if (g4.b() != 200) {
                return "";
            }
            try {
                String a4 = i.a(g4.a(), true);
                cn.jiguang.w.a.b("JDeviceIp", "request i config success,response body:" + a4);
                String optString = new JSONObject(a4).optString("ipv6", "");
                this.f2495e = optString;
                return optString;
            } catch (JSONException unused) {
                return "";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (TextUtils.isEmpty(this.f2495e)) {
            cn.jiguang.w.a.b("JDeviceIp", "no data report");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("itime", cn.jiguang.ah.d.i(context));
            jSONObject.put("type", "ip_info");
            jSONObject.put("ipv6", this.f2495e);
            cn.jiguang.ah.d.a(context, (Object) jSONObject);
            super.c(context, str);
            this.f2495e = null;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceIp", "ip info report failed, " + th.getMessage());
        }
    }
}
