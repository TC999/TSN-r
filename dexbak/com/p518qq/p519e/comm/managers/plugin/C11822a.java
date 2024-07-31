package com.p518qq.p519e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* renamed from: com.qq.e.comm.managers.plugin.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11822a {

    /* renamed from: a */
    private static Method f32928a;

    /* renamed from: b */
    private static boolean f32929b;

    /* renamed from: a */
    public static void m20336a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f32929b) {
                return;
            }
            if (f32928a == null) {
                Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
                f32928a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f32928a.invoke(null, exc);
        } catch (Throwable unused) {
            f32929b = true;
        }
    }
}
