package com.qq.e.comm.plugin.util;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class t0 {
    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 12;
    }

    public static boolean b(String str) {
        return str.startsWith("com.qq.e.comm.plugin");
    }

    public static boolean a(com.qq.e.comm.plugin.e0.e.d dVar) {
        return dVar.a() == 100;
    }
}
