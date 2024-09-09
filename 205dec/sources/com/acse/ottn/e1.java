package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e1 extends g3 {

    /* renamed from: g  reason: collision with root package name */
    public y3 f5631g = (y3) a().create(y3.class);

    public Observable<AccessiblityModel> a(RequestBody requestBody) {
        return this.f5631g.q(requestBody);
    }

    @Override // com.acse.ottn.g3
    public String b() {
        return AcseHelpManager.mIsDebug ? "http://a.idazhe.net/ss/tongji_oozk_cn/" : "http://tongji.oozk.cn";
    }

    public Observable<String> c(RequestBody requestBody) {
        return this.f5631g.t(requestBody);
    }

    public Observable<AccessiblityModel> d(RequestBody requestBody) {
        return this.f5631g.f(requestBody);
    }

    public Observable<String> b(RequestBody requestBody) {
        return this.f5631g.r(requestBody);
    }
}
