package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.AbstractC1840if;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.r5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LogUpdateRequest extends IPV6Request {

    /* renamed from: i */
    private byte[] f5176i;

    /* renamed from: j */
    private String f5177j;

    public LogUpdateRequest(byte[] bArr, String str) {
        this.f5177j = "1";
        this.f5176i = (byte[]) bArr.clone();
        this.f5177j = str;
        setDegradeAbility(AbstractC1840if.EnumC1841a.SINGLE);
        setHttpProtocol(AbstractC1840if.EnumC1843c.HTTP);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        return this.f5176i;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f5176i.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        String m54183u = C1925p4.m54183u(ConstConfig.f3918b);
        byte[] m54189o = C1925p4.m54189o(ConstConfig.f3917a);
        byte[] bArr = new byte[m54189o.length + 50];
        System.arraycopy(this.f5176i, 0, bArr, 0, 50);
        System.arraycopy(m54189o, 0, bArr, 50, m54189o.length);
        return String.format(m54183u, "1", this.f5177j, "1", "open", C1849l4.m54585b(bArr));
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final boolean isHostToIP() {
        return false;
    }
}
