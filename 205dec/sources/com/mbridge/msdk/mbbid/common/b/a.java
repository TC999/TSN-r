package com.mbridge.msdk.mbbid.common.b;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.g.f;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: BidRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends f {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.f, com.mbridge.msdk.foundation.same.net.g.b
    public final void a(String str, d dVar) {
        super.a(str, dVar);
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        dVar.a("platform", "1");
        dVar.a("os_version", Build.VERSION.RELEASE);
        dVar.a("package_name", t.A(this.f39592a));
        dVar.a("app_version_name", t.v(this.f39592a));
        dVar.a("app_version_code", t.u(this.f39592a) + "");
        dVar.a("model", t.x());
        dVar.a("brand", t.z());
        dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
        dVar.a("gaid2", t.F());
        if (b4.Z() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac") && e.b(this.f39592a) != null) {
            dVar.a("d1", s.a(e.b(this.f39592a)));
        }
        if (b4.aa() == 1 && e.g(this.f39592a) != null && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
            dVar.a("d3", e.f(this.f39592a));
        }
        dVar.a("mnc", e.e(this.f39592a));
        dVar.a("mcc", e.d(this.f39592a));
        int D = t.D(this.f39592a);
        dVar.a("network_type", D + "");
        dVar.a("network_str", t.a(this.f39592a, D) + "");
        dVar.a("language", t.s(this.f39592a));
        dVar.a("timezone", t.B());
        dVar.a("useragent", t.A());
        dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        dVar.a("gp_version", e.j(this.f39592a));
        dVar.a("screen_size", t.x(this.f39592a) + "x" + t.y(this.f39592a));
        dVar.a("is_clever", com.mbridge.msdk.foundation.same.a.f39383k);
        com.mbridge.msdk.foundation.same.net.g.e.a(dVar, this.f39592a);
        com.mbridge.msdk.foundation.same.net.g.e.a(dVar);
    }
}
