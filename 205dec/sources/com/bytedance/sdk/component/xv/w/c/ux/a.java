package com.bytedance.sdk.component.xv.w.c.ux;

import java.util.concurrent.CountDownLatch;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class a {

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f30816c = new CountDownLatch(1);

    /* renamed from: w  reason: collision with root package name */
    private long f30817w = -1;
    private long xv = -1;

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f30817w == -1) {
            this.f30817w = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        if (this.xv == -1 && this.f30817w != -1) {
            this.xv = System.nanoTime();
            this.f30816c.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv() {
        if (this.xv == -1) {
            long j4 = this.f30817w;
            if (j4 != -1) {
                this.xv = j4 - 1;
                this.f30816c.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
