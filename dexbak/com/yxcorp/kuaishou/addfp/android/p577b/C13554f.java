package com.yxcorp.kuaishou.addfp.android.p577b;

import android.os.Build;
import java.lang.reflect.Method;

/* renamed from: com.yxcorp.kuaishou.addfp.android.b.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13554f {

    /* renamed from: a */
    private static Object f40055a;

    /* renamed from: b */
    private static Method f40056b;

    /* renamed from: c */
    public static final /* synthetic */ int f40057c = 0;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                f40056b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f40055a = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m12876a() {
        Method method;
        String[] strArr = {"L"};
        Object obj = f40055a;
        if (obj != null && (method = f40056b) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
