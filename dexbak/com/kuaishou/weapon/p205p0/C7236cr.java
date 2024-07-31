package com.kuaishou.weapon.p205p0;

/* renamed from: com.kuaishou.weapon.p0.cr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7236cr {

    /* renamed from: a */
    private static volatile boolean f24725a = false;

    /* renamed from: b */
    private static volatile boolean f24726b = true;

    static {
        try {
            f24725a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f24725a = false;
        }
        f24726b = System.getProperty("java.vm.version").startsWith("2");
    }

    /* renamed from: a */
    public static boolean m34042a() {
        return f24725a;
    }

    /* renamed from: b */
    public static boolean m34041b() {
        return f24726b;
    }
}
