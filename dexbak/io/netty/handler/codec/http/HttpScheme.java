package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, IDataSource.f43971a);
    public static final HttpScheme HTTPS = new HttpScheme(443, "https");
    private final AsciiString name;
    private final int port;

    private HttpScheme(int i, String str) {
        this.port = i;
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
