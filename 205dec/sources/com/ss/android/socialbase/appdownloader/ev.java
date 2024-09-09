package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private final Queue<Integer> f49039c;

    /* renamed from: f  reason: collision with root package name */
    private Handler f49040f;

    /* renamed from: r  reason: collision with root package name */
    private Runnable f49041r;
    private long sr;
    private SoftReference<JumpUnknownSourceActivity> ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f49042w;
    private long xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static final ev f49049c = new ev();
    }

    private ev() {
        this.f49039c = new ArrayDeque();
        this.f49042w = false;
        this.f49040f = new Handler(Looper.getMainLooper());
        this.f49041r = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ev.1
            @Override // java.lang.Runnable
            public void run() {
                ev.this.xv();
            }
        };
        com.ss.android.socialbase.downloader.c.c.c().c(new c.InterfaceC0974c() { // from class: com.ss.android.socialbase.appdownloader.ev.2
            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void w() {
                if (ev.this.f49039c.isEmpty()) {
                    return;
                }
                long c4 = com.ss.android.socialbase.downloader.r.c.xv().c("install_on_resume_install_interval", PolicyConfig.THREAD_BLOCK_TIMEOUT);
                long currentTimeMillis = System.currentTimeMillis() - ev.this.sr;
                if (currentTimeMillis < c4) {
                    if (ev.this.f49040f.hasCallbacks(ev.this.f49041r)) {
                        return;
                    }
                    ev.this.f49040f.postDelayed(ev.this.f49041r, c4 - currentTimeMillis);
                    return;
                }
                ev.this.sr = System.currentTimeMillis();
                ev.this.xv();
            }

            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void xv() {
            }
        });
    }

    private boolean sr() {
        return System.currentTimeMillis() - this.xv < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(Context context, int i4, boolean z3) {
        int w3 = xv.w(context, i4, z3);
        if (w3 == 1) {
            this.f49042w = true;
        }
        this.xv = System.currentTimeMillis();
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.c.c.c().w()) {
            synchronized (this.f49039c) {
                poll = this.f49039c.poll();
            }
            this.f49040f.removeCallbacks(this.f49041r);
            if (poll != null) {
                final Context gw = com.ss.android.socialbase.downloader.downloader.xv.gw();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f49040f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ev.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ev.this.w(gw, poll.intValue(), false);
                        }
                    });
                } else {
                    w(gw, poll.intValue(), false);
                }
                this.f49040f.postDelayed(this.f49041r, 20000L);
                return;
            }
            this.f49042w = false;
        }
    }

    void c(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        xv();
    }

    public JumpUnknownSourceActivity w() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.ux;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.ux = null;
        return jumpUnknownSourceActivity;
    }

    public static ev c() {
        return c.f49049c;
    }

    public int c(final Context context, final int i4, final boolean z3) {
        if (z3) {
            return w(context, i4, z3);
        }
        if (sr()) {
            this.f49040f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ev.4
                @Override // java.lang.Runnable
                public void run() {
                    ev.this.c(context, i4, z3);
                }
            }, 1000L);
            return 1;
        } else if (com.ss.android.socialbase.downloader.c.c.c().w()) {
            com.ss.android.socialbase.downloader.xv.c.xv("leaves", "on Foreground");
            return w(context, i4, z3);
        } else if (w.c()) {
            return 1;
        } else {
            boolean z4 = Build.VERSION.SDK_INT < 29;
            if (this.f49039c.isEmpty() && !this.f49042w && z4) {
                return w(context, i4, z3);
            }
            int c4 = com.ss.android.socialbase.downloader.r.c.xv().c("install_queue_size", 3);
            synchronized (this.f49039c) {
                while (this.f49039c.size() > c4) {
                    this.f49039c.poll();
                }
            }
            if (z4) {
                this.f49040f.removeCallbacks(this.f49041r);
                this.f49040f.postDelayed(this.f49041r, com.ss.android.socialbase.downloader.r.c.c(i4).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f49039c) {
                if (!this.f49039c.contains(Integer.valueOf(i4))) {
                    this.f49039c.offer(Integer.valueOf(i4));
                }
            }
            return 1;
        }
    }

    public void c(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.ux = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
