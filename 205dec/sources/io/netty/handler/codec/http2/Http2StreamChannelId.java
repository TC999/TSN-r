package io.netty.handler.codec.http2;

import io.netty.channel.ChannelId;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class Http2StreamChannelId implements ChannelId {
    private static final long serialVersionUID = -6642338822166867585L;
    private final int id;
    private final ChannelId parentId;

    Http2StreamChannelId(ChannelId channelId, int i4) {
        this.parentId = channelId;
        this.id = i4;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return this.parentId.asLongText() + '/' + this.id;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return this.parentId.asShortText() + '/' + this.id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Http2StreamChannelId) {
            Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) obj;
            return this.id == http2StreamChannelId.id && this.parentId.equals(http2StreamChannelId.parentId);
        }
        return false;
    }

    public int hashCode() {
        return (this.id * 31) + this.parentId.hashCode();
    }

    public String toString() {
        return asShortText();
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (channelId instanceof Http2StreamChannelId) {
            Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) channelId;
            int compareTo = this.parentId.compareTo(http2StreamChannelId.parentId);
            return compareTo == 0 ? this.id - http2StreamChannelId.id : compareTo;
        }
        return this.parentId.compareTo(channelId);
    }
}
