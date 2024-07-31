package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.ExecShell;
import java.io.File;

/* renamed from: com.umeng.commonsdk.internal.utils.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Root {
    /* renamed from: a */
    public static boolean m13905a() {
        return m13904b() || m13903c() || m13902d() || m13901e();
    }

    /* renamed from: b */
    private static boolean m13904b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: c */
    private static boolean m13903c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return new File("/system/app/Kinguser.apk").exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m13902d() {
        return new ExecShell().m13908a(ExecShell.EnumC13233a.check_su_binary) != null;
    }

    /* renamed from: e */
    private static boolean m13901e() {
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 12; i++) {
            String str = strArr[i];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
