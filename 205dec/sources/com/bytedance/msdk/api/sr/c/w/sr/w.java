package com.bytedance.msdk.api.sr.c.w.sr;

import android.content.Context;
import com.bytedance.msdk.api.sr.c.w.xv.xv;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.msdk.api.sr.c.w.w.w {
    private xv ev;

    public abstract void c(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar);

    public final void c(List<? extends c> list) {
        if (list != null) {
            if (!k()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter callLoadSuccess");
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    c cVar = list.get(i4);
                    cVar.c(this);
                    cVar.c(this.f27606w.a());
                    cVar.c(this.f27606w.gd() != 2);
                    arrayList.add(cVar);
                }
                com.bytedance.msdk.adapter.c cVar2 = this.xv;
                if (cVar2 != null) {
                    cVar2.notifyAdLoadedCustom(arrayList);
                    return;
                }
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
        }
    }

    public final boolean f() {
        xv xvVar = this.ev;
        return xvVar != null && xvVar.w() == 1;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void sr() {
    }

    public final boolean ux() {
        xv xvVar = this.ev;
        return xvVar != null && xvVar.w() == 2;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void w() {
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public final void w(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar) {
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
                cVar2.notifyAdFailed(new com.bytedance.msdk.api.c(49015, com.bytedance.msdk.api.c.c(49015), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.w()));
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "\u81ea\u5b9a\u4e49Adapter \u52a0\u8f7d\u6210\u529f\u6216\u8005\u5931\u8d25\u56de\u8c03\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
    }
}
