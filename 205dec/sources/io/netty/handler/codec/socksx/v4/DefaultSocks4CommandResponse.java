package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultSocks4CommandResponse extends AbstractSocks4Message implements Socks4CommandResponse {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandStatus status;

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus) {
        this(socks4CommandStatus, null, 0);
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public int dstPort() {
        return this.dstPort;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public Socks4CommandStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(96);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", dstAddr: ");
        } else {
            sb.append("(dstAddr: ");
        }
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(')');
        return sb.toString();
    }

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus, String str, int i4) {
        if (socks4CommandStatus != null) {
            if (str != null && !NetUtil.isValidIpV4Address(str)) {
                throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv4 address)");
            } else if (i4 >= 0 && i4 <= 65535) {
                this.status = socks4CommandStatus;
                this.dstAddr = str;
                this.dstPort = i4;
                return;
            } else {
                throw new IllegalArgumentException("dstPort: " + i4 + " (expected: 0~65535)");
            }
        }
        throw new NullPointerException("cmdStatus");
    }
}
