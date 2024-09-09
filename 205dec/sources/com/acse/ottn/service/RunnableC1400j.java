package com.acse.ottn.service;

import com.acse.ottn.util.CommonUtil;

/* renamed from: com.acse.ottn.service.j  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1400j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1411v f6555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1400j(C1411v c1411v) {
        this.f6555a = c1411v;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (CommonUtil.isShowConpunInfor) {
            return;
        }
        Y.a(this.f6555a.f6587a);
    }
}
