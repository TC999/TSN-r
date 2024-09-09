package com.kuaishou.weapon.p0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cr {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f38221a = false;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f38222b = true;

    static {
        try {
            f38221a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f38221a = false;
        }
        f38222b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f38221a;
    }

    public static boolean b() {
        return f38222b;
    }
}
