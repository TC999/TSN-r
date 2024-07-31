package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.IDN;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SocksCmdResponse extends SocksResponse {
    private static final byte[] DOMAIN_ZEROED = {0};
    private static final byte[] IPv4_HOSTNAME_ZEROED = {0, 0, 0, 0};
    private static final byte[] IPv6_HOSTNAME_ZEROED = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final SocksAddressType addressType;
    private final SocksCmdStatus cmdStatus;
    private final String host;
    private final int port;

    /* renamed from: io.netty.handler.codec.socks.SocksCmdResponse$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C138951 {
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

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType) {
        this(socksCmdStatus, socksAddressType, null, 0);
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdStatus cmdStatus() {
        return this.cmdStatus;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdStatus.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = C138951.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            String str = this.host;
            byteBuf.writeBytes(str == null ? IPv4_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str));
            byteBuf.writeShort(this.port);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            String str2 = this.host;
            byteBuf.writeBytes(str2 == null ? IPv6_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str2));
            byteBuf.writeShort(this.port);
        } else {
            String str3 = this.host;
            byte[] bytes = str3 == null ? DOMAIN_ZEROED : str3.getBytes(CharsetUtil.US_ASCII);
            byteBuf.writeByte(bytes.length);
            byteBuf.writeBytes(bytes);
            byteBuf.writeShort(this.port);
        }
    }

    public String host() {
        String str = this.host;
        if (str != null) {
            return IDN.toUnicode(str);
        }
        return null;
    }

    public int port() {
        return this.port;
    }

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType, String str, int i) {
        super(SocksResponseType.CMD);
        if (socksCmdStatus == null) {
            throw new NullPointerException("cmdStatus");
        }
        if (socksAddressType == null) {
            throw new NullPointerException("addressType");
        }
        if (str != null) {
            int i2 = C138951.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                        throw new IllegalArgumentException(str + " is not a valid IPv6 address");
                    }
                } else if (IDN.toASCII(str).length() > 255) {
                    throw new IllegalArgumentException(str + " IDN: " + IDN.toASCII(str) + " exceeds 255 char limit");
                }
            } else if (!NetUtil.isValidIpV4Address(str)) {
                throw new IllegalArgumentException(str + " is not a valid IPv4 address");
            }
            str = IDN.toASCII(str);
        }
        if (i >= 0 && i <= 65535) {
            this.cmdStatus = socksCmdStatus;
            this.addressType = socksAddressType;
            this.host = str;
            this.port = i;
            return;
        }
        throw new IllegalArgumentException(i + " is not in bounds 0 <= x <= 65535");
    }
}
