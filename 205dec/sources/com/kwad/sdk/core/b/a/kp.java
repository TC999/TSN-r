package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kp implements com.kwad.sdk.core.d<d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        aVar.Sd = jSONObject.optLong("ad_info_uid");
        aVar.Vp = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(aVar.Vp)) {
            aVar.Vp = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.code;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i4);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "msg", aVar.msg);
        }
        String str2 = aVar.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, aVar.videoUrl);
        }
        long j4 = aVar.llsid;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j4);
        }
        long j5 = aVar.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j5);
        }
        long j6 = aVar.Sd;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j6);
        }
        String str3 = aVar.Vp;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", aVar.Vp);
        }
        return jSONObject;
    }
}
