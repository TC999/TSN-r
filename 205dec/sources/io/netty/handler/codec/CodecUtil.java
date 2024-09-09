package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerAdapter;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class CodecUtil {
    private CodecUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ensureNotSharable(ChannelHandlerAdapter channelHandlerAdapter) {
        if (channelHandlerAdapter.isSharable()) {
            throw new IllegalStateException("@Sharable annotation is not allowed");
        }
    }
}
