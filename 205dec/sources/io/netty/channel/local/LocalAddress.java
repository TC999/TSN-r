package io.netty.channel.local;

import io.netty.channel.Channel;
import java.net.SocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;
    private final String id;
    private final String strVal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalAddress(Channel channel) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("local:E");
        sb.append(Long.toHexString((channel.hashCode() & 4294967295L) | 4294967296L));
        sb.setCharAt(7, ':');
        this.id = sb.substring(6);
        this.strVal = sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.id.equals(((LocalAddress) obj).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String id() {
        return this.id;
    }

    public String toString() {
        return this.strVal;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.id.compareTo(localAddress.id);
    }

    public LocalAddress(String str) {
        if (str != null) {
            String lowerCase = str.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                this.id = lowerCase;
                this.strVal = "local:" + lowerCase;
                return;
            }
            throw new IllegalArgumentException("empty id");
        }
        throw new NullPointerException("id");
    }
}
