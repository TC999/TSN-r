package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.nio.charset.Charset;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HAProxyMessage {
    private static final HAProxyMessage V1_UNKNOWN_MSG;
    private static final HAProxyMessage V2_LOCAL_MSG;
    private static final HAProxyMessage V2_UNKNOWN_MSG;
    private final HAProxyCommand command;
    private final String destinationAddress;
    private final int destinationPort;
    private final HAProxyProtocolVersion protocolVersion;
    private final HAProxyProxiedProtocol proxiedProtocol;
    private final String sourceAddress;
    private final int sourcePort;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessage$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C137971 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily */
        static final /* synthetic */ int[] f40221x3a3897ab;

        static {
            int[] iArr = new int[HAProxyProxiedProtocol.AddressFamily.values().length];
            f40221x3a3897ab = iArr;
            try {
                iArr[HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40221x3a3897ab[HAProxyProxiedProtocol.AddressFamily.AF_UNIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40221x3a3897ab[HAProxyProxiedProtocol.AddressFamily.AF_IPv4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40221x3a3897ab[HAProxyProxiedProtocol.AddressFamily.AF_IPv6.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        HAProxyProtocolVersion hAProxyProtocolVersion = HAProxyProtocolVersion.V1;
        HAProxyCommand hAProxyCommand = HAProxyCommand.PROXY;
        HAProxyProxiedProtocol hAProxyProxiedProtocol = HAProxyProxiedProtocol.UNKNOWN;
        V1_UNKNOWN_MSG = new HAProxyMessage(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, (String) null, (String) null, 0, 0);
        HAProxyProtocolVersion hAProxyProtocolVersion2 = HAProxyProtocolVersion.V2;
        V2_UNKNOWN_MSG = new HAProxyMessage(hAProxyProtocolVersion2, hAProxyCommand, hAProxyProxiedProtocol, (String) null, (String) null, 0, 0);
        V2_LOCAL_MSG = new HAProxyMessage(hAProxyProtocolVersion2, HAProxyCommand.LOCAL, hAProxyProxiedProtocol, (String) null, (String) null, 0, 0);
    }

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, String str3, String str4) {
        this(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, str, str2, portStringToInt(str3), portStringToInt(str4));
    }

    private static void checkAddress(String str, HAProxyProxiedProtocol.AddressFamily addressFamily) {
        if (addressFamily != null) {
            int[] iArr = C137971.f40221x3a3897ab;
            int i = iArr[addressFamily.ordinal()];
            if (i == 1) {
                if (str == null) {
                    return;
                }
                throw new HAProxyProtocolException("unable to validate an AF_UNSPEC address: " + str);
            } else if (i != 2) {
                if (str != null) {
                    int i2 = iArr[addressFamily.ordinal()];
                    if (i2 == 3) {
                        if (NetUtil.isValidIpV4Address(str)) {
                            return;
                        }
                        throw new HAProxyProtocolException("invalid IPv4 address: " + str);
                    } else if (i2 == 4) {
                        if (NetUtil.isValidIpV6Address(str)) {
                            return;
                        }
                        throw new HAProxyProtocolException("invalid IPv6 address: " + str);
                    } else {
                        throw new Error();
                    }
                }
                throw new NullPointerException("address");
            } else {
                return;
            }
        }
        throw new NullPointerException("addrFamily");
    }

    private static void checkPort(int i) {
        if (i < 0 || i > 65535) {
            throw new HAProxyProtocolException("invalid port: " + i + " (expected: 1 ~ 65535)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HAProxyMessage decodeHeader(ByteBuf byteBuf) {
        int readUnsignedShort;
        String str;
        String str2;
        int i;
        if (byteBuf != null) {
            int i2 = 16;
            if (byteBuf.readableBytes() >= 16) {
                byteBuf.skipBytes(12);
                byte readByte = byteBuf.readByte();
                try {
                    HAProxyProtocolVersion valueOf = HAProxyProtocolVersion.valueOf(readByte);
                    if (valueOf == HAProxyProtocolVersion.V2) {
                        try {
                            HAProxyCommand valueOf2 = HAProxyCommand.valueOf(readByte);
                            if (valueOf2 == HAProxyCommand.LOCAL) {
                                return V2_LOCAL_MSG;
                            }
                            try {
                                HAProxyProxiedProtocol valueOf3 = HAProxyProxiedProtocol.valueOf(byteBuf.readByte());
                                if (valueOf3 == HAProxyProxiedProtocol.UNKNOWN) {
                                    return V2_UNKNOWN_MSG;
                                }
                                int readUnsignedShort2 = byteBuf.readUnsignedShort();
                                HAProxyProxiedProtocol.AddressFamily addressFamily = valueOf3.addressFamily();
                                if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_UNIX) {
                                    if (readUnsignedShort2 >= 216 && byteBuf.readableBytes() >= 216) {
                                        int readerIndex = byteBuf.readerIndex();
                                        ByteProcessor byteProcessor = ByteProcessor.FIND_NUL;
                                        int forEachByte = byteBuf.forEachByte(readerIndex, 108, byteProcessor);
                                        int i3 = forEachByte == -1 ? 108 : forEachByte - readerIndex;
                                        Charset charset = CharsetUtil.US_ASCII;
                                        String byteBuf2 = byteBuf.toString(readerIndex, i3, charset);
                                        int i4 = readerIndex + 108;
                                        int forEachByte2 = byteBuf.forEachByte(i4, 108, byteProcessor);
                                        str2 = byteBuf.toString(i4, forEachByte2 != -1 ? forEachByte2 - i4 : 108, charset);
                                        str = byteBuf2;
                                        i = 0;
                                        readUnsignedShort = 0;
                                    } else {
                                        throw new HAProxyProtocolException("incomplete UNIX socket address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 216+ bytes)");
                                    }
                                } else {
                                    if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv4) {
                                        if (readUnsignedShort2 < 12 || byteBuf.readableBytes() < 12) {
                                            throw new HAProxyProtocolException("incomplete IPv4 address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 12+ bytes)");
                                        }
                                        i2 = 4;
                                    } else if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv6) {
                                        if (readUnsignedShort2 < 36 || byteBuf.readableBytes() < 36) {
                                            throw new HAProxyProtocolException("incomplete IPv6 address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 36+ bytes)");
                                        }
                                    } else {
                                        throw new HAProxyProtocolException("unable to parse address information (unkown address family: " + addressFamily + ')');
                                    }
                                    String ipBytestoString = ipBytestoString(byteBuf, i2);
                                    String ipBytestoString2 = ipBytestoString(byteBuf, i2);
                                    int readUnsignedShort3 = byteBuf.readUnsignedShort();
                                    readUnsignedShort = byteBuf.readUnsignedShort();
                                    str = ipBytestoString;
                                    str2 = ipBytestoString2;
                                    i = readUnsignedShort3;
                                }
                                return new HAProxyMessage(valueOf, valueOf2, valueOf3, str, str2, i, readUnsignedShort);
                            } catch (IllegalArgumentException e) {
                                throw new HAProxyProtocolException(e);
                            }
                        } catch (IllegalArgumentException e2) {
                            throw new HAProxyProtocolException(e2);
                        }
                    }
                    throw new HAProxyProtocolException("version 1 unsupported: 0x" + Integer.toHexString(readByte));
                } catch (IllegalArgumentException e3) {
                    throw new HAProxyProtocolException(e3);
                }
            }
            throw new HAProxyProtocolException("incomplete header: " + byteBuf.readableBytes() + " bytes (expected: 16+ bytes)");
        }
        throw new NullPointerException("header");
    }

    private static String ipBytestoString(ByteBuf byteBuf, int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 4) {
            sb.append(byteBuf.readByte() & UByte.f41242c);
            sb.append('.');
            sb.append(byteBuf.readByte() & UByte.f41242c);
            sb.append('.');
            sb.append(byteBuf.readByte() & UByte.f41242c);
            sb.append('.');
            sb.append(byteBuf.readByte() & UByte.f41242c);
        } else {
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
            sb.append(':');
            sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
        }
        return sb.toString();
    }

    private static int portStringToInt(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt <= 0 || parseInt > 65535) {
                throw new HAProxyProtocolException("invalid port: " + str + " (expected: 1 ~ 65535)");
            }
            return parseInt;
        } catch (NumberFormatException e) {
            throw new HAProxyProtocolException("invalid port: " + str, e);
        }
    }

    public HAProxyCommand command() {
        return this.command;
    }

    public String destinationAddress() {
        return this.destinationAddress;
    }

    public int destinationPort() {
        return this.destinationPort;
    }

    public HAProxyProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public HAProxyProxiedProtocol proxiedProtocol() {
        return this.proxiedProtocol;
    }

    public String sourceAddress() {
        return this.sourceAddress;
    }

    public int sourcePort() {
        return this.sourcePort;
    }

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i, int i2) {
        if (hAProxyProxiedProtocol != null) {
            HAProxyProxiedProtocol.AddressFamily addressFamily = hAProxyProxiedProtocol.addressFamily();
            checkAddress(str, addressFamily);
            checkAddress(str2, addressFamily);
            checkPort(i);
            checkPort(i2);
            this.protocolVersion = hAProxyProtocolVersion;
            this.command = hAProxyCommand;
            this.proxiedProtocol = hAProxyProxiedProtocol;
            this.sourceAddress = str;
            this.destinationAddress = str2;
            this.sourcePort = i;
            this.destinationPort = i2;
            return;
        }
        throw new NullPointerException("proxiedProtocol");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HAProxyMessage decodeHeader(String str) {
        if (str != null) {
            String[] split = str.split(" ");
            int length = split.length;
            if (length >= 2) {
                if ("PROXY".equals(split[0])) {
                    try {
                        HAProxyProxiedProtocol valueOf = HAProxyProxiedProtocol.valueOf(split[1]);
                        if (valueOf != HAProxyProxiedProtocol.TCP4 && valueOf != HAProxyProxiedProtocol.TCP6 && valueOf != HAProxyProxiedProtocol.UNKNOWN) {
                            throw new HAProxyProtocolException("unsupported v1 proxied protocol: " + split[1]);
                        } else if (valueOf == HAProxyProxiedProtocol.UNKNOWN) {
                            return V1_UNKNOWN_MSG;
                        } else {
                            if (length == 6) {
                                return new HAProxyMessage(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY, valueOf, split[2], split[3], split[4], split[5]);
                            }
                            throw new HAProxyProtocolException("invalid TCP4/6 header: " + str + " (expected: 6 parts)");
                        }
                    } catch (IllegalArgumentException e) {
                        throw new HAProxyProtocolException(e);
                    }
                }
                throw new HAProxyProtocolException("unknown identifier: " + split[0]);
            }
            throw new HAProxyProtocolException("invalid header: " + str + " (expected: 'PROXY' and proxied protocol values)");
        }
        throw new HAProxyProtocolException("header");
    }
}
