package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdInfoModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f0 extends g3 {

    /* renamed from: g  reason: collision with root package name */
    public y3 f5643g = (y3) a().create(y3.class);

    public Observable<String> a(RequestBody requestBody) {
        return this.f5643g.d(requestBody);
    }

    @Override // com.acse.ottn.g3
    public String b() {
        return AcseHelpManager.mIsDebug ? "http://t.idazhe.net/ss/" : "http://report.idazhe.net/ss/";
    }

    public Observable<String> c(RequestBody requestBody) {
        return this.f5643g.k(requestBody);
    }

    public Observable<String> d(RequestBody requestBody) {
        return this.f5643g.m(requestBody);
    }

    public Observable<String> e(RequestBody requestBody) {
        return this.f5643g.s(requestBody);
    }

    public Observable<String> f(RequestBody requestBody) {
        return this.f5643g.h(requestBody);
    }

    public Observable<AdInfoModel> g(RequestBody requestBody) {
        return this.f5643g.c(requestBody);
    }

    public Observable<String> h(RequestBody requestBody) {
        return this.f5643g.j(requestBody);
    }

    public Observable<String> i(RequestBody requestBody) {
        return this.f5643g.l(requestBody);
    }

    public Observable<String> j(RequestBody requestBody) {
        return this.f5643g.e(requestBody);
    }

    public Observable<String> k(RequestBody requestBody) {
        return this.f5643g.b(requestBody);
    }

    public Observable<String> l(RequestBody requestBody) {
        return this.f5643g.n(requestBody);
    }

    public Observable<String> m(RequestBody requestBody) {
        return this.f5643g.p(requestBody);
    }

    public Observable<String> n(RequestBody requestBody) {
        return this.f5643g.o(requestBody);
    }

    public Observable<String> o(RequestBody requestBody) {
        return this.f5643g.g(requestBody);
    }

    public Observable<String> b(RequestBody requestBody) {
        return this.f5643g.a(requestBody);
    }
}
