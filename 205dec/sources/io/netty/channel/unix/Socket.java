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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
        int i4 = Errors.ERRNO_EPIPE_NEGATIVE;
        SEND_TO_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendto(...)", i4), Socket.class, "sendTo(...)");
        SEND_TO_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendto(...)", i4), Socket.class, "sendToAddress(...)");
        CONNECTION_RESET_EXCEPTION_SENDMSG = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:sendmsg(...)", i4), Socket.class, "sendToAddresses(...)");
        CONNECTION_RESET_SHUTDOWN_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:shutdown(...)", Errors.ERRNO_ECONNRESET_NEGATIVE), Socket.class, "shutdown(...)");
        int i5 = Errors.ERROR_ECONNREFUSED_NEGATIVE;
        FINISH_CONNECT_REFUSED_EXCEPTION = (Errors.NativeConnectException) ThrowableUtil.unknownStackTrace(new Errors.NativeConnectException("syscall:getsockopt(...)", i5), Socket.class, "finishConnect(...)");
        CONNECT_REFUSED_EXCEPTION = (Errors.NativeConnectException) ThrowableUtil.unknownStackTrace(new Errors.NativeConnectException("syscall:connect(...)", i5), Socket.class, "connect(...)");
    }

    public Socket(int i4) {
        super(i4);
    }

    private static native int accept(int i4, byte[] bArr);

    private static native int bind(int i4, byte[] bArr, int i5, int i6);

    private static native int bindDomainSocket(int i4, byte[] bArr);

    private static native int connect(int i4, byte[] bArr, int i5, int i6);

    private static native int connectDomainSocket(int i4, byte[] bArr);

    private static native int finishConnect(int i4);

    private static native int getReceiveBufferSize(int i4) throws IOException;

    private static native int getSendBufferSize(int i4) throws IOException;

    private static native int getSoError(int i4) throws IOException;

    private static native int getSoLinger(int i4) throws IOException;

    private static native int getTcpDeferAccept(int i4) throws IOException;

    private static native int isKeepAlive(int i4) throws IOException;

    private static native int isTcpCork(int i4) throws IOException;

    private static native int isTcpNoDelay(int i4) throws IOException;

    private static native int isTcpQuickAck(int i4) throws IOException;

    private static native int listen(int i4, int i5);

    private static native byte[] localAddress(int i4);

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

    private static native DatagramSocketAddress recvFrom(int i4, ByteBuffer byteBuffer, int i5, int i6) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i4, long j4, int i5, int i6) throws IOException;

    private static native byte[] remoteAddress(int i4);

    private static native int sendTo(int i4, ByteBuffer byteBuffer, int i5, int i6, byte[] bArr, int i7, int i8);

    private static native int sendToAddress(int i4, long j4, int i5, int i6, byte[] bArr, int i7, int i8);

    private static native int sendToAddresses(int i4, long j4, int i5, byte[] bArr, int i6, int i7);

    private static native void setKeepAlive(int i4, int i5) throws IOException;

    private static native void setReceiveBufferSize(int i4, int i5) throws IOException;

    private static native void setSendBufferSize(int i4, int i5) throws IOException;

    private static native void setSoLinger(int i4, int i5) throws IOException;

    private static native void setTcpCork(int i4, int i5) throws IOException;

    private static native void setTcpDeferAccept(int i4, int i5) throws IOException;

    private static native void setTcpNoDelay(int i4, int i5) throws IOException;

    private static native void setTcpQuickAck(int i4, int i5) throws IOException;

    private static native int shutdown(int i4, boolean z3, boolean z4);

    public int accept(byte[] bArr) throws IOException {
        int accept = accept(this.fd, bArr);
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
            int bind = bind(this.fd, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
            if (bind < 0) {
                throw Errors.newIOException("bind", bind);
            }
        } else if (socketAddress instanceof DomainSocketAddress) {
            int bindDomainSocket = bindDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
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
            connectDomainSocket = connect(this.fd, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
        } else if (socketAddress instanceof DomainSocketAddress) {
            connectDomainSocket = connectDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
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
        int finishConnect = finishConnect(this.fd);
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
        return getReceiveBufferSize(this.fd);
    }

    public int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.fd);
    }

    public int getSoError() throws IOException {
        return getSoError(this.fd);
    }

    public int getSoLinger() throws IOException {
        return getSoLinger(this.fd);
    }

    public int getTcpDeferAccept() throws IOException {
        return getTcpDeferAccept(this.fd);
    }

    public boolean isInputShutdown() {
        return FileDescriptor.isInputShutdown(this.state);
    }

    public boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.fd) != 0;
    }

    public boolean isOutputShutdown() {
        return FileDescriptor.isOutputShutdown(this.state);
    }

    public boolean isShutdown() {
        int i4 = this.state;
        return FileDescriptor.isInputShutdown(i4) && FileDescriptor.isOutputShutdown(i4);
    }

    public boolean isTcpCork() throws IOException {
        return isTcpCork(this.fd) != 0;
    }

    public boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.fd) != 0;
    }

    public boolean isTcpQuickAck() throws IOException {
        return isTcpQuickAck(this.fd) != 0;
    }

    public void listen(int i4) throws IOException {
        int listen = listen(this.fd, i4);
        if (listen < 0) {
            throw Errors.newIOException("listen", listen);
        }
    }

    public InetSocketAddress localAddress() {
        byte[] localAddress = localAddress(this.fd);
        if (localAddress == null) {
            return null;
        }
        return NativeInetAddress.address(localAddress, 0, localAddress.length);
    }

    public DatagramSocketAddress recvFrom(ByteBuffer byteBuffer, int i4, int i5) throws IOException {
        return recvFrom(this.fd, byteBuffer, i4, i5);
    }

    public DatagramSocketAddress recvFromAddress(long j4, int i4, int i5) throws IOException {
        return recvFromAddress(this.fd, j4, i4, i5);
    }

    public InetSocketAddress remoteAddress() {
        byte[] remoteAddress = remoteAddress(this.fd);
        if (remoteAddress == null) {
            return null;
        }
        return NativeInetAddress.address(remoteAddress, 0, remoteAddress.length);
    }

    public int sendTo(ByteBuffer byteBuffer, int i4, int i5, InetAddress inetAddress, int i6) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i7;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i7 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i7 = 0;
        }
        int sendTo = sendTo(this.fd, byteBuffer, i4, i5, ipv4MappedIpv6Address, i7, i6);
        return sendTo >= 0 ? sendTo : Errors.ioResult("sendTo", sendTo, SEND_TO_CONNECTION_RESET_EXCEPTION, SEND_TO_CLOSED_CHANNEL_EXCEPTION);
    }

    public int sendToAddress(long j4, int i4, int i5, InetAddress inetAddress, int i6) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i7;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i7 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i7 = 0;
        }
        int sendToAddress = sendToAddress(this.fd, j4, i4, i5, ipv4MappedIpv6Address, i7, i6);
        return sendToAddress >= 0 ? sendToAddress : Errors.ioResult("sendToAddress", sendToAddress, SEND_TO_ADDRESS_CONNECTION_RESET_EXCEPTION, SEND_TO_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public int sendToAddresses(long j4, int i4, InetAddress inetAddress, int i5) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i6;
        if (inetAddress instanceof Inet6Address) {
            byte[] address = inetAddress.getAddress();
            i6 = ((Inet6Address) inetAddress).getScopeId();
            ipv4MappedIpv6Address = address;
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i6 = 0;
        }
        int sendToAddresses = sendToAddresses(this.fd, j4, i4, ipv4MappedIpv6Address, i6, i5);
        return sendToAddresses >= 0 ? sendToAddresses : Errors.ioResult("sendToAddresses", sendToAddresses, CONNECTION_RESET_EXCEPTION_SENDMSG, SEND_TO_ADDRESSES_CLOSED_CHANNEL_EXCEPTION);
    }

    public void setKeepAlive(boolean z3) throws IOException {
        setKeepAlive(this.fd, z3 ? 1 : 0);
    }

    public void setReceiveBufferSize(int i4) throws IOException {
        setReceiveBufferSize(this.fd, i4);
    }

    public void setSendBufferSize(int i4) throws IOException {
        setSendBufferSize(this.fd, i4);
    }

    public void setSoLinger(int i4) throws IOException {
        setSoLinger(this.fd, i4);
    }

    public void setTcpCork(boolean z3) throws IOException {
        setTcpCork(this.fd, z3 ? 1 : 0);
    }

    public void setTcpDeferAccept(int i4) throws IOException {
        setTcpDeferAccept(this.fd, i4);
    }

    public void setTcpNoDelay(boolean z3) throws IOException {
        setTcpNoDelay(this.fd, z3 ? 1 : 0);
    }

    public void setTcpQuickAck(boolean z3) throws IOException {
        setTcpQuickAck(this.fd, z3 ? 1 : 0);
    }

    public void shutdown() throws IOException {
        shutdown(true, true);
    }

    @Override // io.netty.channel.unix.FileDescriptor
    public String toString() {
        return "Socket{fd=" + this.fd + '}';
    }

    public void shutdown(boolean z3, boolean z4) throws IOException {
        int i4;
        int inputShutdown;
        do {
            i4 = this.state;
            inputShutdown = (!z3 || FileDescriptor.isInputShutdown(i4)) ? i4 : FileDescriptor.inputShutdown(i4);
            if (z4 && !FileDescriptor.isOutputShutdown(inputShutdown)) {
                inputShutdown = FileDescriptor.outputShutdown(inputShutdown);
            }
            if (inputShutdown == i4) {
                return;
            }
        } while (!casState(i4, inputShutdown));
        int shutdown = shutdown(this.fd, z3, z4);
        if (shutdown < 0) {
            Errors.ioResult("shutdown", shutdown, CONNECTION_RESET_SHUTDOWN_EXCEPTION, SHUTDOWN_CLOSED_CHANNEL_EXCEPTION);
        }
    }
}
