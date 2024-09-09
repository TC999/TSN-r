package com.iab.omid.library.mmadbridge.adsession;

import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum AdSessionContextType {
    HTML("html"),
    NATIVE(AMPSConstants.AdType.AD_TYPE_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}
