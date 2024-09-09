package com.bytedance.sdk.component.gd.xv;

import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.utils.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f29880c;

    public sr(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i4, i5, j4, timeUnit, blockingQueue, threadFactory);
    }

    private boolean sr() {
        BlockingQueue<Runnable> queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i4 = corePoolSize * 2;
        int min = Math.min(corePoolSize + 4, ev.f29838c);
        if (corePoolSize >= min || queue == null || queue.size() < i4) {
            return false;
        }
        try {
            setCorePoolSize(min);
            return true;
        } catch (Exception e4) {
            a.xv("BizCoreThreadPool", e4.getMessage());
            return false;
        }
    }

    private void xv() {
        BlockingQueue<Runnable> queue = getQueue();
        int ev = com.bytedance.sdk.component.gd.a.f29806w.ev();
        if (getCorePoolSize() == ev || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(ev);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (ev.ux()) {
            xv();
        }
    }

    @Override // com.bytedance.sdk.component.gd.xv.c
    public void c(Runnable runnable) {
        if (runnable instanceof com.bytedance.sdk.component.gd.c.xv) {
            ((com.bytedance.sdk.component.gd.c.xv) runnable).c(false);
        }
        super.c(runnable);
    }

    @Override // com.bytedance.sdk.component.gd.xv.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ev.ux()) {
            sr();
        }
        super.execute(runnable);
    }

    public void w() {
        ScheduledFuture<?> scheduledFuture = this.f29880c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001b  */
    @Override // com.bytedance.sdk.component.gd.xv.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void c(java.lang.Runnable r3, java.lang.OutOfMemoryError r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto Lc
            java.util.concurrent.BlockingQueue r1 = r2.getQueue()     // Catch: java.lang.Throwable -> L17
            boolean r3 = r1.offer(r3)     // Catch: java.lang.Throwable -> L17
            goto L10
        Lc:
            r3 = 1
            com.bytedance.sdk.component.gd.ev.c(r0)     // Catch: java.lang.Throwable -> L16
        L10:
            r2.allowCoreThreadTimeOut(r0)     // Catch: java.lang.Throwable -> L14
            goto L18
        L14:
            r0 = r3
            goto L17
        L16:
            r0 = 1
        L17:
            r3 = r0
        L18:
            if (r3 == 0) goto L1b
            return
        L1b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gd.xv.sr.c(java.lang.Runnable, java.lang.OutOfMemoryError):void");
    }

    @Override // com.bytedance.sdk.component.gd.xv.c
    public boolean c() {
        BlockingQueue<Runnable> queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }
}
