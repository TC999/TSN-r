package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import java.util.HashSet;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46531a = "n0";

    public static boolean a(String str, int i4) {
        String[] split = com.qq.e.comm.plugin.d0.a.d().f().a("sklpjp", str, "1,4,7,10").split(",");
        HashSet hashSet = new HashSet();
        try {
            for (String str2 : split) {
                hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        } catch (Exception e4) {
            d1.a(f46531a, e4.getMessage());
        }
        return hashSet.contains(Integer.valueOf(i4));
    }

    public static String a(String str, String str2) {
        return i2.a(str, "land_page_source", str2);
    }

    public static String a(String str, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        String str2;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return str;
        }
        if (eVar.G() == 1 || eVar.G() == 4) {
            if (z3 && eVar.l1()) {
                str2 = eVar.N0() > eVar.R0() ? "1" : "2";
            } else {
                str2 = "0";
            }
            return i2.c(i2.c(str, "v_subtype", str2), "ad_type", String.valueOf(eVar.o().f42000e));
        }
        return str;
    }
}
