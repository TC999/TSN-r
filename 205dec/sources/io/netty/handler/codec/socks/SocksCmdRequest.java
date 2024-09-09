package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.IDN;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i4) {
        super(SocksRequestType.CMD);
        if (socksCmdType == null) {
            throw new NullPointerException("cmdType");
        }
        if (socksAddressType == null) {
            throw new NullPointerException("addressType");
        }
        if (str != null) {
            int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3 && !NetUtil.isValidIpV6Address(str)) {
                        throw new IllegalArgumentException(str + " is not a valid IPv6 address");
                    }
                } else if (IDN.toASCII(str).length() > 255) {
                    throw new IllegalArgumentException(str + " IDN: " + IDN.toASCII(str) + " exceeds 255 char limit");
                }
            } else if (!NetUtil.isValidIpV4Address(str)) {
                throw new IllegalArgumentException(str + " is not a valid IPv4 address");
            }
            if (i4 > 0 && i4 < 65536) {
                this.cmdType = socksCmdType;
                this.addressType = socksAddressType;
                this.host = IDN.toASCII(str);
                this.port = i4;
                return;
            }
            throw new IllegalArgumentException(i4 + " is not in bounds 0 < x < 65536");
        }
        throw new NullPointerException("host");
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i4 == 1) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        } else if (i4 == 2) {
            byteBuf.writeByte(this.host.length());
            byteBuf.writeBytes(this.host.getBytes(CharsetUtil.US_ASCII));
            byteBuf.writeShort(this.port);
        } else if (i4 != 3) {
        } else {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            byteBuf.writeShort(this.port);
        }
    }

    public String host() {
        return IDN.toUnicode(this.host);
    }

    public int port() {
        return this.port;
    }
}
