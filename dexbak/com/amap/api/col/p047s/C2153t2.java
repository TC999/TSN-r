package com.amap.api.col.p047s;

import com.amap.api.col.p047s.AbstractC2044dz;
import java.util.Map;

/* compiled from: ADIURequest.java */
/* renamed from: com.amap.api.col.s.t2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2153t2 extends AbstractC2044dz {

    /* renamed from: m */
    private byte[] f6520m;

    /* renamed from: n */
    private Map<String, String> f6521n;

    public C2153t2(byte[] bArr, Map<String, String> map) {
        this.f6520m = bArr;
        this.f6521n = map;
        m53063e(AbstractC2044dz.EnumC2045a.SINGLE);
        m53061g(AbstractC2044dz.EnumC2047c.HTTPS);
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        return this.f6521n;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public final Map<String, String> mo52199p() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        return this.f6520m;
    }
}
