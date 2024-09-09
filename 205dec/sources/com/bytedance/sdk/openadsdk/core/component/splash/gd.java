package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.bj;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    public static void c(Context context, bj bjVar, me meVar, boolean z3, long j4) {
        if (context == null || meVar == null || bjVar == null || !ls.w().mt()) {
            return;
        }
        boolean z4 = bjVar.sr() == 1;
        boolean z5 = bjVar.ev() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", bjVar.c());
            jSONObject.put("server_load_type", bjVar.w());
            if (z3) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", bjVar.xv());
            jSONObject.put("splash_creative_type", bjVar.sr());
            if (bjVar.j() > 0) {
                if (bjVar.j() == com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.au) {
                    jSONObject.put("check_cloud_error_code", bjVar.z());
                }
                jSONObject.put("splash_get_cache_error_code", bjVar.j());
            }
            if (z4) {
                if (z5) {
                    jSONObject.put("cache_image_duration", bjVar.r());
                } else {
                    jSONObject.put("download_image_duration", bjVar.f());
                    jSONObject.put("download_client_start_time", bjVar.fp());
                    jSONObject.put("download_net_time", bjVar.ia());
                    jSONObject.put("download_client_end_time", bjVar.s());
                    jSONObject.put("img_conttype", bjVar.ck());
                    jSONObject.put("img_net_bframe_time", bjVar.ba());
                    jSONObject.put("img_net_aframe_time", bjVar.y());
                }
                if (!z3) {
                    jSONObject.put("client_start_time", bjVar.a());
                    jSONObject.put("network_time", bjVar.bk());
                    jSONObject.put("sever_time", bjVar.t());
                    jSONObject.put("client_end_time", bjVar.ys());
                }
                jSONObject.put("load_duration", bjVar.ux());
                jSONObject.put("image_resolution", bjVar.p());
                jSONObject.put("image_cachetype", bjVar.ev());
                jSONObject.put(CampaignEx.JSON_KEY_IMAGE_SIZE, bjVar.gd());
            }
            if (bjVar.ls() > 0) {
                jSONObject.put("real_user_duration", j4 - bjVar.ls());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", bjVar.gb());
            jSONObject.put("on_call_back_time", bjVar.n());
            jSONObject.put("load_suc_time", bjVar.eq());
            jSONObject.put("is_boost", eq.f33187c ? 1 : 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, "splash_ad", "splash_ad_loadtime", j4 - bjVar.u(), jSONObject);
    }

    public static void sr(bj bjVar, long j4) {
        if (bjVar != null) {
            bjVar.fp(System.currentTimeMillis() - j4);
        }
    }

    public static void w(bj bjVar, long j4) {
        if (bjVar == null) {
            return;
        }
        bjVar.xv(j4);
    }

    public static void xv(bj bjVar, long j4) {
        if (bjVar == null) {
            return;
        }
        bjVar.k(j4);
    }

    public static void w(me meVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr srVar) {
        if (meVar == null || srVar == null || !ls.w().mt()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", srVar.sr());
            jSONObject.put("load_resource_duration", srVar.ux());
            jSONObject.put("render_duration", srVar.f());
            jSONObject.put("ren_seq", srVar.w());
            jSONObject.put("real_ren_seq", srVar.xv());
            jSONObject.put("final_t", srVar.ev() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", srVar.gd());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, "splash_ad", "splash_total_duration", srVar.r(), jSONObject);
    }

    public static void c(bj bjVar) {
        if (bjVar == null) {
            return;
        }
        bjVar.c(System.currentTimeMillis() - bjVar.u());
    }

    public static void c(bj bjVar, bj bjVar2) {
        if (bjVar == null || bjVar2 == null) {
            return;
        }
        bjVar.a(System.currentTimeMillis());
        bjVar2.a(System.currentTimeMillis());
        if (q.xv.get()) {
            bjVar.xv(0);
            bjVar2.xv(0);
            q.xv.set(false);
            return;
        }
        bjVar.xv(1);
        bjVar2.xv(1);
    }

    public static void c(bj bjVar, long j4) {
        if (bjVar == null) {
            return;
        }
        bjVar.w(j4);
    }

    public static void c(bj bjVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
        if (bjVar == null || evVar == null) {
            return;
        }
        if (evVar.f()) {
            bjVar.sr(2);
        } else {
            bjVar.sr(1);
        }
    }

    public static void c(bj bjVar, boolean z3) {
        if (bjVar == null) {
            return;
        }
        if (z3) {
            bjVar.ux(1);
        } else {
            bjVar.ux(2);
        }
    }

    public static void c(bj bjVar, com.bytedance.sdk.openadsdk.core.q.c.w wVar, Map<String, String> map) {
        if (wVar == null || bjVar == null) {
            return;
        }
        int w3 = wVar.w();
        if (bjVar.gd() == 0.0d) {
            bjVar.c(w3 / 1024.0f);
        }
        Bitmap c4 = wVar.c();
        if (c4 != null && TextUtils.isEmpty(bjVar.p())) {
            bjVar.c(c4.getWidth() + "X" + c4.getHeight());
        }
        if (map == null || map.size() <= 0 || bjVar.k() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        bjVar.c(jSONObject);
    }

    public static void c(bj bjVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
        if (bjVar == null || fVar == null) {
            return;
        }
        long f4 = fVar.f();
        long ev = fVar.ev();
        long r3 = fVar.r();
        long gd = fVar.gd();
        bjVar.sr(f4);
        bjVar.ux(r3);
        bjVar.f(ev);
        bjVar.r(gd);
    }

    public static void c(me meVar, bj bjVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar) {
        if (meVar == null || bjVar == null || evVar == null || evVar.f() || bjVar.ev() == 1 || !ls.w().mt()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_IMAGE_SIZE, bjVar.gd());
            jSONObject.put("image_resolution", bjVar.p());
            jSONObject.put("download_client_start_time", bjVar.fp());
            jSONObject.put("download_net_time", bjVar.ia());
            jSONObject.put("download_client_end_time", bjVar.s());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - bjVar.fz(), jSONObject);
    }

    public static void c(bj bjVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, long j4) {
        if (bjVar == null || evVar == null) {
            return;
        }
        long ev = evVar.ev();
        bjVar.p(j4 - ev);
        bjVar.u(evVar.gd() - ev);
    }

    public static void c(boolean z3, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar) {
        if (wVar == null || rVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = c(wVar, z3 ? 4 : 3, meVar);
        if (c4 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().xv(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gd.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                int i4;
                int i5;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.w.c.r rVar2 = com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.this;
                if (rVar2 != null) {
                    i4 = rVar2.r();
                    i5 = com.bytedance.sdk.openadsdk.core.component.splash.w.c.r.this.sr();
                } else {
                    i4 = 1;
                    i5 = -1;
                }
                try {
                    jSONObject.put("if_have_cache", i4);
                    jSONObject.put("if_have_rt_ads", i5);
                } catch (Throwable unused) {
                }
                return c4.w(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.fz.c.xv c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4, me meVar) {
        String str;
        String str2;
        String str3 = null;
        if (meVar != null) {
            String jr = meVar.jr();
            str2 = meVar.cf();
            str3 = wv.a(meVar);
            str = jr;
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = wv.r();
        }
        com.bytedance.sdk.openadsdk.core.fz.c.xv xv = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().f(str3).c(i4).xv(wVar.f());
        if (str != null) {
            xv.sr(str);
        }
        if (str2 != null) {
            xv.ev(str2);
        }
        return xv;
    }

    public static void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final long j4) {
        if (wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gd.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j4);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(3).xv(wVar.f()).f(wv.r()).w(jSONObject.toString());
            }
        });
    }

    public static void c(bj bjVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev evVar, long j4, me meVar) {
        if (evVar == null || bjVar == null || meVar == null) {
            return;
        }
        if (!evVar.f()) {
            p.c(j4, false, true, meVar, 0L, "loadSuccess");
            if (!evVar.r()) {
                c(bjVar, SystemClock.elapsedRealtime() - j4);
                com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, "splash_ad", SystemClock.elapsedRealtime() - j4);
            } else {
                w(bjVar, SystemClock.elapsedRealtime() - j4);
            }
        }
        c(bjVar, evVar.r());
        c(bjVar, evVar.sr(), evVar.p());
        c(bjVar, evVar, System.currentTimeMillis());
        c(bjVar, evVar.ys());
    }

    public static void c(bj bjVar, String str) {
        if (bjVar == null) {
            return;
        }
        bjVar.w(str);
    }

    public static void c(boolean z3, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final boolean z4, final boolean z5) {
        if (meVar == null || wVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = c(wVar, z3 ? 4 : 3, meVar);
        if (c4 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gd.3
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z5) {
                        jSONObject.put("image_CacheType", z4 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return c4.w(jSONObject.toString());
            }
        });
    }

    public static void c(boolean z3, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (meVar == null || wVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.fz.c.xv c4 = c(wVar, z3 ? 4 : 3, meVar);
        if (c4 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().sr(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gd.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.this;
            }
        });
    }

    public static void c(me meVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr srVar) {
        if (srVar == null || meVar == null || !ls.w().mt()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", srVar.c());
            jSONObject.put("render_sequence", srVar.w());
            jSONObject.put("real_render_sequence", srVar.xv());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, "splash_ad", "splash_render_duration", srVar.f(), jSONObject);
    }

    public static void c(me meVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.sr srVar, com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd gdVar) {
        if (meVar == null || gdVar == null) {
            return;
        }
        if (meVar.y() == 1) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u81ea\u6e32\u67d3 ");
            srVar.xv(99);
        } else if (!gdVar.w()) {
            int ld = meVar.ld();
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u6a21\u7248\u6e32\u67d3 " + ld);
            srVar.xv(ld);
        } else {
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u6a21\u7248\u515c\u5e95 ");
            srVar.xv(99);
        }
    }

    public static void c(bj bjVar, bj bjVar2, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, int i5) {
        if (bjVar == null || bjVar2 == null) {
            return;
        }
        bjVar.c(i4);
        bjVar.w(i5);
        bjVar.ys(wvVar.gd);
        bjVar2.c(i4);
        bjVar2.w(i5);
        bjVar2.ys(wvVar.gd);
    }
}
