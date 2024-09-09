package com.bytedance.sdk.openadsdk.core.nativeexpress.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static JSONObject c(float f4, float f5, boolean z3, me meVar) {
        String str;
        String str2;
        com.bytedance.sdk.component.adexpress.c.xv.w c4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f4);
            jSONObject2.put("height", f5);
            if (z3) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", c(false, meVar));
            if (meVar.rh() != null) {
                str = meVar.rh().ux();
                str2 = meVar.rh().f();
            } else {
                str = null;
                str2 = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = (meVar.rh() == null || (c4 = com.bytedance.sdk.component.adexpress.c.w.w.c(meVar.rh().w())) == null) ? null : c4.ux();
            }
            jSONObject.put("template_Plugin", str);
            jSONObject.put("diff_template_Plugin", str2);
            jSONObject.put("dynamic_configs", meVar.my());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject sr(me meVar) {
        JSONObject jSONObject = new JSONObject();
        if (meVar != null && com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            try {
                jSONObject.put("live_show_time", ba.w(meVar));
                jSONObject.put("live_author_nickname", ba.xv(meVar));
                if (ba.sr(meVar) > 0) {
                    jSONObject.put("live_author_follower_count", ba.sr(meVar));
                }
                if (ba.ux(meVar) > 0) {
                    jSONObject.put("live_watch_count", ba.ux(meVar));
                }
                jSONObject.put("live_description", ba.f(meVar));
                jSONObject.put("live_feed_url", ba.r(meVar));
                jSONObject.put("live_cover_image_url", ba.ev(meVar));
                jSONObject.put("live_avatar_url", ba.gd(meVar));
                jSONObject.put("live_cover_image_width", ba.a(meVar));
                jSONObject.put("live_cover_image_height", ba.bk(meVar));
                jSONObject.put("live_avatar_width", ba.p(meVar));
                jSONObject.put("live_avatar_height", ba.k(meVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject w(float f4, float f5, boolean z3, me meVar) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f4);
            jSONObject2.put("height", f5);
            if (z3) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", c(true, meVar));
            String str3 = null;
            if (meVar.qy() != null) {
                str = meVar.qy().ux();
                str2 = meVar.qy().f();
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str)) {
                str3 = str;
            } else if (meVar.qy() != null && com.bytedance.sdk.component.adexpress.c.w.w.w(meVar.qy().w()) != null) {
                str3 = com.bytedance.sdk.component.adexpress.c.w.w.w(meVar.qy().w()).ux();
            }
            jSONObject.put("template_Plugin", str3);
            jSONObject.put("diff_template_Plugin", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static Map<String, String> xv(me meVar) {
        HashMap hashMap = null;
        if (meVar == null) {
            return null;
        }
        List<gb> nc = meVar.nc();
        if (nc != null && nc.size() > 0) {
            hashMap = new HashMap();
            for (gb gbVar : nc) {
                if (gbVar != null) {
                    hashMap.put(gbVar.c(), gbVar.r());
                }
            }
        }
        return hashMap;
    }

    public static String w(me meVar) {
        if (meVar == null || meVar.rh() == null) {
            return null;
        }
        return meVar.rh().w();
    }

    public static JSONObject c(boolean z3, me meVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", meVar.dk());
            if (meVar.kr() != null) {
                jSONObject.put(RewardPlus.ICON, meVar.kr().c());
            }
            JSONArray jSONArray = new JSONArray();
            if (meVar.nc() != null) {
                for (int i4 = 0; i4 < meVar.nc().size(); i4++) {
                    gb gbVar = meVar.nc().get(i4);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", gbVar.xv());
                    jSONObject2.put("width", gbVar.w());
                    jSONObject2.put("url", gbVar.c());
                    jSONObject2.put("image_key", gbVar.r());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", meVar.tz());
            jSONObject.put("interaction_type", meVar.v());
            jSONObject.put("is_compliance_template", c(meVar));
            jSONObject.put("title", meVar.ny());
            jSONObject.put("description", meVar.ju());
            jSONObject.put("source", meVar.yh());
            if (meVar.ix() != null) {
                jSONObject.put("comment_num", meVar.ix().f());
                jSONObject.put("score", meVar.ix().ux());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, meVar.ix().r());
                jSONObject.put("app", meVar.ix().ev());
            }
            if (ng.bk(meVar) != null) {
                JSONObject fz = ng.a(meVar).fz();
                if (meVar.ab() == 2 && ng.ux(meVar) > 60.0d) {
                    fz.put("video_duration", 60);
                }
                jSONObject.put("video", fz);
            }
            if (m.ia(meVar)) {
                jSONObject.put("reward_full_play_time", m.ys(meVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            if (z3) {
                if (meVar.qy() != null) {
                    jSONObject.put("dynamic_creative", meVar.qy().r());
                }
            } else if (meVar.rh() != null) {
                jSONObject.put("dynamic_creative", meVar.rh().r());
            }
            jSONObject.put("live_ad", sr(meVar));
            c(meVar, jSONObject);
            if (TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(meVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", meVar.ez());
            jSONObject.put("can_show_interactive", meVar.jg());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void c(me meVar, JSONObject jSONObject) {
        if (wv.ev(meVar) == 7 && bw.c(meVar)) {
            meVar.hl().c(jSONObject);
        }
    }

    public static boolean c(me meVar) {
        return meVar != null && ia.p(meVar) == 2;
    }

    public static String c(me meVar, String str) {
        List<gb> nc;
        if (meVar != null && (nc = meVar.nc()) != null && nc.size() > 0) {
            for (gb gbVar : nc) {
                if (gbVar != null && TextUtils.equals(str, gbVar.c())) {
                    return gbVar.r();
                }
            }
        }
        return null;
    }
}
