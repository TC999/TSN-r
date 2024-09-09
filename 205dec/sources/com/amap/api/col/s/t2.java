package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ADIURequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t2 extends dz {

    /* renamed from: m  reason: collision with root package name */
    private byte[] f10248m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, String> f10249n;

    public t2(byte[] bArr, Map<String, String> map) {
        this.f10248m = bArr;
        this.f10249n = map;
        e(dz.a.SINGLE);
        g(dz.c.HTTPS);
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return this.f10249n;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        return this.f10248m;
    }
}
