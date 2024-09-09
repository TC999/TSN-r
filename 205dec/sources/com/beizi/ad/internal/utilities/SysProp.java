package com.beizi.ad.internal.utilities;

import com.acse.ottn.f3;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SysProp {
    private static Method sysPropGet;
    private static Method sysPropGetLong;
    private static Method sysPropSet;

    static {
        Method[] methods;
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("getLong")) {
                    sysPropGetLong = method;
                } else if (name.equals(f3.f5659h)) {
                    sysPropSet = method;
                } else if (name.equals(f3.f5657f)) {
                    sysPropGet = method;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private SysProp() {
    }

    public static String get(String str, String str2) {
        try {
            return (String) sysPropGet.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static long getLong(String str, long j4) {
        try {
            return ((Long) sysPropGetLong.invoke(null, str, Long.valueOf(j4))).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return j4;
        }
    }

    public static void set(String str, String str2) {
        try {
            sysPropSet.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
