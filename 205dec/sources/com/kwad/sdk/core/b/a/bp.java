package com.kwad.sdk.core.b.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bp implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.posId = jSONObject.optLong("pos_Id");
        aVar.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.templateVersion = jSONObject.optString("template_version");
        if (JSONObject.NULL.toString().equals(aVar.templateVersion)) {
            aVar.templateVersion = "";
        }
        aVar.errorCode = jSONObject.optInt("error_code");
        aVar.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = aVar.creativeId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j4);
        }
        long j5 = aVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j5);
        }
        long j6 = aVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j6);
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_version", aVar.templateVersion);
        }
        int i4 = aVar.errorCode;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", i4);
        }
        String str3 = aVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", aVar.errorMsg);
        }
        return jSONObject;
    }
}
