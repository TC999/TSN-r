package io.netty.channel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z3) {
        this(z3, 1);
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public ChannelMetadata(boolean z3, int i4) {
        if (i4 > 0) {
            this.hasDisconnect = z3;
            this.defaultMaxMessagesPerRead = i4;
            return;
        }
        throw new IllegalArgumentException("defaultMaxMessagesPerRead: " + i4 + " (expected > 0)");
    }
}
