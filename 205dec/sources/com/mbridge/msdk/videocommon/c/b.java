package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: RewardSettingRequest.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b extends com.mbridge.msdk.foundation.same.net.g.b {
    public b(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.b
    public final void a(String str, d dVar) {
        try {
            super.a(str, dVar);
            dVar.a("platform", "1");
            dVar.a("os_version", Build.VERSION.RELEASE);
            dVar.a("package_name", t.A(this.f39592a));
            dVar.a("app_version_name", t.v(this.f39592a));
            dVar.a("app_version_code", t.u(this.f39592a) + "");
            dVar.a("orientation", t.t(this.f39592a) + "");
            dVar.a("model", t.x());
            dVar.a("brand", t.z());
            dVar.a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, t.E());
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
            com.mbridge.msdk.foundation.same.net.g.e.b(dVar);
            dVar.a("is_clever", com.mbridge.msdk.foundation.same.a.f39383k);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
