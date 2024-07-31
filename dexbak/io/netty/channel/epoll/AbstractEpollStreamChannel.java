package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ChannelPromise connectPromise;
    private ScheduledFuture<?> connectTimeoutFuture;
    private FileDescriptor pipeIn;
    private FileDescriptor pipeOut;
    private SocketAddress requestedRemoteAddress;
    private Queue<SpliceInTask> spliceQueue;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractEpollStreamChannel.class);
    private static final ClosedChannelException DO_CLOSE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "doClose()");
    private static final ClosedChannelException CLEAR_SPLICE_QUEUE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "clearSpliceQueue()");
    private static final ClosedChannelException SPLICE_TO_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "spliceTo(...)");
    private static final ClosedChannelException FAIL_SPLICE_IF_CLOSED_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractEpollStreamChannel.class, "failSpliceIfClosed(...)");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class SpliceFdTask extends SpliceInTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: fd */
        private final FileDescriptor f40181fd;
        private final int offset;
        private final ChannelPromise promise;

        SpliceFdTask(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
            super(i2, channelPromise);
            this.f40181fd = fileDescriptor;
            this.promise = channelPromise;
            this.offset = i;
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor[] pipe = FileDescriptor.pipe();
                FileDescriptor fileDescriptor = pipe[0];
                FileDescriptor fileDescriptor2 = pipe[1];
                int spliceIn = spliceIn(fileDescriptor2, handle);
                if (spliceIn > 0) {
                    int i = this.len;
                    if (i != Integer.MAX_VALUE) {
                        this.len = i - spliceIn;
                    }
                    do {
                        spliceIn -= Native.splice(fileDescriptor.intValue(), -1L, this.f40181fd.intValue(), this.offset, spliceIn);
                    } while (spliceIn > 0);
                    if (this.len == 0) {
                        this.promise.setSuccess();
                        AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                        AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                        return true;
                    }
                }
                AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                return false;
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: ch */
        private final AbstractEpollStreamChannel f40182ch;

        SpliceInChannelTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
            super(i, channelPromise);
            this.f40182ch = abstractEpollStreamChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.util.concurrent.Future, io.netty.channel.ChannelPromise] */
        /* JADX WARN: Type inference failed for: r0v16 */
        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            ChannelPromise channelPromise;
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor fileDescriptor = this.f40182ch.pipeOut;
                if (fileDescriptor == null) {
                    FileDescriptor[] pipe = FileDescriptor.pipe();
                    this.f40182ch.pipeIn = pipe[0];
                    fileDescriptor = this.f40182ch.pipeOut = pipe[1];
                }
                int spliceIn = spliceIn(fileDescriptor, handle);
                if (spliceIn > 0) {
                    int i = this.len;
                    if (i != Integer.MAX_VALUE) {
                        this.len = i - spliceIn;
                    }
                    if (this.len == 0) {
                        channelPromise = this.promise;
                    } else {
                        channelPromise = this.f40182ch.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                    }
                    boolean isAutoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                    this.f40182ch.unsafe().write(new SpliceOutTask(this.f40182ch, spliceIn, isAutoRead), channelPromise);
                    this.f40182ch.unsafe().flush();
                    if (isAutoRead && !channelPromise.isDone()) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(false);
                    }
                }
                return this.len == 0;
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            this.promise.setFailure(channelFuture.cause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public abstract class SpliceInTask {
        int len;
        final ChannelPromise promise;

        protected SpliceInTask(int i, ChannelPromise channelPromise) {
            this.promise = channelPromise;
            this.len = i;
        }

        protected final int spliceIn(FileDescriptor fileDescriptor, RecvByteBufAllocator.Handle handle) throws IOException {
            int min = Math.min(handle.guess(), this.len);
            int i = 0;
            while (true) {
                int splice = Native.splice(AbstractEpollStreamChannel.this.mo12687fd().intValue(), -1L, fileDescriptor.intValue(), -1L, min);
                if (splice == 0) {
                    return i;
                }
                i += splice;
                min -= splice;
            }
        }

        abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class SpliceOutTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean autoRead;

        /* renamed from: ch */
        private final AbstractEpollStreamChannel f40183ch;
        private int len;

        SpliceOutTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, boolean z) {
            this.f40183ch = abstractEpollStreamChannel;
            this.len = i;
            this.autoRead = z;
        }

        public boolean spliceOut() throws Exception {
            try {
                int splice = this.len - Native.splice(this.f40183ch.pipeIn.intValue(), -1L, this.f40183ch.mo12687fd().intValue(), -1L, this.len);
                this.len = splice;
                if (splice == 0) {
                    if (this.autoRead) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(true);
                    }
                    return true;
                }
                return false;
            } catch (IOException e) {
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                throw e;
            }
        }
    }

    @Deprecated
    protected AbstractEpollStreamChannel(Channel channel, int i) {
        this(channel, new Socket(i));
    }

    private void addToSpliceQueue(final SpliceInTask spliceInTask) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            addToSpliceQueue0(spliceInTask);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.8
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.addToSpliceQueue0(spliceInTask);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToSpliceQueue0(SpliceInTask spliceInTask) {
        if (this.spliceQueue == null) {
            this.spliceQueue = PlatformDependent.newMpscQueue();
        }
        this.spliceQueue.add(spliceInTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpliceQueue() {
        if (this.spliceQueue == null) {
            return;
        }
        while (true) {
            SpliceInTask poll = this.spliceQueue.poll();
            if (poll == null) {
                return;
            }
            poll.promise.tryFailure(CLEAR_SPLICE_QUEUE_CLOSED_CHANNEL_EXCEPTION);
        }
    }

    private boolean doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer, int i) throws Exception {
        if (PlatformDependent.hasUnsafe()) {
            IovArray cleanArray = ((EpollEventLoop) eventLoop()).cleanArray();
            channelOutboundBuffer.forEachFlushedMessage(cleanArray);
            if (cleanArray.count() >= 1) {
                if (!writeBytesMultiple(channelOutboundBuffer, cleanArray, i)) {
                    return false;
                }
            } else {
                channelOutboundBuffer.removeBytes(0L);
            }
        } else {
            ByteBuffer[] nioBuffers = channelOutboundBuffer.nioBuffers();
            int nioBufferCount = channelOutboundBuffer.nioBufferCount();
            if (nioBufferCount >= 1) {
                if (!writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBufferCount, channelOutboundBuffer.nioBufferSize(), i)) {
                    return false;
                }
            } else {
                channelOutboundBuffer.removeBytes(0L);
            }
        }
        return true;
    }

    private void failSpliceIfClosed(ChannelPromise channelPromise) {
        if (isOpen() || !channelPromise.tryFailure(FAIL_SPLICE_IF_CLOSED_CLOSED_CHANNEL_EXCEPTION)) {
            return;
        }
        eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.clearSpliceQueue();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (IOException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Error while closing a pipe", (Throwable) e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdown0(ChannelPromise channelPromise) {
        try {
            mo12687fd().shutdown(true, true);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            mo12687fd().shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutput0(ChannelPromise channelPromise) {
        try {
            mo12687fd().shutdown(false, true);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    private boolean writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf, int i) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            channelOutboundBuffer.remove();
            return true;
        } else if (!byteBuf.hasMemoryAddress() && byteBuf.nioBufferCount() != 1) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers();
            return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBuffers.length, readableBytes, i);
        } else {
            int doWriteBytes = doWriteBytes(byteBuf, i);
            channelOutboundBuffer.removeBytes(doWriteBytes);
            return doWriteBytes == readableBytes;
        }
    }

    private boolean writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray, int i) throws IOException {
        long size = iovArray.size();
        int count = iovArray.count();
        int i2 = count + 0;
        boolean z = true;
        long j = size;
        int i3 = 0;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            long writevAddresses = mo12687fd().writevAddresses(iovArray.memoryAddress(i3), count);
            if (writevAddresses == 0) {
                break;
            }
            j -= writevAddresses;
            if (j == 0) {
                break;
            }
            do {
                long processWritten = iovArray.processWritten(i3, writevAddresses);
                if (processWritten == -1) {
                    break;
                }
                i3++;
                count--;
                writevAddresses -= processWritten;
                if (i3 < i2) {
                }
            } while (writevAddresses > 0);
        }
        z = false;
        channelOutboundBuffer.removeBytes(size - j);
        return z;
    }

    private boolean writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion, int i) throws Exception {
        long j;
        long count = defaultFileRegion.count();
        boolean z = true;
        if (defaultFileRegion.transferred() >= count) {
            channelOutboundBuffer.remove();
            return true;
        }
        long position = defaultFileRegion.position();
        long j2 = 0;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            long transferred = defaultFileRegion.transferred();
            long sendfile = Native.sendfile(mo12687fd().intValue(), defaultFileRegion, position, transferred, count - transferred);
            if (sendfile == 0) {
                break;
            }
            j2 += sendfile;
            if (defaultFileRegion.transfered() >= count) {
                j = j2;
                break;
            }
        }
        j = j2;
        z = false;
        if (j > 0) {
            channelOutboundBuffer.progress(j);
        }
        if (z) {
            channelOutboundBuffer.remove();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        try {
            ChannelPromise channelPromise = this.connectPromise;
            if (channelPromise != null) {
                channelPromise.tryFailure(DO_CLOSE_CLOSED_CHANNEL_EXCEPTION);
                this.connectPromise = null;
            }
            ScheduledFuture<?> scheduledFuture = this.connectTimeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.connectTimeoutFuture = null;
            }
            super.doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            mo12687fd().bind(socketAddress2);
        }
        try {
            boolean connect = mo12687fd().connect(socketAddress);
            if (!connect) {
                setFlag(Native.EPOLLOUT);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        setFlag(io.netty.channel.epoll.Native.EPOLLOUT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        return;
     */
    @Override // io.netty.channel.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doWrite(io.netty.channel.ChannelOutboundBuffer r4) throws java.lang.Exception {
        /*
            r3 = this;
            io.netty.channel.epoll.EpollChannelConfig r0 = r3.config()
            int r0 = r0.getWriteSpinCount()
        L8:
            int r1 = r4.size()
            if (r1 != 0) goto L14
            int r4 = io.netty.channel.epoll.Native.EPOLLOUT
            r3.clearFlag(r4)
            return
        L14:
            r2 = 1
            if (r1 <= r2) goto L26
            java.lang.Object r1 = r4.current()
            boolean r1 = r1 instanceof io.netty.buffer.ByteBuf
            if (r1 == 0) goto L26
            boolean r1 = r3.doWriteMultiple(r4, r0)
            if (r1 != 0) goto L8
            goto L2c
        L26:
            boolean r1 = r3.doWriteSingle(r4, r0)
            if (r1 != 0) goto L8
        L2c:
            int r4 = io.netty.channel.epoll.Native.EPOLLOUT
            r3.setFlag(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer, int i) throws Exception {
        Object current = channelOutboundBuffer.current();
        if (current instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) current, i);
        } else if (current instanceof DefaultFileRegion) {
            return writeFileRegion(channelOutboundBuffer, (DefaultFileRegion) current, i);
        } else if (current instanceof SpliceOutTask) {
            if (((SpliceOutTask) current).spliceOut()) {
                channelOutboundBuffer.remove();
                return true;
            }
            return false;
        } else {
            throw new Error();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (byteBuf.hasMemoryAddress()) {
                return byteBuf;
            }
            if (PlatformDependent.hasUnsafe() || !byteBuf.isDirect()) {
                if (byteBuf instanceof CompositeByteBuf) {
                    CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
                    return (!compositeByteBuf.isDirect() || compositeByteBuf.nioBufferCount() > Native.IOV_MAX) ? newDirectBuffer(byteBuf) : byteBuf;
                }
                return newDirectBuffer(byteBuf);
            }
            return byteBuf;
        } else if ((obj instanceof DefaultFileRegion) || (obj instanceof SpliceOutTask)) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return mo12687fd().isInputShutdown();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return mo12687fd().isOutputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return mo12687fd().isShutdown();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
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

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i) {
        return spliceTo(abstractEpollStreamChannel, i, newPromise());
    }

    @Deprecated
    protected AbstractEpollStreamChannel(int i) {
        this(new Socket(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdown0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdown0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdown0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownInput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownOutput0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownOutput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownOutput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
        if (abstractEpollStreamChannel.eventLoop() == eventLoop()) {
            if (i >= 0) {
                EpollMode epollMode = abstractEpollStreamChannel.config().getEpollMode();
                EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
                if (epollMode == epollMode2 && config().getEpollMode() == epollMode2) {
                    ObjectUtil.checkNotNull(channelPromise, "promise");
                    if (!isOpen()) {
                        channelPromise.tryFailure(SPLICE_TO_CLOSED_CHANNEL_EXCEPTION);
                    } else {
                        addToSpliceQueue(new SpliceInChannelTask(abstractEpollStreamChannel, i, channelPromise));
                        failSpliceIfClosed(channelPromise);
                    }
                    return channelPromise;
                }
                throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
            }
            throw new IllegalArgumentException("len: " + i + " (expected: >= 0)");
        }
        throw new IllegalArgumentException("EventLoops are not the same.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AbstractEpollStreamChannel(FileDescriptor fileDescriptor) {
        this(new Socket(fileDescriptor.intValue()));
    }

    @Deprecated
    protected AbstractEpollStreamChannel(Socket socket) {
        this(socket, AbstractEpollChannel.isSoErrorZero(socket));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EpollStreamUnsafe() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
            if (r5.this$0.connectTimeoutFuture == null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.epoll.AbstractEpollStreamChannel r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L2f
                boolean r2 = r2.isActive()     // Catch: java.lang.Throwable -> L2f
                boolean r3 = r5.doFinishConnect()     // Catch: java.lang.Throwable -> L2f
                if (r3 != 0) goto Lf
                return
            Lf:
                io.netty.channel.epoll.AbstractEpollStreamChannel r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.ChannelPromise r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r3)     // Catch: java.lang.Throwable -> L2f
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.epoll.AbstractEpollStreamChannel r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$600(r2)
                if (r2 == 0) goto L29
            L20:
                io.netty.channel.epoll.AbstractEpollStreamChannel r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$600(r2)
                r2.cancel(r0)
            L29:
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.AbstractEpollStreamChannel.access$402(r0, r1)
                goto L4c
            L2f:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollStreamChannel r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.ChannelPromise r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r3)     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.epoll.AbstractEpollStreamChannel r4 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L4d
                java.net.SocketAddress r4 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$500(r4)     // Catch: java.lang.Throwable -> L4d
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch: java.lang.Throwable -> L4d
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L4d
                io.netty.channel.epoll.AbstractEpollStreamChannel r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$600(r2)
                if (r2 == 0) goto L29
                goto L20
            L4c:
                return
            L4d:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollStreamChannel r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$600(r3)
                if (r3 == 0) goto L5f
                io.netty.channel.epoll.AbstractEpollStreamChannel r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$600(r3)
                r3.cancel(r0)
            L5f:
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.AbstractEpollStreamChannel.access$402(r0, r1)
                goto L66
            L65:
                throw r2
            L66:
                goto L65
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.finishConnect():void");
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise == null) {
                return;
            }
            AbstractEpollStreamChannel.this.active = true;
            boolean isActive = AbstractEpollStreamChannel.this.isActive();
            boolean trySuccess = channelPromise.trySuccess();
            if (!z && isActive) {
                AbstractEpollStreamChannel.this.pipeline().fireChannelActive();
            }
            if (trySuccess) {
                return;
            }
            close(voidPromise());
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            epollRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof IOException)) {
                shutdownInput();
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractEpollStreamChannel.this.connectPromise == null) {
                        boolean isActive = AbstractEpollStreamChannel.this.isActive();
                        if (AbstractEpollStreamChannel.this.doConnect(socketAddress, socketAddress2)) {
                            fulfillConnectPromise(channelPromise, isActive);
                            return;
                        }
                        AbstractEpollStreamChannel.this.connectPromise = channelPromise;
                        AbstractEpollStreamChannel.this.requestedRemoteAddress = socketAddress;
                        int connectTimeoutMillis = AbstractEpollStreamChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractEpollStreamChannel abstractEpollStreamChannel = AbstractEpollStreamChannel.this;
                            abstractEpollStreamChannel.connectTimeoutFuture = abstractEpollStreamChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise channelPromise2 = AbstractEpollStreamChannel.this.connectPromise;
                                    ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                                    if (channelPromise2 == null || !channelPromise2.tryFailure(connectTimeoutException)) {
                                        return;
                                    }
                                    EpollStreamUnsafe epollStreamUnsafe = EpollStreamUnsafe.this;
                                    epollStreamUnsafe.close(epollStreamUnsafe.voidPromise());
                                }
                            }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isCancelled()) {
                                    if (AbstractEpollStreamChannel.this.connectTimeoutFuture != null) {
                                        AbstractEpollStreamChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractEpollStreamChannel.this.connectPromise = null;
                                    EpollStreamUnsafe epollStreamUnsafe = EpollStreamUnsafe.this;
                                    epollStreamUnsafe.close(epollStreamUnsafe.voidPromise());
                                }
                            }
                        });
                        return;
                    }
                    throw new ConnectionPendingException();
                } catch (Throwable th) {
                    closeIfClosed();
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean doFinishConnect() throws Exception {
            if (AbstractEpollStreamChannel.this.mo12687fd().finishConnect()) {
                AbstractEpollStreamChannel.this.clearFlag(Native.EPOLLOUT);
                return true;
            }
            AbstractEpollStreamChannel.this.setFlag(Native.EPOLLOUT);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't wrap try/catch for region: R(7:6|(6:7|8|9|(4:37|38|39|(4:46|47|48|(1:50)(0))(4:41|42|(2:44|45)|18))(2:13|(3:15|(1:17)|18)(0))|25|26)|20|21|(1:23)|25|26) */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
            r1 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
            r5 = r3;
            r3 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
            r4 = r1;
         */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void epollInReady() {
            /*
                r9 = this;
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.unix.Socket r0 = r0.mo12687fd()
                boolean r0 = r0.isInputShutdown()
                if (r0 == 0) goto L10
                r9.clearEpollIn0()
                return
            L10:
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.EpollChannelConfig r0 = r0.config()
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r6 = r9.recvBufAllocHandle()
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                int r2 = io.netty.channel.epoll.Native.EPOLLET
                boolean r1 = r1.isFlagSet(r2)
                r6.edgeTriggered(r1)
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.ChannelPipeline r2 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                r6.reset(r0)
                r9.epollInBefore()
            L35:
                r3 = 0
                r4 = 0
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb4
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$700(r5)     // Catch: java.lang.Throwable -> Lb4
                if (r5 == 0) goto L65
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb4
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$700(r5)     // Catch: java.lang.Throwable -> Lb4
                java.lang.Object r5 = r5.peek()     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInTask r5 = (io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask) r5     // Catch: java.lang.Throwable -> Lb4
                if (r5 == 0) goto L65
                boolean r5 = r5.spliceIn(r6)     // Catch: java.lang.Throwable -> Lb4
                if (r5 == 0) goto L9f
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb4
                boolean r5 = r5.isActive()     // Catch: java.lang.Throwable -> Lb4
                if (r5 == 0) goto L99
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb4
                java.util.Queue r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$700(r5)     // Catch: java.lang.Throwable -> Lb4
                r5.remove()     // Catch: java.lang.Throwable -> Lb4
                goto L99
            L65:
                io.netty.buffer.ByteBuf r5 = r6.allocate(r1)     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.epoll.AbstractEpollStreamChannel r7 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Laf
                int r7 = r7.doReadBytes(r5)     // Catch: java.lang.Throwable -> Laf
                r6.lastBytesRead(r7)     // Catch: java.lang.Throwable -> Laf
                int r7 = r6.lastBytesRead()     // Catch: java.lang.Throwable -> Laf
                r8 = 1
                if (r7 > 0) goto L84
                r5.release()     // Catch: java.lang.Throwable -> Laf
                int r1 = r6.lastBytesRead()     // Catch: java.lang.Throwable -> Lb4
                if (r1 >= 0) goto L9f
                r3 = 1
                goto L9f
            L84:
                r6.incMessagesRead(r8)     // Catch: java.lang.Throwable -> Laf
                r9.readPending = r3     // Catch: java.lang.Throwable -> Laf
                r2.fireChannelRead(r5)     // Catch: java.lang.Throwable -> Laf
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> Lb4
                io.netty.channel.unix.Socket r5 = r5.mo12687fd()     // Catch: java.lang.Throwable -> Lb4
                boolean r5 = r5.isInputShutdown()     // Catch: java.lang.Throwable -> Lb4
                if (r5 == 0) goto L99
                goto L9f
            L99:
                boolean r5 = r6.continueReading()     // Catch: java.lang.Throwable -> Lb4
                if (r5 != 0) goto L35
            L9f:
                r6.readComplete()     // Catch: java.lang.Throwable -> Lab
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> Lab
                if (r3 == 0) goto Lbc
                r9.shutdownInput()     // Catch: java.lang.Throwable -> Lab
                goto Lbc
            Lab:
                r1 = move-exception
                r5 = r3
                r3 = r4
                goto Lb7
            Laf:
                r1 = move-exception
                r4 = r1
                r3 = r5
                r5 = 0
                goto Lb8
            Lb4:
                r1 = move-exception
                r3 = r4
                r5 = 0
            Lb7:
                r4 = r1
            Lb8:
                r1 = r9
                r1.handleReadException(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lc0
            Lbc:
                r9.epollInFinally(r0)
                return
            Lc0:
                r1 = move-exception
                r9.epollInFinally(r0)
                goto Lc6
            Lc5:
                throw r1
            Lc6:
                goto Lc5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.epollInReady():void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollOutReady() {
            if (AbstractEpollStreamChannel.this.connectPromise != null) {
                finishConnect();
            } else {
                super.epollOutReady();
            }
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.Handle handle) {
            return new EpollRecvByteAllocatorStreamingHandle(handle, AbstractEpollStreamChannel.this.config());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            return super.prepareToClose();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th);
            closeIfClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractEpollStreamChannel(Channel channel, Socket socket) {
        super(channel, socket, Native.EPOLLIN, true);
        this.flags |= Native.EPOLLRDHUP;
    }

    private boolean writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i, long j, int i2) throws IOException {
        int i3;
        int i4 = i + 0;
        boolean z = true;
        long j2 = j;
        int i5 = i2 - 1;
        int i6 = 0;
        int i7 = i;
        while (i5 >= 0) {
            long writev = mo12687fd().writev(byteBufferArr, i6, i7);
            if (writev == 0) {
                break;
            }
            j2 -= writev;
            if (j2 == 0) {
                break;
            }
            while (true) {
                ByteBuffer byteBuffer = byteBufferArr[i6];
                int position = byteBuffer.position();
                i3 = i5;
                long limit = byteBuffer.limit() - position;
                if (limit > writev) {
                    byteBuffer.position(position + ((int) writev));
                    break;
                }
                i6++;
                i7--;
                writev -= limit;
                if (i6 < i4 && writev > 0) {
                    i5 = i3;
                }
            }
            i5 = i3 - 1;
        }
        z = false;
        channelOutboundBuffer.removeBytes(j - j2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractEpollStreamChannel(Socket socket, boolean z) {
        super(null, socket, Native.EPOLLIN, z);
        this.flags |= Native.EPOLLRDHUP;
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2) {
        return spliceTo(fileDescriptor, i, i2, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
        if (i2 < 0) {
            throw new IllegalArgumentException("len: " + i2 + " (expected: >= 0)");
        } else if (i >= 0) {
            EpollMode epollMode = config().getEpollMode();
            EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
            if (epollMode == epollMode2) {
                ObjectUtil.checkNotNull(channelPromise, "promise");
                if (!isOpen()) {
                    channelPromise.tryFailure(SPLICE_TO_CLOSED_CHANNEL_EXCEPTION);
                } else {
                    addToSpliceQueue(new SpliceFdTask(fileDescriptor, i, i2, channelPromise));
                    failSpliceIfClosed(channelPromise);
                }
                return channelPromise;
            }
            throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
        } else {
            throw new IllegalArgumentException("offset must be >= 0 but was " + i);
        }
    }
}