package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class AbstractKQueueStreamChannel extends AbstractKQueueChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractKQueueStreamChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public final class KQueueSocketWritableByteChannel extends SocketWritableByteChannel {
        KQueueSocketWritableByteChannel() {
            super(AbstractKQueueStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractKQueueStreamChannel.this.alloc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class KQueueStreamUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        /* JADX INFO: Access modifiers changed from: package-private */
        public KQueueStreamUnsafe() {
            super();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z3, KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            if (failConnectPromise(th)) {
                return;
            }
            kQueueRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z3 || (th instanceof IOException)) {
                shutdownInput(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            return super.prepareToClose();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #3 {all -> 0x006c, blocks: (B:17:0x0045, B:26:0x0060, B:28:0x0068), top: B:50:0x0045 }] */
        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r9) {
            /*
                r8 = this;
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r0 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.kqueue.KQueueChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r1 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L12
                r8.clearReadFilter0()
                return
            L12:
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r1 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                r9.reset(r0)
                r8.readReadyBefore()
            L22:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r9.allocate(r1)     // Catch: java.lang.Throwable -> L76
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r6 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch: java.lang.Throwable -> L71
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L71
                r9.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L71
                int r6 = r9.lastBytesRead()     // Catch: java.lang.Throwable -> L71
                r7 = 1
                if (r6 > 0) goto L48
                r5.release()     // Catch: java.lang.Throwable -> L71
                int r1 = r9.lastBytesRead()     // Catch: java.lang.Throwable -> L76
                if (r1 >= 0) goto L42
                goto L43
            L42:
                r7 = 0
            L43:
                if (r7 == 0) goto L60
                r8.readPending = r4     // Catch: java.lang.Throwable -> L6c
                goto L60
            L48:
                r9.incMessagesRead(r7)     // Catch: java.lang.Throwable -> L71
                r8.readPending = r4     // Catch: java.lang.Throwable -> L71
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L71
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r5 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch: java.lang.Throwable -> L76
                boolean r5 = r5.shouldBreakReadReady(r0)     // Catch: java.lang.Throwable -> L76
                if (r5 == 0) goto L59
                goto L5f
            L59:
                boolean r5 = r9.continueReading()     // Catch: java.lang.Throwable -> L76
                if (r5 != 0) goto L22
            L5f:
                r7 = 0
            L60:
                r9.readComplete()     // Catch: java.lang.Throwable -> L6c
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L6c
                if (r7 == 0) goto L7f
                r8.shutdownInput(r4)     // Catch: java.lang.Throwable -> L6c
                goto L7f
            L6c:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = r7
                goto L7a
            L71:
                r1 = move-exception
                r4 = r5
                r6 = 0
                r5 = r1
                goto L7a
            L76:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = 0
            L7a:
                r2 = r8
                r7 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L83
            L7f:
                r8.readReadyFinally(r0)
                return
            L83:
                r9 = move-exception
                r8.readReadyFinally(r0)
                goto L89
            L88:
                throw r9
            L89:
                goto L88
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, boolean z3) {
        super(channel, bsdSocket, z3);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    private void adjustMaxBytesPerGatheringWrite(long j4, long j5, long j6) {
        if (j4 == j5) {
            long j7 = j4 << 1;
            if (j7 > j6) {
                config().setMaxBytesPerGatheringWrite(j7);
            }
        } else if (j4 > 4096) {
            long j8 = j4 >>> 1;
            if (j5 < j8) {
                config().setMaxBytesPerGatheringWrite(j8);
            }
        }
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray cleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
        cleanArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(cleanArray);
        if (cleanArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, cleanArray);
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", cause2);
            }
            channelPromise.setFailure(cause);
        } else if (cause2 != null) {
            channelPromise.setFailure(cause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractKQueueStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
                }
            });
        }
    }

    private int writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            channelOutboundBuffer.remove();
            return 0;
        } else if (!byteBuf.hasMemoryAddress() && byteBuf.nioBufferCount() != 1) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers();
            return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBuffers.length, readableBytes, config().getMaxBytesPerGatheringWrite());
        } else {
            return doWriteBytes(channelOutboundBuffer, byteBuf);
        }
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray) throws IOException {
        long size = iovArray.size();
        long writevAddresses = this.socket.writevAddresses(iovArray.memoryAddress(0), iovArray.count());
        if (writevAddresses > 0) {
            adjustMaxBytesPerGatheringWrite(size, writevAddresses, iovArray.maxBytes());
            channelOutboundBuffer.removeBytes(writevAddresses);
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion) throws Exception {
        long count = defaultFileRegion.count();
        long transferred = defaultFileRegion.transferred();
        if (transferred >= count) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long sendFile = this.socket.sendFile(defaultFileRegion, defaultFileRegion.position(), transferred, count - transferred);
        if (sendFile <= 0) {
            if (sendFile == 0) {
                validateFileRegion(defaultFileRegion, transferred);
                return Integer.MAX_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(sendFile);
        if (defaultFileRegion.transferred() >= count) {
            channelOutboundBuffer.remove();
            return 1;
        }
        return 1;
    }

    private int writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, FileRegion fileRegion) throws Exception {
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new KQueueSocketWritableByteChannel();
        }
        long transferTo = fileRegion.transferTo(this.byteChannel, fileRegion.transferred());
        if (transferTo > 0) {
            channelOutboundBuffer.progress(transferTo);
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
                return 1;
            }
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    protected final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int doWriteSingle;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int size = channelOutboundBuffer.size();
            if (size > 1 && (channelOutboundBuffer.current() instanceof ByteBuf)) {
                doWriteSingle = doWriteMultiple(channelOutboundBuffer);
            } else if (size == 0) {
                writeFilter(false);
                return;
            } else {
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            writeFilter(false);
            eventLoop().execute(this.flushTask);
            return;
        }
        writeFilter(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if (current instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) current);
        }
        if (current instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(channelOutboundBuffer, (DefaultFileRegion) current);
        }
        if (current instanceof FileRegion) {
            return writeFileRegion(channelOutboundBuffer, (FileRegion) current);
        }
        throw new Error();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        } else if (obj instanceof FileRegion) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.4
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractKQueueStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractKQueueStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel, bsdSocket, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(BsdSocket bsdSocket) {
        this((Channel) null, bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i4, long j4, long j5) throws IOException {
        if (j4 > j5) {
            j4 = j5;
        }
        long writev = this.socket.writev(byteBufferArr, 0, i4, j4);
        if (writev > 0) {
            adjustMaxBytesPerGatheringWrite(j4, writev, j5);
            channelOutboundBuffer.removeBytes(writev);
            return 1;
        }
        return Integer.MAX_VALUE;
    }
}
