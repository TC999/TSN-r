package com.mbridge.msdk.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingRequestController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38743a = "c";

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final String str, final String str2) {
        String[] split;
        if (!com.mbridge.msdk.foundation.same.net.f.d.a().d()) {
            try {
                if (com.mbridge.msdk.foundation.same.net.f.d.a().E) {
                    return;
                }
                com.mbridge.msdk.foundation.same.net.f.d.a().E = true;
                if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts").longValue() + 86400000) {
                    String b4 = com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host");
                    if (!TextUtils.isEmpty(b4)) {
                        for (String str3 : b4.split("\n")) {
                            if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.f.d.a().F.contains(str3.trim())) {
                                com.mbridge.msdk.foundation.same.net.f.d.a().F.add(str3.trim());
                                com.mbridge.msdk.foundation.same.net.f.d.a().G.add(str3.trim());
                            }
                        }
                        b(context, str, str2);
                        return;
                    }
                }
                new com.mbridge.msdk.foundation.same.net.g.b(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(0, com.mbridge.msdk.foundation.same.net.f.d.a().B, new com.mbridge.msdk.foundation.same.net.g.d(), new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.c.c.2
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(String str4) {
                        String[] split2;
                        x.a(c.f38743a, "fetch CNDSettingHost success, content = " + str4);
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                        com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str4);
                        for (String str5 : str4.split("\n")) {
                            if (!TextUtils.isEmpty(str5.trim()) && !com.mbridge.msdk.foundation.same.net.f.d.a().F.contains(str5.trim())) {
                                com.mbridge.msdk.foundation.same.net.f.d.a().F.add(str5.trim());
                                com.mbridge.msdk.foundation.same.net.f.d.a().G.add(str5.trim());
                            }
                        }
                        c.this.b(context, str, str2);
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str4) {
                        com.mbridge.msdk.foundation.same.net.f.d.a().E = false;
                        String str5 = c.f38743a;
                        x.a(str5, "fetch CNDSettingHost failed, errorCode = " + str4);
                    }
                });
                return;
            } catch (Throwable th) {
                com.mbridge.msdk.foundation.same.net.f.d.a().E = false;
                x.d(f38743a, th.getMessage());
                return;
            }
        }
        a(context, str, str2);
    }

    public final void a(final Context context, final String str, final String str2) {
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        dVar.a("jm_a", com.mbridge.msdk.d.b.a(context).c());
        dVar.a("jm_n", com.mbridge.msdk.d.b.a(context).a() + "");
        dVar.a("launcher", com.mbridge.msdk.d.b.a(context).b());
        try {
            String bb = b.a().g(str).bb();
            if (TextUtils.isEmpty(bb)) {
                bb = "";
            }
            dVar.a("vtag", bb);
        } catch (Throwable th) {
            x.d(f38743a, th.getMessage());
        }
        if (com.mbridge.msdk.foundation.same.net.f.d.a().E) {
            dVar.a("st_net", com.mbridge.msdk.foundation.same.net.f.d.a().f39572i + "");
        }
        com.mbridge.msdk.foundation.same.net.g.c cVar = new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.c.c.1
            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(JSONObject jSONObject) {
                try {
                    String b4 = c.this.b();
                    int i4 = com.mbridge.msdk.foundation.same.net.f.d.a().f39572i;
                    if (ac.a(jSONObject)) {
                        try {
                            int optInt = jSONObject.optInt("use_thread_pool", 0);
                            Context context2 = context;
                            if (context2 != null) {
                                context2.getSharedPreferences("mb_optimization_setting", 0).edit().putInt("use_thread_pool", optInt).apply();
                            }
                        } catch (Exception unused) {
                            Context context3 = context;
                            if (context3 != null) {
                                context3.getSharedPreferences("mb_optimization_setting", 0).edit().putInt("use_thread_pool", 0).apply();
                            }
                        }
                        com.mbridge.msdk.a.ALLOW_APK_DOWNLOAD = jSONObject.optBoolean("aa");
                        jSONObject.put("current_time", System.currentTimeMillis());
                        if (com.mbridge.msdk.foundation.same.net.f.d.a().f39571h) {
                            if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.f.d.a().f39567d);
                            }
                        } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                            jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.f.d.a().f39566c);
                        }
                        b.a().b(str, jSONObject.toString());
                        com.mbridge.msdk.foundation.same.net.f.d.a().c();
                        if (!com.mbridge.msdk.c.b.a.a().c()) {
                            new Thread(new Runnable() { // from class: com.mbridge.msdk.c.c.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Looper.prepare();
                                    com.mbridge.msdk.c.b.a.a().e();
                                    Looper.loop();
                                }
                            }).start();
                        } else {
                            com.mbridge.msdk.c.b.a.a().d();
                        }
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.c.c.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.foundation.controller.a.g();
                            }
                        }).start();
                        try {
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                com.mbridge.msdk.c.b.b.a().a(context, jSONObject.optString("mraid_js"));
                            }
                        } catch (Exception e4) {
                            x.d(c.f38743a, e4.getMessage());
                        }
                        if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                            com.mbridge.msdk.c.b.c.a().a(context, jSONObject.optString("web_env_url"));
                        }
                        c.a(c.this, context, str);
                    } else {
                        b a4 = b.a();
                        String str3 = str;
                        String c4 = a4.c(str3);
                        if (!TextUtils.isEmpty(c4)) {
                            JSONObject jSONObject2 = new JSONObject(c4);
                            jSONObject2.put("current_time", System.currentTimeMillis());
                            a4.b(str3, jSONObject2.toString());
                        }
                    }
                    c.a(c.this, 1, i4, "", b4);
                    c.b(c.this);
                } catch (Exception e5) {
                    x.d(c.f38743a, e5.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(String str3) {
                c.a(c.this, 2, com.mbridge.msdk.foundation.same.net.f.d.a().f39572i, str3, c.this.b());
                if (!com.mbridge.msdk.foundation.same.net.f.d.a().f39571h) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().C++;
                } else {
                    com.mbridge.msdk.foundation.same.net.f.d.a().D++;
                }
                c.this.b(context, str, str2);
                c.b(c.this);
                x.d(c.f38743a, "get app setting error" + str3);
            }
        };
        com.mbridge.msdk.c.a.c cVar2 = new com.mbridge.msdk.c.a.c(context);
        String str3 = com.mbridge.msdk.foundation.same.net.f.d.a().f39579p;
        try {
            if (com.mbridge.msdk.foundation.same.net.f.d.a().f39571h && com.mbridge.msdk.foundation.same.net.f.d.a().E && com.mbridge.msdk.foundation.same.net.f.d.a().D < com.mbridge.msdk.foundation.same.net.f.d.a().G.size()) {
                String str4 = com.mbridge.msdk.foundation.same.net.f.d.a().G.get(com.mbridge.msdk.foundation.same.net.f.d.a().D);
                if (!TextUtils.isEmpty(str4) && (str4.startsWith("http") || str4.startsWith("https"))) {
                    str3 = str4 + "/setting";
                }
            }
        } catch (Throwable th2) {
            x.d(f38743a, th2.getMessage());
        }
        cVar2.a(1, str3, dVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        String str = com.mbridge.msdk.foundation.same.net.f.d.a().f39571h ? com.mbridge.msdk.foundation.same.net.f.d.a().f39584u : com.mbridge.msdk.foundation.same.net.f.d.a().f39579p;
        try {
            if (com.mbridge.msdk.foundation.same.net.f.d.a().f39571h && com.mbridge.msdk.foundation.same.net.f.d.a().E && com.mbridge.msdk.foundation.same.net.f.d.a().D < com.mbridge.msdk.foundation.same.net.f.d.a().G.size()) {
                String str2 = com.mbridge.msdk.foundation.same.net.f.d.a().G.get(com.mbridge.msdk.foundation.same.net.f.d.a().D);
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                if (str2.startsWith("http") || str2.startsWith("https")) {
                    return str2 + "/setting";
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            x.d(f38743a, th.getMessage());
            return str;
        }
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.a.f().k();
            str2 = com.mbridge.msdk.foundation.controller.a.f().l();
        }
        if (b.a().a(str3, str) && b.a().a(str, 2, str3)) {
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            String str4 = "[" + str3 + "]";
            dVar.a("unit_ids", str4);
            dVar.a("app_id", str);
            dVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String y3 = b.a().c(str, str4).y();
                if (TextUtils.isEmpty(y3)) {
                    y3 = "";
                }
                dVar.a("vtag", y3);
            } catch (Throwable th) {
                x.d(f38743a, th.getMessage());
            }
            new com.mbridge.msdk.c.a.c(context).a(1, com.mbridge.msdk.foundation.same.net.f.d.a().f39579p, dVar, new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.c.c.3
                @Override // com.mbridge.msdk.foundation.same.net.g.c
                public final void a(JSONObject jSONObject) {
                    try {
                        if (ac.a(jSONObject)) {
                            String optString = jSONObject.optString("vtag", "");
                            JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                optJSONObject.put("current_time", System.currentTimeMillis());
                                optJSONObject.put("vtag", optString);
                                b.a().a(str, str3, optJSONObject.toString());
                            }
                        } else {
                            b.a().g(str, str3);
                        }
                        c.a(c.this, 1, "");
                    } catch (Exception e4) {
                        x.d(c.f38743a, e4.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.g.c
                public final void a(String str5) {
                    c.a(c.this, 2, str5);
                }
            });
        }
    }

    static /* synthetic */ void b(c cVar) {
        try {
            new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a();
        } catch (Throwable th) {
            x.d(f38743a, th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, Context context, String str) {
        a b4;
        b a4 = b.a();
        if (a4 != null && (b4 = a4.b(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = b4.aM();
            MBridgeConstans.OMID_JS_H5_URL = b4.aL();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    static /* synthetic */ void a(c cVar, int i4, int i5, String str, String str2) {
        try {
            new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a(i4, i5, str, str2);
        } catch (Throwable th) {
            x.d(f38743a, th.getMessage());
        }
    }

    static /* synthetic */ void a(c cVar, int i4, String str) {
        try {
            new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a(i4, com.mbridge.msdk.foundation.same.net.f.d.a().f39572i, str, com.mbridge.msdk.foundation.same.net.f.d.a().f39571h ? com.mbridge.msdk.foundation.same.net.f.d.a().f39584u : com.mbridge.msdk.foundation.same.net.f.d.a().f39579p);
        } catch (Throwable th) {
            x.d(f38743a, th.getMessage());
        }
    }
}
