package com.bytedance.msdk.adapter.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AsyncTasks {

    /* renamed from: a */
    private static Executor f21500a;

    /* renamed from: b */
    private static Handler f21501b;

    static {
        m37568b();
    }

    /* renamed from: b */
    private static void m37568b() {
        f21500a = AsyncTask.THREAD_POOL_EXECUTOR;
        f21501b = new Handler(Looper.getMainLooper());
    }

    public static <P> void safeExecuteOnExecutor(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(f21500a, pArr);
            return;
        }
        Logger.m37557e(AsyncTasks.class.getSimpleName(), "Posting AsyncTask to main thread for execution.");
        f21501b.post(new Runnable() { // from class: com.bytedance.msdk.adapter.util.AsyncTasks.1
            @Override // java.lang.Runnable
            public void run() {
                asyncTask.executeOnExecutor(AsyncTasks.f21500a, pArr);
            }
        });
    }

    public static void setExecutor(Executor executor) {
        f21500a = executor;
    }
}
