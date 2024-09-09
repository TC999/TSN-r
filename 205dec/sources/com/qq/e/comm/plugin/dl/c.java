package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static Set<String> a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return Collections.emptySet();
        }
        return a(eVar, a(eVar.o()));
    }

    public static Set<String> b(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar, "te_bxg_md_ccids");
    }

    private static Set<String> a(com.qq.e.comm.plugin.g0.e eVar, String str) {
        Set<String> emptySet = Collections.emptySet();
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c(str, eVar.q0());
        return !TextUtils.isEmpty(c4) ? new HashSet(Arrays.asList(c4.split(","))) : emptySet;
    }

    private static String a(com.qq.e.comm.plugin.b.g gVar) {
        return gVar.k() ? "te_bxg_sp_ccids" : gVar.f() ? "te_bxg_ex_ccids" : gVar.h() ? "te_bxg_ih_ccids" : gVar.g() ? "te_bxg_if_ccids" : gVar.e() ? "te_bxg_ba_ccids" : gVar.j() ? "te_bxg_rv_ccids" : gVar.i() ? "te_bxg_nu_ccids" : "";
    }
}
