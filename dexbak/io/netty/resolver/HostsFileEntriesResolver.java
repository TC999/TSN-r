package io.netty.resolver;

import java.net.InetAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface HostsFileEntriesResolver {
    public static final HostsFileEntriesResolver DEFAULT = new DefaultHostsFileEntriesResolver();

    InetAddress address(String str);
}
