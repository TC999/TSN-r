package com.amap.api.col.p047s;

import com.amap.api.col.p047s.AbstractC2044dz;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest.java */
/* renamed from: com.amap.api.col.s.f2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2055f2 extends AbstractC2054f1 {

    /* renamed from: m */
    private byte[] f6111m;

    /* renamed from: n */
    private String f6112n;

    public C2055f2(byte[] bArr, String str) {
        this.f6112n = "1";
        this.f6111m = (byte[]) bArr.clone();
        this.f6112n = str;
        m53063e(AbstractC2044dz.EnumC2045a.SINGLE);
        m53061g(AbstractC2044dz.EnumC2047c.HTTP);
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        String m52857t = C2079j1.m52857t(C2139s1.f6467b);
        byte[] m52862o = C2079j1.m52862o(C2139s1.f6466a);
        byte[] bArr = new byte[m52862o.length + 50];
        System.arraycopy(this.f6111m, 0, bArr, 0, 50);
        System.arraycopy(m52862o, 0, bArr, 50, m52862o.length);
        return String.format(m52857t, "1", this.f6112n, "1", "open", C2059g1.m52991b(bArr));
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: k */
    public final boolean mo53010k() {
        return false;
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
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f6111m.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        return this.f6111m;
    }
}
