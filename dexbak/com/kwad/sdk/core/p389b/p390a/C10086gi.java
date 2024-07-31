package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gi */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10086gi implements InterfaceC10273d<AdMatrixInfo.MatrixTag> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        m26916a(matrixTag, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        return m26915b(matrixTag, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26916a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTag.styleId = jSONObject.optInt("styleId");
        matrixTag.type = jSONObject.optString("type");
        if (JSONObject.NULL.toString().equals(matrixTag.type)) {
            matrixTag.type = "";
        }
        matrixTag.isHide = jSONObject.optBoolean("isHide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26915b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = matrixTag.styleId;
        if (i != 0) {
            C11126t.putValue(jSONObject, "styleId", i);
        }
        String str = matrixTag.type;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "type", matrixTag.type);
        }
        boolean z = matrixTag.isHide;
        if (z) {
            C11126t.putValue(jSONObject, "isHide", z);
        }
        return jSONObject;
    }
}
