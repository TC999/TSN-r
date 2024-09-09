package com.iab.omid.library.mmadbridge.adsession;

import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum Owner {
    NATIVE(AMPSConstants.AdType.AD_TYPE_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String owner;

    Owner(String str) {
        this.owner = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.owner;
    }
}
