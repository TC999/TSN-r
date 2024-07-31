package com.amap.api.col.p0463l;

import java.util.Hashtable;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.c1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineDownloadRequest extends AbstractAMapRequest {

    /* renamed from: i */
    private String f3717i;

    public OfflineDownloadRequest(String str) {
        this.f3717i = str;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return this.f3717i;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final boolean isSupportIPV6() {
        return false;
    }
}
