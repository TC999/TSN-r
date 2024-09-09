package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c {
    private com.bytedance.sdk.openadsdk.core.widget.r fp;

    public xv(Activity activity, me meVar) {
        super(activity, meVar);
        this.fp = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        return "\u518d\u770b" + this.f32765c + "s\u53ef\u9886\u53d6\u5956\u52b1";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(final p pVar) {
        w.c w3 = super.w(pVar);
        if (w3.xv()) {
            return w3;
        }
        final com.bytedance.sdk.openadsdk.core.widget.r rVar = new com.bytedance.sdk.openadsdk.core.widget.r(this.f32778r);
        this.fp = rVar;
        rVar.c(i.xv(this.f32778r, "tt_retain_gift")).c(ux()).xv("\u7ee7\u7eed\u89c2\u770b").sr("\u575a\u6301\u9000\u51fa");
        this.fp.c(com.bytedance.sdk.openadsdk.res.ux.p(this.f32778r));
        this.fp.c(new r.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.xv.1
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
        this.fp.show();
        return new w.c(true, 0, "", this.fp);
    }
}
