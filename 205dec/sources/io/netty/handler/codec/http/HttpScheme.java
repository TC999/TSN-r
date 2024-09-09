package io.netty.handler.codec.http;

import io.netty.util.AsciiString;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, "http");
    public static final HttpScheme HTTPS = new HttpScheme(443, "https");
    private final AsciiString name;
    private final int port;

    private HttpScheme(int i4, String str) {
        this.port = i4;
        this.name = new AsciiString(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof HttpScheme) {
            HttpScheme httpScheme = (HttpScheme) obj;
            return httpScheme.port() == this.port && httpScheme.name().equals(this.name);
        }
        return false;
    }

    public int hashCode() {
        return (this.port * 31) + this.name.hashCode();
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }
}
