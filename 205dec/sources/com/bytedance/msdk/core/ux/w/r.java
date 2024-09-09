package com.bytedance.msdk.core.ux.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.yu;
import java.util.HashSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends ux {

    /* renamed from: w  reason: collision with root package name */
    private final HashSet<String> f28226w;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(Context context, String str, int i4) {
        super(context, str, i4);
        this.f28226w = new HashSet<>();
    }

    private p p() {
        for (p pVar : ((ux) this).f28229c) {
            if (pVar != null) {
                if (!this.f28226w.contains(pVar.ia())) {
                    return pVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
    }

    @Override // com.bytedance.msdk.core.r.f, com.bytedance.msdk.core.r.ux, com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        p p3;
        super.c(cVar, xvVar);
        if (xvVar != null && !TextUtils.isEmpty(xvVar.bk())) {
            this.f28226w.add(xvVar.bk());
        }
        com.bytedance.msdk.c.ux uxVar = null;
        List<com.bytedance.msdk.c.ux> list = this.f28160s;
        if (list != null && list.size() > 0) {
            uxVar = this.f28160s.get(0);
        }
        if (uxVar == null || (p3 = p()) == null || !TextUtils.equals(p3.ia(), uxVar.getAdNetworkSlotId())) {
            return;
        }
        ev();
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
    }

    @Override // com.bytedance.msdk.core.r.f, com.bytedance.msdk.core.r.ux, com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        super.c(list, xvVar);
        p p3 = p();
        if (p3 == null || yu.w(list) || !TextUtils.equals(p3.ia(), list.get(0).getAdNetworkSlotId())) {
            return;
        }
        ev();
    }
}
