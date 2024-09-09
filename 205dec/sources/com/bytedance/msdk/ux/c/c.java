package com.bytedance.msdk.ux.c;

import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.ux.f;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w, com.bytedance.msdk.ux.w.w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28439c;

    /* renamed from: w  reason: collision with root package name */
    private w f28440w;
    private com.bytedance.msdk.ux.w.w xv = new com.bytedance.msdk.ux.w.c();

    private c() {
    }

    public static c p() {
        if (f28439c == null) {
            synchronized (c.class) {
                if (f28439c == null) {
                    f28439c = new c();
                }
            }
        }
        return f28439c;
    }

    @Override // com.bytedance.msdk.ux.w.w
    public void a() {
        this.xv.a();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long bk() {
        return this.xv.bk();
    }

    @Override // com.bytedance.msdk.ux.c.w
    public synchronized void c(String str, boolean z3) {
        com.bytedance.msdk.core.w.k().xv(str);
        com.bytedance.msdk.core.w.k().xv(z3);
        w p3 = com.bytedance.msdk.ux.xv.c.c().xv() ? com.bytedance.msdk.ux.ux.w.p() : com.bytedance.msdk.ux.sr.c.p();
        this.f28440w = p3;
        p3.c(com.bytedance.msdk.core.w.k().a(), z3);
    }

    @Override // com.bytedance.msdk.ux.sr
    public boolean ev() {
        w wVar = this.f28440w;
        if (wVar == null) {
            return true;
        }
        return wVar.ev();
    }

    @Override // com.bytedance.msdk.ux.xv
    public int f() {
        w wVar = this.f28440w;
        if (wVar == null) {
            return 0;
        }
        return wVar.f();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public boolean fp() {
        return this.xv.fp();
    }

    @Override // com.bytedance.msdk.ux.ux
    public wv gd() {
        w wVar = this.f28440w;
        if (wVar != null) {
            return wVar.gd();
        }
        return f.f();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public boolean ia() {
        return this.xv.ia();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public void k() {
        this.xv.k();
    }

    @Override // com.bytedance.msdk.ux.sr
    public void r() {
        w wVar = this.f28440w;
        if (wVar != null) {
            wVar.r();
        }
    }

    @Override // com.bytedance.msdk.ux.xv
    public int sr() {
        w wVar = this.f28440w;
        if (wVar == null) {
            return 100;
        }
        return wVar.sr();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long t() {
        return this.xv.t();
    }

    @Override // com.bytedance.msdk.ux.xv
    public long ux() {
        w wVar = this.f28440w;
        return wVar == null ? PolicyConfig.THREAD_BLOCK_TIMEOUT : wVar.ux();
    }

    @Override // com.bytedance.msdk.ux.w
    public List<com.bytedance.msdk.core.k.c> w() {
        w wVar = this.f28440w;
        if (wVar == null) {
            return null;
        }
        return wVar.w();
    }

    @Override // com.bytedance.msdk.ux.w
    public boolean xv() {
        w wVar = this.f28440w;
        if (wVar == null) {
            return false;
        }
        return wVar.xv();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public long ys() {
        return this.xv.ys();
    }

    public boolean w(String str) {
        com.bytedance.msdk.core.k.c c4 = c(str);
        return c4 != null && c4.sr();
    }

    @Override // com.bytedance.msdk.ux.w.w
    public void xv(String str) {
        this.xv.xv(str);
    }

    public void xv(Map<String, Object> map) {
        if (p().fp()) {
            if (p().bk() > 0) {
                p().xv(com.bytedance.msdk.xv.c.xv);
                map.put("call_init_method_duration", Long.valueOf(p().bk()));
            }
        } else if (p().ia()) {
            map.put("call_init_method_duration", Long.valueOf(p().bk()));
        }
    }

    @Override // com.bytedance.msdk.ux.xv
    public void w(JSONObject jSONObject) {
        w wVar = this.f28440w;
        if (wVar == null || jSONObject == null) {
            return;
        }
        wVar.w(jSONObject);
    }

    @Override // com.bytedance.msdk.ux.w
    public void c(JSONObject jSONObject) {
        w wVar = this.f28440w;
        if (wVar != null) {
            wVar.c(jSONObject);
        }
        xv(jSONObject);
    }

    public void w(Map<String, Object> map) {
        if (p().fp()) {
            p().xv(com.bytedance.msdk.xv.c.xv);
            map.put("init_splash_fill_duration", Long.valueOf(p().ys()));
        } else if (p().ia()) {
            map.put("init_splash_fill_duration", Long.valueOf(p().ys()));
        }
    }

    @Override // com.bytedance.msdk.ux.w
    public void c() {
        w wVar = this.f28440w;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void xv(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.ux.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ux.xv.w.c().c(jSONObject);
            }
        });
    }

    @Override // com.bytedance.msdk.ux.w
    public com.bytedance.msdk.core.k.c c(String str) {
        w wVar = this.f28440w;
        if (wVar == null) {
            return null;
        }
        return wVar.c(str);
    }

    public void w(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.ux.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ux.xv.w.c().c(jSONArray);
            }
        });
    }

    @Override // com.bytedance.msdk.ux.sr
    public void c(JSONArray jSONArray) {
        w wVar = this.f28440w;
        if (wVar != null) {
            wVar.c(jSONArray);
        }
        w(jSONArray);
    }

    @Override // com.bytedance.msdk.ux.sr
    public com.bytedance.msdk.core.k.w c(String str, int i4, int i5) {
        w wVar = this.f28440w;
        if (wVar == null) {
            return null;
        }
        return wVar.c(str, i4, i5);
    }

    public void c(Map<String, Object> map) {
        if (p().fp()) {
            map.put("init_splash_request_duration", Long.valueOf(p().t()));
        } else if (p().ia()) {
            map.put("init_splash_request_duration", Long.valueOf(p().t()));
        }
    }

    @Override // com.bytedance.msdk.ux.ux
    public void c(Runnable runnable) {
        w wVar = this.f28440w;
        if (wVar != null) {
            wVar.c(runnable);
        }
    }

    public w c(int i4) {
        w p3;
        if (i4 != 1 && i4 != 2) {
            p3 = com.bytedance.msdk.ux.sr.c.p();
        } else {
            p3 = com.bytedance.msdk.ux.ux.w.p();
        }
        p3.c(com.bytedance.msdk.core.w.k().a(), com.bytedance.msdk.core.w.k().bk());
        return p3;
    }
}
