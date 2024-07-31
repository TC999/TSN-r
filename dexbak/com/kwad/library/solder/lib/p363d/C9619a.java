package com.kwad.library.solder.lib.p363d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.C11124s;
import java.util.HashMap;
import java.util.Map;
import tv.cjump.jni.DeviceUtils;

/* renamed from: com.kwad.library.solder.lib.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9619a {
    private static String akp;
    private static String akq;
    private static final Map<String, String> akr;

    static {
        HashMap hashMap = new HashMap();
        akr = hashMap;
        hashMap.put(DeviceUtils.f47126b, DeviceUtils.f47126b);
        hashMap.put("mips64", "mips64");
        hashMap.put(DeviceUtils.f47125a, DeviceUtils.f47125a);
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i >= 21) {
            Boolean bool = null;
            try {
                bool = (Boolean) C11124s.callMethod(C11124s.m23705a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }

    /* renamed from: xK */
    public static String m28188xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
