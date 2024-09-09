package io.netty.bootstrap;

import io.netty.channel.Channel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ChannelFactory<T extends Channel> {
    T newChannel();
}
