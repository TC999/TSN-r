package com.iab.omid.library.mmadbridge.adsession;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum ErrorType {
    GENERIC("generic"),
    VIDEO("video");
    
    private final String errorType;

    ErrorType(String str) {
        this.errorType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.errorType;
    }
}