package com.amap.api.col.p0003l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseAAIDRequest.java */
/* renamed from: com.amap.api.col.3l.z4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class z4 extends l4 {

    /* renamed from: i  reason: collision with root package name */
    public Context f9583i;

    public z4(Context context) {
        this.f9583i = context;
        setConnectionTimeout(5000);
        setSoTimeout(5000);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(this.f9583i));
        String a4 = h4.a();
        String c4 = h4.c(this.f9583i, a4, q4.r(hashMap));
        hashMap.put("ts", a4);
        hashMap.put("scode", c4);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getURL() {
        return k4.a().h() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }
}
