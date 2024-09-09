package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f38373a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f38374b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static int f38375c = 6;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f38376d;

    private n() {
    }

    public static n a() {
        if (f38373a == null) {
            synchronized (n.class) {
                if (f38373a == null) {
                    f38373a = new n();
                }
                if (f38376d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f38374b, f38375c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    f38376d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f38373a;
    }

    public static n a(int i4, int i5) {
        if (f38373a == null) {
            synchronized (n.class) {
                if (f38373a == null) {
                    f38374b = i4;
                    f38375c = i5;
                    f38373a = new n();
                    if (f38376d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f38374b, f38375c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f38376d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return f38373a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f38376d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
