package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.w.c.w.p;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.sdk.openadsdk.core.w.c.c {

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.sr f35315f;
    com.bytedance.sdk.openadsdk.core.w.c.c.ux ux = new com.bytedance.sdk.openadsdk.core.w.c.c.ux();

    public gd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.w.sr srVar = this.f35315f;
        if (srVar == null || ((com.bytedance.sdk.openadsdk.core.w.c.c.w) srVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(map)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f35315f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.f35315f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.w.sr srVar = this.f35315f;
        if (srVar != null) {
            final com.bytedance.sdk.openadsdk.core.w.c.c.ux w3 = ((com.bytedance.sdk.openadsdk.core.w.c.c.w) srVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w();
            final w.c c4 = w3.c();
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.gd.2
                @Override // java.lang.Runnable
                public void run() {
                    w.c cVar = c4;
                    if (cVar != null) {
                        cVar.c(((com.bytedance.sdk.openadsdk.core.w.c.c) gd.this).sr, w3.sr());
                    }
                }
            });
            if (((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.f35315f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.f35315f.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
        }
    }

    public gd(me meVar, Context context, com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        this.f35315f = srVar;
        this.f35278c = meVar;
        this.f35279w = context;
    }

    public void c(int i4) {
        this.ux.w(i4);
    }

    public void c(boolean z3) {
        this.ux.w(z3);
    }

    public void c(String str) {
        this.ux.c(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(final Map<String, Object> map) {
        p.c(true);
        return new p(this.f35278c, this.f35279w).c(this.ux.k()).c(this.ux.gd()).w(this.ux.xv()).c(new p.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.gd.1
            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
            public void c() {
                gd.this.w(map);
            }

            @Override // com.bytedance.sdk.openadsdk.core.w.c.w.p.c
            public void w() {
                gd.this.xv(map);
            }
        });
    }
}
