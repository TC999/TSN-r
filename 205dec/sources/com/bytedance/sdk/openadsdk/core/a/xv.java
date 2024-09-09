package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.eq.q;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ev;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.y;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import u0.a;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public static int f31762c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {
        public static void c(final int i4, final int i5, me meVar) {
            String c4 = wv.c(meVar);
            if (c4 == null) {
                return;
            }
            xv.c(meVar, c4 + "_landingpage", "local_res_hit_rate", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.c.1
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("all_times", i5);
                    jSONObject2.put("hit_times", i4);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void c(me meVar) {
    }

    public static void ev(me meVar, String str, String str2, Map<String, Object> map) {
        ok si = meVar.si();
        if (si != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("wc_type", Integer.valueOf(si.ux()));
        }
        c(meVar, str, str2, map);
    }

    public static void f(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void gd(me meVar, String str, final String str2, final Map<String, Object> map) {
        c(meVar, str, "click_open", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.8
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", str2);
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void p(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void r(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void sr(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void ux(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(me meVar, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo;
        if (eq.sr() && (oo = meVar.oo()) != null) {
            String ys = oo.ys();
            if (TextUtils.isEmpty(ys)) {
                return;
            }
            jSONObject.putOpt("media_extra", ys);
        }
    }

    public static void xv(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void sr(me meVar, String str, String str2, JSONObject jSONObject) {
        if (meVar == null) {
            return;
        }
        new c.C0472c().ux(meVar.jr()).sr(meVar.cf()).c(str).w(str2).c(jSONObject).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
    }

    public static void ux(me meVar, String str, final long j4) {
        c(meVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.18
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j4);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void xv(me meVar, String str, String str2, final long j4, final JSONObject jSONObject) {
        if (meVar == null) {
            return;
        }
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.6
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j4);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void c(me meVar, String str, String str2, com.bytedance.sdk.openadsdk.ux.c.c cVar) {
        if (meVar == null) {
            return;
        }
        new c.C0472c().ux(meVar.jr()).sr(meVar.cf()).c(str).w(str2).c(cVar);
    }

    public static void xv(me meVar, String str, String str2, JSONObject jSONObject) {
        c(meVar, str, str2, jSONObject);
    }

    public static void xv(me meVar, String str, String str2) {
        ok si = meVar.si();
        JSONObject jSONObject = null;
        if (si != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", si.ux());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        c(meVar, str, str2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(me meVar, JSONObject jSONObject, String str) {
        if (meVar == null || jSONObject == null || TextUtils.isEmpty(str) || !str.equals("embeded_ad")) {
            return;
        }
        int i4 = 1;
        try {
            jSONObject.put("video_middle_page", (meVar.xw() != 1 || meVar.qy() == null) ? 0 : 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void xv(me meVar, String str, final long j4) {
        c(meVar, str, "load", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.15
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(j4, 600000L));
            }
        });
    }

    public static void c(me meVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.ux.c.c cVar) {
        if (meVar == null) {
            return;
        }
        new c.C0472c().ux(meVar.jr()).sr(meVar.cf()).c(str).w(str2).c(jSONObject).c(cVar);
    }

    public static void sr(me meVar, String str, final long j4) {
        c(meVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.16
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j4);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void xv(me meVar, String str, final int i4) {
        c(meVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.24
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i4);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public static void sr(me meVar, String str, final int i4) {
        c(meVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.25
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i4);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public static void w(me meVar, String str, String str2, JSONObject jSONObject) {
        c(meVar, str, str2, jSONObject);
    }

    public static void w(me meVar, String str, String str2, Map<String, Object> map) {
        c(meVar, str, str2, map);
    }

    public static void w(me meVar, String str) {
        if (meVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.xv.xv xvVar = new com.bytedance.sdk.openadsdk.core.dislike.xv.xv();
            xvVar.c("0:00");
            xvVar.w(str);
            c(meVar.ve(), xvVar);
        }
    }

    public static void c(me meVar, String str, String str2, final JSONObject jSONObject) {
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                }
            }
        });
    }

    public static void c(me meVar, String str, String str2, final Map<String, Object> map) {
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.12
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void c(final me meVar, final String str, final Map<String, Object> map, final Double d4) {
        if (c(str, meVar) || meVar == null) {
            return;
        }
        y.w();
        double currentTimeMillis = System.currentTimeMillis() / 1000;
        double k4 = wv.k(meVar);
        Double.isNaN(currentTimeMillis);
        final float floatValue = Double.valueOf(currentTimeMillis - k4).floatValue();
        final String c4 = q.c(str, gd.w(), wv.gd(meVar), com.bytedance.sdk.openadsdk.core.multipro.w.xv());
        f31762c++;
        c(meVar, str, "show", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.23
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.xv.c.c(ls.getContext(), ev.c(str)).toString());
                jSONObject2.put("is_cache", meVar.fn() ? 1 : 0);
                jSONObject2.put("cache_type", meVar.xt());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - com.bytedance.sdk.openadsdk.core.q.ux);
                jSONObject2.put("start_type", !com.bytedance.sdk.openadsdk.core.q.f34488w.get());
                jSONObject2.put("show_count", xv.f31762c);
                xv.w(meVar, str, jSONObject2);
                String str2 = c4;
                if (str2 != null) {
                    xk.c(jSONObject2, str2);
                }
                if (com.bytedance.sdk.openadsdk.core.playable.ux.w() && u.sr(meVar)) {
                    jSONObject2.put("csj_is_playable_pre_render", wx.n(meVar));
                }
                jSONObject2.put("live_sdk_status", TTLiveCommerceHelper.getInstance().getLiveSdkStatus());
                k.c(meVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                float f4 = floatValue;
                if (f4 <= 0.0f) {
                    f4 = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f4));
                String iu = meVar.iu();
                if (!TextUtils.isEmpty(iu)) {
                    try {
                        double parseDouble = Double.parseDouble(iu);
                        if (parseDouble <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        }
                        if (eq.f33190w < 4400) {
                            parseDouble *= 100000.0d;
                        }
                        jSONObject.put("ttdsp_price", parseDouble);
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        th.printStackTrace();
                    }
                }
                c(meVar, d4, jSONObject);
            }

            public void c(me meVar2, Double d5, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> tc = meVar2.tc();
                    if (tc == null || (obj = tc.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d5 != null) {
                        jSONObject.put("ttdsp_price", d5);
                    } else if (meVar2.le() && (obj2 = tc.get(BidResponsed.KEY_PRICE)) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String xv = i.xv();
        if (!TextUtils.isEmpty(xv)) {
            List<String> db = meVar.db();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", meVar.zb());
            hashMap.put(BidResponsedEx.KEY_CID, meVar.jr());
            hashMap.put("req_id", meVar.xq());
            hashMap.put("customer_id", wv.p(meVar));
            com.bytedance.sdk.openadsdk.core.fz.w.c(xv, db, true, hashMap);
        }
        if (f31762c == 1) {
            q.ev();
        }
        if (f31762c % 5 == 0 && com.bytedance.sdk.openadsdk.c.c.c.c() != null) {
            com.bytedance.sdk.openadsdk.c.c.c.c().w("AdShow" + System.currentTimeMillis());
        }
        if (TTLiveCommerceHelper.getInstance().isLiveCommerceScene(meVar)) {
            TTLiveCommerceHelper.getInstance().uploadLiveEventV2(a.a, meVar, 0L);
        } else if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            com.bytedance.sdk.openadsdk.core.video.xv.c.c(a.a, meVar, 0L);
        }
        wv.xv();
        com.bytedance.sdk.openadsdk.t.c.xv();
        TTLiveCommerceHelper.getInstance().tryWarmUpLiveRoom();
        com.bytedance.sdk.openadsdk.core.k.sr().xv().xv();
        q.c(f31762c, 1);
    }

    public static void w(me meVar, String str, String str2, final long j4, final JSONObject jSONObject) {
        if (meVar == null || jSONObject == null) {
            return;
        }
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.5
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j4);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void w(me meVar, String str, String str2) {
        c(meVar, str, str2, (com.bytedance.sdk.openadsdk.ux.c.c) null);
    }

    public static void w(me meVar, String str, long j4) {
        String str2;
        if (ls.w().mt()) {
            final long currentTimeMillis = System.currentTimeMillis() - j4;
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -891990144:
                    if (str.equals("stream")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 1844104722:
                    if (str.equals("interaction")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c4 = 6;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    str2 = "banner_ad_loadtime";
                    break;
                case 1:
                    str2 = "rewarded_video_loadtime";
                    break;
                case 2:
                    str2 = "stream_loadtime";
                    break;
                case 3:
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case 4:
                    str2 = "embeded_ad_loadtime";
                    break;
                case 5:
                    str2 = "interaction_loadtime";
                    break;
                case 6:
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.7
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", currentTimeMillis);
                }
            });
        }
    }

    public static void w(me meVar, String str, String str2, final String str3) {
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.11
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void w(me meVar) {
        c(meVar, "landingpage", "open_url_h5", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.14
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void w(me meVar, String str, final int i4, final String str2) {
        c(meVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.19
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i4));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void w(me meVar, String str, final int i4) {
        c(meVar, str, "live_custom_interaction", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.22
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("app_id", com.bytedance.sdk.openadsdk.core.k.sr().ev());
                    jSONObject2.put("live_interaction_result", i4 == 0);
                    jSONObject2.put("live_interaction_errcode", i4);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public static void w(long j4, me meVar) {
        if (meVar != null && me.w(meVar)) {
            final long currentTimeMillis = j4 > 0 ? System.currentTimeMillis() - j4 : 0L;
            c(meVar, "splash_ad", "play_duration_sum", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.27
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", currentTimeMillis);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void c(me meVar, final String str, final long j4) {
        c(meVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.29
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.xv.c.c(ls.getContext(), ev.c(str)).toString());
                jSONObject2.put("download_creative_duration", j4);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void c(final String str, me meVar, String str2) {
        if (meVar == null) {
            return;
        }
        c(meVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.30
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", str);
            }
        });
    }

    public static long c(long j4, boolean z3, me meVar, String str) {
        if (z3) {
            return System.currentTimeMillis();
        }
        c((System.currentTimeMillis() - j4) + "", meVar, str);
        return 0L;
    }

    public static long c(long j4, me meVar, String str) {
        if (j4 > 0) {
            c((System.currentTimeMillis() - j4) + "", meVar, str);
            return 0L;
        }
        return j4;
    }

    public static void c(me meVar, final String str) {
        String c4;
        if (meVar == null || str == null || (c4 = wv.c(meVar)) == null) {
            return;
        }
        c(meVar, c4, "page_on_create", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.31
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("page_name", str);
                xk.c(jSONObject2, "");
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void c(final String str, final me meVar, final com.bytedance.sdk.openadsdk.core.u.ev evVar, final String str2, final boolean z3, final Map<String, Object> map, final int i4, boolean z4) {
        if (meVar == null || z4 || c(str2, meVar)) {
            return;
        }
        double currentTimeMillis = System.currentTimeMillis() / 1000;
        double k4 = wv.k(meVar);
        Double.isNaN(currentTimeMillis);
        final float floatValue = Double.valueOf(currentTimeMillis - k4).floatValue();
        final int w3 = com.bytedance.sdk.openadsdk.core.playable.ux.c().w(meVar);
        c(meVar, str2, str, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.32
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.core.u.ev evVar2 = com.bytedance.sdk.openadsdk.core.u.ev.this;
                if (evVar2 != null) {
                    JSONObject c4 = evVar2.c();
                    c4.put("device", com.bytedance.sdk.openadsdk.core.xv.c.c(ls.getContext(), ev.c(str2)).toString());
                    c4.put("is_valid", z3);
                    int i5 = i4;
                    if (i5 >= 1 && i5 <= 2) {
                        c4.put("user_behavior_type", i5);
                    }
                    xk.c(c4, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            c4.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    xv.w(meVar, c4, str2);
                    if (com.bytedance.sdk.openadsdk.core.playable.ux.c(meVar)) {
                        c4.put("pre_render_process", w3);
                        c4.put("playable_url", u.w(meVar));
                    }
                    xv.w(meVar, str2, c4);
                    int oz = meVar.oz();
                    if (oz != -1 && str == "click") {
                        c4.put("open_live_status", oz);
                        meVar.ng(-1);
                    }
                    jSONObject.put("ad_extra_data", c4.toString());
                }
                float f4 = floatValue;
                if (f4 <= 0.0f) {
                    f4 = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f4));
            }
        });
        String xv = i.xv();
        if (!TextUtils.isEmpty(xv) && "click".equals(str)) {
            List<String> nd = meVar.nd();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", meVar.zb());
            hashMap.put(BidResponsedEx.KEY_CID, meVar.jr());
            hashMap.put("req_id", meVar.xq());
            hashMap.put("customer_id", wv.p(meVar));
            com.bytedance.sdk.openadsdk.core.fz.w.c(xv, nd, true, hashMap);
        }
        if (str == "click") {
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
                com.bytedance.sdk.openadsdk.core.video.xv.c.c(a.b, meVar, 0L);
            }
            TTLiveCommerceHelper.getInstance().onClick(meVar);
        }
        q.c(1, 2);
        if (com.bytedance.sdk.component.utils.a.xv()) {
            com.bytedance.sdk.component.utils.a.xv("AdEvent", str + " " + meVar.jr());
        }
    }

    private static boolean c(String str, me meVar) {
        return !TextUtils.isEmpty(str) && meVar != null && str.equals("feed_video_middle_page") && meVar.xw() == 1;
    }

    public static void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, com.bytedance.sdk.openadsdk.ys.w.w.f fVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        ls.c().c(wVar, arrayList);
        if (com.bytedance.sdk.component.utils.a.xv()) {
            com.bytedance.sdk.component.utils.a.xv("AdEvent", "tt_dislike_icon " + wVar.xv());
        }
    }

    public static void c(Context context, me meVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || meVar == null || jSONObject == null) {
            return;
        }
        Object opt = jSONObject.opt("value");
        if (opt == null) {
            opt = meVar.jr();
        }
        String optString = jSONObject.optString("category");
        if (TextUtils.isEmpty(optString)) {
            optString = "app_union";
        }
        Object opt2 = jSONObject.opt("log_extra");
        if (opt2 == null) {
            opt2 = meVar.cf();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(ys.xv(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "6.1.0.6");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.getMessage());
        }
        new c.C0472c().ux(opt == null ? "" : opt.toString()).xv(optString).sr(opt2 != null ? opt2.toString() : "").c(str).c(jSONObject).w(str2).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.33
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void c(final long j4, me meVar) {
        if (meVar == null) {
            return;
        }
        c(meVar, "splash_ad", "skip", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.34
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j4);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void c(me meVar, String str, String str2, final long j4, final int i4, final Map<String, Object> map) {
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.2
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j4);
                jSONObject.put("percent", i4);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void c(me meVar, String str, String str2, final long j4, final JSONObject jSONObject) {
        if (meVar == null || jSONObject == null) {
            return;
        }
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.3
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j4);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void c(me meVar, String str, String str2, final long j4) {
        if (meVar == null) {
            return;
        }
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.4
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j4);
            }
        });
    }

    public static void c(String str, String str2, String str3, String str4) {
        new c.C0472c().c(str3).w(str4).ux(str).sr(str2).c((com.bytedance.sdk.openadsdk.ux.c.c) null);
        if (com.bytedance.sdk.component.utils.a.xv()) {
            com.bytedance.sdk.component.utils.a.xv("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
        }
    }

    public static void c(me meVar, String str, String str2) {
        c(meVar, str, str2, (com.bytedance.sdk.openadsdk.ux.c.c) null);
    }

    public static void c(String str, long j4) {
        com.bytedance.sdk.openadsdk.core.bk.xv.c(str, j4);
    }

    public static void c(me meVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
            }
        } catch (Throwable unused) {
        }
        c(meVar, str, str2, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.9
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject);
            }
        });
    }

    public static void c(String str, final String str2, final String str3, long j4, long j5, JSONObject jSONObject) {
        String optString = jSONObject.optString("log_extra");
        double currentTimeMillis = System.currentTimeMillis() / 1000;
        double ux = wv.ux(optString);
        Double.isNaN(currentTimeMillis);
        final float floatValue = Double.valueOf(currentTimeMillis - ux).floatValue();
        new c.C0472c().c(str2).w(str3).xv(str).ux(String.valueOf(j4)).f(String.valueOf(j5)).c(jSONObject).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.10
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String optString2 = jSONObject2.optString("ad_extra_data", null);
                if (optString2 != null) {
                    jSONObject3 = new JSONObject(optString2);
                }
                jSONObject3.put("device", com.bytedance.sdk.openadsdk.core.xv.c.c(ls.getContext(), ev.c(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put("ad_extra_data", jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f4 = floatValue;
                    if (f4 <= 0.0f) {
                        f4 = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f4));
                }
            }
        });
        if (com.bytedance.sdk.component.utils.a.xv()) {
            com.bytedance.sdk.component.utils.a.xv("AdEvent", "sendJsAdEvent");
        }
    }

    public static void c(me meVar, String str, String str2, int i4, int i5) {
        if (meVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("color_percent", Integer.valueOf(i4));
        hashMap.put("playable_url", u.c(meVar));
        hashMap.put("memory_total", Integer.valueOf(wv.i()));
        hashMap.put("memory_use", Integer.valueOf(wv.j() - wv.q()));
        hashMap.put(ConstantAd.KEY_CACHE_AD, wv.a(meVar));
        hashMap.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("color_percent_type", Integer.valueOf(i5));
        p(meVar, str, str2, hashMap);
    }

    public static void c(final long j4, String str, String str2) {
        me meVar;
        try {
            meVar = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(str2));
        } catch (Throwable unused) {
            meVar = null;
        }
        if (meVar == null) {
            return;
        }
        c(meVar, str, "open_appback", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.13
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j4);
            }
        });
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        c4.c("save_dpl_success_time", 0L);
        c4.c("save_dpl_success_ad_tag", "");
    }

    public static void c(me meVar, String str, final int i4, final String str2) {
        c(meVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.17
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i4));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void c(me meVar, String str, final long j4, final JSONObject jSONObject) {
        c(meVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.20
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.putOpt("ad_extra_data", jSONObject3.toString());
                }
                jSONObject2.put("duration", j4);
            }
        });
    }

    public static void c(me meVar, String str, final int i4) {
        c(meVar, str, "internal_jump_live_status", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.21
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                jSONObject.put("status_code", i4);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void c(long j4, final int i4, me meVar, String str) {
        if (meVar == null) {
            return;
        }
        final int i5 = (int) (j4 / 1000);
        c(meVar, str, "show_over", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.26
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("show_count", i4);
                jSONObject2.put("show_time_count", String.valueOf(i5));
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void c(final int i4, String str, me meVar) {
        if (meVar == null) {
            return;
        }
        c(meVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.xv.28
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i4);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }
}
