package org.slf4j.helpers;

import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static b f61763a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f61764b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Util.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends SecurityManager {
        private b() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private j() {
    }

    public static Class<?> a() {
        int i4;
        b b4 = b();
        if (b4 == null) {
            return null;
        }
        Class<?>[] classContext = b4.getClassContext();
        String name = j.class.getName();
        int i5 = 0;
        while (i5 < classContext.length && !name.equals(classContext[i5].getName())) {
            i5++;
        }
        if (i5 < classContext.length && (i4 = i5 + 2) < classContext.length) {
            return classContext[i4];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    private static b b() {
        b bVar = f61763a;
        if (bVar != null) {
            return bVar;
        }
        if (f61764b) {
            return null;
        }
        b e4 = e();
        f61763a = e4;
        f61764b = true;
        return e4;
    }

    public static final void c(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void d(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    private static b e() {
        try {
            return new b();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean f(String str) {
        String g4 = g(str);
        if (g4 == null) {
            return false;
        }
        return g4.equalsIgnoreCase("true");
    }

    public static String g(String str) {
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
