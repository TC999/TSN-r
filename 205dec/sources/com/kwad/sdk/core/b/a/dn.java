package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dn implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aGf = jSONObject.optInt("funcSwitch");
        bVar.aGg = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.aGg)) {
            bVar.aGg = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aGh = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.aGh)) {
            bVar.aGh = "";
        }
        bVar.aGi = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.aGi)) {
            bVar.aGi = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aGj = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.aGj)) {
            bVar.aGj = "";
        }
        bVar.aGk = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.aGk)) {
            bVar.aGk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.aGf;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", i4);
        }
        String str = bVar.aGg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minSdkVersion", bVar.aGg);
        }
        int i5 = bVar.sdkType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i5);
        }
        String str2 = bVar.aGh;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V7", bVar.aGh);
        }
        String str3 = bVar.aGi;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V8", bVar.aGi);
        }
        String str4 = bVar.version;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str5 = bVar.aGj;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v7Url", bVar.aGj);
        }
        String str6 = bVar.aGk;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v8Url", bVar.aGk);
        }
        return jSONObject;
    }
}
