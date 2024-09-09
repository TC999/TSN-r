package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class WeightedFairQueueByteDistributor implements StreamByteDistributor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int allocationQuantum = 1024;
    private final State connectionState;
    private final Http2Connection.PropertyKey stateKey;

    /* renamed from: io.netty.handler.codec.http2.WeightedFairQueueByteDistributor$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class ParentChangedEvent {
        final State oldParent;
        final State state;

        ParentChangedEvent(State state, State state2) {
            this.state = state;
            this.oldParent = state2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

        void isActiveCountChangeForTree(int i4) {
            this.activeCountForTree += i4;
            if (this.stream.isRoot()) {
                return;
            }
            State state = WeightedFairQueueByteDistributor.this.state(this.stream.parent());
            int i5 = this.activeCountForTree;
            if (i5 == 0) {
                state.remove(this);
            } else if (i5 - i4 == 0) {
                state.offerAndInitializePseudoTime(this);
            }
            state.isActiveCountChangeForTree(i4);
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

        public int priorityQueueIndex() {
            return this.priorityQueueIndex;
        }

        void remove(State state) {
            if (this.queue.remove(state)) {
                this.totalQueuedWeights -= state.stream.weight();
            }
        }

        void updatePseudoTime(State state, int i4, long j4) {
            this.pseudoTimeToWrite = Math.min(this.pseudoTimeToWrite, state.pseudoTime) + ((i4 * j4) / this.stream.weight());
        }

        void updateStreamableBytes(int i4, boolean z3) {
            if (this.active != z3) {
                isActiveCountChangeForTree(z3 ? 1 : -1);
                this.active = z3;
            }
            this.streamableBytes = i4;
        }

        void write(int i4, StreamByteDistributor.Writer writer) throws Http2Exception {
            try {
                writer.write(this.stream, i4);
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "byte distribution write error", new Object[0]);
            }
        }

        State(Http2Stream http2Stream, int i4) {
            this.priorityQueueIndex = -1;
            this.stream = http2Stream;
            this.queue = new PriorityQueue(i4);
        }

        public int compareTo(State state) {
            return MathUtil.compare(this.pseudoTimeToWrite, state.pseudoTimeToWrite);
        }

        public void priorityQueueIndex(int i4) {
            this.priorityQueueIndex = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class StateOnlyComparator implements Comparator<State>, Serializable {
        static final StateOnlyComparator INSTANCE = new StateOnlyComparator();
        private static final long serialVersionUID = -4806936913002105966L;

        private StateOnlyComparator() {
        }

        @Override // java.util.Comparator
        public int compare(State state, State state2) {
            boolean wasStreamReservedOrActivated = state.wasStreamReservedOrActivated();
            if (wasStreamReservedOrActivated != state2.wasStreamReservedOrActivated()) {
                return wasStreamReservedOrActivated ? -1 : 1;
            }
            int i4 = state2.dependencyTreeDepth - state.dependencyTreeDepth;
            return i4 != 0 ? i4 : state.streamId - state2.streamId;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class StatePseudoTimeComparator implements Comparator<State>, Serializable {
        static final StatePseudoTimeComparator INSTANCE = new StatePseudoTimeComparator();
        private static final long serialVersionUID = -1437548640227161828L;

        private StatePseudoTimeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(State state, State state2) {
            return MathUtil.compare(state.pseudoTimeToWrite, state2.pseudoTimeToWrite);
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
            public void onWeightChanged(Http2Stream http2Stream, short s3) {
                Http2Stream parent;
                if (WeightedFairQueueByteDistributor.this.state(http2Stream).activeCountForTree == 0 || (parent = http2Stream.parent()) == null) {
                    return;
                }
                WeightedFairQueueByteDistributor.this.state(parent).totalQueuedWeights += http2Stream.weight() - s3;
            }
        });
    }

    private int distributeToChildren(int i4, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        long j4 = state.totalQueuedWeights;
        State poll = state.poll();
        State peek = state.peek();
        if (peek != null) {
            try {
                i4 = Math.min(i4, (int) Math.min((((peek.pseudoTimeToWrite - poll.pseudoTimeToWrite) * poll.stream.weight()) / j4) + this.allocationQuantum, 2147483647L));
            } finally {
                if (poll.activeCountForTree != 0) {
                    state.offer(poll);
                }
            }
        }
        int distribute = distribute(i4, writer, poll);
        state.pseudoTime += distribute;
        poll.updatePseudoTime(state, distribute, j4);
        return distribute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) http2Stream.getProperty(this.stateKey);
    }

    public void allocationQuantum(int i4) {
        if (i4 > 0) {
            this.allocationQuantum = i4;
            return;
        }
        throw new IllegalArgumentException("allocationQuantum must be > 0");
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public boolean distribute(int i4, StreamByteDistributor.Writer writer) throws Http2Exception {
        int i5;
        ObjectUtil.checkNotNull(writer, "writer");
        if (this.connectionState.activeCountForTree == 0) {
            return false;
        }
        while (true) {
            State state = this.connectionState;
            int i6 = state.activeCountForTree;
            i4 -= distributeToChildren(i4, writer, state);
            i5 = this.connectionState.activeCountForTree;
            if (i5 == 0 || (i4 <= 0 && i6 == i5)) {
                break;
            }
        }
        return i5 != 0;
    }

    int streamableBytes0(Http2Stream http2Stream) {
        return state(http2Stream).streamableBytes;
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame() && streamState.windowSize() >= 0);
    }

    private int distribute(int i4, StreamByteDistributor.Writer writer, State state) throws Http2Exception {
        if (state.active) {
            int min = Math.min(i4, state.streamableBytes);
            state.write(min, writer);
            if (min == 0 && i4 != 0) {
                state.updateStreamableBytes(state.streamableBytes, false);
            }
            return min;
        }
        return distributeToChildren(i4, writer, state);
    }
}
