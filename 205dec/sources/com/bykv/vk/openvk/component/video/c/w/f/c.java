package com.bykv.vk.openvk.component.video.c.w.f;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.f.xv;
import com.bykv.vk.openvk.component.video.c.w.f;
import com.bykv.vk.openvk.component.video.c.w.sr;
import com.bykv.vk.openvk.component.video.c.w.ux;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.utils.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f25084c = xv.w();

    /* renamed from: w  reason: collision with root package name */
    private HashMap<String, Boolean> f25085w;
    private C0340c xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class w {

        /* renamed from: c  reason: collision with root package name */
        private static final c f25094c = new c();
    }

    public static c c() {
        return w.f25094c;
    }

    private static com.bykv.vk.openvk.component.video.c.w.c.xv xv() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.w(com.bykv.vk.openvk.component.video.api.xv.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.c.w.c.xv xvVar = null;
        try {
            com.bykv.vk.openvk.component.video.c.w.c.xv xvVar2 = new com.bykv.vk.openvk.component.video.c.w.c.xv(file);
            try {
                xvVar2.c(104857600L);
                return xvVar2;
            } catch (IOException e4) {
                e = e4;
                xvVar = xvVar2;
                e.printStackTrace();
                return xvVar;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    public boolean w() {
        if (this.xv != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.c.w.c.xv xv = xv();
        if (xv == null) {
            return false;
        }
        ux.c(true);
        ux.w(true);
        ux.c(1);
        f.c().sr();
        try {
            C0340c c0340c = new C0340c();
            this.xv = c0340c;
            c0340c.setName("csj_video_cache_preloader");
            this.xv.start();
            ux.c(xv, com.bykv.vk.openvk.component.video.api.xv.getContext());
            sr.xv().c(PolicyConfig.mServerBusyRetryBaseInternal, PolicyConfig.mServerBusyRetryBaseInternal, PolicyConfig.mServerBusyRetryBaseInternal);
            sr.xv().c(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private c() {
        this.f25085w = new HashMap<>();
        w();
    }

    public boolean c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        if (w()) {
            this.xv.c(srVar);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bykv.vk.openvk.component.video.c.w.f.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0340c extends com.bytedance.sdk.component.gd.sr.xv {
        private final Queue<C0341c> sr;
        private Queue<C0341c> ux;

        /* renamed from: w  reason: collision with root package name */
        private Queue<C0341c> f25089w;
        private boolean xv;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bykv.vk.openvk.component.video.c.w.f.c$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class C0341c {

            /* renamed from: c  reason: collision with root package name */
            public int f25090c;

            /* renamed from: f  reason: collision with root package name */
            public com.bykv.vk.openvk.component.video.api.xv.sr f25091f;
            public int sr;
            public String ux;

            /* renamed from: w  reason: collision with root package name */
            public String f25093w;
            public String[] xv;

            public C0341c() {
            }
        }

        public C0340c() {
            super("VideoCachePreloader$PreLoadThread");
            this.sr = new ArrayBlockingQueue(10);
            this.f25089w = new LinkedBlockingQueue();
            this.xv = true;
            this.ux = new LinkedBlockingQueue();
        }

        private C0341c c(int i4, com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
            w();
            a.w("VideoCachePreloader", "pool: " + this.sr.size());
            C0341c poll = this.sr.poll();
            if (poll == null) {
                poll = new C0341c();
            }
            poll.f25090c = i4;
            poll.f25091f = srVar;
            return poll;
        }

        private void c() {
        }

        private void w() {
        }

        private synchronized void w(C0341c c0341c) {
            w();
            this.ux.add(c0341c);
            notify();
        }

        private void xv(C0341c c0341c) {
            c();
            if (c0341c == null) {
                return;
            }
            this.f25089w.offer(c0341c);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.xv) {
                synchronized (this) {
                    if (!this.ux.isEmpty()) {
                        xv();
                    }
                    while (!this.f25089w.isEmpty()) {
                        C0341c poll = this.f25089w.poll();
                        if (poll != null) {
                            int i4 = poll.f25090c;
                            if (i4 == 0) {
                                String[] strArr2 = poll.xv;
                                if (strArr2 != null && strArr2.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : poll.xv) {
                                        if (com.bykv.vk.openvk.component.video.c.xv.c.c(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    sr.xv().c(false, !TextUtils.isEmpty(poll.ux), poll.sr, poll.f25093w, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                            } else if (i4 == 1) {
                                sr.xv().c(poll.f25093w);
                            } else if (i4 == 2) {
                                sr.xv().sr();
                            } else if (i4 == 3) {
                                sr.xv().sr();
                                if (ux.w() != null) {
                                    ux.w().c();
                                }
                                if (ux.c() != null) {
                                    ux.c().c();
                                }
                            } else if (i4 == 4) {
                                sr.xv().sr();
                                this.xv = false;
                            }
                            c(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        private void xv() {
            c();
            while (true) {
                C0341c poll = this.ux.poll();
                if (poll == null) {
                    return;
                }
                poll.f25093w = poll.f25091f.fp();
                poll.xv = new String[]{poll.f25091f.fp()};
                int w3 = poll.f25091f.w();
                if (w3 <= 0) {
                    w3 = poll.f25091f.f();
                }
                poll.sr = w3;
                poll.ux = poll.f25091f.ia();
                if (!TextUtils.isEmpty(poll.f25091f.ia())) {
                    poll.f25093w = poll.f25091f.ia();
                }
                poll.f25091f = null;
                xv(poll);
            }
        }

        private void c(C0341c c0341c) {
            c();
            c0341c.xv = null;
            c0341c.f25093w = null;
            c0341c.f25090c = -1;
            c0341c.f25091f = null;
            this.sr.offer(c0341c);
        }

        public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
            w(c(0, srVar));
        }
    }

    public String w(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        if (srVar == null) {
            return null;
        }
        boolean z3 = !TextUtils.isEmpty(srVar.ia());
        return f.c().c(false, z3, z3 ? srVar.ia() : srVar.fp(), srVar.fp());
    }
}
