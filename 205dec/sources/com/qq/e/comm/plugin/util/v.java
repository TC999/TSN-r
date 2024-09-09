package com.qq.e.comm.plugin.util;

import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v {
    public static void a(com.qq.e.comm.plugin.g0.e eVar) {
        List<String> v3 = eVar.v();
        if (v3 != null && v3.size() > 0) {
            for (String str : v3) {
                a1.a(str);
            }
        }
        List<String> u3 = eVar.u();
        if (u3 == null || u3.size() <= 0) {
            return;
        }
        for (String str2 : u3) {
            u0.a(str2);
        }
    }

    public static void b(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return;
        }
        List<com.qq.e.comm.plugin.g0.e0> v02 = eVar.v0();
        if (v02 != null && v02.size() > 0) {
            for (com.qq.e.comm.plugin.g0.e0 e0Var : v02) {
                if (e0Var != null) {
                    a1.a(e0Var.a());
                }
            }
        }
        List<com.qq.e.comm.plugin.g0.e0> w02 = eVar.w0();
        if (w02 == null || w02.size() <= 0) {
            return;
        }
        for (com.qq.e.comm.plugin.g0.e0 e0Var2 : w02) {
            if (e0Var2 != null) {
                u0.a(e0Var2.a());
            }
        }
    }
}
