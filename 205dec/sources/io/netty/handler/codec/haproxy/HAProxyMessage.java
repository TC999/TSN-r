package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessage$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;

        static {
            int[] iArr = new int[HAProxyProxiedProtocol.AddressFamily.values().length];
            $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily = iArr;
            try {
                iArr[HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_UNIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_IPv4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_IPv6.ordinal()] = 4;
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
            int[] iArr = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
            int i4 = iArr[addressFamily.ordinal()];
            if (i4 == 1) {
                if (str == null) {
                    return;
                }
                throw new HAProxyProtocolException("unable to validate an AF_UNSPEC address: " + str);
            } else if (i4 != 2) {
                if (str != null) {
                    int i5 = iArr[addressFamily.ordinal()];
                    if (i5 == 3) {
                        if (NetUtil.isValidIpV4Address(str)) {
                            return;
                        }
                        throw new HAProxyProtocolException("invalid IPv4 address: " + str);
                    } else if (i5 == 4) {
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

    private static void checkPort(int i4) {
        if (i4 < 0 || i4 > 65535) {
            throw new HAProxyProtocolException("invalid port: " + i4 + " (expected: 1 ~ 65535)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HAProxyMessage decodeHeader(ByteBuf byteBuf) {
        int readUnsignedShort;
        String str;
        String str2;
        int i4;
        if (byteBuf != null) {
            int i5 = 16;
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
                                        int i6 = forEachByte == -1 ? 108 : forEachByte - readerIndex;
                                        Charset charset = CharsetUtil.US_ASCII;
                                        String byteBuf2 = byteBuf.toString(readerIndex, i6, charset);
                                        int i7 = readerIndex + 108;
                                        int forEachByte2 = byteBuf.forEachByte(i7, 108, byteProcessor);
                                        str2 = byteBuf.toString(i7, forEachByte2 != -1 ? forEachByte2 - i7 : 108, charset);
                                        str = byteBuf2;
                                        i4 = 0;
                                        readUnsignedShort = 0;
                                    } else {
                                        throw new HAProxyProtocolException("incomplete UNIX socket address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 216+ bytes)");
                                    }
                                } else {
                                    if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv4) {
                                        if (readUnsignedShort2 < 12 || byteBuf.readableBytes() < 12) {
                                            throw new HAProxyProtocolException("incomplete IPv4 address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 12+ bytes)");
                                        }
                                        i5 = 4;
                                    } else if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv6) {
                                        if (readUnsignedShort2 < 36 || byteBuf.readableBytes() < 36) {
                                            throw new HAProxyProtocolException("incomplete IPv6 address information: " + Math.min(readUnsignedShort2, byteBuf.readableBytes()) + " bytes (expected: 36+ bytes)");
                                        }
                                    } else {
                                        throw new HAProxyProtocolException("unable to parse address information (unkown address family: " + addressFamily + ')');
                                    }
                                    String ipBytestoString = ipBytestoString(byteBuf, i5);
                                    String ipBytestoString2 = ipBytestoString(byteBuf, i5);
                                    int readUnsignedShort3 = byteBuf.readUnsignedShort();
                                    readUnsignedShort = byteBuf.readUnsignedShort();
                                    str = ipBytestoString;
                                    str2 = ipBytestoString2;
                                    i4 = readUnsignedShort3;
                                }
                                return new HAProxyMessage(valueOf, valueOf2, valueOf3, str, str2, i4, readUnsignedShort);
                            } catch (IllegalArgumentException e4) {
                                throw new HAProxyProtocolException(e4);
                            }
                        } catch (IllegalArgumentException e5) {
                            throw new HAProxyProtocolException(e5);
                        }
                    }
                    throw new HAProxyProtocolException("version 1 unsupported: 0x" + Integer.toHexString(readByte));
                } catch (IllegalArgumentException e6) {
                    throw new HAProxyProtocolException(e6);
                }
            }
            throw new HAProxyProtocolException("incomplete header: " + byteBuf.readableBytes() + " bytes (expected: 16+ bytes)");
        }
        throw new NullPointerException("header");
    }

    private static String ipBytestoString(ByteBuf byteBuf, int i4) {
        StringBuilder sb = new StringBuilder();
        if (i4 == 4) {
            sb.append(byteBuf.readByte() & 255);
            sb.append('.');
            sb.append(byteBuf.readByte() & 255);
            sb.append('.');
            sb.append(byteBuf.readByte() & 255);
            sb.append('.');
            sb.append(byteBuf.readByte() & 255);
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
        } catch (NumberFormatException e4) {
            throw new HAProxyProtocolException("invalid port: " + str, e4);
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

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i4, int i5) {
        if (hAProxyProxiedProtocol != null) {
            HAProxyProxiedProtocol.AddressFamily addressFamily = hAProxyProxiedProtocol.addressFamily();
            checkAddress(str, addressFamily);
            checkAddress(str2, addressFamily);
            checkPort(i4);
            checkPort(i5);
            this.protocolVersion = hAProxyProtocolVersion;
            this.command = hAProxyCommand;
            this.proxiedProtocol = hAProxyProxiedProtocol;
            this.sourceAddress = str;
            this.destinationAddress = str2;
            this.sourcePort = i4;
            this.destinationPort = i5;
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
                    } catch (IllegalArgumentException e4) {
                        throw new HAProxyProtocolException(e4);
                    }
                }
                throw new HAProxyProtocolException("unknown identifier: " + split[0]);
            }
            throw new HAProxyProtocolException("invalid header: " + str + " (expected: 'PROXY' and proxied protocol values)");
        }
        throw new HAProxyProtocolException("header");
    }
}
