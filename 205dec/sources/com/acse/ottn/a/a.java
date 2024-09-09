package com.acse.ottn.a;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.c.j;
import com.acse.ottn.model.AdInfoModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends j {

    /* renamed from: g  reason: collision with root package name */
    private d f4574g = (d) a().create(d.class);

    public Observable<String> a(RequestBody requestBody) {
        return this.f4574g.b(requestBody);
    }

    public Observable<String> b(RequestBody requestBody) {
        return this.f4574g.j(requestBody);
    }

    @Override // com.acse.ottn.c.j
    protected String b() {
        return AcseHelpManager.mIsDebug ? "http://t.idazhe.net/ss/" : "http://report.idazhe.net/ss/";
    }

    public Observable<String> c(RequestBody requestBody) {
        return this.f4574g.e(requestBody);
    }

    public Observable<String> d(RequestBody requestBody) {
        return this.f4574g.f(requestBody);
    }

    public Observable<String> e(RequestBody requestBody) {
        return this.f4574g.t(requestBody);
    }

    public Observable<String> f(RequestBody requestBody) {
        return this.f4574g.n(requestBody);
    }

    public Observable<AdInfoModel> g(RequestBody requestBody) {
        return this.f4574g.k(requestBody);
    }

    public Observable<String> h(RequestBody requestBody) {
        return this.f4574g.d(requestBody);
    }

    public Observable<String> i(RequestBody requestBody) {
        return this.f4574g.p(requestBody);
    }

    public Observable<String> j(RequestBody requestBody) {
        return this.f4574g.l(requestBody);
    }

    public Observable<String> k(RequestBody requestBody) {
        return this.f4574g.a(requestBody);
    }

    public Observable<String> l(RequestBody requestBody) {
        return this.f4574g.q(requestBody);
    }

    public Observable<String> m(RequestBody requestBody) {
        return this.f4574g.g(requestBody);
    }

    public Observable<String> n(RequestBody requestBody) {
        return this.f4574g.r(requestBody);
    }

    public Observable<String> o(RequestBody requestBody) {
        return this.f4574g.m(requestBody);
    }
}
