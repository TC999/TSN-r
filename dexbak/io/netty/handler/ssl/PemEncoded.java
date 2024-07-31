package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
interface PemEncoded extends ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded copy();

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded duplicate();

    boolean isSensitive();

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded touch(Object obj);
}
