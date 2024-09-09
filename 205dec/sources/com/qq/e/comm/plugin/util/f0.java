package com.qq.e.comm.plugin.util;

import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.c4;
import com.acse.ottn.f3;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static String f46418a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f46419b;

    public static String a() {
        String str = f46418a;
        if (str != null) {
            return str;
        }
        if (!c()) {
            f46418a = "";
            return "";
        }
        String a4 = a("hw_sc.build.platform.version", "0.0.0");
        f46418a = a4;
        return a4;
    }

    public static int b() {
        if (c()) {
            return Settings.Secure.getInt(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "pure_mode_state", -1);
        }
        return -1;
    }

    public static boolean c() {
        Boolean bool = f46419b;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            method.setAccessible(true);
            f46419b = Boolean.valueOf(c4.f5363a.equals(method.invoke(cls, new Object[0])));
        } catch (Exception unused) {
            f46419b = Boolean.FALSE;
        }
        return f46419b.booleanValue();
    }

    private static String a(String str, String str2) {
        Throwable th;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, str);
        } catch (Throwable th2) {
            th = th2;
            str3 = str2;
        }
        try {
            d1.a("getSystemProperty value: " + str3, new Object[0]);
        } catch (Throwable th3) {
            th = th3;
            d1.a("getSystemProperty error: " + th.getMessage());
            return str3;
        }
        return str3;
    }
}
