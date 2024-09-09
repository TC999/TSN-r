package com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;

import android.app.Activity;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.yu;
import com.bytedance.sdk.openadsdk.core.widget.r;
import com.bytedance.sdk.openadsdk.res.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {

    /* renamed from: w  reason: collision with root package name */
    private r f32245w;

    public w(Activity activity, me meVar) {
        super(activity, meVar);
        this.f32245w = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c c(final p pVar) {
        w.c c4 = super.c(pVar);
        if (c4.xv()) {
            return c4;
        }
        final r rVar = new r(this.f32778r);
        this.f32245w = rVar;
        rVar.c(i.xv(this.f32778r, "tt_retain_gift")).c(c()).xv(yu.c(this.f32775f, this.f32777p, this.f32776k)).sr("\u575a\u6301\u9000\u51fa");
        rVar.c(ux.p(this.f32778r));
        this.f32245w.c(new r.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.w.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.r.c
            public void c() {
                rVar.dismiss();
                p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.r.c
            public void w() {
                rVar.dismiss();
                p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.w();
                }
            }
        });
        this.f32245w.show();
        return new w.c(true, 0, "", this.f32245w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        return "\u606d\u559c\u60a8\u5df2\u7ecf\u83b7\u5f97\u5956\u52b1\uff0c\u662f\u5426\u8981\u7ee7\u7eed\u89c2\u770b\u89c6\u9891\uff0c\u518d\u5f97\u8d85\u503c\u5956\u52b1";
    }
}
