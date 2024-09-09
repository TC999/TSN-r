package com.qq.e.comm.plugin.nativeadunified;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeUnifiedADAppMiitInfo a(com.qq.e.comm.plugin.g0.b bVar) {
        com.qq.e.comm.plugin.g0.a b4;
        if (bVar == null || (b4 = bVar.b()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", b4.a());
            jSONObject.put("author_name", b4.b());
            jSONObject.put("package_size", b4.e());
            jSONObject.put("permission_url", b4.f());
            jSONObject.put("privacy_agreement", b4.g());
            jSONObject.put("version_name", b4.i());
            jSONObject.put("description_url", b4.c());
            jSONObject.put("icp_number", b4.d());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.SUITABLE_AGE, b4.h());
        } catch (JSONException unused) {
        }
        return new NativeUnifiedADAppInfoImpl(jSONObject);
    }
}
