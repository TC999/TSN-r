package com.acse.ottn.service;

import com.acse.ottn.util.CommonUtil;

/* renamed from: com.acse.ottn.service.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1600j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1612v f3064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1600j(C1612v c1612v) {
        this.f3064a = c1612v;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (CommonUtil.isShowConpunInfor) {
            return;
        }
        C1586Y.m56387a(this.f3064a.f3096a);
    }
}
