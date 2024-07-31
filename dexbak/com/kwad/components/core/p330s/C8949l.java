package com.kwad.components.core.p330s;

import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.api.loader.Loader;

/* renamed from: com.kwad.components.core.s.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8949l {
    /* renamed from: c */
    public static void m29542c(Intent intent) {
        if (intent == null) {
            return;
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        Bundle extras = intent.getExtras();
        if (externalClassLoader == null || extras == null) {
            return;
        }
        extras.setClassLoader(externalClassLoader);
    }
}
