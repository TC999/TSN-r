package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p205p0.C7193bi;

/* renamed from: com.kwad.sdk.utils.bk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11061bk {
    /* renamed from: a */
    public static void m23869a(long j, int i, @Nullable Context context) {
        if (j == 0 || context == null || i <= 0 || i > 100) {
            return;
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (Math.abs(currentTimeMillis) / C7193bi.f24584s > i) {
            sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
        } else {
            sharedPreferences.edit().remove("key_time_diff_s2c").apply();
        }
    }

    /* renamed from: v */
    public static long m23868v(@Nullable Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
                if (sharedPreferences == null) {
                    return Math.abs(currentTimeMillis);
                }
                long j = sharedPreferences.getLong("key_time_diff_s2c", 0L);
                if (j != 0) {
                    return currentTimeMillis + j;
                }
            }
            return Math.abs(currentTimeMillis);
        }
        return currentTimeMillis;
    }
}
