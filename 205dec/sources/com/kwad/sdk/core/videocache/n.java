package com.kwad.sdk.core.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n {
    public final long aCx;
    public final String aCy;
    public final String url;

    public n(String str, long j4, String str2) {
        this.url = str;
        this.aCx = j4;
        this.aCy = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aCx + ", mime='" + this.aCy + "'}";
    }
}
