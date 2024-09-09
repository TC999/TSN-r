package com.mbridge.msdk.splash.f;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: SplashMBLoadRequest.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b extends com.mbridge.msdk.foundation.same.net.g.a {
    public b(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.a, com.mbridge.msdk.foundation.same.net.g.b
    public final void a(String str, d dVar) {
        super.a(str, dVar);
        dVar.a("platform", "1");
        dVar.a("os_version", Build.VERSION.RELEASE);
        dVar.a("package_name", t.A(this.f39592a));
        dVar.a("app_version_name", t.v(this.f39592a));
        dVar.a("app_version_code", t.u(this.f39592a) + "");
        dVar.a("orientation", t.t(this.f39592a) + "");
        dVar.a("model", t.x());
        dVar.a("brand", t.z());
        dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, "");
        dVar.a("gaid2", t.F());
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
        dVar.a("version_flag", "1");
        com.mbridge.msdk.foundation.same.net.g.e.a(dVar, this.f39592a);
        com.mbridge.msdk.foundation.same.net.g.e.a(dVar);
    }
}
