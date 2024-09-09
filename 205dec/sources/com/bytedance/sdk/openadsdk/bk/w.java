package com.bytedance.sdk.openadsdk.bk;

import com.bytedance.sdk.component.gd.k;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private int sr;
    private c ux;

    /* renamed from: w  reason: collision with root package name */
    private ev f31630w;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f31629c = null;
    private long xv = 0;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    public w(ev evVar, int i4) {
        this.f31630w = evVar;
        this.sr = i4;
    }

    public void c(long j4) {
        this.xv = j4;
    }

    public boolean w() {
        ScheduledExecutorService scheduledExecutorService = this.f31629c;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void c(int i4) {
        ScheduledExecutorService w3 = com.bytedance.sdk.component.gd.sr.w(1, new k("/CrashMonitor"));
        this.f31629c = w3;
        w3.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bk.w.1
            @Override // java.lang.Runnable
            public void run() {
                r.c("Playable_CrashMonitor", "-- check page stuck  " + (System.currentTimeMillis() - w.this.xv));
                if (System.currentTimeMillis() - w.this.xv > w.this.sr) {
                    w.this.f31629c.shutdown();
                    if (w.this.f31630w != null) {
                        w.this.f31630w.w(0, "\u81ea\u52a8\u68c0\u6d4b\u5361\u6b7b");
                    }
                    if (w.this.ux != null) {
                        w.this.ux.c();
                    }
                }
            }
        }, 0L, i4, TimeUnit.MILLISECONDS);
    }

    public void c() {
        ScheduledExecutorService scheduledExecutorService = this.f31629c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
