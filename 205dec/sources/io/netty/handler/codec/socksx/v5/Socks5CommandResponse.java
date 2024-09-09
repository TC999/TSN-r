package io.netty.handler.codec.socksx.v5;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Socks5CommandResponse extends Socks5Message {
    String bndAddr();

    Socks5AddressType bndAddrType();

    int bndPort();

    Socks5CommandStatus status();
}
