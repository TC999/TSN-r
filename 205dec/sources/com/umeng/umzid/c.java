package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f54235a;

    /* renamed from: b  reason: collision with root package name */
    public static ThreadFactory f54236b = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f54237a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f54237a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f54235a == null) {
            synchronized (c.class) {
                if (f54235a == null) {
                    f54235a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f54236b);
                }
            }
        }
        return f54235a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
