package io.netty.handler.codec.haproxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum TCP4 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HAProxyProxiedProtocol {
    private static final /* synthetic */ HAProxyProxiedProtocol[] $VALUES;
    public static final HAProxyProxiedProtocol TCP4;
    public static final HAProxyProxiedProtocol TCP6;
    public static final HAProxyProxiedProtocol UDP4;
    public static final HAProxyProxiedProtocol UDP6;
    public static final HAProxyProxiedProtocol UNIX_DGRAM;
    public static final HAProxyProxiedProtocol UNIX_STREAM;
    public static final HAProxyProxiedProtocol UNKNOWN;
    private final AddressFamily addressFamily;
    private final byte byteValue;
    private final TransportProtocol transportProtocol;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum AddressFamily {
        AF_UNSPEC((byte) 0),
        AF_IPv4((byte) 16),
        AF_IPv6((byte) 32),
        AF_UNIX((byte) 48);
        
        private static final byte FAMILY_MASK = -16;
        private final byte byteValue;

        AddressFamily(byte b4) {
            this.byteValue = b4;
        }

        public byte byteValue() {
            return this.byteValue;
        }

        public static AddressFamily valueOf(byte b4) {
            int i4 = b4 & (-16);
            byte b5 = (byte) i4;
            if (b5 != 0) {
                if (b5 != 16) {
                    if (b5 != 32) {
                        if (b5 == 48) {
                            return AF_UNIX;
                        }
                        throw new IllegalArgumentException("unknown address family: " + i4);
                    }
                    return AF_IPv6;
                }
                return AF_IPv4;
            }
            return AF_UNSPEC;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum TransportProtocol {
        UNSPEC((byte) 0),
        STREAM((byte) 1),
        DGRAM((byte) 2);
        
        private static final byte TRANSPORT_MASK = 15;
        private final byte transportByte;

        TransportProtocol(byte b4) {
            this.transportByte = b4;
        }

        public byte byteValue() {
            return this.transportByte;
        }

        public static TransportProtocol valueOf(byte b4) {
            int i4 = b4 & 15;
            byte b5 = (byte) i4;
            if (b5 != 0) {
                if (b5 != 1) {
                    if (b5 == 2) {
                        return DGRAM;
                    }
                    throw new IllegalArgumentException("unknown transport protocol: " + i4);
                }
                return STREAM;
            }
            return UNSPEC;
        }
    }

    static {
        HAProxyProxiedProtocol hAProxyProxiedProtocol = new HAProxyProxiedProtocol("UNKNOWN", 0, (byte) 0, AddressFamily.AF_UNSPEC, TransportProtocol.UNSPEC);
        UNKNOWN = hAProxyProxiedProtocol;
        AddressFamily addressFamily = AddressFamily.AF_IPv4;
        TransportProtocol transportProtocol = TransportProtocol.STREAM;
        HAProxyProxiedProtocol hAProxyProxiedProtocol2 = new HAProxyProxiedProtocol("TCP4", 1, (byte) 17, addressFamily, transportProtocol);
        TCP4 = hAProxyProxiedProtocol2;
        AddressFamily addressFamily2 = AddressFamily.AF_IPv6;
        HAProxyProxiedProtocol hAProxyProxiedProtocol3 = new HAProxyProxiedProtocol("TCP6", 2, (byte) 33, addressFamily2, transportProtocol);
        TCP6 = hAProxyProxiedProtocol3;
        TransportProtocol transportProtocol2 = TransportProtocol.DGRAM;
        HAProxyProxiedProtocol hAProxyProxiedProtocol4 = new HAProxyProxiedProtocol("UDP4", 3, (byte) 18, addressFamily, transportProtocol2);
        UDP4 = hAProxyProxiedProtocol4;
        HAProxyProxiedProtocol hAProxyProxiedProtocol5 = new HAProxyProxiedProtocol("UDP6", 4, (byte) 34, addressFamily2, transportProtocol2);
        UDP6 = hAProxyProxiedProtocol5;
        AddressFamily addressFamily3 = AddressFamily.AF_UNIX;
        HAProxyProxiedProtocol hAProxyProxiedProtocol6 = new HAProxyProxiedProtocol("UNIX_STREAM", 5, (byte) 49, addressFamily3, transportProtocol);
        UNIX_STREAM = hAProxyProxiedProtocol6;
        HAProxyProxiedProtocol hAProxyProxiedProtocol7 = new HAProxyProxiedProtocol("UNIX_DGRAM", 6, (byte) 50, addressFamily3, transportProtocol2);
        UNIX_DGRAM = hAProxyProxiedProtocol7;
        $VALUES = new HAProxyProxiedProtocol[]{hAProxyProxiedProtocol, hAProxyProxiedProtocol2, hAProxyProxiedProtocol3, hAProxyProxiedProtocol4, hAProxyProxiedProtocol5, hAProxyProxiedProtocol6, hAProxyProxiedProtocol7};
    }

    private HAProxyProxiedProtocol(String str, int i4, byte b4, AddressFamily addressFamily, TransportProtocol transportProtocol) {
        this.byteValue = b4;
        this.addressFamily = addressFamily;
        this.transportProtocol = transportProtocol;
    }

    public static HAProxyProxiedProtocol valueOf(String str) {
        return (HAProxyProxiedProtocol) Enum.valueOf(HAProxyProxiedProtocol.class, str);
    }

    public static HAProxyProxiedProtocol[] values() {
        return (HAProxyProxiedProtocol[]) $VALUES.clone();
    }

    public AddressFamily addressFamily() {
        return this.addressFamily;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public TransportProtocol transportProtocol() {
        return this.transportProtocol;
    }

    public static HAProxyProxiedProtocol valueOf(byte b4) {
        if (b4 != 0) {
            if (b4 != 17) {
                if (b4 != 18) {
                    if (b4 != 33) {
                        if (b4 != 34) {
                            if (b4 != 49) {
                                if (b4 == 50) {
                                    return UNIX_DGRAM;
                                }
                                throw new IllegalArgumentException("unknown transport protocol + address family: " + (b4 & 255));
                            }
                            return UNIX_STREAM;
                        }
                        return UDP6;
                    }
                    return TCP6;
                }
                return UDP4;
            }
            return TCP4;
        }
        return UNKNOWN;
    }
}
