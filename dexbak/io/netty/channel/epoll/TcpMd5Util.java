package io.netty.channel.epoll;

import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class TcpMd5Util {
    private TcpMd5Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection<InetAddress> newTcpMd5Sigs(AbstractEpollChannel abstractEpollChannel, Collection<InetAddress> collection, Map<InetAddress, byte[]> map) throws IOException {
        ObjectUtil.checkNotNull(abstractEpollChannel, "channel");
        ObjectUtil.checkNotNull(collection, "current");
        ObjectUtil.checkNotNull(map, "newKeys");
        for (Map.Entry<InetAddress, byte[]> entry : map.entrySet()) {
            byte[] value = entry.getValue();
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("newKeys contains an entry with null address: " + map);
            } else if (value != null) {
                if (value.length != 0) {
                    int length = value.length;
                    int i = Native.TCP_MD5SIG_MAXKEYLEN;
                    if (length > i) {
                        throw new IllegalArgumentException("newKeys[" + entry.getKey() + "] has a key with invalid length; should not exceed the maximum length (" + i + ')');
                    }
                } else {
                    throw new IllegalArgumentException("newKeys[" + entry.getKey() + "] has an empty key.");
                }
            } else {
                throw new NullPointerException("newKeys[" + entry.getKey() + ']');
            }
        }
        for (InetAddress inetAddress : collection) {
            if (!map.containsKey(inetAddress)) {
                Native.setTcpMd5Sig(abstractEpollChannel.mo12687fd().intValue(), inetAddress, null);
            }
        }
        if (map.isEmpty()) {
            return Collections.emptySet();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<InetAddress, byte[]> entry2 : map.entrySet()) {
            Native.setTcpMd5Sig(abstractEpollChannel.mo12687fd().intValue(), entry2.getKey(), entry2.getValue());
            arrayList.add(entry2.getKey());
        }
        return arrayList;
    }
}
