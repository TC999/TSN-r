package com.bytedance.sdk.component.w.c.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends a {
    public sr bk;

    public xv(a.c cVar) {
        super(cVar);
        this.bk = new sr();
    }

    @Override // com.bytedance.sdk.component.w.c.a
    public com.bytedance.sdk.component.w.c.sr c() {
        return this.bk;
    }

    @Override // com.bytedance.sdk.component.w.c.a
    public com.bytedance.sdk.component.w.c.w c(t tVar) {
        tVar.c(this);
        if (tVar.w() == null || tVar.w().c() == null || TextUtils.isEmpty(tVar.w().c().toString())) {
            return null;
        }
        return new c(tVar, this.bk);
    }
}
