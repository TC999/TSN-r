package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.AbstractEpollStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.AlreadyConnectedException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollSocketChannel extends AbstractEpollStreamChannel implements SocketChannel {
    private final EpollSocketChannelConfig config;
    private volatile InetSocketAddress local;
    private volatile InetSocketAddress remote;
    private InetSocketAddress requestedRemote;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class EpollSocketChannelUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollSocketChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe
        boolean doFinishConnect() throws Exception {
            if (super.doFinishConnect()) {
                EpollSocketChannel epollSocketChannel = EpollSocketChannel.this;
                epollSocketChannel.remote = EpollSocketChannel.computeRemoteAddr(epollSocketChannel.requestedRemote, EpollSocketChannel.this.fd().remoteAddress());
                EpollSocketChannel.this.requestedRemote = null;
                return true;
            }
            return false;
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe, io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!EpollSocketChannel.this.isOpen() || EpollSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((EpollEventLoop) EpollSocketChannel.this.eventLoop()).remove(EpollSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollSocketChannel(Channel channel, Socket socket, InetSocketAddress inetSocketAddress) {
        super(channel, socket);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
        this.remote = inetSocketAddress;
        this.local = socket.localAddress();
        if (channel instanceof EpollServerSocketChannel) {
            this.tcpMd5SigAddresses = ((EpollServerSocketChannel) channel).tcpMd5SigAddresses();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InetSocketAddress computeRemoteAddr(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress2 != null) {
            if (PlatformDependent.javaVersion() >= 7) {
                try {
                    return new InetSocketAddress(InetAddress.getByAddress(inetSocketAddress.getHostString(), inetSocketAddress2.getAddress().getAddress()), inetSocketAddress2.getPort());
                } catch (UnknownHostException unused) {
                }
            }
            return inetSocketAddress2;
        }
        return inetSocketAddress;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        fd().bind((InetSocketAddress) socketAddress);
        this.local = fd().localAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            AbstractEpollChannel.checkResolvable((InetSocketAddress) socketAddress2);
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        AbstractEpollChannel.checkResolvable(inetSocketAddress);
        if (this.remote == null) {
            boolean doConnect = super.doConnect(socketAddress, socketAddress2);
            if (doConnect) {
                this.remote = computeRemoteAddr(inetSocketAddress, fd().remoteAddress());
            } else {
                this.requestedRemote = inetSocketAddress;
            }
            this.local = fd().localAddress();
            return doConnect;
        }
        throw new AlreadyConnectedException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.remote;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTcpMd5Sig(Map<InetAddress, byte[]> map) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, map);
    }

    public EpollTcpInfo tcpInfo() {
        return tcpInfo(new EpollTcpInfo());
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel, io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollSocketChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public EpollTcpInfo tcpInfo(EpollTcpInfo epollTcpInfo) {
        try {
            Native.tcpInfo(fd().intValue(), epollTcpInfo);
            return epollTcpInfo;
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollSocketChannelConfig config() {
        return this.config;
    }

    public EpollSocketChannel() {
        super(Socket.newSocketStream(), false);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
    }

    @Deprecated
    public EpollSocketChannel(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.remote = fd().remoteAddress();
        this.local = fd().localAddress();
        this.config = new EpollSocketChannelConfig(this);
    }

    public EpollSocketChannel(Socket socket, boolean z3) {
        super(socket, z3);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.remote = socket.remoteAddress();
        this.local = socket.localAddress();
        this.config = new EpollSocketChannelConfig(this);
    }
}
