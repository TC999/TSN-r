package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface Http2SettingsFrame extends Http2Frame {
    @Override // io.netty.handler.codec.http2.Http2Frame
    String name();

    Http2Settings settings();
}
