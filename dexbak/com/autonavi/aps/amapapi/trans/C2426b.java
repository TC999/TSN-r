package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0463l.IPV6Request;
import java.util.Map;

/* compiled from: HttpRequest.java */
/* renamed from: com.autonavi.aps.amapapi.trans.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2426b extends IPV6Request {

    /* renamed from: a */
    Map<String, String> f8255a = null;

    /* renamed from: b */
    Map<String, String> f8256b = null;

    /* renamed from: c */
    String f8257c = "";

    /* renamed from: d */
    byte[] f8258d = null;

    /* renamed from: e */
    private String f8259e = null;

    /* renamed from: a */
    public final void m51389a(Map<String, String> map) {
        this.f8255a = map;
    }

    /* renamed from: b */
    public final void m51386b(Map<String, String> map) {
        this.f8256b = map;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        return this.f8258d;
    }

    @Override // com.amap.api.col.p0463l.IPV6Request, com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        if (!TextUtils.isEmpty(this.f8259e)) {
            return this.f8259e;
        }
        return super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getParams() {
        return this.f8256b;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final Map<String, String> getRequestHead() {
        return this.f8255a;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        return this.f8257c;
    }

    /* renamed from: a */
    public final void m51390a(String str) {
        this.f8257c = str;
    }

    /* renamed from: b */
    public final void m51387b(String str) {
        this.f8259e = str;
    }

    /* renamed from: a */
    public final void m51388a(byte[] bArr) {
        this.f8258d = bArr;
    }
}
