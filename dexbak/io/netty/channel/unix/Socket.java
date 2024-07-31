package io.netty.channel.unix;

import io.netty.channel.ChannelException;
import io.netty.channel.unix.Errors;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThrowableUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Socket extends FileDescriptor {
    private static final Errors.NativeIoException CONNECTION_RESET_EXCEPTION_SENDMSG;
    private static final Errors.NativeIoException CONNECTION_RESET_SHUTDOWN_EXCEPTION;
    private static final Errors.NativeConnectException CONNECT_REFUSED_EXCEPTION;
    private static final Errors.NativeConnectException FINISH_CONNECT_REFUSED_EXCEPTION;
    private static final Errors.NativeIoException SEND_TO_ADDRESS_CONNECTION_RESET_EXCEPTION;
    private static final Errors.NativeIoException SEND_TO_CONNECTION_RESET_EXCEPTION;
    private static final ClosedChannelException SHUTDOWN_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Socket.class, "shutdown(...)");
    private static final ClosedChannelException SEND_TO_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Socket.class, "sendTo(...)");
    private static final ClosedChannelException SEND_TO_ADDRESS_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Socket.class, "sendToAddress(...)");
    private static final ClosedChannelException SEND_TO_ADDRESSES_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Socket.class, "sendToAddresses(...)");

    static {
        int i = Errors.ERRNO_EPIPE_NEGATIVE;
        SEND_TO_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendto(...)", i), Socket.class, "sendTo(...)");
        SEND_TO_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendto(...)", i), Socket.class, "sendToAddress(...)");
        CONNECTION_RESET_EXCEPTION_SENDMSG = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendmsg(...)", i), Socket.class, "sendToAddresses(...)");
        CONNECTION_RESET_SHUTDOWN_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:shutdown(...)", Errors.ERRNO_ECONNRESET_NEGATIVE), Socket.class, "shutdown(...)");
        int i2 = Errors.ERROR_ECONNREFUSED_NEGATIVE;
        FINISH_CONNECT_REFUSED_EXCEPTION = (Errors.NativeConnectException) ThrowableUtil.unknownStackTrace(new Errors.NativeConnectException("syscall:getsockopt(...)", i2), Socket.class, "finishConnect(...)");
        CONNECT_REFUSED_EXCEPTION = (Errors.NativeConnectException) ThrowableUtil.unknownStackTrace(new Errors.NativeConnectException("syscall:connect(...)", i2), Socket.class, "connect(...)");
    }

    public Socket(int i) {
        super(i);
    }

    private static native int accept(int i, byte[] bArr);

    private static native int bind(int i, byte[] bArr, int i2, int i3);

    private static native int bindDomainSocket(int i, byte[] bArr);

    private static native int connect(int i, byte[] bArr, int i2, int i3);

    private static native int connectDomainSocket(int i, byte[] bArr);

    private static native int finishConnect(int i);

    private static native int getReceiveBufferSize(int i) throws IOException;

    private static native int getSendBufferSize(int i) throws IOException;

    private static native int getSoError(int i) throws IOException;

    private static native int getSoLinger(int i) throws IOException;

    private static native int getTcpDeferAccept(int i) throws IOException;

    private static native int isKeepAlive(int i) throws IOException;

    private static native int isTcpCork(int i) throws IOException;

    private static native int isTcpNoDelay(int i) throws IOException;

    private static native int isTcpQuickAck(int i) throws IOException;

    private static native int listen(int i, int i2);

    private static native byte[] localAddress(int i);

    public static Socket newSocketDgram() {
        int newSocketDgramFd = newSocketDgramFd();
        if (newSocketDgramFd >= 0) {
            return new Socket(newSocketDgramFd);
        }
        throw new ChannelException(Errors.newIOException("newSocketDgram", newSocketDgramFd));
    }

    private static native int newSocketDgramFd();

    public static Socket newSocketDomain() {
        int newSocketDomainFd = newSocketDomainFd();
        if (newSocketDomainFd >= 0) {
            return new Socket(newSocketDomainFd);
        }
        throw new ChannelException(Errors.newIOException("newSocketDomain", newSocketDomainFd));
    }

    private static native int newSocketDomainFd();

    public static Socket newSocketStream() {
        int newSocketStreamFd = newSocketStreamFd();
        if (newSocketStreamFd >= 0) {
            return new Socket(newSocketStreamFd);
        }
        throw new ChannelException(Errors.newIOException("newSocketStream", newSocketStreamFd));
    }

    private static native int newSocketStreamFd();

    private static native DatagramSocketAddress recvFrom(int i, ByteBuffer byteBuffer, int i2, int i3) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i, long j, int i2, int i3) throws IOException;

    private static native byte[] remoteAddress(int i);

    private static native int sendTo(int i, ByteBuffer byteBuffer, int i2, int i3, byte[] bArr, int i4, int i5);

    private static native int sendToAddress(int i, long j, int i2, int i3, byte[] bArr, int i4, int i5);

    private static native int sendToAddresses(int i, long j, int i2, byte[] bArr, int i3, int i4);

    private static native void setKeepAlive(int i, int i2) throws IOException;

    private static native void setReceiveBufferSize(int i, int i2) throws IOException;

    private static native void setSendBufferSize(int i, int i2) throws IOException;

    private static native void setSoLinger(int i, int i2) throws IOException;

    private static native void setTcpCork(int i, int i2) throws IOException;

    private static native void setTcpDeferAccept(int i, int i2) throws IOException;

    private static native void setTcpNoDelay(int i, int i2) throws IOException;

    private static native void setTcpQuickAck(int i, int i2) throws IOException;

    private static native int shutdown(int i, boolean z, boolean z2);

    public int accept(byte[] bArr) throws IOException {
        int accept = accept(this.f40194fd, bArr);
        if (accept >= 0) {
            return accept;
        }
        if (accept == Errors.ERRNO_EAGAIN_NEGATIVE || accept == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("accept", accept);
    }

    public void bind(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            NativeInetAddress newInstance = NativeInetAddress.newInstance(inetSocketAddress.getAddress());
            int bind = bind(this.f40194fd, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
            if (bind < 0) {
                throw Errors.newIOException("bind", bind);
            }
        } else if (socketAddress instanceof DomainSocketAddress) {
            int bindDomainSocket = bindDomainSocket(this.f40194fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
            if (bindDomainSocket < 0) {
                throw Errors.newIOException("bind", bindDomainSocket);
            }
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
    }

    public boolean connect(SocketAddress socketAddress) throws IOException {
        int connectDomainSocket;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            NativeInetAddress newInstance = NativeInetAddress.newInstance(inetSocketAddress.getAddress());
            connectDomainSocket = connect(this.f40194fd, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
        } else if (socketAddress instanceof DomainSocketAddress) {
            connectDomainSocket = connectDomainSocket(this.f40194fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
        if (connectDomainSocket < 0) {
            if (connectDomainSocket == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
                return false;
            }
            Errors.throwConnectException("connect", CONNECT_REFUSED_EXCEPTION, connectDomainSocket);
            return true;
        }
        return true;
    }

    public boolean finishConnect() throws IOException {
        int finishConnect = finishConnect(this.f40194fd);
        if (finishConnect < 0) {
            if (finishConnect == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
                return false;
            }
            Errors.throwConnectException("finishConnect", FINISH_CONNECT_REFUSED_EXCEPTION, finishConnect);
            return true;
        }
        return true;
    }

    public int getReceiveBufferSize() throws IOException {
        return getReceiveBufferSize(this.f40194fd);
    }

    public int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.f40194fd);
    }

    public int getSoError() throws IOException {
        return getSoError(this.f40194fd);
    }

    public int getSoLinger() throws IOException {
        return getSoLinger(this.f40194fd);
    }

    public int getTcpDeferAccept() throws IOException {
        return getTcpDeferAccept(this.f40194fd);
    }

    public boolean isInputShutdown() {
        return FileDescriptor.isInputShutdown(this.state);
    }

    public boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.f40194fd) != 0;
    }

    public boolean isOutputShutdown() {
        return FileDescriptor.isOutputShutdown(this.state);
    }

    public boolean isShutdown() {
        int i = this.state;
        return FileDescriptor.isInputShutdown(i) && FileDescriptor.isOutputShutdown(i);
    }

    public boolean isTcpCork() throws IOException {
        return isTcpCork(this.f40194fd) != 0;
    }

    public boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.f40194fd) != 0;
    }

    public boolean isTcpQuickAck() throws IOException {
        return isTcpQuickAck(this.f40194fd) != 0;
    }

    public void listen(int i) throws IOException {
        int listen = listen(this.f40194fd, i);
        if (listen < 0) {
            throw Errors.newIOException("listen", listen);
        }
    }

    public InetSocketAddress localAddress() {
        byte[] localAddress = localAddress(this.f40194fd);
        if (localAddress == null) {
            return null;
        }
        return NativeInetAddress.address(localAddress, 0, localAddress.length);
    }

    public DatagramSocketAddress recvFrom(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return recvFrom(this.f40194fd, byteBuffer, i, i2);
    }

    public DatagramSocketAddress recvFromAddress(long j, int i, int i2) throws IOException {
        return recvFromAddress(this.f40194fd, j, i, i2);
    }

    public InetSocketAddress remoteAddress() {
        byte[] remoteAddress = remoteAddress(this.f40194fd);
        if (remoteAddress == null) {
            return null;
        }
        return NativeInetAddress.address(remoteAddress, 0, remoteAddress.length);
    }

    public int sendTo(ByteBuffer byteBuffer, int i, int i2, InetAddress inetAddress, int i3) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i4;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i4 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i4 = 0;
        }
        int sendTo = sendTo(this.f40194fd, byteBuffer, i, i2, ipv4MappedIpv6Address, i4, i3);
        return sendTo >= 0 ? sendTo : Errors.ioResult("sendTo", sendTo, SEND_TO_CONNECTION_RESET_EXCEPTION, SEND_TO_CLOSED_CHANNEL_EXCEPTION);
    }

    public int sendToAddress(long j, int i, int i2, InetAddress inetAddress, int i3) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i4;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i4 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i4 = 0;
        }
        int sendToAddress = sendToAddress(this.f40194fd, j, i, i2, ipv4MappedIpv6Address, i4, i3);
        return sendToAddress >= 0 ? sendToAddress : Errors.ioResult("sendToAddress", sendToAddress, SEND_TO_ADDRESS_CONNECTION_RESET_EXCEPTION, SEND_TO_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public int sendToAddresses(long j, int i, InetAddress inetAddress, int i2) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i3;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i3 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i3 = 0;
        }
        int sendToAddresses = sendToAddresses(this.f40194fd, j, i, ipv4MappedIpv6Address, i3, i2);
        return sendToAddresses >= 0 ? sendToAddresses : Errors.ioResult("sendToAddresses", sendToAddresses, CONNECTION_RESET_EXCEPTION_SENDMSG, SEND_TO_ADDRESSES_CLOSED_CHANNEL_EXCEPTION);
    }

    public void setKeepAlive(boolean z) throws IOException {
        setKeepAlive(this.f40194fd, z ? 1 : 0);
    }

    public void setReceiveBufferSize(int i) throws IOException {
        setReceiveBufferSize(this.f40194fd, i);
    }

    public void setSendBufferSize(int i) throws IOException {
        setSendBufferSize(this.f40194fd, i);
    }

    public void setSoLinger(int i) throws IOException {
        setSoLinger(this.f40194fd, i);
    }

    public void setTcpCork(boolean z) throws IOException {
        setTcpCork(this.f40194fd, z ? 1 : 0);
    }

    public void setTcpDeferAccept(int i) throws IOException {
        setTcpDeferAccept(this.f40194fd, i);
    }

    public void setTcpNoDelay(boolean z) throws IOException {
        setTcpNoDelay(this.f40194fd, z ? 1 : 0);
    }

    public void setTcpQuickAck(boolean z) throws IOException {
        setTcpQuickAck(this.f40194fd, z ? 1 : 0);
    }

    public void shutdown() throws IOException {
        shutdown(true, true);
    }

    @Override // io.netty.channel.unix.FileDescriptor
    public String toString() {
        return "Socket{fd=" + this.f40194fd + '}';
    }

    public void shutdown(boolean z, boolean z2) throws IOException {
        int i;
        int inputShutdown;
        do {
            i = this.state;
            inputShutdown = (!z || FileDescriptor.isInputShutdown(i)) ? i : FileDescriptor.inputShutdown(i);
            if (z2 && !FileDescriptor.isOutputShutdown(inputShutdown)) {
                inputShutdown = FileDescriptor.outputShutdown(inputShutdown);
            }
            if (inputShutdown == i) {
                return;
            }
        } while (!casState(i, inputShutdown));
        int shutdown = shutdown(this.f40194fd, z, z2);
        if (shutdown < 0) {
            Errors.ioResult("shutdown", shutdown, CONNECTION_RESET_SHUTDOWN_EXCEPTION, SHUTDOWN_CLOSED_CHANNEL_EXCEPTION);
        }
    }
}
