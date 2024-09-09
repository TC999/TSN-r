package com.bytedance.sdk.component.w.c.c.c;

import com.bytedance.sdk.component.xv.w.j;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.component.w.c.sr {

    /* renamed from: c  reason: collision with root package name */
    j f30385c;

    public sr(j jVar) {
        this.f30385c = jVar;
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public void c(int i4) {
        this.f30385c.fz().c(i4);
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public void w(int i4) {
        if (i4 < 5) {
            this.f30385c.fz().w(5);
        } else {
            this.f30385c.fz().w(i4);
        }
    }
}
