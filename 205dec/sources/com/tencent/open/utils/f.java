package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f51824a;

    /* renamed from: b  reason: collision with root package name */
    private String f51825b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static f f51826a = new f();
    }

    public static f a() {
        return a.f51826a;
    }

    public String b(Context context) {
        return this.f51824a;
    }

    public String c(Context context) {
        return this.f51825b;
    }

    private f() {
        this.f51824a = "";
        this.f51825b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f51825b;
        if (str == null || str.trim().isEmpty()) {
            this.f51825b = sharedPreferences.getString("build_model", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f51825b);
        }
        String str2 = this.f51824a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f51824a = sharedPreferences.getString("build_device", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.f51824a);
        }
    }

    public String b() {
        return this.f51825b;
    }

    public void a(Context context, String str) {
        SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f51825b;
            if (str2 != null && str2.equals(str)) {
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f51825b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f51825b).commit();
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f51825b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}
