package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* renamed from: com.kwad.sdk.api.loader.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9764w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i >= 21) {
            try {
                return ((Boolean) Reflect.m27983cg("dalvik.system.VMRuntime").m27980cj("getRuntime").m27980cj("is64Bit").get()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: xK */
    public static String m27832xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
