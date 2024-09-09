package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static volatile f f31673c;
    private w sr;

    /* renamed from: w  reason: collision with root package name */
    private xv f31674w = xv.c();
    private Map<String, Object> xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private int f31676w;

        public c(int i4) {
            this.f31676w = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f31676w != 100 || f.this.sr == null) {
                return;
            }
            f fVar = f.this;
            fVar.w(fVar.sr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class xv {

        /* renamed from: c  reason: collision with root package name */
        public int f31680c = 500;

        /* renamed from: w  reason: collision with root package name */
        public int f31681w = 5000;
        public int xv = 1000;
        public int sr = 300;

        public static xv c() {
            return new xv();
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(w wVar) {
        if (wVar == null) {
            return;
        }
        boolean c4 = k.sr().c();
        boolean c5 = k.sr().c(true);
        if (c5 && !c4) {
            c(wVar);
            return;
        }
        if (wVar.ux == null) {
            wVar.ux = new HashMap();
        }
        wVar.ux.put("is_background", Boolean.valueOf(c4));
        wVar.ux.put("has_focus", Boolean.valueOf(c5));
        xv(wVar.setResult(true));
    }

    private void xv(w wVar) {
        if (wVar == null) {
            return;
        }
        ev.c(wVar, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w extends p implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f31677c;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31678f;
        public String sr;
        public Map<String, Object> ux;

        /* renamed from: w  reason: collision with root package name */
        public final AtomicBoolean f31679w;
        public me xv;

        w() {
            super("EventData");
            this.f31677c = new AtomicInteger(0);
            this.f31679w = new AtomicBoolean(false);
        }

        public static w c(me meVar, String str, Map<String, Object> map, boolean z3) {
            return new w(meVar, str, map, z3);
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            me meVar;
            if (this.xv != null && !TextUtils.isEmpty(this.sr) && (atomicBoolean = this.f31679w) != null) {
                if (this.f31678f) {
                    a.w("DMLibManager", "\u843d\u5730\u9875\u8c03\u8d77\u5e94\u7528\u662f\u5426\u6210\u529f sResult.get() " + this.f31679w.get());
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, this.f31679w.get() ? "lp_dpl_success" : "lp_dpl_failed");
                    return;
                }
                com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.ux);
                AtomicBoolean atomicBoolean2 = this.f31679w;
                if (atomicBoolean2 == null || !atomicBoolean2.get() || (meVar = this.xv) == null) {
                    return;
                }
                f.w(meVar, this.sr);
                return;
            }
            a.c("materialMeta or eventTag or sResult is null, pls check");
        }

        public w setResult(boolean z3) {
            this.f31679w.set(z3);
            return this;
        }

        public int w() {
            return this.f31677c.get();
        }

        public void xv() {
            this.f31677c.incrementAndGet();
        }

        w(me meVar, String str, Map<String, Object> map, boolean z3) {
            super("EventData");
            this.f31677c = new AtomicInteger(0);
            this.f31679w = new AtomicBoolean(false);
            this.xv = meVar;
            this.sr = str;
            this.ux = map;
            this.f31678f = z3;
        }
    }

    public static f c() {
        if (f31673c == null) {
            synchronized (f.class) {
                if (f31673c == null) {
                    f31673c = new f();
                }
            }
        }
        return f31673c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(me meVar, String str) {
        if (meVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        c4.c("save_dpl_success_time", System.currentTimeMillis());
        JSONObject mo = meVar.mo();
        if (mo == null) {
            return;
        }
        c4.c("save_dpl_success_materialmeta", mo.toString());
        c4.c("save_dpl_success_ad_tag", str);
    }

    public void c(me meVar, String str, boolean z3) {
        this.sr = w.c(meVar, str, this.xv, z3);
        ev.sr().schedule(new c(100), 0L, TimeUnit.MILLISECONDS);
    }

    private void c(w wVar) {
        if (wVar == null) {
            return;
        }
        wVar.xv();
        int w3 = wVar.w();
        xv xvVar = this.f31674w;
        if (w3 * xvVar.f31680c > xvVar.f31681w) {
            xv(wVar.setResult(false));
        } else {
            ev.sr().schedule(new c(100), this.f31674w.f31680c, TimeUnit.MILLISECONDS);
        }
    }
}
