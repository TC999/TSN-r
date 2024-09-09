package com.bytedance.msdk.adapter.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AsyncTasks {

    /* renamed from: a  reason: collision with root package name */
    private static Executor f27218a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f27219b;

    static {
        b();
    }

    private static void b() {
        f27218a = AsyncTask.THREAD_POOL_EXECUTOR;
        f27219b = new Handler(Looper.getMainLooper());
    }

    public static <P> void safeExecuteOnExecutor(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(f27218a, pArr);
            return;
        }
        Logger.e(AsyncTasks.class.getSimpleName(), "Posting AsyncTask to main thread for execution.");
        f27219b.post(new Runnable() { // from class: com.bytedance.msdk.adapter.util.AsyncTasks.1
            @Override // java.lang.Runnable
            public void run() {
                asyncTask.executeOnExecutor(AsyncTasks.f27218a, pArr);
            }
        });
    }

    public static void setExecutor(Executor executor) {
        f27218a = executor;
    }
}
