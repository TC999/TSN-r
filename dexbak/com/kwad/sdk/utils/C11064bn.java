package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.kwad.sdk.core.p397e.C10331c;
import java.io.Closeable;

/* renamed from: com.kwad.sdk.utils.bn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11064bn {
    private static final Handler aQX = new Handler(Looper.getMainLooper());

    /* renamed from: le */
    private static long f29678le = 400;

    /* renamed from: a */
    public static void m23862a(Runnable runnable, Object obj, long j) {
        Handler handler = aQX;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j);
    }

    /* renamed from: b */
    public static void m23860b(Runnable runnable) {
        aQX.postAtFrontOfQueue(runnable);
    }

    /* renamed from: c */
    public static void m23858c(Runnable runnable) {
        aQX.removeCallbacks(runnable);
    }

    /* renamed from: hb */
    public static boolean m23857hb(String str) {
        return TextUtils.isEmpty(str) || str.contains(" ") || !URLUtil.isNetworkUrl(str);
    }

    public static void postOnUiThread(Runnable runnable) {
        aQX.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aQX.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        aQX.postDelayed(runnable, j);
    }

    /* renamed from: t */
    public static String m23856t(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            return TextUtils.isEmpty(stackTraceString) ? th.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (C11020am.m24099aq(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                    } else {
                        vibrator.vibrate(j);
                    }
                }
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public static void m23861b(Context context, Vibrator vibrator) {
        if (vibrator == null || C11020am.m24099aq(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    /* renamed from: c */
    public static void m23859c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static void m23863a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, f29678le);
    }
}
