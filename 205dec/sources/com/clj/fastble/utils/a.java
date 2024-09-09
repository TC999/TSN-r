package com.clj.fastble.utils;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleLog.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36718a = true;

    /* renamed from: b  reason: collision with root package name */
    private static String f36719b = "FastBle";

    public static void a(String str) {
        if (!f36718a || str == null) {
            return;
        }
        Log.d(f36719b, str);
    }

    public static void b(String str) {
        if (!f36718a || str == null) {
            return;
        }
        Log.e(f36719b, str);
    }

    public static void c(String str) {
        if (!f36718a || str == null) {
            return;
        }
        Log.i(f36719b, str);
    }

    public static void d(String str) {
        if (!f36718a || str == null) {
            return;
        }
        Log.w(f36719b, str);
    }
}
