package io.netty.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Timeout {
    boolean cancel();

    boolean isCancelled();

    boolean isExpired();

    TimerTask task();

    Timer timer();
}
