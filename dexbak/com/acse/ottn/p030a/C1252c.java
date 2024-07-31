package com.acse.ottn.p030a;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.p041c.AbstractC1479j;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* renamed from: com.acse.ottn.a.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1252c extends AbstractC1479j {

    /* renamed from: g */
    private InterfaceC1253d f2043g = (InterfaceC1253d) m56685a().create(InterfaceC1253d.class);

    /* renamed from: a */
    public Observable<AccessiblityModel> m57359a(RequestBody requestBody) {
        return this.f2043g.m57348h(requestBody);
    }

    /* renamed from: b */
    public Observable<String> m57358b(RequestBody requestBody) {
        return this.f2043g.m57337s(requestBody);
    }

    @Override // com.acse.ottn.p041c.AbstractC1479j
    /* renamed from: b */
    protected String mo56684b() {
        return AcseHelpManager.mIsDebug ? "http://a.idazhe.net/ss/tongji_oozk_cn/" : "http://tongji.oozk.cn";
    }

    /* renamed from: c */
    public Observable<String> m57357c(RequestBody requestBody) {
        return this.f2043g.m57347i(requestBody);
    }

    /* renamed from: d */
    public Observable<AccessiblityModel> m57356d(RequestBody requestBody) {
        return this.f2043g.m57353c(requestBody);
    }
}
