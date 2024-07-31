package com.mbridge.msdk.videocommon.p513b;

import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.b.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class AdParams {

    /* renamed from: a */
    private String f32190a;

    /* renamed from: b */
    private String f32191b;

    private AdParams(String str, String str2) {
        this.f32190a = str;
        this.f32191b = str2;
    }

    /* renamed from: a */
    public static AdParams m20879a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return new AdParams(jSONObject.optString("appId"), jSONObject.optString("placementId"));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
