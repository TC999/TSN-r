package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    public static boolean cQ(String str) {
        DevelopMangerComponents.DevelopValue cP = c.cP(str);
        return cP != null && ((Boolean) cP.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return cQ("KEY_HOST_ENCRYPT_DISABLE");
    }
}
