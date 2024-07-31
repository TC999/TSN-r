package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import android.util.Log;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.kuaishou.weapon.p0.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7280e {

    /* renamed from: a */
    public static final int f24934a = 0;

    /* renamed from: b */
    public static final int f24935b = 1;

    /* renamed from: c */
    public static final int f24936c = 2;

    /* renamed from: d */
    public static final int f24937d = 3;

    /* renamed from: e */
    public static final int f24938e = -1;

    /* renamed from: f */
    public static int f24939f = -1;

    /* renamed from: g */
    static ThreadLocal<StringBuilder> f24940g = new ThreadLocal<>();

    /* renamed from: h */
    private static int f24941h;

    /* renamed from: a */
    private static void m33908a(int i, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else if (i != 2) {
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
        StringBuilder sb2 = f24940g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            f24940g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append("[");
            sb2.append(f24941h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(':');
            sb2.append(lineNumber);
            sb2.append('.');
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            sb = sb2.toString();
            f24941h++;
        }
        if (i == 0) {
            Log.i("WeaponSDK", sb);
        } else if (i == 1) {
            Log.d("WeaponSDK", sb);
        } else if (i != 2) {
        } else {
            Log.e("WeaponSDK", sb);
        }
    }

    /* renamed from: b */
    public static void m33904b(String str) {
        int i = f24939f;
        if (i == -1 || i == 0 || i == 1) {
            m33908a(1, str);
        }
    }

    /* renamed from: c */
    public static void m33902c(String str) {
        int i = f24939f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            m33908a(2, str);
        }
    }

    /* renamed from: d */
    public static void m33900d(String str) {
    }

    /* renamed from: b */
    public static void m33903b(String str, Throwable th) {
        int i = f24939f;
        if (i == -1 || i == 0 || i == 1) {
            m33908a(1, str + ShellAdbUtils.f33810d + m33905a(th));
        }
    }

    /* renamed from: c */
    public static void m33901c(String str, Throwable th) {
        int i = f24939f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            m33908a(2, str + ShellAdbUtils.f33810d + m33905a(th));
        }
    }

    /* renamed from: a */
    public static void m33907a(String str) {
        int i = f24939f;
        if (i == -1 || i == 0) {
            m33908a(0, str);
        }
    }

    /* renamed from: a */
    public static void m33906a(String str, Throwable th) {
        int i = f24939f;
        if (i == -1 || i == 0) {
            m33908a(0, str + ShellAdbUtils.f33810d + m33905a(th));
        }
    }

    /* renamed from: a */
    public static String m33905a(Throwable th) {
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
