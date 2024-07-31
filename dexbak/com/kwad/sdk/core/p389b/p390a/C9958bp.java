package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9958bp implements InterfaceC10273d<AbstractC9822a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AbstractC9822a abstractC9822a, JSONObject jSONObject) {
        m27158a(abstractC9822a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AbstractC9822a abstractC9822a, JSONObject jSONObject) {
        return m27157b(abstractC9822a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27158a(AbstractC9822a abstractC9822a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        abstractC9822a.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        abstractC9822a.llsid = jSONObject.optLong("llsid");
        abstractC9822a.posId = jSONObject.optLong("pos_Id");
        abstractC9822a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(abstractC9822a.templateId)) {
            abstractC9822a.templateId = "";
        }
        abstractC9822a.templateVersion = jSONObject.optString("template_version");
        if (JSONObject.NULL.toString().equals(abstractC9822a.templateVersion)) {
            abstractC9822a.templateVersion = "";
        }
        abstractC9822a.errorCode = jSONObject.optInt("error_code");
        abstractC9822a.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(abstractC9822a.errorMsg)) {
            abstractC9822a.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27157b(AbstractC9822a abstractC9822a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = abstractC9822a.creativeId;
        if (j != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j);
        }
        long j2 = abstractC9822a.llsid;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "llsid", j2);
        }
        long j3 = abstractC9822a.posId;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "pos_Id", j3);
        }
        String str = abstractC9822a.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "template_id", abstractC9822a.templateId);
        }
        String str2 = abstractC9822a.templateVersion;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "template_version", abstractC9822a.templateVersion);
        }
        int i = abstractC9822a.errorCode;
        if (i != 0) {
            C11126t.putValue(jSONObject, "error_code", i);
        }
        String str3 = abstractC9822a.errorMsg;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "error_msg", abstractC9822a.errorMsg);
        }
        return jSONObject;
    }
}
