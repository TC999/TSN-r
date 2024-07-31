package com.amap.api.col.p0463l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.x1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CustomStyleTextureRequest extends AbstractBasicHandler<String, C1982a> {

    /* compiled from: CustomStyleTextureRequest.java */
    /* renamed from: com.amap.api.col.3l.x1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1982a {

        /* renamed from: a */
        public byte[] f5656a;

        /* renamed from: b */
        public int f5657b = -1;
    }

    public CustomStyleTextureRequest(Context context, String str) {
        super(context, str);
        this.f5674p = "/map/styles";
    }

    /* renamed from: p */
    private static C1982a m53561p(byte[] bArr) throws AMapException {
        C1982a c1982a = new C1982a();
        c1982a.f5656a = bArr;
        return c1982a;
    }

    /* renamed from: b */
    public final void m53562b(String str) {
        this.f5674p = str;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: e */
    protected final /* bridge */ /* synthetic */ C1982a mo53402e(String str) throws AMapException {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: f */
    protected final /* synthetic */ C1982a mo53538f(byte[] bArr) throws AMapException {
        return m53561p(bArr);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return C1732a3.m55685y(getURL());
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(this.f5673k));
        hashMap.put("output", "bin");
        String m54933a = ClientInfo.m54933a();
        String m54931c = ClientInfo.m54931c(this.f5673k, m54933a, C1925p4.m54186r(hashMap));
        hashMap.put("ts", m54933a);
        hashMap.put("scode", m54931c);
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return this.f5674p;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: m */
    protected final String mo53401m() {
        return null;
    }
}
