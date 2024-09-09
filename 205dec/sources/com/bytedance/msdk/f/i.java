package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private static final HashSet f28327c = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String c(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                if (!f28327c.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP)) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                } else {
                    continue;
                }
            }
        }
        return jSONArray.toString();
    }

    public static String w(StackTraceElement[] stackTraceElementArr) {
        Map<String, List<String>> ba = com.bytedance.msdk.core.c.w().ba();
        if (ba == null || ba.isEmpty()) {
            return null;
        }
        for (String str : ba.keySet()) {
            if (c(ba.get(str), stackTraceElementArr)) {
                return str;
            }
        }
        return null;
    }

    private static boolean w() {
        Map<String, List<String>> ba = com.bytedance.msdk.core.c.w().ba();
        if (ba == null || ba.size() == 0) {
            return false;
        }
        return c(com.bytedance.msdk.core.c.w().y());
    }

    public static String c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (c(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private static boolean c(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i4) != null && stackTraceElement.toString().contains(list.get(i4))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean c(com.bytedance.msdk.c.ux uxVar) {
        if (uxVar == null || !uxVar.isCustomAd()) {
            return false;
        }
        return w();
    }

    public static boolean c(com.bytedance.msdk.core.k.p pVar) {
        if (pVar == null || !pVar.yu()) {
            return false;
        }
        return w();
    }

    public static boolean c(double d4) {
        return d4 > 0.0d && Math.random() <= d4;
    }

    public static double c() {
        return com.bytedance.msdk.core.c.w().y();
    }
}
