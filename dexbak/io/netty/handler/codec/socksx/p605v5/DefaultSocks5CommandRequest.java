package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* renamed from: io.netty.handler.codec.socksx.v5.DefaultSocks5CommandRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DefaultSocks5CommandRequest extends AbstractSocks5Message implements Socks5CommandRequest {
    private final String dstAddr;
    private final Socks5AddressType dstAddrType;
    private final int dstPort;
    private final Socks5CommandType type;

    public DefaultSocks5CommandRequest(Socks5CommandType socks5CommandType, Socks5AddressType socks5AddressType, String str, int i) {
        if (socks5CommandType == null) {
            throw new NullPointerException("type");
        }
        if (socks5AddressType == null) {
            throw new NullPointerException("dstAddrType");
        }
        if (str != null) {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                if (!NetUtil.isValidIpV4Address(str)) {
                    throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv4 address)");
                }
            } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
                str = IDN.toASCII(str);
                if (str.length() > 255) {
                    throw new IllegalArgumentException("dstAddr: " + str + " (expected: less than 256 chars)");
                }
            } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv6 address");
            }
            if (i > 0 && i < 65536) {
                this.type = socks5CommandType;
                this.dstAddrType = socks5AddressType;
                this.dstAddr = str;
                this.dstPort = i;
                return;
            }
            throw new IllegalArgumentException("dstPort: " + i + " (expected: 1~65535)");
        }
        throw new NullPointerException("dstAddr");
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandRequest
    public Socks5AddressType dstAddrType() {
        return this.dstAddrType;
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandRequest
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", type: ");
        } else {
            sb.append("(type: ");
        }
        sb.append(type());
        sb.append(", dstAddrType: ");
        sb.append(dstAddrType());
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandRequest
    public Socks5CommandType type() {
        return this.type;
    }
}
