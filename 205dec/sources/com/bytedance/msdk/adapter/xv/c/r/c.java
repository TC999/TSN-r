package com.bytedance.msdk.adapter.xv.c.r;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.msdk.api.sr.c.w.xv.xv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.api.sr.c.w.p.w {
    private w ev;

    public c(String str) {
        this.ev = new w(str, this);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
        super.c(z3, d4, i4, map);
        w wVar = this.ev;
        if (wVar != null) {
            wVar.c(z3, d4, i4, map);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void sr() {
        super.sr();
        w wVar = this.ev;
        if (wVar != null) {
            wVar.r();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void w() {
        super.w();
        w wVar = this.ev;
        if (wVar != null) {
            wVar.ux();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void xv() {
        super.xv();
        w wVar = this.ev;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.p.w
    public void c(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar) {
        w wVar2 = this.ev;
        if (wVar2 != null) {
            wVar2.c(context, wVar, xvVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.p.w
    public void c(ViewGroup viewGroup) {
        w wVar = this.ev;
        if (wVar != null) {
            wVar.c(viewGroup);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public MediationConstant.AdIsReadyStatus c() {
        w wVar = this.ev;
        if (wVar != null) {
            return wVar.sr();
        }
        return super.c();
    }
}
