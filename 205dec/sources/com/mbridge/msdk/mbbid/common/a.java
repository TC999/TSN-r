package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;

/* compiled from: AreaBidCommon.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static String a(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (com.mbridge.msdk.foundation.controller.a.f().j() == null) {
                    com.mbridge.msdk.foundation.controller.a.f().b(context);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        stringBuffer.append(t.E());
        stringBuffer.append("|");
        stringBuffer.append((b4.aa() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) ? e.g(context) : "");
        stringBuffer.append("|");
        stringBuffer.append((b4.Z() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) ? e.b(context) : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(t.z());
        stringBuffer.append("|");
        stringBuffer.append(t.y());
        stringBuffer.append("|");
        stringBuffer.append(t.D(context));
        stringBuffer.append("|");
        stringBuffer.append(MBConfiguration.SDK_VERSION);
        stringBuffer.append("|");
        stringBuffer.append(t.x(context));
        stringBuffer.append("x");
        stringBuffer.append(t.y(context));
        stringBuffer.append("|");
        stringBuffer.append(t.A());
        stringBuffer.append("|");
        stringBuffer.append(h.a(20));
        stringBuffer.append("|");
        stringBuffer.append(ac.b(20));
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.same.a.f39378f);
        stringBuffer.append("|");
        stringBuffer.append(t.L());
        stringBuffer.append("|");
        stringBuffer.append(t.K());
        stringBuffer.append("|");
        stringBuffer.append(e.s());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.tools.b.a());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.tools.b.b());
        stringBuffer.append("|");
        stringBuffer.append(aa.b());
        stringBuffer.append("|");
        stringBuffer.append(aa.a());
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().b("b"));
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().b("c"));
        stringBuffer.append("|");
        stringBuffer.append("");
        String o4 = b4.o();
        stringBuffer.append("|");
        stringBuffer.append(o4);
        stringBuffer.append("|");
        stringBuffer.append(ac.e());
        stringBuffer.append("|");
        String f4 = ac.f();
        if (TextUtils.isEmpty(f4)) {
            f4 = "";
        }
        stringBuffer.append(f4);
        stringBuffer.append("|");
        stringBuffer.append(ac.m(str));
        stringBuffer.append("|");
        if (b4.G() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            stringBuffer.append(e.a(context));
        }
        stringBuffer.append("|");
        stringBuffer.append(t.v());
        stringBuffer.append("|");
        stringBuffer.append(t.r(context));
        stringBuffer.append("|");
        stringBuffer.append(t.w() + "");
        stringBuffer.append("|");
        stringBuffer.append(t.g(com.mbridge.msdk.foundation.controller.a.f().m()) + "");
        stringBuffer.append("|");
        stringBuffer.append(t.O());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() ? "1" : "2");
        stringBuffer.append("|");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append(e.u());
        }
        return s.a(stringBuffer.toString());
    }
}
