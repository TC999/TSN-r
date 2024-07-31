package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.BooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultHttp2RemoteFlowController implements Http2RemoteFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_WRITABLE_CHUNK = 32768;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2RemoteFlowController.class);
    private final Http2Connection connection;
    private final FlowState connectionState;
    private ChannelHandlerContext ctx;
    private int initialWindowSize;
    private WritabilityMonitor monitor;
    private final Http2Connection.PropertyKey stateKey;
    private final StreamByteDistributor streamByteDistributor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class FlowState implements StreamByteDistributor.StreamState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean cancelled;
        private boolean markedWritable;
        private int pendingBytes;
        private final Http2Stream stream;
        private int window;
        private boolean writing;
        private BooleanSupplier isWritableSupplier = new BooleanSupplier() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.FlowState.1
            @Override // io.netty.util.BooleanSupplier
            public boolean get() throws Exception {
                return FlowState.this.windowSize() > FlowState.this.pendingBytes();
            }
        };
        private final Deque<Http2RemoteFlowController.FlowControlled> pendingWriteQueue = new ArrayDeque(2);

        FlowState(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        private void decrementFlowControlWindow(int i) {
            int i2 = -i;
            try {
                DefaultHttp2RemoteFlowController.this.connectionState.incrementStreamWindow(i2);
                incrementStreamWindow(i2);
            } catch (Http2Exception e) {
                throw new IllegalStateException("Invalid window state when writing frame: " + e.getMessage(), e);
            }
        }

        private void decrementPendingBytes(int i, boolean z) {
            incrementPendingBytes(-i, z);
        }

        private void enqueueFrameWithoutMerge(Http2RemoteFlowController.FlowControlled flowControlled) {
            this.pendingWriteQueue.offer(flowControlled);
            incrementPendingBytes(flowControlled.size(), true);
        }

        private void incrementPendingBytes(int i, boolean z) {
            this.pendingBytes += i;
            DefaultHttp2RemoteFlowController.this.monitor.incrementPendingBytes(i);
            if (z) {
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
            }
        }

        private Http2RemoteFlowController.FlowControlled peek() {
            return this.pendingWriteQueue.peek();
        }

        private int writableWindow() {
            return Math.min(this.window, DefaultHttp2RemoteFlowController.this.connectionWindowSize());
        }

        private void writeError(Http2RemoteFlowController.FlowControlled flowControlled, Http2Exception http2Exception) {
            decrementPendingBytes(flowControlled.size(), true);
            flowControlled.error(DefaultHttp2RemoteFlowController.this.ctx, http2Exception);
        }

        void cancel() {
            cancel(null);
        }

        void enqueueFrame(Http2RemoteFlowController.FlowControlled flowControlled) {
            Http2RemoteFlowController.FlowControlled peekLast = this.pendingWriteQueue.peekLast();
            if (peekLast == null) {
                enqueueFrameWithoutMerge(flowControlled);
                return;
            }
            int size = peekLast.size();
            if (peekLast.merge(DefaultHttp2RemoteFlowController.this.ctx, flowControlled)) {
                incrementPendingBytes(peekLast.size() - size, true);
            } else {
                enqueueFrameWithoutMerge(flowControlled);
            }
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public boolean hasFrame() {
            return !this.pendingWriteQueue.isEmpty();
        }

        int incrementStreamWindow(int i) throws Http2Exception {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.window) {
                this.window += i;
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
                return this.window;
            }
            throw Http2Exception.streamError(this.stream.mo12684id(), Http2Error.FLOW_CONTROL_ERROR, "Window size overflow for stream: %d", Integer.valueOf(this.stream.mo12684id()));
        }

        boolean isWritable() {
            try {
                return this.isWritableSupplier.get();
            } catch (Throwable th) {
                throw new Error("isWritableSupplier should never throw!", th);
            }
        }

        boolean markedWritability() {
            return this.markedWritable;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public int pendingBytes() {
            return this.pendingBytes;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public Http2Stream stream() {
            return this.stream;
        }

        @Override // io.netty.handler.codec.http2.StreamByteDistributor.StreamState
        public int windowSize() {
            return this.window;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
            r8.writing = r1;
            r9 = r9 - r3;
            decrementPendingBytes(r9, r1);
            decrementFlowControlWindow(r9);
            r9 = r8.cancelled;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int writeAllocatedBytes(int r9) {
            /*
                r8 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r8.writing = r0     // Catch: java.lang.Throwable -> L78
                r3 = r9
                r4 = 0
            L7:
                boolean r5 = r8.cancelled     // Catch: java.lang.Throwable -> L76
                if (r5 != 0) goto L51
                io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled r5 = r8.peek()     // Catch: java.lang.Throwable -> L76
                if (r5 == 0) goto L51
                int r6 = r8.writableWindow()     // Catch: java.lang.Throwable -> L76
                int r6 = java.lang.Math.min(r3, r6)     // Catch: java.lang.Throwable -> L76
                if (r6 > 0) goto L22
                int r7 = r5.size()     // Catch: java.lang.Throwable -> L76
                if (r7 <= 0) goto L22
                goto L51
            L22:
                int r4 = r5.size()     // Catch: java.lang.Throwable -> L76
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r7 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch: java.lang.Throwable -> L49
                io.netty.channel.ChannelHandlerContext r7 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.access$500(r7)     // Catch: java.lang.Throwable -> L49
                int r6 = java.lang.Math.max(r1, r6)     // Catch: java.lang.Throwable -> L49
                r5.write(r7, r6)     // Catch: java.lang.Throwable -> L49
                int r6 = r5.size()     // Catch: java.lang.Throwable -> L49
                if (r6 != 0) goto L41
                java.util.Deque<io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled> r6 = r8.pendingWriteQueue     // Catch: java.lang.Throwable -> L49
                r6.remove()     // Catch: java.lang.Throwable -> L49
                r5.writeComplete()     // Catch: java.lang.Throwable -> L49
            L41:
                int r5 = r5.size()     // Catch: java.lang.Throwable -> L76
                int r4 = r4 - r5
                int r3 = r3 - r4
                r4 = 1
                goto L7
            L49:
                r6 = move-exception
                int r5 = r5.size()     // Catch: java.lang.Throwable -> L76
                int r4 = r4 - r5
                int r3 = r3 - r4
                throw r6     // Catch: java.lang.Throwable -> L76
            L51:
                if (r4 != 0) goto L65
                r0 = -1
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                if (r9 == 0) goto L64
                r8.cancel(r2)
            L64:
                return r0
            L65:
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L8c
                r8.cancel(r2)
                goto L8c
            L76:
                r4 = move-exception
                goto L7a
            L78:
                r4 = move-exception
                r3 = r9
            L7a:
                r8.cancelled = r0     // Catch: java.lang.Throwable -> L8d
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L8c
                r8.cancel(r4)
            L8c:
                return r9
            L8d:
                r0 = move-exception
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                if (r9 == 0) goto L9e
                r8.cancel(r2)
            L9e:
                goto La0
            L9f:
                throw r0
            La0:
                goto L9f
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.FlowState.writeAllocatedBytes(int):int");
        }

        private void cancel(Throwable th) {
            this.cancelled = true;
            if (this.writing) {
                return;
            }
            while (true) {
                Http2RemoteFlowController.FlowControlled poll = this.pendingWriteQueue.poll();
                if (poll == null) {
                    DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
                    this.isWritableSupplier = BooleanSupplier.FALSE_SUPPLIER;
                    DefaultHttp2RemoteFlowController.this.monitor.stateCancelled(this);
                    return;
                }
                writeError(poll, Http2Exception.streamError(this.stream.mo12684id(), Http2Error.INTERNAL_ERROR, th, "Stream closed before write could take place", new Object[0]));
            }
        }

        void markedWritability(boolean z) {
            this.markedWritable = z;
        }

        void windowSize(int i) {
            this.window = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class ListenerWritabilityMonitor extends WritabilityMonitor {
        private final Http2StreamVisitor checkStreamWritabilityVisitor;
        private final Http2RemoteFlowController.Listener listener;

        ListenerWritabilityMonitor(Http2RemoteFlowController.Listener listener) {
            super();
            this.checkStreamWritabilityVisitor = new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.ListenerWritabilityMonitor.1
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) throws Http2Exception {
                    FlowState state = DefaultHttp2RemoteFlowController.this.state(http2Stream);
                    if (ListenerWritabilityMonitor.this.isWritable(state) != state.markedWritability()) {
                        ListenerWritabilityMonitor.this.notifyWritabilityChanged(state);
                        return true;
                    }
                    return true;
                }
            };
            this.listener = listener;
        }

        private void checkAllWritabilityChanged() throws Http2Exception {
            DefaultHttp2RemoteFlowController.this.connectionState.markedWritability(isWritableConnection());
            DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(this.checkStreamWritabilityVisitor);
        }

        private void checkConnectionThenStreamWritabilityChanged(FlowState flowState) throws Http2Exception {
            if (isWritableConnection() != DefaultHttp2RemoteFlowController.this.connectionState.markedWritability()) {
                checkAllWritabilityChanged();
            } else if (isWritable(flowState) != flowState.markedWritability()) {
                notifyWritabilityChanged(flowState);
            }
        }

        private void checkStateWritability(FlowState flowState) throws Http2Exception {
            if (isWritable(flowState) != flowState.markedWritability()) {
                if (flowState == DefaultHttp2RemoteFlowController.this.connectionState) {
                    checkAllWritabilityChanged();
                } else {
                    notifyWritabilityChanged(flowState);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyWritabilityChanged(FlowState flowState) {
            flowState.markedWritability(!flowState.markedWritability());
            try {
                this.listener.writabilityChanged(flowState.stream);
            } catch (Throwable th) {
                DefaultHttp2RemoteFlowController.logger.error("Caught Throwable from listener.writabilityChanged", th);
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void channelWritabilityChange() throws Http2Exception {
            if (DefaultHttp2RemoteFlowController.this.connectionState.markedWritability() != DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                checkAllWritabilityChanged();
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            super.enqueueFrame(flowState, flowControlled);
            checkConnectionThenStreamWritabilityChanged(flowState);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void incrementWindowSize(FlowState flowState, int i) throws Http2Exception {
            super.incrementWindowSize(flowState, i);
            checkStateWritability(flowState);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void initialWindowSize(int i) throws Http2Exception {
            super.initialWindowSize(i);
            if (isWritableConnection()) {
                checkAllWritabilityChanged();
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void stateCancelled(FlowState flowState) {
            try {
                checkConnectionThenStreamWritabilityChanged(flowState);
            } catch (Http2Exception e) {
                throw new RuntimeException("Caught unexpected exception from checkAllWritabilityChanged", e);
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor
        void windowSize(FlowState flowState, int i) {
            super.windowSize(flowState, i);
            try {
                checkStateWritability(flowState);
            } catch (Http2Exception e) {
                throw new RuntimeException("Caught unexpected exception from window", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class WritabilityMonitor {
        private boolean inWritePendingBytes;
        private long totalPendingBytes;
        private final StreamByteDistributor.Writer writer;

        private WritabilityMonitor() {
            this.writer = new StreamByteDistributor.Writer() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor.1
                @Override // io.netty.handler.codec.http2.StreamByteDistributor.Writer
                public void write(Http2Stream http2Stream, int i) {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).writeAllocatedBytes(i);
                }
            };
        }

        void channelWritabilityChange() throws Http2Exception {
        }

        void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            flowState.enqueueFrame(flowControlled);
        }

        final void incrementPendingBytes(int i) {
            this.totalPendingBytes += i;
        }

        void incrementWindowSize(FlowState flowState, int i) throws Http2Exception {
            flowState.incrementStreamWindow(i);
        }

        void initialWindowSize(int i) throws Http2Exception {
            if (i >= 0) {
                final int i2 = i - DefaultHttp2RemoteFlowController.this.initialWindowSize;
                DefaultHttp2RemoteFlowController.this.initialWindowSize = i;
                DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor.2
                    @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                    public boolean visit(Http2Stream http2Stream) throws Http2Exception {
                        DefaultHttp2RemoteFlowController.this.state(http2Stream).incrementStreamWindow(i2);
                        return true;
                    }
                });
                if (i2 <= 0 || !DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                    return;
                }
                writePendingBytes();
                return;
            }
            throw new IllegalArgumentException("Invalid initial window size: " + i);
        }

        final boolean isWritable(FlowState flowState) {
            return isWritableConnection() && flowState.isWritable();
        }

        final boolean isWritableConnection() {
            return ((long) DefaultHttp2RemoteFlowController.this.connectionState.windowSize()) - this.totalPendingBytes > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable();
        }

        void stateCancelled(FlowState flowState) {
        }

        void windowSize(FlowState flowState, int i) {
            flowState.windowSize(i);
        }

        final void writePendingBytes() throws Http2Exception {
            if (this.inWritePendingBytes) {
                return;
            }
            this.inWritePendingBytes = true;
            try {
                int writableBytes = DefaultHttp2RemoteFlowController.this.writableBytes();
                while (DefaultHttp2RemoteFlowController.this.streamByteDistributor.distribute(writableBytes, this.writer) && (writableBytes = DefaultHttp2RemoteFlowController.this.writableBytes()) > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable0()) {
                }
            } finally {
                this.inWritePendingBytes = false;
            }
        }
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection) {
        this(http2Connection, (Http2RemoteFlowController.Listener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int connectionWindowSize() {
        return this.connectionState.windowSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChannelWritable() {
        return this.ctx != null && isChannelWritable0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChannelWritable0() {
        return this.ctx.channel().isWritable();
    }

    private int maxUsableChannelBytes() {
        int min = (int) Math.min(2147483647L, this.ctx.channel().bytesBeforeUnwritable());
        return Math.min(this.connectionState.windowSize(), min > 0 ? Math.max(min, minUsableChannelBytes()) : 0);
    }

    private int minUsableChannelBytes() {
        return Math.max(this.ctx.channel().config().getWriteBufferLowWaterMark(), 32768);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int writableBytes() {
        return Math.min(connectionWindowSize(), maxUsableChannelBytes());
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void addFlowControlled(Http2Stream http2Stream, Http2RemoteFlowController.FlowControlled flowControlled) {
        ObjectUtil.checkNotNull(flowControlled, "frame");
        try {
            this.monitor.enqueueFrame(state(http2Stream), flowControlled);
        } catch (Throwable th) {
            flowControlled.error(this.ctx, th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        channelWritabilityChanged();
        if (isChannelWritable()) {
            writePendingBytes();
        }
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void channelWritabilityChanged() throws Http2Exception {
        this.monitor.channelWritabilityChange();
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public boolean hasFlowControlled(Http2Stream http2Stream) {
        return state(http2Stream).hasFrame();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i) throws Http2Exception {
        this.monitor.incrementWindowSize(state(http2Stream), i);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i) throws Http2Exception {
        this.monitor.initialWindowSize(i);
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public boolean isWritable(Http2Stream http2Stream) {
        return this.monitor.isWritable(state(http2Stream));
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void listener(Http2RemoteFlowController.Listener listener) {
        this.monitor = listener == null ? new WritabilityMonitor() : new ListenerWritabilityMonitor(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public void writePendingBytes() throws Http2Exception {
        this.monitor.writePendingBytes();
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor) {
        this(http2Connection, streamByteDistributor, null);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, Http2RemoteFlowController.Listener listener) {
        this(http2Connection, new WeightedFairQueueByteDistributor(http2Connection), listener);
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor, Http2RemoteFlowController.Listener listener) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.streamByteDistributor = (StreamByteDistributor) ObjectUtil.checkNotNull(streamByteDistributor, "streamWriteDistributor");
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        FlowState flowState = new FlowState(http2Connection.connectionStream());
        this.connectionState = flowState;
        http2Connection.connectionStream().setProperty(newKey, flowState);
        listener(listener);
        this.monitor.windowSize(flowState, this.initialWindowSize);
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.monitor.windowSize(DefaultHttp2RemoteFlowController.this.state(http2Stream), DefaultHttp2RemoteFlowController.this.initialWindowSize);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2RemoteFlowController.this.stateKey, new FlowState(http2Stream));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel();
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamHalfClosed(Http2Stream http2Stream) {
                if (Http2Stream.State.HALF_CLOSED_LOCAL.equals(http2Stream.state())) {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel();
                }
            }
        });
    }

    @Override // io.netty.handler.codec.http2.Http2RemoteFlowController
    public ChannelHandlerContext channelHandlerContext() {
        return this.ctx;
    }
}
