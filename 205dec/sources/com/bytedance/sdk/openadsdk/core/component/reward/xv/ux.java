package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {
    private com.bytedance.sdk.openadsdk.core.widget.r fp;

    public ux(Activity activity, me meVar) {
        super(activity, meVar);
        this.fp = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        return "\u7ee7\u7eed\u89c2\u770b" + this.f32765c + "\u79d2\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u5b9a\u8981\u9000\u51fa\u5417\uff1f";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(final p pVar) {
        final com.bytedance.sdk.openadsdk.core.widget.r rVar = new com.bytedance.sdk.openadsdk.core.widget.r(this.f32778r);
        this.fp = rVar;
        rVar.c(i.xv(this.f32778r, "tt_retain_gift")).c(ux()).xv("\u7ee7\u7eed\u89c2\u770b").sr("\u575a\u6301\u9000\u51fa");
        rVar.c(com.bytedance.sdk.openadsdk.res.ux.t(this.f32778r));
        this.fp.c(new r.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.ux.1
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
        this.fp.c(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.ux.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                rVar.dismiss();
                p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.xv();
                }
            }
        });
        this.fp.show();
        return new w.c(true, 0, "", this.fp);
    }
}
