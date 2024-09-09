package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c4, SelectionKey selectionKey) throws Exception;

    void channelUnregistered(C c4, Throwable th) throws Exception;
}
