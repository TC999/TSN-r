package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dm {

    /* renamed from: a  reason: collision with root package name */
    private static a f38315a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dm() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        a aVar = f38315a;
        if (aVar != null) {
            return aVar;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 21) {
            f38315a = a.ARMEABI_V7A;
        } else if (i4 >= 23) {
            f38315a = Process.is64Bit() ? a.ARM64_V8A : a.ARMEABI_V7A;
        } else if (i4 >= 21) {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                f38315a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f38315a = a.ARM64_V8A;
                    } else {
                        f38315a = a.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f38315a = a.UNKNOWN;
                }
            }
        }
        return f38315a;
    }
}
