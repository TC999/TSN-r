package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultSocks4CommandRequest extends AbstractSocks4Message implements Socks4CommandRequest {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandType type;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i4) {
        this(socks4CommandType, str, i4, "");
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
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

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public Socks4CommandType type() {
        return this.type;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String userId() {
        return this.userId;
    }

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i4, String str2) {
        if (socks4CommandType == null) {
            throw new NullPointerException("type");
        }
        if (str == null) {
            throw new NullPointerException("dstAddr");
        }
        if (i4 <= 0 || i4 >= 65536) {
            throw new IllegalArgumentException("dstPort: " + i4 + " (expected: 1~65535)");
        } else if (str2 != null) {
            this.userId = str2;
            this.type = socks4CommandType;
            this.dstAddr = IDN.toASCII(str);
            this.dstPort = i4;
        } else {
            throw new NullPointerException("userId");
        }
    }
}
