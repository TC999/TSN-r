package com.acse.ottn.util;

import java.util.List;

/* renamed from: com.acse.ottn.util.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1695s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1700u f3359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1695s(C1700u c1700u) {
        this.f3359a = c1700u;
    }

    @Override // java.lang.Runnable
    public void run() {
        CommonUtil.isReadActivityPage = false;
        C1700u c1700u = this.f3359a;
        C1617A c1617a = c1700u.f3377c;
        List<String> list = c1617a.f3119k;
        String package_name = c1700u.f3375a.getPackage_name();
        C1700u c1700u2 = this.f3359a;
        c1617a.m56332a(list, package_name, c1700u2.f3376b, c1700u2.f3377c.f3127s);
    }
}
