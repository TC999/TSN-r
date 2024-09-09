package com.bytedance.msdk.api.sr.c.w.ev;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv extends com.bytedance.msdk.api.sr.c.w.w.w {
    private com.bytedance.msdk.api.sr.c.w.xv.xv ev;

    public abstract void c(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar);

    public final void c(List<? extends w> list) {
        if (list != null) {
            if (!k()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter callLoadSuccess");
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    w wVar = list.get(i4);
                    wVar.c(this);
                    wVar.c(this.f27606w.a());
                    wVar.c(this.f27606w.gd() != 2);
                    arrayList.add(wVar);
                }
                com.bytedance.msdk.adapter.c cVar = this.xv;
                if (cVar != null) {
                    cVar.notifyAdLoadedCustom(arrayList);
                    return;
                }
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
        }
    }

    public final boolean f() {
        com.bytedance.msdk.api.sr.c.w.xv.xv xvVar = this.ev;
        return xvVar != null && xvVar.w() == 1;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void sr() {
    }

    public final boolean ux() {
        com.bytedance.msdk.api.sr.c.w.xv.xv xvVar = this.ev;
        return xvVar != null && xvVar.w() == 2;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void w() {
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void w(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar) {
        this.ev = xvVar;
        c(context, wVar, xvVar);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void xv() {
    }

    public final void c(com.bytedance.msdk.api.sr.c.w.c cVar) {
        if (!a()) {
            com.bytedance.msdk.adapter.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.notifyAdFailed(new com.bytedance.msdk.api.c(49010, com.bytedance.msdk.api.c.c(49010), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }
}
