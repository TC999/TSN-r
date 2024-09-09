package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49166a;
    private long bl;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f49167h;
    private Handler kf;

    /* renamed from: n  reason: collision with root package name */
    private SoftReference<JumpUnknownSourceActivity> f49168n;
    private final Queue<Integer> ok;

    /* renamed from: s  reason: collision with root package name */
    private long f49169s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static final p ok = new p();
    }

    private p() {
        this.ok = new ArrayDeque();
        this.f49166a = false;
        this.kf = new Handler(Looper.getMainLooper());
        this.f49167h = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.1
            @Override // java.lang.Runnable
            public void run() {
                p.this.bl();
            }
        };
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC1022ok() { // from class: com.ss.android.socialbase.appdownloader.p.2
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void a() {
                if (p.this.ok.isEmpty()) {
                    return;
                }
                long ok2 = com.ss.android.socialbase.downloader.h.ok.bl().ok("install_on_resume_install_interval", PolicyConfig.THREAD_BLOCK_TIMEOUT);
                long currentTimeMillis = System.currentTimeMillis() - p.this.f49169s;
                if (currentTimeMillis < ok2) {
                    if (p.this.kf.hasCallbacks(p.this.f49167h)) {
                        return;
                    }
                    p.this.kf.postDelayed(p.this.f49167h, ok2 - currentTimeMillis);
                    return;
                }
                p.this.f49169s = System.currentTimeMillis();
                p.this.bl();
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void bl() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Context context, int i4, boolean z3) {
        int a4 = bl.a(context, i4, z3);
        if (a4 == 1) {
            this.f49166a = true;
        }
        this.bl = System.currentTimeMillis();
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ok.ok.ok().a()) {
            synchronized (this.ok) {
                poll = this.ok.poll();
            }
            this.kf.removeCallbacks(this.f49167h);
            if (poll != null) {
                final Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.kf.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.3
                        @Override // java.lang.Runnable
                        public void run() {
                            p.this.a(l4, poll.intValue(), false);
                        }
                    });
                } else {
                    a(l4, poll.intValue(), false);
                }
                this.kf.postDelayed(this.f49167h, 20000L);
                return;
            }
            this.f49166a = false;
        }
    }

    private boolean s() {
        return System.currentTimeMillis() - this.bl < 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        bl();
    }

    public JumpUnknownSourceActivity a() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f49168n;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f49168n = null;
        return jumpUnknownSourceActivity;
    }

    public static p ok() {
        return ok.ok;
    }

    public int ok(final Context context, final int i4, final boolean z3) {
        if (z3) {
            return a(context, i4, z3);
        }
        if (s()) {
            this.kf.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.4
                @Override // java.lang.Runnable
                public void run() {
                    p.this.ok(context, i4, z3);
                }
            }, 1000L);
            return 1;
        } else if (com.ss.android.socialbase.downloader.ok.ok.ok().a()) {
            com.ss.android.socialbase.downloader.bl.ok.bl("leaves", "on Foreground");
            return a(context, i4, z3);
        } else if (a.ok()) {
            return 1;
        } else {
            boolean z4 = Build.VERSION.SDK_INT < 29;
            if (this.ok.isEmpty() && !this.f49166a && z4) {
                return a(context, i4, z3);
            }
            int ok2 = com.ss.android.socialbase.downloader.h.ok.bl().ok("install_queue_size", 3);
            synchronized (this.ok) {
                while (this.ok.size() > ok2) {
                    this.ok.poll();
                }
            }
            if (z4) {
                this.kf.removeCallbacks(this.f49167h);
                this.kf.postDelayed(this.f49167h, com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("install_queue_timeout", 20000L));
            }
            synchronized (this.ok) {
                if (!this.ok.contains(Integer.valueOf(i4))) {
                    this.ok.offer(Integer.valueOf(i4));
                }
            }
            return 1;
        }
    }

    public void ok(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f49168n = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
