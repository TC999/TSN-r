package com.baidu.liantian.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static final int f12150b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f12151c;

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f12152a;

    private r() {
        this.f12152a = null;
        int i4 = f12150b;
        int i5 = i4 <= 0 ? 1 : i4;
        com.baidu.liantian.b.a();
        this.f12152a = new ThreadPoolExecutor(i5, i5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public final void a(Runnable runnable) {
        try {
            this.f12152a.execute(runnable);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static r a() {
        if (f12151c == null) {
            try {
                synchronized (r.class) {
                    if (f12151c == null) {
                        f12151c = new r();
                    }
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return f12151c;
    }
}
