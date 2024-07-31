package com.acse.ottn.util;

import java.util.List;

/* renamed from: com.acse.ottn.util.t */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1698t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1700u f3371a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1698t(C1700u c1700u) {
        this.f3371a = c1700u;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (CommonUtil.isReadActivityPage || "1".equals(C1661ba.m56097a().m56093a("read_timeout", "0"))) {
            CommonUtil.isReadActivityPage = false;
            C1700u c1700u = this.f3371a;
            C1617A c1617a = c1700u.f3377c;
            List<String> list = c1617a.f3119k;
            String package_name = c1700u.f3375a.getPackage_name();
            C1700u c1700u2 = this.f3371a;
            c1617a.m56332a(list, package_name, c1700u2.f3376b, c1700u2.f3377c.f3127s);
        }
    }
}
