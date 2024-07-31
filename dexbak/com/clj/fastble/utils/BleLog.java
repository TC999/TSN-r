package com.clj.fastble.utils;

import android.util.Log;

/* renamed from: com.clj.fastble.utils.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class BleLog {

    /* renamed from: a */
    public static boolean f23051a = true;

    /* renamed from: b */
    private static String f23052b = "FastBle";

    /* renamed from: a */
    public static void m35960a(String str) {
        if (!f23051a || str == null) {
            return;
        }
        Log.d(f23052b, str);
    }

    /* renamed from: b */
    public static void m35959b(String str) {
        if (!f23051a || str == null) {
            return;
        }
        Log.e(f23052b, str);
    }

    /* renamed from: c */
    public static void m35958c(String str) {
        if (!f23051a || str == null) {
            return;
        }
        Log.i(f23052b, str);
    }

    /* renamed from: d */
    public static void m35957d(String str) {
        if (!f23051a || str == null) {
            return;
        }
        Log.w(f23052b, str);
    }
}
