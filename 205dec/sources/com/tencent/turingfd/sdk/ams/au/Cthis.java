package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.lang.reflect.Method;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.this  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cthis {

    /* renamed from: a  reason: collision with root package name */
    public static Object f52363a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f52364b;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                f52364b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f52363a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a() {
        Method method;
        String[] strArr = {"L"};
        Object obj = f52363a;
        if (obj != null && (method = f52364b) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
