package com.amap.api.col.s;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PrivacyUploadRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i2 extends f1 {

    /* renamed from: m  reason: collision with root package name */
    public JSONObject f9934m = null;

    /* renamed from: n  reason: collision with root package name */
    public Context f9935n = null;

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return e1.a().h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("X-INFO", a1.b(this.f9935n));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f9934m;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.f9934m.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String i4 = x0.i(this.f9935n);
            stringBuffer.append("&key=".concat(String.valueOf(i4)));
            String a4 = a1.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a4)));
            stringBuffer.append("&scode=" + a1.c(this.f9935n, a4, "key=".concat(String.valueOf(i4))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
