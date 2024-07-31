package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.PathCenter;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = PathCenter.m14695b().m14694b(PathCenter.f37691j);

    private PreferenceWrapper() {
    }

    public static SharedPreferences getDefault(Context context) {
        if (context != null) {
            return context.getSharedPreferences(DEFAULT_PREFERENCE, 0);
        }
        return null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
