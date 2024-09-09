package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class av implements Thread.UncaughtExceptionHandler {

    /* renamed from: h  reason: collision with root package name */
    private static String f51033h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f51034i = new Object();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f51035a;

    /* renamed from: b  reason: collision with root package name */
    protected final as f51036b;

    /* renamed from: c  reason: collision with root package name */
    protected final ac f51037c;

    /* renamed from: d  reason: collision with root package name */
    protected final aa f51038d;

    /* renamed from: e  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f51039e;

    /* renamed from: f  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f51040f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f51041g = false;

    /* renamed from: j  reason: collision with root package name */
    private int f51042j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.f51035a = context;
        this.f51036b = asVar;
        this.f51037c = acVar;
        this.f51038d = aaVar;
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f51042j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f51041g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f51040f = defaultUncaughtExceptionHandler;
                this.f51039e = defaultUncaughtExceptionHandler;
            } else {
                al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f51039e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f51042j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f51041g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f51039e);
            this.f51042j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f51034i) {
            a(thread, th, true, null, null, this.f51038d.Q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x010f A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:23:0x00fc, B:28:0x0107, B:33:0x010f, B:35:0x011d, B:36:0x011f), top: B:41:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:23:0x00fc, B:28:0x0107, B:33:0x010f, B:35:0x011d, B:36:0x011f), top: B:41:0x00fc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread r7, java.lang.Throwable r8, boolean r9, java.lang.String r10, byte[] r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z3) {
        String a4;
        String name = th.getClass().getName();
        String a5 = a(th);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th.getCause() != null);
        al.e("stack frame :%d, has cause %b", objArr);
        String str = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f50778n = th2.getClass().getName();
            crashDetailBean.f50779o = a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f50780p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(a5);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f50778n);
            sb.append(":");
            sb.append(crashDetailBean.f50779o);
            sb.append("\n");
            a4 = a(th2, at.f50990h);
            sb.append(a4);
            crashDetailBean.f50781q = sb.toString();
        } else {
            crashDetailBean.f50778n = name;
            if (at.a().i() && z3) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f50779o = a5 + str;
            crashDetailBean.f50780p = stackTraceElement;
            a4 = a(th, at.f50990h);
            crashDetailBean.f50781q = a4;
        }
        crashDetailBean.f50785u = ap.c(crashDetailBean.f50781q.getBytes());
        crashDetailBean.f50790z.put(crashDetailBean.B, a4);
    }

    private static boolean a(Thread thread) {
        synchronized (f51034i) {
            if (f51033h != null && thread.getName().equals(f51033h)) {
                return true;
            }
            f51033h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z3, String str, byte[] bArr, boolean z4) {
        if (z3) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f51040f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f51040f.uncaughtException(thread, th);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f51041g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f51039e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f51039e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f51040f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f51040f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f51037c.b()) {
                al.d("no remote but still store!", new Object[0]);
            }
            if (!this.f51037c.c().f50746f && this.f51037c.b()) {
                al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(z3 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f51038d.f50825d, thread.getName(), ap.a(th), null);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f51039e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f51039e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f51040f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f51040f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b4 = b(thread, th, z3, str, bArr, z4);
            if (b4 == null) {
                al.e("pkg crash datas fail!", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f51039e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f51039e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f51040f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f51040f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.a(z3 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f51038d.f50825d, thread.getName(), ap.a(th), b4);
            if (!this.f51036b.a(b4, z3)) {
                this.f51036b.b(b4, z3);
            }
            if (z3) {
                this.f51036b.a(b4);
            }
            if (z3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f51039e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.f51039e.uncaughtException(thread, th);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f51040f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f51040f.uncaughtException(thread, th);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f51039e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f51039e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f51040f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f51040f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f51039e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f51039e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f51040f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f51040f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
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

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z3 = strategyBean.f50746f;
            if (z3 != this.f51041g) {
                al.a("java changed to %b", Boolean.valueOf(z3));
                if (strategyBean.f50746f) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i4) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i4 > 0 && sb.length() >= i4) {
                        sb.append("\n[Stack over limit size :" + i4 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String a(Throwable th) {
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
