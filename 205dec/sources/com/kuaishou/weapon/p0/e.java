package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f38330a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f38331b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38332c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f38333d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f38334e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f38335f = -1;

    /* renamed from: g  reason: collision with root package name */
    static ThreadLocal<StringBuilder> f38336g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private static int f38337h;

    private static void a(int i4, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i4 == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i4 == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else if (i4 != 2) {
                return;
            } else {
                Log.e("WeaponSDK", str);
                return;
            }
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = f38336g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            f38336g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append("[");
            sb2.append(f38337h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(':');
            sb2.append(lineNumber);
            sb2.append('.');
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            sb = sb2.toString();
            f38337h++;
        }
        if (i4 == 0) {
            Log.i("WeaponSDK", sb);
        } else if (i4 == 1) {
            Log.d("WeaponSDK", sb);
        } else if (i4 != 2) {
        } else {
            Log.e("WeaponSDK", sb);
        }
    }

    public static void b(String str) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0 || i4 == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0 || i4 == 1 || i4 == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    public static void b(String str, Throwable th) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0 || i4 == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str, Throwable th) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0 || i4 == 1 || i4 == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void a(String str) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i4 = f38335f;
        if (i4 == -1 || i4 == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
