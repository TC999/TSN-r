package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bk {
    public static void a(long j4, int i4, @Nullable Context context) {
        if (j4 == 0 || context == null || i4 <= 0 || i4 > 100) {
            return;
        }
        long currentTimeMillis = j4 - System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (Math.abs(currentTimeMillis) / 3600000 > i4) {
            sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
        } else {
            sharedPreferences.edit().remove("key_time_diff_s2c").apply();
        }
    }

    public static long v(@Nullable Context context, boolean z3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z3) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
                if (sharedPreferences == null) {
                    return Math.abs(currentTimeMillis);
                }
                long j4 = sharedPreferences.getLong("key_time_diff_s2c", 0L);
                if (j4 != 0) {
                    return currentTimeMillis + j4;
                }
            }
            return Math.abs(currentTimeMillis);
        }
        return currentTimeMillis;
    }
}
