package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.concurrent.CountDownLatch;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class Ping {

    /* renamed from: a */
    private final CountDownLatch f1199a = new CountDownLatch(1);

    /* renamed from: b */
    private long f1200b = -1;

    /* renamed from: c */
    private long f1201c = -1;

    Ping() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58529a() {
        if (this.f1201c == -1) {
            long j = this.f1200b;
            if (j != -1) {
                this.f1201c = j - 1;
                this.f1199a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58528b() {
        if (this.f1201c == -1 && this.f1200b != -1) {
            this.f1201c = System.nanoTime();
            this.f1199a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m58527c() {
        if (this.f1200b == -1) {
            this.f1200b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
