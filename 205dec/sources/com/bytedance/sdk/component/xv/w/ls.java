package com.bytedance.sdk.component.xv.w;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum ls {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String ux;

    ls(String str) {
        this.ux = str;
    }

    public static ls c(String str) throws IOException {
        ls lsVar = HTTP_1_0;
        if (str.equals(lsVar.ux)) {
            return lsVar;
        }
        ls lsVar2 = HTTP_1_1;
        if (str.equals(lsVar2.ux)) {
            return lsVar2;
        }
        ls lsVar3 = HTTP_2;
        if (str.equals(lsVar3.ux)) {
            return lsVar3;
        }
        ls lsVar4 = SPDY_3;
        if (str.equals(lsVar4.ux)) {
            return lsVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ux;
    }
}
