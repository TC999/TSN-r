package io.netty.handler.codec.socksx.v5;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Socks5CommandType implements Comparable<Socks5CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5CommandType CONNECT = new Socks5CommandType(1, "CONNECT");
    public static final Socks5CommandType BIND = new Socks5CommandType(2, "BIND");
    public static final Socks5CommandType UDP_ASSOCIATE = new Socks5CommandType(3, "UDP_ASSOCIATE");

    public Socks5CommandType(int i4) {
        this(i4, "UNKNOWN");
    }

    public static Socks5CommandType valueOf(byte b4) {
        if (b4 != 1) {
            if (b4 != 2) {
                if (b4 != 3) {
                    return new Socks5CommandType(b4);
                }
                return UDP_ASSOCIATE;
            }
            return BIND;
        }
        return CONNECT;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5CommandType) && this.byteValue == ((Socks5CommandType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str == null) {
            String str2 = this.name + '(' + (this.byteValue & 255) + ')';
            this.text = str2;
            return str2;
        }
        return str;
    }

    public Socks5CommandType(int i4, String str) {
        if (str != null) {
            this.byteValue = (byte) i4;
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5CommandType socks5CommandType) {
        return this.byteValue - socks5CommandType.byteValue;
    }
}
