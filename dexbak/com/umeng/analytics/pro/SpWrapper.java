package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.umeng.analytics.pro.ar */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SpWrapper {

    /* renamed from: a */
    public static final String f37665a = "cl_count";

    /* renamed from: b */
    public static final String f37666b = "interval_";

    /* renamed from: c */
    public static final String f37667c = "config_ts";

    /* renamed from: d */
    public static final String f37668d = "iucc_s1";

    /* renamed from: e */
    public static final String f37669e = "iucc_s2";

    /* renamed from: f */
    public static final String f37670f = "sdk_type_ver";

    /* renamed from: g */
    public static final String f37671g = "should_fetch";

    /* renamed from: h */
    private static final String f37672h = "ccg_sp_config_file";

    private SpWrapper() {
    }

    /* renamed from: a */
    public static SharedPreferences m14703a(Context context) {
        if (context != null) {
            try {
                return context.getSharedPreferences(f37672h, 0);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
