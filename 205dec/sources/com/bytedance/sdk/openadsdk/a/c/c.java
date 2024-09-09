package com.bytedance.sdk.openadsdk.a.c;

import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.ux.r;
import com.bytedance.sdk.openadsdk.core.q.c.c;
import com.bytedance.sdk.openadsdk.core.u.bj;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.core.q.c.c {

    /* renamed from: c  reason: collision with root package name */
    private bj f31361c;

    private void c(k kVar) {
        r p3 = kVar.p();
        if (p3 == null || !sr()) {
            return;
        }
        c(p3.c(), p3.w());
    }

    private boolean sr() {
        bj bjVar = this.f31361c;
        return bjVar != null && bjVar.q();
    }

    private void ux() {
        if (sr()) {
            long currentTimeMillis = System.currentTimeMillis();
            bj bjVar = this.f31361c;
            bjVar.ev(currentTimeMillis - bjVar.fz());
            this.f31361c.bk(currentTimeMillis);
        }
    }

    public bj xv() {
        return this.f31361c;
    }

    private void c(long j4, long j5) {
        this.f31361c.t(j5);
        bj bjVar = this.f31361c;
        bjVar.gd(j5 - bjVar.i());
        this.f31361c.fz(j5 - j4);
    }

    public void c(bj bjVar) {
        this.f31361c = bjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.q.c.c
    public void c(k kVar, c.w wVar) {
        c(kVar);
        super.c(kVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.c.c
    protected void c() {
        ux();
    }
}
