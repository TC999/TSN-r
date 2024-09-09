package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003l.l4;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b extends l4 {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f11927a = null;

    /* renamed from: b  reason: collision with root package name */
    Map<String, String> f11928b = null;

    /* renamed from: c  reason: collision with root package name */
    String f11929c = "";

    /* renamed from: d  reason: collision with root package name */
    byte[] f11930d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f11931e = null;

    public final void a(Map<String, String> map) {
        this.f11927a = map;
    }

    public final void b(Map<String, String> map) {
        this.f11928b = map;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f11930d;
    }

    @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        if (!TextUtils.isEmpty(this.f11931e)) {
            return this.f11931e;
        }
        return super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f11928b;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return this.f11927a;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f11929c;
    }

    public final void a(String str) {
        this.f11929c = str;
    }

    public final void b(String str) {
        this.f11931e = str;
    }

    public final void a(byte[] bArr) {
        this.f11930d = bArr;
    }
}
