package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f34435c;
    private int sr;

    /* renamed from: w  reason: collision with root package name */
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.c.c> f34438w;
    private final long xv;
    private CopyOnWriteArrayList<String> ux = new CopyOnWriteArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f34436f = new CopyOnWriteArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.ia.xv>> f34437r = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> ev = new ConcurrentHashMap<>();
    private final Object gd = new Object();

    private sr() {
        int v3 = ls.w().v();
        this.sr = v3;
        if (v3 > 30) {
            this.sr = 30;
        } else if (v3 < 0) {
            this.sr = 5;
        }
        long kr = ls.w().kr() * 1000;
        this.xv = kr;
        c("cacheSetting \u7f13\u5b58\u6700\u5927\u4e2a\u6570: " + this.sr + "  \u7f13\u5b58\u8fc7\u671f\u65f6\u95f4: " + kr);
        this.f34438w = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.c.c>(this.sr) { // from class: com.bytedance.sdk.openadsdk.core.playable.sr.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: c */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.c.c cVar) {
                return 1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
    }

    private void sr(final me meVar) {
        if (TextUtils.isEmpty(meVar.kw())) {
            return;
        }
        final String kw = meVar.kw();
        if (this.ux.contains(kw)) {
            c("prefetchCache... running,no add new ");
        } else if (this.f34436f.contains(kw)) {
            c("prefetchCache... discarded ");
        } else if (this.f34438w.get(kw) != null) {
            c("prefetchCache... cache exist ");
        } else {
            this.ux.add(kw);
            this.ev.put(kw, Long.valueOf(System.currentTimeMillis()));
            com.bytedance.sdk.component.gd.ev.w(new p("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.sr.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        sr.this.c(meVar, kw);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void w(me meVar) {
        if (meVar != null) {
            try {
                if (TextUtils.isEmpty(meVar.kw())) {
                    return;
                }
                String kw = meVar.kw();
                this.f34436f.add(kw);
                this.f34438w.remove(kw);
                this.ux.remove(kw);
                this.f34437r.remove(kw);
                this.ev.remove(kw);
                c("clearCache... mRomCache size: " + this.f34438w.size());
                c("clearCache... mRunningTasks size: " + this.ux.size());
                c("clearCache... mDiscardTasks size: " + this.f34436f.size());
            } catch (Exception unused) {
            }
        }
    }

    public long xv(me meVar) {
        try {
            if (this.ev == null || meVar == null || TextUtils.isEmpty(meVar.kw())) {
                return 0L;
            }
            return this.ev.get(meVar.kw()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static sr c() {
        if (f34435c == null) {
            synchronized (sr.class) {
                if (f34435c == null) {
                    f34435c = new sr();
                }
            }
        }
        return f34435c;
    }

    public void c(me meVar) {
        if (meVar != null) {
            try {
                if (meVar.jy() == 3) {
                    sr(meVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(me meVar, final String str) {
        c("prefetchCache... \u5f00\u59cb\u8bf7\u6c42 key: " + str);
        com.bytedance.sdk.openadsdk.core.q.w.c(meVar, meVar == null ? null : meVar.ya(), new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.playable.sr.3
            @Override // com.bytedance.sdk.openadsdk.core.ia.xv
            public void c(boolean z3, List<me> list, boolean z4) {
                try {
                    if (sr.this.f34436f != null && sr.this.f34436f.contains(str)) {
                        sr srVar = sr.this;
                        srVar.c("prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    sr srVar2 = sr.this;
                    srVar2.c("prefetchCache-onAdLoaded.. success: " + z3);
                    synchronized (sr.this.gd) {
                        if (z3 && list != null && list.size() > 0) {
                            com.bytedance.sdk.openadsdk.core.playable.c.c cVar = new com.bytedance.sdk.openadsdk.core.playable.c.c();
                            cVar.f34420c = list;
                            cVar.f34421w = z3;
                            cVar.xv = SystemClock.elapsedRealtime();
                            sr.this.f34438w.put(str, cVar);
                            sr srVar3 = sr.this;
                            srVar3.c("prefetchCache-onAdLoaded.. \u7f13\u5b58save  key: " + str);
                        }
                        sr.this.ux.remove(str);
                    }
                    WeakReference weakReference = (WeakReference) sr.this.f34437r.get(str);
                    com.bytedance.sdk.openadsdk.core.ia.xv xvVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.ia.xv) weakReference.get();
                    if (xvVar != null) {
                        xvVar.c(z3, list, true);
                        sr.this.f34437r.remove(str);
                        sr srVar4 = sr.this;
                        srVar4.c("prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.ys.w.xv.w) null);
    }

    public boolean c(me meVar, com.bytedance.sdk.openadsdk.core.ia.xv xvVar) {
        if (meVar != null && !TextUtils.isEmpty(meVar.kw())) {
            String kw = meVar.kw();
            try {
            } catch (Exception unused) {
            }
            synchronized (this.gd) {
                if (this.ux.contains(kw)) {
                    this.f34437r.put(kw, new WeakReference<>(xvVar));
                    return true;
                }
                com.bytedance.sdk.openadsdk.core.playable.c.c cVar = this.f34438w.get(kw);
                if (cVar == null) {
                    return false;
                }
                if (c(cVar)) {
                    w(meVar);
                    return false;
                }
                if (xvVar != null) {
                    c("getCache..callback invoke key: " + kw);
                    xvVar.c(cVar.f34421w, cVar.f34420c, true);
                    return true;
                }
                c("getCache:  null");
            }
        }
        return false;
    }

    private boolean c(com.bytedance.sdk.openadsdk.core.playable.c.c cVar) {
        return this.xv > 0 && cVar != null && SystemClock.elapsedRealtime() - cVar.xv > this.xv;
    }
}
