package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface StompFrame extends StompHeadersSubframe, LastStompContentSubframe {
    StompFrame copy();

    StompFrame duplicate();

    StompFrame replace(ByteBuf byteBuf);

    StompFrame retain();

    StompFrame retain(int i4);

    StompFrame retainedDuplicate();

    StompFrame touch();

    StompFrame touch(Object obj);
}
