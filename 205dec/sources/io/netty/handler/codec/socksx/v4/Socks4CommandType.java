package io.netty.handler.codec.socksx.v4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public Socks4CommandType(int i4) {
        this(i4, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b4) {
        if (b4 != 1) {
            if (b4 != 2) {
                return new Socks4CommandType(b4);
            }
            return BIND;
        }
        return CONNECT;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
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

    public Socks4CommandType(int i4, String str) {
        if (str != null) {
            this.byteValue = (byte) i4;
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }
}
