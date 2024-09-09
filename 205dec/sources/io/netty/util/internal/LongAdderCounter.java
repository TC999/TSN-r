package io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class LongAdderCounter extends LongAdder implements LongCounter {
    @Override // io.netty.util.internal.LongCounter
    public long value() {
        return longValue();
    }
}
