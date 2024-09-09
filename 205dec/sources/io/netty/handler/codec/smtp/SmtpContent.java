package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface SmtpContent extends ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent copy();

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent retain(int i4);

    @Override // io.netty.buffer.ByteBufHolder
    SmtpContent retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SmtpContent touch(Object obj);
}
