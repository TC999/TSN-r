package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StreamBufferingEncoder extends DecoratingHttp2ConnectionEncoder {
    private boolean closed;
    private int maxConcurrentStreams;
    private final TreeMap<Integer, PendingStream> pendingStreams;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class DataFrame extends Frame {
        final ByteBuf data;
        final boolean endOfStream;
        final int padding;

        DataFrame(ByteBuf byteBuf, int i, boolean z, ChannelPromise channelPromise) {
            super(channelPromise);
            this.data = byteBuf;
            this.padding = i;
            this.endOfStream = z;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void release(Throwable th) {
            super.release(th);
            ReferenceCountUtil.safeRelease(this.data);
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i) {
            StreamBufferingEncoder.this.writeData(channelHandlerContext, i, this.data, this.padding, this.endOfStream, this.promise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class Frame {
        final ChannelPromise promise;

        Frame(ChannelPromise channelPromise) {
            this.promise = channelPromise;
        }

        void release(Throwable th) {
            if (th == null) {
                this.promise.setSuccess();
            } else {
                this.promise.setFailure(th);
            }
        }

        abstract void send(ChannelHandlerContext channelHandlerContext, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class HeadersFrame extends Frame {
        final boolean endOfStream;
        final boolean exclusive;
        final Http2Headers headers;
        final int padding;
        final int streamDependency;
        final short weight;

        HeadersFrame(Http2Headers http2Headers, int i, short s, boolean z, int i2, boolean z2, ChannelPromise channelPromise) {
            super(channelPromise);
            this.headers = http2Headers;
            this.streamDependency = i;
            this.weight = s;
            this.exclusive = z;
            this.padding = i2;
            this.endOfStream = z2;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i) {
            StreamBufferingEncoder.this.writeHeaders(channelHandlerContext, i, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Http2ChannelClosedException extends Http2Exception {
        private static final long serialVersionUID = 4768543442094476971L;

        public Http2ChannelClosedException() {
            super(Http2Error.REFUSED_STREAM, "Connection closed");
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Http2GoAwayException extends Http2Exception {
        private static final long serialVersionUID = 1326785622777291198L;
        private final byte[] debugData;
        private final long errorCode;
        private final int lastStreamId;

        public Http2GoAwayException(int i, long j, byte[] bArr) {
            super(Http2Error.STREAM_CLOSED);
            this.lastStreamId = i;
            this.errorCode = j;
            this.debugData = bArr;
        }

        public byte[] debugData() {
            return this.debugData;
        }

        public long errorCode() {
            return this.errorCode;
        }

        public int lastStreamId() {
            return this.lastStreamId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class PendingStream {
        final ChannelHandlerContext ctx;
        final Queue<Frame> frames = new ArrayDeque(2);
        final int streamId;

        PendingStream(ChannelHandlerContext channelHandlerContext, int i) {
            this.ctx = channelHandlerContext;
            this.streamId = i;
        }

        void close(Throwable th) {
            for (Frame frame : this.frames) {
                frame.release(th);
            }
        }

        void sendFrames() {
            for (Frame frame : this.frames) {
                frame.send(this.ctx, this.streamId);
            }
        }
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, 100);
    }

    private boolean canCreateStream() {
        return connection().local().numActiveStreams() < this.maxConcurrentStreams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelGoAwayStreams(int i, long j, ByteBuf byteBuf) {
        Iterator<PendingStream> it = this.pendingStreams.values().iterator();
        Http2GoAwayException http2GoAwayException = new Http2GoAwayException(i, j, ByteBufUtil.getBytes(byteBuf));
        while (it.hasNext()) {
            PendingStream next = it.next();
            if (next.streamId > i) {
                it.remove();
                next.close(http2GoAwayException);
            }
        }
    }

    private boolean isExistingStream(int i) {
        return i <= connection().local().lastStreamCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCreatePendingStreams() {
        while (!this.pendingStreams.isEmpty() && canCreateStream()) {
            this.pendingStreams.pollFirstEntry().getValue().sendFrames();
        }
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (!this.closed) {
                this.closed = true;
                Http2ChannelClosedException http2ChannelClosedException = new Http2ChannelClosedException();
                while (!this.pendingStreams.isEmpty()) {
                    this.pendingStreams.pollFirstEntry().getValue().close(http2ChannelClosedException);
                }
            }
        } finally {
            super.close();
        }
    }

    public int numBufferedStreams() {
        return this.pendingStreams.size();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        super.remoteSettings(http2Settings);
        this.maxConcurrentStreams = connection().local().maxActiveStreams();
        tryCreatePendingStreams();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        if (isExistingStream(i)) {
            return super.writeData(channelHandlerContext, i, byteBuf, i2, z, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i));
        if (pendingStream != null) {
            pendingStream.frames.add(new DataFrame(byteBuf, i2, z, channelPromise));
        } else {
            ReferenceCountUtil.safeRelease(byteBuf);
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i)));
        }
        return channelPromise;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i, http2Headers, 0, (short) 16, false, i2, z, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        if (isExistingStream(i)) {
            return super.writeRstStream(channelHandlerContext, i, j, channelPromise);
        }
        PendingStream remove = this.pendingStreams.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.close(null);
            channelPromise.setSuccess();
        } else {
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i)));
        }
        return channelPromise;
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i) {
        super(http2ConnectionEncoder);
        this.pendingStreams = new TreeMap<>();
        this.maxConcurrentStreams = i;
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.StreamBufferingEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onGoAwayReceived(int i2, long j, ByteBuf byteBuf) {
                StreamBufferingEncoder.this.cancelGoAwayStreams(i2, j, byteBuf);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                StreamBufferingEncoder.this.tryCreatePendingStreams();
            }
        });
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        if (this.closed) {
            return channelPromise.setFailure((Throwable) new Http2ChannelClosedException());
        }
        if (!isExistingStream(i) && !connection().goAwayReceived()) {
            if (canCreateStream()) {
                return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2, channelPromise);
            }
            PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i));
            if (pendingStream == null) {
                pendingStream = new PendingStream(channelHandlerContext, i);
                this.pendingStreams.put(Integer.valueOf(i), pendingStream);
            }
            pendingStream.frames.add(new HeadersFrame(http2Headers, i2, s, z, i3, z2, channelPromise));
            return channelPromise;
        }
        return super.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2, channelPromise);
    }
}
