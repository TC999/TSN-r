package io.netty.handler.codec.http.cookie;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Cookie extends Comparable<Cookie> {
    String domain();

    boolean isHttpOnly();

    boolean isSecure();

    long maxAge();

    String name();

    String path();

    void setDomain(String str);

    void setHttpOnly(boolean z3);

    void setMaxAge(long j4);

    void setPath(String str);

    void setSecure(boolean z3);

    void setValue(String str);

    void setWrap(boolean z3);

    String value();

    boolean wrap();
}
