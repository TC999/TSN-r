package io.netty.channel.epoll;

import io.netty.channel.ChannelOption;
import io.netty.channel.unix.DomainSocketReadMode;
import java.net.InetAddress;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> TCP_CORK = ChannelOption.valueOf(EpollChannelOption.class, "TCP_CORK");
    public static final ChannelOption<Boolean> SO_REUSEPORT = ChannelOption.valueOf(EpollChannelOption.class, "SO_REUSEPORT");
    public static final ChannelOption<Long> TCP_NOTSENT_LOWAT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_NOTSENT_LOWAT");
    public static final ChannelOption<Integer> TCP_KEEPIDLE = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPIDLE");
    public static final ChannelOption<Integer> TCP_KEEPINTVL = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPINTVL");
    public static final ChannelOption<Integer> TCP_KEEPCNT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_KEEPCNT");
    public static final ChannelOption<Integer> TCP_USER_TIMEOUT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_USER_TIMEOUT");
    public static final ChannelOption<Boolean> IP_FREEBIND = ChannelOption.valueOf("IP_FREEBIND");
    public static final ChannelOption<Integer> TCP_FASTOPEN = ChannelOption.valueOf(EpollChannelOption.class, "TCP_FASTOPEN");
    public static final ChannelOption<Integer> TCP_DEFER_ACCEPT = ChannelOption.valueOf(EpollChannelOption.class, "TCP_DEFER_ACCEPT");
    public static final ChannelOption<Boolean> TCP_QUICKACK = ChannelOption.valueOf(EpollChannelOption.class, "TCP_QUICKACK");
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(EpollChannelOption.class, "DOMAIN_SOCKET_READ_MODE");
    public static final ChannelOption<EpollMode> EPOLL_MODE = ChannelOption.valueOf(EpollChannelOption.class, "EPOLL_MODE");
    public static final ChannelOption<Map<InetAddress, byte[]>> TCP_MD5SIG = ChannelOption.valueOf("TCP_MD5SIG");

    private EpollChannelOption() {
        super(null);
    }
}
