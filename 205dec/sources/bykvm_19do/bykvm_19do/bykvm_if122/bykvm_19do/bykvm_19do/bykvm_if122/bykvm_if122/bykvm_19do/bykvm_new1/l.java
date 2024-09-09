package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.concurrent.CountDownLatch;

/* compiled from: Ping.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f1192a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f1193b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f1194c = -1;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f1194c == -1) {
            long j4 = this.f1193b;
            if (j4 != -1) {
                this.f1194c = j4 - 1;
                this.f1192a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1194c == -1 && this.f1193b != -1) {
            this.f1194c = System.nanoTime();
            this.f1192a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f1193b == -1) {
            this.f1193b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
