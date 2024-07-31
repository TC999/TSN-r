package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;

/* renamed from: io.netty.handler.codec.socksx.v5.AbstractSocks5Message */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractSocks5Message extends AbstractSocksMessage implements Socks5Message {
    @Override // io.netty.handler.codec.socksx.SocksMessage
    public final SocksVersion version() {
        return SocksVersion.SOCKS5;
    }
}
