package com.acse.ottn.activity;

import android.text.TextUtils;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.Ha;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4760a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f4761b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4762c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ExcessActivity f4763d;

    x(ExcessActivity excessActivity, String str, String str2, String str3) {
        this.f4763d = excessActivity;
        this.f4760a = str;
        this.f4761b = str2;
        this.f4762c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!TextUtils.isEmpty(this.f4760a)) {
            AccessiblityModel accessiblityModel = new AccessiblityModel();
            accessiblityModel.getData().setSpop_deeplink(this.f4760a);
            accessiblityModel.getData().setSpop_link(this.f4761b);
            accessiblityModel.getData().setPackage_name(this.f4762c);
            Ha.b().a(this.f4763d, accessiblityModel);
        }
        this.f4763d.finish();
    }
}
