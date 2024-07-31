package com.kuaishou.weapon.p205p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kuaishou.weapon.p0.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7292n {

    /* renamed from: a */
    private static volatile C7292n f24977a = null;

    /* renamed from: b */
    private static int f24978b = 3;

    /* renamed from: c */
    private static int f24979c = 6;

    /* renamed from: d */
    private static ThreadPoolExecutor f24980d;

    private C7292n() {
    }

    /* renamed from: a */
    public static C7292n m33830a() {
        if (f24977a == null) {
            synchronized (C7292n.class) {
                if (f24977a == null) {
                    f24977a = new C7292n();
                }
                if (f24980d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f24978b, f24979c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    f24980d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f24977a;
    }

    /* renamed from: a */
    public static C7292n m33829a(int i, int i2) {
        if (f24977a == null) {
            synchronized (C7292n.class) {
                if (f24977a == null) {
                    f24978b = i;
                    f24979c = i2;
                    f24977a = new C7292n();
                    if (f24980d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f24978b, f24979c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f24980d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return f24977a;
    }

    /* renamed from: a */
    public void m33828a(Runnable runnable) {
        if (runnable != null) {
            try {
                f24980d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
