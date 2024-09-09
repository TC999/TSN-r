package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.gd.k;
import com.bytedance.sdk.component.gd.sr.sr;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EngineThreadPool {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f24910a;

    public static ExecutorService a() {
        if (f24910a == null) {
            synchronized (EngineThreadPool.class) {
                if (f24910a == null) {
                    sr srVar = new sr(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k("EngineThreadPool"));
                    f24910a = srVar;
                    srVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f24910a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f24910a = threadPoolExecutor;
        }
    }
}
