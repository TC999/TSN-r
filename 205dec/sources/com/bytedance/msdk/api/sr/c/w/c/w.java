package com.bytedance.msdk.api.sr.c.w.c;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.w.w.w;
import com.bytedance.msdk.api.sr.c.w.xv.xv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.msdk.api.sr.c.w.w.w {
    public abstract void c(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar);

    public final void ev() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.c.w.2
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    w.this.xv(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.c.w.2.1
                        @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                        public void c() {
                            com.bytedance.msdk.api.sr.c.c.c cVar = (com.bytedance.msdk.api.sr.c.c.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                            if (cVar != null) {
                                cVar.j_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final View f() {
        try {
            return ux();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void gd() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.c.w.3
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.c.c cVar = (com.bytedance.msdk.api.sr.c.c.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.i_();
                    }
                }
            });
        }
    }

    public final void r() {
        if (this.sr != null) {
            c(new w.c() { // from class: com.bytedance.msdk.api.sr.c.w.c.w.1
                @Override // com.bytedance.msdk.api.sr.c.w.w.w.c
                public void c() {
                    com.bytedance.msdk.api.sr.c.c.c cVar = (com.bytedance.msdk.api.sr.c.c.c) ((com.bytedance.msdk.api.sr.c.w.w.w) w.this).sr.k();
                    if (cVar != null) {
                        cVar.k_();
                    }
                }
            });
        }
    }

    @Nullable
    public abstract View ux();

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

    public final void c(com.bytedance.msdk.api.sr.c.w.c cVar) {
        if (!a()) {
            com.bytedance.msdk.adapter.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.notifyAdFailed(new com.bytedance.msdk.api.c(49000, com.bytedance.msdk.api.c.c(49000), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }

    public final void c(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.f27605r = hashMap;
            hashMap.putAll(map);
        }
    }
}
