package com.iab.omid.library.mmadbridge.adsession.media;

import com.baidu.mobads.sdk.api.IAdInterListener;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum Position {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    
    private final String position;

    Position(String str) {
        this.position = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.position;
    }
}
