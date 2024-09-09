package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38339a = "android.permission.INTERNET";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38340b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38341c = "android.permission.READ_PHONE_STATE";

    /* renamed from: d  reason: collision with root package name */
    public static final String f38342d = "android.permission.ACCESS_WIFI_STATE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f38343e = "android.permission.GET_TASKS";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38344f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g  reason: collision with root package name */
    public static final String f38345g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h  reason: collision with root package name */
    public static final String f38346h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i  reason: collision with root package name */
    public static final String f38347i = "android.permission.READ_EXTERNAL_STORAGE";

    /* renamed from: j  reason: collision with root package name */
    public static final String f38348j = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: k  reason: collision with root package name */
    public static final String f38349k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static boolean a(Context context, String[] strArr) {
        if (strArr != null) {
            try {
                for (String str : strArr) {
                    if (a(context, str) != 0) {
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

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
