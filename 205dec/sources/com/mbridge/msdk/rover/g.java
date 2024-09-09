package com.mbridge.msdk.rover;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: RoverRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends com.mbridge.msdk.foundation.same.net.g.b {
    public g(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.b
    public final void a(String str, com.mbridge.msdk.foundation.same.net.g.d dVar) {
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
        dVar.a("mnc", com.mbridge.msdk.foundation.tools.e.e(this.f39592a));
        dVar.a("mcc", com.mbridge.msdk.foundation.tools.e.d(this.f39592a));
        int D = t.D(this.f39592a);
        dVar.a("network_type", D + "");
        dVar.a("network_str", t.a(this.f39592a, D));
        dVar.a("language", t.s(this.f39592a));
        dVar.a("timezone", t.B());
        dVar.a("useragent", t.A());
        dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        dVar.a("gp_version", com.mbridge.msdk.foundation.tools.e.j(this.f39592a));
        dVar.a("screen_size", t.x(this.f39592a) + "x" + t.y(this.f39592a));
        StringBuilder sb = new StringBuilder();
        sb.append(com.mbridge.msdk.foundation.controller.a.f().k());
        sb.append(com.mbridge.msdk.foundation.controller.a.f().l());
        dVar.a("sign", SameMD5.getMD5(sb.toString()));
        dVar.a("app_id", com.mbridge.msdk.foundation.controller.a.f().k());
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (b4.Z() == 1) {
                    if (com.mbridge.msdk.foundation.tools.e.b(this.f39592a) != null) {
                        jSONObject.put("imei", com.mbridge.msdk.foundation.tools.e.b(this.f39592a));
                    }
                    if (com.mbridge.msdk.foundation.tools.e.i(this.f39592a) != null) {
                        jSONObject.put("mac", com.mbridge.msdk.foundation.tools.e.i(this.f39592a));
                    }
                }
                if (b4.aa() == 1 && com.mbridge.msdk.foundation.tools.e.g(this.f39592a) != null) {
                    jSONObject.put("android_id", com.mbridge.msdk.foundation.tools.e.g(this.f39592a));
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String a4 = s.a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a4)) {
                        dVar.a("dvi", a4);
                        return;
                    } else {
                        dVar.a("dvi", "");
                        return;
                    }
                }
                dVar.a("dvi", "");
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        dVar.a("dvi", "");
    }
}
