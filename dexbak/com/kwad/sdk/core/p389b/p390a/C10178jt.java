package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10178jt implements InterfaceC10273d<AdMatrixInfo.Styles> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        m26732a(styles, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        return m26731b(styles, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26732a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templates");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(optJSONArray.optJSONObject(i));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26731b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }
}
