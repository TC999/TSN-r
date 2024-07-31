package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Process;

/* renamed from: com.kuaishou.weapon.p0.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7282g {

    /* renamed from: a */
    public static final String f24943a = "android.permission.INTERNET";

    /* renamed from: b */
    public static final String f24944b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c */
    public static final String f24945c = "android.permission.READ_PHONE_STATE";

    /* renamed from: d */
    public static final String f24946d = "android.permission.ACCESS_WIFI_STATE";

    /* renamed from: e */
    public static final String f24947e = "android.permission.GET_TASKS";

    /* renamed from: f */
    public static final String f24948f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g */
    public static final String f24949g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h */
    public static final String f24950h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i */
    public static final String f24951i = "android.permission.READ_EXTERNAL_STORAGE";

    /* renamed from: j */
    public static final String f24952j = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: k */
    public static final String f24953k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    /* renamed from: a */
    public static boolean m33891a(Context context, String[] strArr) {
        if (strArr != null) {
            try {
                for (String str : strArr) {
                    if (m33892a(context, str) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m33892a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
