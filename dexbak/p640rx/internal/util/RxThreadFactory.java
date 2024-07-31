package p640rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: rx.internal.util.RxThreadFactory */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory NONE = new ThreadFactoryC16046a();
    private static final long serialVersionUID = -8841098858898482335L;
    final String prefix;

    /* renamed from: rx.internal.util.RxThreadFactory$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class ThreadFactoryC16046a implements ThreadFactory {
        ThreadFactoryC16046a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public RxThreadFactory(String str) {
        this.prefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.prefix + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
