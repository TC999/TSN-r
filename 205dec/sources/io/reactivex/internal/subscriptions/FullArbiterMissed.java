package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FullArbiter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class FullArbiterMissed extends FullArbiterPad1 {
    final AtomicLong missedRequested = new AtomicLong();
}
