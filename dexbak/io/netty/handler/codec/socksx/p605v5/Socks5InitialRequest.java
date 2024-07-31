package io.netty.handler.codec.socksx.p605v5;

import java.util.List;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5InitialRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Socks5InitialRequest extends Socks5Message {
    List<Socks5AuthMethod> authMethods();
}
