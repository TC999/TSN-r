package com.bytedance.sdk.openadsdk.core.ys;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.p.w.sr;
import com.bytedance.sdk.openadsdk.core.p.xv.f;
import com.bytedance.sdk.openadsdk.core.p.xv.gd;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.u.ux;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements xv {

    /* renamed from: c  reason: collision with root package name */
    private final me f35661c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.c f35662f;

    /* renamed from: w  reason: collision with root package name */
    private final w f35664w;
    private boolean xv;
    private final Map<String, com.bytedance.sdk.openadsdk.core.p.w.sr> sr = new HashMap();
    private boolean ux = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f35663r = false;

    private c(w wVar, me meVar, boolean z3) {
        this.f35664w = wVar;
        this.f35661c = meVar;
        this.xv = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void xv() {
        w();
        for (com.bytedance.sdk.openadsdk.core.p.w.sr srVar : this.sr.values()) {
            if (srVar != null) {
                srVar.f();
            }
        }
        this.sr.clear();
    }

    public static c c(w wVar, me meVar, boolean z3) {
        return new c(wVar, meVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void w() {
        for (com.bytedance.sdk.openadsdk.core.p.w.sr srVar : this.sr.values()) {
            if (srVar != null) {
                srVar.ux();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c() {
        for (com.bytedance.sdk.openadsdk.core.p.w.sr srVar : this.sr.values()) {
            if (srVar != null) {
                srVar.sr();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || this.f35664w == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.sr srVar = this.sr.get(c(this.f35661c, optJSONObject, (String) null).ix().w());
        if (srVar != null) {
            srVar.r();
        }
    }

    public static me c(me meVar, JSONObject jSONObject, String str) {
        String str2;
        boolean z3;
        me c4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        boolean z4 = false;
        if (jSONObject != null) {
            str2 = jSONObject.optString(DownloadModel.DOWNLOAD_URL);
            z3 = true;
        } else {
            str2 = "";
            z3 = false;
        }
        if (TextUtils.isEmpty(str2)) {
            z3 = false;
        }
        if (meVar.ix() == null || meVar.ix().w() == null || !meVar.ix().w().equals(str2)) {
            z4 = z3;
        }
        if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !optJSONObject2.optBoolean("has_valid_download_url", true)) {
            z4 = true;
        }
        if (z4) {
            c4 = new me();
            c4.gb(meVar.jv());
            c4.ls(meVar.rd());
            c4.gb(jSONObject.optInt("lp_down_rule"));
            c4.ck(4);
            c4.u(jSONObject.optString("id"));
            c4.bk(jSONObject.optString("source"));
            com.bytedance.sdk.openadsdk.core.u.sr srVar = new com.bytedance.sdk.openadsdk.core.u.sr();
            srVar.sr(jSONObject.optString("pkg_name"));
            srVar.xv(jSONObject.optString("name"));
            srVar.w(str2);
            c4.c(srVar);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (optJSONObject3 != null) {
                c4.c(new ia(optJSONObject3));
                if (!optJSONObject3.optBoolean("has_valid_download_url", true)) {
                    c4.ev(true);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (optJSONObject4 != null) {
                ux zg = c4.zg();
                if (zg == null) {
                    zg = new ux();
                }
                zg.c(optJSONObject4.optInt("score"));
                zg.c(optJSONObject4.optJSONArray("creative_tags"));
                c4.c(zg);
                c4.a(optJSONObject4.toString());
                gb kr = c4.kr();
                if (kr == null) {
                    kr = new gb();
                }
                kr.c(optJSONObject4.optString(CampaignEx.JSON_KEY_ICON_URL));
                c4.c(kr);
                c4.s(optJSONObject4.optString("desc"));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (optJSONObject5 != null) {
                c4.ls(optJSONObject5.optInt("app_manage_type"));
            }
            int optInt = jSONObject.optInt("live_interaction_type");
            String optString = jSONObject.optString("live_room_id");
            if (optInt > 0 && !TextUtils.isEmpty(optString)) {
                c4.wo(optInt);
                c4.eq(optString);
            }
            ok c5 = ok.c(jSONObject.optJSONObject("wc_miniapp_info"));
            if (c5 != null) {
                c4.c(c5);
            }
            String optString2 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(optString2)) {
                com.bytedance.sdk.openadsdk.core.u.sr ix = c4.ix() != null ? c4.ix() : new com.bytedance.sdk.openadsdk.core.u.sr();
                ix.c(optString2);
                c4.c(ix);
            }
        } else {
            c4 = com.bytedance.sdk.openadsdk.core.w.c(meVar.mo());
        }
        if (!TextUtils.isEmpty(str)) {
            c4.i(str);
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL)) != null) {
            ys ysVar = new ys();
            if (meVar.qu() != null) {
                ysVar.c(meVar.qu());
            }
            ysVar.c(new ys(optJSONObject));
            c4.c(ysVar);
        }
        return c4;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ys.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0525c {

        /* renamed from: c  reason: collision with root package name */
        private static ConcurrentHashMap<String, JSONObject> f35673c = new ConcurrentHashMap<>();

        public static synchronized JSONObject c(String str) {
            synchronized (C0525c.class) {
                if (TextUtils.isEmpty(str)) {
                    return new JSONObject();
                }
                ConcurrentHashMap<String, JSONObject> concurrentHashMap = f35673c;
                if (concurrentHashMap == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject = concurrentHashMap.get(str);
                if (jSONObject == null) {
                    return new JSONObject();
                }
                return jSONObject;
            }
        }

        public static synchronized void c(String str, int i4, int i5) {
            synchronized (C0525c.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f35673c == null) {
                    f35673c = new ConcurrentHashMap<>();
                }
                JSONObject jSONObject = f35673c.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                    f35673c.put(str, jSONObject);
                }
                try {
                    jSONObject.put("downloadStatus", i4);
                    jSONObject.put("downloadProcessRate", i5);
                    jSONObject.put("code", 0);
                    jSONObject.put("codeMsg", "get ad_down_load_id success");
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void w(boolean z3) {
        this.f35663r = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c(Context context, JSONObject jSONObject, String str, int i4, boolean z3, boolean z4) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        me c4 = c(this.f35661c, optJSONObject, str);
        c(context, c4, optJSONObject, i4, z3 ? k.c(c4) : 0, z4);
    }

    private void c(Context context, me meVar, JSONObject jSONObject, int i4, int i5, boolean z3) {
        if (context == null || meVar == null || meVar.ix() == null || jSONObject == null || this.f35664w == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.sr srVar = this.sr.get(meVar.ix().w());
        if (srVar != null) {
            srVar.c(i5);
            return;
        }
        String c4 = wv.c(i4);
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.sr c5 = c(context, meVar, jSONObject, c4);
        c5.c(i5);
        if (c5 instanceof com.bytedance.sdk.openadsdk.core.p.xv.sr) {
            ((com.bytedance.sdk.openadsdk.core.p.xv.sr) c5).w(z3);
        }
        this.sr.put(meVar.ix().w(), c5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        c(context, c(this.f35661c, optJSONObject, str2), str);
    }

    private void c(Context context, me meVar, String str) {
        if (context == null || meVar == null) {
            return;
        }
        if (meVar.ix() == null) {
            com.bytedance.sdk.openadsdk.core.p.w.sr w3 = com.bytedance.sdk.openadsdk.core.p.xv.w(context, meVar, str);
            if (w3 instanceof f) {
                ((f) w3).w(this.xv);
            }
            w3.w(me.ux(meVar));
        } else {
            final String jr = meVar.jr();
            com.bytedance.sdk.openadsdk.core.p.w.sr srVar = this.sr.get(meVar.ix().w());
            if (srVar != null) {
                srVar.sr(this.f35663r);
                if (srVar instanceof f) {
                    ((f) srVar).c().c(this.ux);
                } else if (srVar instanceof gd) {
                    ((gd) srVar).c().c(this.ux);
                }
                srVar.w(me.ux(meVar));
                srVar.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.ys.c.1
                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void c() {
                        C0525c.c(jr, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void w(long j4, long j5, String str2, String str3) {
                        if (j4 > 0) {
                            C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void xv(long j4, long j5, String str2, String str3) {
                        if (j4 > 0) {
                            C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void c(long j4, long j5, String str2, String str3) {
                        if (j4 > 0) {
                            C0525c.c(jr, 3, (int) ((j5 * 100) / j4));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void c(long j4, String str2, String str3) {
                        C0525c.c(jr, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                    public void c(String str2, String str3) {
                        C0525c.c(jr, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.r.w) {
            ((com.bytedance.sdk.openadsdk.core.r.w) context).c(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        c(c(this.f35661c, optJSONObject, (String) null), optJSONObject);
    }

    private void c(me meVar, JSONObject jSONObject) {
        if (this.f35664w == null || meVar == null || meVar.ix() == null) {
            return;
        }
        String w3 = meVar.ix().w();
        if (this.sr.containsKey(w3)) {
            com.bytedance.sdk.openadsdk.core.p.w.sr remove = this.sr.remove(w3);
            if (remove != null) {
                try {
                    remove.f();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.f35664w.c("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c(boolean z3) {
        this.ux = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.xv
    public void c(String str, boolean z3) {
        com.bytedance.sdk.openadsdk.core.p.w.sr srVar;
        if (TextUtils.isEmpty(str) || (srVar = this.sr.get(str)) == null) {
            return;
        }
        srVar.ux(z3);
    }

    private com.bytedance.sdk.openadsdk.core.p.w.sr c(Context context, me meVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.p.w.sr w3 = com.bytedance.sdk.openadsdk.core.p.xv.w(context, meVar, str);
        if (w3 instanceof f) {
            ((f) w3).w(this.xv);
        }
        w3.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.ys.c.2
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                c("status", "idle");
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str2, String str3) {
                c("status", "download_paused", DownloadModel.TOTAL_BYTES, String.valueOf(j4), "current_bytes", String.valueOf(j5));
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.w(j4, j5, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str2, String str3) {
                c("status", "download_failed", DownloadModel.TOTAL_BYTES, String.valueOf(j4), "current_bytes", String.valueOf(j5));
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.xv(j4, j5, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str2, String str3) {
                c("status", "download_active", DownloadModel.TOTAL_BYTES, String.valueOf(j4), "current_bytes", String.valueOf(j5));
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.c(j4, j5, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str2, String str3) {
                c("status", "download_finished", DownloadModel.TOTAL_BYTES, String.valueOf(j4), "current_bytes", String.valueOf(j4));
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.c(j4, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str2, String str3) {
                c("status", "installed");
                if (c.this.f35662f == null) {
                    return;
                }
                c.this.f35662f.c(str2, str3);
            }

            private void c(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i4 = 0; i4 < strArr.length; i4 += 2) {
                        jSONObject2.put(strArr[i4], strArr[i4 + 1]);
                    }
                    c.this.f35664w.c("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                    a.w("JsAppAdDownloadManager", "JSONException");
                }
            }
        });
        w3.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.ys.c.3
        });
        return w3;
    }
}
