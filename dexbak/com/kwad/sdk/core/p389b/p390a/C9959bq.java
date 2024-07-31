package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9959bq implements InterfaceC10273d<AdMatrixInfo.BaseMatrixTemplate> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        m27156a(baseMatrixTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        return m27155b(baseMatrixTemplate, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27156a(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseMatrixTemplate.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(baseMatrixTemplate.templateId)) {
            baseMatrixTemplate.templateId = "";
        }
        baseMatrixTemplate.renderType = jSONObject.optInt("renderType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27155b(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = baseMatrixTemplate.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateId", baseMatrixTemplate.templateId);
        }
        int i = baseMatrixTemplate.renderType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "renderType", i);
        }
        return jSONObject;
    }
}
