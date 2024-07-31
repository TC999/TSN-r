package org.slf4j.helpers;

import java.io.PrintStream;

/* compiled from: Util.java */
/* renamed from: org.slf4j.helpers.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15428j {

    /* renamed from: a */
    private static C15430b f44363a;

    /* renamed from: b */
    private static boolean f44364b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Util.java */
    /* renamed from: org.slf4j.helpers.j$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15430b extends SecurityManager {
        private C15430b() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private C15428j() {
    }

    /* renamed from: a */
    public static Class<?> m2568a() {
        int i;
        C15430b m2567b = m2567b();
        if (m2567b == null) {
            return null;
        }
        Class<?>[] classContext = m2567b.getClassContext();
        String name = C15428j.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 < classContext.length && (i = i2 + 2) < classContext.length) {
            return classContext[i];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    /* renamed from: b */
    private static C15430b m2567b() {
        C15430b c15430b = f44363a;
        if (c15430b != null) {
            return c15430b;
        }
        if (f44364b) {
            return null;
        }
        C15430b m2564e = m2564e();
        f44363a = m2564e;
        f44364b = true;
        return m2564e;
    }

    /* renamed from: c */
    public static final void m2566c(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    /* renamed from: d */
    public static final void m2565d(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: e */
    private static C15430b m2564e() {
        try {
            return new C15430b();
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m2563f(String str) {
        String m2562g = m2562g(str);
        if (m2562g == null) {
            return false;
        }
        return m2562g.equalsIgnoreCase("true");
    }

    /* renamed from: g */
    public static String m2562g(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("null input");
    }
}
