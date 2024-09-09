package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.spdy.SpdySession;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ThrowableUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdySessionHandler extends ChannelDuplexHandler {
    private static final int DEFAULT_MAX_CONCURRENT_STREAMS = Integer.MAX_VALUE;
    private static final int DEFAULT_WINDOW_SIZE = 65536;
    private static final SpdyProtocolException PROTOCOL_EXCEPTION = (SpdyProtocolException) ThrowableUtil.unknownStackTrace(new SpdyProtocolException(), SpdySessionHandler.class, "handleOutboundMessage(...)");
    private static final SpdyProtocolException STREAM_CLOSED = (SpdyProtocolException) ThrowableUtil.unknownStackTrace(new SpdyProtocolException("Stream closed"), SpdySessionHandler.class, "removeStream(...)");
    private ChannelFutureListener closeSessionFutureListener;
    private int lastGoodStreamId;
    private final int minorVersion;
    private boolean receivedGoAwayFrame;
    private boolean sentGoAwayFrame;
    private final boolean server;
    private int initialSendWindowSize = 65536;
    private int initialReceiveWindowSize = 65536;
    private volatile int initialSessionReceiveWindowSize = 65536;
    private final SpdySession spdySession = new SpdySession(this.initialSendWindowSize, this.initialReceiveWindowSize);
    private int remoteConcurrentStreams = Integer.MAX_VALUE;
    private int localConcurrentStreams = Integer.MAX_VALUE;
    private final AtomicInteger pings = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ClosingChannelFutureListener implements ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            this.ctx.close(this.promise);
        }
    }

    public SpdySessionHandler(SpdyVersion spdyVersion, boolean z3) {
        if (spdyVersion != null) {
            this.server = z3;
            this.minorVersion = spdyVersion.getMinorVersion();
            return;
        }
        throw new NullPointerException("version");
    }

    private boolean acceptStream(int i4, byte b4, boolean z3, boolean z4) {
        if (this.receivedGoAwayFrame || this.sentGoAwayFrame) {
            return false;
        }
        boolean isRemoteInitiatedId = isRemoteInitiatedId(i4);
        if (this.spdySession.numActiveStreams(isRemoteInitiatedId) >= (isRemoteInitiatedId ? this.localConcurrentStreams : this.remoteConcurrentStreams)) {
            return false;
        }
        this.spdySession.acceptStream(i4, b4, z3, z4, this.initialSendWindowSize, this.initialReceiveWindowSize, isRemoteInitiatedId);
        if (isRemoteInitiatedId) {
            this.lastGoodStreamId = i4;
            return true;
        }
        return true;
    }

    private void halfCloseStream(int i4, boolean z3, ChannelFuture channelFuture) {
        if (z3) {
            this.spdySession.closeRemoteSide(i4, isRemoteInitiatedId(i4));
        } else {
            this.spdySession.closeLocalSide(i4, isRemoteInitiatedId(i4));
        }
        if (this.closeSessionFutureListener == null || !this.spdySession.noActiveStreams()) {
            return;
        }
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) this.closeSessionFutureListener);
    }

    private void handleOutboundMessage(final ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) obj;
            int streamId = spdyDataFrame.streamId();
            if (this.spdySession.isLocalSideClosed(streamId)) {
                spdyDataFrame.release();
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            }
            int readableBytes = spdyDataFrame.content().readableBytes();
            int min = Math.min(this.spdySession.getSendWindowSize(streamId), this.spdySession.getSendWindowSize(0));
            if (min <= 0) {
                this.spdySession.putPendingWrite(streamId, new SpdySession.PendingWrite(spdyDataFrame, channelPromise));
                return;
            } else if (min < readableBytes) {
                int i4 = min * (-1);
                this.spdySession.updateSendWindowSize(streamId, i4);
                this.spdySession.updateSendWindowSize(0, i4);
                DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(streamId, spdyDataFrame.content().readRetainedSlice(min));
                this.spdySession.putPendingWrite(streamId, new SpdySession.PendingWrite(spdyDataFrame, channelPromise));
                channelHandlerContext.write(defaultSpdyDataFrame).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdySessionHandler.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        SpdySessionHandler.this.issueSessionError(channelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
                    }
                });
                return;
            } else {
                int i5 = readableBytes * (-1);
                this.spdySession.updateSendWindowSize(streamId, i5);
                this.spdySession.updateSendWindowSize(0, i5);
                channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdySessionHandler.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        SpdySessionHandler.this.issueSessionError(channelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
                    }
                });
                if (spdyDataFrame.isLast()) {
                    halfCloseStream(streamId, false, channelPromise);
                }
            }
        } else if (obj instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) obj;
            int streamId2 = spdySynStreamFrame.streamId();
            if (isRemoteInitiatedId(streamId2)) {
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            } else if (!acceptStream(streamId2, spdySynStreamFrame.priority(), spdySynStreamFrame.isUnidirectional(), spdySynStreamFrame.isLast())) {
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            }
        } else if (obj instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) obj;
            int streamId3 = spdySynReplyFrame.streamId();
            if (isRemoteInitiatedId(streamId3) && !this.spdySession.isLocalSideClosed(streamId3)) {
                if (spdySynReplyFrame.isLast()) {
                    halfCloseStream(streamId3, false, channelPromise);
                }
            } else {
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            }
        } else if (obj instanceof SpdyRstStreamFrame) {
            removeStream(((SpdyRstStreamFrame) obj).streamId(), channelPromise);
        } else if (obj instanceof SpdySettingsFrame) {
            SpdySettingsFrame spdySettingsFrame = (SpdySettingsFrame) obj;
            int value = spdySettingsFrame.getValue(0);
            if (value >= 0 && value != this.minorVersion) {
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            }
            int value2 = spdySettingsFrame.getValue(4);
            if (value2 >= 0) {
                this.localConcurrentStreams = value2;
            }
            if (spdySettingsFrame.isPersisted(7)) {
                spdySettingsFrame.removeValue(7);
            }
            spdySettingsFrame.setPersistValue(7, false);
            int value3 = spdySettingsFrame.getValue(7);
            if (value3 >= 0) {
                updateInitialReceiveWindowSize(value3);
            }
        } else if (obj instanceof SpdyPingFrame) {
            SpdyPingFrame spdyPingFrame = (SpdyPingFrame) obj;
            if (isRemoteInitiatedId(spdyPingFrame.id())) {
                channelHandlerContext.fireExceptionCaught((Throwable) new IllegalArgumentException("invalid PING ID: " + spdyPingFrame.id()));
                return;
            }
            this.pings.getAndIncrement();
        } else if (obj instanceof SpdyGoAwayFrame) {
            channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
            return;
        } else if (obj instanceof SpdyHeadersFrame) {
            SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) obj;
            int streamId4 = spdyHeadersFrame.streamId();
            if (this.spdySession.isLocalSideClosed(streamId4)) {
                channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
                return;
            } else if (spdyHeadersFrame.isLast()) {
                halfCloseStream(streamId4, false, channelPromise);
            }
        } else if (obj instanceof SpdyWindowUpdateFrame) {
            channelPromise.setFailure((Throwable) PROTOCOL_EXCEPTION);
            return;
        }
        channelHandlerContext.write(obj, channelPromise);
    }

    private boolean isRemoteInitiatedId(int i4) {
        boolean isServerId = SpdyCodecUtil.isServerId(i4);
        boolean z3 = this.server;
        return (z3 && !isServerId) || (!z3 && isServerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void issueSessionError(ChannelHandlerContext channelHandlerContext, SpdySessionStatus spdySessionStatus) {
        sendGoAwayFrame(channelHandlerContext, spdySessionStatus).addListener((GenericFutureListener<? extends Future<? super Void>>) new ClosingChannelFutureListener(channelHandlerContext, channelHandlerContext.newPromise()));
    }

    private void issueStreamError(ChannelHandlerContext channelHandlerContext, int i4, SpdyStreamStatus spdyStreamStatus) {
        boolean z3 = !this.spdySession.isRemoteSideClosed(i4);
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        removeStream(i4, newPromise);
        DefaultSpdyRstStreamFrame defaultSpdyRstStreamFrame = new DefaultSpdyRstStreamFrame(i4, spdyStreamStatus);
        channelHandlerContext.writeAndFlush(defaultSpdyRstStreamFrame, newPromise);
        if (z3) {
            channelHandlerContext.fireChannelRead((Object) defaultSpdyRstStreamFrame);
        }
    }

    private void removeStream(int i4, ChannelFuture channelFuture) {
        this.spdySession.removeStream(i4, STREAM_CLOSED, isRemoteInitiatedId(i4));
        if (this.closeSessionFutureListener == null || !this.spdySession.noActiveStreams()) {
            return;
        }
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) this.closeSessionFutureListener);
    }

    private void sendGoAwayFrame(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        ChannelFuture sendGoAwayFrame = sendGoAwayFrame(channelHandlerContext, SpdySessionStatus.OK);
        if (this.spdySession.noActiveStreams()) {
            sendGoAwayFrame.addListener((GenericFutureListener<? extends Future<? super Void>>) new ClosingChannelFutureListener(channelHandlerContext, channelPromise));
        } else {
            this.closeSessionFutureListener = new ClosingChannelFutureListener(channelHandlerContext, channelPromise);
        }
    }

    private void updateInitialReceiveWindowSize(int i4) {
        int i5 = i4 - this.initialReceiveWindowSize;
        this.initialReceiveWindowSize = i4;
        this.spdySession.updateAllReceiveWindowSizes(i5);
    }

    private void updateInitialSendWindowSize(int i4) {
        int i5 = i4 - this.initialSendWindowSize;
        this.initialSendWindowSize = i4;
        this.spdySession.updateAllSendWindowSizes(i5);
    }

    private void updateSendWindowSize(final ChannelHandlerContext channelHandlerContext, int i4, int i5) {
        this.spdySession.updateSendWindowSize(i4, i5);
        while (true) {
            SpdySession.PendingWrite pendingWrite = this.spdySession.getPendingWrite(i4);
            if (pendingWrite == null) {
                return;
            }
            SpdyDataFrame spdyDataFrame = pendingWrite.spdyDataFrame;
            int readableBytes = spdyDataFrame.content().readableBytes();
            int streamId = spdyDataFrame.streamId();
            int min = Math.min(this.spdySession.getSendWindowSize(streamId), this.spdySession.getSendWindowSize(0));
            if (min <= 0) {
                return;
            }
            if (min < readableBytes) {
                int i6 = min * (-1);
                this.spdySession.updateSendWindowSize(streamId, i6);
                this.spdySession.updateSendWindowSize(0, i6);
                channelHandlerContext.writeAndFlush(new DefaultSpdyDataFrame(streamId, spdyDataFrame.content().readRetainedSlice(min))).addListener(new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdySessionHandler.3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        SpdySessionHandler.this.issueSessionError(channelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
                    }
                });
            } else {
                this.spdySession.removePendingWrite(streamId);
                int i7 = readableBytes * (-1);
                this.spdySession.updateSendWindowSize(streamId, i7);
                this.spdySession.updateSendWindowSize(0, i7);
                if (spdyDataFrame.isLast()) {
                    halfCloseStream(streamId, false, pendingWrite.promise);
                }
                channelHandlerContext.writeAndFlush(spdyDataFrame, pendingWrite.promise).addListener(new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdySessionHandler.4
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        SpdySessionHandler.this.issueSessionError(channelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
                    }
                });
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        for (Integer num : this.spdySession.activeStreams().keySet()) {
            removeStream(num.intValue(), channelHandlerContext.newSucceededFuture());
        }
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) obj;
            int streamId = spdyDataFrame.streamId();
            int readableBytes = spdyDataFrame.content().readableBytes() * (-1);
            int updateReceiveWindowSize = this.spdySession.updateReceiveWindowSize(0, readableBytes);
            if (updateReceiveWindowSize < 0) {
                issueSessionError(channelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
                return;
            }
            if (updateReceiveWindowSize <= this.initialSessionReceiveWindowSize / 2) {
                int i4 = this.initialSessionReceiveWindowSize - updateReceiveWindowSize;
                this.spdySession.updateReceiveWindowSize(0, i4);
                channelHandlerContext.writeAndFlush(new DefaultSpdyWindowUpdateFrame(0, i4));
            }
            if (!this.spdySession.isActiveStream(streamId)) {
                spdyDataFrame.release();
                if (streamId <= this.lastGoodStreamId) {
                    issueStreamError(channelHandlerContext, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                    return;
                } else if (this.sentGoAwayFrame) {
                    return;
                } else {
                    issueStreamError(channelHandlerContext, streamId, SpdyStreamStatus.INVALID_STREAM);
                    return;
                }
            } else if (this.spdySession.isRemoteSideClosed(streamId)) {
                spdyDataFrame.release();
                issueStreamError(channelHandlerContext, streamId, SpdyStreamStatus.STREAM_ALREADY_CLOSED);
                return;
            } else if (!isRemoteInitiatedId(streamId) && !this.spdySession.hasReceivedReply(streamId)) {
                spdyDataFrame.release();
                issueStreamError(channelHandlerContext, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            } else {
                int updateReceiveWindowSize2 = this.spdySession.updateReceiveWindowSize(streamId, readableBytes);
                if (updateReceiveWindowSize2 < this.spdySession.getReceiveWindowSizeLowerBound(streamId)) {
                    spdyDataFrame.release();
                    issueStreamError(channelHandlerContext, streamId, SpdyStreamStatus.FLOW_CONTROL_ERROR);
                    return;
                }
                if (updateReceiveWindowSize2 < 0) {
                    while (spdyDataFrame.content().readableBytes() > this.initialReceiveWindowSize) {
                        channelHandlerContext.writeAndFlush(new DefaultSpdyDataFrame(streamId, spdyDataFrame.content().readRetainedSlice(this.initialReceiveWindowSize)));
                    }
                }
                if (updateReceiveWindowSize2 <= this.initialReceiveWindowSize / 2 && !spdyDataFrame.isLast()) {
                    int i5 = this.initialReceiveWindowSize - updateReceiveWindowSize2;
                    this.spdySession.updateReceiveWindowSize(streamId, i5);
                    channelHandlerContext.writeAndFlush(new DefaultSpdyWindowUpdateFrame(streamId, i5));
                }
                if (spdyDataFrame.isLast()) {
                    halfCloseStream(streamId, true, channelHandlerContext.newSucceededFuture());
                }
            }
        } else if (obj instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) obj;
            int streamId2 = spdySynStreamFrame.streamId();
            if (!spdySynStreamFrame.isInvalid() && isRemoteInitiatedId(streamId2) && !this.spdySession.isActiveStream(streamId2)) {
                if (streamId2 <= this.lastGoodStreamId) {
                    issueSessionError(channelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
                    return;
                } else if (!acceptStream(streamId2, spdySynStreamFrame.priority(), spdySynStreamFrame.isLast(), spdySynStreamFrame.isUnidirectional())) {
                    issueStreamError(channelHandlerContext, streamId2, SpdyStreamStatus.REFUSED_STREAM);
                    return;
                }
            } else {
                issueStreamError(channelHandlerContext, streamId2, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            }
        } else if (obj instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) obj;
            int streamId3 = spdySynReplyFrame.streamId();
            if (!spdySynReplyFrame.isInvalid() && !isRemoteInitiatedId(streamId3) && !this.spdySession.isRemoteSideClosed(streamId3)) {
                if (this.spdySession.hasReceivedReply(streamId3)) {
                    issueStreamError(channelHandlerContext, streamId3, SpdyStreamStatus.STREAM_IN_USE);
                    return;
                }
                this.spdySession.receivedReply(streamId3);
                if (spdySynReplyFrame.isLast()) {
                    halfCloseStream(streamId3, true, channelHandlerContext.newSucceededFuture());
                }
            } else {
                issueStreamError(channelHandlerContext, streamId3, SpdyStreamStatus.INVALID_STREAM);
                return;
            }
        } else if (obj instanceof SpdyRstStreamFrame) {
            removeStream(((SpdyRstStreamFrame) obj).streamId(), channelHandlerContext.newSucceededFuture());
        } else if (obj instanceof SpdySettingsFrame) {
            SpdySettingsFrame spdySettingsFrame = (SpdySettingsFrame) obj;
            int value = spdySettingsFrame.getValue(0);
            if (value >= 0 && value != this.minorVersion) {
                issueSessionError(channelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
                return;
            }
            int value2 = spdySettingsFrame.getValue(4);
            if (value2 >= 0) {
                this.remoteConcurrentStreams = value2;
            }
            if (spdySettingsFrame.isPersisted(7)) {
                spdySettingsFrame.removeValue(7);
            }
            spdySettingsFrame.setPersistValue(7, false);
            int value3 = spdySettingsFrame.getValue(7);
            if (value3 >= 0) {
                updateInitialSendWindowSize(value3);
            }
        } else if (obj instanceof SpdyPingFrame) {
            SpdyPingFrame spdyPingFrame = (SpdyPingFrame) obj;
            if (isRemoteInitiatedId(spdyPingFrame.id())) {
                channelHandlerContext.writeAndFlush(spdyPingFrame);
                return;
            } else if (this.pings.get() == 0) {
                return;
            } else {
                this.pings.getAndDecrement();
            }
        } else if (obj instanceof SpdyGoAwayFrame) {
            this.receivedGoAwayFrame = true;
        } else if (obj instanceof SpdyHeadersFrame) {
            SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) obj;
            int streamId4 = spdyHeadersFrame.streamId();
            if (spdyHeadersFrame.isInvalid()) {
                issueStreamError(channelHandlerContext, streamId4, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            } else if (this.spdySession.isRemoteSideClosed(streamId4)) {
                issueStreamError(channelHandlerContext, streamId4, SpdyStreamStatus.INVALID_STREAM);
                return;
            } else if (spdyHeadersFrame.isLast()) {
                halfCloseStream(streamId4, true, channelHandlerContext.newSucceededFuture());
            }
        } else if (obj instanceof SpdyWindowUpdateFrame) {
            SpdyWindowUpdateFrame spdyWindowUpdateFrame = (SpdyWindowUpdateFrame) obj;
            int streamId5 = spdyWindowUpdateFrame.streamId();
            int deltaWindowSize = spdyWindowUpdateFrame.deltaWindowSize();
            if (streamId5 != 0 && this.spdySession.isLocalSideClosed(streamId5)) {
                return;
            }
            if (this.spdySession.getSendWindowSize(streamId5) > Integer.MAX_VALUE - deltaWindowSize) {
                if (streamId5 == 0) {
                    issueSessionError(channelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
                    return;
                } else {
                    issueStreamError(channelHandlerContext, streamId5, SpdyStreamStatus.FLOW_CONTROL_ERROR);
                    return;
                }
            }
            updateSendWindowSize(channelHandlerContext, streamId5, deltaWindowSize);
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        sendGoAwayFrame(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (th instanceof SpdyProtocolException) {
            issueSessionError(channelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    public void setSessionReceiveWindowSize(int i4) {
        if (i4 >= 0) {
            this.initialSessionReceiveWindowSize = i4;
            return;
        }
        throw new IllegalArgumentException("sessionReceiveWindowSize");
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof SpdyDataFrame) && !(obj instanceof SpdySynStreamFrame) && !(obj instanceof SpdySynReplyFrame) && !(obj instanceof SpdyRstStreamFrame) && !(obj instanceof SpdySettingsFrame) && !(obj instanceof SpdyPingFrame) && !(obj instanceof SpdyGoAwayFrame) && !(obj instanceof SpdyHeadersFrame) && !(obj instanceof SpdyWindowUpdateFrame)) {
            channelHandlerContext.write(obj, channelPromise);
        } else {
            handleOutboundMessage(channelHandlerContext, obj, channelPromise);
        }
    }

    private ChannelFuture sendGoAwayFrame(ChannelHandlerContext channelHandlerContext, SpdySessionStatus spdySessionStatus) {
        if (!this.sentGoAwayFrame) {
            this.sentGoAwayFrame = true;
            return channelHandlerContext.writeAndFlush(new DefaultSpdyGoAwayFrame(this.lastGoodStreamId, spdySessionStatus));
        }
        return channelHandlerContext.newSucceededFuture();
    }
}
