package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import java.net.URLConnection;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ADIURequest.java */
/* renamed from: com.amap.api.col.3l.p6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p6 extends Cif {

    /* renamed from: i  reason: collision with root package name */
    private byte[] f8644i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, String> f8645j;

    /* compiled from: BaseNetManager.java */
    /* renamed from: com.amap.api.col.3l.p6$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        URLConnection a();
    }

    public p6(byte[] bArr, Map<String, String> map) {
        this.f8644i = bArr;
        this.f8645j = map;
        setDegradeAbility(Cif.a.SINGLE);
        setHttpProtocol(Cif.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f8644i;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f8645j;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
