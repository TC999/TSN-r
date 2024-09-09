package io.netty.buffer;

import io.netty.util.ReferenceCounted;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ByteBufHolder extends ReferenceCounted {
    ByteBuf content();

    ByteBufHolder copy();

    ByteBufHolder duplicate();

    ByteBufHolder replace(ByteBuf byteBuf);

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain(int i4);

    ByteBufHolder retainedDuplicate();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch(Object obj);
}
