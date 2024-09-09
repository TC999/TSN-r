package com.bytedance.msdk.api.sr.c.w.p;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.msdk.api.sr.c.w.w.w;
import com.bytedance.msdk.api.sr.c.w.xv.xv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.msdk.api.sr.c.w.w.w {
    public abstract void c(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar);

    public abstract void c(ViewGroup viewGroup);

    public final void ev() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.4
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.gd.w wVar = (com.bytedance.msdk.api.sr.c.gd.w) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (wVar != null) {
                        wVar.w(2);
                    }
                }
            });
        }
    }

    public final void f() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.2
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    w.this.w(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.2.1
                        @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                        public void c() {
                            com.bytedance.msdk.api.sr.c.gd.w wVar = (com.bytedance.msdk.api.sr.c.gd.w) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                            if (wVar != null) {
                                wVar.u_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void r() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.3
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.gd.w wVar = (com.bytedance.msdk.api.sr.c.gd.w) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (wVar != null) {
                        wVar.c(1);
                    }
                }
            });
        }
    }

    public final void ux() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.1
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    w.this.xv(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.p.w.1.1
                        @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                        public void c() {
                            com.bytedance.msdk.api.sr.c.gd.w wVar = (com.bytedance.msdk.api.sr.c.gd.w) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                            if (wVar != null) {
                                wVar.r();
                            }
                        }
                    });
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

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void w(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar) {
        c(context, wVar, xvVar);
    }

    public final void w(ViewGroup viewGroup) {
        try {
            this.f27603c = true;
            c(viewGroup);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
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
                cVar2.notifyAdFailed(new com.bytedance.msdk.api.c(49008, com.bytedance.msdk.api.c.c(49008), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }
}
