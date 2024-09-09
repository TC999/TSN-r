package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    private final SocketChannelConfig config;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioSocketChannel.class);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioSocketChannel.this.clearReadPending();
        }

        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel, Socket socket) {
            super(nioSocketChannel, socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class NioSocketChannelUnsafe extends AbstractNioByteChannel.NioByteUnsafe {
        private NioSocketChannelUnsafe() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            try {
                if (!NioSocketChannel.this.mo104javaChannel().isOpen() || NioSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                NioSocketChannel.this.doDeregister();
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public NioSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    private void doBind0(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo104javaChannel().bind(socketAddress);
        } else {
            mo104javaChannel().socket().bind(socketAddress);
        }
    }

    private static java.nio.channels.SocketChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openSocketChannel();
        } catch (IOException e4) {
            throw new ChannelException("Failed to open a socket.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdown0(ChannelPromise channelPromise) {
        try {
            shutdownOutput0();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            shutdownInput0();
            if (th == null) {
                channelPromise.setSuccess();
            } else {
                channelPromise.setFailure(th);
            }
        } catch (Throwable th2) {
            if (th == null) {
                channelPromise.setFailure(th2);
                return;
            }
            logger.debug("Exception suppressed because a previous exception occurred.", th2);
            channelPromise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            shutdownInput0();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutput0(ChannelPromise channelPromise) {
        try {
            shutdownOutput0();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        doBind0(socketAddress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        super.doClose();
        mo104javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            doBind0(socketAddress2);
        }
        try {
            boolean connect = mo104javaChannel().connect(socketAddress);
            if (!connect) {
                selectionKey().interestOps(8);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        if (!mo104javaChannel().finishConnect()) {
            throw new Error();
        }
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.attemptedBytesRead(byteBuf.writableBytes());
        return byteBuf.writeBytes(mo104javaChannel(), recvBufAllocHandle.attemptedBytesRead());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
        r8 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b A[LOOP:0: B:2:0x0000->B:36:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076 A[SYNTHETIC] */
    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doWrite(io.netty.channel.ChannelOutboundBuffer r16) throws java.lang.Exception {
        /*
            r15 = this;
        L0:
            int r0 = r16.size()
            if (r0 != 0) goto Lc
            r15.clearOpWrite()
            r1 = r15
            goto L7a
        Lc:
            java.nio.ByteBuffer[] r0 = r16.nioBuffers()
            int r1 = r16.nioBufferCount()
            long r2 = r16.nioBufferSize()
            java.nio.channels.SocketChannel r4 = r15.mo104javaChannel()
            if (r1 == 0) goto L7d
            r5 = 0
            r6 = 0
            r8 = 1
            if (r1 == r8) goto L4a
            io.netty.channel.socket.SocketChannelConfig r9 = r15.config()
            int r9 = r9.getWriteSpinCount()
            int r9 = r9 - r8
            r10 = r6
        L2e:
            if (r9 < 0) goto L46
            long r12 = r4.write(r0, r5, r1)
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 != 0) goto L39
            goto L6f
        L39:
            long r2 = r2 - r12
            long r10 = r10 + r12
            int r12 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r12 != 0) goto L43
            r0 = r16
            r5 = 1
            goto L48
        L43:
            int r9 = r9 + (-1)
            goto L2e
        L46:
            r0 = r16
        L48:
            r8 = 0
            goto L71
        L4a:
            r0 = r0[r5]
            io.netty.channel.socket.SocketChannelConfig r1 = r15.config()
            int r1 = r1.getWriteSpinCount()
            int r1 = r1 - r8
            r9 = r6
        L56:
            if (r1 < 0) goto L6d
            int r11 = r4.write(r0)
            if (r11 != 0) goto L60
            r10 = r9
            goto L6f
        L60:
            long r11 = (long) r11
            long r2 = r2 - r11
            long r9 = r9 + r11
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 != 0) goto L6a
            r10 = r9
            r5 = 1
            goto L6e
        L6a:
            int r1 = r1 + (-1)
            goto L56
        L6d:
            r10 = r9
        L6e:
            r8 = 0
        L6f:
            r0 = r16
        L71:
            r0.removeBytes(r10)
            if (r5 != 0) goto L7b
            r1 = r15
            r15.incompleteWrite(r8)
        L7a:
            return
        L7b:
            r1 = r15
            goto L0
        L7d:
            r1 = r15
            r0 = r16
            super.doWrite(r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.socket.nio.NioSocketChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doWriteBytes(ByteBuf byteBuf) throws Exception {
        return byteBuf.readBytes(mo104javaChannel(), byteBuf.readableBytes());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected long doWriteFileRegion(FileRegion fileRegion) throws Exception {
        return fileRegion.transferTo(mo104javaChannel(), fileRegion.transferred());
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel mo104javaChannel = mo104javaChannel();
        return mo104javaChannel.isOpen() && mo104javaChannel.isConnected();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return mo104javaChannel().socket().isInputShutdown() || !isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return mo104javaChannel().socket().isOutputShutdown() || !isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        Socket socket = mo104javaChannel().socket();
        return (socket.isInputShutdown() && socket.isOutputShutdown()) || !isActive();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return mo104javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return mo104javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public NioSocketChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    @Override // io.netty.channel.Channel
    public SocketChannelConfig config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel */
    public java.nio.channels.SocketChannel mo104javaChannel() {
        return (java.nio.channels.SocketChannel) super.mo104javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((NioSocketChannelUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.5
                @Override // java.lang.Runnable
                public void run() {
                    NioSocketChannel.this.shutdown0(channelPromise);
                }
            });
        } else {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdown0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.6
                    @Override // java.lang.Runnable
                    public void run() {
                        NioSocketChannel.this.shutdown0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((NioSocketChannelUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    NioSocketChannel.this.shutdownInput0(channelPromise);
                }
            });
        } else {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownInput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.4
                    @Override // java.lang.Runnable
                    public void run() {
                        NioSocketChannel.this.shutdownInput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((NioSocketChannelUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    NioSocketChannel.this.shutdownOutput0(channelPromise);
                }
            });
        } else {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownOutput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NioSocketChannel.this.shutdownOutput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel) {
        this(null, socketChannel);
    }

    public NioSocketChannel(Channel channel, java.nio.channels.SocketChannel socketChannel) {
        super(channel, socketChannel);
        this.config = new NioSocketChannelConfig(this, socketChannel.socket());
    }

    private void shutdownInput0() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo104javaChannel().shutdownInput();
        } else {
            mo104javaChannel().socket().shutdownInput();
        }
    }

    private void shutdownOutput0() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo104javaChannel().shutdownOutput();
        } else {
            mo104javaChannel().socket().shutdownOutput();
        }
    }
}
