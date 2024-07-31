package io.netty.handler.codec.socksx.p605v5;

import com.tencent.connect.common.Constants;
import kotlin.UByte;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5CommandStatus */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5CommandStatus implements Comparable<Socks5CommandStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5CommandStatus SUCCESS = new Socks5CommandStatus(0, "SUCCESS");
    public static final Socks5CommandStatus FAILURE = new Socks5CommandStatus(1, "FAILURE");
    public static final Socks5CommandStatus FORBIDDEN = new Socks5CommandStatus(2, "FORBIDDEN");
    public static final Socks5CommandStatus NETWORK_UNREACHABLE = new Socks5CommandStatus(3, "NETWORK_UNREACHABLE");
    public static final Socks5CommandStatus HOST_UNREACHABLE = new Socks5CommandStatus(4, "HOST_UNREACHABLE");
    public static final Socks5CommandStatus CONNECTION_REFUSED = new Socks5CommandStatus(5, "CONNECTION_REFUSED");
    public static final Socks5CommandStatus TTL_EXPIRED = new Socks5CommandStatus(6, "TTL_EXPIRED");
    public static final Socks5CommandStatus COMMAND_UNSUPPORTED = new Socks5CommandStatus(7, "COMMAND_UNSUPPORTED");
    public static final Socks5CommandStatus ADDRESS_UNSUPPORTED = new Socks5CommandStatus(8, "ADDRESS_UNSUPPORTED");

    public Socks5CommandStatus(int i) {
        this(i, Constants.APP_VERSION_UNKNOWN);
    }

    public static Socks5CommandStatus valueOf(byte b) {
        switch (b) {
            case 0:
                return SUCCESS;
            case 1:
                return FAILURE;
            case 2:
                return FORBIDDEN;
            case 3:
                return NETWORK_UNREACHABLE;
            case 4:
                return HOST_UNREACHABLE;
            case 5:
                return CONNECTION_REFUSED;
            case 6:
                return TTL_EXPIRED;
            case 7:
                return COMMAND_UNSUPPORTED;
            case 8:
                return ADDRESS_UNSUPPORTED;
            default:
                return new Socks5CommandStatus(b);
        }
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5CommandStatus) && this.byteValue == ((Socks5CommandStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 0;
    }

    public String toString() {
        String str = this.text;
        if (str == null) {
            String str2 = this.name + '(' + (this.byteValue & UByte.f41242c) + ')';
            this.text = str2;
            return str2;
        }
        return str;
    }

    public Socks5CommandStatus(int i, String str) {
        if (str != null) {
            this.byteValue = (byte) i;
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5CommandStatus socks5CommandStatus) {
        return this.byteValue - socks5CommandStatus.byteValue;
    }
}
