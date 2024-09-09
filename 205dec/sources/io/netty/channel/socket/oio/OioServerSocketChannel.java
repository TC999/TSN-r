package io.netty.channel.socket.oio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class OioServerSocketChannel extends AbstractOioMessageChannel implements ServerSocketChannel {
    private final OioServerSocketChannelConfig config;
    final Lock shutdownLock;
    final ServerSocket socket;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioServerSocketChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);

    public OioServerSocketChannel() {
        this(newServerSocket());
    }

    private static ServerSocket newServerSocket() {
        try {
            return new ServerSocket();
        } catch (IOException e4) {
            throw new ChannelException("failed to create a server socket", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void clearReadPending0() {
        super.clearReadPending();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress, this.config.getBacklog());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        if (this.socket.isClosed()) {
            return -1;
        }
        try {
            list.add(new OioSocketChannel(this, this.socket.accept()));
            return 1;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && this.socket.isBound();
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.oio.AbstractOioChannel
    @Deprecated
    public void setReadPending(boolean z3) {
        super.setReadPending(z3);
    }

    public OioServerSocketChannel(ServerSocket serverSocket) {
        super(null);
        this.shutdownLock = new ReentrantLock();
        if (serverSocket != null) {
            try {
                try {
                    serverSocket.setSoTimeout(1000);
                    this.socket = serverSocket;
                    this.config = new DefaultOioServerSocketChannelConfig(this, serverSocket);
                    return;
                } catch (IOException e4) {
                    throw new ChannelException("Failed to set the server socket timeout.", e4);
                }
            } catch (Throwable th) {
                try {
                    serverSocket.close();
                } catch (IOException e5) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Failed to close a partially initialized socket.", (Throwable) e5);
                    }
                }
                throw th;
            }
        }
        throw new NullPointerException("socket");
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.Channel
    public OioServerSocketChannelConfig config() {
        return this.config;
    }
}
