package io.netty.util.concurrent;

import io.netty.util.concurrent.ProgressiveFuture;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>> extends GenericFutureListener<F> {
    void operationProgressed(F f, long j, long j2) throws Exception;
}
