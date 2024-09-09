package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fo implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        a2(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return b2(ipInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString("ip");
        if (JSONObject.NULL.toString().equals(ipInfo.ip)) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.ip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip", ipInfo.ip);
        }
        int i4 = ipInfo.weight;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weight", i4);
        }
        return jSONObject;
    }
}
