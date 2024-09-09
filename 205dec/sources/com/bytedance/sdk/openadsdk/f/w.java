package com.bytedance.sdk.openadsdk.f;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static void c(Object obj) {
        try {
            xv(obj);
        } catch (Throwable th) {
            a.sr("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    private static String f(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        return ttc == null ? "" : ttc.value();
    }

    private static void sr(Object obj) {
        if (obj instanceof TTILog) {
            LogAdapter.zzz((TTILog) obj, true);
        }
    }

    private static void ux(Object obj) {
        Method[] declaredMethods;
        if (a.xv()) {
            sr srVar = new sr();
            sr.f35859c = srVar;
            for (Method method : obj.getClass().getDeclaredMethods()) {
                TTM ttm = (TTM) method.getAnnotation(TTM.class);
                if (ttm != null) {
                    method.setAccessible(true);
                    srVar.c(ttm.value(), method);
                }
            }
            srVar.c(obj);
        }
    }

    public static void w(Object obj) {
        c(f(obj));
    }

    private static void xv(Object obj) {
        if (obj == null) {
            return;
        }
        String f4 = f(obj);
        f4.hashCode();
        if (f4.equals("log")) {
            sr(obj);
        } else if (f4.equals("net")) {
            ux(obj);
        }
        a.sr("HookObject", "register object  " + obj + " successed~ ");
    }

    public static xv w(String str) {
        str.hashCode();
        if (str.equals("net")) {
            return sr.f35859c;
        }
        return null;
    }

    public static void c(String str) {
        str.hashCode();
        if (str.equals("net")) {
            sr.f35859c = null;
        }
    }
}
