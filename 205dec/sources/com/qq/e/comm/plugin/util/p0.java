package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Looper f46562a = Looper.getMainLooper();

    /* renamed from: b  reason: collision with root package name */
    private static Handler f46563b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Runnable f46564c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.util.p0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0906a implements MessageQueue.IdleHandler {
            C0906a() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    a.this.f46564c.run();
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        a(Runnable runnable) {
            this.f46564c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(new C0906a());
        }
    }

    private static Handler a() {
        if (f46563b == null) {
            f46563b = new Handler(f46562a);
        }
        return f46563b;
    }

    public static final boolean b(Runnable runnable) {
        if (Thread.currentThread() == f46562a.getThread()) {
            runnable.run();
            return true;
        }
        return a().postAtFrontOfQueue(runnable);
    }

    public static final boolean c(Runnable runnable) {
        return a().post(new a(runnable));
    }

    public static boolean d(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (Thread.currentThread() == f46562a.getThread()) {
            runnable.run();
            return true;
        }
        return a(runnable);
    }

    public static final void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a().removeCallbacks(runnable);
    }

    public static final boolean a(Runnable runnable) {
        return a().post(runnable);
    }

    public static final boolean a(Runnable runnable, long j4) {
        return a().postDelayed(runnable, j4);
    }

    public static final void a(Object obj) {
        a().removeCallbacksAndMessages(obj);
    }
}
