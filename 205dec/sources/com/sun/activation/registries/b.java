package com.sun.activation.registries;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LogSupport.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f50238a;

    /* renamed from: b  reason: collision with root package name */
    private static Logger f50239b;

    /* renamed from: c  reason: collision with root package name */
    private static final Level f50240c = Level.FINE;

    static {
        try {
            f50238a = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable unused) {
        }
        f50239b = Logger.getLogger("javax.activation");
    }

    private b() {
    }

    public static boolean a() {
        return f50238a || f50239b.isLoggable(f50240c);
    }

    public static void b(String str) {
        if (f50238a) {
            System.out.println(str);
        }
        f50239b.log(f50240c, str);
    }

    public static void c(String str, Throwable th) {
        if (f50238a) {
            PrintStream printStream = System.out;
            printStream.println(String.valueOf(str) + "; Exception: " + th);
        }
        f50239b.log(f50240c, str, th);
    }
}
