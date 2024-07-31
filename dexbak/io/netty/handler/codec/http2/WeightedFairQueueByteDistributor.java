package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.Queue;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class WeightedFairQueueByteDistributor implements StreamByteDistributor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int allocationQuantum = 1024;
    private final State connectionState;
    private final Http2Connection.PropertyKey stateKey;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class State implements PriorityQueueNode<State> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean active;
        int activeCountForTree;
        private int priorityQueueIndex;
        long pseudoTime;
        long pseudoTimeToWrite;
        private final Queue<State> queue;
        final Http2Stream stream;
        int streamableBytes;
        long totalQueuedWeights;

        State(WeightedFairQueueByteDistributor weightedFairQueueByteDistributor, Http2Stream http2Stream) {
            this(http2Stream, 0);
        }

        void close() {
            updateStreamableBytes(0, false);
        }

        void isActiveCountChangeForTree(int i) {
            this.activeCountForTree += i;
            if (this.stream.isRoot()) {
                return;
            }
            State state = WeightedFairQueueByteDistributor.this.state(this.stream.parent());
            int i2 = this.activeCountForTree;
            if (i2 == 0) {
                state.remove(this);
            } else if (i2 - i == 0) {
                state.offerAndInitializePseudoTime(this);
            }
            state.isActiveCountChangeForTree(i);
        }

        void offer(State state) {
            this.queue.offer(state);
            this.totalQueuedWeights += state.stream.weight();
        }

        void offerAndInitializePseudoTime(State state) {
            state.pseudoTimeToWrite = this.pseudoTime;
            offer(state);
        }

        State peek() {
            return this.queue.peek();
        }

        State poll() {
            State poll = this.queue.poll();
            this.totalQueuedWeights -= poll.stream.weight();
            return poll;
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public int priorityQueueIndex() {
            return this.priorityQueueIndex;
        }

        void remove(State state) {
            if (this.queue.remove(state)) {
                this.totalQueuedWeights -= state.stream.weight();
            }
        }

        void updatePseudoTime(State state, int i, long j) {
            this.pseudoTimeToWrite = Math.min(this.pseudoTimeToWrite, state.pseudoTime) + ((i * j) / this.stream.weight());
        }

        void updateStreamableBytes(int i, boolean z) {
            if (this.active != z) {
                isActiveCountChangeForTree(z ? 1 : -1);
                this.active = z;
            }
            this.streamableBytes = i;
        }

        void write(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
            try {
                writer.write(this.stream, i);
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "byte distribution write error", new Object[0]);
            }
        }

        State(Http2Stream http2Stream, int i) {
            this.priorityQueueIndex = -1;
            this.stream = http2Stream;
            this.queue = new PriorityQueue(i);
        }

        @Override // java.lang.Comparable
        public int compareTo(State state) {
            return MathUtil.compare(this.pseudoTimeToWrite, state.pseudoTimeToWrite);
        }

        @Override // io.netty.util.internal.PriorityQueueNode
        public void priorityQueueIndex(int i) {
            this.priorityQueueIndex = i;
        }
    }

    public WeightedFairQueueByteDistributor(Http2Connection http2Connection) {
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        Http2Stream connectionStream = http2Connection.connectionStream();
        State state = new State(connectionStream, 16);
        this.connectionState = state;
        connectionStream.setProperty(newKey, state);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onPriorityTreeParentChanged(Http2Stream http2Stream, Http2Stream http2Stream2) {
                Http2Stream parent = http2Stream.parent();
                if (parent != null) {
                    State state2 = WeightedFairQueueByteDistributor.this.state(http2Stream);
                    if (state2.activeCountForTree != 0) {
                        State state3 = WeightedFairQueueByteDistributor.this.state(parent);
                        state3.offerAndInitializePseudoTime(state2);
                        state3.isActiveCountChangeForTree(state2.activeCountForTree);
                    }
                }
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onPriorityTreeParentChanging(Http2Stream http2Stream, Http2Stream http2Stream2) {
                Http2Stream parent = http2Stream.parent();
                if (parent != null) {
                    State state2 = WeightedFairQueueByteDistributor.this.state(http2Stream);
                    if (state2.activeCountForTree != 0) {
                        State state3 = WeightedFairQueueByteDistributor.this.state(parent);
                        state3.remove(state2);
                        state3.isActiveCountChangeForTree(-state2.activeCountForTree);
                    }
                }
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(WeightedFairQueueByteDistributor.this.stateKey, new State(WeightedFairQueueByteDistributor.this, http2Stream));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                WeightedFairQueueByteDistributor.this.state(http2Stream).close();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onWeightChanged(Http2Stream http2Stream, short s) {
                Http2Stream parent;
                if (WeightedFairQueueByteDistributor.this.state(http2Stream).activeCountForTree == 0 || (parent = http2Stream.parent()) == null) {
                    return;
                }
                WeightedFairQueueByteDistributor.this.state(parent).totalQueuedWeights += http2Stream.weight() - s;
            }
        });
    }

    private int distributeToChildren(int i, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        long j = state.totalQueuedWeights;
        State poll = state.poll();
        State peek = state.peek();
        if (peek != null) {
            try {
                i = Math.min(i, (int) Math.min((((peek.pseudoTimeToWrite - poll.pseudoTimeToWrite) * poll.stream.weight()) / j) + this.allocationQuantum, 2147483647L));
            } finally {
                if (poll.activeCountForTree != 0) {
                    state.offer(poll);
                }
            }
        }
        int distribute = distribute(i, writer, poll);
        state.pseudoTime += distribute;
        poll.updatePseudoTime(state, distribute, j);
        return distribute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) http2Stream.getProperty(this.stateKey);
    }

    public void allocationQuantum(int i) {
        if (i > 0) {
            this.allocationQuantum = i;
            return;
        }
        throw new IllegalArgumentException("allocationQuantum must be > 0");
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public boolean distribute(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
        int i2;
        ObjectUtil.checkNotNull(writer, "writer");
        if (this.connectionState.activeCountForTree == 0) {
            return false;
        }
        while (true) {
            State state = this.connectionState;
            int i3 = state.activeCountForTree;
            i -= distributeToChildren(i, writer, state);
            i2 = this.connectionState.activeCountForTree;
            if (i2 == 0 || (i <= 0 && i3 == i2)) {
                break;
            }
        }
        return i2 != 0;
    }

    int streamableBytes0(Http2Stream http2Stream) {
        return state(http2Stream).streamableBytes;
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame() && streamState.windowSize() >= 0);
    }

    private int distribute(int i, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        if (state.active) {
            int min = Math.min(i, state.streamableBytes);
            state.write(min, writer);
            if (min == 0 && i != 0) {
                state.updateStreamableBytes(state.streamableBytes, false);
            }
            return min;
        }
        return distributeToChildren(i, writer, state);
    }
}
