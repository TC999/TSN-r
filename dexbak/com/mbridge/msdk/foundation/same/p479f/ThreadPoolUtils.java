package com.mbridge.msdk.foundation.same.p479f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mbridge.msdk.foundation.same.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ThreadPoolUtils {

    /* renamed from: a */
    public static ThreadPoolExecutor f30681a;

    /* renamed from: b */
    private static ThreadPoolExecutor f30682b;

    /* renamed from: c */
    private static ThreadPoolExecutor f30683c;

    /* renamed from: d */
    private static Handler f30684d;

    /* compiled from: ThreadPoolUtils.java */
    /* renamed from: com.mbridge.msdk.foundation.same.f.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class HandlerC11331a extends Handler {
        public HandlerC11331a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m22309a() {
        if (f30681a == null) {
            f30681a = new ThreadPoolExecutor(5, 10, 15L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(60), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("CommonThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f30681a;
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m22308b() {
        if (f30682b == null) {
            f30682b = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(60), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("ReportThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f30682b;
    }

    /* renamed from: c */
    public static ThreadPoolExecutor m22307c() {
        if (f30683c == null) {
            f30683c = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.b.3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("NwtThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f30683c;
    }

    /* renamed from: d */
    public static Handler m22306d() {
        if (f30684d == null) {
            f30684d = new HandlerC11331a();
        }
        return f30684d;
    }
}
