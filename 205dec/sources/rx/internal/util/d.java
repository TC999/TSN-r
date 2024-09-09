package rx.internal.util;

import java.util.concurrent.CountDownLatch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BlockingUtils.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d {
    private d() {
    }

    public static void a(CountDownLatch countDownLatch, rx.m mVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e4) {
            mVar.unsubscribe();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e4);
        }
    }
}
