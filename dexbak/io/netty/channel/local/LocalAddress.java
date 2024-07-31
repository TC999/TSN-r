package io.netty.channel.local;

import io.netty.channel.Channel;
import java.net.SocketAddress;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;

    /* renamed from: id */
    private final String f40186id;
    private final String strVal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalAddress(Channel channel) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("local:E");
        sb.append(Long.toHexString((channel.hashCode() & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
        sb.setCharAt(7, ':');
        this.f40186id = sb.substring(6);
        this.strVal = sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.f40186id.equals(((LocalAddress) obj).f40186id);
        }
        return false;
    }

    public int hashCode() {
        return this.f40186id.hashCode();
    }

    /* renamed from: id */
    public String m12689id() {
        return this.f40186id;
    }

    public String toString() {
        return this.strVal;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.f40186id.compareTo(localAddress.f40186id);
    }

    public LocalAddress(String str) {
        if (str != null) {
            String lowerCase = str.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                this.f40186id = lowerCase;
                this.strVal = "local:" + lowerCase;
                return;
            }
            throw new IllegalArgumentException("empty id");
        }
        throw new NullPointerException("id");
    }
}
