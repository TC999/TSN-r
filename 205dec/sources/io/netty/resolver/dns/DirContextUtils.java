package io.netty.resolver.dns;

import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.List;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class DirContextUtils {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DirContextUtils.class);

    private DirContextUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addNameServers(List<InetSocketAddress> list, int i4) {
        String[] split;
        URI uri;
        String host;
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        hashtable.put("java.naming.provider.url", "dns://");
        try {
            String str = (String) new InitialDirContext(hashtable).getEnvironment().get("java.naming.provider.url");
            if (str == null || str.isEmpty()) {
                return;
            }
            for (String str2 : str.split(" ")) {
                try {
                    uri = new URI(str2);
                    host = new URI(str2).getHost();
                } catch (URISyntaxException e4) {
                    logger.debug("Skipping a malformed nameserver URI: {}", str2, e4);
                }
                if (host != null && !host.isEmpty()) {
                    int port = uri.getPort();
                    String host2 = uri.getHost();
                    if (port == -1) {
                        port = i4;
                    }
                    list.add(SocketUtils.socketAddress(host2, port));
                }
                logger.debug("Skipping a nameserver URI as host portion could not be extracted: {}", str2);
            }
        } catch (NamingException unused) {
        }
    }
}
