package com.kwad.sdk.core.p389b.p390a;

import com.baidu.mobads.sdk.internal.C2573a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.do */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10011do implements InterfaceC10273d<AdStyleInfo.ExposeTagInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        m27060a(exposeTagInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        return m27059b(exposeTagInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27060a(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        exposeTagInfo.text = jSONObject.optString(C2573a.f8443b);
        if (JSONObject.NULL.toString().equals(exposeTagInfo.text)) {
            exposeTagInfo.text = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27059b(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = exposeTagInfo.text;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, C2573a.f8443b, exposeTagInfo.text);
        }
        return jSONObject;
    }
}
