package cn.jiguang.cm;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f3465a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f3466b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    private final String f3467c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f3465a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        String lowerCase = TextUtils.isEmpty(str) ? "default" : str.toLowerCase();
        this.f3467c = "jg_" + lowerCase + "_pool_thread";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        Throwable th;
        try {
            thread = new Thread(this.f3465a, runnable, this.f3467c + this.f3466b.getAndIncrement(), 0L);
        } catch (Throwable th2) {
            thread = null;
            th = th2;
        }
        try {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
                return thread;
            }
            return thread;
        } catch (Throwable th3) {
            th = th3;
            cn.jiguang.bq.d.l("JThreadFactory", "JThreadFactory new Thread error, " + th.getMessage());
            try {
                Thread thread2 = new Thread(this.f3465a, runnable, this.f3467c + this.f3466b.getAndIncrement(), 0L);
                try {
                    if (thread2.isDaemon()) {
                        thread2.setDaemon(false);
                    }
                    if (thread2.getPriority() != 5) {
                        thread2.setPriority(5);
                    }
                    return thread2;
                } catch (Throwable th4) {
                    th = th4;
                    thread = thread2;
                    cn.jiguang.bq.d.l("JThreadFactory", "JThreadFactory new Thread again error, " + th.getMessage());
                    return thread;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }
}
