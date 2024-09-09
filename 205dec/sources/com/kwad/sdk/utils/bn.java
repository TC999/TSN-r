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
import java.io.Closeable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bn {
    private static final Handler aQX = new Handler(Looper.getMainLooper());
    private static long le = 400;

    public static void a(Runnable runnable, Object obj, long j4) {
        Handler handler = aQX;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j4);
    }

    public static void b(Runnable runnable) {
        aQX.postAtFrontOfQueue(runnable);
    }

    public static void c(Runnable runnable) {
        aQX.removeCallbacks(runnable);
    }

    public static boolean hb(String str) {
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

    public static void runOnUiThreadDelay(Runnable runnable, long j4) {
        aQX.postDelayed(runnable, j4);
    }

    public static String t(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            return TextUtils.isEmpty(stackTraceString) ? th.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j4) {
        if (vibrator != null) {
            try {
                if (am.aq(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j4, -1));
                    } else {
                        vibrator.vibrate(j4);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || am.aq(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, le);
    }
}
