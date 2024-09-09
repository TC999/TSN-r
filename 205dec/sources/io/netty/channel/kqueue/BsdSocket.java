package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class BsdSocket extends Socket {
    private static final int APPLE_SND_LOW_AT_MAX = 131072;
    static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
    private static final int FREEBSD_SND_LOW_AT_MAX = 32768;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BsdSocket(int i4) {
        super(i4);
    }

    private static native String[] getAcceptFilter(int i4) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i4) throws IOException;

    private static native int getSndLowAt(int i4) throws IOException;

    private static native int getTcpNoPush(int i4) throws IOException;

    public static BsdSocket newSocketDgram() {
        return new BsdSocket(Socket.newSocketDgram0());
    }

    public static BsdSocket newSocketDomain() {
        return new BsdSocket(Socket.newSocketDomain0());
    }

    public static BsdSocket newSocketStream() {
        return new BsdSocket(Socket.newSocketStream0());
    }

    private static native long sendFile(int i4, DefaultFileRegion defaultFileRegion, long j4, long j5, long j6) throws IOException;

    private static native void setAcceptFilter(int i4, String str, String str2) throws IOException;

    private static native void setSndLowAt(int i4, int i5) throws IOException;

    private static native void setTcpNoPush(int i4, int i5) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AcceptFilter getAcceptFilter() throws IOException {
        String[] acceptFilter = getAcceptFilter(intValue());
        return acceptFilter == null ? AcceptFilter.PLATFORM_UNSUPPORTED : new AcceptFilter(acceptFilter[0], acceptFilter[1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSndLowAt() throws IOException {
        return getSndLowAt(intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTcpNoPush() throws IOException {
        return getTcpNoPush(intValue()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long sendFile(DefaultFileRegion defaultFileRegion, long j4, long j5, long j6) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j4, j5, j6);
        return sendFile >= 0 ? sendFile : Errors.ioResult("sendfile", (int) sendFile);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAcceptFilter(AcceptFilter acceptFilter) throws IOException {
        setAcceptFilter(intValue(), acceptFilter.filterName(), acceptFilter.filterArgs());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSndLowAt(int i4) throws IOException {
        setSndLowAt(intValue(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTcpNoPush(boolean z3) throws IOException {
        setTcpNoPush(intValue(), z3 ? 1 : 0);
    }
}
