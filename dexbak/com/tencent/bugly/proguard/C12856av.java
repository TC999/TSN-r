package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.av */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12856av implements Thread.UncaughtExceptionHandler {

    /* renamed from: h */
    private static String f36663h;

    /* renamed from: i */
    private static final Object f36664i = new Object();

    /* renamed from: a */
    protected final Context f36665a;

    /* renamed from: b */
    protected final C12832as f36666b;

    /* renamed from: c */
    protected final C12803ac f36667c;

    /* renamed from: d */
    protected final C12786aa f36668d;

    /* renamed from: e */
    protected Thread.UncaughtExceptionHandler f36669e;

    /* renamed from: f */
    protected Thread.UncaughtExceptionHandler f36670f;

    /* renamed from: g */
    protected boolean f36671g = false;

    /* renamed from: j */
    private int f36672j;

    public C12856av(Context context, C12832as c12832as, C12803ac c12803ac, C12786aa c12786aa) {
        this.f36665a = context;
        this.f36666b = c12832as;
        this.f36667c = c12803ac;
        this.f36668d = c12786aa;
    }

    /* renamed from: c */
    private static void m15723c() {
        C12820al.m15872e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* renamed from: a */
    public final synchronized void m15733a() {
        if (this.f36672j >= 10) {
            C12820al.m15878a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f36671g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (C12856av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C12820al.m15878a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f36670f = defaultUncaughtExceptionHandler;
                this.f36669e = defaultUncaughtExceptionHandler;
            } else {
                C12820al.m15878a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f36669e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f36672j++;
        C12820al.m15878a("registered java monitor: %s", toString());
    }

    /* renamed from: b */
    public final synchronized void m15725b() {
        this.f36671g = false;
        C12820al.m15878a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            C12820al.m15878a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f36669e);
            this.f36672j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f36664i) {
            m15728a(thread, th, true, null, null, this.f36668d.f36415Q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x010f A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:23:0x00fc, B:28:0x0107, B:33:0x010f, B:35:0x011d, B:36:0x011f), top: B:41:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:23:0x00fc, B:28:0x0107, B:33:0x010f, B:35:0x011d, B:36:0x011f), top: B:41:0x00fc }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean m15724b(java.lang.Thread r7, java.lang.Throwable r8, boolean r9, java.lang.String r10, byte[] r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12856av.m15724b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    /* renamed from: a */
    private static void m15731a(CrashDetailBean crashDetailBean, Throwable th, boolean z) {
        String m15726a;
        String name = th.getClass().getName();
        String m15727a = m15727a(th);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th.getCause() != null);
        C12820al.m15872e("stack frame :%d, has cause %b", objArr);
        String str = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f36354n = th2.getClass().getName();
            crashDetailBean.f36355o = m15727a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f36356p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(m15727a);
            sb.append(ShellAdbUtils.f33810d);
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f36354n);
            sb.append(":");
            sb.append(crashDetailBean.f36355o);
            sb.append(ShellAdbUtils.f33810d);
            m15726a = m15726a(th2, C12848at.f36617h);
            sb.append(m15726a);
            crashDetailBean.f36357q = sb.toString();
        } else {
            crashDetailBean.f36354n = name;
            if (C12848at.m15755a().m15741i() && z) {
                C12820al.m15872e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f36355o = m15727a + str;
            crashDetailBean.f36356p = stackTraceElement;
            m15726a = m15726a(th, C12848at.f36617h);
            crashDetailBean.f36357q = m15726a;
        }
        crashDetailBean.f36361u = C12828ap.m15810c(crashDetailBean.f36357q.getBytes());
        crashDetailBean.f36366z.put(crashDetailBean.f36315B, m15726a);
    }

    /* renamed from: a */
    private static boolean m15729a(Thread thread) {
        synchronized (f36664i) {
            if (f36663h != null && thread.getName().equals(f36663h)) {
                return true;
            }
            f36663h = thread.getName();
            return false;
        }
    }

    /* renamed from: a */
    public final void m15728a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        if (z) {
            C12820al.m15872e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m15729a(thread)) {
                C12820al.m15878a("this class has handled this exception", new Object[0]);
                if (this.f36670f != null) {
                    C12820al.m15878a("call system handler", new Object[0]);
                    this.f36670f.uncaughtException(thread, th);
                } else {
                    m15723c();
                }
            }
        } else {
            C12820al.m15872e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f36671g) {
                C12820al.m15874c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f36669e;
                    if (uncaughtExceptionHandler != null && m15730a(uncaughtExceptionHandler)) {
                        C12820al.m15872e("sys default last handle start!", new Object[0]);
                        this.f36669e.uncaughtException(thread, th);
                        C12820al.m15872e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f36670f != null) {
                        C12820al.m15872e("system handle start!", new Object[0]);
                        this.f36670f.uncaughtException(thread, th);
                        C12820al.m15872e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C12820al.m15872e("crashreport last handle start!", new Object[0]);
                        m15723c();
                        C12820al.m15872e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f36667c.m15943b()) {
                C12820al.m15873d("no remote but still store!", new Object[0]);
            }
            if (!this.f36667c.m15941c().f36296f && this.f36667c.m15943b()) {
                C12820al.m15872e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C12832as.m15786a(z ? "JAVA_CRASH" : "JAVA_CATCH", C12828ap.m15848a(), this.f36668d.f36451d, thread.getName(), C12828ap.m15828a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f36669e;
                    if (uncaughtExceptionHandler2 != null && m15730a(uncaughtExceptionHandler2)) {
                        C12820al.m15872e("sys default last handle start!", new Object[0]);
                        this.f36669e.uncaughtException(thread, th);
                        C12820al.m15872e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f36670f != null) {
                        C12820al.m15872e("system handle start!", new Object[0]);
                        this.f36670f.uncaughtException(thread, th);
                        C12820al.m15872e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C12820al.m15872e("crashreport last handle start!", new Object[0]);
                        m15723c();
                        C12820al.m15872e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean m15724b = m15724b(thread, th, z, str, bArr, z2);
            if (m15724b == null) {
                C12820al.m15872e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f36669e;
                    if (uncaughtExceptionHandler3 != null && m15730a(uncaughtExceptionHandler3)) {
                        C12820al.m15872e("sys default last handle start!", new Object[0]);
                        this.f36669e.uncaughtException(thread, th);
                        C12820al.m15872e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f36670f != null) {
                        C12820al.m15872e("system handle start!", new Object[0]);
                        this.f36670f.uncaughtException(thread, th);
                        C12820al.m15872e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C12820al.m15872e("crashreport last handle start!", new Object[0]);
                        m15723c();
                        C12820al.m15872e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            C12832as.m15786a(z ? "JAVA_CRASH" : "JAVA_CATCH", C12828ap.m15848a(), this.f36668d.f36451d, thread.getName(), C12828ap.m15828a(th), m15724b);
            if (!this.f36666b.m15789a(m15724b, z)) {
                this.f36666b.m15768b(m15724b, z);
            }
            if (z) {
                this.f36666b.m15794a(m15724b);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f36669e;
                if (uncaughtExceptionHandler4 != null && m15730a(uncaughtExceptionHandler4)) {
                    C12820al.m15872e("sys default last handle start!", new Object[0]);
                    this.f36669e.uncaughtException(thread, th);
                    C12820al.m15872e("sys default last handle end!", new Object[0]);
                } else if (this.f36670f != null) {
                    C12820al.m15872e("system handle start!", new Object[0]);
                    this.f36670f.uncaughtException(thread, th);
                    C12820al.m15872e("system handle end!", new Object[0]);
                } else {
                    C12820al.m15872e("crashreport last handle start!", new Object[0]);
                    m15723c();
                    C12820al.m15872e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!C12820al.m15877a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f36669e;
                    if (uncaughtExceptionHandler5 != null && m15730a(uncaughtExceptionHandler5)) {
                        C12820al.m15872e("sys default last handle start!", new Object[0]);
                        this.f36669e.uncaughtException(thread, th);
                        C12820al.m15872e("sys default last handle end!", new Object[0]);
                    } else if (this.f36670f != null) {
                        C12820al.m15872e("system handle start!", new Object[0]);
                        this.f36670f.uncaughtException(thread, th);
                        C12820al.m15872e("system handle end!", new Object[0]);
                    } else {
                        C12820al.m15872e("crashreport last handle start!", new Object[0]);
                        m15723c();
                        C12820al.m15872e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f36669e;
                    if (uncaughtExceptionHandler6 != null && m15730a(uncaughtExceptionHandler6)) {
                        C12820al.m15872e("sys default last handle start!", new Object[0]);
                        this.f36669e.uncaughtException(thread, th);
                        C12820al.m15872e("sys default last handle end!", new Object[0]);
                    } else if (this.f36670f != null) {
                        C12820al.m15872e("system handle start!", new Object[0]);
                        this.f36670f.uncaughtException(thread, th);
                        C12820al.m15872e("system handle end!", new Object[0]);
                    } else {
                        C12820al.m15872e("crashreport last handle start!", new Object[0]);
                        m15723c();
                        C12820al.m15872e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    /* renamed from: a */
    private static boolean m15730a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final synchronized void m15732a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f36296f;
            if (z != this.f36671g) {
                C12820al.m15878a("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f36296f) {
                    m15733a();
                    return;
                }
                m15725b();
            }
        }
    }

    /* renamed from: a */
    private static String m15726a(Throwable th, int i) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append(ShellAdbUtils.f33810d);
                }
            }
        } catch (Throwable th2) {
            C12820al.m15872e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m15727a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
