package io.netty.handler.codec.http;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultCookie extends io.netty.handler.codec.http.cookie.DefaultCookie implements Cookie {
    private String comment;
    private String commentUrl;
    private boolean discard;
    private Set<Integer> ports;
    private Set<Integer> unmodifiablePorts;
    private int version;

    public DefaultCookie(String str, String str2) {
        super(str, str2);
        Set<Integer> emptySet = Collections.emptySet();
        this.ports = emptySet;
        this.unmodifiablePorts = emptySet;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String comment() {
        return this.comment;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String commentUrl() {
        return this.commentUrl;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getComment() {
        return comment();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getCommentUrl() {
        return commentUrl();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getDomain() {
        return domain();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public long getMaxAge() {
        return maxAge();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getName() {
        return name();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getPath() {
        return path();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> getPorts() {
        return ports();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getValue() {
        return value();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int getVersion() {
        return version();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public boolean isDiscard() {
        return this.discard;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> ports() {
        if (this.unmodifiablePorts == null) {
            this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
        }
        return this.unmodifiablePorts;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setComment(String str) {
        this.comment = validateValue("comment", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setCommentUrl(String str) {
        this.commentUrl = validateValue("commentUrl", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setDiscard(boolean z3) {
        this.discard = z3;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(int... iArr) {
        if (iArr != null) {
            int[] iArr2 = (int[]) iArr.clone();
            if (iArr2.length == 0) {
                Set<Integer> emptySet = Collections.emptySet();
                this.ports = emptySet;
                this.unmodifiablePorts = emptySet;
                return;
            }
            TreeSet treeSet = new TreeSet();
            for (int i4 : iArr2) {
                if (i4 > 0 && i4 <= 65535) {
                    treeSet.add(Integer.valueOf(i4));
                } else {
                    throw new IllegalArgumentException("port out of range: " + i4);
                }
            }
            this.ports = treeSet;
            this.unmodifiablePorts = null;
            return;
        }
        throw new NullPointerException("ports");
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setVersion(int i4) {
        this.version = i4;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int version() {
        return this.version;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(Iterable<Integer> iterable) {
        TreeSet treeSet = new TreeSet();
        for (Integer num : iterable) {
            int intValue = num.intValue();
            if (intValue > 0 && intValue <= 65535) {
                treeSet.add(Integer.valueOf(intValue));
            } else {
                throw new IllegalArgumentException("port out of range: " + intValue);
            }
        }
        if (treeSet.isEmpty()) {
            Set<Integer> emptySet = Collections.emptySet();
            this.ports = emptySet;
            this.unmodifiablePorts = emptySet;
            return;
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }
}
