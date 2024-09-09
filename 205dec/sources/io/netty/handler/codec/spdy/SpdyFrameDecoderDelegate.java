package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SpdyFrameDecoderDelegate {
    void readDataFrame(int i4, boolean z3, ByteBuf byteBuf);

    void readFrameError(String str);

    void readGoAwayFrame(int i4, int i5);

    void readHeaderBlock(ByteBuf byteBuf);

    void readHeaderBlockEnd();

    void readHeadersFrame(int i4, boolean z3);

    void readPingFrame(int i4);

    void readRstStreamFrame(int i4, int i5);

    void readSetting(int i4, int i5, boolean z3, boolean z4);

    void readSettingsEnd();

    void readSettingsFrame(boolean z3);

    void readSynReplyFrame(int i4, boolean z3);

    void readSynStreamFrame(int i4, int i5, byte b4, boolean z3, boolean z4);

    void readWindowUpdateFrame(int i4, int i5);
}
