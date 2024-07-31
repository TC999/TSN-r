package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.socksx.v5.DefaultSocks5InitialResponse */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultSocks5InitialResponse extends AbstractSocks5Message implements Socks5InitialResponse {
    private final Socks5AuthMethod authMethod;

    public DefaultSocks5InitialResponse(Socks5AuthMethod socks5AuthMethod) {
        if (socks5AuthMethod != null) {
            this.authMethod = socks5AuthMethod;
            return;
        }
        throw new NullPointerException("authMethod");
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5InitialResponse
    public Socks5AuthMethod authMethod() {
        return this.authMethod;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethod: ");
        } else {
            sb.append("(authMethod: ");
        }
        sb.append(authMethod());
        sb.append(')');
        return sb.toString();
    }
}
