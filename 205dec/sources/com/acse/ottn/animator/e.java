package com.acse.ottn.animator;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f5045a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5045a.f5046a.f4798f) {
            return;
        }
        this.f5045a.f5046a.a();
    }
}
