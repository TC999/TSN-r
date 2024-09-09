package com.amap.api.col.p0003l;

import java.util.Hashtable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineDownloadRequest.java */
/* renamed from: com.amap.api.col.3l.c1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c1 extends f2 {

    /* renamed from: i  reason: collision with root package name */
    private String f7299i;

    public c1(String str) {
        this.f7299i = str;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f7299i;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return false;
    }
}
