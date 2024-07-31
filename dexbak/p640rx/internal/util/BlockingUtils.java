package p640rx.internal.util;

import java.util.concurrent.CountDownLatch;
import p640rx.Subscription;

/* renamed from: rx.internal.util.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingUtils {
    private BlockingUtils() {
    }

    /* renamed from: a */
    public static void m872a(CountDownLatch countDownLatch, Subscription subscription) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            subscription.unsubscribe();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
        }
    }
}
