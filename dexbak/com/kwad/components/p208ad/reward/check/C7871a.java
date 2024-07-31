package com.kwad.components.p208ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.check.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7871a {
    /* renamed from: a */
    public static void m32122a(@NonNull AdTemplate adTemplate, int i, long j, int i2, String str) {
        C9815b.m27670e(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i).setEnviType(0).setDataLoadInterval(j).setCode(i2).setErrorMsg(str).setCreativeId(C10483a.m25978J(C10487e.m25641dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m32121b(@NonNull AdTemplate adTemplate, int i) {
        C9815b.m27670e(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i).setEnviType(0).setCreativeId(C10483a.m25978J(C10487e.m25641dQ(adTemplate))).setAdTemplate(adTemplate));
    }
}
