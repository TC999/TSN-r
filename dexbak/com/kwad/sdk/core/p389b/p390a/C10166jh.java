package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.webview.tachikoma.p333a.C9225u;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10166jh implements InterfaceC10273d<C9225u.C9227b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9225u.C9227b c9227b, JSONObject jSONObject) {
        m26756a(c9227b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9225u.C9227b c9227b, JSONObject jSONObject) {
        return m26755b(c9227b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26756a(C9225u.C9227b c9227b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9227b.status = jSONObject.optInt("status");
        c9227b.errorCode = jSONObject.optInt("errorCode");
        c9227b.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(c9227b.errorMsg)) {
            c9227b.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26755b(C9225u.C9227b c9227b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9227b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9227b.errorCode;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "errorCode", i2);
        }
        String str = c9227b.errorMsg;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, c9227b.errorMsg);
        }
        return jSONObject;
    }
}
