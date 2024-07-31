package io.netty.handler.codec.socksx.p605v5;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Socks5CommandRequest extends Socks5Message {
    String dstAddr();

    Socks5AddressType dstAddrType();

    int dstPort();

    Socks5CommandType type();
}
