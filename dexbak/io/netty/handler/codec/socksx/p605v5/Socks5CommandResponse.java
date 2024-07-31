package io.netty.handler.codec.socksx.p605v5;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandResponse */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Socks5CommandResponse extends Socks5Message {
    String bndAddr();

    Socks5AddressType bndAddrType();

    int bndPort();

    Socks5CommandStatus status();
}
