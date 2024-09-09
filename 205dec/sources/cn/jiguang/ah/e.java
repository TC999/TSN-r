package cn.jiguang.ah;

import java.lang.Thread;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2243a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.ah.e.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            cn.jiguang.s.b.a(thread, th);
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(e.this.f2244d);
            sb.append("thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            cn.jiguang.w.a.h("JCommonRunnable", sb.toString());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    protected String f2244d;

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f2243a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
