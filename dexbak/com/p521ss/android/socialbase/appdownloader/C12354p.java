package com.p521ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.ss.android.socialbase.appdownloader.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12354p {

    /* renamed from: a */
    private boolean f34813a;

    /* renamed from: bl */
    private long f34814bl;

    /* renamed from: h */
    private Runnable f34815h;

    /* renamed from: kf */
    private Handler f34816kf;

    /* renamed from: n */
    private SoftReference<JumpUnknownSourceActivity> f34817n;

    /* renamed from: ok */
    private final Queue<Integer> f34818ok;

    /* renamed from: s */
    private long f34819s;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.p$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12359ok {

        /* renamed from: ok */
        private static final C12354p f34829ok = new C12354p();
    }

    private C12354p() {
        this.f34818ok = new ArrayDeque();
        this.f34813a = false;
        this.f34816kf = new Handler(Looper.getMainLooper());
        this.f34815h = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.1
            @Override // java.lang.Runnable
            public void run() {
                C12354p.this.m18101bl();
            }
        };
        C12646ok.m16846ok().m16843ok(new C12646ok.InterfaceC12650ok() { // from class: com.ss.android.socialbase.appdownloader.p.2
            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: a */
            public void mo16836a() {
                if (C12354p.this.f34818ok.isEmpty()) {
                    return;
                }
                long m17592ok = C12534ok.m17605bl().m17592ok("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - C12354p.this.f34819s;
                if (currentTimeMillis < m17592ok) {
                    if (C12354p.this.f34816kf.hasCallbacks(C12354p.this.f34815h)) {
                        return;
                    }
                    C12354p.this.f34816kf.postDelayed(C12354p.this.f34815h, m17592ok - currentTimeMillis);
                    return;
                }
                C12354p.this.f34819s = System.currentTimeMillis();
                C12354p.this.m18101bl();
            }

            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: bl */
            public void mo16835bl() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m18103a(Context context, int i, boolean z) {
        int m18442a = C12293bl.m18442a(context, i, z);
        if (m18442a == 1) {
            this.f34813a = true;
        }
        this.f34814bl = System.currentTimeMillis();
        return m18442a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public void m18101bl() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || C12646ok.m16846ok().m16854a()) {
            synchronized (this.f34818ok) {
                poll = this.f34818ok.poll();
            }
            this.f34816kf.removeCallbacks(this.f34815h);
            if (poll != null) {
                final Context m17807l = C12490bl.m17807l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f34816kf.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.3
                        @Override // java.lang.Runnable
                        public void run() {
                            C12354p.this.m18103a(m17807l, poll.intValue(), false);
                        }
                    });
                } else {
                    m18103a(m17807l, poll.intValue(), false);
                }
                this.f34816kf.postDelayed(this.f34815h, 20000L);
                return;
            }
            this.f34813a = false;
        }
    }

    /* renamed from: s */
    private boolean m18091s() {
        return System.currentTimeMillis() - this.f34814bl < 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m18092ok(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        m18101bl();
    }

    /* renamed from: a */
    public JumpUnknownSourceActivity m18104a() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f34817n;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f34817n = null;
        return jumpUnknownSourceActivity;
    }

    /* renamed from: ok */
    public static C12354p m18098ok() {
        return C12359ok.f34829ok;
    }

    /* renamed from: ok */
    public int m18097ok(final Context context, final int i, final boolean z) {
        if (z) {
            return m18103a(context, i, z);
        }
        if (m18091s()) {
            this.f34816kf.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.4
                @Override // java.lang.Runnable
                public void run() {
                    C12354p.this.m18097ok(context, i, z);
                }
            }, 1000L);
            return 1;
        } else if (C12646ok.m16846ok().m16854a()) {
            C12409ok.m17901bl("leaves", "on Foreground");
            return m18103a(context, i, z);
        } else if (C12284a.m18473ok()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f34818ok.isEmpty() && !this.f34813a && z2) {
                return m18103a(context, i, z);
            }
            int m17593ok = C12534ok.m17605bl().m17593ok("install_queue_size", 3);
            synchronized (this.f34818ok) {
                while (this.f34818ok.size() > m17593ok) {
                    this.f34818ok.poll();
                }
            }
            if (z2) {
                this.f34816kf.removeCallbacks(this.f34815h);
                this.f34816kf.postDelayed(this.f34815h, C12534ok.m17599ok(i).m17592ok("install_queue_timeout", 20000L));
            }
            synchronized (this.f34818ok) {
                if (!this.f34818ok.contains(Integer.valueOf(i))) {
                    this.f34818ok.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    /* renamed from: ok */
    public void m18093ok(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f34817n = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
