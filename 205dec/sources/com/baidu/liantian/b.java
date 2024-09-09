package com.baidu.liantian;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: BaiduLog.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f12109a = -1;

    /* renamed from: b  reason: collision with root package name */
    static ThreadLocal<StringBuilder> f12110b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f12111c;

    public static String a(Throwable th) {
        StringWriter stringWriter;
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
            try {
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return "";
            }
        }
        StringWriter stringWriter2 = null;
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter3 = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return stringWriter3;
        } catch (Throwable th4) {
            th = th4;
            stringWriter2 = stringWriter;
            if (stringWriter2 != null) {
                try {
                    stringWriter2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }
}
