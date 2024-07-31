package com.p201hw.videoprocessor.util;

import android.util.Log;

/* renamed from: com.hw.videoprocessor.util.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CL {

    /* renamed from: a */
    private static boolean f24125a;

    /* renamed from: b */
    private static int f24126b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CL.java */
    /* renamed from: com.hw.videoprocessor.util.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7072a {

        /* renamed from: a */
        String f24127a;

        /* renamed from: b */
        String f24128b;

        /* renamed from: c */
        int f24129c;

        C7072a() {
        }
    }

    private CL() {
    }

    /* renamed from: a */
    private static String m34901a(C7072a c7072a, String str, Object... objArr) {
        return "[" + c7072a.f24127a + "." + c7072a.f24128b + "():" + c7072a.f24129c + "]" + m34893i(str, objArr);
    }

    /* renamed from: b */
    private static String m34900b(C7072a c7072a, String str, Object... objArr) {
        return "[" + c7072a.f24128b + "():" + c7072a.f24129c + "]" + m34893i(str, objArr);
    }

    /* renamed from: c */
    public static void m34899c(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.d(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }

    /* renamed from: d */
    public static void m34898d(Throwable th) {
        if (f24125a) {
            Log.d(m34892j(th.getStackTrace()).f24127a, "", th);
        }
    }

    /* renamed from: e */
    public static void m34897e(String str, String str2, Object... objArr) {
        if (f24125a) {
            Log.d(str, m34901a(m34892j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    /* renamed from: f */
    public static void m34896f(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.e(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }

    /* renamed from: g */
    public static void m34895g(Throwable th) {
        if (f24125a) {
            Log.e(m34892j(th.getStackTrace()).f24127a, "", th);
        }
    }

    /* renamed from: h */
    public static void m34894h(String str, String str2, Object... objArr) {
        if (f24125a) {
            Log.e(str, m34901a(m34892j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    /* renamed from: i */
    private static String m34893i(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    /* renamed from: j */
    private static C7072a m34892j(StackTraceElement[] stackTraceElementArr) {
        C7072a c7072a = new C7072a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            c7072a.f24127a = fileName;
            if (fileName.endsWith(".java")) {
                String str = c7072a.f24127a;
                c7072a.f24127a = str.substring(0, str.length() - 5);
            }
            c7072a.f24128b = stackTraceElementArr[1].getMethodName();
            c7072a.f24129c = stackTraceElementArr[1].getLineNumber();
        }
        return c7072a;
    }

    /* renamed from: k */
    public static void m34891k(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.i(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }

    /* renamed from: l */
    public static void m34890l(Throwable th) {
        if (f24125a) {
            Log.i(m34892j(th.getStackTrace()).f24127a, "", th);
        }
    }

    /* renamed from: m */
    public static boolean m34889m() {
        return f24125a;
    }

    /* renamed from: n */
    public static void m34888n(String str, String str2, Object... objArr) {
        if (f24125a) {
            Log.i(str, m34901a(m34892j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    /* renamed from: o */
    public static void m34887o(String str) {
        if (f24125a) {
            Log.d(str, Log.getStackTraceString(new Throwable()));
        }
    }

    /* renamed from: p */
    public static void m34886p(boolean z) {
        int i = f24126b + 1;
        f24126b = i;
        if (i > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            f24125a = z;
        }
    }

    /* renamed from: q */
    public static void m34885q(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.v(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }

    /* renamed from: r */
    public static void m34884r(Throwable th) {
        if (f24125a) {
            Log.v(m34892j(th.getStackTrace()).f24127a, "", th);
        }
    }

    /* renamed from: s */
    public static void m34883s(String str, String str2, Object... objArr) {
        if (f24125a) {
            Log.v(str, m34901a(m34892j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    /* renamed from: t */
    public static void m34882t(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.w(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }

    /* renamed from: u */
    public static void m34881u(Throwable th) {
        if (f24125a) {
            Log.v(m34892j(th.getStackTrace()).f24127a, "", th);
        }
    }

    /* renamed from: v */
    public static void m34880v(String str, String str2, Object... objArr) {
        if (f24125a) {
            Log.w(str, m34901a(m34892j(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m34879w(String str, Object... objArr) {
        if (f24125a) {
            C7072a m34892j = m34892j(new Throwable().getStackTrace());
            Log.wtf(m34892j.f24127a, m34900b(m34892j, str, objArr));
        }
    }
}
