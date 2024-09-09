package com.acse.ottn.util;

import java.util.List;

/* renamed from: com.acse.ottn.util.s  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1447s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1449u f6869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1447s(C1449u c1449u) {
        this.f6869a = c1449u;
    }

    @Override // java.lang.Runnable
    public void run() {
        CommonUtil.isReadActivityPage = false;
        C1449u c1449u = this.f6869a;
        A a4 = c1449u.f6887c;
        List<String> list = a4.f6692k;
        String package_name = c1449u.f6885a.getPackage_name();
        C1449u c1449u2 = this.f6869a;
        a4.a(list, package_name, c1449u2.f6886b, c1449u2.f6887c.f6700s);
    }
}
