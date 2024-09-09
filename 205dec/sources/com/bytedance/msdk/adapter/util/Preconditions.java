package com.bytedance.msdk.adapter.util;

import android.os.Looper;
import java.util.IllegalFormatException;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class NoThrow {

        /* renamed from: a  reason: collision with root package name */
        private static volatile boolean f27226a;

        public static boolean checkArgument(boolean z3) {
            return Preconditions.h(z3, f27226a, "Illegal argument", "");
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.e(obj, f27226a, "Object can not be null.", "");
        }

        public static boolean checkState(boolean z3) {
            return Preconditions.i(z3, f27226a, "Illegal state.", "");
        }

        public static boolean checkUiThread() {
            return Preconditions.f(f27226a, "This method must be called from the UI thread.", "");
        }

        public static void setStrictMode(boolean z3) {
            f27226a = z3;
        }

        public static boolean checkArgument(boolean z3, String str) {
            return Preconditions.h(z3, f27226a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.e(obj, f27226a, str, "");
        }

        public static boolean checkState(boolean z3, String str) {
            return Preconditions.i(z3, f27226a, str, "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.f(f27226a, str, "");
        }

        public static boolean checkArgument(boolean z3, String str, Object... objArr) {
            return Preconditions.h(z3, f27226a, str, objArr);
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.e(obj, f27226a, str, objArr);
        }

        public static boolean checkState(boolean z3, String str, Object... objArr) {
            return Preconditions.i(z3, f27226a, str, objArr);
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.f(false, str, objArr);
        }
    }

    private Preconditions() {
    }

    private static String a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e4) {
            Logger.e("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e4.getMessage());
            return valueOf;
        }
    }

    public static void checkArgument(boolean z3) {
        h(z3, true, "Illegal argument.", "");
    }

    public static void checkNotNull(Object obj) {
        e(obj, true, "Object can not be null.", "");
    }

    public static void checkState(boolean z3) {
        i(z3, true, "Illegal state.", "");
    }

    public static void checkUiThread() {
        f(true, "This method must be called from the UI thread.", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Object obj, boolean z3, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String a4 = a(str, objArr);
        if (!z3) {
            Logger.e("TTMediationSDK_ADAPTER", a4);
            return false;
        }
        throw new NullPointerException(a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(boolean z3, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String a4 = a(str, objArr);
        if (!z3) {
            Logger.e("TTMediationSDK_ADAPTER", a4);
            return false;
        }
        throw new IllegalStateException(a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(boolean z3, boolean z4, String str, Object... objArr) {
        if (z3) {
            return true;
        }
        String a4 = a(str, objArr);
        if (!z4) {
            Logger.e("TTMediationSDK_ADAPTER", a4);
            return false;
        }
        throw new IllegalArgumentException(a4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(boolean z3, boolean z4, String str, Object... objArr) {
        if (z3) {
            return true;
        }
        String a4 = a(str, objArr);
        if (!z4) {
            Logger.e("TTMediationSDK_ADAPTER", a4);
            return false;
        }
        throw new IllegalStateException(a4);
    }

    public static void checkArgument(boolean z3, String str) {
        h(z3, true, str, "");
    }

    public static void checkNotNull(Object obj, String str) {
        e(obj, true, str, "");
    }

    public static void checkState(boolean z3, String str) {
        i(z3, true, str, "");
    }

    public static void checkUiThread(String str) {
        f(true, str, "");
    }

    public static void checkArgument(boolean z3, String str, Object... objArr) {
        h(z3, true, str, objArr);
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        e(obj, true, str, objArr);
    }

    public static void checkState(boolean z3, String str, Object... objArr) {
        i(z3, true, str, objArr);
    }

    public static void checkUiThread(String str, Object... objArr) {
        f(true, str, objArr);
    }
}
