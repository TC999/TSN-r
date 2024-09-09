package com.acse.ottn.animator;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f5050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f5050a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5050a.f5051a.f4811f) {
            return;
        }
        this.f5050a.f5051a.a();
    }
}
