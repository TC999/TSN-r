package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mbridge.msdk.foundation.tools.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class FastKVConfig {

    /* renamed from: a */
    static FastKV.InterfaceC11396b f31087a;

    /* renamed from: b */
    static volatile Executor f31088b;

    private FastKVConfig() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Executor m21847a() {
        if (f31088b == null) {
            synchronized (FastKVConfig.class) {
                if (f31088b == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.tools.k.1
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            return new Thread(runnable, "mb-sp-handler");
                        }
                    }, new ThreadPoolExecutor.DiscardPolicy());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f31088b = threadPoolExecutor;
                }
            }
        }
        return f31088b;
    }
}
