package com.tencent.open.p565a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12999c implements InterfaceC13004g {

    /* renamed from: a */
    private String f37264a;

    /* renamed from: b */
    private int f37265b;

    /* renamed from: c */
    private int f37266c;

    /* renamed from: d */
    private int f37267d;

    /* renamed from: e */
    private String f37268e;

    /* renamed from: f */
    private Map<String, List<String>> f37269f = new HashMap();

    public C12999c(HttpURLConnection httpURLConnection, String str, int i, int i2, int i3, String str2) {
        Map<String, List<String>> headerFields;
        this.f37264a = str;
        this.f37265b = i;
        this.f37266c = i2;
        this.f37267d = i3;
        this.f37268e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f37269f.putAll(headerFields);
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: a */
    public String mo15207a() {
        return this.f37264a;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: b */
    public int mo15206b() {
        return this.f37265b;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: c */
    public int mo15205c() {
        return this.f37266c;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: d */
    public int mo15204d() {
        return this.f37267d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f37264a + "]\nresponseSize = " + this.f37265b + "\nrequestSize = " + this.f37266c + "\nresultCode = " + this.f37267d + "\nerrorMsg = " + this.f37268e;
    }
}
