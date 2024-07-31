package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hi */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10113hi implements InterfaceC10273d<C9092aq.C9094a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9092aq.C9094a c9094a, JSONObject jSONObject) {
        m26862a(c9094a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9092aq.C9094a c9094a, JSONObject jSONObject) {
        return m26861b(c9094a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26862a(C9092aq.C9094a c9094a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9094a.status = jSONObject.optInt("status");
        c9094a.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(c9094a.errorMsg)) {
            c9094a.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26861b(C9092aq.C9094a c9094a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9094a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9094a.errorMsg;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, c9094a.errorMsg);
        }
        return jSONObject;
    }
}
