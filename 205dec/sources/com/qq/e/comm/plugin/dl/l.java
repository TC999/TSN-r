package com.qq.e.comm.plugin.dl;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {
    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar, "dlctd", 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.g0.y yVar) {
        int o4;
        return (yVar == null || (o4 = yVar.o()) < 0) ? a(eVar, "dlcte", -1) : o4;
    }

    private static int a(com.qq.e.comm.plugin.g0.e eVar, String str, int i4) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(a(eVar, str), eVar.q0(), -1);
        return a4 >= 0 ? a4 : com.qq.e.comm.plugin.d0.a.d().f().a(str, eVar.q0(), i4);
    }

    private static String a(com.qq.e.comm.plugin.g0.e eVar, String str) {
        return str + "_" + eVar.o().c();
    }
}
