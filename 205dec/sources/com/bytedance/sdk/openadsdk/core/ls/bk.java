package com.bytedance.sdk.openadsdk.core.ls;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.yu;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<String, JSONObject> f33868c = new ConcurrentHashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static AtomicInteger f33869w = new AtomicInteger();
    private JSONObject sr;
    private JSONObject xv;

    private JSONObject w(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            me c4 = com.bytedance.sdk.openadsdk.core.video.sr.w.c(srVar);
            if (c4 != null) {
                String c5 = wv.c(c4, "");
                int parseInt = TextUtils.isEmpty(c5) ? 0 : Integer.parseInt(c5);
                int ev = wv.ev(c4);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.ux.w.c.c());
                JSONObject c6 = c();
                jSONObject.put("device", c6);
                JSONObject c7 = c(srVar, parseInt, ev);
                jSONObject.put("current_video", c7);
                jSONObject.put("predict_use", c(String.valueOf(parseInt)));
                jSONObject.put("csj_plugin", w());
                jSONObject.put("package", w("video_cache"));
                jSONObject.put("hour", c6.optInt("hour"));
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, srVar.a());
                jSONObject.put("rit", parseInt);
                jSONObject.put("preload_size", srVar.f());
                jSONObject.put("access", c6.optString("access"));
                jSONObject.put("sdk_fg_time", c6.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", c7.optInt("ad_slot_type"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private static String c(int i4, String str) {
        int incrementAndGet = f33869w.incrementAndGet();
        String xv = i.xv();
        return i4 + "-" + xv + "-" + incrementAndGet + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f33868c.get(str);
    }

    public static void c(int i4, long j4, me meVar, com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo;
        if (meVar == null || srVar == null || (oo = meVar.oo()) == null) {
            return;
        }
        try {
            JSONObject c4 = c(oo.f());
            if (c4 != null) {
                String ia = srVar.ia();
                String optString = c4.optString("trace_id");
                if (!TextUtils.isEmpty(optString) && optString.contains(ia)) {
                    com.bytedance.sdk.component.utils.a.w("pit_play", i4 + " " + j4);
                    c4.put("play_type", i4);
                    c4.put("cache_size", j4);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void c(long j4, me meVar, com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo;
        if (meVar == null || srVar == null || (oo = meVar.oo()) == null) {
            return;
        }
        try {
            JSONObject c4 = c(oo.f());
            if (c4 != null) {
                String optString = c4.optString("trace_id");
                if (!TextUtils.isEmpty(optString) && optString.contains(srVar.ia())) {
                    c4.put("play_duration", j4);
                    c4.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access", ys.r(ls.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long currentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.eq.c.f33205w;
            if (currentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", currentTimeMillis);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject w(final String str) {
        xv xvVar = (xv) AutoService.c(xv.class);
        if (xvVar != null) {
            xvVar.c(str, new r() { // from class: com.bytedance.sdk.openadsdk.core.ls.bk.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.bytedance.sdk.openadsdk.core.ls.r
                public ValueSet c(int i4, Result result) {
                    if (result == null) {
                        return null;
                    }
                    ValueSet values = result.values();
                    boolean isSuccess = result.isSuccess();
                    if (values != null && TextUtils.equals(str, values.stringValue(5))) {
                        if (!isSuccess) {
                            bk.this.sr = (JSONObject) values.objectValue(4, JSONObject.class);
                        } else {
                            bk.this.xv = (JSONObject) values.objectValue(3, JSONObject.class);
                            com.bytedance.sdk.component.utils.a.c("pit_pack", bk.this.xv);
                        }
                    }
                    return super.c(i4, result);
                }
            });
        } else {
            this.xv = new JSONObject();
        }
        return this.xv;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", eq.f33190w);
            jSONObject.put("core_plugin_code", 6106);
            jSONObject.put("ext_api_code", eq.sr);
            jSONObject.put("ext_plugin_code", yu.w());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, srVar.a());
            jSONObject.put("preload_size", srVar.f());
            jSONObject.put("video_duration", srVar.gb().f());
            jSONObject.put("ad_slot_type", i5);
            jSONObject.put("rit", i4);
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, srVar.fp());
            jSONObject.put("preload_all", srVar.bk());
            jSONObject.put("trace_id", c(i4, srVar.ia()));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, JSONObject jSONObject, int i4, int i5) {
        int optInt;
        if (srVar == null || jSONObject == null || (optInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        f33868c.put(String.valueOf(optInt), jSONObject);
    }

    public JSONObject c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        return w(srVar);
    }
}
