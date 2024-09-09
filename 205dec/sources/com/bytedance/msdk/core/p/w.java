package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    private static volatile w sr;
    protected final Map<String, String> xv;

    private w() {
        super("label_v_v_s_3");
        this.xv = new ConcurrentHashMap();
        w();
    }

    public static w sr() {
        if (sr == null) {
            synchronized (w.class) {
                if (sr == null) {
                    sr = new w();
                }
            }
        }
        return sr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, int i4, double d4) {
        if (!com.bytedance.msdk.core.c.w().gw() || TextUtils.isEmpty(str)) {
            return;
        }
        c(3, str, i4, d4);
    }

    @Override // com.bytedance.msdk.core.p.c
    protected boolean w(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", c(obj != null ? (com.bytedance.msdk.core.k.sr) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.c.w().vc()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("ecpm", map.get("ecpm"));
            jSONObject3.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME, map.get(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME));
            return true;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.c.w().gw() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3\uff0ccpmKey:" + str + "\uff0ctype_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.xv.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected Map<String, String> c() {
        return this.xv;
    }

    @Override // com.bytedance.msdk.core.p.c
    protected void c(String str, int i4, String str2) {
        if (i4 == 3) {
            this.xv.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.p.c
    protected JSONObject c(com.bytedance.msdk.core.k.sr srVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", srVar != null ? srVar.c() : "-1");
            jSONObject.putOpt("label_id", srVar != null ? Integer.valueOf(srVar.xv()) : "-1");
            jSONObject.putOpt("label_version", srVar != null ? srVar.sr() : "-1");
            return jSONObject;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
