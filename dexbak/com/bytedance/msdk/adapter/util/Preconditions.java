package com.bytedance.msdk.adapter.util;

import android.os.Looper;
import java.util.IllegalFormatException;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class NoThrow {

        /* renamed from: a */
        private static volatile boolean f21508a;

        public static boolean checkArgument(boolean z) {
            return Preconditions.m37538h(z, f21508a, "Illegal argument", "");
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.m37541e(obj, f21508a, "Object can not be null.", "");
        }

        public static boolean checkState(boolean z) {
            return Preconditions.m37537i(z, f21508a, "Illegal state.", "");
        }

        public static boolean checkUiThread() {
            return Preconditions.m37540f(f21508a, "This method must be called from the UI thread.", "");
        }

        public static void setStrictMode(boolean z) {
            f21508a = z;
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.m37538h(z, f21508a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.m37541e(obj, f21508a, str, "");
        }

        public static boolean checkState(boolean z, String str) {
            return Preconditions.m37537i(z, f21508a, str, "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.m37540f(f21508a, str, "");
        }

        public static boolean checkArgument(boolean z, String str, Object... objArr) {
            return Preconditions.m37538h(z, f21508a, str, objArr);
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.m37541e(obj, f21508a, str, objArr);
        }

        public static boolean checkState(boolean z, String str, Object... objArr) {
            return Preconditions.m37537i(z, f21508a, str, objArr);
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.m37540f(false, str, objArr);
        }
    }

    private Preconditions() {
    }

    /* renamed from: a */
    private static String m37545a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e) {
            Logger.m37557e("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return valueOf;
        }
    }

    public static void checkArgument(boolean z) {
        m37538h(z, true, "Illegal argument.", "");
    }

    public static void checkNotNull(Object obj) {
        m37541e(obj, true, "Object can not be null.", "");
    }

    public static void checkState(boolean z) {
        m37537i(z, true, "Illegal state.", "");
    }

    public static void checkUiThread() {
        m37540f(true, "This method must be called from the UI thread.", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m37541e(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String m37545a = m37545a(str, objArr);
        if (!z) {
            Logger.m37557e("TTMediationSDK_ADAPTER", m37545a);
            return false;
        }
        throw new NullPointerException(m37545a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m37540f(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String m37545a = m37545a(str, objArr);
        if (!z) {
            Logger.m37557e("TTMediationSDK_ADAPTER", m37545a);
            return false;
        }
        throw new IllegalStateException(m37545a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static boolean m37538h(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m37545a = m37545a(str, objArr);
        if (!z2) {
            Logger.m37557e("TTMediationSDK_ADAPTER", m37545a);
            return false;
        }
        throw new IllegalArgumentException(m37545a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m37537i(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m37545a = m37545a(str, objArr);
        if (!z2) {
            Logger.m37557e("TTMediationSDK_ADAPTER", m37545a);
            return false;
        }
        throw new IllegalStateException(m37545a);
    }

    public static void checkArgument(boolean z, String str) {
        m37538h(z, true, str, "");
    }

    public static void checkNotNull(Object obj, String str) {
        m37541e(obj, true, str, "");
    }

    public static void checkState(boolean z, String str) {
        m37537i(z, true, str, "");
    }

    public static void checkUiThread(String str) {
        m37540f(true, str, "");
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        m37538h(z, true, str, objArr);
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        m37541e(obj, true, str, objArr);
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        m37537i(z, true, str, objArr);
    }

    public static void checkUiThread(String str, Object... objArr) {
        m37540f(true, str, objArr);
    }
}
