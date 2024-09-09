package com.amap.api.col.p0003l;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: PrivacyUploadRequest.java */
/* renamed from: com.amap.api.col.3l.b6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b6 extends l4 {

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7262i = null;

    /* renamed from: j  reason: collision with root package name */
    public Context f7263j = null;

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f7262i;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.f7262i.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String j4 = e4.j(this.f7263j);
            stringBuffer.append("&key=".concat(String.valueOf(j4)));
            String a4 = h4.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a4)));
            stringBuffer.append("&scode=" + h4.c(this.f7263j, a4, "key=".concat(String.valueOf(j4))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("X-INFO", h4.i(this.f7263j));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return k4.a().h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
