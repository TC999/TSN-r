package pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class ConditionVariable {

    /* renamed from: a */
    private volatile boolean f44409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m2475a() throws InterruptedException {
        while (!this.f44409a) {
            wait();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void m2474b() {
        this.f44409a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void m2473c() {
        boolean z = this.f44409a;
        this.f44409a = true;
        if (!z) {
            notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void m2472d(boolean z) {
        if (z) {
            m2473c();
        } else {
            m2474b();
        }
    }
}
