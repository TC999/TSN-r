package com.iab.omid.library.mmadbridge.adsession;

import com.baidu.mobads.sdk.internal.C2573a;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum AdSessionContextType {
    HTML(C2573a.f8447f),
    NATIVE("native"),
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
