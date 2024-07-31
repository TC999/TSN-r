package com.kwad.components.core.p330s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.core.s.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8947j {
    /* renamed from: d */
    public static boolean m29549d(@NonNull AdTemplate adTemplate, boolean z) {
        if (!z && C10484b.m25704dj(C10487e.m25641dQ(adTemplate))) {
            return C10251d.m26558CD();
        }
        return false;
    }

    /* renamed from: e */
    public static void m29548e(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        C8615a.m30233a(new C8615a.C8616a(context).m30206am(true).m30198aq(adTemplate));
    }
}
