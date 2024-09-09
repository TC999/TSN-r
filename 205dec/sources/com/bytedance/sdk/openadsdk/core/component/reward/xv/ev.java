package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.widget.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends c {
    private com.bytedance.sdk.openadsdk.core.widget.r fp;
    private String ia;

    public ev(Activity activity, me meVar) {
        super(activity, meVar);
        this.fp = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        return this.ia;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(final p pVar) {
        final com.bytedance.sdk.openadsdk.core.widget.r rVar = new com.bytedance.sdk.openadsdk.core.widget.r(this.f32778r);
        this.fp = rVar;
        c(rVar, this.sr);
        this.fp.c(new r.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.ev.1
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

    private void c(com.bytedance.sdk.openadsdk.core.widget.r rVar, boolean z3) {
        if (u.xv(this.f32775f)) {
            int ms2 = this.f32775f.ms();
            int u3 = wx.u(this.f32775f);
            if (ms2 == 0) {
                if (u3 != 1 && !z3) {
                    this.ia = this.xv ? "\u8bd5\u73a9\u65f6\u957f\u8fbe\u6807\u624d\u80fd\u9886\u53d6\u5956\u52b1" : "\u8bd5\u73a9\u540e\u624d\u80fd\u9886\u53d6\u5956\u52b1";
                } else {
                    this.ia = "\u8bd5\u73a9\u65f6\u957f\u8fbe\u6807\u624d\u80fd\u9886\u53d6\u5956\u52b1";
                }
                rVar.c(i.xv(this.f32778r, "tt_retain_gift")).c(ux()).xv("\u7ee7\u7eed\u8bd5\u73a9").sr("\u575a\u6301\u9000\u51fa");
                rVar.c(com.bytedance.sdk.openadsdk.res.ux.p(this.f32778r));
            } else if (ms2 != 1) {
                if (ms2 != 3) {
                    return;
                }
                this.ia = "\u786e\u5b9a\u9000\u51fa\u5417?";
                Activity activity = this.f32778r;
                if (activity != null) {
                    Intent intent = activity.getIntent();
                    this.ia = String.format("\u518d\u770b%s\u79d2\u53ef\u5f97\u5956\u52b1", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                c(rVar, ux(), "\u7ee7\u7eed\u89c2\u770b", "\u575a\u6301\u9000\u51fa");
                rVar.c(Color.parseColor("#FC1D56"));
            } else {
                boolean xv = fp.xv(this.f32775f);
                if (u3 != 0 || xv) {
                    this.ia = String.format("\u518d\u770b%s\u79d2\u53ef\u5f97\u5956\u52b1", Integer.valueOf(this.f32765c));
                } else {
                    this.ia = "\u672a\u6ee1\u8db3\u5956\u52b1\u8981\u6c42\uff0c\u9700\u8981\u7ee7\u7eed\u6d4f\u89c8";
                }
                if (xv) {
                    rVar.w("\u786e\u5b9a\u9000\u51fa\u5417?");
                    c(rVar, ux(), "\u7ee7\u7eed\u89c2\u770b", "\u575a\u6301\u9000\u51fa");
                    return;
                }
                rVar.c(i.xv(this.f32778r, "tt_reward_coin")).c(Color.parseColor("#FC1D56")).c(ux()).xv("\u7ee7\u7eed\u89c2\u770b").sr("\u575a\u6301\u9000\u51fa");
                rVar.c(com.bytedance.sdk.openadsdk.res.ux.p(this.f32778r));
            }
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.widget.r rVar, String str, String str2, String str3) {
        rVar.c(i.xv(this.f32778r, "tt_reward_browse_multi_icon")).c(str).xv(str2).sr(str3);
        rVar.c(com.bytedance.sdk.openadsdk.res.ux.xk(this.f32778r));
    }
}
