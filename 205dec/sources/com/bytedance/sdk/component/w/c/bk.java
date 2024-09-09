package com.bytedance.sdk.component.w.c;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum bk {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String ux;

    bk(String str) {
        this.ux = str;
    }

    public static bk c(String str) throws IOException {
        bk bkVar = HTTP_1_0;
        if (str.equals(bkVar.ux)) {
            return bkVar;
        }
        bk bkVar2 = HTTP_1_1;
        if (str.equals(bkVar2.ux)) {
            return bkVar2;
        }
        bk bkVar3 = HTTP_2;
        if (str.equals(bkVar3.ux)) {
            return bkVar3;
        }
        bk bkVar4 = SPDY_3;
        if (str.equals(bkVar4.ux)) {
            return bkVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ux;
    }
}
