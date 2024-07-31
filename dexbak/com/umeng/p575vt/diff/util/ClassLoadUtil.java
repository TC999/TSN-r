package com.umeng.p575vt.diff.util;

import android.text.TextUtils;

/* renamed from: com.umeng.vt.diff.util.ClassLoadUtil */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ClassLoadUtil {
    public static Class<?> findClass(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
