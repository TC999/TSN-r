package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.js */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10177js implements InterfaceC10273d<AdMatrixInfo.StyleInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        m26734a(styleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        return m26733b(styleInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26734a(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(styleInfo.title)) {
            styleInfo.title = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26733b(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = styleInfo.title;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "title", styleInfo.title);
        }
        return jSONObject;
    }
}
