package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.AbstractC1840if;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.o6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ADIURequest extends AbstractC1840if {

    /* renamed from: i */
    private byte[] f4805i;

    /* renamed from: j */
    private Map<String, String> f4806j;

    public ADIURequest(byte[] bArr, Map<String, String> map) {
        this.f4805i = bArr;
        this.f4806j = map;
        setDegradeAbility(AbstractC1840if.EnumC1841a.SINGLE);
        setHttpProtocol(AbstractC1840if.EnumC1843c.HTTPS);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        return this.f4805i;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return this.f4806j;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
