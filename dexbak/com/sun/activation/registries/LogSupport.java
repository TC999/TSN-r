package com.sun.activation.registries;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.sun.activation.registries.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LogSupport {

    /* renamed from: a */
    private static boolean f35817a;

    /* renamed from: b */
    private static Logger f35818b;

    /* renamed from: c */
    private static final Level f35819c = Level.FINE;

    static {
        try {
            f35817a = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable unused) {
        }
        f35818b = Logger.getLogger("javax.activation");
    }

    private LogSupport() {
    }

    /* renamed from: a */
    public static boolean m16477a() {
        return f35817a || f35818b.isLoggable(f35819c);
    }

    /* renamed from: b */
    public static void m16476b(String str) {
        if (f35817a) {
            System.out.println(str);
        }
        f35818b.log(f35819c, str);
    }

    /* renamed from: c */
    public static void m16475c(String str, Throwable th) {
        if (f35817a) {
            PrintStream printStream = System.out;
            printStream.println(String.valueOf(str) + "; Exception: " + th);
        }
        f35818b.log(f35819c, str, th);
    }
}
