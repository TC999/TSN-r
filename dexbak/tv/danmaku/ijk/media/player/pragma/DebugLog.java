package tv.danmaku.ijk.media.player.pragma;

import android.util.Log;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    /* renamed from: d */
    public static void m257d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        Log.d(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: e */
    public static void m255e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void efmt(String str, String str2, Object... objArr) {
        Log.e(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: i */
    public static void m253i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        Log.i(str, String.format(Locale.US, str2, objArr));
    }

    public static void printCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        printStackTrace(th);
    }

    public static void printStackTrace(Throwable th) {
        th.printStackTrace();
    }

    /* renamed from: v */
    public static void m251v(String str, String str2) {
        Log.v(str, str2);
    }

    public static void vfmt(String str, String str2, Object... objArr) {
        Log.v(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: w */
    public static void m249w(String str, String str2) {
        Log.w(str, str2);
    }

    public static void wfmt(String str, String str2, Object... objArr) {
        Log.w(str, String.format(Locale.US, str2, objArr));
    }

    /* renamed from: d */
    public static void m256d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    /* renamed from: e */
    public static void m254e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* renamed from: i */
    public static void m252i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    /* renamed from: v */
    public static void m250v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }

    /* renamed from: w */
    public static void m248w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
