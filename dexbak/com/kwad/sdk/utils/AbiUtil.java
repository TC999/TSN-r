package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AbiUtil {
    private static Abi aOd;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    /* renamed from: bD */
    public static String m24284bD(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    /* renamed from: bE */
    private static Abi m24283bE(Context context) {
        Abi abi = aOd;
        if (abi != null) {
            return abi;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            aOd = Abi.ARMEABI_V7A;
        } else if (i >= 23) {
            aOd = Process.is64Bit() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else if (i >= 21) {
            try {
                aOd = ((Boolean) C11124s.callMethod(C11124s.m23705a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aOd = Abi.ARM64_V8A;
                    } else {
                        aOd = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    aOd = Abi.UNKNOWN;
                }
            }
        }
        return aOd;
    }

    public static boolean isArm64(Context context) {
        return m24283bE(context) == Abi.ARM64_V8A;
    }
}
