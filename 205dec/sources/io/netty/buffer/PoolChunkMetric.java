package io.netty.buffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface PoolChunkMetric {
    int chunkSize();

    int freeBytes();

    int usage();
}