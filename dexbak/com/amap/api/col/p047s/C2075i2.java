package com.amap.api.col.p047s;

import android.content.Context;
import io.netty.handler.codec.http.HttpHeaders;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PrivacyUploadRequest.java */
/* renamed from: com.amap.api.col.s.i2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2075i2 extends AbstractC2054f1 {

    /* renamed from: m */
    public JSONObject f6206m = null;

    /* renamed from: n */
    public Context f6207n = null;

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2048e1.m53039a().m53032h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: m */
    public final String mo52630m() {
        return "core";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public final Map<String, String> mo52199p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("X-INFO", C2016a1.m53274b(this.f6207n));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f6206m;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.f6206m.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String m52327i = C2199x0.m52327i(this.f6207n);
            stringBuffer.append("&key=".concat(String.valueOf(m52327i)));
            String m53275a = C2016a1.m53275a();
            stringBuffer.append("&ts=".concat(String.valueOf(m53275a)));
            stringBuffer.append("&scode=" + C2016a1.m53273c(this.f6207n, m53275a, "key=".concat(String.valueOf(m52327i))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
