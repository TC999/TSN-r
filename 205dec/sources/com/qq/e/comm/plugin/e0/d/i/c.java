package com.qq.e.comm.plugin.e0.d.i;

import android.os.Build;
import android.util.Pair;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.e0.d.i.a;
import com.qq.e.comm.plugin.e0.e.e;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.util.z1;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static void a(List<com.qq.e.comm.plugin.e0.e.d> list, String str, b bVar) {
        com.qq.e.comm.plugin.e0.d.i.a.a(list, new a(str, bVar));
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f42853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f42854b;

        a(String str, b bVar) {
            this.f42853a = str;
            this.f42854b = bVar;
        }

        @Override // com.qq.e.comm.plugin.e0.d.i.a.b
        public void a(JSONArray jSONArray, Map<Integer, com.qq.e.comm.plugin.e0.e.d> map) {
            j0 j0Var = new j0();
            com.qq.e.comm.plugin.d0.a d4 = com.qq.e.comm.plugin.d0.a.d();
            j0 j0Var2 = new j0();
            Pair<Integer, Integer> b4 = y.b();
            j0Var2.a("ifa", com.qq.e.comm.plugin.util.a.a()).a("os", 2).a("osv", String.valueOf(Build.VERSION.SDK_INT)).a("model", Build.MODEL).a("connection_type", d4.c().n().a()).a("language", Locale.getDefault().getLanguage()).a("h", b4.first).a("w", b4.second).a("country", Locale.getDefault().getCountry()).a("device_type", z1.c() ? 2 : 1).a("make", Build.BRAND);
            j0 j0Var3 = new j0();
            j0Var3.a("app_id", d4.b().a()).a("bundle", d4.a().getPackageName()).a("ver", d4.b().d());
            j0 j0Var4 = new j0();
            JSONObject optJSONObject = GlobalSetting.getSettings().optJSONObject("oversea_privacy_info");
            if (optJSONObject != null) {
                j0Var4.a("gdpr", optJSONObject.optBoolean("gdpr", false) ? 1 : 0).a("ccpa", optJSONObject.optBoolean("ccpa", false) ? 1 : 0).a("coppa", optJSONObject.optBoolean("coppa", false) ? 1 : 0);
            } else {
                j0Var4.a("gdpr", 0).a("ccpa", 0).a("coppa", 0);
            }
            j0Var.a("sdk_version", e1.c()).a("device", j0Var2.a()).a("mediation_id", this.f42853a).a("app", j0Var3.a()).a("adns", jSONArray).a("ext", j0Var4.a());
            C0810a c0810a = new C0810a(map);
            com.qq.e.comm.plugin.i0.n.c cVar = new com.qq.e.comm.plugin.i0.n.c("{domain}/auction".replace("{domain}", com.qq.e.comm.plugin.m0.a.l().f()), f.a.POST, j0Var.toString().getBytes(com.qq.e.comm.plugin.k.a.f44515a));
            v.a(1144001, (com.qq.e.comm.plugin.n0.c) null);
            com.qq.e.comm.plugin.i0.d.a().a(cVar, c.a.f44221d, c0810a);
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.e0.d.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0810a implements com.qq.e.comm.plugin.i0.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f42855a;

            C0810a(Map map) {
                this.f42855a = map;
            }

            @Override // com.qq.e.comm.plugin.i0.b
            public void a(f fVar, g gVar) {
                int statusCode = gVar.getStatusCode();
                v.a(1144002, null, Integer.valueOf(statusCode));
                if (statusCode == 200) {
                    try {
                        e eVar = new e(new JSONObject(gVar.b()));
                        int g4 = eVar.g();
                        v.a(1144003, null, Integer.valueOf(g4));
                        if (g4 == 0 && eVar.a() > 0) {
                            a.this.f42854b.a(eVar, this.f42855a);
                        } else {
                            a.this.f42854b.a(null, this.f42855a);
                        }
                        return;
                    } catch (Exception unused) {
                        a.this.f42854b.a(null, this.f42855a);
                        return;
                    }
                }
                a.this.f42854b.a(null, this.f42855a);
            }

            @Override // com.qq.e.comm.plugin.i0.b
            public void a(f fVar, Exception exc) {
                a.this.f42854b.a(null, this.f42855a);
                v.a(1144004, (com.qq.e.comm.plugin.n0.c) null);
            }
        }
    }
}
