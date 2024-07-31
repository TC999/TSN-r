package io.netty.channel.epoll;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Native {
    public static final int EPOLLERR;
    public static final int EPOLLET;
    public static final int EPOLLIN;
    public static final int EPOLLOUT;
    public static final int EPOLLRDHUP;
    public static final int IOV_MAX;
    public static final boolean IS_SUPPORTING_SENDMMSG;
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    public static final String KERNEL_VERSION;
    private static final ClosedChannelException SENDFILE_CLOSED_CHANNEL_EXCEPTION;
    private static final Errors.NativeIoException SENDFILE_CONNECTION_RESET_EXCEPTION;
    private static final ClosedChannelException SENDMMSG_CLOSED_CHANNEL_EXCEPTION;
    private static final Errors.NativeIoException SENDMMSG_CONNECTION_RESET_EXCEPTION;
    private static final ClosedChannelException SPLICE_CLOSED_CHANNEL_EXCEPTION;
    private static final Errors.NativeIoException SPLICE_CONNECTION_RESET_EXCEPTION;
    public static final long SSIZE_MAX;
    public static final int TCP_MD5SIG_MAXKEYLEN;
    public static final int UIO_MAX_IOV;

    static {
        try {
            offsetofEpollData();
        } catch (UnsatisfiedLinkError unused) {
            loadNativeLibrary();
        }
        EPOLLIN = NativeStaticallyReferencedJniMethods.epollin();
        EPOLLOUT = NativeStaticallyReferencedJniMethods.epollout();
        EPOLLRDHUP = NativeStaticallyReferencedJniMethods.epollrdhup();
        EPOLLET = NativeStaticallyReferencedJniMethods.epollet();
        EPOLLERR = NativeStaticallyReferencedJniMethods.epollerr();
        IOV_MAX = NativeStaticallyReferencedJniMethods.iovMax();
        UIO_MAX_IOV = NativeStaticallyReferencedJniMethods.uioMaxIov();
        IS_SUPPORTING_SENDMMSG = NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
        IS_SUPPORTING_TCP_FASTOPEN = NativeStaticallyReferencedJniMethods.isSupportingTcpFastopen();
        SSIZE_MAX = NativeStaticallyReferencedJniMethods.ssizeMax();
        TCP_MD5SIG_MAXKEYLEN = NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
        KERNEL_VERSION = NativeStaticallyReferencedJniMethods.kernelVersion();
        SENDFILE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Native.class, "sendfile(...)");
        SENDMMSG_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Native.class, "sendmmsg(...)");
        SPLICE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Native.class, "splice(...)");
        int i = Errors.ERRNO_EPIPE_NEGATIVE;
        SENDFILE_CONNECTION_RESET_EXCEPTION = Errors.newConnectionResetException("syscall:sendfile(...)", i);
        SENDMMSG_CONNECTION_RESET_EXCEPTION = Errors.newConnectionResetException("syscall:sendmmsg(...)", i);
        SPLICE_CONNECTION_RESET_EXCEPTION = Errors.newConnectionResetException("syscall:splice(...)", i);
    }

    private Native() {
    }

    private static native int epollCreate();

    public static void epollCtlAdd(int i, int i2, int i3) throws IOException {
        int epollCtlAdd0 = epollCtlAdd0(i, i2, i3);
        if (epollCtlAdd0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlAdd0);
        }
    }

    private static native int epollCtlAdd0(int i, int i2, int i3);

    public static void epollCtlDel(int i, int i2) throws IOException {
        int epollCtlDel0 = epollCtlDel0(i, i2);
        if (epollCtlDel0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlDel0);
        }
    }

    private static native int epollCtlDel0(int i, int i2);

    public static void epollCtlMod(int i, int i2, int i3) throws IOException {
        int epollCtlMod0 = epollCtlMod0(i, i2, i3);
        if (epollCtlMod0 < 0) {
            throw Errors.newIOException("epoll_ctl", epollCtlMod0);
        }
    }

    private static native int epollCtlMod0(int i, int i2, int i3);

    public static int epollWait(int i, EpollEventArray epollEventArray, int i2) throws IOException {
        int epollWait0 = epollWait0(i, epollEventArray.memoryAddress(), epollEventArray.length(), i2);
        if (epollWait0 >= 0) {
            return epollWait0;
        }
        throw Errors.newIOException("epoll_wait", epollWait0);
    }

    private static native int epollWait0(int i, long j, int i2, int i3);

    private static native int eventFd();

    public static native void eventFdRead(int i);

    public static native void eventFdWrite(int i, long j);

    public static native int getTcpKeepCnt(int i) throws IOException;

    public static native int getTcpKeepIdle(int i) throws IOException;

    public static native int getTcpKeepIntvl(int i) throws IOException;

    public static native int getTcpNotSentLowAt(int i) throws IOException;

    public static native int getTcpUserTimeout(int i) throws IOException;

    public static native int getTrafficClass(int i) throws IOException;

    public static native int isBroadcast(int i) throws IOException;

    public static native int isIpFreeBind(int i) throws IOException;

    public static native int isReuseAddress(int i) throws IOException;

    public static native int isReusePort(int i) throws IOException;

    private static void loadNativeLibrary() {
        if (SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim().startsWith("linux")) {
            NativeLibraryLoader.load(SystemPropertyUtil.get("io.netty.packagePrefix", "").replace('.', '-') + "netty-transport-native-epoll", PlatformDependent.getClassLoader(Native.class));
            return;
        }
        throw new IllegalStateException("Only supported on Linux");
    }

    public static FileDescriptor newEpollCreate() {
        return new FileDescriptor(epollCreate());
    }

    public static FileDescriptor newEventFd() {
        return new FileDescriptor(eventFd());
    }

    public static native int offsetofEpollData();

    public static int recvFd(int i) throws IOException {
        int recvFd0 = recvFd0(i);
        if (recvFd0 > 0) {
            return recvFd0;
        }
        if (recvFd0 == 0) {
            return -1;
        }
        if (recvFd0 == Errors.ERRNO_EAGAIN_NEGATIVE || recvFd0 == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        throw Errors.newIOException("recvFd", recvFd0);
    }

    private static native int recvFd0(int i);

    public static int sendFd(int i, int i2) throws IOException {
        int sendFd0 = sendFd0(i, i2);
        if (sendFd0 >= 0) {
            return sendFd0;
        }
        if (sendFd0 == Errors.ERRNO_EAGAIN_NEGATIVE || sendFd0 == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("sendFd", sendFd0);
    }

    private static native int sendFd0(int i, int i2);

    public static long sendfile(int i, DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException {
        defaultFileRegion.open();
        long sendfile0 = sendfile0(i, defaultFileRegion, j, j2, j3);
        return sendfile0 >= 0 ? sendfile0 : Errors.ioResult("sendfile", (int) sendfile0, SENDFILE_CONNECTION_RESET_EXCEPTION, SENDFILE_CLOSED_CHANNEL_EXCEPTION);
    }

    private static native long sendfile0(int i, DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException;

    public static int sendmmsg(int i, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3) throws IOException {
        int sendmmsg0 = sendmmsg0(i, nativeDatagramPacketArr, i2, i3);
        return sendmmsg0 >= 0 ? sendmmsg0 : Errors.ioResult("sendmmsg", sendmmsg0, SENDMMSG_CONNECTION_RESET_EXCEPTION, SENDMMSG_CLOSED_CHANNEL_EXCEPTION);
    }

    private static native int sendmmsg0(int i, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i2, int i3);

    public static native void setBroadcast(int i, int i2) throws IOException;

    public static native void setIpFreeBind(int i, int i2) throws IOException;

    public static native void setReuseAddress(int i, int i2) throws IOException;

    public static native void setReusePort(int i, int i2) throws IOException;

    public static native void setTcpFastopen(int i, int i2) throws IOException;

    public static native void setTcpKeepCnt(int i, int i2) throws IOException;

    public static native void setTcpKeepIdle(int i, int i2) throws IOException;

    public static native void setTcpKeepIntvl(int i, int i2) throws IOException;

    public static void setTcpMd5Sig(int i, InetAddress inetAddress, byte[] bArr) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        setTcpMd5Sig0(i, newInstance.address(), newInstance.scopeId(), bArr);
    }

    private static native void setTcpMd5Sig0(int i, byte[] bArr, int i2, byte[] bArr2) throws IOException;

    public static native void setTcpNotSentLowAt(int i, int i2) throws IOException;

    public static native void setTcpUserTimeout(int i, int i2) throws IOException;

    public static native void setTrafficClass(int i, int i2) throws IOException;

    public static native int sizeofEpollEvent();

    public static int splice(int i, long j, int i2, long j2, long j3) throws IOException {
        int splice0 = splice0(i, j, i2, j2, j3);
        return splice0 >= 0 ? splice0 : Errors.ioResult("splice", splice0, SPLICE_CONNECTION_RESET_EXCEPTION, SPLICE_CLOSED_CHANNEL_EXCEPTION);
    }

    private static native int splice0(int i, long j, int i2, long j2, long j3);

    public static void tcpInfo(int i, EpollTcpInfo epollTcpInfo) throws IOException {
        tcpInfo0(i, epollTcpInfo.info);
    }

    private static native void tcpInfo0(int i, int[] iArr) throws IOException;
}
