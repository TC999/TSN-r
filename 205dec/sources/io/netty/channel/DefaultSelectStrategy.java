package io.netty.channel;

import io.netty.util.IntSupplier;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    private DefaultSelectStrategy() {
    }

    @Override // io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier intSupplier, boolean z3) throws Exception {
        if (z3) {
            return intSupplier.get();
        }
        return -1;
    }
}
