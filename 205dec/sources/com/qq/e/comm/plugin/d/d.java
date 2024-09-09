package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends com.qq.e.comm.plugin.r.a<com.qq.e.comm.plugin.w.d> {

    /* renamed from: p  reason: collision with root package name */
    private static volatile d f42179p;

    /* renamed from: o  reason: collision with root package name */
    private JSONObject f42180o;

    private d() {
    }

    public static d i() {
        if (f42179p == null) {
            synchronized (d.class) {
                if (f42179p == null) {
                    f42179p = new d();
                }
            }
        }
        return f42179p;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [com.qq.e.comm.plugin.d.c, T] */
    @Override // com.qq.e.comm.plugin.r.a
    public void a(Context context, String str) {
        try {
            String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("wdc", "{\"jcc\":\"10000,100,60000,1000,10000\"}");
            if (TextUtils.isEmpty(b4)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(b4);
            this.f42180o = jSONObject;
            this.f45654a = b4;
            if (jSONObject.optInt(AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY) > 0) {
                super.a(context, str);
            } else {
                this.f45661h = context.getDir(b1.a(str), 0);
            }
            if (this.f45664k == null) {
                this.f45664k = new c(b());
            }
        } catch (Throwable th) {
            com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(9800002);
            eVar.c(c().f45671c);
            eVar.d(100);
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("ver", 0);
            dVar.a("ot", Log.getStackTraceString(th));
            v.a(eVar);
        }
    }

    @Override // com.qq.e.comm.plugin.r.a
    protected com.qq.e.comm.plugin.r.c c() {
        return com.qq.e.comm.plugin.r.c.f45670e;
    }

    @Override // com.qq.e.comm.plugin.r.a
    protected boolean d() throws Throwable {
        long optLong = this.f42180o.optLong("ddl");
        if (optLong <= 0 || optLong > System.currentTimeMillis()) {
            this.f45655b = this.f42180o.optString("up");
            this.f45656c = this.f42180o.optString("sgp");
            if (!TextUtils.isEmpty(this.f45655b) && !TextUtils.isEmpty(this.f45656c)) {
                String[] split = this.f45655b.split("_");
                if (split.length < 2) {
                    return false;
                }
                String str = split[split.length - 1];
                this.f45657d = str;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                this.f45659f = this.f42180o.optInt("ddc", 3);
                int pluginVersion = SDKStatus.getPluginVersion();
                int optInt = this.f42180o.optInt("psv");
                int optInt2 = this.f42180o.optInt("pev");
                if (pluginVersion >= optInt && pluginVersion <= optInt2) {
                    String optString = this.f42180o.optString("mcn");
                    this.f45658e = optString;
                    return !TextUtils.isEmpty(optString);
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.r.a
    protected boolean g() {
        return false;
    }
}
