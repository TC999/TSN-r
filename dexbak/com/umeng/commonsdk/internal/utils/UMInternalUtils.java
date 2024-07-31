package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;

/* renamed from: com.umeng.commonsdk.internal.utils.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMInternalUtils {

    /* renamed from: a */
    private static final String f38870a = PathCenter.m14695b().m14694b(PathCenter.f37699r);

    /* renamed from: b */
    private static final String f38871b = "um_common_strength";

    /* renamed from: c */
    private static final String f38872c = "um_common_battery";

    /* renamed from: a */
    public static String m13900a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f38870a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f38872c, null);
    }

    /* renamed from: a */
    public static void m13899a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f38870a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f38872c, str).commit();
    }
}
