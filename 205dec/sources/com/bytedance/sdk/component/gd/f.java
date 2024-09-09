package com.bytedance.sdk.component.gd;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {
    public static ThreadGroup w() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e4) {
            c(e4);
            return null;
        }
    }

    private static void c(Throwable th) {
        com.bytedance.sdk.component.utils.a.w("PthreadUtil", String.valueOf(th.getMessage()));
    }

    public static int c() {
        ThreadGroup w3 = w();
        if (w3 == null) {
            return 0;
        }
        int activeCount = w3.activeCount();
        try {
            return w3.enumerate(new Thread[(activeCount / 2) + activeCount]);
        } catch (Throwable unused) {
            return activeCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e4) {
            c(e4);
        }
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }

    public static void c(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e4) {
                c(e4);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.gd.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.w(threadPoolExecutor);
                }
            });
        }
    }
}
