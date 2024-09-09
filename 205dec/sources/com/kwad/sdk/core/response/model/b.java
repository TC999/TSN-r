package com.kwad.sdk.core.response.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private boolean UD = true;
    private boolean aAb;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public b(String str, int i4, int i5, boolean z3, boolean z4) {
        this.mUrl = str;
        this.mWidth = i4;
        this.mHeight = i5;
        this.aAb = z4;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
