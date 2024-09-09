package cn.jiguang.cm;

import cn.jiguang.cd.h;
import java.lang.Thread;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3461a;

    /* renamed from: h  reason: collision with root package name */
    protected String f3462h;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        this.f3461a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.cm.b.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f3462h);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.bq.d.l("JCoreRunnable", sb.toString());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str) {
        this.f3462h = str;
        this.f3461a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.cm.b.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f3462h);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.bq.d.l("JCoreRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f3461a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
