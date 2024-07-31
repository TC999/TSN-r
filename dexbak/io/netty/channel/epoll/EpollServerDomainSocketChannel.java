package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.ServerDomainSocketChannel;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.net.SocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollServerDomainSocketChannel extends AbstractEpollServerChannel implements ServerDomainSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollServerDomainSocketChannel.class);
    private final EpollServerChannelConfig config;
    private volatile DomainSocketAddress local;

    public EpollServerDomainSocketChannel() {
        super(Socket.newSocketDomain(), false);
        this.config = new EpollServerChannelConfig(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        mo12687fd().bind(socketAddress);
        mo12687fd().listen(this.config.getBacklog());
        this.local = (DomainSocketAddress) socketAddress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        DomainSocketAddress domainSocketAddress;
        boolean delete;
        try {
            super.doClose();
            if (domainSocketAddress != null) {
                if (delete) {
                    return;
                }
            }
        } finally {
            domainSocketAddress = this.local;
            if (domainSocketAddress != null && !new File(domainSocketAddress.path()).delete()) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Failed to delete a domain socket file: {}", domainSocketAddress.path());
                }
            }
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception {
        return new EpollDomainSocketChannel((Channel) this, new Socket(i));
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    public EpollServerDomainSocketChannel(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        this.config = new EpollServerChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollServerChannelConfig config() {
        return this.config;
    }

    public EpollServerDomainSocketChannel(Socket socket) {
        super(socket);
        this.config = new EpollServerChannelConfig(this);
    }

    public EpollServerDomainSocketChannel(Socket socket, boolean z) {
        super(socket, z);
        this.config = new EpollServerChannelConfig(this);
    }
}
