package com.acse.ottn.util;

/* renamed from: com.acse.ottn.util.O */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1645O implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1647Q f3269a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1645O(C1647Q c1647q) {
        this.f3269a = c1647q;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3269a.f3274d.onFinish();
    }
}
