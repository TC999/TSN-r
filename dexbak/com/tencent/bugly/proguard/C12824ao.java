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

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ao */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12824ao {

    /* renamed from: a */
    public static boolean f36551a = true;

    /* renamed from: b */
    public static boolean f36552b = true;

    /* renamed from: c */
    private static SimpleDateFormat f36553c = null;

    /* renamed from: d */
    private static int f36554d = 30720;

    /* renamed from: e */
    private static StringBuilder f36555e;

    /* renamed from: f */
    private static StringBuilder f36556f;

    /* renamed from: g */
    private static boolean f36557g;

    /* renamed from: h */
    private static C12827a f36558h;

    /* renamed from: i */
    private static String f36559i;

    /* renamed from: j */
    private static String f36560j;

    /* renamed from: k */
    private static Context f36561k;

    /* renamed from: l */
    private static String f36562l;

    /* renamed from: m */
    private static boolean f36563m;

    /* renamed from: n */
    private static boolean f36564n;

    /* renamed from: o */
    private static ExecutorService f36565o;

    /* renamed from: p */
    private static int f36566p;

    /* renamed from: q */
    private static final Object f36567q = new Object();

    static {
        try {
            f36553c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            C12820al.m15875b(th.getCause());
        }
    }

    /* renamed from: a */
    public static synchronized void m15862a(Context context) {
        synchronized (C12824ao.class) {
            if (f36563m || context == null || !f36552b) {
                return;
            }
            try {
                f36565o = Executors.newSingleThreadExecutor();
                f36556f = new StringBuilder(0);
                f36555e = new StringBuilder(0);
                f36561k = context;
                f36559i = C12786aa.m16009a(context).f36451d;
                f36560j = "";
                f36562l = f36561k.getFilesDir().getPath() + "/buglylog_" + f36559i + "_" + f36560j + ".txt";
                f36566p = Process.myPid();
            } catch (Throwable unused) {
            }
            f36563m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m15854d(String str, String str2, String str3) {
        InterfaceC12905q interfaceC12905q;
        try {
            C12786aa m16005b = C12786aa.m16005b();
            if (m16005b == null || (interfaceC12905q = m16005b.f36412N) == null) {
                return false;
            }
            return interfaceC12905q.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static synchronized void m15853e(String str, String str2, String str3) {
        synchronized (C12824ao.class) {
            if (f36551a) {
                m15852f(str, str2, str3);
            } else {
                m15851g(str, str2, str3);
            }
        }
    }

    /* renamed from: f */
    private static synchronized void m15852f(String str, String str2, String str3) {
        synchronized (C12824ao.class) {
            String m15860a = m15860a(str, str2, str3, Process.myTid());
            synchronized (f36567q) {
                f36556f.append(m15860a);
                if (f36556f.length() >= f36554d) {
                    StringBuilder sb = f36556f;
                    f36556f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    /* renamed from: g */
    private static synchronized void m15851g(String str, String str2, String str3) {
        synchronized (C12824ao.class) {
            String m15860a = m15860a(str, str2, str3, Process.myTid());
            synchronized (f36567q) {
                try {
                    f36556f.append(m15860a);
                } catch (Throwable unused) {
                }
                if (f36556f.length() <= f36554d) {
                    return;
                }
                if (f36557g) {
                    return;
                }
                f36557g = true;
                C12827a c12827a = f36558h;
                if (c12827a == null) {
                    f36558h = new C12827a(f36562l);
                } else {
                    File file = c12827a.f36575b;
                    if (file == null || file.length() + f36556f.length() > f36558h.f36576c) {
                        f36558h.m15850a();
                    }
                }
                if (f36558h.m15849a(f36556f.toString())) {
                    f36556f.setLength(0);
                    f36557g = false;
                }
            }
        }
    }

    /* renamed from: b */
    private static String m15858b() {
        InterfaceC12905q interfaceC12905q;
        try {
            C12786aa m16005b = C12786aa.m16005b();
            if (m16005b == null || (interfaceC12905q = m16005b.f36412N) == null) {
                return null;
            }
            return interfaceC12905q.getLogFromNative();
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static byte[] m15856c() {
        File file;
        if (f36552b) {
            if (f36564n) {
                C12820al.m15878a("[LogUtil] Get user log from native.", new Object[0]);
                String m15858b = m15858b();
                if (m15858b != null) {
                    C12820al.m15878a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(m15858b.length()));
                    return C12828ap.m15831a(m15858b, "BuglyNativeLog.txt");
                }
            }
            StringBuilder sb = new StringBuilder();
            synchronized (f36567q) {
                C12827a c12827a = f36558h;
                if (c12827a != null && c12827a.f36574a && (file = c12827a.f36575b) != null && file.length() > 0) {
                    sb.append(C12828ap.m15838a(f36558h.f36575b, 30720, true));
                }
                StringBuilder sb2 = f36556f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f36556f.toString());
                }
            }
            return C12828ap.m15831a(sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ao$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12827a {

        /* renamed from: a */
        boolean f36574a;

        /* renamed from: b */
        File f36575b;

        /* renamed from: c */
        long f36576c = 30720;

        /* renamed from: d */
        private String f36577d;

        /* renamed from: e */
        private long f36578e;

        public C12827a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f36577d = str;
            this.f36574a = m15850a();
        }

        /* renamed from: a */
        final boolean m15850a() {
            try {
                File file = new File(this.f36577d);
                this.f36575b = file;
                if (file.exists() && !this.f36575b.delete()) {
                    this.f36574a = false;
                    return false;
                } else if (this.f36575b.createNewFile()) {
                    return true;
                } else {
                    this.f36574a = false;
                    return false;
                }
            } catch (Throwable th) {
                C12820al.m15877a(th);
                this.f36574a = false;
                return false;
            }
        }

        /* renamed from: a */
        public final boolean m15849a(String str) {
            FileOutputStream fileOutputStream;
            byte[] bytes;
            if (this.f36574a) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(this.f36575b, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f36578e += bytes.length;
                    this.f36574a = true;
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        C12820al.m15877a(th);
                        this.f36574a = false;
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

    /* renamed from: a */
    public static void m15863a(int i) {
        synchronized (f36567q) {
            f36554d = i;
            if (i < 0) {
                f36554d = 0;
            } else if (i > 30720) {
                f36554d = 30720;
            }
        }
    }

    /* renamed from: a */
    public static void m15859a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m15861a(str, str2, message + '\n' + C12828ap.m15815b(th));
    }

    /* renamed from: a */
    public static synchronized void m15861a(final String str, final String str2, final String str3) {
        synchronized (C12824ao.class) {
            if (f36563m && f36552b) {
                try {
                    if (f36564n) {
                        f36565o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                C12824ao.m15854d(str, str2, str3);
                            }
                        });
                    } else {
                        f36565o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ao.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                C12824ao.m15853e(str, str2, str3);
                            }
                        });
                    }
                } catch (Exception e) {
                    C12820al.m15875b(e);
                }
            }
        }
    }

    /* renamed from: a */
    private static String m15860a(String str, String str2, String str3, long j) {
        String date;
        f36555e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f36553c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f36555e;
        sb.append(date);
        sb.append(" ");
        sb.append(f36566p);
        sb.append(" ");
        sb.append(j);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f36555e.toString();
    }

    /* renamed from: a */
    public static byte[] m15864a() {
        if (f36551a) {
            if (f36552b) {
                return C12828ap.m15831a(f36556f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return m15856c();
    }
}
