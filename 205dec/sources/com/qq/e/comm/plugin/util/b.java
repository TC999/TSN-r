package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import java.util.Random;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f46376a = new Random(System.currentTimeMillis());

    /* renamed from: b  reason: collision with root package name */
    private static int f46377b = a("expad_report_sampling_rate", 1);

    /* renamed from: c  reason: collision with root package name */
    private static int f46378c = a("clkad_report_sampling_rate", 100);

    public static boolean b(String str) {
        return str != null && str.length() > 3 && str.charAt(1) == '1';
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("devid")) {
            return str;
        }
        String a4 = com.qq.e.comm.plugin.m.b.f44639e.b().a(com.qq.e.comm.plugin.d0.a.d().a());
        if (a4 == null) {
            a4 = "";
        }
        return str.replace("devid", a4);
    }

    public static String a(String str, String str2) {
        String format = String.format("%s@%s#%d#%s", str2, str, Long.valueOf(System.currentTimeMillis()), "devid");
        int nextDouble = (int) (f46376a.nextDouble() * 100.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(nextDouble < f46377b ? "1" : "0");
        sb.append(nextDouble < f46378c ? "1" : "0");
        sb.append(format);
        return sb.toString();
    }

    public static boolean a(String str) {
        return str != null && str.length() > 3 && str.charAt(2) == '1';
    }

    private static int a(String str, int i4) {
        return com.qq.e.comm.plugin.d0.a.d().f().a(str, i4);
    }
}
