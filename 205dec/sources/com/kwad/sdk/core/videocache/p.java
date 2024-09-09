package com.kwad.sdk.core.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class p implements m {
    protected volatile String aCy;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Gy();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aCy + "'}";
    }
}
