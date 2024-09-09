package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private Response f51670a;

    /* renamed from: b  reason: collision with root package name */
    private String f51671b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f51672c;

    /* renamed from: d  reason: collision with root package name */
    private int f51673d;

    /* renamed from: e  reason: collision with root package name */
    private int f51674e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Response response, int i4) {
        this.f51670a = response;
        this.f51673d = i4;
        this.f51672c = response.code();
        ResponseBody body = this.f51670a.body();
        if (body != null) {
            this.f51674e = (int) body.contentLength();
        } else {
            this.f51674e = 0;
        }
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f51671b == null) {
            ResponseBody body = this.f51670a.body();
            if (body != null) {
                this.f51671b = body.string();
            }
            if (this.f51671b == null) {
                this.f51671b = "";
            }
        }
        return this.f51671b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f51674e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f51673d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f51672c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.f51671b + this.f51672c + this.f51673d + this.f51674e;
    }
}
