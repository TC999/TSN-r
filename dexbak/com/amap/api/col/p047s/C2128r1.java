package com.amap.api.col.p047s;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2594an;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseAAIDRequest.java */
/* renamed from: com.amap.api.col.s.r1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2128r1 extends AbstractC2054f1 {

    /* renamed from: m */
    public Context f6418m;

    public C2128r1(Context context) {
        this.f6418m = context;
        m53064d(5000);
        m53059j(5000);
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2048e1.m53039a().m53032h() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: m */
    public final String mo52630m() {
        return "core";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        HashMap hashMap = new HashMap();
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, C2199x0.m52327i(this.f6418m));
        String m53275a = C2016a1.m53275a();
        String m53273c = C2016a1.m53273c(this.f6418m, m53275a, C2079j1.m52859r(hashMap));
        hashMap.put("ts", m53275a);
        hashMap.put("scode", m53273c);
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public final Map<String, String> mo52199p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", C2594an.f8583d);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
