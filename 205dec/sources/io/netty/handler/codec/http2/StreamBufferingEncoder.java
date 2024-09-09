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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StreamBufferingEncoder extends DecoratingHttp2ConnectionEncoder {
    private boolean closed;
    private int maxConcurrentStreams;
    private final TreeMap<Integer, PendingStream> pendingStreams;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class DataFrame extends Frame {
        final ByteBuf data;
        final boolean endOfStream;
        final int padding;

        DataFrame(ByteBuf byteBuf, int i4, boolean z3, ChannelPromise channelPromise) {
            super(channelPromise);
            this.data = byteBuf;
            this.padding = i4;
            this.endOfStream = z3;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void release(Throwable th) {
            super.release(th);
            ReferenceCountUtil.safeRelease(this.data);
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i4) {
            StreamBufferingEncoder.this.writeData(channelHandlerContext, i4, this.data, this.padding, this.endOfStream, this.promise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

        abstract void send(ChannelHandlerContext channelHandlerContext, int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class HeadersFrame extends Frame {
        final boolean endOfStream;
        final boolean exclusive;
        final Http2Headers headers;
        final int padding;
        final int streamDependency;
        final short weight;

        HeadersFrame(Http2Headers http2Headers, int i4, short s3, boolean z3, int i5, boolean z4, ChannelPromise channelPromise) {
            super(channelPromise);
            this.headers = http2Headers;
            this.streamDependency = i4;
            this.weight = s3;
            this.exclusive = z3;
            this.padding = i5;
            this.endOfStream = z4;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i4) {
            StreamBufferingEncoder.this.writeHeaders(channelHandlerContext, i4, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Http2ChannelClosedException extends Http2Exception {
        private static final long serialVersionUID = 4768543442094476971L;

        public Http2ChannelClosedException() {
            super(Http2Error.REFUSED_STREAM, "Connection closed");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Http2GoAwayException extends Http2Exception {
        private static final long serialVersionUID = 1326785622777291198L;
        private final byte[] debugData;
        private final long errorCode;
        private final int lastStreamId;

        public Http2GoAwayException(int i4, long j4, byte[] bArr) {
            super(Http2Error.STREAM_CLOSED);
            this.lastStreamId = i4;
            this.errorCode = j4;
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class PendingStream {
        final ChannelHandlerContext ctx;
        final Queue<Frame> frames = new ArrayDeque(2);
        final int streamId;

        PendingStream(ChannelHandlerContext channelHandlerContext, int i4) {
            this.ctx = channelHandlerContext;
            this.streamId = i4;
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
    public void cancelGoAwayStreams(int i4, long j4, ByteBuf byteBuf) {
        Iterator<PendingStream> it = this.pendingStreams.values().iterator();
        Http2GoAwayException http2GoAwayException = new Http2GoAwayException(i4, j4, ByteBufUtil.getBytes(byteBuf));
        while (it.hasNext()) {
            PendingStream next = it.next();
            if (next.streamId > i4) {
                it.remove();
                next.close(http2GoAwayException);
            }
        }
    }

    private boolean isExistingStream(int i4) {
        return i4 <= connection().local().lastStreamCreated();
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
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i4, ByteBuf byteBuf, int i5, boolean z3, ChannelPromise channelPromise) {
        if (isExistingStream(i4)) {
            return super.writeData(channelHandlerContext, i4, byteBuf, i5, z3, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i4));
        if (pendingStream != null) {
            pendingStream.frames.add(new DataFrame(byteBuf, i5, z3, channelPromise));
        } else {
            ReferenceCountUtil.safeRelease(byteBuf);
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i4)));
        }
        return channelPromise;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, boolean z3, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i4, http2Headers, 0, (short) 16, false, i5, z3, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i4, long j4, ChannelPromise channelPromise) {
        if (isExistingStream(i4)) {
            return super.writeRstStream(channelHandlerContext, i4, j4, channelPromise);
        }
        PendingStream remove = this.pendingStreams.remove(Integer.valueOf(i4));
        if (remove != null) {
            remove.close(null);
            channelPromise.setSuccess();
        } else {
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i4)));
        }
        return channelPromise;
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i4) {
        super(http2ConnectionEncoder);
        this.pendingStreams = new TreeMap<>();
        this.maxConcurrentStreams = i4;
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.StreamBufferingEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onGoAwayReceived(int i5, long j4, ByteBuf byteBuf) {
                StreamBufferingEncoder.this.cancelGoAwayStreams(i5, j4, byteBuf);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                StreamBufferingEncoder.this.tryCreatePendingStreams();
            }
        });
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, short s3, boolean z3, int i6, boolean z4, ChannelPromise channelPromise) {
        if (this.closed) {
            return channelPromise.setFailure((Throwable) new Http2ChannelClosedException());
        }
        if (!isExistingStream(i4) && !connection().goAwayReceived()) {
            if (canCreateStream()) {
                return super.writeHeaders(channelHandlerContext, i4, http2Headers, i5, s3, z3, i6, z4, channelPromise);
            }
            PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i4));
            if (pendingStream == null) {
                pendingStream = new PendingStream(channelHandlerContext, i4);
                this.pendingStreams.put(Integer.valueOf(i4), pendingStream);
            }
            pendingStream.frames.add(new HeadersFrame(http2Headers, i5, s3, z3, i6, z4, channelPromise));
            return channelPromise;
        }
        return super.writeHeaders(channelHandlerContext, i4, http2Headers, i5, s3, z3, i6, z4, channelPromise);
    }
}
