package com.bytedance.c.xv.c.w;

import com.bytedance.c.xv.c.w.w;
import com.bytedance.sdk.component.gd.sr.sr;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f26666a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f26667b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f26668c;

    /* renamed from: d  reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f26669d;

    /* renamed from: e  reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f26670e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f26666a = availableProcessors;
        f26667b = (availableProcessors / 2) + 1 < 4 ? 4 : (availableProcessors / 2) + 1;
        f26668c = (availableProcessors / 2) + 1 >= 4 ? (availableProcessors / 2) + 1 : 4;
        f26669d = new PriorityBlockingQueue<>();
        f26670e = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor a() {
        int i4 = f26667b;
        return new sr(i4, i4, 1L, TimeUnit.SECONDS, f26669d, new b(w.c.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor b() {
        int i4 = f26668c;
        return new sr(i4, i4, 1L, TimeUnit.SECONDS, f26670e, new b(w.c.NORMAL, "tt-default-thread-"));
    }

    public static ScheduledExecutorService c() {
        return com.bytedance.sdk.component.gd.sr.xv(new b(w.c.LOW, "tt-delay-thread-"));
    }
}
