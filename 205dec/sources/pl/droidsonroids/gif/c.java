package pl.droidsonroids.gif;

/* compiled from: ConditionVariable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f61822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() throws InterruptedException {
        while (!this.f61822a) {
            wait();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.f61822a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        boolean z3 = this.f61822a;
        this.f61822a = true;
        if (!z3) {
            notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(boolean z3) {
        if (z3) {
            c();
        } else {
            b();
        }
    }
}
