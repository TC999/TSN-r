package com.kwad.components.core.p298i;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.i.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8674c {

    /* renamed from: Me */
    private Object f28343Me;

    /* renamed from: Mf */
    private AdTemplate f28344Mf;

    public C8674c(@NonNull AdTemplate adTemplate, int i) {
        this.f28343Me = null;
        try {
            this.f28343Me = new C8673b(adTemplate, i);
        } catch (Throwable unused) {
            this.f28344Mf = adTemplate;
        }
    }

    /* renamed from: m */
    public static List<AdTemplate> m30037m(List<C8674c> list) {
        ArrayList arrayList = new ArrayList();
        for (C8674c c8674c : list) {
            arrayList.add(c8674c.getAdTemplate());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kwad.sdk.core.response.model.AdTemplate getAdTemplate() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.f28343Me
            if (r0 == 0) goto Lb
            com.kwad.components.core.i.b r0 = (com.kwad.components.core.p298i.C8673b) r0     // Catch: java.lang.Exception -> Lb
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L10
            com.kwad.sdk.core.response.model.AdTemplate r0 = r1.f28344Mf
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.p298i.C8674c.getAdTemplate():com.kwad.sdk.core.response.model.AdTemplate");
    }

    public final Object getHost() {
        return this.f28343Me;
    }
}
