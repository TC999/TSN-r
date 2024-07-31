package com.acse.ottn.activity;

import android.text.TextUtils;
import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.activity.F */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1268F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HandlerC1269G f2111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1268F(HandlerC1269G handlerC1269G) {
        this.f2111a = handlerC1269G;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        str = this.f2111a.f2112a.f2153o;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("write code = ");
        str2 = this.f2111a.f2112a.f2153o;
        sb.append(str2);
        C1694ra.m55917a("SeedingLoadingActivity", sb.toString());
        C1631H m56262a = C1631H.m56262a();
        SeedingLoadingActivity seedingLoadingActivity = this.f2111a.f2112a;
        str3 = seedingLoadingActivity.f2153o;
        m56262a.m56260a(seedingLoadingActivity, str3);
    }
}
