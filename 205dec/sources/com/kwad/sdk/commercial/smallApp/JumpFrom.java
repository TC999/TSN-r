package com.kwad.sdk.commercial.smallApp;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public enum JumpFrom {
    H5("h5"),
    AD_PAGE("ad_page");
    
    private final String value;

    JumpFrom(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
