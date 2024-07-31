package io.netty.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ResourceLeak {
    boolean close();

    void record();

    void record(Object obj);
}
