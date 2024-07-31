package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ka */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10186ka implements InterfaceC10273d<AdMatrixInfo.TemplateData> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        m26716a(templateData, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        return m26715b(templateData, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26716a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(templateData.data)) {
            templateData.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26715b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = templateData.templateShowTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "templateShowTime", j);
        }
        long j2 = templateData.templateDelayTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "templateDelayTime", j2);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }
}
