package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ng {

    /* renamed from: c  reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.xv.xv f34793c;

    /* renamed from: w  reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.xv.xv f34794w;
    private com.bykv.vk.openvk.component.video.api.xv.c xv;

    public ng() {
    }

    public static com.bykv.vk.openvk.component.video.api.xv.xv a(me meVar) {
        return c(meVar, 0);
    }

    public static com.bykv.vk.openvk.component.video.api.xv.xv bk(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar = fp.f34793c;
        if (xvVar != null) {
            return xvVar;
        }
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar) && meVar.ld() == 3) {
            return xvVar;
        }
        if (!com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            return fp.f34793c;
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar2 = new com.bykv.vk.openvk.component.video.api.xv.xv();
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            xvVar2.xv(fp.xv.ux());
            xvVar2.ux(0);
            xvVar2.sr(0);
            xvVar2.ux(fp.xv.w());
            xvVar2.c(fp.xv.xv());
            double f4 = fp.xv.f();
            double r3 = fp.xv.r() + 1;
            Double.isNaN(r3);
            xvVar2.c(f4 * r3);
        }
        fp.f34793c = xvVar2;
        return xvVar2;
    }

    public static int ev(me meVar) {
        if (fp(meVar) == null) {
            return 413;
        }
        if (TextUtils.isEmpty(c(meVar))) {
            return 414;
        }
        return TextUtils.isEmpty(w(meVar)) ? 415 : 200;
    }

    public static String f(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return com.bykv.vk.openvk.component.video.api.f.w.c(ba.r(meVar));
        }
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            return ys(meVar).w();
        }
        return fp.f34793c.ys();
    }

    private static ng fp(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.mk();
    }

    public static boolean gd(me meVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar;
        ng fp = fp(meVar);
        return (fp == null || (xvVar = fp.f34793c) == null || xvVar.c() != 1) ? false : true;
    }

    public static boolean k(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return false;
        }
        return fp.f34793c.q();
    }

    public static boolean p(me meVar) {
        ng fp = fp(meVar);
        return (fp == null || fp.xv == null) ? false : true;
    }

    public static String r(me meVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar;
        ng fp = fp(meVar);
        return (fp == null || (xvVar = fp.f34793c) == null) ? "" : xvVar.bk();
    }

    public static int sr(me meVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar;
        ng fp = fp(meVar);
        if (fp == null || (xvVar = fp.f34793c) == null) {
            return 0;
        }
        return xvVar.xv();
    }

    public static com.bykv.vk.openvk.component.video.api.xv.xv t(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return null;
        }
        return fp.f34794w;
    }

    public static double ux(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            int w3 = ba.w(meVar);
            com.bytedance.sdk.openadsdk.ys.w.xv.w oo = meVar.oo();
            if (oo != null && oo.q() == 9) {
                w3 *= 2;
            }
            return w3;
        } else if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            return ((int) ys(meVar).f()) * (ys(meVar).r() + 1);
        } else {
            com.bykv.vk.openvk.component.video.api.xv.xv xvVar = fp.f34793c;
            if (xvVar == null) {
                return 0.0d;
            }
            return xvVar.f();
        }
    }

    public static String w(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return ba.ev(meVar);
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar = fp.f34793c;
        return xvVar == null ? "" : xvVar.k();
    }

    public static int xv(me meVar) {
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar;
        ng fp = fp(meVar);
        if (fp == null || (xvVar = fp.f34793c) == null) {
            return 0;
        }
        return xvVar.w();
    }

    public static com.bykv.vk.openvk.component.video.api.xv.c ys(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return null;
        }
        return fp.xv;
    }

    public void c(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.xv.xv xvVar = this.f34793c;
            if (xvVar != null) {
                jSONObject.put("video", xvVar.fz());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            com.bykv.vk.openvk.component.video.api.xv.xv xvVar2 = this.f34794w;
            if (xvVar2 != null) {
                jSONObject.put("h265_video", xvVar2.fz());
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        try {
            com.bykv.vk.openvk.component.video.api.xv.c cVar = this.xv;
            if (cVar != null) {
                jSONObject.put("audio", cVar.c());
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public ng(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        ng ngVar;
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.xv.xv xvVar = new com.bykv.vk.openvk.component.video.api.xv.xv();
            xvVar.w(optJSONObject.optInt("cover_height"));
            xvVar.xv(optJSONObject.optInt("cover_width"));
            xvVar.c(optJSONObject.optString("resolution"));
            str2 = "resolution";
            str3 = "cover_width";
            xvVar.c(optJSONObject.optLong("size"));
            xvVar.c(optJSONObject.optDouble("video_duration"));
            xvVar.w(optJSONObject.optString("cover_url"));
            xvVar.xv(optJSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL));
            xvVar.sr(optJSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
            xvVar.ux(optJSONObject.optString("file_hash"));
            str = "file_hash";
            xvVar.c((float) optJSONObject.optDouble("play_speed_ratio", -1.0d));
            xvVar.c(optJSONObject.optInt("fallback_endcard_judge", 0));
            xvVar.sr(optJSONObject.optInt("video_preload_size", 307200));
            xvVar.ux(optJSONObject.optInt("reward_video_cached_type", 0));
            xvVar.f(optJSONObject.optInt("execute_cached_type", 0));
            xvVar.w(optJSONObject.optDouble(CampaignEx.JSON_NATIVE_VIDEO_START, -1.0d));
            ngVar = this;
            str4 = "size";
            ngVar.f34793c = xvVar;
        } else {
            str = "file_hash";
            str2 = "resolution";
            str3 = "cover_width";
            str4 = "size";
            ngVar = this;
        }
        String str5 = str;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (optJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.xv.xv xvVar2 = new com.bykv.vk.openvk.component.video.api.xv.xv();
            xvVar2.w(optJSONObject2.optInt("cover_height"));
            xvVar2.xv(optJSONObject2.optInt(str3));
            xvVar2.c(optJSONObject2.optString(str2));
            xvVar2.c(optJSONObject2.optLong(str4));
            xvVar2.c(optJSONObject2.optDouble("video_duration"));
            xvVar2.w(optJSONObject2.optString("cover_url"));
            xvVar2.xv(optJSONObject2.optString(CampaignEx.JSON_KEY_VIDEO_URL));
            xvVar2.sr(optJSONObject2.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
            xvVar2.ux(optJSONObject2.optString(str5));
            xvVar2.c((float) optJSONObject2.optDouble("play_speed_ratio", -1.0d));
            xvVar2.c(optJSONObject2.optInt("fallback_endcard_judge", 0));
            xvVar2.sr(optJSONObject2.optInt("video_preload_size", 307200));
            xvVar2.ux(optJSONObject2.optInt("reward_video_cached_type", 0));
            xvVar2.f(optJSONObject2.optInt("execute_cached_type", 0));
            xvVar2.w(optJSONObject2.optDouble(CampaignEx.JSON_NATIVE_VIDEO_START, -1.0d));
            ngVar.f34794w = xvVar2;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("audio");
        if (optJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.xv.c cVar = new com.bykv.vk.openvk.component.video.api.xv.c();
            cVar.w(optJSONObject3.optString("audio_url"));
            cVar.c(optJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            cVar.w(optJSONObject3.optLong("audio_preload_size", -2147483648L));
            cVar.c(optJSONObject3.optLong(str4, -2147483648L));
            cVar.c(optJSONObject3.optString(str5));
            cVar.w(optJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            cVar.c(optJSONObject3.optDouble(CampaignEx.JSON_NATIVE_VIDEO_START, -1.0d));
            cVar.w(optJSONObject3.optInt("repeat_count", 0));
            ngVar.xv = cVar;
        }
    }

    public void c(com.bykv.vk.openvk.component.video.api.xv.xv xvVar) {
        this.f34793c = xvVar;
    }

    public static String c(me meVar) {
        ng fp = fp(meVar);
        if (fp == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return ba.r(meVar);
        }
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            return ys(meVar).ux();
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar = fp.f34793c;
        return xvVar == null ? "" : xvVar.a();
    }

    public static com.bykv.vk.openvk.component.video.api.xv.xv c(me meVar, int i4) {
        ng fp = fp(meVar);
        if (fp == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar = new com.bykv.vk.openvk.component.video.api.xv.xv();
        com.bykv.vk.openvk.component.video.api.xv.xv xvVar2 = fp.f34793c;
        if (xvVar2 != null) {
            xvVar.w(xvVar2.w());
            xvVar.xv(fp.f34793c.xv());
            xvVar.c(fp.f34793c.gd());
            xvVar.c(fp.f34793c.ux());
            xvVar.c(fp.f34793c.f());
            xvVar.w(fp.f34793c.k());
            xvVar.xv(fp.f34793c.a());
            xvVar.sr(fp.f34793c.bk());
            xvVar.ux(fp.f34793c.ys());
            xvVar.c(fp.f34793c.c());
            xvVar.sr(fp.f34793c.fp());
            xvVar.ux(fp.f34793c.ia());
            xvVar.f(fp.f34793c.s());
            xvVar.c(fp.f34793c.ev());
            xvVar.w(fp.f34793c.r());
        }
        boolean z3 = false;
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            xvVar.w(ba.ev(meVar));
            xvVar.xv(ba.r(meVar));
            xvVar.ux(com.bykv.vk.openvk.component.video.api.f.w.c(ba.r(meVar)));
            xvVar.c(-1L);
            xvVar.c(ba.w(meVar));
            xvVar.sr(0);
            xvVar.ux(1);
        }
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            xvVar.xv(fp.xv.ux());
            xvVar.ux(0);
            xvVar.sr(0);
            xvVar.ux(fp.xv.w());
            xvVar.c(fp.xv.xv());
            xvVar.w(fp.xv.sr());
            double f4 = fp.xv.f();
            double r3 = fp.xv.r() + 1;
            Double.isNaN(r3);
            xvVar.c(f4 * r3);
        }
        if (wx.ck(meVar)) {
            if (TextUtils.isEmpty(xvVar.a()) && i4 == 1) {
                z3 = true;
            }
            if (i4 != 2 ? z3 : true) {
                xvVar.xv(wx.z(meVar));
                xvVar.c(wx.ba(meVar));
            }
        }
        return xvVar;
    }

    public static com.bykv.vk.openvk.component.video.api.xv.sr c(int i4, me meVar, int i5) {
        String c4;
        if (meVar.ou() == 1 && !com.bytedance.sdk.openadsdk.core.eq.w()) {
            meVar.bm(0);
        }
        if (com.bytedance.sdk.openadsdk.n.gd.c(meVar)) {
            meVar.bm(0);
        }
        if (i4 == 1) {
            c4 = com.bytedance.sdk.openadsdk.n.ev.c(meVar.ou()).c();
        } else if (i4 == 2) {
            c4 = com.bytedance.sdk.openadsdk.n.ev.c(meVar.ou()).w();
        } else if (i4 != 3) {
            c4 = i4 != 4 ? "" : com.bytedance.sdk.openadsdk.n.ev.c(meVar.ou()).sr();
        } else {
            c4 = com.bytedance.sdk.openadsdk.n.ev.c(meVar.ou()).xv();
        }
        com.bykv.vk.openvk.component.video.api.xv.sr srVar = new com.bykv.vk.openvk.component.video.api.xv.sr(c4, c(meVar, i5), t(meVar), meVar.ou(), meVar.yn());
        srVar.c(meVar.sc());
        return srVar;
    }

    public static com.bykv.vk.openvk.component.video.api.xv.sr c(int i4, me meVar) {
        return c(i4, meVar, 0);
    }
}
