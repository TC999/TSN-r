package com.beizi.p051ad.internal.utilities;

import java.lang.reflect.Method;

/* renamed from: com.beizi.ad.internal.utilities.SysProp */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
                } else if (name.equals("set")) {
                    sysPropSet = method;
                } else if (name.equals("get")) {
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

    public static long getLong(String str, long j) {
        try {
            return ((Long) sysPropGetLong.invoke(null, str, Long.valueOf(j))).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return j;
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
