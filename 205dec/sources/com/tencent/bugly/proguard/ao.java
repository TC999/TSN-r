package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ao {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50925a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50926b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f50927c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f50928d = 30720;

    /* renamed from: e  reason: collision with root package name */
    private static StringBuilder f50929e;

    /* renamed from: f  reason: collision with root package name */
    private static StringBuilder f50930f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f50931g;

    /* renamed from: h  reason: collision with root package name */
    private static a f50932h;

    /* renamed from: i  reason: collision with root package name */
    private static String f50933i;

    /* renamed from: j  reason: collision with root package name */
    private static String f50934j;

    /* renamed from: k  reason: collision with root package name */
    private static Context f50935k;

    /* renamed from: l  reason: collision with root package name */
    private static String f50936l;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f50937m;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f50938n;

    /* renamed from: o  reason: collision with root package name */
    private static ExecutorService f50939o;

    /* renamed from: p  reason: collision with root package name */
    private static int f50940p;

    /* renamed from: q  reason: collision with root package name */
    private static final Object f50941q = new Object();

    static {
        try {
            f50927c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ao.class) {
            if (f50937m || context == null || !f50926b) {
                return;
            }
            try {
                f50939o = Executors.newSingleThreadExecutor();
                f50930f = new StringBuilder(0);
                f50929e = new StringBuilder(0);
                f50935k = context;
                f50933i = aa.a(context).f50825d;
                f50934j = "";
                f50936l = f50935k.getFilesDir().getPath() + "/buglylog_" + f50933i + "_" + f50934j + ".txt";
                f50940p = Process.myPid();
            } catch (Throwable unused) {
            }
            f50937m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        q qVar;
        try {
            aa b4 = aa.b();
            if (b4 == null || (qVar = b4.N) == null) {
                return false;
            }
            return qVar.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (f50925a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a4 = a(str, str2, str3, Process.myTid());
            synchronized (f50941q) {
                f50930f.append(a4);
                if (f50930f.length() >= f50928d) {
                    StringBuilder sb = f50930f;
                    f50930f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a4 = a(str, str2, str3, Process.myTid());
            synchronized (f50941q) {
                try {
                    f50930f.append(a4);
                } catch (Throwable unused) {
                }
                if (f50930f.length() <= f50928d) {
                    return;
                }
                if (f50931g) {
                    return;
                }
                f50931g = true;
                a aVar = f50932h;
                if (aVar == null) {
                    f50932h = new a(f50936l);
                } else {
                    File file = aVar.f50949b;
                    if (file == null || file.length() + f50930f.length() > f50932h.f50950c) {
                        f50932h.a();
                    }
                }
                if (f50932h.a(f50930f.toString())) {
                    f50930f.setLength(0);
                    f50931g = false;
                }
            }
        }
    }

    private static String b() {
        q qVar;
        try {
            aa b4 = aa.b();
            if (b4 == null || (qVar = b4.N) == null) {
                return null;
            }
            return qVar.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        File file;
        if (f50926b) {
            if (f50938n) {
                al.a("[LogUtil] Get user log from native.", new Object[0]);
                String b4 = b();
                if (b4 != null) {
                    al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b4.length()));
                    return ap.a(b4, "BuglyNativeLog.txt");
                }
            }
            StringBuilder sb = new StringBuilder();
            synchronized (f50941q) {
                a aVar = f50932h;
                if (aVar != null && aVar.f50948a && (file = aVar.f50949b) != null && file.length() > 0) {
                    sb.append(ap.a(f50932h.f50949b, 30720, true));
                }
                StringBuilder sb2 = f50930f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f50930f.toString());
                }
            }
            return ap.a(sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f50948a;

        /* renamed from: b  reason: collision with root package name */
        File f50949b;

        /* renamed from: c  reason: collision with root package name */
        long f50950c = 30720;

        /* renamed from: d  reason: collision with root package name */
        private String f50951d;

        /* renamed from: e  reason: collision with root package name */
        private long f50952e;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f50951d = str;
            this.f50948a = a();
        }

        final boolean a() {
            try {
                File file = new File(this.f50951d);
                this.f50949b = file;
                if (file.exists() && !this.f50949b.delete()) {
                    this.f50948a = false;
                    return false;
                } else if (this.f50949b.createNewFile()) {
                    return true;
                } else {
                    this.f50948a = false;
                    return false;
                }
            } catch (Throwable th) {
                al.a(th);
                this.f50948a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            byte[] bytes;
            if (this.f50948a) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(this.f50949b, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f50952e += bytes.length;
                    this.f50948a = true;
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        al.a(th);
                        this.f50948a = false;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            return false;
        }
    }

    public static void a(int i4) {
        synchronized (f50941q) {
            f50928d = i4;
            if (i4 < 0) {
                f50928d = 0;
            } else if (i4 > 30720) {
                f50928d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (ao.class) {
            if (f50937m && f50926b) {
                try {
                    if (f50938n) {
                        f50939o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.d(str, str2, str3);
                            }
                        });
                    } else {
                        f50939o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.e(str, str2, str3);
                            }
                        });
                    }
                } catch (Exception e4) {
                    al.b(e4);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j4) {
        String date;
        f50929e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f50927c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f50929e;
        sb.append(date);
        sb.append(" ");
        sb.append(f50940p);
        sb.append(" ");
        sb.append(j4);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f50929e.toString();
    }

    public static byte[] a() {
        if (f50925a) {
            if (f50926b) {
                return ap.a(f50930f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}
