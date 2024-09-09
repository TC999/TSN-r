package io.netty.channel.unix;

import io.netty.channel.ChannelOption;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class UnixChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> SO_REUSEPORT = ChannelOption.valueOf(UnixChannelOption.class, "SO_REUSEPORT");
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(UnixChannelOption.class, "DOMAIN_SOCKET_READ_MODE");

    /* JADX INFO: Access modifiers changed from: protected */
    public UnixChannelOption() {
        super(null);
    }
}
