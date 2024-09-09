package com.bytedance.sdk.component.adexpress.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.c.xv.c;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.s;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends xv {

    /* renamed from: c  reason: collision with root package name */
    private static File f29035c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile ux f29036w;
    private AtomicBoolean xv = new AtomicBoolean(true);
    private AtomicBoolean sr = new AtomicBoolean(false);
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f29037f = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private AtomicInteger f29038r = new AtomicInteger(0);
    private AtomicLong ev = new AtomicLong();

    private ux() {
        ev();
    }

    private void ev() {
        com.bytedance.sdk.component.adexpress.sr.xv.w(new p("init") { // from class: com.bytedance.sdk.component.adexpress.c.w.ux.1
            @Override // java.lang.Runnable
            public void run() {
                ev.c();
                ux.this.xv.set(false);
                ux.this.xv();
                ux.this.f();
                if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() == null || !s.c(com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.c.c.c.c().xv().w().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.c.w.ux.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() != null) {
                            com.bytedance.sdk.component.adexpress.c.c.c.c().xv().xv();
                        }
                    }
                });
            }
        }, 10);
    }

    private void gd() {
        if (this.f29038r.getAndSet(0) <= 0 || System.currentTimeMillis() - this.ev.get() <= 600000) {
            return;
        }
        f();
    }

    public static File r() {
        if (f29035c == null) {
            try {
                File file = new File(new File(sr.c(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                f29035c = file;
            } catch (Throwable th) {
                a.xv("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f29035c;
    }

    public static ux w() {
        if (f29036w == null) {
            synchronized (ux.class) {
                if (f29036w == null) {
                    f29036w = new ux();
                }
            }
        }
        return f29036w;
    }

    public void f() {
        c(false);
    }

    public boolean sr() {
        return this.ux;
    }

    public com.bytedance.sdk.component.adexpress.c.xv.c ux() {
        return ev.w();
    }

    public void xv() {
        com.bytedance.sdk.component.adexpress.c.xv.c w3 = ev.w();
        if (w3 == null || !w3.f()) {
            return;
        }
        boolean c4 = c(w3);
        if (!c4) {
            ev.sr();
        }
        this.ux = c4;
    }

    public boolean c(com.bytedance.sdk.component.adexpress.c.xv.c cVar) {
        if (cVar == null) {
            return false;
        }
        return c(cVar.c()) || c(cVar.ux()) || c(cVar.getResources());
    }

    @Override // com.bytedance.sdk.component.adexpress.c.w.xv
    public File c() {
        return r();
    }

    public void c(boolean z3) {
        boolean z4;
        if (this.xv.get()) {
            a.w("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.sr.get()) {
                if (z3) {
                    this.f29038r.getAndIncrement();
                }
                a.w("TemplateManager", "loadTemplate error2: " + z3);
                return;
            }
            boolean z5 = true;
            this.sr.set(true);
            com.bytedance.sdk.component.adexpress.c.xv.c sr = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().sr();
            com.bytedance.sdk.component.adexpress.c.xv.c w3 = ev.w();
            if (sr != null && sr.f()) {
                if (!ev.w(sr)) {
                    this.sr.set(false);
                    this.ev.set(System.currentTimeMillis());
                    a.w("TemplateManager", "loadTemplate error4");
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() != null) {
                    com.bytedance.sdk.component.adexpress.c.c.c.c().xv().w().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.c.w.ux.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.ux.ux.c().w();
                        }
                    });
                }
                ev.c(sr);
                boolean c4 = (sr.ux() == null || TextUtils.isEmpty(sr.ux().c())) ? false : c(sr.ux().c());
                List<c.C0435c> list = null;
                if (sr.c().size() != 0) {
                    list = c(sr, w3);
                    z4 = list != null;
                } else {
                    z4 = c4;
                }
                if (!c4) {
                    List<c.C0435c> w4 = w(sr, w3);
                    if (list == null || w4 == null) {
                        list = w4;
                    } else {
                        list.addAll(w4);
                    }
                    if (w4 == null) {
                        z5 = false;
                    }
                    if (w4 == null) {
                        this.sr.set(false);
                    }
                    z4 = z5;
                }
                if (z4 && c(sr)) {
                    ev.c(sr);
                    ev.xv();
                    w(list);
                }
                xv();
                this.sr.set(false);
                this.ev.set(System.currentTimeMillis());
                gd();
                return;
            }
            this.sr.set(false);
            c(109);
        } catch (Throwable th) {
            a.c("TemplateManager", "loadTemplate error: ", th);
        }
    }
}
