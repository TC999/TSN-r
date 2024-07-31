package com.acse.ottn.util;

/* renamed from: com.acse.ottn.util.L */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1639L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1643N f3255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1639L(C1643N c1643n) {
        this.f3255a = c1643n;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3255a.f3263d.onFinish();
    }
}
