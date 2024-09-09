package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SpWrapper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52557a = "cl_count";

    /* renamed from: b  reason: collision with root package name */
    public static final String f52558b = "interval_";

    /* renamed from: c  reason: collision with root package name */
    public static final String f52559c = "config_ts";

    /* renamed from: d  reason: collision with root package name */
    public static final String f52560d = "iucc_s1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f52561e = "iucc_s2";

    /* renamed from: f  reason: collision with root package name */
    public static final String f52562f = "sdk_type_ver";

    /* renamed from: g  reason: collision with root package name */
    public static final String f52563g = "should_fetch";

    /* renamed from: h  reason: collision with root package name */
    private static final String f52564h = "ccg_sp_config_file";

    private ar() {
    }

    public static SharedPreferences a(Context context) {
        if (context != null) {
            try {
                return context.getSharedPreferences("ccg_sp_config_file", 0);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
