package com.bytedance.sdk.openadsdk.ux.w;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls.bk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.n.ev;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.ux.xv.f;
import com.bytedance.sdk.openadsdk.ux.xv.fp;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import com.bytedance.sdk.openadsdk.ux.xv.k;
import com.bytedance.sdk.openadsdk.ux.xv.p;
import com.bytedance.sdk.openadsdk.ux.xv.r;
import com.bytedance.sdk.openadsdk.ux.xv.t;
import com.bytedance.sdk.openadsdk.ux.xv.ux;
import com.bytedance.sdk.openadsdk.ux.xv.xv;
import com.bytedance.sdk.openadsdk.ux.xv.ys;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<com.bykv.vk.openvk.component.video.api.w.c, ia> f36308c = Collections.synchronizedMap(new WeakHashMap());

    public static void f(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        r(cVar, cVar2);
        ia iaVar = f36308c.get(cVar);
        if (iaVar == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        if (xv <= 0) {
            return;
        }
        r rVar = new r();
        rVar.w(cVar2.w());
        rVar.c(xv);
        rVar.c(cVar2.p());
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, sr.ux("EXTRA_PLAY_ACTION"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, rVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            bk.c(c4, ux, sr);
            c(wVar, c(ux, "feed_over"), jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        f36308c.remove(cVar);
    }

    public static void r(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        if (cVar2.k() <= 0) {
            a.xv("VideoEventManager", "Cancel log report when buffer count is 0");
            return;
        }
        ia iaVar = f36308c.get(cVar);
        if (iaVar == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long xv = cVar2.xv();
        if (xv <= 0) {
            return;
        }
        t tVar = new t();
        tVar.c(cVar2.w());
        tVar.w(xv);
        tVar.c(cVar2.k());
        JSONObject c4 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c4, sr.ux("EXTRA_PLAY_ACTION"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c4, tVar);
        wVar.c(cVar2.a());
        c(wVar, "play_buffer");
    }

    public static void sr(com.bytedance.sdk.openadsdk.ux.xv.w<p> wVar) {
        c(wVar, "load_video_cancel");
    }

    public static void ux(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        Map<com.bykv.vk.openvk.component.video.api.w.c, ia> map;
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = (map = f36308c).get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        map.remove(cVar);
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        xv xvVar = new xv();
        xvVar.c(cVar2.w());
        xvVar.w(xv);
        xvVar.c(cVar2.f());
        xvVar.w(cVar2.r());
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, sr.ux("EXTRA_PLAY_START"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, xvVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            c(wVar, "endcard_skip", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void xv(com.bytedance.sdk.openadsdk.ux.xv.w<k> wVar) {
        c(wVar, "load_video_error");
    }

    public static JSONObject c(sr srVar, String str, int i4, int i5, me meVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv j4;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i4 > 0) {
                jSONObject.put("play_type", String.valueOf(i4));
            }
            if (gd.c(meVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (srVar != null) {
                if (srVar.t()) {
                    j4 = srVar.ls();
                    jSONObject.put("codec", "h265");
                } else {
                    j4 = srVar.j();
                }
                if (j4 != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, j4.gd());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(j4.ux()));
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, j4.a());
                    jSONObject.put("player_type", i5);
                    jSONObject.put("play_speed_ratio", j4.ev());
                    if (j4.r() > 0.0d) {
                        jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, j4.r());
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void sr(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = f36308c.get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        if (xv < 0) {
            return;
        }
        ys ysVar = new ys();
        ysVar.c(cVar2.w());
        ysVar.w(xv);
        ysVar.c(cVar2.sr());
        ysVar.w(cVar2.ux());
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, sr.ux("EXTRA_PLAY_START"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, ysVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            c(wVar, "play_error", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void w(com.bytedance.sdk.openadsdk.ux.xv.w<com.bytedance.sdk.openadsdk.ux.xv.bk> wVar) {
        c(wVar, "load_video_success");
    }

    public static void xv(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = f36308c.get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        if (xv <= 0 || c4 <= 0) {
            return;
        }
        f fVar = new f();
        fVar.c(cVar2.w());
        fVar.w(xv);
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, sr.ux("EXTRA_PLAY_ACTION"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, fVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            c(wVar, "feed_continue", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void w(me meVar, com.bykv.vk.openvk.component.video.api.w.c cVar, sr srVar) {
        if (meVar == null || cVar == null || srVar == null) {
            return;
        }
        String uuid = UUID.randomUUID().toString();
        com.bykv.vk.openvk.component.video.api.c.w c4 = ev.c(meVar.ou());
        int i4 = c(meVar, cVar, srVar) ? 1 : 2;
        f36308c.put(cVar, new ia(SystemClock.elapsedRealtime(), uuid, i4, srVar, meVar));
        long w3 = c4.w(srVar);
        fp fpVar = new fp();
        if (w3 > 0) {
            fpVar.c(w3);
        }
        a.w("pit", "ps:" + i4 + " " + w3);
        bk.c(i4, w3, meVar, srVar);
        JSONObject c5 = c(srVar, uuid, i4, srVar.s(), meVar);
        c(c5, srVar.ux("EXTRA_PLAY_START"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(meVar, wv.c(meVar), c5, fpVar);
        wVar.c(srVar.s() == -1);
        c(wVar, "play_start");
    }

    public static void c(com.bytedance.sdk.openadsdk.ux.xv.w<com.bytedance.sdk.openadsdk.ux.xv.a> wVar) {
        c(wVar, "load_video_start");
    }

    public static boolean c(me meVar, com.bykv.vk.openvk.component.video.api.w.c cVar, sr srVar) {
        int ou = meVar.ou();
        com.bykv.vk.openvk.component.video.api.c.w c4 = ev.c(ou);
        if (ou != 0) {
            if (ou == 1) {
                return c4.c(srVar);
            }
            return false;
        }
        long w3 = c4.w(srVar);
        boolean bk = srVar.bk();
        int f4 = srVar.f();
        if (bk) {
            f4 = (int) srVar.a();
        }
        int w4 = srVar.w();
        if (w4 > 0) {
            f4 = w4;
        }
        return w3 >= ((long) f4);
    }

    public static void w(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = f36308c.get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        if (xv <= 0 || c4 <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.ux.xv.ev evVar = new com.bytedance.sdk.openadsdk.ux.xv.ev();
        evVar.c(cVar2.w());
        evVar.w(xv);
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, sr.ux("EXTRA_PLAY_ACTION"));
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, evVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            c(wVar, "feed_pause", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long xv(sr srVar) {
        if (srVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.xv.xv ls = srVar.t() ? srVar.ls() : srVar.j();
        if (ls != null) {
            return Double.valueOf(ls.f() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sr(sr srVar) {
        return new File(srVar.ux(), srVar.ia()).getAbsolutePath();
    }

    private static boolean ux(com.bytedance.sdk.openadsdk.ux.xv.w wVar) {
        me c4;
        if (wVar == null || !wVar.ux() || (c4 = wVar.c()) == null) {
            return false;
        }
        String ls = c4.oo().ls();
        if (TextUtils.isEmpty(ls)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(ls);
            int length = jSONArray.length();
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (int i4 = 0; i4 < length; i4++) {
                String optString = jSONArray.getJSONObject(i4).optString("name");
                if ("content_did".equalsIgnoreCase(optString)) {
                    z3 = true;
                } else if ("content_utmsource".equalsIgnoreCase(optString)) {
                    z4 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(optString)) {
                    z5 = true;
                }
            }
            return z3 && z4 && z5;
        } catch (JSONException e4) {
            a.w("VideoEventManager", e4.getMessage());
            return false;
        }
    }

    public static void c(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2) {
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = f36308c.get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        if (!gd.c(ux) || com.bytedance.sdk.openadsdk.core.u.fp.w(ux)) {
            if (!cVar2.a()) {
                c(ux, sr, cVar2);
            }
            com.bytedance.sdk.openadsdk.ux.xv.gd gdVar = new com.bytedance.sdk.openadsdk.ux.xv.gd();
            gdVar.c(cVar2.bk() ? 1 : 0);
            gdVar.w(ev.c(ux.ou()).w(sr));
            gdVar.c(SystemClock.elapsedRealtime() - iaVar.c());
            JSONObject c4 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
            c(c4, sr.ux("EXTRA_PLAY_START"));
            com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c4, gdVar);
            wVar.c(cVar2.a());
            c(wVar, c(ux, "feed_play"));
        }
    }

    public static String c(me meVar, String str) {
        if (meVar != null && wv.sr(meVar) && wv.ux(meVar)) {
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1643912491:
                    if (str.equals("feed_over")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1643892427:
                    if (str.equals("feed_play")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 566194974:
                    if (str.equals("feed_break")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    return "play_over";
                case 1:
                    return "play";
                case 2:
                    return "play_break";
                default:
                    return str;
            }
        }
        return str;
    }

    public static void c(com.bykv.vk.openvk.component.video.api.w.c cVar, ia.c cVar2, Map<String, Object> map) {
        ia iaVar;
        if (cVar == null || cVar2 == null || (iaVar = f36308c.get(cVar)) == null) {
            return;
        }
        sr sr = iaVar.sr();
        me ux = iaVar.ux();
        if (sr == null || ux == null) {
            return;
        }
        long c4 = cVar2.c();
        long xv = cVar2.xv();
        if (xv <= 0) {
            return;
        }
        ux uxVar = new ux();
        uxVar.w(cVar2.w());
        uxVar.c(xv);
        uxVar.c(cVar2.gd());
        uxVar.w(cVar2.p());
        JSONObject c5 = c(sr, iaVar.w(), iaVar.xv(), sr.s(), ux);
        c(c5, map);
        com.bytedance.sdk.openadsdk.ux.xv.w wVar = new com.bytedance.sdk.openadsdk.ux.xv.w(ux, wv.c(ux), c5, uxVar);
        wVar.c(cVar2.a());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", c4);
            jSONObject.put("percent", cVar2.ev());
            bk.c(c4, ux, sr);
            c(wVar, c(ux, "feed_break"), jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        f36308c.remove(cVar);
    }

    private static void c(com.bytedance.sdk.openadsdk.ux.xv.w wVar, String str) {
        c(wVar, str, (JSONObject) null);
    }

    private static void c(final com.bytedance.sdk.openadsdk.ux.xv.w wVar, String str, JSONObject jSONObject) {
        if (wVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (wVar.ux() && !TextUtils.isEmpty(wVar.w()) && !ux(wVar)) {
            String w3 = wVar.w();
            w3.hashCode();
            char c4 = '\uffff';
            switch (w3.hashCode()) {
                case -891990144:
                    if (w3.equals("stream")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -712491894:
                    if (w3.equals("embeded_ad")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1912999166:
                    if (w3.equals("draw_ad")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                case 2:
                    str = "customer_" + str;
                    break;
            }
        }
        c.c(str, wVar.c());
        com.bytedance.sdk.openadsdk.core.a.xv.c(wVar.c(), wVar.w(), str, jSONObject, new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.ux.w.w.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                JSONObject xv = com.bytedance.sdk.openadsdk.ux.xv.w.this.xv();
                if (com.bytedance.sdk.openadsdk.ux.xv.w.this.sr() != null) {
                    com.bytedance.sdk.openadsdk.ux.xv.w.this.sr().a_(xv);
                }
                jSONObject2.put("ad_extra_data", xv.toString());
            }
        });
    }

    private static void c(final me meVar, final sr srVar, final ia.c cVar) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.ux.w.w.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", w.xv(sr.this));
                jSONObject.put("player_duration", cVar.xv());
                jSONObject.put("cache_path_type", ev.sr());
                jSONObject.put("url", sr.this.fp());
                jSONObject.put("path", w.sr(sr.this));
                jSONObject.put("player_type", sr.this.s());
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pangle_video_play_state").c(wv.ev(meVar)).w(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    public static synchronized sr c(com.bykv.vk.openvk.component.video.api.w.c cVar) {
        synchronized (w.class) {
            if (cVar == null) {
                return null;
            }
            ia iaVar = f36308c.get(cVar);
            if (iaVar == null) {
                return null;
            }
            return iaVar.sr();
        }
    }

    public static void c(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }
}
