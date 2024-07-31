package io.netty.channel.embedded;

import io.netty.channel.ChannelId;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class EmbeddedChannelId implements ChannelId {
    static final ChannelId INSTANCE = new EmbeddedChannelId();
    private static final long serialVersionUID = -251711922203466130L;

    private EmbeddedChannelId() {
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return toString();
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return toString();
    }

    public boolean equals(Object obj) {
        return obj instanceof EmbeddedChannelId;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "embedded";
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (channelId instanceof EmbeddedChannelId) {
            return 0;
        }
        return asLongText().compareTo(channelId.asLongText());
    }
}
