package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1449u f6868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C1449u c1449u) {
        this.f6868a = c1449u;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1449u c1449u = this.f6868a;
        A a4 = c1449u.f6887c;
        a4.a(a4.f6692k, c1449u.f6885a.getPackage_name(), this.f6868a.f6886b, "");
    }
}
