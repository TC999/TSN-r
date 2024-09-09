package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean is64Bit() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            return Process.is64Bit();
        }
        if (i4 >= 21) {
            try {
                return ((Boolean) Reflect.cg("dalvik.system.VMRuntime").cj("getRuntime").cj("is64Bit").get()).booleanValue();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static String xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
