package io.netty.channel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface MessageSizeEstimator {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Handle {
        int size(Object obj);
    }

    Handle newHandle();
}
