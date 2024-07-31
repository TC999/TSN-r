package io.netty.channel;

import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ChannelId extends Serializable, Comparable<ChannelId> {
    String asLongText();

    String asShortText();
}
