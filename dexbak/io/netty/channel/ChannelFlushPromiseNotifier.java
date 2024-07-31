package io.netty.channel;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ChannelFlushPromiseNotifier {
    private final Queue<FlushCheckpoint> flushCheckpoints;
    private final boolean tryNotify;
    private long writeCounter;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        DefaultFlushCheckpoint(long j, ChannelPromise channelPromise) {
            this.checkpoint = j;
            this.future = channelPromise;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }

        @Override // io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public void flushCheckpoint(long j) {
            this.checkpoint = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long j);

        ChannelPromise promise();
    }

    public ChannelFlushPromiseNotifier(boolean z) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = z;
    }

    private void notifyPromises0(Throwable th) {
        if (this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0L;
            return;
        }
        long j = this.writeCounter;
        while (true) {
            FlushCheckpoint peek = this.flushCheckpoints.peek();
            if (peek == null) {
                this.writeCounter = 0L;
                break;
            } else if (peek.flushCheckpoint() > j) {
                if (j > 0 && this.flushCheckpoints.size() == 1) {
                    this.writeCounter = 0L;
                    peek.flushCheckpoint(peek.flushCheckpoint() - j);
                }
            } else {
                this.flushCheckpoints.remove();
                ChannelPromise promise = peek.promise();
                if (th == null) {
                    if (this.tryNotify) {
                        promise.trySuccess();
                    } else {
                        promise.setSuccess();
                    }
                } else if (this.tryNotify) {
                    promise.tryFailure(th);
                } else {
                    promise.setFailure(th);
                }
            }
        }
        long j2 = this.writeCounter;
        if (j2 >= 549755813888L) {
            this.writeCounter = 0L;
            for (FlushCheckpoint flushCheckpoint : this.flushCheckpoints) {
                flushCheckpoint.flushCheckpoint(flushCheckpoint.flushCheckpoint() - j2);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, int i) {
        return add(channelPromise, i);
    }

    public ChannelFlushPromiseNotifier increaseWriteCounter(long j) {
        if (j >= 0) {
            this.writeCounter += j;
            return this;
        }
        throw new IllegalArgumentException("delta must be >= 0 but was " + j);
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures() {
        return notifyPromises();
    }

    public ChannelFlushPromiseNotifier notifyPromises() {
        notifyPromises0(null);
        return this;
    }

    public long writeCounter() {
        return this.writeCounter;
    }

    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise, long j) {
        if (channelPromise != null) {
            if (j >= 0) {
                long j2 = this.writeCounter + j;
                if (channelPromise instanceof FlushCheckpoint) {
                    FlushCheckpoint flushCheckpoint = (FlushCheckpoint) channelPromise;
                    flushCheckpoint.flushCheckpoint(j2);
                    this.flushCheckpoints.add(flushCheckpoint);
                } else {
                    this.flushCheckpoints.add(new DefaultFlushCheckpoint(j2, channelPromise));
                }
                return this;
            }
            throw new IllegalArgumentException("pendingDataSize must be >= 0 but was " + j);
        }
        throw new NullPointerException("promise");
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th) {
        return notifyPromises(th);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th) {
        notifyPromises();
        while (true) {
            FlushCheckpoint poll = this.flushCheckpoints.poll();
            if (poll == null) {
                return this;
            }
            if (this.tryNotify) {
                poll.promise().tryFailure(th);
            } else {
                poll.promise().setFailure(th);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable th, Throwable th2) {
        return notifyPromises(th, th2);
    }

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable th, Throwable th2) {
        notifyPromises0(th);
        while (true) {
            FlushCheckpoint poll = this.flushCheckpoints.poll();
            if (poll == null) {
                return this;
            }
            if (this.tryNotify) {
                poll.promise().tryFailure(th2);
            } else {
                poll.promise().setFailure(th2);
            }
        }
    }
}
