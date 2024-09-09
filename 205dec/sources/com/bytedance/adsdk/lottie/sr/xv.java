package com.bytedance.adsdk.lottie.sr;

import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum xv {
    JSON(".json"),
    ZIP(".zip");
    
    public final String xv;

    xv(String str) {
        this.xv = str;
    }

    public String c() {
        return ".temp" + this.xv;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.xv;
    }
}
