package com.kwad.components.core.i;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private Object Me;
    private AdTemplate Mf;

    public c(@NonNull AdTemplate adTemplate, int i4) {
        this.Me = null;
        try {
            this.Me = new b(adTemplate, i4);
        } catch (Throwable unused) {
            this.Mf = adTemplate;
        }
    }

    public static List<AdTemplate> m(List<c> list) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            arrayList.add(cVar.getAdTemplate());
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
            java.lang.Object r0 = r1.Me
            if (r0 == 0) goto Lb
            com.kwad.components.core.i.b r0 = (com.kwad.components.core.i.b) r0     // Catch: java.lang.Exception -> Lb
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L10
            com.kwad.sdk.core.response.model.AdTemplate r0 = r1.Mf
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.i.c.getAdTemplate():com.kwad.sdk.core.response.model.AdTemplate");
    }

    public final Object getHost() {
        return this.Me;
    }
}
