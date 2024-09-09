package com.bytedance.msdk.adapter.xv.c.sr;

import android.content.Context;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.api.sr.c.w.ev.xv {
    private com.bytedance.msdk.adapter.xv.c.c ev;

    public c(String str) {
        this.ev = new w(str, this);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.ev.xv
    public void c(Context context, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.w.xv.xv xvVar) {
        this.ev.c(context, wVar, xvVar);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.w.w
    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
        super.c(z3, d4, i4, map);
        com.bytedance.msdk.adapter.xv.c.c cVar = this.ev;
        if (cVar != null) {
            cVar.c(z3, d4, i4, map);
        }
    }
}
