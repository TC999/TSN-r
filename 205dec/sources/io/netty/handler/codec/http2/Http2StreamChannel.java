package io.netty.handler.codec.http2;

import io.netty.channel.Channel;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface Http2StreamChannel extends Channel {
    Http2FrameStream stream();
}
