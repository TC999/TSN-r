package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.Socket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollServerSocketChannel extends AbstractEpollServerChannel implements ServerSocketChannel {
    private final EpollServerSocketChannelConfig config;
    private volatile InetSocketAddress local;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    public EpollServerSocketChannel() {
        super(Socket.newSocketStream(), false);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollServerSocketChannelConfig(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        AbstractEpollChannel.checkResolvable(inetSocketAddress);
        fd().bind(inetSocketAddress);
        this.local = fd().localAddress();
        if (Native.IS_SUPPORTING_TCP_FASTOPEN && this.config.getTcpFastopen() > 0) {
            Native.setTcpFastopen(fd().intValue(), this.config.getTcpFastopen());
        }
        fd().listen(this.config.getBacklog());
        this.active = true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel, io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int i4, byte[] bArr, int i5, int i6) throws Exception {
        return new EpollSocketChannel(this, new Socket(i4), NativeInetAddress.address(bArr, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTcpMd5Sig(Map<InetAddress, byte[]> map) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<InetAddress> tcpMd5SigAddresses() {
        return this.tcpMd5SigAddresses;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public InetSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Deprecated
    public EpollServerSocketChannel(FileDescriptor fileDescriptor) {
        this(new Socket(fileDescriptor.intValue()));
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollServerSocketChannelConfig config() {
        return this.config;
    }

    @Deprecated
    public EpollServerSocketChannel(Socket socket) {
        super(socket);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.local = socket.localAddress();
        this.config = new EpollServerSocketChannelConfig(this);
    }

    public EpollServerSocketChannel(Socket socket, boolean z3) {
        super(socket, z3);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.local = socket.localAddress();
        this.config = new EpollServerSocketChannelConfig(this);
    }
}
