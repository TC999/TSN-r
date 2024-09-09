package com.acse.ottn.a;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.c.j;
import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends j {

    /* renamed from: g  reason: collision with root package name */
    private d f4578g = (d) a().create(d.class);

    public Observable<AccessiblityModel> a(RequestBody requestBody) {
        return this.f4578g.h(requestBody);
    }

    public Observable<String> b(RequestBody requestBody) {
        return this.f4578g.s(requestBody);
    }

    @Override // com.acse.ottn.c.j
    protected String b() {
        return AcseHelpManager.mIsDebug ? "http://a.idazhe.net/ss/tongji_oozk_cn/" : "http://tongji.oozk.cn";
    }

    public Observable<String> c(RequestBody requestBody) {
        return this.f4578g.i(requestBody);
    }

    public Observable<AccessiblityModel> d(RequestBody requestBody) {
        return this.f4578g.c(requestBody);
    }
}
