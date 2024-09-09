package io.netty.channel.epoll;

import io.netty.channel.ChannelException;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class LinuxSocket extends Socket {
    static final InetAddress INET6_ANY = unsafeInetAddrByName("::");
    private static final InetAddress INET_ANY = unsafeInetAddrByName("0.0.0.0");
    private static final long MAX_UINT32_T = 4294967295L;

    LinuxSocket(int i4) {
        super(i4);
    }

    private static InetAddress deriveInetAddress(NetworkInterface networkInterface, boolean z3) {
        InetAddress inetAddress = z3 ? INET6_ANY : INET_ANY;
        if (networkInterface != null) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if ((nextElement instanceof Inet6Address) == z3) {
                    return nextElement;
                }
            }
        }
        return inetAddress;
    }

    private InternetProtocolFamily family() {
        return ((Socket) this).ipv6 ? InternetProtocolFamily.IPv6 : InternetProtocolFamily.IPv4;
    }

    private static native int getInterface(int i4, boolean z3);

    private static native int getIpMulticastLoop(int i4, boolean z3) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i4) throws IOException;

    private static native int getSoBusyPoll(int i4) throws IOException;

    private static native int getTcpDeferAccept(int i4) throws IOException;

    private static native void getTcpInfo(int i4, long[] jArr) throws IOException;

    private static native int getTcpKeepCnt(int i4) throws IOException;

    private static native int getTcpKeepIdle(int i4) throws IOException;

    private static native int getTcpKeepIntvl(int i4) throws IOException;

    private static native int getTcpNotSentLowAt(int i4) throws IOException;

    private static native int getTcpUserTimeout(int i4) throws IOException;

    private static native int getTimeToLive(int i4) throws IOException;

    private static InetAddress inetAddress(int i4) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i4 >>> 24) & 255), (byte) ((i4 >>> 16) & 255), (byte) ((i4 >>> 8) & 255), (byte) (i4 & 255)});
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private static int interfaceIndex(NetworkInterface networkInterface) {
        if (PlatformDependent.javaVersion() >= 7) {
            return networkInterface.getIndex();
        }
        return -1;
    }

    private static native int isIpFreeBind(int i4) throws IOException;

    private static native int isIpRecvOrigDestAddr(int i4) throws IOException;

    private static native int isIpTransparent(int i4) throws IOException;

    private static native int isTcpCork(int i4) throws IOException;

    private static native int isTcpFastOpenConnect(int i4) throws IOException;

    private static native int isTcpQuickAck(int i4) throws IOException;

    private static native void joinGroup(int i4, boolean z3, byte[] bArr, byte[] bArr2, int i5, int i6) throws IOException;

    private static native void joinSsmGroup(int i4, boolean z3, byte[] bArr, byte[] bArr2, int i5, int i6, byte[] bArr3) throws IOException;

    private static native void leaveGroup(int i4, boolean z3, byte[] bArr, byte[] bArr2, int i5, int i6) throws IOException;

    private static native void leaveSsmGroup(int i4, boolean z3, byte[] bArr, byte[] bArr2, int i5, int i6, byte[] bArr3) throws IOException;

    public static LinuxSocket newSocketDgram(boolean z3) {
        return new LinuxSocket(Socket.newSocketDgram0(z3));
    }

    public static LinuxSocket newSocketDomain() {
        return new LinuxSocket(Socket.newSocketDomain0());
    }

    public static LinuxSocket newSocketStream(boolean z3) {
        return new LinuxSocket(Socket.newSocketStream0(z3));
    }

    private static native long sendFile(int i4, DefaultFileRegion defaultFileRegion, long j4, long j5, long j6) throws IOException;

    private static native void setInterface(int i4, boolean z3, byte[] bArr, int i5, int i6) throws IOException;

    private static native void setIpFreeBind(int i4, int i5) throws IOException;

    private static native void setIpMulticastLoop(int i4, boolean z3, int i5) throws IOException;

    private static native void setIpRecvOrigDestAddr(int i4, int i5) throws IOException;

    private static native void setIpTransparent(int i4, int i5) throws IOException;

    private static native void setSoBusyPoll(int i4, int i5) throws IOException;

    private static native void setTcpCork(int i4, int i5) throws IOException;

    private static native void setTcpDeferAccept(int i4, int i5) throws IOException;

    private static native void setTcpFastOpen(int i4, int i5) throws IOException;

    private static native void setTcpFastOpenConnect(int i4, int i5) throws IOException;

    private static native void setTcpKeepCnt(int i4, int i5) throws IOException;

    private static native void setTcpKeepIdle(int i4, int i5) throws IOException;

    private static native void setTcpKeepIntvl(int i4, int i5) throws IOException;

    private static native void setTcpMd5Sig(int i4, boolean z3, byte[] bArr, int i5, byte[] bArr2) throws IOException;

    private static native void setTcpNotSentLowAt(int i4, int i5) throws IOException;

    private static native void setTcpQuickAck(int i4, int i5) throws IOException;

    private static native void setTcpUserTimeout(int i4, int i5) throws IOException;

    private static native void setTimeToLive(int i4, int i5) throws IOException;

    private static InetAddress unsafeInetAddrByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e4) {
            throw new ChannelException(e4);
        }
    }

    InetAddress getInterface() throws IOException {
        NetworkInterface networkInterface = getNetworkInterface();
        if (networkInterface != null) {
            Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
            if (addressesFromNetworkInterface.hasMoreElements()) {
                return addressesFromNetworkInterface.nextElement();
            }
            return null;
        }
        return null;
    }

    NetworkInterface getNetworkInterface() throws IOException {
        int i4 = getInterface(intValue(), ((Socket) this).ipv6);
        if (((Socket) this).ipv6) {
            if (PlatformDependent.javaVersion() >= 7) {
                return NetworkInterface.getByIndex(i4);
            }
            return null;
        }
        InetAddress inetAddress = inetAddress(i4);
        if (inetAddress != null) {
            return NetworkInterface.getByInetAddress(inetAddress);
        }
        return null;
    }

    PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    int getSoBusyPoll() throws IOException {
        return getSoBusyPoll(intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public int getTcpDeferAccept() throws IOException {
        return getTcpDeferAccept(intValue());
    }

    void getTcpInfo(EpollTcpInfo epollTcpInfo) throws IOException {
        getTcpInfo(intValue(), epollTcpInfo.info);
    }

    int getTcpKeepCnt() throws IOException {
        return getTcpKeepCnt(intValue());
    }

    int getTcpKeepIdle() throws IOException {
        return getTcpKeepIdle(intValue());
    }

    int getTcpKeepIntvl() throws IOException {
        return getTcpKeepIntvl(intValue());
    }

    long getTcpNotSentLowAt() throws IOException {
        return getTcpNotSentLowAt(intValue()) & 4294967295L;
    }

    int getTcpUserTimeout() throws IOException {
        return getTcpUserTimeout(intValue());
    }

    int getTimeToLive() throws IOException {
        return getTimeToLive(intValue());
    }

    boolean isIpFreeBind() throws IOException {
        return isIpFreeBind(intValue()) != 0;
    }

    boolean isIpRecvOrigDestAddr() throws IOException {
        return isIpRecvOrigDestAddr(intValue()) != 0;
    }

    boolean isIpTransparent() throws IOException {
        return isIpTransparent(intValue()) != 0;
    }

    boolean isLoopbackModeDisabled() throws IOException {
        return getIpMulticastLoop(intValue(), ((Socket) this).ipv6) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public boolean isTcpCork() throws IOException {
        return isTcpCork(intValue()) != 0;
    }

    boolean isTcpFastOpenConnect() throws IOException {
        return isTcpFastOpenConnect(intValue()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public boolean isTcpQuickAck() throws IOException {
        return isTcpQuickAck(intValue()) != 0;
    }

    void joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        NativeInetAddress newInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, inetAddress instanceof Inet6Address));
        if (inetAddress2 != null) {
            joinSsmGroup(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
            return;
        }
        joinGroup(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
    }

    void leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        NativeInetAddress newInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, inetAddress instanceof Inet6Address));
        if (inetAddress2 != null) {
            leaveSsmGroup(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
            return;
        }
        leaveGroup(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
    }

    long sendFile(DefaultFileRegion defaultFileRegion, long j4, long j5, long j6) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j4, j5, j6);
        return sendFile >= 0 ? sendFile : Errors.ioResult("sendfile", (int) sendFile);
    }

    int sendmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i4, int i5) throws IOException {
        return Native.sendmmsg(intValue(), ((Socket) this).ipv6, nativeDatagramPacketArr, i4, i5);
    }

    void setInterface(InetAddress inetAddress) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        setInterface(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance.scopeId(), interfaceIndex(inetAddress));
    }

    void setIpFreeBind(boolean z3) throws IOException {
        setIpFreeBind(intValue(), z3 ? 1 : 0);
    }

    void setIpRecvOrigDestAddr(boolean z3) throws IOException {
        setIpRecvOrigDestAddr(intValue(), z3 ? 1 : 0);
    }

    void setIpTransparent(boolean z3) throws IOException {
        setIpTransparent(intValue(), z3 ? 1 : 0);
    }

    void setLoopbackModeDisabled(boolean z3) throws IOException {
        setIpMulticastLoop(intValue(), ((Socket) this).ipv6, !z3 ? 1 : 0);
    }

    void setNetworkInterface(NetworkInterface networkInterface) throws IOException {
        InetAddress deriveInetAddress = deriveInetAddress(networkInterface, family() == InternetProtocolFamily.IPv6);
        if (!deriveInetAddress.equals(family() == InternetProtocolFamily.IPv4 ? INET_ANY : INET6_ANY)) {
            NativeInetAddress newInstance = NativeInetAddress.newInstance(deriveInetAddress);
            setInterface(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
            return;
        }
        throw new IOException("NetworkInterface does not support " + family());
    }

    void setSoBusyPoll(int i4) throws IOException {
        setSoBusyPoll(intValue(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public void setTcpCork(boolean z3) throws IOException {
        setTcpCork(intValue(), z3 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public void setTcpDeferAccept(int i4) throws IOException {
        setTcpDeferAccept(intValue(), i4);
    }

    void setTcpFastOpen(int i4) throws IOException {
        setTcpFastOpen(intValue(), i4);
    }

    void setTcpFastOpenConnect(boolean z3) throws IOException {
        setTcpFastOpenConnect(intValue(), z3 ? 1 : 0);
    }

    void setTcpKeepCnt(int i4) throws IOException {
        setTcpKeepCnt(intValue(), i4);
    }

    void setTcpKeepIdle(int i4) throws IOException {
        setTcpKeepIdle(intValue(), i4);
    }

    void setTcpKeepIntvl(int i4) throws IOException {
        setTcpKeepIntvl(intValue(), i4);
    }

    void setTcpMd5Sig(InetAddress inetAddress, byte[] bArr) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        setTcpMd5Sig(intValue(), ((Socket) this).ipv6, newInstance.address(), newInstance.scopeId(), bArr);
    }

    void setTcpNotSentLowAt(long j4) throws IOException {
        if (j4 >= 0 && j4 <= 4294967295L) {
            setTcpNotSentLowAt(intValue(), (int) j4);
            return;
        }
        throw new IllegalArgumentException("tcpNotSentLowAt must be a uint32_t");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.channel.unix.Socket
    public void setTcpQuickAck(boolean z3) throws IOException {
        setTcpQuickAck(intValue(), z3 ? 1 : 0);
    }

    void setTcpUserTimeout(int i4) throws IOException {
        setTcpUserTimeout(intValue(), i4);
    }

    void setTimeToLive(int i4) throws IOException {
        setTimeToLive(intValue(), i4);
    }

    private static int interfaceIndex(InetAddress inetAddress) throws IOException {
        NetworkInterface byInetAddress;
        if (PlatformDependent.javaVersion() < 7 || (byInetAddress = NetworkInterface.getByInetAddress(inetAddress)) == null) {
            return -1;
        }
        return byInetAddress.getIndex();
    }

    public static LinuxSocket newSocketDgram() {
        return newSocketDgram(Socket.isIPv6Preferred());
    }

    public static LinuxSocket newSocketStream() {
        return newSocketStream(Socket.isIPv6Preferred());
    }
}
