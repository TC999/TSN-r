package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.k;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jm implements com.kwad.sdk.core.d<k.a.C0718a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a.C0718a c0718a, JSONObject jSONObject) {
        a2(c0718a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a.C0718a c0718a, JSONObject jSONObject) {
        return b2(c0718a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(k.a.C0718a c0718a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0718a.aTs = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0718a.aTs)) {
            c0718a.aTs = "";
        }
        c0718a.aTt = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0718a.aTt)) {
            c0718a.aTt = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.a.C0718a c0718a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0718a.aTs;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_cn", c0718a.aTs);
        }
        String str2 = c0718a.aTt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_mn", c0718a.aTt);
        }
        return jSONObject;
    }
}
