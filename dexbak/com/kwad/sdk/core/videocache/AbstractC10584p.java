package com.kwad.sdk.core.videocache;

/* renamed from: com.kwad.sdk.core.videocache.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10584p implements InterfaceC10581m {
    protected volatile String aCy;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    /* renamed from: Gy */
    public abstract String mo25393Gy();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aCy + "'}";
    }
}
