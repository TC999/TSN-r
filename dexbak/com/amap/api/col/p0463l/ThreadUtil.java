package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.y2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ThreadUtil {

    /* renamed from: b */
    private static volatile ThreadUtil f5784b;

    /* renamed from: a */
    private ThreadPool f5785a;

    private ThreadUtil() {
        this.f5785a = null;
        this.f5785a = ThreadUtilPoolFactory.m53336b("AMapThreadUtil");
    }

    /* renamed from: a */
    public static ThreadUtil m53406a() {
        if (f5784b == null) {
            synchronized (ThreadUtil.class) {
                if (f5784b == null) {
                    f5784b = new ThreadUtil();
                }
            }
        }
        return f5784b;
    }

    /* renamed from: c */
    public static void m53404c() {
        if (f5784b != null) {
            try {
                if (f5784b.f5785a != null) {
                    f5784b.f5785a.m55649g();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f5784b.f5785a = null;
            f5784b = null;
        }
    }

    /* renamed from: d */
    public static void m53403d(ThreadTask threadTask) {
        if (threadTask != null) {
            try {
                threadTask.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final void m53405b(ThreadTask threadTask) {
        try {
            this.f5785a.m55654b(threadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
