package io.netty.resolver;

import java.net.InetAddress;
import java.util.Locale;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private final Map<String, InetAddress> entries = HostsFileParser.parseSilently();

    @Override // io.netty.resolver.HostsFileEntriesResolver
    public InetAddress address(String str) {
        return this.entries.get(str.toLowerCase(Locale.ENGLISH));
    }
}
