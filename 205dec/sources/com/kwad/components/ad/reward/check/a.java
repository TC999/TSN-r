package com.kwad.components.ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void a(@NonNull AdTemplate adTemplate, int i4, long j4, int i5, String str) {
        b.e(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i4).setEnviType(0).setDataLoadInterval(j4).setCode(i5).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i4) {
        b.e(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i4).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }
}
