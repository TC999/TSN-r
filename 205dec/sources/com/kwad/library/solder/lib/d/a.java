package com.kwad.library.solder.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static String akp;
    private static String akq;
    private static final Map<String, String> akr;

    static {
        HashMap hashMap = new HashMap();
        akr = hashMap;
        hashMap.put("mips", "mips");
        hashMap.put("mips64", "mips64");
        hashMap.put("x86", "x86");
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            return Process.is64Bit();
        }
        if (i4 >= 21) {
            Boolean bool = null;
            try {
                bool = (Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }

    public static String xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
