package com.bytedance.c.w.sr;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.c.w.b;
import com.bytedance.c.w.ux.c.e;
import com.bytedance.c.w.xv;
import com.bytedance.c.xv.c.w.d;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    private static a f26564e;

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f26565a;

    /* renamed from: c  reason: collision with root package name */
    private b f26567c;

    /* renamed from: b  reason: collision with root package name */
    private HashSet<Thread.UncaughtExceptionHandler> f26566b = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private long f26568d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.c.w.sr.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0375a extends d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f26569c;

        C0375a(String str) {
            this.f26569c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.c.w.xv.a aVar = new com.bytedance.c.w.xv.a();
                aVar.k("data", this.f26569c);
                aVar.k("userdefine", 1);
                com.bytedance.c.w.xv.a c4 = e.a().c(xv.CUSTOM_JAVA, aVar);
                if (c4 != null) {
                    com.bytedance.c.w.r.a.a().d(c4.j());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private a() {
        e();
    }

    public static a a() {
        if (f26564e == null) {
            f26564e = new a();
        }
        return f26564e;
    }

    public static void c(String str) {
        if (str == null) {
            return;
        }
        com.bytedance.c.xv.c.w.a.a().b(new C0375a(str));
    }

    private boolean d(Thread thread, Throwable th) {
        com.bytedance.c.w.e e4 = com.bytedance.c.w.d.k().e();
        if (e4 != null) {
            try {
                return e4.c(th, thread);
            } catch (Throwable unused) {
                return true;
            }
        }
        return true;
    }

    private void e() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.f26565a == null) {
                this.f26565a = defaultUncaughtExceptionHandler;
            } else {
                this.f26566b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    private void f(Thread thread, Throwable th) {
        List<com.bytedance.c.w.c> f4 = com.bytedance.c.w.d.k().f();
        xv xvVar = xv.JAVA;
        for (com.bytedance.c.w.c cVar : f4) {
            try {
                cVar.a(xvVar, b.n.a(th), thread);
            } catch (Throwable th2) {
                b.k.c(th2);
            }
        }
    }

    private void g(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f26566b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f26565a.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public void b(b bVar) {
        this.f26567c = bVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d4;
        b bVar;
        if (SystemClock.uptimeMillis() - this.f26568d < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f26568d = SystemClock.uptimeMillis();
            d4 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d4) {
            xv xvVar = xv.JAVA;
            f(thread, th);
            if (d4 && (bVar = this.f26567c) != null && bVar.c(th)) {
                this.f26567c.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
