package io.netty.handler.codec.socksx.p605v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* renamed from: io.netty.handler.codec.socksx.v5.DefaultSocks5CommandResponse */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DefaultSocks5CommandResponse extends AbstractSocks5Message implements Socks5CommandResponse {
    private final String bndAddr;
    private final Socks5AddressType bndAddrType;
    private final int bndPort;
    private final Socks5CommandStatus status;

    public DefaultSocks5CommandResponse(Socks5CommandStatus socks5CommandStatus, Socks5AddressType socks5AddressType) {
        this(socks5CommandStatus, socks5AddressType, null, 0);
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandResponse
    public String bndAddr() {
        return this.bndAddr;
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandResponse
    public Socks5AddressType bndAddrType() {
        return this.bndAddrType;
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandResponse
    public int bndPort() {
        return this.bndPort;
    }

    @Override // io.netty.handler.codec.socksx.p605v5.Socks5CommandResponse
    public Socks5CommandStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", status: ");
        } else {
            sb.append("(status: ");
        }
        sb.append(status());
        sb.append(", bndAddrType: ");
        sb.append(bndAddrType());
        sb.append(", bndAddr: ");
        sb.append(bndAddr());
        sb.append(", bndPort: ");
        sb.append(bndPort());
        sb.append(')');
        return sb.toString();
    }

    public DefaultSocks5CommandResponse(Socks5CommandStatus socks5CommandStatus, Socks5AddressType socks5AddressType, String str, int i) {
        if (socks5CommandStatus == null) {
            throw new NullPointerException("status");
        }
        if (socks5AddressType == null) {
            throw new NullPointerException("bndAddrType");
        }
        if (str != null) {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                if (!NetUtil.isValidIpV4Address(str)) {
                    throw new IllegalArgumentException("bndAddr: " + str + " (expected: a valid IPv4 address)");
                }
            } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
                str = IDN.toASCII(str);
                if (str.length() > 255) {
                    throw new IllegalArgumentException("bndAddr: " + str + " (expected: less than 256 chars)");
                }
            } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException("bndAddr: " + str + " (expected: a valid IPv6 address)");
            }
        }
        if (i >= 0 && i <= 65535) {
            this.status = socks5CommandStatus;
            this.bndAddrType = socks5AddressType;
            this.bndAddr = str;
            this.bndPort = i;
            return;
        }
        throw new IllegalArgumentException("bndPort: " + i + " (expected: 0~65535)");
    }
}
