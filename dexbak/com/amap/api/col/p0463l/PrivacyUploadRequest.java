package com.amap.api.col.p0463l;

import android.content.Context;
import io.netty.handler.codec.http.HttpHeaders;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.a6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class PrivacyUploadRequest extends IPV6Request {

    /* renamed from: i */
    public JSONObject f3552i = null;

    /* renamed from: j */
    public Context f3553j = null;

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f3552i;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.f3552i.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String m55240j = C1780e4.m55240j(this.f3553j);
            stringBuffer.append("&key=".concat(String.valueOf(m55240j)));
            String m54933a = ClientInfo.m54933a();
            stringBuffer.append("&ts=".concat(String.valueOf(m54933a)));
            stringBuffer.append("&scode=" + ClientInfo.m54931c(this.f3553j, m54933a, "key=".concat(String.valueOf(m55240j))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("X-INFO", ClientInfo.m54925i(this.f3553j));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return HttpsDecisionUtil.m54673a().m54666h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
