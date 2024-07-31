package io.netty.handler.codec.socksx.p604v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* renamed from: io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultSocks4CommandRequest extends AbstractSocks4Message implements Socks4CommandRequest {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandType type;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i) {
        this(socks4CommandType, str, i, "");
    }

    @Override // io.netty.handler.codec.socksx.p604v4.Socks4CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.p604v4.Socks4CommandRequest
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
        sb.append(", dstAddr: ");
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(", userId: ");
        sb.append(userId());
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.socksx.p604v4.Socks4CommandRequest
    public Socks4CommandType type() {
        return this.type;
    }

    @Override // io.netty.handler.codec.socksx.p604v4.Socks4CommandRequest
    public String userId() {
        return this.userId;
    }

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i, String str2) {
        if (socks4CommandType == null) {
            throw new NullPointerException("type");
        }
        if (str == null) {
            throw new NullPointerException("dstAddr");
        }
        if (i <= 0 || i >= 65536) {
            throw new IllegalArgumentException("dstPort: " + i + " (expected: 1~65535)");
        } else if (str2 != null) {
            this.userId = str2;
            this.type = socks4CommandType;
            this.dstAddr = IDN.toASCII(str);
            this.dstPort = i;
        } else {
            throw new NullPointerException("userId");
        }
    }
}
