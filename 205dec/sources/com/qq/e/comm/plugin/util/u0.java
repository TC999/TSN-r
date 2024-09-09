package com.qq.e.comm.plugin.util;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class u0 {
    public static void a(String str) {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("mmaEnabled", 1) == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ams.a.a.a.a.a().b(com.qq.e.comm.plugin.d0.a.d().a(), com.qq.e.comm.plugin.d0.a.d().f().c("mmaConfigUrl"));
        a1.a(com.tencent.ams.a.a.a.a.a().a(str));
    }

    public static boolean b() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("mma_disable_get_imei", 0) == 0;
    }

    public static boolean c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("mma_disable_get_mac", 0) == 0 && !y.b("mac_address");
    }

    public static boolean a() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("mma_disable_get_androidid", 0) == 0;
    }
}
