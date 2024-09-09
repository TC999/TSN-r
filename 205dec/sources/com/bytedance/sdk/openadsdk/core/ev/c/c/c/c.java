package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33373a;

    /* renamed from: c  reason: collision with root package name */
    protected me f33374c;
    private ia gd;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f33376k;

    /* renamed from: r  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w f33378r;
    protected com.bytedance.sdk.openadsdk.core.p.xv.xv.xv sr;
    protected String ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f33379w;
    protected String xv;

    /* renamed from: f  reason: collision with root package name */
    protected volatile boolean f33375f = false;

    /* renamed from: p  reason: collision with root package name */
    private int f33377p = 0;
    protected Bridge ev = k.sr().u();

    private boolean f() {
        ia iaVar;
        if (this.ev == null || (iaVar = this.gd) == null || iaVar.xv() == 1 || this.gd.w()) {
            return true;
        }
        if (((Boolean) this.ev.call(6, b.a().h(0, new y().c("downloadUrl", this.ux)).l(), Boolean.class)).booleanValue()) {
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(c.this.f33379w, "\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d...", 0).show();
                }
            });
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        r rVar = new r(this.f33374c.ix(), this.f33379w, this.xv);
        rVar.c(this.f33374c);
        rVar.c(this.f33375f);
        return rVar.c(new HashMap());
    }

    private void ux() {
        c(this.f33376k);
        if (this.f33379w == null || TextUtils.isEmpty(this.ux) || !f()) {
            return;
        }
        this.sr.c(sr(), this.f33374c);
        y<String, Object> c4 = new y().c("downloadUrl", this.ux);
        com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c w3 = w(c4);
        if (w3 == null || c((com.bytedance.sdk.openadsdk.core.u.xv) null, w3, c4)) {
            return;
        }
        c(c4, w3);
    }

    abstract com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, Map<String, Object> map);

    abstract com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.w c(Map<String, Object> map, y<String, Object> yVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.sdk.openadsdk.core.p.xv.xv.c sr() {
        if (xv()) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.ux();
        }
        if (this.f33375f) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.xv.sr();
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.xv.w();
    }

    abstract com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c w(Map<String, Object> map);

    abstract void w(boolean z3);

    public boolean w() {
        if (this.f33374c.ja() || TextUtils.isEmpty(this.ux)) {
            return false;
        }
        if (ys.xv(this.f33379w) == 0) {
            try {
                Context context = this.f33379w;
                Toast.makeText(context, i.w(context, "tt_no_network"), 0).show();
            } catch (Exception unused) {
            }
            return true;
        }
        ux();
        return true;
    }

    public void xv(boolean z3) {
        this.f33375f = z3;
    }

    abstract boolean xv();

    private void xv(Map<String, Object> map) {
        Bridge bridge = this.ev;
        if (bridge != null) {
            bridge.call(16, b.a().h(0, map).l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        if (c()) {
            return w();
        }
        return false;
    }

    private void w(com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c cVar, Map<String, Object> map) {
        if (this.ev == null) {
            return;
        }
        y<String, Object> c4 = new y().c("itemClickListener", null).c("downloadButtonClickListener", cVar).c(map);
        if (eq.f33190w < 4500) {
            this.ev.call(17, b.a().h(0, c4).l(), Void.class);
            return;
        }
        c4.put("itemClickListener", c(map, c4));
        this.ev.call(17, b.a().h(0, c4).l(), Void.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        return (this.f33374c == null || this.f33379w == null || this.ev == null || TextUtils.isEmpty(this.ux) || TextUtils.isEmpty(this.xv) || this.sr == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, final com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c cVar, final Map<String, Object> map) {
        if (this.sr.c()) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar2 = this.f33373a;
            if (cVar2 == null || !cVar2.c(new HashMap())) {
                this.sr.c(xvVar, this.xv, this.ux, new com.bytedance.sdk.openadsdk.core.p.xv.c.w() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.2
                    @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.w
                    public void c() {
                        if (c.this.xv()) {
                            c.this.c(true);
                            c.this.c(map, cVar);
                            return;
                        }
                        c.this.c(cVar, map);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.openadsdk.core.u.xv xvVar, Map<String, Object> map) {
        c(c(xvVar, map), map);
    }

    public void c(boolean z3) {
        if (eq.f33190w >= 5400 && xv()) {
            w(z3);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.ev.c.c.c.w.w wVar) {
        this.f33378r = wVar;
    }

    public void c(ia iaVar) {
        this.gd = iaVar;
    }

    public void c(int i4) {
        this.f33377p = i4;
    }

    public void c(com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar) {
        this.f33373a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.p.ev.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(cVar, map);
            }
        }, this.f33374c);
        this.f33376k = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c cVar, Map<String, Object> map) {
        try {
            if (cVar == null) {
                xv(map);
                this.f33376k = false;
                return;
            }
            w(cVar, map);
            this.f33376k = false;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final Map<String, Object> map, final boolean z3) {
        int i4 = this.f33377p;
        if (i4 == 1) {
            if (r()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.p.xv.k.c(ls.getContext());
        } else if (i4 == 2) {
            com.bytedance.sdk.component.gd.ev.w(new p("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.4
                @Override // java.lang.Runnable
                public void run() {
                    ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                    c cVar = c.this;
                    com.bytedance.sdk.openadsdk.core.u.xv c5 = c4.c(cVar.f33374c, cVar.ux);
                    if (c5 == null || !c5.ux()) {
                        if (c.this.r()) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.p.xv.k.c(ls.getContext());
                    } else if (z3) {
                        c.this.w(c5, map);
                    } else {
                        c.this.c((com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c) null, map);
                    }
                }
            });
        } else if (z3) {
            w((com.bytedance.sdk.openadsdk.core.u.xv) null, map);
        } else {
            c((com.bytedance.sdk.openadsdk.core.ev.c.c.c.c.c) null, map);
        }
    }
}
