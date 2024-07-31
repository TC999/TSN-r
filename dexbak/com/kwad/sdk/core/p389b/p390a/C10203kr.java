package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10203kr implements InterfaceC10273d<C9263x> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9263x c9263x, JSONObject jSONObject) {
        m26682a(c9263x, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9263x c9263x, JSONObject jSONObject) {
        return m26681b(c9263x, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26682a(C9263x c9263x, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9263x.aaw = jSONObject.optString("status");
        if (JSONObject.NULL.toString().equals(c9263x.aaw)) {
            c9263x.aaw = "";
        }
        c9263x.errorCode = jSONObject.optInt("errorCode");
        c9263x.errorReason = jSONObject.optString("errorReason");
        if (JSONObject.NULL.toString().equals(c9263x.errorReason)) {
            c9263x.errorReason = "";
        }
        c9263x.f29320nE = jSONObject.optInt("currentTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26681b(C9263x c9263x, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9263x.aaw;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "status", c9263x.aaw);
        }
        int i = c9263x.errorCode;
        if (i != 0) {
            C11126t.putValue(jSONObject, "errorCode", i);
        }
        String str2 = c9263x.errorReason;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "errorReason", c9263x.errorReason);
        }
        int i2 = c9263x.f29320nE;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "currentTime", i2);
        }
        return jSONObject;
    }
}
