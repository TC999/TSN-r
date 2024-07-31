package com.acse.ottn.activity;

import android.text.TextUtils;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.C1632Ha;

/* renamed from: com.acse.ottn.activity.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1306x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2209a;

    /* renamed from: b */
    final /* synthetic */ String f2210b;

    /* renamed from: c */
    final /* synthetic */ String f2211c;

    /* renamed from: d */
    final /* synthetic */ ExcessActivity f2212d;

    RunnableC1306x(ExcessActivity excessActivity, String str, String str2, String str3) {
        this.f2212d = excessActivity;
        this.f2209a = str;
        this.f2210b = str2;
        this.f2211c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!TextUtils.isEmpty(this.f2209a)) {
            AccessiblityModel accessiblityModel = new AccessiblityModel();
            accessiblityModel.getData().setSpop_deeplink(this.f2209a);
            accessiblityModel.getData().setSpop_link(this.f2210b);
            accessiblityModel.getData().setPackage_name(this.f2211c);
            C1632Ha.m56256b().m56257a(this.f2212d, accessiblityModel);
        }
        this.f2212d.finish();
    }
}
