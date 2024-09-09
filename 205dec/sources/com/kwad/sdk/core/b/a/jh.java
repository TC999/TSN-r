package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.a.u;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jh implements com.kwad.sdk.core.d<u.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.errorCode = jSONObject.optInt("errorCode");
        bVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(bVar.errorMsg)) {
            bVar.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        int i5 = bVar.errorCode;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i5);
        }
        String str = bVar.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", bVar.errorMsg);
        }
        return jSONObject;
    }
}
