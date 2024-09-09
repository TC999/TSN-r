package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private String f51664a;

    /* renamed from: b  reason: collision with root package name */
    private int f51665b;

    /* renamed from: c  reason: collision with root package name */
    private int f51666c;

    /* renamed from: d  reason: collision with root package name */
    private int f51667d;

    /* renamed from: e  reason: collision with root package name */
    private String f51668e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, List<String>> f51669f = new HashMap();

    public c(HttpURLConnection httpURLConnection, String str, int i4, int i5, int i6, String str2) {
        Map<String, List<String>> headerFields;
        this.f51664a = str;
        this.f51665b = i4;
        this.f51666c = i5;
        this.f51667d = i6;
        this.f51668e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f51669f.putAll(headerFields);
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.f51664a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f51665b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f51666c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f51667d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f51664a + "]\nresponseSize = " + this.f51665b + "\nrequestSize = " + this.f51666c + "\nresultCode = " + this.f51667d + "\nerrorMsg = " + this.f51668e;
    }
}
