package com.tencent.open.p565a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C13000d implements InterfaceC13004g {

    /* renamed from: a */
    private Response f37270a;

    /* renamed from: b */
    private String f37271b = null;

    /* renamed from: c */
    private int f37272c;

    /* renamed from: d */
    private int f37273d;

    /* renamed from: e */
    private int f37274e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C13000d(Response response, int i) {
        this.f37270a = response;
        this.f37273d = i;
        this.f37272c = response.code();
        ResponseBody body = this.f37270a.body();
        if (body != null) {
            this.f37274e = (int) body.contentLength();
        } else {
            this.f37274e = 0;
        }
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: a */
    public String mo15207a() throws IOException {
        if (this.f37271b == null) {
            ResponseBody body = this.f37270a.body();
            if (body != null) {
                this.f37271b = body.string();
            }
            if (this.f37271b == null) {
                this.f37271b = "";
            }
        }
        return this.f37271b;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: b */
    public int mo15206b() {
        return this.f37274e;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: c */
    public int mo15205c() {
        return this.f37273d;
    }

    @Override // com.tencent.open.p565a.InterfaceC13004g
    /* renamed from: d */
    public int mo15204d() {
        return this.f37272c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.f37271b + this.f37272c + this.f37273d + this.f37274e;
    }
}
