package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressivePromise;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ChannelProgressivePromise extends ProgressivePromise<Void>, ChannelProgressiveFuture, ChannelPromise {
    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> await() throws InterruptedException;

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ChannelProgressivePromise setFailure(Throwable th);

    @Override // io.netty.util.concurrent.ProgressivePromise
    ProgressivePromise<Void> setProgress(long j4, long j5);

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise setSuccess(Void r12);

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.ProgressivePromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    Future<Void> syncUninterruptibly();

    @Override // io.netty.channel.ChannelPromise
    ChannelProgressivePromise unvoid();
}
