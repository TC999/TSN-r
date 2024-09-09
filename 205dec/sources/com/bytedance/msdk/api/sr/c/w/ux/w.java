package com.bytedance.msdk.api.sr.c.w.ux;

import android.content.Context;
import com.bytedance.msdk.api.sr.c.w.w.w;
import com.bytedance.msdk.api.sr.c.w.w.xv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends xv {
    public abstract void c(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar);

    public final void ev() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.3
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.p_();
                    }
                }
            });
        }
    }

    public final void gd() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.4
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.q_();
                    }
                }
            });
        }
    }

    public final void ia() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.5
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.ux();
                    }
                }
            });
        }
    }

    public final void s() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.6
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.f();
                    }
                }
            });
        }
    }

    public void c(double d4, Map<String, Object> map) {
        if (!k()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter callLoadSuccess");
            c cVar = new c();
            this.sr = cVar;
            cVar.c(this.f27605r);
            this.sr.c(this.f27606w.a());
            if (d4 > 0.0d && t() == 1) {
                this.sr.c(d4);
            }
            this.sr.w(map);
            this.sr.c(this);
            com.bytedance.msdk.adapter.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.notifyAdLoaded(this.sr);
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }

    public final void f() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.1
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    w.this.w(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.1.1
                        @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                        public void c() {
                            com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void r() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.2
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    w.this.xv(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.2.1
                        @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                        public void c() {
                            com.bytedance.msdk.api.sr.c.sr.c cVar = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                            if (cVar != null) {
                                cVar.o_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void ux() {
        com.bytedance.msdk.api.sr.c.w.w.c cVar;
        com.bytedance.msdk.adapter.c cVar2 = this.xv;
        if (cVar2 == null || (cVar = this.sr) == null) {
            return;
        }
        cVar2.notifyAdVideoCache(cVar, (com.bytedance.msdk.api.c) null);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void w(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar) {
        c(context, wVar, xvVar);
    }

    public final void c(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.f27605r = hashMap;
            hashMap.putAll(map);
        }
    }

    public final void c(com.bytedance.msdk.api.sr.c.w.c cVar) {
        if (!a()) {
            com.bytedance.msdk.adapter.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.notifyAdFailed(new com.bytedance.msdk.api.c(49006, com.bytedance.msdk.api.c.c(49007), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }

    public final void c(final com.bytedance.msdk.api.xv.c cVar) {
        if (cVar == null || this.sr == null) {
            return;
        }
        c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.ux.w.7
            @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
            public void c() {
                com.bytedance.msdk.api.sr.c.sr.c cVar2 = (com.bytedance.msdk.api.sr.c.sr.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                if (cVar2 != null) {
                    cVar2.c(cVar);
                }
            }
        });
    }
}
