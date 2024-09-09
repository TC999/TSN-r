package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ResourceLeak {
    boolean close();

    void record();

    void record(Object obj);
}
