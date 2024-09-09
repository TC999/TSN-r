package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LogUpdateRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f2 extends f1 {

    /* renamed from: m  reason: collision with root package name */
    private byte[] f9839m;

    /* renamed from: n  reason: collision with root package name */
    private String f9840n;

    public f2(byte[] bArr, String str) {
        this.f9840n = "1";
        this.f9839m = (byte[]) bArr.clone();
        this.f9840n = str;
        e(dz.a.SINGLE);
        g(dz.c.HTTP);
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String t3 = j1.t(s1.f10195b);
        byte[] o4 = j1.o(s1.f10194a);
        byte[] bArr = new byte[o4.length + 50];
        System.arraycopy(this.f9839m, 0, bArr, 0, 50);
        System.arraycopy(o4, 0, bArr, 50, o4.length);
        return String.format(t3, "1", this.f9840n, "1", "open", g1.b(bArr));
    }

    @Override // com.amap.api.col.s.dz
    public final boolean k() {
        return false;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f9839m.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        return this.f9839m;
    }
}
