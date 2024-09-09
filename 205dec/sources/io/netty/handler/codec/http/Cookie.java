package io.netty.handler.codec.http;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Cookie extends io.netty.handler.codec.http.cookie.Cookie {
    @Deprecated
    String comment();

    @Deprecated
    String commentUrl();

    @Deprecated
    String getComment();

    @Deprecated
    String getCommentUrl();

    @Deprecated
    String getDomain();

    @Deprecated
    long getMaxAge();

    @Deprecated
    String getName();

    @Deprecated
    String getPath();

    @Deprecated
    Set<Integer> getPorts();

    @Deprecated
    String getValue();

    @Deprecated
    int getVersion();

    @Deprecated
    boolean isDiscard();

    @Override // io.netty.handler.codec.http.cookie.Cookie
    @Deprecated
    long maxAge();

    @Deprecated
    Set<Integer> ports();

    @Deprecated
    void setComment(String str);

    @Deprecated
    void setCommentUrl(String str);

    @Deprecated
    void setDiscard(boolean z3);

    @Override // io.netty.handler.codec.http.cookie.Cookie
    @Deprecated
    void setMaxAge(long j4);

    @Deprecated
    void setPorts(Iterable<Integer> iterable);

    @Deprecated
    void setPorts(int... iArr);

    @Deprecated
    void setVersion(int i4);

    @Deprecated
    int version();
}
