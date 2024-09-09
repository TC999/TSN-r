package io.netty.channel.unix;

import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final int receivedAmount;

    DatagramSocketAddress(String str, int i4, int i5) {
        super(str, i4);
        this.receivedAmount = i5;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
