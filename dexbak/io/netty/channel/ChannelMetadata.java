package io.netty.channel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z) {
        this(z, 1);
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public ChannelMetadata(boolean z, int i) {
        if (i > 0) {
            this.hasDisconnect = z;
            this.defaultMaxMessagesPerRead = i;
            return;
        }
        throw new IllegalArgumentException("defaultMaxMessagesPerRead: " + i + " (expected > 0)");
    }
}
