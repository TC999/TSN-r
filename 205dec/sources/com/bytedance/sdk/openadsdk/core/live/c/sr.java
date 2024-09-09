package com.bytedance.sdk.openadsdk.core.live.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {
    private String w(me meVar, Map<String, Object> map) {
        if (meVar == null) {
            return "";
        }
        Map<String, String> c4 = c(meVar, map);
        try {
            Uri c5 = com.bytedance.sdk.openadsdk.core.live.sr.c(Uri.parse("sslocal://webcast_room"), c4);
            a.xv("TTLiveSDkBridge", "link: " + c5.toString());
            return c5.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            a.f("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int b_(me meVar) {
        if (this.f33848c != null) {
            long w3 = w(meVar);
            if (w3 == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", w3);
                Object call = this.f33848c.call(3, b.a().e(0, 2).h(1, bundle).l(), Object.class);
                if (call != null && (call instanceof Integer)) {
                    return ((Integer) call).intValue();
                }
            } catch (Throwable th) {
                a.xv("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int sr() {
        Bridge bridge = this.f33848c;
        boolean z3 = false;
        if (bridge != null) {
            try {
                Object call = bridge.call(3, b.a().e(0, 3).l(), Object.class);
                if (call != null && (call instanceof Boolean)) {
                    z3 = ((Boolean) call).booleanValue();
                }
            } catch (Throwable th) {
                a.xv("TTLiveSDkBridge", th);
            }
        }
        return z3 ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public String ux() {
        Bridge bridge = this.f33848c;
        if (bridge != null) {
            try {
                Object call = bridge.call(3, b.a().e(0, 4).l(), Object.class);
                if (call == null || !(call instanceof String)) {
                    return null;
                }
                return (String) call;
            } catch (Throwable th) {
                a.xv("TTLiveSDkBridge", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int w(Context context, me meVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int xv(me meVar) {
        Object call;
        if (meVar == null || TextUtils.isEmpty(meVar.xk()) || this.f33848c == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", meVar.xk());
            call = this.f33848c.call(3, b.a().e(0, 5).h(1, bundle).l(), Object.class);
        } catch (Throwable unused) {
        }
        if (call == null) {
            return 4;
        }
        if (call instanceof Integer) {
            return ((Integer) call).intValue();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void xv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int c(Context context, me meVar, Map<String, Object> map) {
        String str;
        if (context == null || meVar == null) {
            return -1;
        }
        if (!a_(meVar)) {
            a.xv("TTLiveSDkBridge", "mata has not le property");
            return -1;
        }
        Bridge bridge = this.f33848c;
        if (bridge != null) {
            int intValue = ((Integer) bridge.call(0, b.a().i(0, w(meVar, map)).l(), Integer.class)).intValue();
            meVar.ng(intValue);
            if (intValue == 0 && com.bytedance.sdk.openadsdk.core.live.xv.c.c(context, meVar, false)) {
                String str2 = "";
                if (map != null) {
                    try {
                        str2 = (String) map.get("event_tag");
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                new com.bytedance.sdk.openadsdk.core.live.xv.c().c(str2).c(context, meVar);
            }
            com.bytedance.sdk.openadsdk.core.fz.a.c().w(intValue, meVar);
            if (intValue == 0) {
                str = "le openliv succ";
            } else {
                str = "callR: " + intValue;
            }
            a.xv("TTLiveSDkBridge", str);
            return intValue;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, me meVar, long j4) {
        try {
            if (this.f33848c == null) {
                return;
            }
            Map<String, String> c4 = c(meVar, (Map<String, Object>) null);
            Map<String, String> c5 = com.bytedance.sdk.openadsdk.core.video.xv.c.c(ls.getContext());
            c5.put("room_id", c4.get("room_id"));
            c5.put("anchor_id", c4.get("owner_open_id"));
            c5.put("enter_from_merge", c4.get("enter_from_merge"));
            c5.put("enter_method", c4.get("enter_method"));
            c5.put("action_type", "click");
            c5.put(ConstantAd.KEY_CACHE_AD, c4.get(ConstantAd.KEY_CACHE_AD));
            c5.put("duration", j4 + "");
            c5.put("is_other_channel", "union_ad");
            c5.put("IESLiveEffectAdTrackExtraServiceKey", c4.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : c5.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.f33848c.call(4, b.a().i(0, str).h(1, jSONObject).l(), Void.class);
        } catch (Throwable th) {
            if (a.xv()) {
                a.xv("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    public Map<String, String> c(me meVar, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (meVar == null) {
            return hashMap;
        }
        hashMap.put("room_id", meVar.yw());
        if (this.f33848c != null) {
            int ev = wv.ev(meVar);
            hashMap.put("enter_from_merge", (String) this.f33848c.call(1, b.a().e(0, ev).l(), String.class));
            hashMap.put("enter_method", (String) this.f33848c.call(2, b.a().e(0, ev).j(1, com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)).l(), String.class));
        }
        hashMap.put("host", "aweme");
        hashMap.put("is_other_channel", "union_ad");
        String c4 = c(meVar, meVar.ho(), map);
        if (!TextUtils.isEmpty(c4)) {
            hashMap.put("ecom_live_params", c4);
        }
        ys qu = meVar.qu();
        if (qu != null && !TextUtils.isEmpty(qu.c())) {
            try {
                Uri parse = Uri.parse(qu.c());
                JSONObject jSONObject = new JSONObject(parse.getQueryParameter("ad_data_params"));
                String optString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "source"));
                    jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", k.sr().ev());
                    jSONObject3.put("ad_event_live_type", "1");
                    hashMap.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String optString2 = jSONObject.optString(BidResponsedEx.KEY_CID);
                jSONObject2.put("creativeID", optString2);
                hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, optString2);
                hashMap.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String c5 = com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "owner_open_id");
                if (TextUtils.isEmpty(c5)) {
                    c5 = com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "user_id");
                }
                hashMap.put("owner_open_id", c5);
                String c6 = com.bytedance.sdk.openadsdk.core.live.sr.c(parse, "pangle_live_room_data");
                if (!TextUtils.isEmpty(c6)) {
                    hashMap.put("pangle_live_room_data", c6);
                }
                hashMap.put(ConstantAd.KEY_CACHE_AD, com.bytedance.sdk.openadsdk.core.live.sr.c(parse, ConstantAd.KEY_CACHE_AD));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public int w() {
        Bridge bridge = this.f33848c;
        if (bridge != null) {
            try {
                Object call = bridge.call(3, b.a().e(0, 1).l(), Object.class);
                if (call != null && (call instanceof Integer)) {
                    return ((Integer) call).intValue();
                }
            } catch (Throwable th) {
                a.xv("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(me meVar, String str, int i4) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, str, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.xv
    public boolean c(me meVar) {
        return a_(meVar) && this.f33848c != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c(final String str, final me meVar, final long j4) {
        com.bytedance.sdk.openadsdk.n.f.w(new p("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.c.sr.1
            @Override // java.lang.Runnable
            public void run() {
                sr.this.w(str, meVar, j4);
            }
        });
    }
}
