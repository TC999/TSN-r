package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class DnsServerAddressStreamProviders {
    private static final long REFRESH_INTERVAL = TimeUnit.MINUTES.toNanos(5);
    private static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = new DnsServerAddressStreamProvider() { // from class: io.netty.resolver.dns.DnsServerAddressStreamProviders.1
        private volatile DnsServerAddressStreamProvider currentProvider = provider();
        private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());

        private DnsServerAddressStreamProvider provider() {
            return PlatformDependent.isWindows() ? DefaultDnsServerAddressStreamProvider.INSTANCE : UnixResolverDnsServerAddressStreamProvider.parseSilently();
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
        public DnsServerAddressStream nameServerAddressStream(String str) {
            long j4 = this.lastRefresh.get();
            DnsServerAddressStreamProvider dnsServerAddressStreamProvider = this.currentProvider;
            if (System.nanoTime() - j4 > DnsServerAddressStreamProviders.REFRESH_INTERVAL && this.lastRefresh.compareAndSet(j4, System.nanoTime())) {
                dnsServerAddressStreamProvider = provider();
                this.currentProvider = dnsServerAddressStreamProvider;
            }
            return dnsServerAddressStreamProvider.nameServerAddressStream(str);
        }
    };

    private DnsServerAddressStreamProviders() {
    }

    public static DnsServerAddressStreamProvider platformDefault() {
        return DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
    }
}
