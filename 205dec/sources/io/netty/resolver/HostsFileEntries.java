package io.netty.resolver;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class HostsFileEntries {
    static final HostsFileEntries EMPTY = new HostsFileEntries(Collections.emptyMap(), Collections.emptyMap());
    private final Map<String, Inet4Address> inet4Entries;
    private final Map<String, Inet6Address> inet6Entries;

    public HostsFileEntries(Map<String, Inet4Address> map, Map<String, Inet6Address> map2) {
        this.inet4Entries = Collections.unmodifiableMap(new HashMap(map));
        this.inet6Entries = Collections.unmodifiableMap(new HashMap(map2));
    }

    public Map<String, Inet4Address> inet4Entries() {
        return this.inet4Entries;
    }

    public Map<String, Inet6Address> inet6Entries() {
        return this.inet6Entries;
    }
}
