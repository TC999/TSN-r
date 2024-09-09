package com.amap.api.col.s;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseAAIDRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class r1 extends f1 {

    /* renamed from: m  reason: collision with root package name */
    public Context f10146m;

    public r1(Context context) {
        this.f10146m = context;
        d(5000);
        j(5000);
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return e1.a().h() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        HashMap hashMap = new HashMap();
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, x0.i(this.f10146m));
        String a4 = a1.a();
        String c4 = a1.c(this.f10146m, a4, j1.r(hashMap));
        hashMap.put("ts", a4);
        hashMap.put("scode", c4);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
