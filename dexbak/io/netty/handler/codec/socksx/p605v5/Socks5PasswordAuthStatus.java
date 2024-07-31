package io.netty.handler.codec.socksx.p605v5;

import com.tencent.connect.common.Constants;
import kotlin.UByte;

/* renamed from: io.netty.handler.codec.socksx.v5.Socks5PasswordAuthStatus */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Socks5PasswordAuthStatus implements Comparable<Socks5PasswordAuthStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, "SUCCESS");
    public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");

    public Socks5PasswordAuthStatus(int i) {
        this(i, Constants.APP_VERSION_UNKNOWN);
    }

    public static Socks5PasswordAuthStatus valueOf(byte b) {
        if (b != -1) {
            if (b != 0) {
                return new Socks5PasswordAuthStatus(b);
            }
            return SUCCESS;
        }
        return FAILURE;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5PasswordAuthStatus) && this.byteValue == ((Socks5PasswordAuthStatus) obj).byteValue;
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

    public Socks5PasswordAuthStatus(int i, String str) {
        if (str != null) {
            this.byteValue = (byte) i;
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        return this.byteValue - socks5PasswordAuthStatus.byteValue;
    }
}
