package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractEpollChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    protected volatile boolean active;
    private final Socket fileDescriptor;
    protected int flags;
    private final int readFlag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public abstract class AbstractEpollUnsafe extends AbstractChannel.AbstractUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EpollRecvByteAllocatorHandle allocHandle;
        private Runnable epollInReadyRunnable;
        boolean epollInReadyRunnablePending;
        boolean maybeMoreDataToRead;
        boolean readPending;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractEpollUnsafe() {
            super();
        }

        private void clearEpollRdHup() {
            try {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLRDHUP);
            } catch (IOException e) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                close(voidPromise());
            }
        }

        private void fireEventAndClose(Object obj) {
            AbstractEpollChannel.this.pipeline().fireUserEventTriggered(obj);
            close(voidPromise());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void clearEpollIn0() {
            try {
                this.readPending = false;
                AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                abstractEpollChannel.clearFlag(abstractEpollChannel.readFlag);
            } catch (IOException e) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                AbstractEpollChannel.this.unsafe().close(AbstractEpollChannel.this.unsafe().voidPromise());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void epollInBefore() {
            this.maybeMoreDataToRead = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void epollInFinally(ChannelConfig channelConfig) {
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (!this.readPending && !channelConfig.isAutoRead()) {
                AbstractEpollChannel.this.clearEpollIn();
            } else if (this.readPending && this.maybeMoreDataToRead && !AbstractEpollChannel.this.mo12687fd().isInputShutdown()) {
                executeEpollInReadyRunnable();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void epollInReady();

        /* JADX INFO: Access modifiers changed from: package-private */
        public void epollOutReady() {
            if (AbstractEpollChannel.this.mo12687fd().isOutputShutdown()) {
                return;
            }
            super.flush0();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void epollRdHupReady() {
            recvBufAllocHandle().receivedRdHup();
            if (AbstractEpollChannel.this.isActive()) {
                epollInReady();
                clearEpollRdHup();
            }
            shutdownInput();
        }

        final void executeEpollInReadyRunnable() {
            if (this.epollInReadyRunnablePending) {
                return;
            }
            this.epollInReadyRunnablePending = true;
            if (this.epollInReadyRunnable == null) {
                this.epollInReadyRunnable = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                        abstractEpollUnsafe.epollInReadyRunnablePending = false;
                        abstractEpollUnsafe.epollInReady();
                    }
                };
            }
            AbstractEpollChannel.this.eventLoop().execute(this.epollInReadyRunnable);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public void flush0() {
            if (AbstractEpollChannel.this.isFlagSet(Native.EPOLLOUT)) {
                return;
            }
            super.flush0();
        }

        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.Handle handle) {
            return new EpollRecvByteAllocatorHandle(handle, AbstractEpollChannel.this.config());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void shutdownInput() {
            if (AbstractEpollChannel.this.mo12687fd().isInputShutdown()) {
                return;
            }
            if (Boolean.TRUE.equals(AbstractEpollChannel.this.config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                try {
                    AbstractEpollChannel.this.mo12687fd().shutdown(true, false);
                    clearEpollIn0();
                    AbstractEpollChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                    return;
                } catch (IOException unused) {
                    fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                    return;
                } catch (NotYetConnectedException unused2) {
                    fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
            }
            close(voidPromise());
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe, io.netty.channel.Channel.Unsafe
        public EpollRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = newEpollHandle(super.recvBufAllocHandle());
            }
            return this.allocHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractEpollChannel(Socket socket, int i) {
        this(null, socket, i, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSoErrorZero(Socket socket) {
        try {
            return socket.getSoError() == 0;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    private void modifyEvents() throws IOException {
        if (isOpen() && isRegistered()) {
            ((EpollEventLoop) eventLoop()).modify(this);
        }
    }

    private static ByteBuf newDirectBuffer0(Object obj, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf directBuffer = byteBufAllocator.directBuffer(i);
        directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
        ReferenceCountUtil.safeRelease(obj);
        return directBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void clearEpollIn() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            final AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
            if (eventLoop.inEventLoop()) {
                abstractEpollUnsafe.clearEpollIn0();
                return;
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (abstractEpollUnsafe.readPending || AbstractEpollChannel.this.config().isAutoRead()) {
                            return;
                        }
                        abstractEpollUnsafe.clearEpollIn0();
                    }
                });
                return;
            }
        }
        this.flags &= this.readFlag ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFlag(int i) throws IOException {
        if (isFlagSet(i)) {
            this.flags = (i ^ (-1)) & this.flags;
            modifyEvents();
        }
    }

    @Override // io.netty.channel.Channel
    public abstract EpollChannelConfig config();

    @Override // io.netty.channel.AbstractChannel
    protected final void doBeginRead() throws Exception {
        AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
        abstractEpollUnsafe.readPending = true;
        setFlag(this.readFlag);
        if (abstractEpollUnsafe.maybeMoreDataToRead) {
            abstractEpollUnsafe.executeEpollInReadyRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        this.active = false;
        try {
            doDeregister();
        } finally {
            this.fileDescriptor.close();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((EpollEventLoop) eventLoop()).remove(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int read;
        int writerIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            read = this.fileDescriptor.readAddress(byteBuf.memoryAddress(), writerIndex, byteBuf.capacity());
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
            read = this.fileDescriptor.read(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        }
        if (read > 0) {
            byteBuf.writerIndex(writerIndex + read);
        }
        return read;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        ((AbstractEpollUnsafe) unsafe()).epollInReadyRunnablePending = false;
        ((EpollEventLoop) eventLoop()).add(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int doWriteBytes(ByteBuf byteBuf, int i) throws Exception {
        ByteBuffer nioBuffer;
        int readableBytes = byteBuf.readableBytes();
        int i2 = 0;
        if (byteBuf.hasMemoryAddress()) {
            long memoryAddress = byteBuf.memoryAddress();
            int readerIndex = byteBuf.readerIndex();
            int writerIndex = byteBuf.writerIndex();
            for (int i3 = i - 1; i3 >= 0; i3--) {
                int writeAddress = this.fileDescriptor.writeAddress(memoryAddress, readerIndex, writerIndex);
                if (writeAddress <= 0) {
                    break;
                }
                i2 += writeAddress;
                if (i2 == readableBytes) {
                    return i2;
                }
                readerIndex += writeAddress;
            }
        } else {
            if (byteBuf.nioBufferCount() == 1) {
                nioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            } else {
                nioBuffer = byteBuf.nioBuffer();
            }
            for (int i4 = i - 1; i4 >= 0; i4--) {
                int position = nioBuffer.position();
                int write = this.fileDescriptor.write(nioBuffer, position, nioBuffer.limit());
                if (write <= 0) {
                    break;
                }
                nioBuffer.position(position + write);
                i2 += write;
                if (i2 == readableBytes) {
                    return i2;
                }
            }
        }
        if (i2 < readableBytes) {
            setFlag(Native.EPOLLOUT);
        }
        return i2;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.active;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFlagSet(int i) {
        return (i & this.flags) != 0;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.fileDescriptor.isOpen();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return newDirectBuffer(byteBuf, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public abstract AbstractEpollUnsafe newUnsafe();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFlag(int i) throws IOException {
        if (isFlagSet(i)) {
            return;
        }
        this.flags = i | this.flags;
        modifyEvents();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractEpollChannel(Channel channel, Socket socket, int i, boolean z) {
        super(channel);
        this.flags = Native.EPOLLET;
        this.fileDescriptor = (Socket) ObjectUtil.checkNotNull(socket, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.readFlag = i;
        this.flags |= i;
        this.active = z;
    }

    @Override // io.netty.channel.unix.UnixChannel
    /* renamed from: fd */
    public final Socket mo12687fd() {
        return this.fileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuf newDirectBuffer(Object obj, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(obj);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(obj);
        return threadLocalDirectBuffer;
    }
}
