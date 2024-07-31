package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* renamed from: com.kwad.sdk.components.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9865f {
    /* renamed from: cQ */
    public static boolean m27498cQ(String str) {
        DevelopMangerComponents.DevelopValue m27502cP = C9861c.m27502cP(str);
        return m27502cP != null && ((Boolean) m27502cP.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return m27498cQ("KEY_HOST_ENCRYPT_DISABLE");
    }
}
