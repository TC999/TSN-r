package com.hw.videoprocessor.util;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: CL.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f37607a;

    /* renamed from: b  reason: collision with root package name */
    private static int f37608b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: CL.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f37609a;

        /* renamed from: b  reason: collision with root package name */
        String f37610b;

        /* renamed from: c  reason: collision with root package name */
        int f37611c;

        a() {
        }
    }

    private c() {
    }

    private static String a(a aVar, String str, Object... objArr) {
        return "[" + aVar.f37609a + "." + aVar.f37610b + "():" + aVar.f37611c + "]" + i(str, objArr);
    }

    private static String b(a aVar, String str, Object... objArr) {
        return "[" + aVar.f37610b + "():" + aVar.f37611c + "]" + i(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.d(j4.f37609a, b(j4, str, objArr));
        }
    }

    public static void d(Throwable th) {
        if (f37607a) {
            Log.d(j(th.getStackTrace()).f37609a, "", th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (f37607a) {
            Log.d(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.e(j4.f37609a, b(j4, str, objArr));
        }
    }

    public static void g(Throwable th) {
        if (f37607a) {
            Log.e(j(th.getStackTrace()).f37609a, "", th);
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        if (f37607a) {
            Log.e(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    private static String i(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static a j(StackTraceElement[] stackTraceElementArr) {
        a aVar = new a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            aVar.f37609a = fileName;
            if (fileName.endsWith(".java")) {
                String str = aVar.f37609a;
                aVar.f37609a = str.substring(0, str.length() - 5);
            }
            aVar.f37610b = stackTraceElementArr[1].getMethodName();
            aVar.f37611c = stackTraceElementArr[1].getLineNumber();
        }
        return aVar;
    }

    public static void k(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.i(j4.f37609a, b(j4, str, objArr));
        }
    }

    public static void l(Throwable th) {
        if (f37607a) {
            Log.i(j(th.getStackTrace()).f37609a, "", th);
        }
    }

    public static boolean m() {
        return f37607a;
    }

    public static void n(String str, String str2, Object... objArr) {
        if (f37607a) {
            Log.i(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void o(String str) {
        if (f37607a) {
            Log.d(str, Log.getStackTraceString(new Throwable()));
        }
    }

    public static void p(boolean z3) {
        int i4 = f37608b + 1;
        f37608b = i4;
        if (i4 > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            f37607a = z3;
        }
    }

    public static void q(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.v(j4.f37609a, b(j4, str, objArr));
        }
    }

    public static void r(Throwable th) {
        if (f37607a) {
            Log.v(j(th.getStackTrace()).f37609a, "", th);
        }
    }

    public static void s(String str, String str2, Object... objArr) {
        if (f37607a) {
            Log.v(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void t(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.w(j4.f37609a, b(j4, str, objArr));
        }
    }

    public static void u(Throwable th) {
        if (f37607a) {
            Log.v(j(th.getStackTrace()).f37609a, "", th);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (f37607a) {
            Log.w(str, a(j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (f37607a) {
            a j4 = j(new Throwable().getStackTrace());
            Log.wtf(j4.f37609a, b(j4, str, objArr));
        }
    }
}
