package com.qq.e.comm.plugin.fs.f.e.d;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {
    public static f a(Context context, com.qq.e.comm.plugin.g0.e eVar, String str, int i4, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        if (a(eVar)) {
            d1.a("EndCardFactory", "create LandingPageView");
            return new h(context, eVar);
        }
        d1.a("EndCardFactory", "create EndCardView");
        return new d(context, eVar, str, i4, aVar);
    }

    private static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar instanceof u) {
            u uVar = (u) eVar;
            if (com.qq.e.comm.plugin.d0.a.d().f().a("rewardEndCardLandingPage", 1) == 0) {
                d1.a("EndCardFactory", "rewardEndCardLandingPage feature, switch off.");
                return false;
            }
            String a4 = uVar.a();
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            if (uVar.c()) {
                return true;
            }
            String b4 = uVar.b();
            int g4 = uVar.g();
            boolean f4 = uVar.f();
            boolean f5 = com.qq.e.comm.plugin.util.c.f(uVar.d());
            boolean z3 = uVar.d() != null && uVar.d().m1();
            d1.a("EndCardFactory", "showLandingPage ? landingPage : " + a4 + " ,productType : " + g4 + " ,dlUrl : " + b4 + " ,demoGame : " + f4 + " ,WXMiniProgram : " + f5);
            return ((g4 != 12 && g4 != 1000 && g4 != 38) || !TextUtils.isEmpty(b4) || f4 || f5 || z3) ? false : true;
        }
        return false;
    }
}
