package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13058f {

    /* renamed from: a */
    private String f37424a;

    /* renamed from: b */
    private String f37425b;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.f$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13060a {

        /* renamed from: a */
        private static C13058f f37426a = new C13058f();
    }

    /* renamed from: a */
    public static C13058f m15034a() {
        return C13060a.f37426a;
    }

    /* renamed from: b */
    public String m15030b(Context context) {
        return this.f37424a;
    }

    /* renamed from: c */
    public String m15029c(Context context) {
        return this.f37425b;
    }

    private C13058f() {
        this.f37424a = "";
        this.f37425b = "";
    }

    /* renamed from: a */
    public void m15033a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f37425b;
        if (str == null || str.trim().isEmpty()) {
            this.f37425b = sharedPreferences.getString("build_model", "");
            SLog.m15127i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f37425b);
        }
        String str2 = this.f37424a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f37424a = sharedPreferences.getString("build_device", "");
            SLog.m15127i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.f37424a);
        }
    }

    /* renamed from: b */
    public String m15031b() {
        return this.f37425b;
    }

    /* renamed from: a */
    public void m15032a(Context context, String str) {
        SLog.m15127i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f37425b;
            if (str2 != null && str2.equals(str)) {
                SLog.m15127i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f37425b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f37425b).commit();
                SLog.m15127i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f37425b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}
