package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* renamed from: com.kuaishou.weapon.p0.dm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7269dm {

    /* renamed from: a */
    private static EnumC7270a f24919a;

    /* renamed from: com.kuaishou.weapon.p0.dm$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum EnumC7270a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private C7269dm() {
    }

    /* renamed from: a */
    public static String m33942a(Context context) {
        return m33941b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    /* renamed from: b */
    public static boolean m33941b(Context context) {
        return m33940c(context) == EnumC7270a.ARM64_V8A;
    }

    /* renamed from: c */
    private static EnumC7270a m33940c(Context context) {
        EnumC7270a enumC7270a = f24919a;
        if (enumC7270a != null) {
            return enumC7270a;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            f24919a = EnumC7270a.ARMEABI_V7A;
        } else if (i >= 23) {
            f24919a = Process.is64Bit() ? EnumC7270a.ARM64_V8A : EnumC7270a.ARMEABI_V7A;
        } else if (i >= 21) {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                f24919a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? EnumC7270a.ARM64_V8A : EnumC7270a.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f24919a = EnumC7270a.ARM64_V8A;
                    } else {
                        f24919a = EnumC7270a.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f24919a = EnumC7270a.UNKNOWN;
                }
            }
        }
        return f24919a;
    }
}
