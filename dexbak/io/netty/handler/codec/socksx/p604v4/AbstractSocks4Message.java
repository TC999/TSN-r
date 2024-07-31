package io.netty.handler.codec.socksx.p604v4;

import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;

/* renamed from: io.netty.handler.codec.socksx.v4.AbstractSocks4Message */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractSocks4Message extends AbstractSocksMessage implements Socks4Message {
    @Override // io.netty.handler.codec.socksx.SocksMessage
    public final SocksVersion version() {
        return SocksVersion.SOCKS4a;
    }
}
