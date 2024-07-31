package com.acse.ottn.p030a;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdInfoModel;
import com.acse.ottn.p041c.AbstractC1479j;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* renamed from: com.acse.ottn.a.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1249a extends AbstractC1479j {

    /* renamed from: g */
    private InterfaceC1253d f2041g = (InterfaceC1253d) m56685a().create(InterfaceC1253d.class);

    /* renamed from: a */
    public Observable<String> m57376a(RequestBody requestBody) {
        return this.f2041g.m57354b(requestBody);
    }

    /* renamed from: b */
    public Observable<String> m57375b(RequestBody requestBody) {
        return this.f2041g.m57346j(requestBody);
    }

    @Override // com.acse.ottn.p041c.AbstractC1479j
    /* renamed from: b */
    protected String mo56684b() {
        return AcseHelpManager.mIsDebug ? "http://t.idazhe.net/ss/" : "http://report.idazhe.net/ss/";
    }

    /* renamed from: c */
    public Observable<String> m57374c(RequestBody requestBody) {
        return this.f2041g.m57351e(requestBody);
    }

    /* renamed from: d */
    public Observable<String> m57373d(RequestBody requestBody) {
        return this.f2041g.m57350f(requestBody);
    }

    /* renamed from: e */
    public Observable<String> m57372e(RequestBody requestBody) {
        return this.f2041g.m57336t(requestBody);
    }

    /* renamed from: f */
    public Observable<String> m57371f(RequestBody requestBody) {
        return this.f2041g.m57342n(requestBody);
    }

    /* renamed from: g */
    public Observable<AdInfoModel> m57370g(RequestBody requestBody) {
        return this.f2041g.m57345k(requestBody);
    }

    /* renamed from: h */
    public Observable<String> m57369h(RequestBody requestBody) {
        return this.f2041g.m57352d(requestBody);
    }

    /* renamed from: i */
    public Observable<String> m57368i(RequestBody requestBody) {
        return this.f2041g.m57340p(requestBody);
    }

    /* renamed from: j */
    public Observable<String> m57367j(RequestBody requestBody) {
        return this.f2041g.m57344l(requestBody);
    }

    /* renamed from: k */
    public Observable<String> m57366k(RequestBody requestBody) {
        return this.f2041g.m57355a(requestBody);
    }

    /* renamed from: l */
    public Observable<String> m57365l(RequestBody requestBody) {
        return this.f2041g.m57339q(requestBody);
    }

    /* renamed from: m */
    public Observable<String> m57364m(RequestBody requestBody) {
        return this.f2041g.m57349g(requestBody);
    }

    /* renamed from: n */
    public Observable<String> m57363n(RequestBody requestBody) {
        return this.f2041g.m57338r(requestBody);
    }

    /* renamed from: o */
    public Observable<String> m57362o(RequestBody requestBody) {
        return this.f2041g.m57343m(requestBody);
    }
}
