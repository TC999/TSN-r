package com.qq.e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f41662a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f41663b;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("\u63d2\u4ef6\u9519\u8bef\uff1a" + str, th);
            if (f41663b) {
                return;
            }
            if (f41662a == null) {
                Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
                f41662a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f41662a.invoke(null, exc);
        } catch (Throwable unused) {
            f41663b = true;
        }
    }
}
