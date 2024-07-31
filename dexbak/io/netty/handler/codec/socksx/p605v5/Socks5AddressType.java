package io.netty.handler.codec.socksx.p605v5;

import com.tencent.connect.common.Constants;
import kotlin.UByte;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5AddressType */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5AddressType implements Comparable<Socks5AddressType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AddressType IPv4 = new Socks5AddressType(1, "IPv4");
    public static final Socks5AddressType DOMAIN = new Socks5AddressType(3, "DOMAIN");
    public static final Socks5AddressType IPv6 = new Socks5AddressType(4, "IPv6");

    public Socks5AddressType(int i) {
        this(i, Constants.APP_VERSION_UNKNOWN);
    }

    public static Socks5AddressType valueOf(byte b) {
        if (b != 1) {
            if (b != 3) {
                if (b != 4) {
                    return new Socks5AddressType(b);
                }
                return IPv6;
            }
            return DOMAIN;
        }
        return IPv4;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AddressType) && this.byteValue == ((Socks5AddressType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
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

    public Socks5AddressType(int i, String str) {
        if (str != null) {
            this.byteValue = (byte) i;
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5AddressType socks5AddressType) {
        return this.byteValue - socks5AddressType.byteValue;
    }
}
