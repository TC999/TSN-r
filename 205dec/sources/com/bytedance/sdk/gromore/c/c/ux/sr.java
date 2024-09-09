package com.bytedance.sdk.gromore.c.c.ux;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.msdk.core.admanager.p;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private p f31208c;
    private w sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31209w;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.r xv;

    public sr(Activity activity, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.r rVar) {
        this.f31209w = cVar;
        if (cVar != null) {
            this.f31208c = new p(activity, cVar.f());
            this.xv = rVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        HashMap hashMap = new HashMap();
        String ys = this.f31209w.ys();
        if (!TextUtils.isEmpty(ys)) {
            hashMap.put("gdt", ys);
        }
        this.f31208c.c(new com.bytedance.msdk.api.c.w(7, this.f31209w.w()), new com.bytedance.msdk.api.sr.c.ev.w() { // from class: com.bytedance.sdk.gromore.c.c.ux.sr.1
            @Override // com.bytedance.msdk.api.sr.c.ev.w
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || sr.this.xv == null) {
                    return;
                }
                sr.this.xv.onError(cVar.f27444c, cVar.f27445w);
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.w
            public void w() {
                if (sr.this.xv != null) {
                    sr.this.xv.onRewardVideoCached();
                    if (sr.this.sr == null) {
                        sr srVar = sr.this;
                        srVar.sr = new w(srVar.f31208c);
                    }
                    sr.this.xv.onRewardVideoCached(sr.this.sr);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.w
            public void c() {
                if (sr.this.xv != null) {
                    if (sr.this.sr == null) {
                        sr srVar = sr.this;
                        srVar.sr = new w(srVar.f31208c);
                    }
                    sr.this.xv.onRewardVideoAdLoad(sr.this.sr);
                }
            }
        });
    }
}
