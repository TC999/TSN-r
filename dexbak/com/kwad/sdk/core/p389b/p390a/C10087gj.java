package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10087gj implements InterfaceC10273d<AdMatrixInfo.MatrixTemplate> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        m26914a(matrixTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        return m26913b(matrixTemplate, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26914a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTemplate.templateUrl = jSONObject.optString("templateUrl");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateUrl)) {
            matrixTemplate.templateUrl = "";
        }
        matrixTemplate.templateVersion = jSONObject.optString("templateVersion");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateVersion)) {
            matrixTemplate.templateVersion = "";
        }
        matrixTemplate.templateVersionCode = jSONObject.optLong("templateVersionCode");
        matrixTemplate.templateMd5 = jSONObject.optString("templateMd5");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateMd5)) {
            matrixTemplate.templateMd5 = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26913b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = matrixTemplate.templateUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        }
        String str2 = matrixTemplate.templateVersion;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        }
        long j = matrixTemplate.templateVersionCode;
        if (j != 0) {
            C11126t.putValue(jSONObject, "templateVersionCode", j);
        }
        String str3 = matrixTemplate.templateMd5;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        }
        return jSONObject;
    }
}
