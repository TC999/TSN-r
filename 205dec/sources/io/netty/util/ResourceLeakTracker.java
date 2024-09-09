package io.netty.util;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ResourceLeakTracker<T> {
    boolean close(T t3);

    void record();

    void record(Object obj);
}
