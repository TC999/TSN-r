package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.fp;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.bj;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.vc;
import com.bytedance.sdk.openadsdk.core.u.wv;
import com.bytedance.sdk.openadsdk.core.z;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements n.c {

    /* renamed from: c  reason: collision with root package name */
    private static final Integer f33066c = 2;

    /* renamed from: k  reason: collision with root package name */
    private c f33068k;
    private sr sr;

    /* renamed from: w  reason: collision with root package name */
    private final n f33071w = new n(Looper.getMainLooper(), this);
    private final WeakHashMap<Integer, InterfaceC0489xv> xv = new WeakHashMap<>();
    private volatile com.bytedance.sdk.component.f.c ux = null;

    /* renamed from: f  reason: collision with root package name */
    private long f33067f = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f33070r = 0;
    private AtomicBoolean ev = new AtomicBoolean(false);
    private com.bytedance.sdk.component.f.c gd = ba.c("tt_materialMeta");

    /* renamed from: p  reason: collision with root package name */
    private AtomicBoolean f33069p = new AtomicBoolean(false);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        xv f33098c;

        /* renamed from: w  reason: collision with root package name */
        private ConcurrentHashMap<String, C0488c> f33099w;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.xv$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class C0488c {

            /* renamed from: c  reason: collision with root package name */
            String f33116c;
            boolean sr = false;

            /* renamed from: w  reason: collision with root package name */
            com.bytedance.sdk.openadsdk.ys.w.xv.w f33117w;
            wv xv;

            C0488c(String str, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
                this.f33116c = str;
                this.f33117w = wVar;
                this.xv = wvVar;
            }

            public void c(boolean z3) {
                this.sr = z3;
            }

            public boolean c() {
                return this.sr;
            }
        }

        private boolean w(ConcurrentHashMap<String, C0488c> concurrentHashMap) {
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return false;
            }
            for (Map.Entry<String, C0488c> entry : concurrentHashMap.entrySet()) {
                C0488c value = entry.getValue();
                if (value != null && !value.c()) {
                    return true;
                }
            }
            return false;
        }

        private void xv(ConcurrentHashMap<String, C0488c> concurrentHashMap) {
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return;
            }
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "\u91cd\u7f6e\u5f00\u5c4frit\u8bf7\u6c42\u72b6\u6001");
            Iterator<Map.Entry<String, C0488c>> it = concurrentHashMap.entrySet().iterator();
            if (it == null) {
                return;
            }
            while (it.hasNext()) {
                C0488c value = it.next().getValue();
                if (value != null) {
                    value.c(false);
                }
            }
        }

        private c(xv xvVar) {
            this.f33099w = new ConcurrentHashMap<>();
            this.f33098c = xvVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
            int bm;
            if (wVar == null || wvVar == null || TextUtils.isEmpty(wVar.f()) || !c()) {
                return;
            }
            if (!this.f33099w.containsKey(wVar.f())) {
                com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "add adSlot.getCodeId() " + wVar.f());
                this.f33099w.put(wVar.f(), new C0488c(wVar.f(), wVar, wvVar));
            }
            if (!ls.sr() && (bm = ls.w().bm()) > 0) {
                ls.xv();
                com.bytedance.sdk.component.gd.ev.sr().scheduleWithFixedDelay(new com.bytedance.sdk.component.gd.p("timeLoopLoadAd") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "\u89e6\u53d1\u5b9a\u65f6\u5668\u8fdb\u884c\u68c0\u6d4b\u5b9e\u73b0\u9700\u8981\u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a");
                        c cVar = c.this;
                        cVar.c(cVar.f33099w);
                    }
                }, 0L, (bm * 60000) + 10000, TimeUnit.MILLISECONDS);
            }
        }

        private boolean c() {
            return ls.w().bj() == 1 && ls.w().bm() > 0;
        }

        private int c(long j4) {
            if (j4 <= 0) {
                return 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j4;
            if (currentTimeMillis <= 0) {
                return 0;
            }
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "CircleLoadSplashAd getIntervalTime temp " + currentTimeMillis);
            return (int) (currentTimeMillis / 60000);
        }

        private boolean c(String str) {
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd rit " + str);
            com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
            long w3 = c4.w("last_load_splash_ad_time" + str, 0L);
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd lastLoadAdTime " + w3);
            return c(w3) >= ls.w().bm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ConcurrentHashMap<String, C0488c> concurrentHashMap) {
            Map.Entry<String, C0488c> next;
            C0488c value;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                Iterator<Map.Entry<String, C0488c>> it = concurrentHashMap.entrySet().iterator();
                if (it == null) {
                    return;
                }
                while (it.hasNext() && (next = it.next()) != null && (value = next.getValue()) != null) {
                    if (!value.c()) {
                        com.bytedance.sdk.openadsdk.ys.w.xv.w wVar = value.f33117w;
                        wv wvVar = value.xv;
                        com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", " loadSplashParamHashMapTest " + concurrentHashMap.size());
                        com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "byRitLoadSplashAd \u5f00\u59cb\u8bf7\u6c42\u5e7f\u544a");
                        value.c(true);
                        c(next.getKey(), wVar, wvVar);
                        return;
                    }
                }
                return;
            }
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "mloadSplashParaHashMap == null || mloadSplashParaHashMap.size() == 0 ");
        }

        private void c(String str, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (c(str)) {
                if (this.f33098c != null) {
                    com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "adSlot " + wVar.p() + "  " + wVar.k());
                    StringBuilder sb = new StringBuilder();
                    sb.append("\u5faa\u73af\u8bf7\u6c42\u5e7f\u544a adSlot getCodeId ");
                    sb.append(wVar.f());
                    com.bytedance.sdk.component.utils.a.f(" SplashAdCacheManager", sb.toString());
                    this.f33098c.c(wVar, wvVar);
                }
            } else if (w(this.f33099w)) {
                com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "\u8fd8\u5b58\u5728\u6ca1\u6709\u52a0\u8f7d\u7684\u5f00\u5c4frit\u9700\u8981\u52a0\u8f7d\u5f00\u5c4f");
                c(this.f33099w);
            } else {
                xv(this.f33099w);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
            if (wVar == null || this.f33099w == null || TextUtils.isEmpty(wVar.f())) {
                return;
            }
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "SplashAdCacheManager \u5df2\u7ecf\u52a0\u8f7d\u8fc7\u4e86 adSlot.getCodeId() " + wVar.f());
            C0488c c0488c = this.f33099w.get(wVar.f());
            if (c0488c != null) {
                c0488c.c(true);
            }
            com.bytedance.sdk.component.utils.a.f("SplashAdCacheManager", "SplashAdCacheManager \u662f\u5426\u9700\u8981\u52a0\u8f7d\u5176\u4ed6rit\u5f00\u5c4f\u5e7f\u544a");
            c(this.f33099w);
            if (w(this.f33099w)) {
                return;
            }
            xv(this.f33099w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class sr extends com.bytedance.sdk.component.gd.p {

        /* renamed from: w  reason: collision with root package name */
        private vc f33119w;

        public sr(vc vcVar) {
            super("WriteCacheTask");
            this.f33119w = vcVar;
        }

        private void w() {
            try {
                int c4 = p.c(this.f33119w);
                if (c4 <= 0) {
                    return;
                }
                String w3 = xv.this.gd.w("net_ad_already_shown", "");
                if (TextUtils.isEmpty(w3) || !w3.equals(this.f33119w.c().xq())) {
                    com.bytedance.sdk.component.f.c cVar = xv.this.gd;
                    cVar.c("materialMeta" + c4, this.f33119w.w().xv());
                    com.bytedance.sdk.component.f.c cVar2 = xv.this.gd;
                    cVar2.c("net_ad_save_success" + c4, this.f33119w.c().xq());
                    com.bytedance.sdk.openadsdk.core.ux.c.sr("lqmt", "\u7f13\u5b58\u6210\u529f\uff1a rit: " + c4 + "   reqId: " + this.f33119w.c().xq());
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ux.c.sr("lqmt", "\u7f13\u5b58\u5df2show\uff1a rit: " + c4 + "   reqId: " + this.f33119w.c().xq());
            } catch (Throwable unused) {
            }
        }

        public void c(vc vcVar) {
            this.f33119w = vcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        boolean f33122c = true;

        /* renamed from: w  reason: collision with root package name */
        long f33123w = 0;
        long xv = 0;
        long sr = 0;

        w() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.xv$xv  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0489xv {
        void c();

        void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar);
    }

    private xv(Context context) {
    }

    private void w(vc vcVar) {
        sr srVar = this.sr;
        if (srVar == null) {
            this.sr = new sr(vcVar);
        } else {
            srVar.c(vcVar);
        }
        com.bytedance.sdk.component.gd.ev.c(this.sr, 10);
    }

    private com.bytedance.sdk.openadsdk.core.u.c xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.f.c cVar = this.gd;
        String w3 = cVar.w("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(w3)) {
            try {
                z.c c4 = z.c.c(new JSONObject(w3));
                if (c4 != null) {
                    com.bytedance.sdk.openadsdk.core.u.c cVar2 = c4.ev;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static xv c(Context context) {
        return new xv(context);
    }

    public void c(vc vcVar) {
        int c4;
        if (vcVar != null && (c4 = p.c(vcVar)) > 0) {
            c(c4, vcVar.c().lp());
            w(vcVar);
        }
    }

    private com.bytedance.sdk.component.f.c w() {
        if (this.ux == null) {
            this.ux = ba.c("tt_splash");
        }
        return this.ux;
    }

    private void c(int i4, long j4) {
        com.bytedance.sdk.component.f.c w3 = w();
        w3.c("expiration" + i4, j4);
        w3.c("update" + i4, System.currentTimeMillis() / 1000);
        w3.c("has_ad_cache" + i4, true);
    }

    private void xv(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
        if (this.f33069p.get()) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "\u5df2\u7ecf\u5b58\u50a8\u4e86\u4e00\u4e2a\u5b9e\u65f6\u5e7f\u544a");
        } else if (this.ev.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "\u5df2\u5728\u9884\u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a....\u4e0d\u518d\u53d1\u51fa");
        } else {
            if (ls.w().t(wVar.f()) && wvVar != null) {
                wvVar.f34867r = 2;
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "\u9884\u52a0\u8f7d\u5f00\u5c4f\u5e7f\u544a....");
            ls.c().c(wVar, wvVar, 4, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.2
                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    com.bytedance.sdk.component.utils.a.w("splashLoad", "\u5e7f\u544a\u7269\u6599\u9884\u52a0\u8f7d\u5931\u8d25...." + str + i4);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i4);
                    com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", sb.toString());
                    xv.this.ev.set(false);
                    if (xv.this.f33068k != null) {
                        xv.this.f33068k.c(wVar);
                    }
                    if (wVar != null) {
                        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
                        c4.c("last_load_splash_ad_time" + wVar.f(), System.currentTimeMillis());
                    }
                    wVar2.c(i4);
                    com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    if (!p.c(cVar)) {
                        xv.this.ev.set(false);
                        if (xv.this.f33068k != null) {
                            xv.this.f33068k.c(wVar);
                        }
                    } else {
                        com.bytedance.sdk.component.utils.a.w("splashLoad", "\u5e7f\u544a\u7269\u6599\u9884\u52a0\u8f7d\u6210\u529f....");
                        me meVar = cVar.w().get(0);
                        if (meVar.df()) {
                            if (xv.this.f33069p == null || !xv.this.f33069p.get()) {
                                com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", "\u9884\u52a0\u8f7d\u6210\u529f\uff0c\u5e7f\u544a\u7f13\u5b58\u5230\u672c\u5730----10");
                                xv.this.c(new vc(cVar, meVar, null));
                                xv.this.c(cVar, meVar, wVar);
                            }
                        } else {
                            wVar2.c(-4);
                            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
                        }
                    }
                    if (wVar != null) {
                        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
                        c4.c("last_load_splash_ad_time" + wVar.f(), System.currentTimeMillis());
                    }
                }
            });
        }
    }

    w w(String str) {
        w wVar = new w();
        if (TextUtils.isEmpty(str)) {
            return wVar;
        }
        com.bytedance.sdk.component.f.c w3 = w();
        long w4 = w3.w("expiration" + str, 0L);
        long w5 = w3.w("update" + str, 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        wVar.f33122c = currentTimeMillis < w5 || currentTimeMillis >= w4;
        wVar.f33123w = w5;
        wVar.xv = w4;
        wVar.sr = currentTimeMillis;
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:9:0x0016, B:11:0x001c, B:13:0x0026, B:17:0x0037, B:18:0x003a, B:21:0x0046), top: B:26:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:9:0x0016, B:11:0x001c, B:13:0x0026, B:17:0x0037, B:18:0x003a, B:21:0x0046), top: B:26:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.lang.String r4, com.bytedance.sdk.openadsdk.core.component.splash.xv.InterfaceC0489xv r5) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L4c
            if (r5 != 0) goto L9
            goto L4c
        L9:
            r0 = 0
            com.bytedance.sdk.openadsdk.core.u.c r4 = r3.xv(r4)     // Catch: java.lang.Throwable -> L49
            com.bytedance.sdk.openadsdk.core.component.splash.w.c.f r1 = new com.bytedance.sdk.openadsdk.core.component.splash.w.c.f     // Catch: java.lang.Throwable -> L49
            r2 = 1
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L34
            java.util.List r2 = r4.w()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L34
            java.util.List r2 = r4.w()     // Catch: java.lang.Throwable -> L32
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L34
            java.util.List r4 = r4.w()     // Catch: java.lang.Throwable -> L32
            r2 = 0
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L32
            com.bytedance.sdk.openadsdk.core.u.me r4 = (com.bytedance.sdk.openadsdk.core.u.me) r4     // Catch: java.lang.Throwable -> L32
            goto L35
        L32:
            r0 = r1
            goto L49
        L34:
            r4 = r0
        L35:
            if (r4 == 0) goto L3a
            r1.c(r4)     // Catch: java.lang.Throwable -> L32
        L3a:
            com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper r2 = com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper.getInstance()     // Catch: java.lang.Throwable -> L32
            int r4 = r2.getLiveRoomStatus(r4)     // Catch: java.lang.Throwable -> L32
            r2 = 3
            if (r4 == r2) goto L46
            goto L32
        L46:
            r1.c(r0)     // Catch: java.lang.Throwable -> L32
        L49:
            r5.c(r0)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.xv.c(java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.xv$xv):void");
    }

    public void w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
        if (wVar == null || wvVar == null) {
            return;
        }
        if (this.f33068k == null) {
            this.f33068k = new c();
        }
        this.f33068k.c(wVar, wvVar);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.component.f.c w3 = w();
        return w3.w("has_ad_cache" + str, false);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 2) {
            InterfaceC0489xv remove = this.xv.remove(f33066c);
            if (remove != null) {
                Object obj = message.obj;
                if (obj instanceof com.bytedance.sdk.openadsdk.core.component.splash.w.c.f) {
                    remove.c((com.bytedance.sdk.openadsdk.core.component.splash.w.c.f) obj);
                    com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", "\u89c6\u9891\u7269\u6599\u7f13\u5b58\u53cd\u5e8f\u5217\u5316\u6210\u529f");
                } else {
                    remove.c();
                    com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", "\u89c6\u9891\u7269\u6599\u7f13\u5b58\u53cd\u5e8f\u5217\u5316\u5931\u8d25");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnLoadCacheCallback is null: ");
            sb.append(remove == null);
            com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", sb.toString());
            this.f33071w.removeCallbacksAndMessages(null);
        }
    }

    public boolean c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, boolean z3) {
        final w w3 = w(wVar.f());
        if (z3 && w3.f33122c) {
            com.bytedance.sdk.openadsdk.core.fz.a.c().r(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.1
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    w wVar2 = w3;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf((wVar2.sr - wVar2.f33123w) / 3600));
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(4).xv(wVar.f()).w(jSONObject.toString());
                }
            });
        }
        return w3.f33122c;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, wv wvVar) {
        if (ls.w().w(com.bytedance.sdk.openadsdk.core.eq.wv.c(wVar)) && wVar != null && TextUtils.isEmpty(wVar.j())) {
            com.bytedance.sdk.openadsdk.core.ux.c.w("lqmt", "preLoadSplashAd... ");
            wv wvVar2 = wvVar == null ? new wv() : wvVar.c();
            wvVar2.ev = System.currentTimeMillis();
            wvVar2.f34868t = com.bytedance.sdk.openadsdk.core.k.sr().wx();
            xv(wVar, wvVar2);
        }
    }

    public static void c() {
        ls.w().yn();
    }

    public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final me meVar, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (meVar.nc() == null || meVar.nc().size() <= 0) {
            return;
        }
        gb gbVar = meVar.nc().get(0);
        String c4 = gbVar.c();
        int w3 = gbVar.w();
        int xv = gbVar.xv();
        this.f33067f = System.currentTimeMillis();
        this.f33070r = SystemClock.elapsedRealtime();
        bj xv2 = com.bytedance.sdk.openadsdk.core.q.ux.c().xv().xv();
        if (xv2 != null) {
            xv2.c(false);
        }
        final boolean z3 = ng.bk(meVar) != null;
        fp.c(new com.bytedance.sdk.openadsdk.a.w(c4, gbVar.r()), w3, xv, new fp.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar2, com.bytedance.sdk.component.ux.k kVar) {
                p.c(xv.this, cVar);
                if (!z3) {
                    com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, "splash_ad", System.currentTimeMillis() - xv.this.f33067f);
                }
                com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", "\u56fe\u7247\u6570\u636e\u52a0\u8f7d\u7684\u5e7f\u544a\u7f13\u5b58\u5230\u672c\u5730");
                xv.this.f33067f = 0L;
                if (z3) {
                    p.c(xv.this.f33070r, false, true, meVar, 0L, "preLoadImageSuccess");
                }
                xv.this.ev.set(false);
                if (xv.this.f33068k != null) {
                    xv.this.f33068k.c(wVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c() {
                p.c(xv.this, cVar);
                com.bytedance.sdk.component.utils.a.w("SplashAdCacheManager", "\u56fe\u7247\u6570\u636e\u52a0\u8f7d\u5931\u8d25");
                com.bytedance.sdk.component.utils.a.w("splashLoad", "\u56fe\u7247\u6570\u636e\u9884\u52a0\u8f7d\u5931\u8d25....");
                if (z3) {
                    p.c(xv.this.f33070r, false, false, meVar, -7L, "preLoadImageFailed");
                }
                xv.this.ev.set(false);
                if (xv.this.f33068k != null) {
                    xv.this.f33068k.c(wVar);
                }
            }
        }, com.bytedance.sdk.openadsdk.n.ev.ux(), 4, null, false);
    }

    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, boolean z3) {
        if (com.bytedance.sdk.openadsdk.core.xv.ux.c().n() && !this.f33069p.get()) {
            this.f33069p.set(true);
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            c(new vc(fVar.sr(), fVar.w(), null));
            if (z3) {
                c(fVar.sr(), fVar.w(), wVar);
            }
            com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }
}
