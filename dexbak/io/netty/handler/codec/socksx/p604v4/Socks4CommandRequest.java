package io.netty.handler.codec.socksx.p604v4;

/* renamed from: io.netty.handler.codec.socksx.v4.Socks4CommandRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Socks4CommandRequest extends Socks4Message {
    String dstAddr();

    int dstPort();

    Socks4CommandType type();

    String userId();
}