package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.q1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static boolean a(String str) {
        return a(str, null, 0);
    }

    public static boolean b(String str, com.qq.e.comm.plugin.g0.e eVar) {
        return a(str, eVar, 0);
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar, String str) {
        return a(str, eVar, 1);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if (intent.resolveActivity(a4.getPackageManager()) == null) {
            d1.a("openWithSystemBrowser fail, can't resolve intent: " + intent);
            return false;
        }
        a4.startActivity(intent);
        d1.a("Browse with system browser", new Object[0]);
        return true;
    }

    public static boolean a(String str, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        long c02 = eVar.c0();
        boolean a5 = i2.a(str, eVar.x());
        try {
            com.qq.e.comm.plugin.n0.w.f.a(4003033, a5, 1, a4, c02);
            return a(str, eVar, 2);
        } catch (Exception unused) {
            com.qq.e.comm.plugin.n0.w.f.a(4003035, a5, 1, a4, c02);
            return false;
        }
    }

    private static boolean a(String str, com.qq.e.comm.plugin.g0.e eVar, int i4) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        Intent intent = new Intent();
        intent.setClassName(a4, q1.a());
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.INNER_BROWSER);
        intent.putExtra("url", str);
        intent.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
        intent.putExtra("web_page_type", i4);
        if (eVar != null) {
            intent.putExtra("objectId", eVar.l0());
            ((com.qq.e.comm.plugin.d0.b.a) com.qq.e.comm.plugin.d0.b.e.a(eVar.l0(), com.qq.e.comm.plugin.d0.b.a.class)).a(eVar);
            intent.putExtra("landingPageStartTime", eVar.c0());
            intent.putExtra("posId", eVar.q0());
            intent.putExtra("adType", eVar.o().d());
        }
        intent.addFlags(268435456);
        com.qq.e.comm.plugin.h0.l.a().c(3).a();
        try {
            a4.startActivity(intent);
            d1.a("Browse with sdk browser", new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
