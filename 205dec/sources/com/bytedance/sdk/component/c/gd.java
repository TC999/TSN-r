package com.bytedance.sdk.component.c;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class gd {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f29663c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z3) {
        f29663c = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(String str) {
        if (f29663c) {
            Log.w("JsBridge2", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str) {
        if (f29663c) {
            Log.i("JsBridge2", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(String str, Throwable th) {
        if (f29663c) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, Throwable th) {
        if (f29663c) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(RuntimeException runtimeException) {
        if (f29663c) {
            throw runtimeException;
        }
    }
}
