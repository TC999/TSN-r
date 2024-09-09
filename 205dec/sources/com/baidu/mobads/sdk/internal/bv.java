package com.baidu.mobads.sdk.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bv {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12551a = "logger";

    /* renamed from: b  reason: collision with root package name */
    public static final int f12552b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12553c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f12554d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12555e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static final int f12556f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f12557g = 7;

    /* renamed from: h  reason: collision with root package name */
    public static final int f12558h = -1;

    /* renamed from: i  reason: collision with root package name */
    private static volatile bv f12559i;

    private bv() {
    }

    public static bv a() {
        if (f12559i == null) {
            synchronized (bv.class) {
                if (f12559i == null) {
                    f12559i = new bv();
                }
            }
        }
        return f12559i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public boolean a(String str, int i4) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                az.c().e(str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b("logger", str);
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                az.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                az.c().c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                az.c().d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                az.c().e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(int i4) {
        return a("logger", i4);
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                az.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        a("logger", str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                az.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                az.h("logger").b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
