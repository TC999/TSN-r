package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultHttp2LocalFlowController implements Http2LocalFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final FlowState REDUCED_FLOW_STATE = new FlowState() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.2
        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i4) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z3) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i4) throws Http2Exception {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i4) {
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i4) throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i4) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return 0;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f4) {
            throw new UnsupportedOperationException();
        }
    };
    private final Http2Connection connection;
    private ChannelHandlerContext ctx;
    private Http2FrameWriter frameWriter;
    private int initialWindowSize;
    private final Http2Connection.PropertyKey stateKey;
    private float windowUpdateRatio;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class AutoRefillState extends DefaultState {
        public AutoRefillState(Http2Stream http2Stream, int i4) {
            super(http2Stream, i4);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i4) throws Http2Exception {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.DefaultState, io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i4) throws Http2Exception {
            super.receiveFlowControlledFrame(i4);
            super.consumeBytes(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class DefaultState implements FlowState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean endOfStream;
        private int initialStreamWindowSize;
        private int lowerBound;
        private int processedWindow;
        private final Http2Stream stream;
        private float streamWindowUpdateRatio;
        private int window;

        public DefaultState(Http2Stream http2Stream, int i4) {
            this.stream = http2Stream;
            window(i4);
            this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
        }

        private void returnProcessedBytes(int i4) throws Http2Exception {
            int i5 = this.processedWindow;
            if (i5 - i4 < this.window) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
            this.processedWindow = i5 - i4;
        }

        private void writeWindowUpdate() throws Http2Exception {
            int i4 = this.initialStreamWindowSize - this.processedWindow;
            try {
                incrementFlowControlWindows(i4);
                DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i4, DefaultHttp2LocalFlowController.this.ctx.newPromise());
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean consumeBytes(int i4) throws Http2Exception {
            returnProcessedBytes(i4);
            return writeWindowUpdateIfNeeded();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void endOfStream(boolean z3) {
            this.endOfStream = z3;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementFlowControlWindows(int i4) throws Http2Exception {
            if (i4 > 0 && this.window > Integer.MAX_VALUE - i4) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", Integer.valueOf(this.stream.id()));
            }
            this.window += i4;
            this.processedWindow += i4;
            if (i4 >= 0) {
                i4 = 0;
            }
            this.lowerBound = i4;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void incrementInitialStreamWindow(int i4) {
            int min = (int) Math.min(2147483647L, Math.max(0L, this.initialStreamWindowSize + i4));
            int i5 = this.initialStreamWindowSize;
            this.initialStreamWindowSize = i5 + (min - i5);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int initialWindowSize() {
            return this.initialStreamWindowSize;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void receiveFlowControlledFrame(int i4) throws Http2Exception {
            int i5 = this.window - i4;
            this.window = i5;
            if (i5 < this.lowerBound) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", Integer.valueOf(this.stream.id()));
            }
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int unconsumedBytes() {
            return this.processedWindow - this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void window(int i4) {
            this.initialStreamWindowSize = i4;
            this.processedWindow = i4;
            this.window = i4;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public int windowSize() {
            return this.window;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public float windowUpdateRatio() {
            return this.streamWindowUpdateRatio;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            int i4;
            if (!this.endOfStream && (i4 = this.initialStreamWindowSize) > 0) {
                if (this.processedWindow <= ((int) (i4 * this.streamWindowUpdateRatio))) {
                    writeWindowUpdate();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.FlowState
        public void windowUpdateRatio(float f4) {
            this.streamWindowUpdateRatio = f4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface FlowState {
        boolean consumeBytes(int i4) throws Http2Exception;

        void endOfStream(boolean z3);

        void incrementFlowControlWindows(int i4) throws Http2Exception;

        void incrementInitialStreamWindow(int i4);

        int initialWindowSize();

        void receiveFlowControlledFrame(int i4) throws Http2Exception;

        int unconsumedBytes();

        void window(int i4);

        int windowSize();

        float windowUpdateRatio();

        void windowUpdateRatio(float f4);

        boolean writeWindowUpdateIfNeeded() throws Http2Exception;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class WindowUpdateVisitor implements Http2StreamVisitor {
        private Http2Exception.CompositeStreamException compositeException;
        private final int delta;

        public WindowUpdateVisitor(int i4) {
            this.delta = i4;
        }

        public void throwIfError() throws Http2Exception.CompositeStreamException {
            Http2Exception.CompositeStreamException compositeStreamException = this.compositeException;
            if (compositeStreamException != null) {
                throw compositeStreamException;
            }
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            try {
                FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                state.incrementFlowControlWindows(this.delta);
                state.incrementInitialStreamWindow(this.delta);
                return true;
            } catch (Http2Exception.StreamException e4) {
                if (this.compositeException == null) {
                    this.compositeException = new Http2Exception.CompositeStreamException(e4.error(), 4);
                }
                this.compositeException.add(e4);
                return true;
            }
        }
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection) {
        this(http2Connection, 0.5f, false);
    }

    private static void checkValidRatio(float f4) {
        double d4 = f4;
        if (Double.compare(d4, 0.0d) <= 0 || Double.compare(d4, 1.0d) >= 0) {
            throw new IllegalArgumentException("Invalid ratio: " + f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState connectionState() {
        return (FlowState) this.connection.connectionStream().getProperty(this.stateKey);
    }

    private static boolean isClosed(Http2Stream http2Stream) {
        return http2Stream.state() == Http2Stream.State.CLOSED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public boolean consumeBytes(Http2Stream http2Stream, int i4) throws Http2Exception {
        if (i4 >= 0) {
            if (i4 == 0 || http2Stream == null || isClosed(http2Stream)) {
                return false;
            }
            if (http2Stream.id() != 0) {
                return state(http2Stream).consumeBytes(i4) | connectionState().consumeBytes(i4);
            }
            throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
        }
        throw new IllegalArgumentException("numBytes must not be negative");
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void incrementWindowSize(Http2Stream http2Stream, int i4) throws Http2Exception {
        FlowState state = state(http2Stream);
        state.incrementInitialStreamWindow(i4);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public void initialWindowSize(int i4) throws Http2Exception {
        this.initialWindowSize = i4;
        WindowUpdateVisitor windowUpdateVisitor = new WindowUpdateVisitor(i4 - this.initialWindowSize);
        this.connection.forEachActiveStream(windowUpdateVisitor);
        windowUpdateVisitor.throwIfError();
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i4, boolean z3) throws Http2Exception {
        int readableBytes = byteBuf.readableBytes() + i4;
        FlowState connectionState = connectionState();
        connectionState.receiveFlowControlledFrame(readableBytes);
        if (http2Stream == null || isClosed(http2Stream)) {
            if (readableBytes > 0) {
                connectionState.consumeBytes(readableBytes);
                return;
            }
            return;
        }
        FlowState state = state(http2Stream);
        state.endOfStream(z3);
        state.receiveFlowControlledFrame(readableBytes);
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int unconsumedBytes(Http2Stream http2Stream) {
        return state(http2Stream).unconsumedBytes();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public void windowUpdateRatio(float f4) {
        checkValidRatio(f4);
        this.windowUpdateRatio = f4;
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection, float f4, boolean z3) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        windowUpdateRatio(f4);
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        http2Connection.connectionStream().setProperty(newKey, z3 ? new AutoRefillState(http2Connection.connectionStream(), this.initialWindowSize) : new DefaultState(http2Connection.connectionStream(), this.initialWindowSize));
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.DefaultHttp2LocalFlowController.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamActive(Http2Stream http2Stream) {
                Http2Connection.PropertyKey propertyKey = DefaultHttp2LocalFlowController.this.stateKey;
                DefaultHttp2LocalFlowController defaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
                http2Stream.setProperty(propertyKey, new DefaultState(http2Stream, defaultHttp2LocalFlowController.initialWindowSize));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                try {
                    try {
                        FlowState state = DefaultHttp2LocalFlowController.this.state(http2Stream);
                        int unconsumedBytes = state.unconsumedBytes();
                        if (DefaultHttp2LocalFlowController.this.ctx != null && unconsumedBytes > 0) {
                            DefaultHttp2LocalFlowController.this.connectionState().consumeBytes(unconsumedBytes);
                            state.consumeBytes(unconsumedBytes);
                        }
                    } catch (Http2Exception e4) {
                        PlatformDependent.throwException(e4);
                    }
                } finally {
                    http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
                }
            }
        });
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    public float windowUpdateRatio() {
        return this.windowUpdateRatio;
    }

    public void windowUpdateRatio(Http2Stream http2Stream, float f4) throws Http2Exception {
        checkValidRatio(f4);
        FlowState state = state(http2Stream);
        state.windowUpdateRatio(f4);
        state.writeWindowUpdateIfNeeded();
    }

    @Override // io.netty.handler.codec.http2.Http2FlowController
    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    @Override // io.netty.handler.codec.http2.Http2LocalFlowController
    public int initialWindowSize(Http2Stream http2Stream) {
        return state(http2Stream).initialWindowSize();
    }

    public float windowUpdateRatio(Http2Stream http2Stream) throws Http2Exception {
        return state(http2Stream).windowUpdateRatio();
    }
}
