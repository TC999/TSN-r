package com.amap.api.col.p0463l;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2594an;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.y4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseAAIDRequest extends IPV6Request {

    /* renamed from: i */
    public Context f5786i;

    public BaseAAIDRequest(Context context) {
        this.f5786i = context;
        setConnectionTimeout(5000);
        setSoTimeout(5000);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5786i));
        String m54933a = ClientInfo.m54933a();
        String m54931c = ClientInfo.m54931c(this.f5786i, m54933a, C1925p4.m54186r(hashMap));
        hashMap.put("ts", m54933a);
        hashMap.put("scode", m54931c);
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", C2594an.f8583d);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public String getURL() {
        return HttpsDecisionUtil.m54673a().m54666h() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }
}
